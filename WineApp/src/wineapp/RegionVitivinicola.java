package wineapp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "RegionVitivinicola")
public class RegionVitivinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;  // Relación con Provincia

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bodega> bodegas = new ArrayList<>();  // Relación con Bodega

    // Constructor vacío requerido por JPA
    protected RegionVitivinicola() {}

    public RegionVitivinicola(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    public ArrayList<String> getProcedencia(){
        ArrayList<String> procedencia = new ArrayList<>();
        procedencia.add(this.provincia.getNombre());
        procedencia.add(this.provincia.getNombrePais());
        return procedencia;
    }
}
