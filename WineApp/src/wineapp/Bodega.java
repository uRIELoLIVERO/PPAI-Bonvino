package wineapp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coordenadas_ubicacion", nullable = false)
    private int coordenadasUbicacion;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String historia;

    @Column(nullable = true)
    private String novedad;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "periodo_actualizacion")
    private LocalDate periodoActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionVitivinicola region;  // Relación con RegionVitivinicola

    @OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vino> vinos = new ArrayList<>();  // Relación con Vino

    // Constructor vacío requerido por JPA
    protected Bodega(int par, String bodega_Los_Andes, String historia_de_la_bodega_Los_Andes, String los_Andes, LocalDate now, RegionVitivinicola regionValleDeUco) {}

    public Bodega(int coordenadasUbicacion, String descripcion, String historia, String novedad,
                  String nombre, LocalDate periodoActualizacion, RegionVitivinicola region) {
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.novedad = novedad;
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
        this.region = region;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }
    public ArrayList<String> getProcedencia(){
        return this.region.getProcedencia();
    }

    public int getCoordenadasUbicacion() {
        return coordenadasUbicacion;
    }

    public void setCoordenadasUbicacion(int coordenadasUbicacion) {
        this.coordenadasUbicacion = coordenadasUbicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getPeriodoActualizacion() {
        return periodoActualizacion;
    }

    public void setPeriodoActualizacion(LocalDate periodoActualizacion) {
        this.periodoActualizacion = periodoActualizacion;
    }

    public RegionVitivinicola getNombreRegionVitivinicola() {
        return region;
    }

    public void setRegion(RegionVitivinicola region) {
        this.region = region;
    }
}
