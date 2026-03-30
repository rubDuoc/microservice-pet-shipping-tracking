package com.pet.shipping.tracking.pet_shipping_tracking.model;

public class Envio {

    private Long id;
    private String numeroSeguimiento;
    private String estado;
    private String origen;
    private String destino;
    private String fechaEstimada;
    private Long paqueteId;

    public Envio() {}

    public Envio(Long id, String numeroSeguimiento, String estado, String origen,
                 String destino, String fechaEstimada, Long paqueteId) {
        this.id = id;
        this.numeroSeguimiento = numeroSeguimiento;
        this.estado = estado;
        this.origen = origen;
        this.destino = destino;
        this.fechaEstimada = fechaEstimada;
        this.paqueteId = paqueteId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroSeguimiento() { return numeroSeguimiento; }
    public void setNumeroSeguimiento(String numeroSeguimiento) { this.numeroSeguimiento = numeroSeguimiento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getFechaEstimada() { return fechaEstimada; }
    public void setFechaEstimada(String fechaEstimada) { this.fechaEstimada = fechaEstimada; }

    public Long getPaqueteId() { return paqueteId; }
    public void setPaqueteId(Long paqueteId) { this.paqueteId = paqueteId; }
}
