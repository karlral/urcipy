package com.sistema.urcipy.entidades;

import javax.persistence.*;

@Entity
@Table(name="dorsal"
        ,catalog="urcipy"
)
public class Dorsal {

    @Id
    @Column(name="iddorsal", unique=true, nullable=false)
    private Integer iddorsal;
    @Column(name="chip", length=20)
    private String chip;
    @Column(name="color", length=20)
    private String color;
    private Boolean activo;

    public Dorsal() {
    }

    public Dorsal(Integer iddorsal,String chip, String color, Boolean activo) {
        this.iddorsal=iddorsal;
        this.chip = chip;
        this.color = color;
        this.activo = activo;
    }

    public Integer getIddorsal() {
        return iddorsal;
    }

    public void setIddorsal(Integer iddorsal) {
        this.iddorsal = iddorsal;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

