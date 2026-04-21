package com.pet.shipping.tracking.pet_shipping_tracking.repository;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnvioRepository extends JpaRepository<Envio, Long> {

    Optional<Envio> findByNumeroSeguimiento(String numeroSeguimiento);

    List<Envio> findByEstado(String estado);
}
