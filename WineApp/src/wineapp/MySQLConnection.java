package wineapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/WineAppPU"; // Cambia el nombre_de_tu_base por el nombre real de tu base de datos
        String user = "root"; // Cambia si tu usuario de MySQL no es root
        String password = "15545367"; // Reemplaza por tu contraseña de MySQL

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa a MySQL.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a MySQL: " + e.getMessage());
        }
    }
}
