package cu36;

import java.time.LocalDateTime;


public class CambioEstadoTurno {
	private LocalDateTime fechaHoraDesde;
	private LocalDateTime fechaHoraFin;
        private Estado estado;
	
	//CONSTRUCTOR
	public CambioEstadoTurno(Estado estado,LocalDateTime fechaHoraDesde) {
            this.estado=estado;
            this.fechaHoraDesde=fechaHoraDesde;
	}

	public void conocerActual() {
            
	}
	public void mostrarCambioEstado() {
		
	}
	//SET AND GET
	public LocalDateTime getFechaHoraDesde() {
		return fechaHoraDesde;
	}
	public void setFechaHoraDesde(LocalDateTime fechaHoraDesde) {
		this.fechaHoraDesde = fechaHoraDesde;
	}
	public LocalDateTime getFechaHoraHasta() {
		return fechaHoraFin;
	}
	public void setFechaHoraFin(LocalDateTime fechaHoraHasta) {
		this.fechaHoraFin = fechaHoraFin;
	}

    public boolean estasReservadoOPteConf() {
        return estado.sosReservadoOPteConf();
    }
	
}
