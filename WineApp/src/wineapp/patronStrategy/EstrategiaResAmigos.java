/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wineapp.patronStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import wineapp.Reseña;

/**
 *
 * @author carol
 */

//VER ACA LOS PARÁMETROS SI HABIA QUE MODIFICARLOS, TAMBIÉN LA IMPLEMENTACION PORQ HABRIA Q CREAR NUEVAS CLASES
public class EstrategiaResAmigos implements IEstrategiaCalculoRanking{
    @Override
    public float calcularPromedioPuntuacion(ArrayList<Reseña> reseñas, LocalDate fechaInicio, LocalDate fechaFin) {
        return 1;
    }
}
