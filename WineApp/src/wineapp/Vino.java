package wineapp;

import java.util.ArrayList;
import java.time.LocalDate;
import java.awt.Image;
import javax.persistence.*;
import wineapp.patronStrategy.IEstrategiaCalculoRanking;

@Entity
@Table(name = "Vino")
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "añada")
    private LocalDate añada;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Transient // Las imágenes se manejarán por separado
    private Image imagenEtiqueta;

    @Column(name = "ruta_imagen")
    private String rutaImagenEtiqueta;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "nota_cata_bodega")
    private int notaDeCataBodega;

    @Column(name = "precio_ars")
    private float precioARS;

    @ManyToMany
    @JoinTable(
        name = "vino_maridaje",
        joinColumns = @JoinColumn(name = "vino_id"),
        inverseJoinColumns = @JoinColumn(name = "maridaje_id")
    )
    private ArrayList<Maridaje> maridaje;  // Relación con Maridaje

    @OneToMany(mappedBy = "vino", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Reseña> reseñas = new ArrayList<>();  // Relación con Reseña

    @ManyToMany
    @JoinTable(
        name = "vino_varietal",
        joinColumns = @JoinColumn(name = "vino_id"),
        inverseJoinColumns = @JoinColumn(name = "varietal_id")
    )
    private ArrayList<Varietal> varietal;  // Relación con Varietal

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bodega_id")
    private Bodega bodega;  // Relación con Bodega

    // Constructor por defecto requerido por JPA
    protected Vino() {}

    // Constructor original
    public Vino(LocalDate añada, LocalDate fechaActualizacion, Image imagenEtiqueta, 
                String nombre, int notaDeCataBodega, float precioARS, 
                ArrayList<Maridaje> maridaje, ArrayList<Varietal> varietal, Bodega bodega) {
        this.añada = añada;
        this.fechaActualizacion = fechaActualizacion;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.notaDeCataBodega = notaDeCataBodega;
        this.precioARS = precioARS;
        this.maridaje = maridaje;
        this.varietal = varietal;
        this.bodega = bodega;
    }

    // Getter y setter para el nuevo campo id
    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para el manejo de la ruta de la imagen
    public String getRutaImagenEtiqueta() {
        return rutaImagenEtiqueta;
    }

    public void setRutaImagenEtiqueta(String rutaImagenEtiqueta) {
        this.rutaImagenEtiqueta = rutaImagenEtiqueta;
    }

    // Métodos existentes sin cambios
    public boolean esDeBodega(Bodega bodega){
        return this.bodega.equals(bodega);
    }

    public float calcularPromedioPuntuacion(LocalDate fechaInicio, LocalDate fechaFin, IEstrategiaCalculoRanking estrategia) {
        System.out.println("Adentro del calcularPromedioPuntuacion vino");
        return estrategia.calcularPromedioPuntuacion(reseñas, fechaInicio, fechaFin);
    }
    
    // Resto de getters y setters existentes se mantienen igual
    public LocalDate getAñada() {
        return this.añada;
    }

    public void setAñada(LocalDate añada){
        this.añada = añada;
    }

    public LocalDate getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion){
        this.fechaActualizacion = fechaActualizacion;
    }

    public Image getImagenEtiqueta() {
        return this.imagenEtiqueta;
    }

    public void setImagenEtiqueta(Image imagenEtiqueta){
        this.imagenEtiqueta = imagenEtiqueta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getnotaDeCataBodega() {
        return this.notaDeCataBodega;
    }

    public void setnotaDeCataBodega(int notaDeCataBodega){
        this.notaDeCataBodega = notaDeCataBodega;
    }

    public float getPrecioARS() {
        return this.precioARS;
    }

    public void setPrecioARS(float precioARS){
        this.precioARS = precioARS;
    }

    public ArrayList<Maridaje> getMaridaje() {
        return this.maridaje;
    }

    public void setMaridaje(ArrayList<Maridaje> maridaje){
        this.maridaje = maridaje;
    }

    public ArrayList<Reseña> getReseña() {
        return this.reseñas;
    }

    public void setReseña(ArrayList<Reseña> reseña){
        this.reseñas = reseña;
    }

    public ArrayList<Varietal> getVarietal() {
        return this.varietal;
    }

    public void setVarietal(ArrayList<Varietal> varietal){
        this.varietal = varietal;
    }

    public ArrayList<String> getDescripcionVarietal(){
        ArrayList<String> descripcionVarietales = new ArrayList<>();
        for (Varietal varietal : varietal) {
            descripcionVarietales.add(varietal.getDescripcion());
        }
        return descripcionVarietales;
    }

    public Bodega getBodega(){
        return this.bodega;
    }

    public void setBodega(Bodega bodega){
        this.bodega = bodega;
    }

    public String getNombreBodega(){
        return this.bodega.getNombre();
    }

    public RegionVitivinicola getNombreRegionVitivinicola(){
        return this.bodega.getNombreRegionVitivinicola();
    }

    public ArrayList<String> getProcedencia(){
        return this.bodega.getProcedencia();
    }
}