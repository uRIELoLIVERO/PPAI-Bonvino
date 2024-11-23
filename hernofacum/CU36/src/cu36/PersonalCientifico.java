package cu36;
import java.time.* ;

import java.util.ArrayList;


//---------------------------------------------------------------------------
//---------------------------Personal Cientifico-----------------------------
public class PersonalCientifico {    

    private String correoElectronicoInstitucional;
    private String correoElectronicoPersonal;
    private int legajo;
    private String nombre;
    private int numeroDocumento;
    private int telefonoCelular;
    private Usuario usuario;
    
    
    private ArrayList<AsignacionRTRT> asignacion;
    //-----------------------------------------------------------------------
    //Constructor
    public PersonalCientifico(String correoElectronicoInstitucional, String correoElectronicoPersonal, int legajo, String nombre, int numeroDocumento, int telefonoCelular, Usuario usuario) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.legajo = legajo;
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.telefonoCelular = telefonoCelular;
        this.usuario=usuario;
    }
    //-----------------------------------------------------------------------
    //Metodos
    public Boolean esTuUsuario(String user){
        if (user==usuario.getNombre()){
            return true;
        }else{
            return false;
        }
    }

    public void habilitarUsuario(){
    }

    public void inhabilitarUsuario(){
    }

    //public mostrarMisNovedades(){
    //}

    public String mostrarPersonalCientifico(){
        return nombre;
    }

    public ArrayList<String> mostrarRTDisponible(LocalDateTime fecha){
        ArrayList<String> datosRT = new ArrayList<String>();
        for (AsignacionRTRT a : asignacion) {
            if(a.esActual(fecha)){
                datosRT.addAll(a.misRT());
            }
        }
        return datosRT;
    }

    public String notificarCientificosRTMantenimiento(){
        return getCorreoElectronicoInstitucional();
    }

    public Boolean tengoUsuarioHabilitado(){
        return false;
    }
    //-----------------------------------------------------------------------
    //Getters y Setters
    public String getCorreoElectronicoInstitucional() {
        return this.correoElectronicoInstitucional;
    }
    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public String getCorreoElectronicoPersonal() {
        return this.correoElectronicoPersonal;
    }
    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public int getLegajo() {
        return this.legajo;
    }
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDocumento() {
        return this.numeroDocumento;
    }
    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getTelefonoCelular() {
        return this.telefonoCelular;
    }
    public void setTelefonoCelular(int telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    
    
    
    
    public void setAsignacion(ArrayList<AsignacionRTRT> asignacion){
        this.asignacion=asignacion;}
    //-----------------------------------------------------------------------




}
//---------------------------------------------------------------------------
