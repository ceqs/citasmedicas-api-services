package pe.edu.utp.soa.citasmedicas.service.api;

import pe.edu.utp.soa.citasmedicas.commons.GenericServiceAPI;
import pe.edu.utp.soa.citasmedicas.model.Medico;

import java.util.List;

public interface MedicoServiceAPI extends GenericServiceAPI<Medico, Integer> {
	List<Medico> searchByEspecialidad(Integer idEspecialidad);
}
