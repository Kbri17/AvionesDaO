package model;

import java.time.LocalDate;

public class Avion {

    private Integer id;
    private String marca;
    private String modelo;
    private String matricula;

    private LocalDate fechaEntradaServicio;

    public Avion(String marca, String modelo, String matricula, LocalDate fechaEntradaServicio) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    public Avion(Integer id, String marca, String modelo, String matricula, LocalDate fechaEntradaServicio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.fechaEntradaServicio = fechaEntradaServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getFechaEntradaServicio() {
        return fechaEntradaServicio;
    }

    public void setFechaEntradaServicio(LocalDate fechaEntradaServicio) {
        this.fechaEntradaServicio = fechaEntradaServicio;
    }
}
