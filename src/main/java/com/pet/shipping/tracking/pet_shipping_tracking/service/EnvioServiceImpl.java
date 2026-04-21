package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioServiceImpl implements EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioServiceImpl(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    @Override
    public Optional<Envio> obtenerPorId(Long id) {
        return envioRepository.findById(id);
    }

    @Override
    public Optional<Envio> obtenerPorNumeroSeguimiento(String numero) {
        return envioRepository.findByNumeroSeguimiento(numero);
    }

    @Override
    public List<Envio> obtenerPorEstado(String estado) {
        return envioRepository.findByEstado(estado);
    }

    @Override
    public Envio registrar(Envio envio) {
        return envioRepository.save(envio);
    }

    @Override
    public Optional<Envio> actualizar(Long id, Envio datos) {
        return envioRepository.findById(id).map(e -> {
            e.setNumeroSeguimiento(datos.getNumeroSeguimiento());
            e.setEstado(datos.getEstado());
            e.setOrigen(datos.getOrigen());
            e.setDestino(datos.getDestino());
            e.setFechaEstimada(datos.getFechaEstimada());
            e.setPaqueteId(datos.getPaqueteId());
            return envioRepository.save(e);
        });
    }

    @Override
    public Optional<Envio> actualizarEstado(Long id, String estado) {
        return envioRepository.findById(id).map(e -> {
            e.setEstado(estado);
            return envioRepository.save(e);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if (envioRepository.existsById(id)) {
            envioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
