package wineapp;
import java.util.ArrayList;
import java.time.LocalDate;
import java.awt.Image;

public class Vino {
    private LocalDate añada;
    private LocalDate fechaActualizacion;
    private Image imagenEtiqueta;
    private String nombre;
    private int notaDeCataBodega;
    private float precioARS;
    private ArrayList<Maridaje> maridaje;
    private ArrayList<Reseña> reseñas = new ArrayList<>();
    private ArrayList<Varietal> varietal;
    private Bodega bodega;

    public Vino(LocalDate añada, LocalDate fechaActualizacion, Image imagenEtiqueta, String nombre, int notaDeCataBodega, float precioARS, ArrayList<Maridaje> maridaje, ArrayList<Varietal> varietal, Bodega bodega) {
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

    public boolean esDeBodega(Bodega bodega){
        return this.bodega.equals(bodega);
    }

    public float calcularPromedioPuntuacion(LocalDate fechaInicioRanking, LocalDate fechaFinRanking) {
        System.out.println("ESTOY DENTRO DE CALCULARRRRRRRRRRRR PROM"+ this.nombre);
        float acumulador = 0f;
        int cantidad = 0;
        for (Reseña reseña : reseñas) {
            if (reseña.esDePeriodo(fechaInicioRanking, fechaFinRanking) && reseña.sosDeSomelier()) {
                acumulador += reseña.getPuntaje();
                cantidad++;
            }
        }
        if (cantidad == 0) {
            return 0; 
        } else {
            return acumulador / cantidad;
        }
        
    }
    
    // añada
    public LocalDate getAñada() {
        return this.añada;
    }

    public void setAñada(LocalDate añada){
        this.añada = añada;
    }
    // fechaActualizacion
    public LocalDate getFechaActualizacion() {
        return this.fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion){
        this.fechaActualizacion = fechaActualizacion;
    }
    // imagenEtiqueta
    public Image getImagenEtiqueta() {
        return this.imagenEtiqueta;
    }

    public void setImagenEtiqueta(Image imagenEtiqueta){
        this.imagenEtiqueta = imagenEtiqueta;
    }
    // nombre
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    // nota de cata bodega
    public int getnotaDeCataBodega() {
        return this.notaDeCataBodega;
    }

    public void setnotaDeCataBodega(int notaDeCataBodega){
        this.notaDeCataBodega = notaDeCataBodega;
    }
    // precio ARS
    public float getPrecioARS() {
        return this.precioARS;
    }

    public void setPrecioARS(float precioARS){
        this.precioARS = precioARS;
    }
    //maridaje
    public ArrayList<Maridaje> getMaridaje() {
        return this.maridaje;
    }

    public void setMaridaje(ArrayList<Maridaje> maridaje){
        this.maridaje = maridaje;
    }
    //reseña
    public ArrayList<Reseña> getReseña() {
        return this.reseñas;
    }

    public void setReseña(ArrayList<Reseña> reseña){
        this.reseñas = reseña;
    }
    // varietal
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

    // bodega
    public Bodega getBodega(){
        return this.bodega;
    }

    public void setBodega(Bodega bodega){
        this.bodega = bodega;
    }
    public String getNombreBodega(){
        return this.bodega.getNombre();
    }

    public String getNombreRegionVitivinicola(){
        return this.bodega.getNombreRegionVitivinicola();
    }

    public ArrayList<String> getProcedencia(){
        return this.bodega.getProcedencia();
    }
}