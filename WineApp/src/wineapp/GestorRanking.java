package wineapp;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.ZoneId;

import javax.swing.JOptionPane;

public class GestorRanking {
    private Date fechaInicioRanking;
    private Date fechaFinRanking;
    private ArrayList<String> tiposVisualizacion = new ArrayList<>();
    private ArrayList<String> tiposReseñas= new ArrayList<>();
    private ArrayList<Vino> vinos;
    private Pnl_GenerarRanking pantalla;
    private String tipoReseñaSelec;
    private String tipoVisualizacionSelec;
    private ExcelReporteRanking excelReporte = new ExcelReporteRanking();
    
    public GestorRanking(ArrayList<Vino> vinos){
        this.vinos = vinos;
        this.tiposVisualizacion.add("PDF");
        this.tiposVisualizacion.add("Archivo Excel");
        this.tiposVisualizacion.add("Pantalla"); 
        this.tiposReseñas.add("Reseñas normales");
        this.tiposReseñas.add("Reseñas de Sommelier");  
        this.tiposReseñas.add("Reseñas de Amigos"); 
    }
   
    public Object[][] calcularRankingVinos() {
        int numVinos = vinos.size();
        Object[][] ranking = new Object[2][numVinos];
       System.out.print("Adentro de calcularRankingVinos");
        int i = 0;
        for (Vino vino: vinos){
            ranking[0][i] = vino;
            ranking[1][i] = vino.calcularPromedioPuntuacion(convertToLocalDate(fechaInicioRanking), convertToLocalDate(fechaFinRanking));
            i ++;
        }
        System.out.print("runea calcularRankingVinos");
        return ranking;
    }

    public Object[][] ordenarVinoSCalificacion(Object[][] ranking) {

        // Convertir la matriz en una lista de pares para ordenar
        ArrayList<Object[]> rankingList = new ArrayList<>();
        for (int i = 0; i < ranking[0].length; i++) {
            rankingList.add(new Object[]{ranking[0][i], ranking[1][i]});
        }

        // Ordenar la lista en orden descendente de acuerdo al puntaje promedio
        rankingList.sort((a, b) -> ((Float) b[1]).compareTo((Float) a[1]));

        // Seleccionar los primeros 10 elementos
        int topN = Math.min(10, rankingList.size());
        Object[][] topRanking = new Object[2][topN];
        for (int i = 0; i < topN; i++) {
            topRanking[0][i] = rankingList.get(i)[0];
            topRanking[1][i] = rankingList.get(i)[1];
        };
        System.out.print("runea ordenarVinoSCalificacion");
        return topRanking;
    }
    
    public Object[][] buscarDatosVinosDelRanking(Object[][] topRanking){
        System.out.println("ENTRE A DATOS VINOS");
        Object[][] rankingConDatos = new Object[10][10];
        
        for (int i = 0; i < 10; i++){
            Vino vino = (Vino) topRanking[0][i];
            rankingConDatos[0][i]=vino.getNombre();
            rankingConDatos[1][i]=vino.getPrecioARS();
            rankingConDatos[2][i]=vino.getNombreBodega();
            rankingConDatos[3][i]=vino.getNombreRegionVitivinicola();
            rankingConDatos[4][i]=(vino.getProcedencia()).get(0);
            rankingConDatos[5][i]=(vino.getProcedencia()).get(1);
            rankingConDatos[6][i]=topRanking[1][i];
            ArrayList<String> arrayDescripcionVarietal = vino.getDescripcionVarietal();

            for (int j = 0; j < arrayDescripcionVarietal.size(); j++){
                rankingConDatos[7+j][i]= arrayDescripcionVarietal.get(j);
            }
        }
        
        return rankingConDatos;
    }

    public void validarFechas() {
        System.out.println("EstOY DENTRO DEL VALIDAR FECHAS GESTOR");
        if (this.fechaInicioRanking.after(this.fechaFinRanking)){
            System.out.println("No es valido");
            pantalla.informarNoValidacionFechas();
        } else {
            System.out.println("Es valido");
            pantalla.solicitarSelecTipoReseña();
        }
        
    }
    
    public void generarRankingVinos(){
        pantalla.solicitarFechasRanking();
    }
    
    public void tomarFechasRanking(Date fechaInicioRanking, Date fechaFinRanking){
        this.fechaInicioRanking = fechaInicioRanking;
        this.fechaFinRanking = fechaFinRanking;
        System.out.println("Estoy tomando fechass gestor");
        validarFechas();
        
    }
    
    public void tomarTipoReseñasSelec(String tipoReseñaSelect){
        this.tipoReseñaSelec = tipoReseñaSelect;
        this.pantalla.mostrarFormaVisualizacionParaSelec(tiposVisualizacion);
        System.out.println("ESTOY DENTRO DEL tomar SELEC tipo reseña");
        
    }
    public void tomarSelecFormaVisualizacion(String formaVisualizacionSelec){
        System.out.println("EL GESTOR TOMO FORMA VISUALIZACION");
        this.tipoVisualizacionSelec = formaVisualizacionSelec;
        pantalla.solicitarConfirmacion();
    }
    public void tomarConfirmacion(java.awt.event.ActionEvent evt){
        System.out.println("ESTOY DENTRO DEL TOMAR CONFIRMARCION");
        generarExcel(buscarDatosVinosDelRanking(ordenarVinoSCalificacion(calcularRankingVinos())));
        pantalla.informarExitoRegistro(evt);
        finCU();
    }
 
    public void generarExcel(Object[][] rankingDatos){
        System.out.print("runea Excel");
        excelReporte.generar(rankingDatos);
    }
    
    public void finCU(){
        System.out.println("Terminado");
    }

    public void setPantalla(Pnl_GenerarRanking pantalla){
        this.pantalla = pantalla;
    }
    public void setVinos(ArrayList<Vino> vinos){
        this.vinos = vinos;
    }
    
    private static LocalDate convertToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
