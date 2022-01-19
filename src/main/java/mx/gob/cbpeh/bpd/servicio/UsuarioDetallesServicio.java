package mx.gob.cbpeh.bpd.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import mx.gob.cbpeh.bpd.modelo.CatEstatus;
import mx.gob.cbpeh.bpd.modelo.Usuario;
import mx.gob.cbpeh.bpd.repositorio.UsuarioRepositorio;

@Component
@Service
	public class UsuarioDetallesServicio implements UserDetailsService {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioDetallesServicio.class);

	    @Autowired
	    private UsuarioRepositorio userRepository;
	    
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	      /*Here we are using dummy data, you need to load user data from
	       database or other third party application*/
	    	CatEstatus catEstatus = new CatEstatus();
	    	catEstatus.setIdEstatus(1);
	    	Usuario user = userRepository.findByIdUsuarioAndCatEstatus(username,catEstatus);
	      //Usuario user = userRepository.findByIdUsuario(username);
	      //Estatico Usuario user = findUserbyUername(username);
          System.out.println("Entra en loadUserByUsername");
	      
	      
	      if (user == null) {
	    	
	    	  System.out.println("Error en loadUserByUsername");
	            throw new UsernameNotFoundException(username);
	        }
	      LOG.info("loadUserByUsername buscar usuario"+user.getIdUsuario());
	      System.out.println("Entra en loadUserByUsername"+user.getIdUsuario());
	        return new UsuarioDetallesAdapter(user);
	    }
	      
	     /* UserBuilder builder = null;
	     // if (user != null) {
	   ///  builder = org.springframework.security.core.userdetails.User.withUsername(username);
	        builder.password(new BCryptPasswordEncoder().encode(user.getContrasenia()));
	        builder.roles(user.getPerfil().getRole());
	      } else {
	        throw new UsernameNotFoundException("El usuario no existe.");
	      }

	      return builder.build();
	    }*/
       
	    //Estatico
	   /* private Usuario findUserbyUername(String username) {
	      if(username.equalsIgnoreCase("admin")) {
	        return new Usuario(username, "admin123", "ADMIN");
	      }
	      return null;
	    }*/

	  
	}
