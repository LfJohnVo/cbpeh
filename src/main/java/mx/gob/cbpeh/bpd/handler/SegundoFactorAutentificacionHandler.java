package mx.gob.cbpeh.bpd.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import mx.gob.cbpeh.bpd.servicio.UsuarioDetallesAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SegundoFactorAutentificacionHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	 
	    @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
	        handle(request, response, authentication);
	        clearAuthenticationAttributes(request);
	    }
	 
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
	          String targetUrl = getTargetUrl(authentication);
	 
	        if (response.isCommitted()) {
	            return;
	        }
	 
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }
	 
	    protected String getTargetUrl(Authentication authentication) {
	        UsuarioDetallesAdapter userDetailsAdapter = (UsuarioDetallesAdapter) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	       
	        System.out.println("Entra en getUsuario : "+userDetailsAdapter.getUsuario());
	        if (userDetailsAdapter.getUsuario().getAplica2fa()) {
	        	
	        	 System.out.println("Entra en IF");
	            return "/code";
	        } else {
	           
	            System.out.println("Entra else");
	           
                String pathContexto = "/";
                
                for (GrantedAuthority grantedAuthority : userDetailsAdapter.getAuthorities()) {
                	
                	System.out.print("TIPO ROL : "+grantedAuthority.getAuthority());
                    if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                    	pathContexto =  "/admin";
                       // break;
                    } else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR_1")) {
                    	pathContexto = "/atencionciudadana";
                     //   break;
                    } else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR_2")) {
                    	pathContexto = "/accionesbusqueda";
                      //  break;
                    }else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR_3")) {
                    	pathContexto = "/analisiscontexto";
                      //  break;
                    }else if (grantedAuthority.getAuthority().equals("ROLE_SUPERVISOR")) {
                    	pathContexto = "/gerencia";
                        //  break;
                    } else  throw new IllegalStateException();
                }
              // Utils.setAuthentication();
	            return pathContexto;
	        }
	    }
	 
	    protected void clearAuthenticationAttributes(HttpServletRequest request) {
	        HttpSession session = request.getSession(false);
	        if (session == null) {
	            return;
	        }
	        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	    }
	 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }
	}
