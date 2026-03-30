package com.pet.shipping.tracking.pet_shipping_tracking.controller;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import com.pet.shipping.tracking.pet_shipping_tracking.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public ResponseEntity<List<Envio>> obtenerTodos() {
        return ResponseEntity.ok(envioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> obtenerPorId(@PathVariable Long id) {
        return envioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/seguimiento/{numero}")
    public ResponseEntity<Envio> obtenerPorNumeroSeguimiento(@PathVariable String numero) {
        return envioService.obtenerPorNumeroSeguimiento(numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Envio>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(envioService.obtenerPorEstado(estado));
    }
}
