package wineapp;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de las regiones vitivinícolas
        RegionVitivinicola regionValleDeUco = new RegionVitivinicola("Valle de Uco", "Región vinícola de Mendoza");
        RegionVitivinicola regionSanRafael = new RegionVitivinicola("San Rafael", "Región vinícola de Mendoza");
        RegionVitivinicola regionTulumValley = new RegionVitivinicola("Tulum Valley", "Región vinícola de San Juan");
        RegionVitivinicola regionMaipu = new RegionVitivinicola("Maipú", "Región vinícola de Mendoza");
        RegionVitivinicola regionPedernal = new RegionVitivinicola("Pedernal", "Región vinícola de San Juan");

        // Crear instancias de provincias
        ArrayList<RegionVitivinicola> regionesMendoza = new ArrayList<>();
        regionesMendoza.add(regionValleDeUco);
        regionesMendoza.add(regionSanRafael);
        regionesMendoza.add(regionMaipu);

        ArrayList<RegionVitivinicola> regionesSanJuan = new ArrayList<>();
        regionesSanJuan.add(regionTulumValley);
        regionesSanJuan.add(regionPedernal);

        Provincia mendoza = new Provincia("Mendoza", regionesMendoza);
        Provincia sanJuan = new Provincia("San Juan", regionesSanJuan);

        // Crear instancia de país
        ArrayList<Provincia> provinciasArgentina = new ArrayList<>();
        provinciasArgentina.add(mendoza);
        provinciasArgentina.add(sanJuan);
        Pais argentina = new Pais("Argentina", provinciasArgentina);

        // Crear instancias de bodegas
        Bodega bodegaLosAndes = new Bodega(12345, "Bodega Los Andes", "Historia de la bodega Los Andes", "Descubre nuestro nuevo Malbec Reserva", "Los Andes", LocalDate.now(), regionValleDeUco);
        Bodega bodegaLasRosas = new Bodega(23456, "Bodega Las Rosas", "Historia de la bodega Las Rosas", "¡Presentamos nuestro nuevo Cabernet Sauvignon Gran Reserva!", "Las Rosas", LocalDate.now(), regionSanRafael);
        Bodega bodegaLasPalmeras = new Bodega(34567, "Bodega Las Palmeras", "Historia de la bodega Las Palmeras", "Sorprende a tu paladar con nuestro Torrontés Dulce", "Las Palmeras", LocalDate.now(), regionTulumValley);
        Bodega bodegaSanMiguel = new Bodega(45678, "Bodega San Miguel", "Historia de la bodega San Miguel", "Prueba nuestro Merlot", "San Miguel", LocalDate.now(), regionMaipu);
        Bodega bodegaLaEstancia = new Bodega(56789, "Bodega La Estancia", "Historia de la bodega La Estancia", "Disfruta de nuestro Chardonnay", "La Estancia", LocalDate.now(), regionPedernal);

        // Crear instancias de varietal
        Varietal malbecVarietal = new Varietal("Malbec", 100, new TipoUva("Tinta", "Malbec"));
        Varietal cabernetSauvignonVarietal = new Varietal("Cabernet Sauvignon", 100, new TipoUva("Tinta", "Cabernet Sauvignon"));
        Varietal torrontesVarietal = new Varietal("Torrontés", 100, new TipoUva("Blanca", "Torrontés"));
        Varietal merlotVarietal = new Varietal("Merlot", 90, new TipoUva("Tinta", "Merlot"));
        Varietal chardonnayVarietal = new Varietal("Chardonnay", 95, new TipoUva("Blanca", "Chardonnay"));

        ArrayList<Varietal> varietal1 = new ArrayList<>();
        varietal1.add(malbecVarietal);
        ArrayList<Varietal> varietal2 = new ArrayList<>();
        varietal2.add(cabernetSauvignonVarietal);
        ArrayList<Varietal> varietal3 = new ArrayList<>();
        varietal3.add(torrontesVarietal);
        ArrayList<Varietal> varietal4 = new ArrayList<>();
        varietal4.add(merlotVarietal);
        ArrayList<Varietal> varietal5 = new ArrayList<>();
        varietal5.add(chardonnayVarietal);

        // Crear instancias de maridaje
        Maridaje maridaje1 = new Maridaje("Carnes rojas a la parrilla", "Ideal para acompañar con carnes rojas asadas, a la parrilla o al horno.");
        Maridaje maridaje2 = new Maridaje("Pescados y mariscos", "Perfecto para disfrutar con platos de pescados frescos o mariscos, especialmente con ceviches y sushi.");
        Maridaje maridaje3 = new Maridaje("Quesos suaves", "Complementa muy bien con quesos suaves como el brie o el camembert, realzando sus sabores cremosos y suaves.");
        Maridaje maridaje4 = new Maridaje("Carnes blancas", "Acompaña perfectamente con carnes blancas como el pollo o el pavo, realzando sus sabores.");
        Maridaje maridaje5 = new Maridaje("Ensaladas frescas", "Ideal para acompañar ensaladas frescas con ingredientes ligeros y crujientes.");

        // Crear instancias de vino
        Vino malbec = new Vino(LocalDate.of(2017, 1, 1), LocalDate.now(), null, "Malbec Reserva", 85, 500.0f, maridaje1, varietal1, bodegaLosAndes);
        Vino cabernetSauvignon = new Vino(LocalDate.of(2018, 1, 1), LocalDate.now(), null, "Cabernet Sauvignon Gran Reserva", 88, 600.0f, maridaje2, varietal2, bodegaLasRosas);
        Vino torrontes = new Vino(LocalDate.of(2019, 1, 1), LocalDate.now(), null, "Torrontés Dulce", 90, 700.0f, maridaje3, varietal3, bodegaLasPalmeras);
        Vino merlot = new Vino(LocalDate.of(2018, 5, 1), LocalDate.now(), null, "Merlot Reserva", 87, 550.0f, maridaje4, varietal4, bodegaSanMiguel);
        Vino chardonnay = new Vino(LocalDate.of(2020, 3, 1), LocalDate.now(), null, "Chardonnay Premium", 92, 750.0f, maridaje5, varietal5, bodegaLaEstancia);
        ArrayList<Vino> vinos = new ArrayList<>();
        vinos.add(malbec);
        vinos.add(cabernetSauvignon);
        vinos.add (torrontes);
        vinos.add(merlot);
        vinos.add(chardonnay);

        // Crear instancias de reseña
        Reseña reseñaMalbec = new Reseña("Muy buen Malbec", true, 4.5f, LocalDate.of(2022, 5, 30), malbec);
        Reseña reseñaCabernetSauvignon = new Reseña("Excelente Cabernet Sauvignon", false, 4.8f, LocalDate.of(2022, 5, 30), cabernetSauvignon);
        Reseña reseñaTorrontes = new Reseña("Refrescante Torrontés", true, 4.6f, LocalDate.of(2022, 5, 30), torrontes);
        Reseña reseñaMerlot = new Reseña("Buen Merlot", true, 4.3f, LocalDate.of(2022, 6, 15), merlot);
        Reseña reseñaChardonnay = new Reseña("Excelente Chardonnay", false, 4.9f, LocalDate.of(2022, 7, 10), chardonnay);
        
        // Añadir reseñas a los vinos correspondientes
        malbec.getReseña().add(reseñaMalbec);
        cabernetSauvignon.getReseña().add(reseñaCabernetSauvignon);
        torrontes.getReseña().add(reseñaTorrontes);
        merlot.getReseña().add(reseñaMerlot);
        chardonnay.getReseña().add(reseñaChardonnay);


        Pnl_GenerarRanking pantallaGenerarRanking = new Pnl_GenerarRanking();
        pantallaGenerarRanking.setVinos(vinos);
    }
}