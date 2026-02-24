package com.sistema.urcipy.entidades.custom;

public class Partici {
     private Integer idparticipante;
     private Integer idevento;
    private Integer idcorredor;
     private Integer idcategoria;
     private Integer idclub;
     private String ci;
     private Integer tamano;
     private String telefono;


    public Partici() {
    }

    public Partici(Integer idparticipante, Integer idevento, Integer idcategoria, Integer idclub, Integer tamano, Integer idcorredor, String ci, String telefono) {
        this.idparticipante = idparticipante;
        this.idevento = idevento;
        this.idcategoria = idcategoria;
        this.idclub = idclub;
        this.tamano = tamano;
        this.idcorredor = idcorredor;
        this.ci = ci;
        this.telefono = telefono;
    }

    public Integer getIdparticipante() {
        return idparticipante;
    }

    public void setIdparticipante(Integer idparticipante) {
        this.idparticipante = idparticipante;
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

    public Integer getIdcorredor() {
        return idcorredor;
    }

    public void setIdcorredor(Integer idcorredor) {
        this.idcorredor = idcorredor;
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
}


