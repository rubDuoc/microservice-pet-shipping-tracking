package com.pet.shipping.tracking.pet_shipping_tracking.model;

public class Paquete {

    private Long id;
    private String descripcion;
    private Double peso;
    private String dimensiones;
    private String tipoCarga;

    public Paquete() {}

    public Paquete(Long id, String descripcion, Double peso, String dimensiones, String tipoCarga) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.tipoCarga = tipoCarga;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getDimensiones() { return dimensiones; }
    public void setDimensiones(String dimensiones) { this.dimensiones = dimensiones; }

    public String getTipoCarga() { return tipoCarga; }
    public void setTipoCarga(String tipoCarga) { this.tipoCarga = tipoCarga; }
}
