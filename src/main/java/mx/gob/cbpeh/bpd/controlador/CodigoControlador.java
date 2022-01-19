package mx.gob.cbpeh.bpd.controlador;

import org.jboss.aerogear.security.otp.Totp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.gob.cbpeh.bpd.exceptions.VerificacionCodigoException;
import mx.gob.cbpeh.bpd.repositorio.UsuarioRepositorio;
import mx.gob.cbpeh.bpd.servicio.UsuarioDetallesAdapter;
import mx.gob.cbpeh.bpd.util.Utils;

@Controller
@RequestMapping("/code")
public class CodigoControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @RequestMapping(method = RequestMethod.GET)
    public String showCodeForm() {
        return "code";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String verifyCode(String code) {
        try {
            UsuarioDetallesAdapter userDetailsAdapter = (UsuarioDetallesAdapter) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Totp totp = new Totp(userDetailsAdapter.getUsuario().getLlaveSecreta());
            if (!isValidLong(code) || !totp.verify(code)) {
                throw new VerificacionCodigoException("invalid key");
            }

           
            String pathContexto = "/";
            
            for (GrantedAuthority grantedAuthority : userDetailsAdapter.getAuthorities()) {
            	
            	System.out.print("Controlador TIPO ROL : "+grantedAuthority.getAuthority());
                if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                	pathContexto = "redirect:/admin";
                    break;
                } else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR_1")) {
                	pathContexto = "redirect:/atencionciudadana";
                    break;
                } else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR_2")) {
                	pathContexto = "redirect:/accionesbusqueda";
                    break;
                }else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR_3")) {
                	pathContexto = "redirect:/analisiscontexto";
                    break;
                }else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR")) {
                	pathContexto = "redirect:/gerencia";
                    break;
                } else  throw new IllegalStateException();
                
            }
            
          // Utils.setAuthentication();
            return pathContexto;
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (VerificacionCodigoException e) {
            e.printStackTrace();
        }
        return "redirect:/code?error=1";
    }

    private boolean isValidLong(String code) {
        try {
            Long.parseLong(code);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
