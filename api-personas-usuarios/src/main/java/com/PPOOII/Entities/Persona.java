package com.PPOOII.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table(name = "persona", schema = "PPOOII")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identificacion", nullable = false, unique = true)
    private Integer identificacion;

    @Column(name = "pnombre", nullable = false)
    private String pnombre;

    @Column(name = "snombre")
    private String snombre;

    @Column(name = "papellido", nullable = false)
    private String papellido;

    @Column(name = "sapellido")
    private String sapellido;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "fechanacimiento", nullable = false)
    private LocalDate fechanacimiento;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "edadclinica", nullable = false)
    private String edadclinica;

    public Persona() {}

    public Persona(Integer identificacion, String pnombre, String snombre, String papellido, 
                   String sapellido, String email, LocalDate fechanacimiento) {
        this.identificacion = identificacion;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.papellido = papellido;
        this.sapellido = sapellido;
        this.email = email;
        this.fechanacimiento = fechanacimiento;
        calcularEdad(); // Calcula automáticamente edad y edad clínica
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
        calcularEdad(); // Recalcula la edad si cambia la fecha de nacimiento
    }

    public int getEdad() {
        return edad;
    }

    public String getEdadclinica() {
        return edadclinica;
    }

    /**
     * Calcula la edad y la edad clínica basándose en la fecha de nacimiento.
     */
    private void calcularEdad() {
        if (this.fechanacimiento != null) {
            LocalDate hoy = LocalDate.now();
            Period periodo = Period.between(this.fechanacimiento, hoy);
            this.edad = periodo.getYears();
            this.edadclinica = periodo.getYears() + " años " + periodo.getMonths() + " meses " + periodo.getDays() + " días";
        }
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", identificacion=" + identificacion + ", nombre=" + pnombre + " " + snombre +
               ", apellido=" + papellido + " " + sapellido + ", email=" + email + ", fechanacimiento=" + fechanacimiento +
               ", edad=" + edad + ", edadclinica=" + edadclinica + "]";
    }
}