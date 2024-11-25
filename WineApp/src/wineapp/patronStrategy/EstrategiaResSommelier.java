package wineapp.patronStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import wineapp.Reseña;

public class EstrategiaResSommelier implements IEstrategiaCalculoRanking{
    @Override

    public float calcularPromedioPuntuacion(ArrayList<Reseña> reseñas, LocalDate fechaInicio, LocalDate fechaFin) {
        // Filtrar reseñas por fechas (si es necesario)
        float suma = 0;
        int contador = 0;

        for (Reseña reseña : reseñas) {
            LocalDate fecha = reseña.getFechaReseña();

            // Filtrar por el rango de fechas si es necesario
            if ((fechaInicio == null || !fecha.isBefore(fechaInicio)) && (fechaFin == null || !fecha.isAfter(fechaFin))) {
                suma += reseña.getPuntaje();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }
}




