package com.pet.shipping.tracking.pet_shipping_tracking.repository;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
}
