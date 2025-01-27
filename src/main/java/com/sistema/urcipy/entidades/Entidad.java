package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad generated by hbm2java
 */
@Entity
@Table(name="entidad"
    ,catalog="urcipy"
)
public class Entidad  {


     private Integer identidad;
     private String nombre;
     private String telefono;
     private String direccion;
     private String email;
     private Integer ano;
     private String presentacion;
     private String quien;
     private String clubes;
     private String icono;
     private String logo;
     private String frenteabajo1;
     private String frenteabajo2;
     private String frenteabajo3;
     private Integer avisoactivo;
     private String avisoruta;

    public Entidad() {
    }

    public Entidad(String nombre, String telefono, String direccion, String email, Integer ano, String presentacion, String quien, String clubes, String icono, String logo, String frenteabajo1, String frenteabajo2, String frenteabajo3, Integer avisoactivo, String avisoruta) {
       this.nombre = nombre;
       this.telefono = telefono;
       this.direccion = direccion;
       this.email = email;
       this.ano = ano;
       this.presentacion = presentacion;
       this.quien = quien;
       this.clubes = clubes;
       this.icono = icono;
       this.logo = logo;
       this.frenteabajo1 = frenteabajo1;
       this.frenteabajo2 = frenteabajo2;
       this.frenteabajo3 = frenteabajo3;
       this.avisoactivo = avisoactivo;
       this.avisoruta = avisoruta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="identidad", unique=true, nullable=false)
    public Integer getIdentidad() {
        return this.identidad;
    }
    
    public void setIdentidad(Integer identidad) {
        this.identidad = identidad;
    }

    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="telefono", length=45)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="direccion", length=45)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="email", length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="ano")
    public Integer getAno() {
        return this.ano;
    }
    
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    
    @Column(name="presentacion", length=65535)
    public String getPresentacion() {
        return this.presentacion;
    }
    
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    
    @Column(name="quien", length=45)
    public String getQuien() {
        return this.quien;
    }
    
    public void setQuien(String quien) {
        this.quien = quien;
    }

    
    @Column(name="clubes", length=45)
    public String getClubes() {
        return this.clubes;
    }
    
    public void setClubes(String clubes) {
        this.clubes = clubes;
    }

    
    @Column(name="icono", length=45)
    public String getIcono() {
        return this.icono;
    }
    
    public void setIcono(String icono) {
        this.icono = icono;
    }

    
    @Column(name="logo", length=45)
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    
    @Column(name="frenteabajo1", length=45)
    public String getFrenteabajo1() {
        return this.frenteabajo1;
    }
    
    public void setFrenteabajo1(String frenteabajo1) {
        this.frenteabajo1 = frenteabajo1;
    }

    
    @Column(name="frenteabajo2", length=45)
    public String getFrenteabajo2() {
        return this.frenteabajo2;
    }
    
    public void setFrenteabajo2(String frenteabajo2) {
        this.frenteabajo2 = frenteabajo2;
    }

    
    @Column(name="frenteabajo3", length=45)
    public String getFrenteabajo3() {
        return this.frenteabajo3;
    }
    
    public void setFrenteabajo3(String frenteabajo3) {
        this.frenteabajo3 = frenteabajo3;
    }

    
    @Column(name="avisoactivo")
    public Integer getAvisoactivo() {
        return this.avisoactivo;
    }
    
    public void setAvisoactivo(Integer avisoactivo) {
        this.avisoactivo = avisoactivo;
    }

    
    @Column(name="avisoruta", length=45)
    public String getAvisoruta() {
        return this.avisoruta;
    }
    
    public void setAvisoruta(String avisoruta) {
        this.avisoruta = avisoruta;
    }




}


