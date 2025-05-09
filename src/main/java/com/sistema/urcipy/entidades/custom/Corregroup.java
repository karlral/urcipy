package com.sistema.urcipy.entidades.custom;

import java.util.Date;

public class Corregroup {

    private Integer idevento;
    private String ci;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private Date fecnac;
    private String categoria;
    private String club;
    private String sexo;
    private String ciudad;
    private String pais;
    private Integer distancia;

    public Corregroup() {
    }

    public Corregroup(Integer idevento, String ci, String nombre, String apellido, String telefono, String email, Date fecnac, String categoria, String club, String sexo, String ciudad, String pais, Integer distancia) {
        this.idevento = idevento;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fecnac = fecnac;
        this.categoria = categoria;
        this.club = club;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.distancia = distancia;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecnac() {
        return fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
}
