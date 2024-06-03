package wineapp;
public class Varietal {
    private String descripcion;
    private int porcentajeComposicion;
    private TipoUva tipoUva;

    public Varietal(String descripcion, int porcentajeComposicion, TipoUva tipoUva){
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
        this.tipoUva = tipoUva;
    }

    public TipoUva conocerTipoUva(){
        return this.tipoUva;
    }

    public boolean esDeTipoUva(TipoUva tipoUva){
        return this.tipoUva.equals(tipoUva);
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setPorcentajeComposicion (int porcentajeComposicion){
        this.porcentajeComposicion = porcentajeComposicion;
    }


    public void setTipoUva(TipoUva tipoUva){
        this.tipoUva = tipoUva;
    }

    public String getDescripcion (){
        return this.descripcion;
    }

    public int getPorcentajeComposicion (){
        return this.porcentajeComposicion;
    }
}