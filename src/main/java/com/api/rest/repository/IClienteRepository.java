package com.api.rest.repository;

import com.api.rest.model.Cliente;
import com.api.rest.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    public List<Region> findAllRegions();

}

