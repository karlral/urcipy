package com.sistema.urcipy.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="categoria"
    ,catalog="urcipy"
)
public class Categoria  {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idcategoria", unique=true, nullable=false)
     private Integer idcategoria;
    @Column(name="nomcategoria", length=60)
    private String nomcategoria;
     private Boolean activo;
     private String nomcorto;
     private Byte orden;
     private Byte tanda;
     private Boolean ascenso;
     private Byte activonacional;
     private Byte edadinicio;
     private Byte edadfin;
     private Byte sexo;
     private Byte tipo;
    private String horario;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="trayecto_idtrayecto", nullable=false)
     private Trayecto trayecto;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modalidad_idmodalidad", nullable=false)
    private Modalidad modalidad;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    @JsonIgnore
     private Set<Corredor> corredors = new HashSet<Corredor>(0);

    public Categoria() {
    }
    public Categoria(Trayecto trayecto, Modalidad modalidad) {
        this.trayecto=trayecto;
        this.modalidad = modalidad;
    }

    public Categoria(String nomcategoria, Boolean activo, String nomcorto, Byte orden, Byte tanda, Boolean ascenso, Byte activonacional, Byte edadinicio, Byte edadfin, Byte sexo, Byte tipo, Trayecto trayecto, Set<Corredor> corredors, String horario, Modalidad modalidad) {
       this.nomcategoria = nomcategoria;
       this.activo = activo;
       this.nomcorto = nomcorto;
       this.orden = orden;
       this.tanda = tanda;
       this.ascenso = ascenso;
       this.activonacional = activonacional;
       this.edadinicio = edadinicio;
       this.edadfin = edadfin;
       this.sexo = sexo;
       this.tipo = tipo;
       this.trayecto=trayecto;
       this.corredors = corredors;
       this.horario=horario;
        this.modalidad = modalidad;
    }


    public Integer getIdcategoria() {
        return this.idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNomcategoria() {
        return this.nomcategoria;
    }

    public void setNomcategoria(String nomcategoria) {
        this.nomcategoria = nomcategoria;
    }

    @Column(name="activo")
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Column(name="nomcorto", length=60)
    public String getNomcorto() {
        return this.nomcorto;
    }

    public void setNomcorto(String nomcorto) {
        this.nomcorto = nomcorto;
    }


    @Column(name="orden")
    public Byte getOrden() {
        return this.orden;
    }

    public void setOrden(Byte orden) {
        this.orden = orden;
    }


    @Column(name="tanda")
    public Byte getTanda() {
        return this.tanda;
    }

    public void setTanda(Byte tanda) {
        this.tanda = tanda;
    }


    @Column(name="ascenso")
    public Boolean getAscenso() {
        return this.ascenso;
    }

    public void setAscenso(Boolean ascenso) {
        this.ascenso = ascenso;
    }

    
    @Column(name="activonacional")
    public Byte getActivonacional() {
        return this.activonacional;
    }
    
    public void setActivonacional(Byte activonacional) {
        this.activonacional = activonacional;
    }

    
    @Column(name="edadinicio")
    public Byte getEdadinicio() {
        return this.edadinicio;
    }
    
    public void setEdadinicio(Byte edadinicio) {
        this.edadinicio = edadinicio;
    }

    
    @Column(name="edadfin")
    public Byte getEdadfin() {
        return this.edadfin;
    }
    
    public void setEdadfin(Byte edadfin) {
        this.edadfin = edadfin;
    }

    
    @Column(name="sexo")
    public Byte getSexo() {
        return this.sexo;
    }
    
    public void setSexo(Byte sexo) {
        this.sexo = sexo;
    }

    
    @Column(name="tipo")
    public Byte getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Byte tipo) {
        this.tipo = tipo;
    }


    public Trayecto getTrayecto() {
        return this.trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }


    public Set<Corredor> getCorredors() {
        return this.corredors;
    }
    
    public void setCorredors(Set<Corredor> corredors) {
        this.corredors = corredors;
    }

    @Column(name="horario", length=20)
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
}


