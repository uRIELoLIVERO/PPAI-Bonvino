package wineapp;
/**
 *
 * @author grupo1
 */
public class ExcelReporteRanking {
    
    public ExcelReporteRanking(){
        
    }
    
    public void generar(Object[][] rankingConDatos){
        System.out.print("GENERANDO EXCEL.... DATOS QUE UTILIZA:");
        // Imprimir los datos
        for (int i = 0; i < rankingConDatos.length; i++) {
            for (int j = 0; j < rankingConDatos[i].length; j++) {
                System.out.print(rankingConDatos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
