package com.sistema.urcipy.entidades;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="tipo"
    ,catalog="urcipy"
)
public class Tipo {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idtipo", unique=true, nullable=false)
    private Integer idtipo;
    @Column(length = 20, nullable=false)
    private String nomtipo;

    public Tipo() {
    }

    public Tipo(String nomtipo) {
        this.nomtipo = nomtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNomtipo() {
        return nomtipo;
    }

    public void setNomtipo(String nomtipo) {
        this.nomtipo = nomtipo;
    }
}


