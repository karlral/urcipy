package com.sistema.urcipy.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="corredor"
    ,catalog="urcipy"
)
public class Corredor   {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idcorredor", unique=true, nullable=false)
     private Integer idcorredor;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="persona_idpersona", nullable=false)
    private Persona persona;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="club_idclub", nullable=false)
    private Club club;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_idcategoria", nullable=false)
     private Categoria categoria;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_idusuario", nullable=false)
     private Usuario usuario;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regional_idregional", nullable=false)
    private Regional regional;
     private Byte verificar;
     private String carnet;
    private String carnetatras;
     private Byte tipocat;
     private Integer licencia;
     private Boolean modificar;
     private Integer puntua;
     private Date fecmodi;
     private Integer montopuntua;
     private Byte carnetfpc;
    private String observacion;
    private Boolean catalianza;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="corredor")
    @JsonIgnore
     private Set<Imc> imcs = new HashSet<Imc>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="corredor")
    @JsonIgnore
     private Set<Participante> participantes = new HashSet<Participante>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="corredor")
    @JsonIgnore
     private Set<Miembros> miembroses = new HashSet<Miembros>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="corredor")
    @JsonIgnore
    private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);

    public Corredor() {
    }

    public Corredor(Persona persona, Club club, Categoria categoria,  Usuario usuario, Regional regional) {
        this.persona = persona;
        this.club = club;
        this.categoria = categoria;
        this.usuario = usuario;
        this.regional = regional;
    }


    public Corredor(Persona persona, Club club, Categoria categoria, Usuario usuario, Regional regional, Byte verificar, String carnet, String carnetatras, Byte tipocat, Integer licencia, Boolean modificar, Integer puntua, Date fecmodi, Integer montopuntua, Byte carnetfpc, String observacion, Boolean catalianza, Set<Imc> imcs, Set<Participante> participantes, Set<Miembros> miembroses, Set<Movimiento> movimientos) {
        this.persona = persona;
        this.club = club;
        this.categoria = categoria;
        this.usuario = usuario;
        this.regional = regional;
        this.verificar = verificar;
        this.carnet = carnet;
        this.carnetatras = carnetatras;
        this.tipocat = tipocat;
        this.licencia = licencia;
        this.modificar = modificar;
        this.puntua = puntua;
        this.fecmodi = fecmodi;
        this.montopuntua = montopuntua;
        this.carnetfpc = carnetfpc;
        this.observacion = observacion;
        this.catalianza = catalianza;
        this.imcs = imcs;
        this.participantes = participantes;
        this.miembroses = miembroses;
        this.movimientos=movimientos;
    }

    public Integer getIdcorredor() {
        return this.idcorredor;
    }

    public void setIdcorredor(Integer idcorredor) {
        this.idcorredor = idcorredor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Club getClub() { return club;}

    public void setClub(Club club) {this.club = club;}

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(name="verificar")
    public Byte getVerificar() {
        return verificar;
    }

    public void setVerificar(Byte verificar) {
        this.verificar = verificar;
    }

    @Column(name="carnet", length=45)
    public String getCarnet() {
        return this.carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    @Column(name="carnetatras", length=45)
    public String getCarnetatras() {
        return carnetatras;
    }

    public void setCarnetatras(String carnetatras) {
        this.carnetatras = carnetatras;
    }

    @Column(name="tipocat")
    public Byte getTipocat() {
        return this.tipocat;
    }

    public void setTipocat(Byte tipocat) {
        this.tipocat = tipocat;
    }

    @Column(name="licencia")
    public Integer getLicencia() {
        return this.licencia;
    }

    public void setLicencia(Integer licencia) {
        this.licencia = licencia;
    }

    @Column(name="modificar")
    public Boolean getModificar() {
        return this.modificar;
    }

    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }

    @Column(name="puntua")
    public Integer getPuntua() {
        return this.puntua;
    }

    public void setPuntua(Integer puntua) {
        this.puntua = puntua;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecmodi", length=19)
    public Date getFecmodi() {
        return this.fecmodi;
    }

    public void setFecmodi(Date fecmodi) {
        this.fecmodi = fecmodi;
    }


    @Column(name="montopuntua")
    public Integer getMontopuntua() {
        return this.montopuntua;
    }

    public void setMontopuntua(Integer montopuntua) {
        this.montopuntua = montopuntua;
    }


    @Column(name="carnetfpc")
    public Byte getCarnetfpc() {
        return this.carnetfpc;
    }

    public void setCarnetfpc(Byte carnetfpc) {
        this.carnetfpc = carnetfpc;
    }
    @Column(name="observacion", length=100)
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Set<Imc> getImcs() {
        return this.imcs;
    }
    
    public void setImcs(Set<Imc> imcs) {
        this.imcs = imcs;
    }


    public Set<Participante> getParticipantes() {
        return this.participantes;
    }
    
    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }


    public Set<Miembros> getMiembroses() {
        return this.miembroses;
    }
    
    public void setMiembroses(Set<Miembros> miembroses) {
        this.miembroses = miembroses;
    }


    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    public Boolean getCatalianza() {
        return catalianza;
    }

    public void setCatalianza(Boolean catalianza) {
        this.catalianza = catalianza;
    }

    public Set<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}


