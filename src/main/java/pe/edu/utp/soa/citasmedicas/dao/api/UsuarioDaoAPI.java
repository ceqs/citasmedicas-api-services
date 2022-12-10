package pe.edu.utp.soa.citasmedicas.dao.api;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.soa.citasmedicas.model.Usuario;

public interface UsuarioDaoAPI extends CrudRepository<Usuario, String> {

	Usuario findByUsuario(String usuario);
}
