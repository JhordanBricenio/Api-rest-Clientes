package com.api.rest.repository;

import com.api.rest.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
