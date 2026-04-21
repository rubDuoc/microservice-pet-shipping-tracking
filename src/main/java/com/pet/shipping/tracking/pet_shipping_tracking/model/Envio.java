package com.pet.shipping.tracking.pet_shipping_tracking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ENVIOS")
@Getter
@Setter
@NoArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de seguimiento es obligatorio")
    @Column(name = "NUMERO_SEGUIMIENTO", nullable = false, unique = true, length = 50)
    private String numeroSeguimiento;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false, length = 50)
    private String estado;

    @NotBlank(message = "El origen es obligatorio")
    @Column(nullable = false, length = 150)
    private String origen;

    @NotBlank(message = "El destino es obligatorio")
    @Column(nullable = false, length = 150)
    private String destino;

    @Column(name = "FECHA_ESTIMADA", length = 20)
    private String fechaEstimada;

    @Column(name = "PAQUETE_ID")
    private Long paqueteId;
}
