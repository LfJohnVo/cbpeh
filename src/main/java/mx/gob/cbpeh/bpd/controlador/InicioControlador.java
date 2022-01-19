package mx.gob.cbpeh.bpd.controlador;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.gob.cbpeh.bpd.dto.Comunicado2;
import mx.gob.cbpeh.bpd.dto.ComunicadosDto;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.CatTipoComunicado;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.servicio.ComunicadoServicio;


@Controller
public class InicioControlador {
	
	@Autowired
	private ComunicadoServicio comunicadoServicio;
	
	 private static final Logger LOG = LoggerFactory.getLogger(InicioControlador.class);
	
	 @RequestMapping(value = "/username", method = RequestMethod.GET)
	    @ResponseBody
	    public String currentUserNameSimple(HttpServletRequest request) {
	        Principal principal = request.getUserPrincipal();
	        return principal.getName();
	    }
	 
	/**Metodo para la pagina de incio de la aplicacion
	 * @throws ResourceNotFoundException 
	 * @throws JsonProcessingException **/
	@RequestMapping(value = { "/","/inicio" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() throws ResourceNotFoundException, JsonProcessingException {
		
		
		
		ModelAndView model = new ModelAndView("inicio");
		CatTipoComunicado catTipoComunicado = new CatTipoComunicado();
		  catTipoComunicado.setIdTipoComunicado(1);
		 ComunicadosDto comunicadosDto = new ComunicadosDto();
		 List<Comunicado> comunicados = comunicadoServicio.getComunicados(catTipoComunicado);
		 
		 for(Comunicado comunicado2: comunicados) {
			 
			Comunicado2 comunicado22 = new Comunicado2();
			            comunicado22.setIdComunicado(comunicado2.getIdComunicado());
			            comunicado22.setTitulo(comunicado2.getTitulo());
			            comunicado22.setDescripcion(comunicado2.getDescripcion());
			            comunicado22.setUrl(comunicado2.getUrl());
			            comunicado22.setImagen(comunicado2.getImagen());
			            comunicado22.setImagenDetalle(comunicado2.getImagen().toString());
			            
			            comunicadosDto.getComunicados().add(comunicado22);
			}
				   
		  //Object mapper instance
		  ObjectMapper mapper = new ObjectMapper();
		   
		  //Convert POJO to JSON
		  String json = mapper.writeValueAsString(comunicadosDto);
		  
		 // model.addObject("comunicadosCarrusel", comunicado.getComunicados());
		  model.addObject("json", json);
		 
		
		return model;

	}
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public ModelAndView login() {
		
		System.out.println("Entra en defaultPage LOGIN GET");
		
		ModelAndView model = new ModelAndView("login");
		return model;

	}
	@RequestMapping(value = "/access-denied" , method = RequestMethod.GET)
	public ModelAndView errorAcceso() {
		
		System.out.println("Entra en defaultPage LOGIN GET");
		
		ModelAndView model = new ModelAndView("error403");		
		
		return model;

	}
	
	 @ExceptionHandler(NoHandlerFoundException.class)
	    public ModelAndView handle(Exception ex) {

		 ModelAndView mv = new ModelAndView();
	        mv.addObject("message", ex.getMessage());
	        mv.setViewName("error404");

	        return mv;
	    }
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public ModelAndView login2() {
		
		System.out.println("Entra en defaultPage LOGIN2 POST");
		
		ModelAndView model = new ModelAndView("login");
		
		
		return model;

	}
	/*
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String loginPage(@RequestParam(value = "error", required = false) String error, 
	                            @RequestParam(value = "logout", required = false) String logout,
	                            Model model) {
		 
			LOG.info("Entra en loginPage");
	        String errorMessge = null;
	        if(error != null) {
	            errorMessge = "Username or Password is incorrect !!";
	        }
	        if(logout != null) {
	            errorMessge = "You have been successfully logged out !!";
	        }
	        model.addAttribute("errorMessge", errorMessge);
	        return "login";
	    }
	 
	 */ 
				@RequestMapping(value = "/consultaexterna/obtener-comunicado", method = RequestMethod.GET,produces = "application/json")
	    public ResponseEntity<ComunicadosDto> getComunicados(@RequestParam ("idComunicado") Integer idComunicado) {

		 ComunicadosDto comunicadoDto = new ComunicadosDto();
		
		 try {
			
			 Comunicado comunicado = comunicadoServicio.getComunicado(idComunicado);
			  
			 if(comunicado.equals(null))
			 { 
				 comunicadoDto.setEstatus(-1);
				 comunicadoDto.setDescripcion("Se genero un error al cargar la imagen");
			    return new ResponseEntity<>(comunicadoDto, HttpStatus.OK);
					
				 
			 }
			 
			 //comunicadoDto.setComunicado(comunicado);
			 comunicadoDto.setEstatus(1);
			 comunicadoDto.setDescripcion("OK");
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
			return new ResponseEntity<>(comunicadoDto, HttpStatus.OK);
	    }

	 
	      
	    @RequestMapping(value="/logout", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/";  
	     }  

}
