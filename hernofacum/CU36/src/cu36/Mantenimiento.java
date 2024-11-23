package cu36;

import java.time.LocalDate;

public class Mantenimiento {
    private LocalDate fechaFin;
    private LocalDate fechaInicio;
    private LocalDate fechaInicioPrevista;
    private String motivoMantenimiento;


    public Mantenimiento(LocalDate fechaFin, String motivo) {
        this.fechaFin = fechaFin;
        this.motivoMantenimiento = motivo;
    }

    public void calcularDuracionTotal(){

    }

    public boolean esPreventivo(){
        return false;
    }

    public void extender(){

    }

    public void finalizar(){

    }

    public void iniciar(){

    }

    public void mostrarMantenimiento(){

    }



    //GETTERS Y SETTERS

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaInicioPrevista() {
        return this.fechaInicioPrevista;
    }

    public void setFechaInicioPrevista(LocalDate fechaInicioPrevista) {
        this.fechaInicioPrevista = fechaInicioPrevista;
    }

    public String getMotivoMantenimiento() {
        return this.motivoMantenimiento;
    }

    public void setMotivoMantenimiento(String motivoMantenimiento) {
        this.motivoMantenimiento = motivoMantenimiento;
    }

    
}
