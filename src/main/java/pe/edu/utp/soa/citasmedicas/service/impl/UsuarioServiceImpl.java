package pe.edu.utp.soa.citasmedicas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import pe.edu.utp.soa.citasmedicas.commons.GenericServiceImpl;
import pe.edu.utp.soa.citasmedicas.dao.api.UsuarioDaoAPI;
import pe.edu.utp.soa.citasmedicas.model.Usuario;
import pe.edu.utp.soa.citasmedicas.service.api.UsuarioServiceAPI;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, String> implements UsuarioServiceAPI {

	@Autowired
	private UsuarioDaoAPI usuarioDaoAPI;
	
	@Override
	public CrudRepository<Usuario, String> getDao() {
		return usuarioDaoAPI;
	}

}
