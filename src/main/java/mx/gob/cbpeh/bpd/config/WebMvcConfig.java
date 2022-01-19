package mx.gob.cbpeh.bpd.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "mx.gob.cbpeh.bpd.controlador" })
public class WebMvcConfig implements WebMvcConfigurer {

	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		ResourceBundleViewResolver viewResolver2 = new ResourceBundleViewResolver();
		viewResolver2.setOrder(1);
		viewResolver2.setBasename("vistas");
		registry.viewResolver(viewResolver2);

		InternalResourceViewResolver viewResolver1 = new InternalResourceViewResolver();
		viewResolver1.setViewClass(JstlView.class);
		viewResolver1.setPrefix("vistas/");
		viewResolver1.setSuffix(".jsp");
		viewResolver1.setOrder(2);
		registry.viewResolver(viewResolver1);
	}
	
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}
	
   	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/recursos/**").addResourceLocations("/recursos/");
	
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20000000); //5MB
	    return multipartResolver;
	}
	

	
	}
