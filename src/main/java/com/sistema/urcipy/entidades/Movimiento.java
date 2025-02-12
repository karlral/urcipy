package com.sistema.urcipy.entidades;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="movimiento"
    ,catalog="urcipy"
)
public class Movimiento  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmovimiento", unique=true, nullable=false)
     private int idmovimiento;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="concepto_idconcepto", nullable=false)
    private Concepto concepto;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="corredor_idcorredor", nullable=false)
    private Corredor corredor;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_idusuario", nullable=false)
     private Usuario usuario;
     private Date fecha;
     private Integer entrada;
     private Integer salida;

    public Movimiento() {
    }

	
    public Movimiento(Concepto concepto,  Corredor corredor, Usuario usuario) {

        this.concepto = concepto;

        this.corredor = corredor;
        this.usuario = usuario;
    }
    public Movimiento(Concepto concepto,  Corredor corredor, Usuario usuario, Date fecha, Integer entrada, Integer salida) {

       this.concepto = concepto;

        this.corredor = corredor;
        this.usuario = usuario;
       this.fecha = fecha;
       this.entrada = entrada;
       this.salida = salida;
    }
   

    public int getIdmovimiento() {
        return this.idmovimiento;
    }
    
    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public Concepto getConcepto() {
        return this.concepto;
    }
    
    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }



    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="entrada")
    public Integer getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    
    @Column(name="salida")
    public Integer getSalida() {
        return this.salida;
    }
    
    public void setSalida(Integer salida) {
        this.salida = salida;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }
}


