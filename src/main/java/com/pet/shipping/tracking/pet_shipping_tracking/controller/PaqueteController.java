package com.pet.shipping.tracking.pet_shipping_tracking.controller;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;
import com.pet.shipping.tracking.pet_shipping_tracking.service.PaqueteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @GetMapping
    public ResponseEntity<List<Paquete>> obtenerTodos() {
        return ResponseEntity.ok(paqueteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paquete> obtenerPorId(@PathVariable Long id) {
        return paqueteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paquete> crear(@Valid @RequestBody Paquete paquete) {
        return ResponseEntity.ok(paqueteService.crear(paquete));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paquete> actualizar(@PathVariable Long id, @Valid @RequestBody Paquete datos) {
        return paqueteService.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (paqueteService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
