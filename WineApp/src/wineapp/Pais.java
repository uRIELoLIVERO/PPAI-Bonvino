import java.util.ArrayList;

public class Pais{
    private String nombre;
    private ArrayList <Provincia> provincia;

    public Pais (String nombre, ArrayList <Provincia> provincia){
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setProvincia (ArrayList <Provincia> provincia){
        this.provincia = provincia;
    }

    public ArrayList<Provincia> getProvincia(){
        return this.provincia;
    }
}