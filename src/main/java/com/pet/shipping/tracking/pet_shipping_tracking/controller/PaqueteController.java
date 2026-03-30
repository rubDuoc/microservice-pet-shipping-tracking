package com.pet.shipping.tracking.pet_shipping_tracking.controller;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Paquete;
import com.pet.shipping.tracking.pet_shipping_tracking.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

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
}
