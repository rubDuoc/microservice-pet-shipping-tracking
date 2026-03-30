package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Optional<Envio> obtenerPorId(Long id) {
        return envioRepository.findById(id);
    }

    public Optional<Envio> obtenerPorNumeroSeguimiento(String numero) {
        return envioRepository.findByNumeroSeguimiento(numero);
    }

    public List<Envio> obtenerPorEstado(String estado) {
        return envioRepository.findByEstado(estado);
    }
}
