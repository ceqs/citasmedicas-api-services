package pe.edu.utp.soa.citasmedicas.dao.api;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.soa.citasmedicas.model.Paciente;

public interface PacienteDaoAPI extends CrudRepository<Paciente, Integer> {
    Paciente findByUsuarioUsuario(String usuario);
}
