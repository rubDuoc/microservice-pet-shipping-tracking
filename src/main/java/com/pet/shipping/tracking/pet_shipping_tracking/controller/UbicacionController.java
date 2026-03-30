package com.pet.shipping.tracking.pet_shipping_tracking.controller;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Ubicacion;
import com.pet.shipping.tracking.pet_shipping_tracking.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public ResponseEntity<List<Ubicacion>> obtenerTodas() {
        return ResponseEntity.ok(ubicacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> obtenerPorId(@PathVariable Long id) {
        return ubicacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/envio/{envioId}")
    public ResponseEntity<Ubicacion> obtenerUbicacionActual(@PathVariable Long envioId) {
        return ubicacionService.obtenerUbicacionActualDeEnvio(envioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
