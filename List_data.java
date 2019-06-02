package com.example.cargarempresas;


public class List_data {
    private String nombre;
    private String telefono;
    private String logo;




    public List_data(String nombre, String telefono , String logo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}