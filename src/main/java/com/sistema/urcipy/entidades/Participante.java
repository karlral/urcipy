package com.sistema.urcipy.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="participante"
    ,catalog="urcipy"
)
public class Participante  {

    @Id @GeneratedValue(strategy=IDENTITY)


    @Column(name="idparticipante", unique=true, nullable=false)
     private Integer idparticipante;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="corredor_idcorredor", nullable=false)
     private Corredor corredor;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="evento_idevento", nullable=false)
     private Evento evento;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regional_idregional", nullable=false)
    private Regional regional;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="region_idregion", nullable=false)
    private Region region;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_idclub", nullable=false)
    private Club club;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_idcategoria", nullable=false)
    private Categoria categoria;
     private Date fecha;
     private Integer pagado;
     private String nrogiro;
     private Integer costo;
     private Integer dorsal;
     private Integer puesto;
     private Integer puestocat;
     private Integer puntaje;
     private Date tiempo;
     private Integer participo;
     private Integer completo;
     private Integer descalif;
     private BigDecimal promedio;
     private Integer km;
     private Integer orden;
     private Integer puntajeaux;
     private Integer puntua;
     private Integer totalpuntos;
     private Integer acobrar;
     private String tiempos;
     private Integer puntajeclub;

    public Participante() {
    }

	
    public Participante(Corredor corredor, Evento evento, Regional regional, Region region, Club club, Categoria categoria) {
        this.corredor = corredor;
        this.evento = evento;
        this.regional=regional;
        this.region = region;
        this.club = club;
        this.categoria=categoria;
    }
    public Participante(Corredor corredor, Evento evento, Region region, Date fecha, Integer pagado, String nrogiro, Integer costo, Integer dorsal, Integer puesto, Integer puestocat, Integer puntaje, Date tiempo, Integer participo, Integer completo, Integer descalif, BigDecimal promedio, Integer km, Integer orden, Integer puntajeaux, Integer puntua, Integer totalpuntos, Integer acobrar, Regional regional, Club club, Categoria categoria, String tiempos, Integer puntajeclub) {
       this.corredor = corredor;
       this.evento = evento;
        this.region = region;
        this.fecha = fecha;
       this.pagado = pagado;
       this.nrogiro = nrogiro;
       this.costo = costo;
       this.dorsal = dorsal;
       this.puesto = puesto;
       this.puestocat = puestocat;
       this.puntaje = puntaje;
       this.tiempo = tiempo;
       this.participo = participo;
       this.completo = completo;
       this.descalif = descalif;
       this.promedio = promedio;
       this.km = km;
       this.orden = orden;
       this.puntajeaux = puntajeaux;
       this.puntua = puntua;
       this.totalpuntos = totalpuntos;
       this.acobrar = acobrar;
        this.regional=regional;
        this.club = club;
        this.categoria=categoria;
        this.tiempos=tiempos;
        this.puntajeclub = puntajeclub;

    }
   

    public Integer getIdparticipante() {
        return this.idparticipante;
    }
    
    public void setIdparticipante(Integer idparticipante) {
        this.idparticipante = idparticipante;
    }


    public Corredor getCorredor() {
        return this.corredor;
    }
    
    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }


    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }


    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }


    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Categoria getCategoria() {
    return this.categoria;
}

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="pagado")
    public Integer getPagado() {
        return this.pagado;
    }
    
    public void setPagado(Integer pagado) {
        this.pagado = pagado;
    }

    
    @Column(name="nrogiro", length=45)
    public String getNrogiro() {
        return this.nrogiro;
    }
    
    public void setNrogiro(String nrogiro) {
        this.nrogiro = nrogiro;
    }

    
    @Column(name="costo")
    public Integer getCosto() {
        return this.costo;
    }
    
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
    @Column(name="dorsal")
    public Integer getDorsal() {
        return this.dorsal;
    }
    
    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    
    @Column(name="puesto")
    public Integer getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    
    @Column(name="puestocat")
    public Integer getPuestocat() {
        return this.puestocat;
    }
    
    public void setPuestocat(Integer puestocat) {
        this.puestocat = puestocat;
    }

    
    @Column(name="puntaje")
    public Integer getPuntaje() {
        return this.puntaje;
    }
    
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="tiempo", length=8)
    public Date getTiempo() {
        return this.tiempo;
    }
    
    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    
    @Column(name="participo")
    public Integer getParticipo() {
        return this.participo;
    }
    
    public void setParticipo(Integer participo) {
        this.participo = participo;
    }

    
    @Column(name="completo")
    public Integer getCompleto() {
        return this.completo;
    }
    
    public void setCompleto(Integer completo) {
        this.completo = completo;
    }

    
    @Column(name="descalif")
    public Integer getDescalif() {
        return this.descalif;
    }
    
    public void setDescalif(Integer descalif) {
        this.descalif = descalif;
    }

    
    @Column(name="promedio", precision=3, scale=1)
    public BigDecimal getPromedio() {
        return this.promedio;
    }
    
    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    
    @Column(name="km")
    public Integer getKm() {
        return this.km;
    }
    
    public void setKm(Integer km) {
        this.km = km;
    }

    
    @Column(name="orden")
    public Integer getOrden() {
        return this.orden;
    }
    
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    
    @Column(name="puntajeaux")
    public Integer getPuntajeaux() {
        return this.puntajeaux;
    }
    
    public void setPuntajeaux(Integer puntajeaux) {
        this.puntajeaux = puntajeaux;
    }

    
    @Column(name="puntua")
    public Integer getPuntua() {
        return this.puntua;
    }
    
    public void setPuntua(Integer puntua) {
        this.puntua = puntua;
    }

    
    @Column(name="totalpuntos")
    public Integer getTotalpuntos() {
        return this.totalpuntos;
    }
    
    public void setTotalpuntos(Integer totalpuntos) {
        this.totalpuntos = totalpuntos;
    }

    
    @Column(name="acobrar")
    public Integer getAcobrar() {
        return this.acobrar;
    }
    
    public void setAcobrar(Integer acobrar) {
        this.acobrar = acobrar;
    }

    @Column(name="tiempos", length=12)
    public String getTiempos() {
        return tiempos;
    }

    public void setTiempos(String tiempos) {
        this.tiempos = tiempos;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    @Column(name="puntajeclub")
    public Integer getPuntajeclub() {
        return puntajeclub;
    }

    public void setPuntajeclub(Integer puntajeclub) {
        this.puntajeclub = puntajeclub;
    }
}


