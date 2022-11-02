package com.api.rest.serviceImp;

import com.api.rest.model.Usuario;
import com.api.rest.repository.IUsuarioRepository;
import com.api.rest.service.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(UsuarioService.class);

    private  IUsuarioRepository usuarioRepository;
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository= usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= usuarioRepository.findByUsername(username);
        if(usuario==null){
            logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
            throw  new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"'" +
                    " en el sistema!");
        }
        List<GrantedAuthority> authorities = usuario.getRoles()
                .stream()
                .map(role->new SimpleGrantedAuthority(role.getName()))
                .peek(authority -> logger.info("Role: "+authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true,
                true, true, authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
