package com.sistema.urcipy.entidades;
// Generated 09/02/2023 11:28:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cargo generated by hbm2java
 */
@Entity
@Table(name="cargo"
    ,catalog="urcipy"
)
public class Cargo   {


     private Integer idcargo;
     private String nomcargo;
     private Set<Miembros> miembroses = new HashSet<Miembros>(0);

    public Cargo() {
    }

    public Cargo(String nomcargo, Set<Miembros> miembroses) {
       this.nomcargo = nomcargo;
       this.miembroses = miembroses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcargo", unique=true, nullable=false)
    public Integer getIdcargo() {
        return this.idcargo;
    }
    
    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    
    @Column(name="nomcargo", length=45)
    public String getNomcargo() {
        return this.nomcargo;
    }
    
    public void setNomcargo(String nomcargo) {
        this.nomcargo = nomcargo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cargo")
    public Set<Miembros> getMiembroses() {
        return this.miembroses;
    }
    
    public void setMiembroses(Set<Miembros> miembroses) {
        this.miembroses = miembroses;
    }




}


