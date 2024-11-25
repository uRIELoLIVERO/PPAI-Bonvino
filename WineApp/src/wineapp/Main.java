package wineapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import wineapp.patronStrategy.EstrategiaResSommelier;
import java.awt.Image;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/wineapp";
        String usuario = "postgres";
        String contraseña = "hebe456";

        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");

            Statement stmt = conexion.createStatement();

            // Consulta para obtener reseñas premium
            String queryReseñas = "SELECT vino_id, puntaje, es_premium, fecha_resena FROM resena WHERE es_premium = true";
            ResultSet rsReseñas = stmt.executeQuery(queryReseñas);

            // Mapa para almacenar las reseñas agrupadas por vino_id
            Map<Integer, ArrayList<Reseña>> reseñasPorVino = new HashMap<>();
            ArrayList<Vino> vinos = new ArrayList<>();

            while (rsReseñas.next()) {
                int vinoId = rsReseñas.getInt("vino_id");
                float puntaje = rsReseñas.getFloat("puntaje");
                boolean esPremium = rsReseñas.getBoolean("es_premium");
                LocalDate fechaReseña = rsReseñas.getDate("fecha_resena").toLocalDate();
                Reseña resena = new Reseña(vinoId, puntaje, esPremium, fechaReseña);

                reseñasPorVino.computeIfAbsent(vinoId, k -> new ArrayList<>()).add(resena);
            }

            // Estrategia para calcular el promedio de puntuación
            EstrategiaResSommelier estrategia = new EstrategiaResSommelier();
            LocalDate fechaInicio = LocalDate.of(2024, 11, 1);
            LocalDate fechaFin = LocalDate.of(2024, 11, 30);

            // Consulta para obtener los detalles de los vinos, incluyendo el varietal
            String queryVinos = "SELECT vino.id, vino.nombre, vino.precio_ars, " +
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

            ResultSet rsVinos = stmt.executeQuery(queryVinos);

            while (rsVinos.next()) {
                int vinoId = rsVinos.getInt("id");
                String nombreVino = rsVinos.getString("nombre");
                String precioVino = rsVinos.getString("precio_ars");
                String nombreBodega = rsVinos.getString("nombre_bodega");
                String region = rsVinos.getString("region");
                String provincia = rsVinos.getString("provincia");
                String pais = rsVinos.getString("pais");
                String varietalDescripcion = rsVinos.getString("varietal_descripcion");
                // Otros datos necesarios
                LocalDate añada = null; // Supón que no tienes la añada
                LocalDate fechaActualizacion = null; // Supón que no tienes la fecha de actualización
                Image imagenEtiqueta = null; // Supón que no tienes la imagen
                int notaDeCataBodega = 0; // No disponible, asignamos un valor predeterminado
                float precioARS = Float.parseFloat(precioVino); // Convertimos el precio de String a float
                ArrayList<Maridaje> maridaje = null; // No tenemos maridaje, lo dejamos como null
                ArrayList<Varietal> varietales = null; // No tenemos varietales, lo dejamos como null
                Bodega bodega = null; // No tenemos la bodega, lo dejamos como null

                // Crear el objeto Vino
                Vino vino = new Vino(añada, fechaActualizacion, imagenEtiqueta, 
                                     nombreVino, notaDeCataBodega, precioARS, 
                                     maridaje, varietales, bodega);
                vinos.add(vino);
                // Calcular el promedio de puntuación para el vino actual
                ArrayList<Reseña> reseñasVino = reseñasPorVino.get(vinoId);
                float promedio = 0;
                if (reseñasVino != null && !reseñasVino.isEmpty()) {
                    promedio = estrategia.calcularPromedioPuntuacion(reseñasVino, fechaInicio, fechaFin);
                }
                

                // Mostrar los detalles del vino junto con el varietal
                System.out.println("Detalles del Vino:");
                System.out.println("Nombre del vino: " + nombreVino);
                System.out.println("Precio del vino (ARS): " + precioVino);
                System.out.println("Bodega: " + nombreBodega);
                System.out.println("Región Vitivinícola: " + region);
                System.out.println("Provincia: " + provincia);
                System.out.println("País: " + pais);
                System.out.println("Varietal: " + varietalDescripcion);
                System.out.println("Promedio de puntuación (sommeliers): " + promedio);
                System.out.println("-------------------------------");
            }

            System.out.println("Estoy ejecutando el main");
            Pnl_GenerarRanking pantallaGenerarRanking = new Pnl_GenerarRanking();
            pantallaGenerarRanking.setVinos(vinos);
            InterfazInicioBonVino.main(args, pantallaGenerarRanking);
            System.out.println("CREE TODO");
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante la ejecución de la consulta.");
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexión cerrada.");
                }
            } catch (Exception ex) {
                System.out.println("Ocurrió un error al cerrar la conexión.");
                ex.printStackTrace();
            }
        }
    }


}
