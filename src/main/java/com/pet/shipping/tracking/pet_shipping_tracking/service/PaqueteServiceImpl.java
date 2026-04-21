package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.PaqueteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteServiceImpl implements PaqueteService {

    private final PaqueteRepository paqueteRepository;

    public PaqueteServiceImpl(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    @Override
    public List<Paquete> obtenerTodos() {
        return paqueteRepository.findAll();
    }

    @Override
    public Optional<Paquete> obtenerPorId(Long id) {
        return paqueteRepository.findById(id);
    }

    @Override
    public Paquete crear(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    @Override
    public Optional<Paquete> actualizar(Long id, Paquete datos) {
        return paqueteRepository.findById(id).map(p -> {
            p.setDescripcion(datos.getDescripcion());
            p.setPeso(datos.getPeso());
            p.setDimensiones(datos.getDimensiones());
            p.setTipoCarga(datos.getTipoCarga());
            return paqueteRepository.save(p);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if (paqueteRepository.existsById(id)) {
            paqueteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
