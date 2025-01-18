package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Evento generated by hbm2java
 */
@Entity
@Table(name="evento"
    ,catalog="urcipy"
)
public class Evento  implements java.io.Serializable {


     private Integer idevento;
     private Club club;
     private Regional regional;
     private Date fecha;
     private String nomevento;
     private Integer activo;
     private String direccion;
     private Integer orden;

     private Integer tipoevento;
     private Integer modo;
     private Integer verencuesta;
    private Integer ranqueable;
    private Integer preinscrip;

     private Integer doble;
     private Integer km;
     private Integer kmpromo;
     private Integer kmmenor;
     private String informacion;
     private String locales;
     private String deposito;
     private String urlpromocional;
    private String urlcategoria;
     private String contacto;

     private Integer montopric;
     private Integer montopris;
     private Integer montomenc;
     private Integer montomens;

    private String fondocolor;
    private String fondo;
     private Set<Fotos> fotoses = new HashSet<Fotos>(0);
     private Set<Participante> participantes = new HashSet<Participante>(0);
     private Set<Enlaces> enlaceses = new HashSet<Enlaces>(0);
     private Set<Resultimio> resultimios = new HashSet<Resultimio>(0);
     private Set<Sugerencia> sugerencias = new HashSet<Sugerencia>(0);

    public Evento() {
    }

	
    public Evento(Club club, Regional regional) {
        this.club = club;
        this.regional = regional;
    }

    public Evento(Integer idevento, Club club, Regional regional, Date fecha, String nomevento, Integer activo, String direccion, Integer orden, Integer tipoevento, Integer modo, Integer verencuesta, Integer ranqueable, Integer preinscrip, Integer doble, Integer km, Integer kmpromo, Integer kmmenor, String informacion, String locales, String deposito, String urlpromocional, String urlcategoria, String contacto, Integer montopric, Integer montopris, Integer montomenc, Integer montomens, String fondocolor, String fondo, Set<Fotos> fotoses, Set<Participante> participantes, Set<Enlaces> enlaceses, Set<Resultimio> resultimios, Set<Sugerencia> sugerencias) {
        this.idevento = idevento;
        this.club = club;
        this.regional = regional;
        this.fecha = fecha;
        this.nomevento = nomevento;
        this.activo = activo;
        this.direccion = direccion;
        this.orden = orden;
        this.tipoevento = tipoevento;
        this.modo = modo;
        this.verencuesta = verencuesta;
        this.ranqueable = ranqueable;
        this.preinscrip = preinscrip;
        this.doble = doble;
        this.km = km;
        this.kmpromo = kmpromo;
        this.kmmenor = kmmenor;
        this.informacion = informacion;
        this.locales = locales;
        this.deposito = deposito;
        this.urlpromocional = urlpromocional;
        this.urlcategoria = urlcategoria;
        this.contacto = contacto;
        this.montopric = montopric;
        this.montopris = montopris;
        this.montomenc = montomenc;
        this.montomens = montomens;
        this.fondocolor = fondocolor;
        this.fondo = fondo;
        this.fotoses = fotoses;
        this.participantes = participantes;
        this.enlaceses = enlaceses;
        this.resultimios = resultimios;
        this.sugerencias = sugerencias;
    }

