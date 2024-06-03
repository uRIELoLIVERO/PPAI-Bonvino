import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
        };
        return topRanking;
    }
    
    public Object[][] buscarDatosVinosDelRanking(Object[][] topRanking){
        Object[][] rankingConDatos = new Object[10][10];

        Vino vino = topRanking[0][i];

        rankingConDatos[0][i]=vino.getNombre();
        rankingConDatos[1][i]=vino.getPrecioARS();
        rankingConDatos[2][i]=vino.getNombreBodega();
        rankingConDatos[3][i]=vino.getNombreRegionVitivinicola();
        rankingConDatos[4][i]=(vino.getProcedencia()).get(0);
        rankingConDatos[5][i]=(vino.getProcedencia()).get(1);
        ArrayList<String> arrayDescripcionVarietal = vino.getDescripcionVarietal();
        for (String descripcion: arrayDescripcionVarietal){
            rankingConDatos[2+j][i]= arrayDescripcionVarietal.get(j);
        }
    }
    private void validarFechas() {
        Date fromDate = tomarSelecFechaInicio();
        Date toDate = tomarSelecFechaHasta();

        if (fromDate != null && toDate != null) {
            if (fromDate.after(toDate)) {
                JOptionPane.showMessageDialog(null, "Las fechas no son validas", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                fechaHasta.setDate(null);
                setPanelEnabled(PanelTReseña, false);
                setPanelEnabled(PanelFVisualizacion, false);
                setPanelEnabled(panelBoton, false);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(fromDate);
                System.out.println("Fecha desde: " + dateString);
                setPanelEnabled(PanelTReseña, true);
            }
        }
    }
    
    public void generarRankingVinos(){
        pantalla.solicitarFechasRanking();
    }
    
    public void tomarFechasRanking(){
        
    }
    
    public void tomarTipoReseñasSelec(){
        
    }
    public void tomarSelecFormaVisualizacion(){
        
    }
    public void tomarConfirmacion(){
        generarExcel(buscarDatosVinosDelRanking(calcularRankingVinos(fechaInicioRanking, fechaFinRanking)));
        pantalla.informarExitoRegistro();
        finCU();
    }
 
    public void generarExcel(){
        
    }
    public void finCU(){

    }
}
