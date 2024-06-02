import java.time.LocalDate;
import java.util.ArrayList;

public class GestorRanking {
    private LocalDate fechaInicioRanking;
    private LocalDate fechaFinRanking;
    private ArrayList<String> formasVisualizacion;
    private ArrayList<String> tiposReseñas;
    private ArrayList<Vino> vinos;


    public GestorRanking(ArrayList<Vino> vino){
        this.formasVisualizacion.add("PDF");
        this.formasVisualizacion.add("Archivo Excel");
        this.formasVisualizacion.add("Pantalla"); 
        
        this.tiposReseñas.add("Reseñas normales");
        this.tiposReseñas.add("Reseñas de Sommelier");  
        this.tiposReseñas.add("Reseñas de Amigos"); 

        this.vinos = vino;
    }

    public Object[][] calcularRankingVinos(LocalDate fechaInicioRanking, LocalDate fechaFinRanking) {
        int numVinos = vinos.size();
        Object[][] ranking = new Object[2][numVinos];

        for (int i = 0; i < numVinos; i++) {
            Vino vino = vinos.get(i);
            ranking[0][i] = vino;
            ranking[1][i] = vino.calcularPromedioPuntuacion(fechaInicioRanking, fechaFinRanking);
        }
        return ordenarVinoSCalificacion(ranking);
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
        }
        return topRanking;
    }
    
    public void generarRankingVinos(){
    }
    
    public void tomarFechasRanking(){
        
    }
    
    public void tomarTipoReseñasSelec(){
        
    }
    public void tomarSelecFormaVisualizacion(){
        
    }
    public void tomarConfirmacion(){

    }   
    public void generarExcel(){
        
    }
    public void finCU(){

    }
}
