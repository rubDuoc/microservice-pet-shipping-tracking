package com.pet.shipping.tracking.pet_shipping_tracking.repository;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PaqueteRepository {

    private final List<Paquete> paquetes = new ArrayList<>();

    public PaqueteRepository() {
        paquetes.add(new Paquete(1L, "Alimento premium para perros 10kg",  10.5, "40x30x25 cm", "NORMAL"));
        paquetes.add(new Paquete(2L, "Medicamento refrigerado para gatos",  0.8, "15x10x10 cm", "REFRIGERADO"));
        paquetes.add(new Paquete(3L, "Juguetes y accesorios para mascotas",  2.3, "35x25x20 cm", "FRAGIL"));
    }

    public List<Paquete> findAll() {
        return paquetes;
    }

    public Optional<Paquete> findById(Long id) {
        return paquetes.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
