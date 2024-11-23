/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wineapp.patronStrategy;
import wineapp.Reseña;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author carol
 */
public class EstrategiaResSommelier implements IEstrategiaCalculoRanking{
    @Override
    public float calcularPromedioPuntuacion(ArrayList<Reseña> reseñas, LocalDate fechaInicio, LocalDate fechaFin) {
        float acumulador = 0f;
        int cantidad = 0;
        for (Reseña reseña : reseñas) {
            if (reseña.esDePeriodo(fechaInicio, fechaFin) && reseña.sosDeSommelier()) {
                acumulador += reseña.getPuntaje();
                cantidad++;
            }
        }
        if (cantidad == 0) {
            return 0; 
        } else {
            return acumulador / cantidad;
        }
    }
}
