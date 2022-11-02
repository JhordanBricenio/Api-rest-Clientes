package com.api.rest.service;

import com.api.rest.model.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);
}
