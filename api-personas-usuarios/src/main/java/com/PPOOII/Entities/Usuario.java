package com.PPOOII.Entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario", schema = "PPOOII")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idpersona")
    private Long idPersona;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    @MapsId // Indica que este campo es la clave primaria y FK al mismo tiempo
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    private Persona persona;

    public Usuario() {}

    public Usuario(Persona persona, String login, String password) {
        this.persona = persona;
        this.idPersona = persona.getId();
        this.login = login;
        this.password = password;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
        this.idPersona = persona.getId();
    }
}