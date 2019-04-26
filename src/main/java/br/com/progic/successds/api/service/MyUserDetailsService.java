package br.com.progic.successds.api.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import br.com.progic.successds.api.repository.UsuarioRepository;
import br.com.progic.successds.model.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@Autowired
    private UsuarioRepository usuarioRepository;
    
    public MyUserDetailsService() {
    	super();
    }
 
	@PostConstruct
    public void completeSetup() {
		usuarioRepository = applicationContext.getBean(UsuarioRepository.class);
    }
	
	 @Override
    public User loadUserByUsername(String usuario) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        if (user == null) {
            throw new UsernameNotFoundException(usuario);
        }
        Collection<SimpleGrantedAuthority> listGrants = new ArrayList<>();
        listGrants.add(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getUsuario(),user.getSenha(),listGrants);
    }
	
}
