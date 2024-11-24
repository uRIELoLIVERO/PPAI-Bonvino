package wineapp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reseña")
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comentario;

    @Column(name = "es_premium", nullable = false)
    private boolean esPremium;

    @Column(name = "fecha_reseña", nullable = false)
    private LocalDate fechaReseña;

    @Column(nullable = false)
    private float puntaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vino_id")
    private Vino vino;

    // Constructor vacío requerido por JPA
    protected Reseña() {}

    public Reseña(String comentario, boolean esPremium, float puntaje, LocalDate fechaReseña, Vino vino) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.puntaje = puntaje;
        this.fechaReseña = fechaReseña;
        this.vino = vino;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
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
}
