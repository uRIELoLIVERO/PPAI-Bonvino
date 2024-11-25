package wineapp;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import wineapp.patronStrategy.EstrategiaResAmigos;
import wineapp.patronStrategy.EstrategiaResNormales;
import wineapp.patronStrategy.EstrategiaResSommelier;
import wineapp.patronStrategy.IEstrategiaCalculoRanking;
import wineapp.InterfazExcelReporteRanking;

public class GestorRanking {
    private Date fechaInicioRanking;
    private Date fechaFinRanking;
    private ArrayList<String> tiposVisualizacion = new ArrayList<>();
    private ArrayList<String> tiposReseñas= new ArrayList<>();
    private ArrayList<Vino> vinos;
    private Pnl_GenerarRanking pantalla;
    private String tipoReseñaSelec;
    private String tipoVisualizacionSelec;
    private InterfazExcelReporteRanking excelReporte = new InterfazExcelReporteRanking();
    IEstrategiaCalculoRanking estrategia = null;
    
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
        List<Object[]> rankingList = new ArrayList<>();
        for (Vino vino : vinos) {
            try {
                float promedio = vino.calcularPromedioPuntuacion(convertToLocalDate(fechaInicioRanking), convertToLocalDate(fechaFinRanking), estrategia);
                if (promedio != 0) {
                    rankingList.add(new Object[] { vino, promedio });
                }
            } catch (Exception e) {
                System.out.println("Error al calcular promedio: " + e.getMessage());
            }
        }

        // Convierte la lista a un array
        Object[][] ranking = new Object[2][rankingList.size()];
        for (int j = 0; j < rankingList.size(); j++) {
            ranking[0][j] = rankingList.get(j)[0];
            ranking[1][j] = rankingList.get(j)[1];
        }
        System.out.println("runea calcularRankingVinos");
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
    
    public Object[][] buscarDatosVinosDelRanking(Object[][] topRanking) {
        System.out.println("ENTRE A DATOS VINOS");

        // Determinar la cantidad de vinos en el ranking (no más de 10)
        int numVinos = Math.min(10, topRanking[0].length);  // El número máximo de vinos será 10

        // Crear la matriz ajustada a los datos disponibles
        Object[][] rankingConDatos = new Object[8][numVinos];  // Solo se crearán las columnas necesarias

        for (int i = 0; i < numVinos; i++) {
            Vino vino = (Vino) topRanking[0][i];

            // Rellenar la matriz con los datos de cada vino
            rankingConDatos[0][i] = vino.getNombre() != null ? vino.getNombre() : "Desconocido";
            rankingConDatos[1][i] = vino.getPrecioARS();
            rankingConDatos[2][i] = vino.getNombreBodega() != null ? vino.getNombreBodega() : "Desconocida";
            rankingConDatos[3][i] = vino.getNombreRegionVitivinicola() != null ? vino.getNombreRegionVitivinicola() : "Desconocida";

            // Manejo de procedencia (máximo 2 valores)
            ArrayList<String> procedencia = vino.getProcedencia();
            rankingConDatos[4][i] = procedencia != null && procedencia.size() > 0 ? procedencia.get(0) : "No especificado";
            rankingConDatos[5][i] = procedencia != null && procedencia.size() > 1 ? procedencia.get(1) : "No especificado";

            // Puntuación promedio
            rankingConDatos[6][i] = topRanking[1][i] != null ? topRanking[1][i] : 0.0;

            // Manejo de descripción varietal
            ArrayList<String> arrayDescripcionVarietal = vino.getDescripcionVarietal();
            if (arrayDescripcionVarietal != null) {
                for (int j = 0; j < Math.min(arrayDescripcionVarietal.size(), 10); j++) {
                    rankingConDatos[7 + j][i] = arrayDescripcionVarietal.get(j);
                }
            }
        }

        return rankingConDatos;
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
    
        public void validarFechas() {
        System.out.println("EstOY DENTRO DEL VALIDAR FECHAS GESTOR"); 
        if (this.fechaInicioRanking.after(this.fechaFinRanking)){
            System.out.println("No es valido");
            pantalla.informarNoValidacionFechas();
        } else {
            System.out.println("Es valido");
            pantalla.solicitarSelecTipoReseña(tiposReseñas);
        }
        
    }
    
    public void tomarTipoReseñaSelec(String tipoReseñaSelect){
        this.tipoReseñaSelec = tipoReseñaSelect;
        System.out.println("tomarTipoReseñaSelect - Gestor - Creando estrategia"+ tipoReseñaSelec);
        crearEstrategia();
        this.pantalla.mostrarFormaVisualizacionParaSelec(tiposVisualizacion);
    }
    
    
    public void crearEstrategia() {
        if (null != tipoReseñaSelec) switch (tipoReseñaSelec) {
            case "De Sommelier":
                System.out.println("cree estrategia sommelier");
                this.estrategia = new EstrategiaResSommelier();
                break;
            case "Normales":
                this.estrategia = new EstrategiaResNormales();
                break;
            case "De Amigos":
                this.estrategia = new EstrategiaResAmigos();
                break;
            default:
                break;
        }
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
        excelReporte.generar();
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
