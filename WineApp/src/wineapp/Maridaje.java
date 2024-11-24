package wineapp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Maridaje")
public class Maridaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "maridaje")
    private List<Vino> vinos = new ArrayList<>();  // Relación con Vino

    // Constructor vacío requerido por JPA
    protected Maridaje() {}

    public Maridaje(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
