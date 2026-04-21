package com.pet.shipping.tracking.pet_shipping_tracking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PAQUETES")
@Getter
@Setter
@NoArgsConstructor
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(nullable = false, length = 300)
    private String descripcion;

    @NotNull(message = "El peso es obligatorio")
    @Column(nullable = false, columnDefinition = "NUMBER(8,2)")
    private Double peso;

    @Column(length = 100)
    private String dimensiones;

    @Column(name = "TIPO_CARGA", length = 100)
    private String tipoCarga;
}
