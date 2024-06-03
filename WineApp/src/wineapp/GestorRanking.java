package wineapp;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestorRanking {
    private LocalDate fechaInicioRanking;
    private LocalDate fechaFinRanking;
    private ArrayList<String> formasVisualizacion;
    private ArrayList<String> tiposReseñas;
    private ArrayList<Vino> vinos;
    private Pnl_GenerarRanking pantalla;
    private String tipoReseñaSelect;
    private String formaVisualizacionSelec;
    public GestorRanking(){
        this.formasVisualizacion.add("PDF");
        this.formasVisualizacion.add("Archivo Excel");
        this.formasVisualizacion.add("Pantalla"); 
        
        this.tiposReseñas.add("Reseñas normales");
        this.tiposReseñas.add("Reseñas de Sommelier");  
        this.tiposReseñas.add("Reseñas de Amigos"); 
    }

    
    
    public Object[][] calcularRankingVinos() {
        int numVinos = vinos.size();
        Object[][] ranking = new Object[2][numVinos];

        int i = 0;
        for (Vino vino: vinos){
            i ++;
            ranking[0][i] = vino;
            ranking[1][i] = vino.calcularPromedioPuntuacion(fechaInicioRanking, fechaFinRanking);
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
        Object[][] rankingConDatos = new Object[10][10];
        
        for (int i = 0; i < 10; i++){
            Vino vino = (Vino) topRanking[0][i];
            rankingConDatos[0][i]=vino.getNombre();
            rankingConDatos[1][i]=vino.getPrecioARS();
            rankingConDatos[2][i]=vino.getNombreBodega();
            rankingConDatos[3][i]=vino.getNombreRegionVitivinicola();
            rankingConDatos[4][i]=(vino.getProcedencia()).get(0);
            rankingConDatos[5][i]=(vino.getProcedencia()).get(1);
            ArrayList<String> arrayDescripcionVarietal = vino.getDescripcionVarietal();

            for (int j = 0; j < arrayDescripcionVarietal.size(); j++){
                rankingConDatos[6+j][i]= arrayDescripcionVarietal.get(j);
            }
        }
        System.out.print("runea buscarDatosVinosDelRanking");
        return rankingConDatos;
    }

    public boolean validarFechas(LocalDate fechaInicioRanking, LocalDate fechaFinRanking) {
        this.fechaFinRanking = fechaFinRanking;
        this.fechaInicioRanking = fechaInicioRanking;
        if (!this.fechaInicioRanking.isAfter(this.fechaFinRanking)){
            return true;
        } else {
            return false;
        }
        
    }
    
    public void generarRankingVinos(){
        pantalla.solicitarFechasRanking();
    }
    
    public void tomarFechasRanking(LocalDate fechaInicioRanking, LocalDate fechaFinRanking){
        this.fechaInicioRanking = fechaInicioRanking;
        this.fechaFinRanking = fechaFinRanking;
        validarFechas(fechaInicioRanking, fechaFinRanking);
        
    }
    
    public void tomarTipoReseñasSelec(String tipoReseñaSelect){
        this.tipoReseñaSelect = tipoReseñaSelect;
        this.pantalla.mostrarFormaVisualizacionParaSelec(formasVisualizacion);
        
    }
    public void tomarSelecFormaVisualizacion(String formaVisualizacionSelec){
        this.formaVisualizacionSelec = formaVisualizacionSelec;
        pantalla.solicitarConfirmacion();
    }
    public void tomarConfirmacion(){
        generarExcel(buscarDatosVinosDelRanking(ordenarVinoSCalificacion(calcularRankingVinos())));
        
    }
 
    public void generarExcel(Object[][] datosVinos){
        System.out.print("runea Excel");
        finCU();
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
}
