package wineapp;
import java.util.ArrayList;

public class Provincia {
    private String nombre;
    private ArrayList <RegionVitivinicola> regionVitivinicola;
    private Pais pais;

    public Provincia (String nombre, ArrayList <RegionVitivinicola> regionVitivinicola){
        this.nombre = nombre;
        this.regionVitivinicola = regionVitivinicola;
    }

    
    public String getNombre(){
        return this.nombre;
    }

    public String getNombrePais(){
        return this.pais.getNombre();
    }

    public int contarRegiones(){
        return this.regionVitivinicola.size();
    }
    
    public void setPais(Pais pais){
        this.pais = pais;
    }
    //HACER REGION VITIVINICOLA

}