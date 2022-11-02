package com.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotBlank(message = "Name es obligatorio")
    @Size(min = 3, max = 12, message = "Debe tener entre 3 e 100 caracteres")
    private String name;

    @NotBlank(message = "LastName es obligatorio")
    @Size(min = 3, max = 12, message = "Deve tener entre 3 e 100 caracteres")
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email es obligatorio")
    @Email
    private String email;

    @NotNull(message = "Fecha obligatoria")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    private String foto;

    //Metodo para crear la fecha antes de persistir los datos
   /* @PrePersist
    public void prePersist(){
        this.createdAt = new Date();
    }*/
    @NotNull(message = "La región no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;
}
