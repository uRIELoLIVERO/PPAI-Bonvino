package cu36;


import java.util.ArrayList;

//---------------------------------------------------------------------------
//----------------------------------Marca------------------------------------
public class Marca {
    private Modelo modelo;
    public String nombre;
    //-----------------------------------------------------------------------
    //Constructor
    public Marca(String nombre, Modelo obj) {
        this.nombre = nombre;
        modelo=obj;
    }
    //-----------------------------------------------------------------------
    //Metodos
    //public mostrarMarca(){
    //}

    //public mostrarMisModelos(){
    //}
    //-----------------------------------------------------------------------
    //Getters y Setters
    public ArrayList<String> getNombre() {
        ArrayList<String> modeloMarca = new ArrayList<String>();
        modeloMarca.add(nombre);
        modeloMarca.add(modelo.getNombre());
        return modeloMarca;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //-----------------------------------------------------------------------
}
//---------------------------------------------------------------------------