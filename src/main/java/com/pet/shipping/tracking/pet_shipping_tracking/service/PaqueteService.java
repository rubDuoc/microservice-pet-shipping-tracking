package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;

import java.util.List;
import java.util.Optional;

public interface PaqueteService {

    List<Paquete> obtenerTodos();

    Optional<Paquete> obtenerPorId(Long id);

    Paquete crear(Paquete paquete);

    Optional<Paquete> actualizar(Long id, Paquete datos);

    boolean eliminar(Long id);
}
