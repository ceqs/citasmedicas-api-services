package pe.edu.utp.soa.citasmedicas.dao.api;

import org.springframework.data.repository.CrudRepository;
import pe.edu.utp.soa.citasmedicas.model.Medico;

import java.util.List;

public interface MedicoDaoAPI extends CrudRepository<Medico, Integer> {

    List<Medico> findByEspecialidadId(Integer idEspecialidad);
}
