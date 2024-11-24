package wineapp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "TipoUva")
public class TipoUva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoUva", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Varietal> varietales = new ArrayList<>();  // Relación con Varietal

    // Constructor y getters/setters omitidos para brevedad

    // Constructor vacío requerido por JPA
    protected TipoUva() {}

    public TipoUva(String descripcion, String nombre) {
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
