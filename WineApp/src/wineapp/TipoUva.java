package wineapp;
public class TipoUva {
    private String descripcion;
    private String nombre;

    public TipoUva (String descripcion, String nombre){
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getNombre(){
        return nombre;
    }
}