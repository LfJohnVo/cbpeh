package mx.gob.cbpeh.bpd.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.gob.cbpeh.bpd.modelo.*;

@Repository("usuarioRepositorio")
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByIdUsuarioAndCatEstatus(String idUsuario,CatEstatus estatus);
	
	public Usuario findByIdUsuario(String idUsuario);

}
