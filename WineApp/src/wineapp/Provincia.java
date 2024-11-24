package wineapp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    private Pais pais;  // Relación con Pais

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegionVitivinicola> regiones = new ArrayList<>();  // Relación con RegionVitivinicola

    // Constructor vacío requerido por JPA
    protected Provincia(String mendoza, ArrayList<RegionVitivinicola> regionesMendoza) {}

    public Provincia(String nombre) {
        this.nombre = nombre;
    }
    public String getNombrePais(){
        return this.pais.getNombre();
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

    public List<RegionVitivinicola> getRegiones() {
        return regiones;
    }

    public void setRegiones(List<RegionVitivinicola> regiones) {
        this.regiones = regiones;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
