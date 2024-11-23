package cu36;

import java.time.LocalDateTime;

public class CambioEstadoRT {
	private LocalDateTime fechaHoraDesde;
	private LocalDateTime fechaHoraFin;
        private Estado estado;
	
	public CambioEstadoRT(Estado es,LocalDateTime desde) {
            estado=es;
            fechaHoraDesde=desde;
	}
	public boolean conocerActual() {
            return(estado.esDisponible());
	}
	public void mostrarCambioEstadoRT(){
		
	}
	//GET AND SET
	public LocalDateTime getFechaHoraDesde() {
		return fechaHoraDesde;
	}
	public void setFechaHoraDesde(int fechaHoraDesde) {
		//this.fechaHoraDesde = fechaHoraDesde;
	}
	public LocalDateTime getFechaHoraHasta() {
		return fechaHoraFin;
	}
	public void setFechaHoraFin(LocalDateTime fechaHoraHasta) {
		this.fechaHoraFin = fechaHoraHasta;
	}
}
