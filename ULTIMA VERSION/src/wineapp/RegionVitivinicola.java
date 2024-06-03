package wineapp;
import java.util.ArrayList;

public class RegionVitivinicola {
    private String nombre;
    private String descripcion;
    private Provincia provincia;

    public RegionVitivinicola (String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<String> getProcedencia(){
        ArrayList<String> procedencia = new ArrayList<>();
        procedencia.add(this.provincia.getNombre());
        procedencia.add(this.provincia.getNombrePais());
        return procedencia;
    }

    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion (){
        return this.descripcion;
    }
}