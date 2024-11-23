package cu36;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

//---------------------------------------------------------------------------
//----------------------------------Turnos-----------------------------------
public class Turnos {
    private LocalDate diaSemana;
    private LocalDate fechaGeneracion;
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;
    private CambioEstadoTurno actual;
    private ArrayList<CambioEstadoTurno> cambioEstadoTurno;
    
    private AsignacionCientificoDelCI asignacion;
    //-----------------------------------------------------------------------
    //Constructor
	public Turnos(LocalDate diaSemana, LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio, CambioEstadoTurno actual, AsignacionCientificoDelCI asignacion){
            this.diaSemana = diaSemana;
            this.fechaHoraFin = fechaHoraFin;
            this.fechaHoraInicio = fechaHoraInicio;
            this.actual=actual;
            this.asignacion=asignacion;
	}
    //-----------------------------------------------------------------------
    //Metodos
    public void actualizarEstadoTurno(Estado estado, LocalDateTime fecha){
	actual.setFechaHoraFin(fecha);
        CambioEstadoTurno nuevoCambioEstadoTurno = new CambioEstadoTurno(estado,fecha);
        actual=nuevoCambioEstadoTurno;
    }

    public boolean estasEnPlazo(LocalDateTime fecha){
        if(fechaHoraInicio.isBefore(fecha)){
            return true;
        }else{
            return false;
        }
    }

    public boolean estasReservadoOPteConf(){
        return actual.estasReservadoOPteConf();
    }

    //public estoyDisponible(){
    //}

    public ArrayList<String> getDatosTurno(){
        ArrayList<String> str = new ArrayList<String>(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = getFechaHoraInicio().format(formatter);
        str.add(formattedDateTime);
        str.add(asignacion.buscarCientifico());
        return str;
    }

    //public mostrarTurno(){
    //}

    public String notificarCientificosRTMantenimiento(){
        return asignacion.notificarCientificosRTMantenimiento();
    }
    //-----------------------------------------------------------------------
    //Getters y Setters
    public LocalDate getDiaSemana() {
        return this.diaSemana;
    }
    public void setDiaSemana(LocalDate diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalDate getFechaGeneracion() {
        return this.fechaGeneracion;
    }
    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public LocalDateTime getFechaHoraFin() {
        return this.fechaHoraFin;
    }
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public LocalDateTime getFechaHoraInicio() {
        return this.fechaHoraInicio;
    }
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }
    //-----------------------------------------------------------------------
}
//---------------------------------------------------------------------------


