package com.sistema.urcipy.entidades.custom;


import java.util.Date;

public class Correbus {
    public Integer idcorredor;
    public Integer idpersona;
    public Integer idcategoria;
    public String ci;
    public String corredor;
    public Date fecnac;
    public Integer sexo;
    public String telefono;
    public String categoria;
    public String club;
    public String nacionalidad;
    public String ciudad;
    public String pais;
    public Integer carnetfpc;
    public Integer puntua;
    public Integer tamano;
    public Byte verificar;
    public Integer idclub;
    public Integer tipocat;

    public Correbus() {
    }

    public Correbus(Integer idcorredor, Integer idpersona, Integer idcategoria, String ci, String corredor, Date fecnac, Integer sexo, String telefono, String categoria, String club, String nacionalidad, String ciudad, String pais, Integer carnetfpc, Integer puntua, Integer tamano, Byte verificar, Integer idclub, Integer tipocat) {
        this.idcorredor = idcorredor;
        this.idpersona = idpersona;
        this.idcategoria = idcategoria;
        this.ci = ci;
        this.corredor = corredor;
        this.fecnac = fecnac;
        this.sexo = sexo;
        this.telefono = telefono;
        this.categoria = categoria;
        this.club = club;
        this.nacionalidad = nacionalidad;
        this.ciudad = ciudad;
        this.pais = pais;
        this.carnetfpc = carnetfpc;
        this.puntua = puntua;
        this.tamano = tamano;
        this.verificar = verificar;
        this.idclub = idclub;
        this.tipocat = tipocat;
    }

    public Integer getTipocat() {
        return tipocat;
    }

    public void setTipocat(Integer tipocat) {
        this.tipocat = tipocat;
    }

    public Integer getIdclub() {
        return idclub;
    }

    public void setIdclub(Integer idclub) {
        this.idclub = idclub;
    }

    public Byte getVerificar() {
        return verificar;
    }

    public void setVerificar(Byte verificar) {
        this.verificar = verificar;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    public Integer getPuntua() {
        return puntua;
    }

    public void setPuntua(Integer puntua) {
        this.puntua = puntua;
    }

    public Integer getCarnetfpc() {
        return carnetfpc;
    }

    public void setCarnetfpc(Integer carnetfpc) {
        this.carnetfpc = carnetfpc;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Date getFecnac() {
        return fecnac;
    }

    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Integer getIdcorredor() {
        return idcorredor;
    }

    public void setIdcorredor(Integer idcorredor) {
        this.idcorredor = idcorredor;
    }
}
