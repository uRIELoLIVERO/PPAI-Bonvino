package cu36;
import java.time.* ;
import java.util.ArrayList;

public class AsignacionRTRT {

    private LocalDateTime  fechaDesde;
    private LocalDateTime  fechaHasta;
    private ArrayList<RecursoTecnologico> recurso;
    private PersonalCientifico personal;
    //-----------------------------------------------------------------------
    //Constructor
    public AsignacionRTRT(LocalDateTime  fechaDesde, LocalDateTime  fechaHasta, ArrayList<RecursoTecnologico> array,PersonalCientifico personal){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        recurso = array;
        this.personal=personal;
    }
    //-----------------------------------------------------------------------
    //Metodos
    public boolean esActual(LocalDateTime fecha){
        if(fecha.isBefore(fechaHasta)){
            return true; 
        }else{
            return false;
        }
    }

    public ArrayList<String> misRT(){
        ArrayList<String> datosRT = new ArrayList<String>();
        for (RecursoTecnologico rt : recurso) {
            if(rt.conocerRT()){
                datosRT.addAll(rt.getNumero());
            }
        }
        return datosRT;
    }

    public void mostrarResponsableTecnicoRT(){
        
    }
    //-----------------------------------------------------------------------
    //Getters y Setters

    //-----------------------------------------------------------------------
}
//---------------------------------------------------------------------------