package com.example.veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table (name ="Mascota")
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String Nombre;
    @NotBlank
    private String Especie;
    @NotBlank
    private String Raza;

    @NotNull
    @Min(0)
    private Integer edad;

    @NotNull
    @Positive
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @OneToOne (mappedBy = "mascota", cascade = CascadeType.ALL)
    private HistoriaClinica historiaClinica;

    @ManyToMany
    @JoinTable(
            name= "mascota_veterinario",
            joinColumns = @JoinColumn (name = "mascota_id "),
            inverseJoinColumns =  @JoinColumn (name = "veterinario_id")
    )
    private List<Veterinario> veterinarios;

}
