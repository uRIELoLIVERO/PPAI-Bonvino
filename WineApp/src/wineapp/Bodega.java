package wineapp;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bodega {
    private int coordenadasUbicacion;
    private String descripcion;
    private String historia;
    private String novedad;
    private String nombre;
    private LocalDate periodoActualizacion;
    private RegionVitivinicola region;

    public Bodega(int coordenadasUbicacion, String descripcion, String historia, String novedad, String nombre, LocalDate periodoActualizacion, RegionVitivinicola region){
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.novedad = novedad;
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
        this.region = region;
    }
    
    public String getNombreRegionVitivinicola(){
        return this.region.getNombre();
    }

    public ArrayList<String> getProcedencia(){
        return this.region.getProcedencia();
    }
    //coordenadasUbicacion
    public int getCoordenadasUbicacion(){
        return this.coordenadasUbicacion;
    }

    public void setCoordenadasUbicacion(int coordenadasUbicacion){
        this.coordenadasUbicacion = coordenadasUbicacion;
    }
    //descripcion
    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    //historia
    public String getHistoria(){
        return this.historia;
    }
    public void setHistoria(String historia){
        this.historia = historia;
    }
    //novedad
    public String getNovedad(){
        return this.novedad;
    }
    public void setNovedad(String novedad){
        this.novedad = novedad;
    }
    //nombre
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //periodoActualizacion
    public LocalDate getPeriodoActualizacion(){
        return this.periodoActualizacion;
    }
    public void setPeriodoActulizacion(LocalDate periodoActualizacion){
        this.periodoActualizacion = periodoActualizacion;
    }
    // regionvitinicola
    public RegionVitivinicola getRegion(){
        return this.region;
    }
    public void setRegion(RegionVitivinicola region){
        this.region = region;
    }

}
