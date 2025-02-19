package com.sistema.urcipy.entidades.custom;

import java.util.Date;

public interface Corredorank {
    Integer getIdmovimiento();
    Date getFecha();
    String getNomconcepto();
    Integer getIdcorredor();
    String getCorredor();
    String getClub();
    String getCategoria();
    Integer getEntrada();
    Integer getSalida();
    String getFoto();
    Integer getPuntua();
}
