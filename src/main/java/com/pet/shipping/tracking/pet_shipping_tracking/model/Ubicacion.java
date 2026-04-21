package com.pet.shipping.tracking.pet_shipping_tracking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UBICACIONES")
@Getter
@Setter
@NoArgsConstructor
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de envío es obligatorio")
    @Column(name = "ENVIO_ID", nullable = false)
    private Long envioId;

    @NotBlank(message = "La ciudad es obligatoria")
    @Column(nullable = false, length = 100)
    private String ciudad;

    @NotBlank(message = "El país es obligatorio")
    @Column(nullable = false, length = 100)
    private String pais;

    @Column(length = 300)
    private String direccion;

    @Column(name = "FECHA_REGISTRO", length = 30)
    private String fechaRegistro;
}