    @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idevento", unique=true, nullable=false)
    public Integer getIdevento() {
        return this.idevento;
    }
    
    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="club_idclub", nullable=false)
    public Club getClub() {
        return this.club;
    }
    
    public void setClub(Club club) {
        this.club = club;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="regional_idregional", nullable=false)
    public Regional getRegional() {
        return this.regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="nomevento", length=45)
    public String getNomevento() {
        return this.nomevento;
    }
    
    public void setNomevento(String nomevento) {
        this.nomevento = nomevento;
    }

    
    @Column(name="activo")
    public Integer getActivo() {
        return this.activo;
    }
    
    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    
    @Column(name="direccion", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Column(name="orden")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    
    @Column(name="urlpromocional", length=60)
    public String getUrlpromocional() {
        return this.urlpromocional;
    }
    
    public void setUrlpromocional(String urlpromocional) {
        this.urlpromocional = urlpromocional;
    }

    
    @Column(name="urlcategoria", length=100)
    public String getUrlcategoria() {
        return this.urlcategoria;
    }
    
    public void setUrlcategoria(String urlcategoria) {
        this.urlcategoria = urlcategoria;
    }

    
    @Column(name="tipoevento")
    public Integer getTipoevento() {
        return this.tipoevento;
    }
    
    public void setTipoevento(Integer tipoevento) {
        this.tipoevento = tipoevento;
    }

    
    @Column(name="modo")
    public Integer getModo() {
        return this.modo;
    }
    
    public void setModo(Integer modo) {
        this.modo = modo;
    }

    
    @Column(name="verencuesta")
    public Integer getVerencuesta() {
        return this.verencuesta;
    }
    
    public void setVerencuesta(Integer verencuesta) {
        this.verencuesta = verencuesta;
    }

    
    @Column(name="km")
    public Integer getKm() {
        return this.km;
    }
    
    public void setKm(Integer km) {
        this.km = km;
    }

    
    @Column(name="kmpromo")
    public Integer getKmpromo() {
        return this.kmpromo;
    }
    
    public void setKmpromo(Integer kmpromo) {
        this.kmpromo = kmpromo;
    }

    
    @Column(name="kmmenor")
    public Integer getKmmenor() {
        return this.kmmenor;
    }
    
    public void setKmmenor(Integer kmmenor) {
        this.kmmenor = kmmenor;
    }

    
    @Column(name="informacion", length=300)
    public String getInformacion() {
        return this.informacion;
    }
    
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    
    @Column(name="locales", length=300)
    public String getLocales() {
        return this.locales;
    }
    
    public void setLocales(String locales) {
        this.locales = locales;
    }

    
    @Column(name="deposito", length=300)
    public String getDeposito() {
        return this.deposito;
    }
    
    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    
    @Column(name="ranqueable")
    public Integer getRanqueable() {
        return this.ranqueable;
    }
    
    public void setRanqueable(Integer ranqueable) {
        this.ranqueable = ranqueable;
    }

    
    @Column(name="preinscrip")
    public Integer getPreinscrip() {
        return this.preinscrip;
    }
    
    public void setPreinscrip(Integer preinscrip) {
        this.preinscrip = preinscrip;
    }

    
    @Column(name="contacto", length=45)
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    
    @Column(name="fondo", length=45)
    public String getFondo() {
        return this.fondo;
    }
    
    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    
    @Column(name="montopric")
    public Integer getMontopric() {
        return this.montopric;
    }
    
    public void setMontopric(Integer montopric) {
        this.montopric = montopric;
    }

    
    @Column(name="montopris")
    public Integer getMontopris() {
        return this.montopris;
    }
    
    public void setMontopris(Integer montopris) {
        this.montopris = montopris;
    }

    
    @Column(name="montomenc")
    public Integer getMontomenc() {
        return this.montomenc;
    }
    
    public void setMontomenc(Integer montomenc) {
        this.montomenc = montomenc;
    }

    
    @Column(name="montomens")
    public Integer getMontomens() {
        return this.montomens;
    }
    
    public void setMontomens(Integer montomens) {
        this.montomens = montomens;
    }

    
    @Column(name="doble")
    public Integer getDoble() {
        return this.doble;
    }
    
    public void setDoble(Integer doble) {
        this.doble = doble;
    }

    @Column(name="fondocolor", length=45)
    public String getFondocolor() {
        return fondocolor;
    }

    public void setFondocolor(String fondocolor) {
        this.fondocolor = fondocolor;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="evento")
@JsonIgnore
    public Set<Fotos> getFotoses() {
        return this.fotoses;
    }
    
    public void setFotoses(Set<Fotos> fotoses) {
        this.fotoses = fotoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="evento")
@JsonIgnore
    public Set<Participante> getParticipantes() {
        return this.participantes;
    }
    
    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="evento")
@JsonIgnore
    public Set<Enlaces> getEnlaceses() {
        return this.enlaceses;
    }
    
    public void setEnlaceses(Set<Enlaces> enlaceses) {
        this.enlaceses = enlaceses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="evento")
@JsonIgnore
    public Set<Resultimio> getResultimios() {
        return this.resultimios;
    }
    
    public void setResultimios(Set<Resultimio> resultimios) {
        this.resultimios = resultimios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="evento")
@JsonIgnore
    public Set<Sugerencia> getSugerencias() {
        return this.sugerencias;
    }
    
    public void setSugerencias(Set<Sugerencia> sugerencias) {
        this.sugerencias = sugerencias;
    }




}


