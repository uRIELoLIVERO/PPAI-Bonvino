package wineapp;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class InterfazExcelReporteRanking {


    // Parámetros de conexión a la base de datos
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/wineapp"; // Cambia esto según tu configuración
    private static final String DB_USER = "postgres"; // Usuario de la base de datos
    private static final String DB_PASSWORD = "hebe456"; // Contraseña de la base de datos


    public InterfazExcelReporteRanking() {
    }


    public void generar() {
        // Crear un nuevo workbook y una hoja
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte Ranking Vinos");


        System.out.println("GENERANDO EXCEL...");


        // Definir los títulos del encabezado
        String[] encabezados = {
            "Nombre del vino", "Precio ARS", "Nombre de la bodega",
            "Región", "Provincia", "País", "Promedio", "Varietal"
        };


        // Obtener datos de la base de datos
        List<Object[]> rankingConDatos = obtenerDatosDesdeBD();


        // Validar que tengamos datos para procesar
        if (rankingConDatos == null || rankingConDatos.isEmpty()) {
            System.out.println("Error: No hay datos para procesar");
            return;
        }


        // Crear encabezados en la fila 0
        Row headerRow = sheet.createRow(0);
        for (int j = 0; j < encabezados.length; j++) {
            Cell headerCell = headerRow.createCell(j);
            headerCell.setCellValue(encabezados[j]);
        }


        // Iterar sobre las filas de datos
        for (int i = 0; i < rankingConDatos.size(); i++) {
            Row dataRow = sheet.createRow(i + 1); // +1 porque la fila 0 son los encabezados
            Object[] filaDatos = rankingConDatos.get(i);


            for (int j = 0; j < encabezados.length; j++) {
                Cell cell = dataRow.createCell(j);
                Object value = filaDatos[j];


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


        private List<Object[]> obtenerDatosDesdeBD() {
        List<Object[]> datos = new ArrayList<>();

        // Consulta principal para obtener los datos de los vinos
        String query = "SELECT vino.id AS vino_id, vino.nombre, vino.precio_ars, " +
                       "bodega.nombre AS nombre_bodega, " +
                       "regionvitivinicola.nombre AS region, " +
                       "provincia.nombre AS provincia, " +
                       "pais.nombre AS pais, " +
                       "varietal.descripcion AS varietal_descripcion " +
                       "FROM vino " +
                       "JOIN bodega ON vino.bodega_id = bodega.id " +
                       "JOIN regionvitivinicola ON bodega.region_id = regionvitivinicola.id " +
                       "JOIN provincia ON regionvitivinicola.provincia_id = provincia.id " +
                       "JOIN pais ON provincia.pais_id = pais.id " +
                       "JOIN vino_varietal ON vino.id = vino_varietal.vino_id " +
                       "JOIN varietal ON vino_varietal.varietal_id = varietal.id";

        // Consulta para calcular el promedio de puntajes de vinos premium por ID
        String queryPromedio = "SELECT AVG(puntaje) AS promedio " +
                               "FROM resena " +
                               "WHERE vino_id = ? AND es_premium = true";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Preparar el statement para calcular los promedios
            PreparedStatement stmtPromedio = conn.prepareStatement(queryPromedio);

            // Procesar el ResultSet principal
            while (rs.next()) {
                Object[] fila = new Object[8]; // Ajustado al número de columnas seleccionadas en la consulta
                int vinoId = rs.getInt("vino_id");

                fila[0] = rs.getString("nombre"); // Nombre del vino
                fila[1] = rs.getDouble("precio_ars"); // Precio en ARS
                fila[2] = rs.getString("nombre_bodega"); // Nombre de la bodega
                fila[3] = rs.getString("region"); // Región vitivinícola
                fila[4] = rs.getString("provincia"); // Provincia
                fila[5] = rs.getString("pais"); // País
                fila[7] = rs.getString("varietal_descripcion"); // Descripción del varietal

                // Calcular el promedio de puntaje para vinos premium
                stmtPromedio.setInt(1, vinoId);
                try (ResultSet rsPromedio = stmtPromedio.executeQuery()) {
                    if (rsPromedio.next()) {
                        fila[6] = rsPromedio.getDouble("promedio"); // Promedio de puntajes premium
                    } else {
                        fila[6] = null; // Si no hay puntajes, dejar el promedio como null
                    }
                }

                datos.add(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }

        return datos;
        }



}
