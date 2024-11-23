/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package wineapp.patronStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import wineapp.Reseña;

/**
 *
 * @author carol
 */
public interface IEstrategiaCalculoRanking {
    
    public float calcularPromedioPuntuacion(ArrayList<Reseña> reseñas, LocalDate fechaInicio, LocalDate fechaFin);
    
}
