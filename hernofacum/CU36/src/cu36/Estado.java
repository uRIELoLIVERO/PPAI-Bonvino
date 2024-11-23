package cu36;


public class Estado {
	private String ambito;
	private String nombre;
	
	public Estado(String nomb,String amb) {
            ambito=amb;
            nombre=nomb;
	}
	//public boolean esAmbitoRT() {
		
	//}
	//public boolean esAmbitoTurno() {
		
	//}
        
	public boolean esDisponible() {
            if(nombre=="Disponible"){
                return true;
            }else{
                return false;
            }
	}
	public boolean sosCanceladoPorMantCorrectivo() {
            if(nombre=="CanceladoPorMantCorrectivo"){
                return true;
            }else{
                return false;
            }
	}
	public boolean sosConIngresoEnMantenimientoCorrectivo() {
            if(nombre=="ConIngresoEnMantenimientoCorrectivo"){
                return true;
            }else{
                return false;
            }
	}
	public boolean sosReservadoOPteConf() {
            if(nombre=="Reservado" || nombre=="Pendiente de Confirmacion"){
                return true;
            }else{
                return false;
            }
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}
