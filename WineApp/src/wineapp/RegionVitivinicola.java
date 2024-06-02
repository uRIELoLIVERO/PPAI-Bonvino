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


    //VER COMO SE IMPLEMENTA
    public void getProcedencia(){

    }

    public Provincia getProvincia(){
        return this.provincia;
    }

    public String getPaís(){
        return this.provincia.getNombrePaís();
    }

    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion (){
        return this.descripcion;
    }
}