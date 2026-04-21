package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Ubicacion;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionServiceImpl(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    @Override
    public List<Ubicacion> obtenerTodas() {
        return ubicacionRepository.findAll();
    }

    @Override
    public Optional<Ubicacion> obtenerPorId(Long id) {
        return ubicacionRepository.findById(id);
    }

    @Override
    public Optional<Ubicacion> obtenerUbicacionActualDeEnvio(Long envioId) {
        return ubicacionRepository.findTopByEnvioIdOrderByIdDesc(envioId);
    }

    @Override
    public Ubicacion registrar(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public Optional<Ubicacion> actualizar(Long id, Ubicacion datos) {
        return ubicacionRepository.findById(id).map(u -> {
            u.setEnvioId(datos.getEnvioId());
            u.setCiudad(datos.getCiudad());
            u.setPais(datos.getPais());
            u.setDireccion(datos.getDireccion());
            u.setFechaRegistro(datos.getFechaRegistro());
            return ubicacionRepository.save(u);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if (ubicacionRepository.existsById(id)) {
            ubicacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
