package mx.gob.cbpeh.bpd.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import mx.gob.cbpeh.bpd.exceptions.ResourceNotFoundException;
import mx.gob.cbpeh.bpd.modelo.Comunicado;
import mx.gob.cbpeh.bpd.servicio.ComunicadoServicio;
import mx.gob.cbpeh.bpd.servicio.UsuarioDetallesAdapter;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Utils {
	
	public Utils() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private ComunicadoServicio comunicadoServicio;
	
	public byte[] getImagen(int idComunicado) throws ResourceNotFoundException {

		Comunicado comunicado = comunicadoServicio.getComunicado(idComunicado);
	
		return comunicado.getImagen()  ;
	}
	
	public void setImagen(int idComunicado) throws ResourceNotFoundException {
      
    	  try {
    	  System.out.println("Id  "+  idComunicado);
    	  Comunicado comunicado = new Comunicado();
    	  String validar  = ( comunicadoServicio.getComunicado(idComunicado)==null?"vacio":"Con datos");
    		
 		 System.out.println("Imagen "+  validar);
		
    	  }catch (Exception e) {
    		  System.err.println("ERROR "+  e);
		}
		
	}
	
	public void comprimirImagen (File input) {

        try {

            //File input = new File("C:/Users/efrain.nataren/Evidencia3.png");
            File output = new File("C:/Users/efrain.nataren/Evidencia3-to-jpg.jpg");

            BufferedImage image = ImageIO.read(input);
            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(result, "jpg", output);

        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	public static void setAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioDetallesAdapter userDetailsAdapter = (UsuarioDetallesAdapter) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userDetailsAdapter.getUsuario().getPerfil().getRole());

        Authentication newAuth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }

	public String getIniciales(String nombres, String aPaterno, String aMaterno) {
		String iniciales="";
		
		iniciales = getInicialesMayor3(nombres);
		if(null!= aPaterno && !aPaterno.equals("")) {
			iniciales = iniciales+getInicialesMayor3(aPaterno);
		}
		if(null!= aMaterno && !aMaterno.equals("")) {
			iniciales = iniciales+getInicialesMayor3(aMaterno);
		}		
		return iniciales.toUpperCase();
	}
	
	public String getInicialesMayor3(String cad) {
		String inicial="";
		StringTokenizer stPalabras = new StringTokenizer(cad);
		while (stPalabras.hasMoreTokens()) {
			  String strPalabra = stPalabras.nextToken();
			  if(strPalabra.length()>3) {
				  inicial =inicial+strPalabra.charAt(0);
				  //sPalabra.substring(0,1)				  
			  }
			}
		return inicial;
	}
	
	 public static String convertToJSON(Object object)
	    {
	        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	        String json;
	        try {
	            json = ow.writeValueAsString(object);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	            return convertToJSON(e);
	        }
	        return json;
	    }


	    public static <T> T convertToObject(Class<T> clazz,String jsonString)
	    {
	        try {
	        ObjectMapper mapper = new ObjectMapper();
	        return (T)mapper.readValue(jsonString, clazz);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
		public static String dateToString(Date fecha, String format) {
			String formatted = "";
			if (format != null && !format.equals("")) {
				SimpleDateFormat format1 = new SimpleDateFormat(format);
				// formatted = format1.format(DateUtils.addMinutes(cal.getTime(),
				// 18)); //en desarrollo el tiempo esta mal por 18 minutos aprox
				formatted = format1.format(fecha);
			}
			return formatted;
		}
	
}
