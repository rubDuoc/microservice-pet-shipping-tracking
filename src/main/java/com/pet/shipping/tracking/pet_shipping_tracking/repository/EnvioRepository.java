package com.pet.shipping.tracking.pet_shipping_tracking.repository;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EnvioRepository {

    private final List<Envio> envios = new ArrayList<>();

    public EnvioRepository() {
        envios.add(new Envio(1L, "ENV-001", "EN_TRANSITO", "Santiago", "Valparaíso", "2026-04-02", 1L));
        envios.add(new Envio(2L, "ENV-002", "PENDIENTE",   "Concepción", "Temuco",    "2026-04-05", 2L));
        envios.add(new Envio(3L, "ENV-003", "ENTREGADO",   "Antofagasta", "La Serena","2026-03-28", 3L));
    }

    public List<Envio> findAll() {
        return envios;
    }

    public Optional<Envio> findById(Long id) {
        return envios.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Optional<Envio> findByNumeroSeguimiento(String numero) {
        return envios.stream().filter(e -> e.getNumeroSeguimiento().equals(numero)).findFirst();
    }

    public List<Envio> findByEstado(String estado) {
        List<Envio> resultado = new ArrayList<>();
        for (Envio e : envios) {
            if (e.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
}
