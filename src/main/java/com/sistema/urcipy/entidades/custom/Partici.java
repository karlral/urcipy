package com.sistema.urcipy.entidades.custom;

import java.util.Date;

public class Partici {
     private Integer idparticipante;
     private Integer idevento;
    private Integer idcorredor;
     private Integer idcategoria;
     private Integer idclub;
     private String ci;
     private Integer tamano;
     private String telefono;
     private Integer idregional;
     private Integer modificar;
     private Byte tipocat;
     private String corredor;
     private String nombre;
     private String apellido;
     private Date fecnac;
     private Byte sexo;
     private String nacionalidad;
     private Boolean regcorredor;


    public Partici() {
    }

    public Partici(Integer idparticipante, Integer idevento, Integer idcorredor, Integer idcategoria, Integer idclub, String ci, Integer tamano, String telefono, Integer idregional, Integer modificar, Byte tipocat, String corredor, String nombre, String apellido, Date fecnac, Byte sexo, String nacionalidad, Boolean regcorredor) {
        this.idparticipante = idparticipante;
        this.idevento = idevento;
        this.idcorredor = idcorredor;
        this.idcategoria = idcategoria;
        this.idclub = idclub;
        this.ci = ci;
        this.tamano = tamano;
        this.telefono = telefono;
        this.idregional = idregional;
        this.modificar = modificar;
        this.tipocat = tipocat;
        this.corredor = corredor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecnac = fecnac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.regcorredor = regcorredor;
    }

    public Integer getIdparticipante() {
        return idparticipante;
    }

    public void setIdparticipante(Integer idparticipante) {
        this.idparticipante = idparticipante;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public Integer getIdcorredor() {
        return idcorredor;
    }

    public void setIdcorredor(Integer idcorredor) {
        this.idcorredor = idcorredor;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Integer getIdclub() {
        return idclub;
    }

    public void setIdclub(Integer idclub) {
        this.idclub = idclub;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdregional() {
        return idregional;
    }

    public void setIdregional(Integer idregional) {
        this.idregional = idregional;
    }

    public Integer getModificar() {
        return modificar;
    }

    public void setModificar(Integer modificar) {
        this.modificar = modificar;
    }

    public Byte getTipocat() {
        return tipocat;
    }

    public void setTipocat(Byte tipocat) {
        this.tipocat = tipocat;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
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

    public Date getFecnac() {
        return fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public Byte getSexo() {
        return sexo;
    }

    public void setSexo(Byte sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getRegcorredor() {
        return regcorredor;
    }

    public void setRegcorredor(Boolean regcorredor) {
        this.regcorredor = regcorredor;
    }
}

