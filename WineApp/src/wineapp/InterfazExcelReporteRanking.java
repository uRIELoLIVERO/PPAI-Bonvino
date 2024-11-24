package wineapp;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

        // Validar que tengamos datos para procesar
        if (rankingConDatos == null || rankingConDatos.length == 0) {
            System.out.println("Error: No hay datos para procesar");
            return;
        }

        // Imprimir los datos para debug
        imprimirDatosDebug(rankingConDatos);

        // Reorganizar los datos si es necesario
        Object[][] datosOrganizados = reorganizarDatos(rankingConDatos);

        // Crear encabezados en la fila 0
        Row headerRow = sheet.createRow(0);
        for (int j = 0; j < encabezados.length; j++) {
            Cell headerCell = headerRow.createCell(j);
            headerCell.setCellValue(encabezados[j]);
        }

        // Ordenar los datos por promedio
        ordenarPorPromedio(datosOrganizados);

        // Iterar sobre las filas de datos
        for (int i = 0; i < datosOrganizados.length; i++) {
            Row dataRow = sheet.createRow(i + 1); // +1 porque la fila 0 son los encabezados
            
            for (int j = 0; j < encabezados.length; j++) {
                Cell cell = dataRow.createCell(j);
                Object value = datosOrganizados[i][j];
                
                try {
                    if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else {
                        cell.setCellValue(value == null ? "" : value.toString());
                    }
                } catch (Exception e) {
                    System.out.println("Error al procesar celda [" + i + "][" + j + "]: " + value);
                    cell.setCellValue("");
                }
            }
        }

        // Ajustar el tamaño de las columnas automáticamente
        for (int i = 0; i < encabezados.length; i++) {
            sheet.autoSizeColumn(i);
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

    private Object[][] reorganizarDatos(Object[][] datosOriginales) {
        // Asumiendo que los datos están en columnas y necesitamos convertirlos a filas
        int numColumnas = 8; // Número de columnas esperadas
        int numFilas = datosOriginales[0].length; // Número de vinos
        
        Object[][] datosReorganizados = new Object[numFilas][numColumnas];
        
        // Reorganizar los datos de columnas a filas
        try {
            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numColumnas; j++) {
                    datosReorganizados[i][j] = datosOriginales[j][i];
                }
            }
        } catch (Exception e) {
            System.out.println("Error al reorganizar datos: " + e.getMessage());
            e.printStackTrace();
        }
        
        return datosReorganizados;
    }

    private void ordenarPorPromedio(Object[][] datos) {
        try {
            for (int i = 0; i < datos.length - 1; i++) {
                for (int j = 0; j < datos.length - i - 1; j++) {
                    // Obtener los promedios con manejo seguro de tipos
                    double promedio1 = extraerPromedio(datos[j][6]);
                    double promedio2 = extraerPromedio(datos[j + 1][6]);
                    
                    // Ordenar de mayor a menor
                    if (promedio1 < promedio2) {
                        // Intercambiar las filas completas
                        Object[] temp = datos[j];
                        datos[j] = datos[j + 1];
                        datos[j + 1] = temp;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al ordenar por promedio: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private double extraerPromedio(Object valor) {
        try {
            if (valor instanceof Double) {
                return (Double) valor;
            } else if (valor instanceof String) {
                return Double.parseDouble((String) valor);
            } else if (valor instanceof Integer) {
                return ((Integer) valor).doubleValue();
            }
        } catch (Exception e) {
            System.out.println("Error al extraer promedio del valor: " + valor);
        }
        return 0.0; // valor por defecto en caso de error
    }

    private void imprimirDatosDebug(Object[][] datos) {
        System.out.println("Estructura de datos recibida:");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < datos[i].length; j++) {
                System.out.print(datos[i][j] + " | ");
            }
            System.out.println();
        }
    }
}