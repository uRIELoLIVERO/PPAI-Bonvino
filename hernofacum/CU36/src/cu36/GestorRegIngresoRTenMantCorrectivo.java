package cu36;
import PatronObserver.IObservador;
import PatronObserver.ISujeto;
import PatronObserver.InterfazMail;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GestorRegIngresoRTenMantCorrectivo implements ISujeto{
    
    private ArrayList<IObservador> observadores;
    
    
    private Sesion sesion;
    private ArrayList<PersonalCientifico> personalCientifico;
    private String personalUsuario;
    private ArrayList<String> datosRTDispDelusuario;
    //private ArrayList<String> datosRTDispDelusuarioAgrupadosPorTipo =new ArrayList<String>();
    private PantRegIngresoRTenMantCorrectivo pantalla;
    private LocalDateTime fechaFin;
    private String motivo;
    private RecursoTecnologico rtSeleccionado;
    private ArrayList<RecursoTecnologico> recursosTecnologicos;
    private ArrayList<Turnos> turnoEnPlazo;
    private ArrayList<String> datosTurnoEnPlazo = new ArrayList<String>();
    private Estado estadoCanceladoPorMantCorr; 
    private Estado estadoConIngresoEnMantCorr;
    private ArrayList<Estado> estados;
    private LocalDateTime fechaHoraActual;
    private ArrayList<String> mails;
    private int rTdelUsuario;
    private int rTDispdelUsuario;
    private int tipoNotificacion;
    private String usuarioLogeado;

    public GestorRegIngresoRTenMantCorrectivo(ArrayList<PersonalCientifico> personalCientifico,Sesion sesion,PantRegIngresoRTenMantCorrectivo pantalla, ArrayList<RecursoTecnologico> todosLosRT, ArrayList<Estado> estados) {
        this.personalCientifico=personalCientifico;
        this.sesion=sesion;
        this.pantalla=pantalla;
        this.recursosTecnologicos=todosLosRT;
        this.estados=estados;
        //this.usuarioLogeado = usuarioLogeado;
    } 

    public void actualizarEstadoRT(){
        getFechaHoraActual();
        rtSeleccionado.actualizarEstadoRT(estadoConIngresoEnMantCorr,fechaHoraActual);
        buscarEstadoCanceladoPorMantCorrectivo();
    }

    public void actualizarEstadoTurnosInvolucrados(){
        rtSeleccionado.actualizarEstadoTurnosInvolucrados(estadoCanceladoPorMantCorr,fechaHoraActual,turnoEnPlazo);
        notificarCientificos();
    }

    public void agruparTipoRecurso(){
        pantalla.mostrarRTdispDelUsuario(datosRTDispDelusuario);
        pantalla.pedirSelrRTdispDelUsuario();
    }
    
    
    public void buscarDatosTurno(){
        ArrayList<String> datos = new ArrayList<String>();
        for (Turnos t : turnoEnPlazo){
            datos.add(rtSeleccionado.buscarDatosTurno(t).get(0));
            datos.add(rtSeleccionado.buscarDatosTurno(t).get(1));
        }
        agruparTurnosPorCientifico(datos);
    }
    
    public void buscarEstadoCanceladoPorMantCorrectivo(){
        for (Estado e : estados){
            if(e.sosCanceladoPorMantCorrectivo()){
                estadoCanceladoPorMantCorr=e;
            }
        }
        actualizarEstadoTurnosInvolucrados();
    }
    
    public void buscarEstadoConIngresoEnMantinimietnoCorrectivo(){
        for (Estado e : estados){
            if(e.sosConIngresoEnMantenimientoCorrectivo()){
                estadoConIngresoEnMantCorr=e;
            }
        }
        actualizarEstadoRT();
    }
    
    public void buscarUsuario(){
        usuarioLogeado = sesion.conocerUsuario();
        for (PersonalCientifico p : personalCientifico) {
            if (p.esTuUsuario(usuarioLogeado)==true){
                datosRTDispDelusuario=p.mostrarRTDisponible(LocalDateTime.now());//(num,tipo,mod,marca)
            }
        }
        agruparTipoRecurso();
    }
    
    public void finCU(){
        System.out.println("Terminado");
    }
    
    public void generarMantCorrectivo(){
        Mantenimiento NuevoMantenimiento = new Mantenimiento(fechaFin.toLocalDate(),motivo);
        System.out.println("Mantenimiento generado");
        buscarEstadoCanceladoPorMantCorrectivo();
    }
    
    public void notificarCientificos(){
        IObservador nuevoObservador = new InterfazMail();
        suscribir(nuevoObservador);
        notificar();
        /*LOGICA ANTERIOR
        mails=rtSeleccionado.notificarCientificosRTMantenimiento(turnoEnPlazo);
        for(String m : mails){
            enviarMail(m);
        }
        finCU();*/
    }
    
    public void obtenerDatosDeRT(){}
    
    public void obtenerRTDelUsuario(){}
    
    public void opcRegIngresoRTenMantCorrectivo(){
        buscarUsuario();
    }
    
    public void tomarConfirmacionYNotif(){
        generarMantCorrectivo();
    }
    
    public void tomarFechaFin(LocalDateTime fecha){
        fechaFin=fecha;
    }

    public void tomarRazon(String razon){
        motivo=razon;
        verificarTurnosEnElPlazo();
    }
    
    public void tomarSelrRTdispDelUsuario(RecursoTecnologico RT){
        rtSeleccionado=RT;
        pantalla.solicitarFechaFin();
        pantalla.solicitarRazon();
    }

    public void verificarTurnosEnElPlazo (){
        turnoEnPlazo=rtSeleccionado.verificarTurnosEnElPlazo(fechaFin);
        buscarDatosTurno();
    }

    private void agruparTurnosPorCientifico(ArrayList<String> datos) {
        pantalla.mostrarTurnosEnPlazo(datos);
        pantalla.solicitarConfirmacion();
    }

    private void getFechaHoraActual() {
        fechaHoraActual=LocalDateTime.now();
    }

    private void enviarMail(String mail) {
        //enviar mail
    }
    
    
    //PATRON OBSERVER

    @Override
    public void notificar() {
        for(IObservador o : observadores){
            for(String mail : mails){
                o.notificarCientificosRTMantenimiento(this.motivo, mail);
            }
        }
    }

    @Override
    public void quitar(IObservador observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void suscribir(IObservador observador) {
        this.observadores.add(observador);
    }
    


}
