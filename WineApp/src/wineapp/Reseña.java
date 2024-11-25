package wineapp;

import java.time.LocalDate;

public class Reseña {
    private int vinoId;
    private float puntaje;
    private boolean esPremium;
    private LocalDate fechaReseña;

    // Constructor
    public Reseña(int vinoId, float puntaje, boolean esPremium, LocalDate fechaReseña) {
        this.vinoId = vinoId;
        this.puntaje = puntaje;
        this.esPremium = esPremium;
        this.fechaReseña = fechaReseña;
    }

    // Getters y setters
    public int getVinoId() {
        return vinoId;
    }

    public void setVinoId(int vinoId) {
        this.vinoId = vinoId;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public LocalDate getFechaReseña() {
        return fechaReseña;
    }

    public void setFechaReseña(LocalDate fechaReseña) {
        this.fechaReseña = fechaReseña;
    }
    
    public boolean esDePeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
    return !(fechaReseña.isBefore(fechaInicio) || fechaReseña.isAfter(fechaFin));
    }
    
    public boolean sosDeSommelier(){
        if (this.esPremium) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Reseña{" +
                "vinoId=" + vinoId +
                ", puntaje=" + puntaje +
                ", esPremium=" + esPremium +
                ", fechaReseña=" + fechaReseña +
                '}';
    }
}

