package com.api.rest.service;


import com.api.rest.model.Cliente;
import com.api.rest.model.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();
    public Page<Cliente> findAll(Pageable pageable);
    public Cliente findById(long id);
    public Cliente save (Cliente cliente);
    public void delete(long id);

    public List<Region> findAllRegions();

}
