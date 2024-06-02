public class Maridaje {
    private String descripcion;
    private String nombre;

    public Maridaje(String descripcion, String nombre){
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    //descripcion
    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getDescripcion (){
        return this.descripcion;
    }
    //nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
