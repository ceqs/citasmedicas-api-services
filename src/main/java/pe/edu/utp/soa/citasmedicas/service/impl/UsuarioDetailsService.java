package pe.edu.utp.soa.citasmedicas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.utp.soa.citasmedicas.dao.api.UsuarioDaoAPI;
import pe.edu.utp.soa.citasmedicas.model.Usuario;

import java.util.HashSet;
import java.util.Set;

@Service("usuarioDetailsService")
public class UsuarioDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioDaoAPI usuarioDaoAPI;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDaoAPI.findByUsuario(username);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRol().getId()));
		return new User(username, usuario.getPassword(), authorities);
	}

}
