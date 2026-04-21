package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Ubicacion;

import java.util.List;
import java.util.Optional;

public interface UbicacionService {

    List<Ubicacion> obtenerTodas();

    Optional<Ubicacion> obtenerPorId(Long id);

    Optional<Ubicacion> obtenerUbicacionActualDeEnvio(Long envioId);

    Ubicacion registrar(Ubicacion ubicacion);

    Optional<Ubicacion> actualizar(Long id, Ubicacion datos);

    boolean eliminar(Long id);
}
