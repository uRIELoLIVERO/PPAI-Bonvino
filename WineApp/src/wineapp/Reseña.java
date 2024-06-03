package wineapp;
import java.time.LocalDate;

public class Reseña {
    private String comentario;
    private boolean esPremium;
    private LocalDate fechaReseña;
    private float puntaje;
    private Vino vino;

    public Reseña(String comentario, boolean esPremium, float puntaje, LocalDate fechaReseña, Vino vino) {
       this.comentario = comentario;
       this.esPremium = esPremium;
       this.puntaje = puntaje;
       this.fechaReseña = fechaReseña;
       this.vino = vino;
    }

    public boolean esDePeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
    return !(fechaReseña.isBefore(fechaInicio) || fechaReseña.isAfter(fechaFin));
    }


    public boolean sosDeSomelier(){
        if (this.esPremium) {
            return true;
        } else {
            return false;
        }
    }

    public float getPuntaje (){
        return this.puntaje;
    }

    public boolean esPremium() {
        if (this.esPremium){
            return true;
        } else {
            return false;
        }
    }

    public void sosDeEnofilo(){
    }

    public void setComentario(String comentario){
        this.comentario = comentario;
    }

    public String getComentario(){
        return this.comentario;
    }

    public Vino getVino(){
        return this.vino;
    }

    public void setVino(Vino vino){
        this.vino = vino;
    }
}
