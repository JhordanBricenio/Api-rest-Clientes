package com.api.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "regiones")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
