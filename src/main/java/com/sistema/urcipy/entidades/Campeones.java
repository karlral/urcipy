package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="campeones"
    ,catalog="urcipy"
)
public class Campeones  {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idcampeones", unique=true, nullable=false)
     private Integer idcampeones;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoriah_idcategoriah", nullable=false)
     private Categoriah categoriah;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_idclub", nullable=false)
     private Club club;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regional_idregional", nullable=false)
     private Regional regional;
     private String nombre;
     private String apellido;
     private String nacionalidad;
     private Integer ano;
     private Integer peso;
     private Integer altura;
     private String bici;
     private String velmedia;
     private Integer puntos;
     private Integer puesto;
     private String rutabici;
     private String ruta;
     private Double promedio;
     private Integer kmts;
     private Integer cantidad;

    public Campeones() {
    }

	
    public Campeones(Categoriah categoriah, Club club, Regional regional) {
        this.categoriah = categoriah;
        this.club = club;
        this.regional = regional;
    }
    public Campeones(Categoriah categoriah, Club club, Regional regional, String nombre, String apellido, String nacionalidad, Integer ano, Integer peso, Integer altura, String bici, String velmedia, Integer puntos, Integer puesto, String rutabici, String ruta, Double promedio, Integer kmts, Integer cantidad) {
       this.categoriah = categoriah;
       this.club = club;
       this.regional = regional;
       this.nombre = nombre;
       this.apellido = apellido;
       this.nacionalidad = nacionalidad;
       this.ano = ano;
       this.peso = peso;
       this.altura = altura;
       this.bici = bici;
       this.velmedia = velmedia;
       this.puntos = puntos;
       this.puesto = puesto;
       this.rutabici = rutabici;
       this.ruta = ruta;
       this.promedio = promedio;
       this.kmts = kmts;
       this.cantidad = cantidad;
    }

    public Integer getIdcampeones() {
        return this.idcampeones;
    }
    
    public void setIdcampeones(Integer idcampeones) {
        this.idcampeones = idcampeones;
    }


    public Categoriah getCategoriah() {
        return this.categoriah;
    }
    
    public void setCategoriah(Categoriah categoriah) {
        this.categoriah = categoriah;
    }


    public Club getClub() {
        return this.club;
    }
    
    public void setClub(Club club) {
        this.club = club;
    }


    public Regional getRegional() {
        return this.regional;
    }
    
    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", length=45)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="nacionalidad", length=45)
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    
    @Column(name="ano")
    public Integer getAno() {
        return this.ano;
    }
    
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    
    @Column(name="peso")
    public Integer getPeso() {
        return this.peso;
    }
    
    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    
    @Column(name="altura")
    public Integer getAltura() {
        return this.altura;
    }
    
    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    
    @Column(name="bici", length=45)
    public String getBici() {
        return this.bici;
    }
    
    public void setBici(String bici) {
        this.bici = bici;
    }

    
    @Column(name="velmedia", length=45)
    public String getVelmedia() {
        return this.velmedia;
    }
    
    public void setVelmedia(String velmedia) {
        this.velmedia = velmedia;
    }

    
    @Column(name="puntos")
    public Integer getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    
    @Column(name="puesto")
    public Integer getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    
    @Column(name="rutabici", length=45)
    public String getRutabici() {
        return this.rutabici;
    }
    
    public void setRutabici(String rutabici) {
        this.rutabici = rutabici;
    }

    
    @Column(name="ruta", length=45)
    public String getRuta() {
        return this.ruta;
    }
    
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
    @Column(name="promedio", precision=22, scale=0)
    public Double getPromedio() {
        return this.promedio;
    }
    
    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    
    @Column(name="kmts")
    public Integer getKmts() {
        return this.kmts;
    }
    
    public void setKmts(Integer kmts) {
        this.kmts = kmts;
    }

    
    @Column(name="cantidad")
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }




}


