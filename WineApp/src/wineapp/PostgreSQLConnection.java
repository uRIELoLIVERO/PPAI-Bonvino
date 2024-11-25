package wineapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    public static void main(String[] args) {
        // URL de conexión para PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/wineapp"; // Cambia 'WineAppPU' por el nombre real de tu base de datos
        String user = "postgres"; // Cambia si tu usuario de PostgreSQL no es 'postgres'
        String password = "hebe456"; // Reemplaza por tu contraseña de PostgreSQL

        // Intentamos conectarnos
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a PostgreSQL.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a PostgreSQL: " + e.getMessage());
        }
    }
}

