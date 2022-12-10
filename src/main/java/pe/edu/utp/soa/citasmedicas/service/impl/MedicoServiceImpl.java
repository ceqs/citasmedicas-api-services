package pe.edu.utp.soa.citasmedicas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pe.edu.utp.soa.citasmedicas.dao.api.MedicoDaoAPI;
import pe.edu.utp.soa.citasmedicas.model.Medico;
import pe.edu.utp.soa.citasmedicas.service.api.MedicoServiceAPI;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceImpl;

import java.util.List;

@Service
public class MedicoServiceImpl extends GenericServiceImpl<Medico, Integer> implements MedicoServiceAPI {

	@Autowired
	private MedicoDaoAPI medicoDaoAPI;
	
	@Override
	public CrudRepository<Medico, Integer> getDao() {
		return medicoDaoAPI;
	}

	@Override
	public List<Medico> searchByEspecialidad(Integer idEspecialidad) {
		return medicoDaoAPI.findByEspecialidadId(idEspecialidad);
	}
}
