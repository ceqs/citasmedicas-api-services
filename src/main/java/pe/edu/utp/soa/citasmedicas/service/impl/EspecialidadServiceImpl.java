package pe.edu.utp.soa.citasmedicas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceImpl;
import pe.edu.utp.soa.citasmedicas.dao.api.EspecialidadDaoAPI;
import pe.edu.utp.soa.citasmedicas.model.Especialidad;
import pe.edu.utp.soa.citasmedicas.service.api.EspecialidadServiceAPI;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<Especialidad, Integer> implements EspecialidadServiceAPI {

	@Autowired
	private EspecialidadDaoAPI especialidadDaoAPI;
	
	@Override
	public CrudRepository<Especialidad, Integer> getDao() {
		return especialidadDaoAPI;
	}

}
