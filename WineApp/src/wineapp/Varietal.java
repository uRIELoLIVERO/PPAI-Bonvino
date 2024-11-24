package wineapp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Varietal")
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(name = "porcentaje_composicion", nullable = false)
    private int porcentajeComposicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_uva_id")
    private TipoUva tipoUva;  // Relación con TipoUva

    @ManyToMany(mappedBy = "varietal")
    private List<Vino> vinos = new ArrayList<>();  // Relación con Vino




    // Constructor vacío requerido por JPA
    protected Varietal() {}

    public Varietal(String descripcion, int porcentajeComposicion, TipoUva tipoUva) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
        this.tipoUva = tipoUva;
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

    public int getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setPorcentajeComposicion(int porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public TipoUva getTipoUva() {
        return tipoUva;
    }

    public void setTipoUva(TipoUva tipoUva) {
        this.tipoUva = tipoUva;
    }
}
