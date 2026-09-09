package com.example.veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table (name ="Historia Clinica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private LocalDate FechadeApertura ;
    @NotBlank
    private String Antecedentes;

    @NotBlank
    private String Observaciones;
    @OneToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;


}
