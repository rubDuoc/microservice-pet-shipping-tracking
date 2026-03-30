package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    public List<Paquete> obtenerTodos() {
        return paqueteRepository.findAll();
    }

    public Optional<Paquete> obtenerPorId(Long id) {
        return paqueteRepository.findById(id);
    }
}
