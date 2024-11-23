package cu36;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class RecursoTecnologico {
    private int duracionMantenimientoPrev;
    private String fechaAlta;
    private int fraccionHorarioTurnos;
    private boolean habilitar;
    private String modeloDelRT;
    private int numeroRT;
    private int periodicidadMantenimientoPrev;
    private ArrayList<CambioEstadoRT> cambioEstadoRT = new ArrayList<CambioEstadoRT>();
    private CambioEstadoRT actual;
    private TipoRecursoTecnologico tipoRecurso;
    private Marca marca;
    private ArrayList<Turnos> turnos;

    public RecursoTecnologico(CambioEstadoRT cambio,Marca marca,int num,TipoRecursoTecnologico tipoRec, ArrayList<Turnos> turnos){
        actual=cambio;
        this.marca = marca;
        numeroRT=num;
        tipoRecurso=tipoRec;
        this.turnos=turnos;
    }

    public void actualizarEstadoTurnosInvolucrados(Estado estado, LocalDateTime fecha, ArrayList<Turnos> arrayTurnos){
        for(Turnos t : arrayTurnos){
            t.actualizarEstadoTurno(estado, fecha);
        }
    }
    
    public void actualizarEstadoRT(Estado estado, LocalDateTime fecha){
        actual.setFechaHoraFin(fecha);
        CambioEstadoRT nuevoCambioEstado = new CambioEstadoRT(estado,fecha);
        actual=nuevoCambioEstado;
    }

    public ArrayList<String> buscarDatosTurno(Turnos turno){
        ArrayList<String> str = new ArrayList<String>();
        str.add(turno.getDatosTurno().get(0));
        str.add(turno.getDatosTurno().get(1));
        return str; 
    }

    public boolean buscarTurnosReservadosOPteConf(Turnos turno){
        return turno.estasReservadoOPteConf();
    }

    public boolean conocerRT(){
        return (actual.conocerActual());
    }
    

    public ArrayList<String> getNumero(){
        ArrayList<String> datos = new ArrayList<String>();
        datos.add(Integer.toString(numeroRT));
        datos.add(tipoRecurso.getNombre());
        datos.add(marca.getNombre().get(0));
        datos.add(marca.getNombre().get(1));
        return datos;
    }

    public boolean miModeloyMarca(){
        return false; //Cambiar, puse return false para que no tire errores
    }

    public ArrayList<String> notificarCientificosRTMantenimiento(ArrayList<Turnos> turnos){
        ArrayList<String> str = new ArrayList<String>();
        for (Turnos t : turnos){
            str.add(t.notificarCientificosRTMantenimiento());
        }
        return str;
    }

    public ArrayList<Turnos> verificarTurnosEnElPlazo(LocalDateTime fecha){
        ArrayList<Turnos> turnosInvolucrados = new ArrayList<Turnos>();
        for (Turnos t : turnos){
            if(t.estasEnPlazo(fecha)){
                if (buscarTurnosReservadosOPteConf(t)){
                    turnosInvolucrados.add(t);
                }
            }
        }
        return turnosInvolucrados;
    }




    //GETTERS Y SETTERS

    public int getDuracionMantenimientoPrev() {
        return this.duracionMantenimientoPrev;
    }

    public void setDuracionMantenimientoPrev(int duracionMantenimientoPrev) {
        this.duracionMantenimientoPrev = duracionMantenimientoPrev;
    }

    //public int getFechaAlta() {
    //    return this.fechaAlta;
    //}

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getFraccionHorarioTurnos() {
        return this.fraccionHorarioTurnos;
    }

    public void setFraccionHorarioTurnos(int fraccionHorarioTurnos) {
        this.fraccionHorarioTurnos = fraccionHorarioTurnos;
    }

    public boolean isHabilitar() {
        return this.habilitar;
    }

    public boolean getHabilitar() {
        return this.habilitar;
    }

    public void setHabilitar(boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getModeloDelRT() {
        return this.modeloDelRT;
    }

    public void setModeloDelRT(String modeloDelRT) {
        this.modeloDelRT = modeloDelRT;
    }

    public int getNumeroRT() {
        return this.numeroRT;
    }

    public void setNumeroRT(int numeroRT) {
        this.numeroRT = numeroRT;
    }

    public int getPeriodicidadMantenimientoPrev() {
        return this.periodicidadMantenimientoPrev;
    }

    public void setPeriodicidadMantenimientoPrev(int periodicidadMantenimientoPrev) {
        this.periodicidadMantenimientoPrev = periodicidadMantenimientoPrev;
    }

    public ArrayList<Turnos> getTurnos() {
        return this.turnos;
    }



}
