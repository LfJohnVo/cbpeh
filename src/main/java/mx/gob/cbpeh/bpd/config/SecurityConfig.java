package mx.gob.cbpeh.bpd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import mx.gob.cbpeh.bpd.handler.SegundoFactorAutentificacionHandler;
import mx.gob.cbpeh.bpd.servicio.UsuarioDetallesServicio;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "mx.gob.cbpeh.bpd.controlador" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
	 @Override
	    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	        // authentication manager (see below)
		 
		/* auth.inMemoryAuthentication()
		 .withUser("admin1").password("{noop}135").roles("ADMIN")
	        .and()
	      .withUser("user1").password("{noop}1234").roles("SUPERVISOR_1")
	      .and()
	      .withUser("user2").password("{noop}1234").roles("SUPERVISOR_2")
	      .and()
	      .withUser("user3").password("{noop}1234").roles("SUPERVISOR_3");*/
		 //Con base de datos
		  auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		  
		
	    }
	 
	 @Bean
	  public UserDetailsService userDetailsService() {
		 System.out.println("Entra en userDetailsService");
		LOG.info("Entra en userDetailsService");		 
	    return new UsuarioDetallesServicio(); 
	  };
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  };
	  
	  @Autowired
	    private AuthenticationSuccessHandler authenticationSuccessHandler;
     
	  
	  @Bean
	    public AuthenticationSuccessHandler authenticationSuccessHandler() {
	        return new SegundoFactorAutentificacionHandler();
	    }    
	

	    @Override
	    protected void configure(final HttpSecurity http) throws Exception {
	        // http builder configurations for authorize requests and form login (see below)
	    	
	    	
	    	
	    	http
	        .csrf().disable()
	        //.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class)
	        .authorizeRequests()
	        .antMatchers("/","/login").permitAll()
	        .antMatchers("/recursos/**").permitAll()
	        .antMatchers("/consultaexterna/**").permitAll()
            .antMatchers("/code").hasAnyRole("ADMIN","SUPERVISOR_3","SUPERVISOR_2","SUPERVISOR_1","SUPERVISOR")
	        .antMatchers("/admin/**").hasRole("ADMIN")
	        .antMatchers("/atencionciudadana").hasAnyRole("SUPERVISOR_1","SUPERVISOR")
	        //.antMatchers("/atencionciudadana/**").hasAnyRole("SUPERVISOR_1","SUPERVISOR")
	        .antMatchers("/accionesbusqueda/**").hasAnyRole("SUPERVISOR_2","SUPERVISOR")
	        .antMatchers("/analisiscontexto/acciones/busqueda-atenta-notas",
	        		     "/analisiscontexto/acciones/guardar-atentas-notas",
	        		     "/analisiscontexto/acciones/obtener-direccion-puesto",
	        		     "/analisiscontexto/acciones/busqueda-atenta-notas-area").hasAnyRole("SUPERVISOR_3","SUPERVISOR_2","SUPERVISOR_1","SUPERVISOR")
	        .antMatchers("/analisiscontexto/**").hasAnyRole("SUPERVISOR_3","SUPERVISOR")
	        .antMatchers("/**/refrescar-expedientes").hasAnyRole("SUPERVISOR_1","SUPERVISOR_2","SUPERVISOR","SUPERVISOR_3")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .loginPage("/login")
	        .successHandler(authenticationSuccessHandler)
             .failureUrl("/login?error=0")
	        //.failureHandler(authenticationFailureHandler())
	        .and()
	        .exceptionHandling()
	          .accessDeniedPage("/access-denied")
	        .and()
	        .logout()
	         .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) 
	        .deleteCookies("JSESSIONID");
	        //.logoutSuccessHandler(logoutSuccessHandler());
	        
	    	

	    }     
  
	    
}