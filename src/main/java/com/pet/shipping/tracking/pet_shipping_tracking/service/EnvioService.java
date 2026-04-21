package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;

import java.util.List;
import java.util.Optional;

public interface EnvioService {

    List<Envio> obtenerTodos();

    Optional<Envio> obtenerPorId(Long id);

    Optional<Envio> obtenerPorNumeroSeguimiento(String numero);

    List<Envio> obtenerPorEstado(String estado);

    Envio registrar(Envio envio);

    Optional<Envio> actualizar(Long id, Envio datos);

    Optional<Envio> actualizarEstado(Long id, String estado);

    boolean eliminar(Long id);
}
