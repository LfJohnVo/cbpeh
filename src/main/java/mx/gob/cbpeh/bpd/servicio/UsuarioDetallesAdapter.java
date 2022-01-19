package mx.gob.cbpeh.bpd.servicio;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mx.gob.cbpeh.bpd.modelo.Usuario;

import java.util.Collection;


public class UsuarioDetallesAdapter implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

    public UsuarioDetallesAdapter(Usuario account) {
        this.usuario = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ROLE_"+usuario.getPerfil().getRole());
    }
    

    @Override
    public String getUsername() {
        return usuario.getIdUsuario();
    }

    @Override
    public String getPassword() {
        return new BCryptPasswordEncoder().encode(usuario.getContrasenia());
    }
    
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
