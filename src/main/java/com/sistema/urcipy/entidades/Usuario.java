package com.sistema.urcipy.entidades;
// Generated 03/02/2023 12:59:13 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="usuario"
    ,catalog="urcipy"
)
public class Usuario  implements Serializable, UserDetails {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idusuario", unique=true, nullable=false)

    private Integer idusuario;

    private String nombre;
     private String apellido;
     private String telefono;
     private String perfil;
     private String email;
     private String username;
     private String password;
     private Boolean enabled;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    @JsonIgnore
     private Set<Movimiento> movimientos = new HashSet<>(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    @JsonIgnore
     private Set<Corredor> corredors = new HashSet<>(0);
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="usuario")
    @JsonIgnore
     private Set<UsuarioRol> usuarioRols = new HashSet<>();
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="regional_idregional", nullable=false)
    @JsonIgnore
    private Regional regional;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String telefono, String perfil, String email, String username, String password, Boolean enabled, Set<Movimiento> movimientos, Set<Corredor> corredors, Set<UsuarioRol> usuarioRols, Regional regional) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.telefono = telefono;
       this.perfil = perfil;
       this.email = email;
       this.username = username;
       this.password = password;
       this.enabled = enabled;
       this.movimientos = movimientos;
       this.corredors = corredors;
       this.usuarioRols = usuarioRols;
       this.regional=regional;
    }

    public Integer getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
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


    @Column(name="telefono", length=45)
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Column(name="perfil")
    public String getPerfil() {
        return this.perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }


    @Column(name="email", length=60)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name="username", length=20)
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades=new HashSet<>();
        this.usuarioRols.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getNombre()));

        });
        return autoridades;
    }

    @Column(name="password", length=255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name="enabled")
    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Movimiento> getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }


    public Set<Corredor> getCorredors() {
        return this.corredors;
    }

    public void setCorredors(Set<Corredor> corredors) {
        this.corredors = corredors;
    }

    public Set<UsuarioRol> getUsuarioRols() {
        return this.usuarioRols;
    }

    public void setUsuarioRols(Set<UsuarioRol> usuarioRols) {
        this.usuarioRols = usuarioRols;
    }

    public Regional getRegional() {
        return regional;
    }

    public void setRegional(Regional regional) {
        this.regional = regional;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", perfil='" + perfil + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}


