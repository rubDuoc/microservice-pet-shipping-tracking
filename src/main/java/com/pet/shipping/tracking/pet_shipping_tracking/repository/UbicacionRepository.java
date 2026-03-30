package com.pet.shipping.tracking.pet_shipping_tracking.repository;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Ubicacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UbicacionRepository {

    private final List<Ubicacion> ubicaciones = new ArrayList<>();

    public UbicacionRepository() {
        ubicaciones.add(new Ubicacion(1L, 1L, "Rancagua",    "Chile", "Av. Principal 123", "2026-03-30T08:00:00"));
        ubicaciones.add(new Ubicacion(2L, 2L, "Concepción",  "Chile", "Terminal de Carga 5", "2026-03-29T14:30:00"));
        ubicaciones.add(new Ubicacion(3L, 3L, "La Serena",   "Chile", "Bodega Central 2",    "2026-03-28T17:45:00"));
    }

    public List<Ubicacion> findAll() {
        return ubicaciones;
    }

    public Optional<Ubicacion> findById(Long id) {
        return ubicaciones.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Optional<Ubicacion> findByEnvioId(Long envioId) {
        return ubicaciones.stream().filter(u -> u.getEnvioId().equals(envioId)).findFirst();
    }
}
