package com.pet.shipping.tracking.pet_shipping_tracking.service;

import com.pet.shipping.tracking.pet_shipping_tracking.model.Envio;
import com.pet.shipping.tracking.pet_shipping_tracking.repository.EnvioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnvioServiceTest {

    @Mock
    private EnvioRepository envioRepository;

    @InjectMocks
    private EnvioServiceImpl envioService;

    private Envio envio;

    @BeforeEach
    void setUp() {
        envio = new Envio();
        envio.setNumeroSeguimiento("ENV-001");
        envio.setEstado("PENDIENTE");
        envio.setOrigen("Santiago");
        envio.setDestino("Valparaíso");
        envio.setFechaEstimada("2025-06-01");
    }

    @Test
    @DisplayName("Debe registrar un envío y retornarlo correctamente")
    void registrarEnvioTest() {
        // Arrange
        when(envioRepository.save(envio)).thenReturn(envio);

        // Act
        Envio resultado = envioService.registrar(envio);

        // Assert
        assertNotNull(resultado);
        assertEquals("ENV-001", resultado.getNumeroSeguimiento());
        assertEquals("PENDIENTE", resultado.getEstado());
        verify(envioRepository, times(1)).save(envio);
    }

    @Test
    @DisplayName("Debe obtener todos los envíos correctamente")
    void obtenerTodosTest() {
        // Arrange
        Envio envio2 = new Envio();
        envio2.setNumeroSeguimiento("ENV-002");
        envio2.setEstado("EN_TRANSITO");
        envio2.setOrigen("Concepción");
        envio2.setDestino("Santiago");

        when(envioRepository.findAll()).thenReturn(Arrays.asList(envio, envio2));

        // Act
        List<Envio> resultado = envioService.obtenerTodos();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("ENV-001", resultado.get(0).getNumeroSeguimiento());
        assertEquals("ENV-002", resultado.get(1).getNumeroSeguimiento());
        verify(envioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe actualizar el estado de un envío existente")
    void actualizarEstadoTest() {
        // Arrange
        Envio existente = new Envio();
        existente.setId(7L);
        existente.setNumeroSeguimiento("ENV-007");
        existente.setEstado("PENDIENTE");
        existente.setOrigen("Santiago");
        existente.setDestino("Valparaíso");
        existente.setFechaEstimada("2025-06-01");

        when(envioRepository.findById(7L)).thenReturn(Optional.of(existente));
        when(envioRepository.save(existente)).thenReturn(existente);

        // Act
        Optional<Envio> resultado = envioService.actualizarEstado(7L, "ENTREGADO");

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("ENTREGADO", resultado.get().getEstado());
        assertEquals("ENV-007", resultado.get().getNumeroSeguimiento());
        verify(envioRepository, times(1)).findById(7L);
        verify(envioRepository, times(1)).save(existente);
    }

    @Test
    @DisplayName("Debe eliminar un envío cuando existe y retornar true")
    void eliminarEnvioExistenteTest() {
        // Arrange
        when(envioRepository.existsById(3L)).thenReturn(true);

        // Act
        boolean resultado = envioService.eliminar(3L);

        // Assert
        assertTrue(resultado);
        verify(envioRepository, times(1)).existsById(3L);
        verify(envioRepository, times(1)).deleteById(3L);
    }
}
