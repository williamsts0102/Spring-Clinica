package net.clinica.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.clinica.entity.Usuario;
import net.clinica.services.UsuarioServices;

@Service
public class UserSecurity implements UserDetailsService{
	@Autowired
	private UsuarioServices servicio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails datos=null;
		//invocar al método validarSesion
		Usuario bean=servicio.validarSesion(username);
		//rol del usuario
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		//adicionar rol del usuario
		rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
		//crear objeto datos
		datos=new User(username,bean.getClave(),rol);
		
		return datos;
	}

}
