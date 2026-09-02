package com.example.veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name ="Veterinario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;

    @NotBlank
    private String Nombre;

    @NotBlank
    private String TarjetaProfesional;

    @NotBlank
    private String Especialidad;
    @NotBlank
    @Email
    private String Correo;

    @ManyToMany (mappedBy = "veterinarios")
    private List<Mascota> mascotas;
}
