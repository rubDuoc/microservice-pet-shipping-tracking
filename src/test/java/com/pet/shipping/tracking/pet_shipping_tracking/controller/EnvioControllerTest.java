package com.pet.shipping.tracking.pet_shipping_tracking.controller;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import com.pet.shipping.tracking.pet_shipping_tracking.service.EnvioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EnvioController.class)
class EnvioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EnvioService envioService;

    private Envio envio1;
    private Envio envio2;

    @BeforeEach
    void setUp() {
        envio1 = new Envio();
        envio1.setId(1L);
        envio1.setNumeroSeguimiento("ENV-001");
        envio1.setEstado("PENDIENTE");
        envio1.setOrigen("Santiago");
        envio1.setDestino("Valparaíso");

        envio2 = new Envio();
        envio2.setId(2L);
        envio2.setNumeroSeguimiento("ENV-002");
        envio2.setEstado("EN_TRANSITO");
        envio2.setOrigen("Concepción");
        envio2.setDestino("Santiago");
    }

    @Test
    @DisplayName("GET /api/envios debe retornar lista de envíos con estado 200")
    void obtenerTodosTest() throws Exception {
        // Arrange
        List<Envio> envios = Arrays.asList(envio1, envio2);
        when(envioService.obtenerTodos()).thenReturn(envios);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/envios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.envioList", hasSize(2)))
                .andExpect(jsonPath("$._embedded.envioList[0].numeroSeguimiento", is("ENV-001")))
                .andExpect(jsonPath("$._embedded.envioList[1].numeroSeguimiento", is("ENV-002")));
    }

    @Test
    @DisplayName("GET /api/envios/{id} debe retornar 404 si el envío no existe")
    void obtenerPorIdNoEncontradoTest() throws Exception {
        // Arrange
        when(envioService.obtenerPorId(99L)).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/envios/99"))
                .andExpect(status().isNotFound());
    }
}
