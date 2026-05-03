package com.sistema.urcipy.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="tipopuntos"
    ,catalog="urcipy"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tipopuntos {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idtipopuntos", unique=true, nullable=false)
    private Integer idtipopuntos;
    @Column(length = 20, nullable=false)
    private String nomtipopuntos;

    public Tipopuntos() {
    }

    public Tipopuntos(String nomtipopuntos) {
        this.nomtipopuntos = nomtipopuntos;
    }

    public Integer getIdtipopuntos() {
        return idtipopuntos;
    }

    public void setIdtipopuntos(Integer idtipopuntos) {
        this.idtipopuntos = idtipopuntos;
    }

    public String getNomtipopuntos() {
        return nomtipopuntos;
    }

    public void setNomtipopuntos(String nomtipopuntos) {
        this.nomtipopuntos = nomtipopuntos;
    }
}


