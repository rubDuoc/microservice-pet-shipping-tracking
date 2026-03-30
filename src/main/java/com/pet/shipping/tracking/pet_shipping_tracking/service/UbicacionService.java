package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Ubicacion;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> obtenerTodas() {
        return ubicacionRepository.findAll();
    }

    public Optional<Ubicacion> obtenerPorId(Long id) {
        return ubicacionRepository.findById(id);
    }

    public Optional<Ubicacion> obtenerUbicacionActualDeEnvio(Long envioId) {
        return ubicacionRepository.findByEnvioId(envioId);
    }
}
