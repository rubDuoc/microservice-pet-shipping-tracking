package com.pet.shipping.tracking.pet_shipping_tracking.model;

public class Ubicacion {

    private Long id;
    private Long envioId;
    private String ciudad;
    private String pais;
    private String direccion;
    private String timestamp;

    public Ubicacion() {}

    public Ubicacion(Long id, Long envioId, String ciudad, String pais, String direccion, String timestamp) {
        this.id = id;
        this.envioId = envioId;
        this.ciudad = ciudad;
        this.pais = pais;
        this.direccion = direccion;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEnvioId() { return envioId; }
    public void setEnvioId(Long envioId) { this.envioId = envioId; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
