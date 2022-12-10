package pe.edu.utp.soa.citasmedicas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pe.edu.utp.soa.citasmedicas.dao.api.RolDaoAPI;
import pe.edu.utp.soa.citasmedicas.service.api.RolServiceAPI;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceImpl;
import pe.edu.utp.soa.citasmedicas.model.Rol;

@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, String> implements RolServiceAPI {

	@Autowired
	private RolDaoAPI rolDaoAPI;
	
	@Override
	public CrudRepository<Rol, String> getDao() {
		return rolDaoAPI;
	}

}
