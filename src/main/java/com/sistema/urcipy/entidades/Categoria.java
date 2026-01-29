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
    @Column(name="activo")
     private Boolean activo;
    @Column(name="nomcorto", length=60)
     private String nomcorto;
    @Column(name="orden")
     private Byte orden;
    @Column(name="tanda")
     private Byte tanda;
    @Column(name="ascenso")
     private Boolean ascenso;
    @Column(name="activonacional")
     private Byte activonacional;
    @Column(name="edadinicio")
     private Byte edadinicio;
    @Column(name="edadfin")
     private Byte edadfin;
    @Column(name="sexo")
     private Byte sexo;
    @Column(name="tipo")
     private Byte tipo;
    @Column(name="horario", length=20)
    private String horario;
    @Column(name="codigo", length=30)
    private String codigo;
    @Column(name="nomalternativo", length=60)
    private String nomalternativo;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="trayecto_idtrayecto", nullable=false)
     private Trayecto trayecto;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modalidad_idmodalidad", nullable=false)
    private Modalidad modalidad;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    @JsonIgnore
     private Set<Corredor> corredors = new HashSet<Corredor>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    @JsonIgnore
    private Set<EventoCategoria> eventoCategorias = new HashSet<EventoCategoria>(0);

    public Categoria() {
    }
    public Categoria(Trayecto trayecto, Modalidad modalidad) {
        this.trayecto=trayecto;
        this.modalidad = modalidad;
    }

    public Categoria(String nomcategoria, Boolean activo, String nomcorto, Byte orden, Byte tanda, Boolean ascenso, Byte activonacional, Byte edadinicio, Byte edadfin, Byte sexo, Byte tipo, String codigo, String nomalternativo, Trayecto trayecto, Set<Corredor> corredors, String horario, Modalidad modalidad,Set<EventoCategoria> eventoCategorias) {
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
        this.codigo = codigo;
        this.nomalternativo = nomalternativo;
        this.trayecto=trayecto;
       this.corredors = corredors;
       this.horario=horario;
        this.modalidad = modalidad;
        this.eventoCategorias = eventoCategorias;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNomcorto() {
        return this.nomcorto;
    }

    public void setNomcorto(String nomcorto) {
        this.nomcorto = nomcorto;
    }

    public Byte getOrden() {
        return this.orden;
    }

    public void setOrden(Byte orden) {
        this.orden = orden;
    }

    public Byte getTanda() {
        return this.tanda;
    }

    public void setTanda(Byte tanda) {
        this.tanda = tanda;
    }

    public Boolean getAscenso() {
        return this.ascenso;
    }

    public void setAscenso(Boolean ascenso) {
        this.ascenso = ascenso;
    }

    public Byte getActivonacional() {
        return this.activonacional;
    }
    
    public void setActivonacional(Byte activonacional) {
        this.activonacional = activonacional;
    }

    public Byte getEdadinicio() {
        return this.edadinicio;
    }
    
    public void setEdadinicio(Byte edadinicio) {
        this.edadinicio = edadinicio;
    }

    public Byte getEdadfin() {
        return this.edadfin;
    }
    
    public void setEdadfin(Byte edadfin) {
        this.edadfin = edadfin;
    }

    public Byte getSexo() {
        return this.sexo;
    }
    
    public void setSexo(Byte sexo) {
        this.sexo = sexo;
    }

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


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomalternativo() {
        return nomalternativo;
    }

    public void setNomalternativo(String nomalternativo) {
        this.nomalternativo = nomalternativo;
    }

    public Set<EventoCategoria> getEventoCategorias() {
        return eventoCategorias;
    }

    public void setEventoCategorias(Set<EventoCategoria> eventoCategorias) {
        this.eventoCategorias = eventoCategorias;
    }
}


