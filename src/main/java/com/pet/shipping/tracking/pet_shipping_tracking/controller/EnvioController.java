package com.pet.shipping.tracking.pet_shipping_tracking.controller;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import com.pet.shipping.tracking.pet_shipping_tracking.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public CollectionModel<EntityModel<Envio>> obtenerTodos() {
        List<EntityModel<Envio>> envios = envioService.obtenerTodos().stream()
                .map(e -> EntityModel.of(e,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(e.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios")))
                .collect(Collectors.toList());

        return CollectionModel.of(envios,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withSelfRel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Envio>> obtenerPorId(@PathVariable Long id) {
        return envioService.obtenerPorId(id)
                .map(e -> EntityModel.of(e,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/seguimiento/{numero}")
    public ResponseEntity<EntityModel<Envio>> obtenerPorNumeroSeguimiento(@PathVariable String numero) {
        return envioService.obtenerPorNumeroSeguimiento(numero)
                .map(e -> EntityModel.of(e,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(e.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public CollectionModel<EntityModel<Envio>> obtenerPorEstado(@PathVariable String estado) {
        List<EntityModel<Envio>> envios = envioService.obtenerPorEstado(estado).stream()
                .map(e -> EntityModel.of(e,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(e.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios")))
                .collect(Collectors.toList());

        return CollectionModel.of(envios,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios"));
    }

    @PostMapping
    public ResponseEntity<EntityModel<Envio>> registrar(@Valid @RequestBody Envio envio) {
        Envio registrado = envioService.registrar(envio);
        EntityModel<Envio> model = EntityModel.of(registrado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(registrado.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios"));
        return ResponseEntity.ok(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Envio>> actualizar(@PathVariable Long id, @Valid @RequestBody Envio datos) {
        return envioService.actualizar(id, datos)
                .map(e -> EntityModel.of(e,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<EntityModel<Envio>> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        return envioService.actualizarEstado(id, estado)
                .map(e -> EntityModel.of(e,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerPorId(id)).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EnvioController.class).obtenerTodos()).withRel("all-envios")))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (envioService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
