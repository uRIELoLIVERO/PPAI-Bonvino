package wineapp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author grupo1
 */
public class InterfazExcelReporteRanking {

    public InterfazExcelReporteRanking() {

    }

    
    public void generar(Object[][] rankingConDatos) {
        // Crear un nuevo workbook y una hoja
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte Ranking Vinos");

        System.out.println("GENERANDO EXCEL.... DATOS QUE UTILIZA:");

        // Definir los títulos del encabezado
        String[] encabezados = {
                "Nombre del vino", "Precio ARS", "Nombre de la bodega",
                "Región", "Provincia", "País", "Promedio", "Varietal"
        };

        // Iterar sobre filas: encabezado (fila 0) + datos
        for (int i = 0; i <= rankingConDatos.length; i++) {
            Row row = sheet.createRow(i); // Crear fila

            for (int j = 0; j < encabezados.length; j++) {
                Cell cell = row.createCell(j); // Crear celda

                // Si es la fila 0, escribir encabezados
                if (i == 0) {
                    cell.setCellValue(encabezados[j]);
                } else {
                    // Escribir datos (a partir de fila 1)
                    Object value = rankingConDatos[i - 1][j];
                    if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else {
                        cell.setCellValue(value == null ? "" : value.toString());
                    }
                }
            }
        }

        // Escribir el archivo Excel en disco
        try (FileOutputStream fileOut = new FileOutputStream("ReporteRankingVinos.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Archivo Excel generado exitosamente: ReporteRankingVinos.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}