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
        regionValleDeUco.setProvincia(mendoza);
        regionSanRafael.setProvincia(mendoza);
        regionMaipu.setProvincia(mendoza);
        regionTulumValley.setProvincia(sanJuan);
        regionPedernal.setProvincia(sanJuan);
        

        // Crear instancia de país
        ArrayList<Provincia> provinciasArgentina = new ArrayList<>();
        provinciasArgentina.add(mendoza);
        provinciasArgentina.add(sanJuan);
        Pais argentina = new Pais("Argentina", provinciasArgentina);
        mendoza.setPais(argentina);
        sanJuan.setPais(argentina);

        // Crear instancias de bodegas
        Bodega bodegaLosAndes = new Bodega(12345, "Bodega Los Andes", "Historia de la bodega Los Andes",  "Los Andes", LocalDate.now(), regionValleDeUco);
        Bodega bodegaLasRosas = new Bodega(23456, "Bodega Las Rosas", "Historia de la bodega Las Rosas",  "Las Rosas", LocalDate.now(), regionSanRafael);
        Bodega bodegaLasPalmeras = new Bodega(34567, "Bodega Las Palmeras", "Historia de la bodega Las Palmeras",  "Las Palmeras", LocalDate.now(), regionTulumValley);
        Bodega bodegaSanMiguel = new Bodega(45678, "Bodega San Miguel", "Historia de la bodega San Miguel",  "San Miguel", LocalDate.now(), regionMaipu);
        Bodega bodegaLaEstancia = new Bodega(56789, "Bodega La Estancia", "Historia de la bodega La Estancia", "La Estancia", LocalDate.now(), regionPedernal);

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
        ArrayList<Maridaje> aMaridaje1 = new ArrayList<>();
        aMaridaje1.add(maridaje1);
        ArrayList<Maridaje> aMaridaje2 = new ArrayList<>();
        aMaridaje2.add(maridaje2);
        ArrayList<Maridaje> aMaridaje3 = new ArrayList<>();
        aMaridaje3.add(maridaje3);
        ArrayList<Maridaje> aMaridaje4 = new ArrayList<>();
        aMaridaje4.add(maridaje4);
        ArrayList<Maridaje> aMaridaje5 = new ArrayList<>();
        aMaridaje5.add(maridaje5);

        // Crear instancias de vino
        Vino malbec = new Vino(LocalDate.of(2017, 1, 1), LocalDate.now(), null, "Malbec Reserva", 85, 500.0f, aMaridaje1, varietal1, bodegaLosAndes);
        Vino cabernetSauvignon = new Vino(LocalDate.of(2018, 1, 1), LocalDate.now(), null, "Cabernet Sauvignon Gran Reserva", 88, 600.0f, aMaridaje2, varietal2, bodegaLasRosas);
        Vino torrontes = new Vino(LocalDate.of(2019, 1, 1), LocalDate.now(), null, "Torrontés Dulce", 90, 700.0f, aMaridaje3, varietal3, bodegaLasPalmeras);
        Vino merlot = new Vino(LocalDate.of(2018, 5, 1), LocalDate.now(), null, "Merlot Reserva", 87, 550.0f, aMaridaje4, varietal4, bodegaSanMiguel);
        Vino chardonnay = new Vino(LocalDate.of(2020, 3, 1), LocalDate.now(), null, "Chardonnay Premium", 92, 750.0f, aMaridaje5, varietal5, bodegaLaEstancia);
        Vino syrah = new Vino(LocalDate.of(2016, 2, 1), LocalDate.now(), null, "Syrah Especial", 86, 520.0f, aMaridaje1, varietal1, bodegaLosAndes);
        Vino pinotNoir = new Vino(LocalDate.of(2017, 3, 1), LocalDate.now(), null, "Pinot Noir Elegante", 89, 640.0f, aMaridaje2, varietal2, bodegaLasRosas);
        Vino sauvignonBlanc = new Vino(LocalDate.of(2019, 4, 1), LocalDate.now(), null, "Sauvignon Blanc Fresco", 91, 710.0f, aMaridaje3, varietal3, bodegaLasPalmeras);
        Vino tempranillo = new Vino(LocalDate.of(2018, 6, 1), LocalDate.now(), null, "Tempranillo Joven", 85, 560.0f, aMaridaje4, varietal4, bodegaSanMiguel);
        Vino gewurztraminer = new Vino(LocalDate.of(2020, 8, 1), LocalDate.now(), null, "Gewürztraminer Exótico", 93, 780.0f, aMaridaje5, varietal5, bodegaLaEstancia);
        Vino zinfandel = new Vino(LocalDate.of(2016, 2, 15), LocalDate.now(), null, "Zinfandel Intenso", 87, 530.0f, aMaridaje1, varietal1, bodegaLosAndes);
        Vino carmenere = new Vino(LocalDate.of(2017, 3, 20), LocalDate.now(), null, "Carménère Suave", 90, 650.0f, aMaridaje2, varietal2, bodegaLasRosas);
        Vino riesling = new Vino(LocalDate.of(2019, 4, 25), LocalDate.now(), null, "Riesling Delicado", 92, 720.0f, aMaridaje3, varietal3, bodegaLasPalmeras);
        Vino garnacha = new Vino(LocalDate.of(2018, 6, 30), LocalDate.now(), null, "Garnacha Aromática", 86, 570.0f, aMaridaje4, varietal4, bodegaSanMiguel);
        Vino albarino = new Vino(LocalDate.of(2020, 8, 10), LocalDate.now(), null, "Albariño Refrescante", 94, 790.0f, aMaridaje5, varietal5, bodegaLaEstancia);
        
        ArrayList<Vino> vinos = new ArrayList<>();
        vinos.add(zinfandel);
        vinos.add(carmenere);
        vinos.add(riesling);
        vinos.add(garnacha);
        vinos.add(albarino);
        vinos.add(malbec);
        vinos.add(cabernetSauvignon);
        vinos.add(torrontes);
        vinos.add(merlot);
        vinos.add(chardonnay);
        vinos.add(syrah);
        vinos.add(pinotNoir);
        vinos.add(sauvignonBlanc);
        vinos.add(tempranillo);
        vinos.add(gewurztraminer);
        
        
        // Crear instancias de reseña
        Reseña reseñaMalbec = new Reseña("Muy buen Malbec", true, 4.5f, LocalDate.of(2024, 6, 30), malbec);
        Reseña reseñaCabernetSauvignon = new Reseña("Excelente Cabernet Sauvignon", true, 4.8f, LocalDate.of(2024, 6, 30), cabernetSauvignon);
        Reseña reseñaTorrontes = new Reseña("Refrescante Torrontés", true, 4.6f, LocalDate.of(2024, 6, 30), torrontes);
        Reseña reseñaMerlot = new Reseña("Buen Merlot", true, 4.3f, LocalDate.of(2024, 6, 30), merlot);
        Reseña reseñaChardonnay = new Reseña("Excelente Chardonnay", true, 4.9f, LocalDate.of(2024, 6, 30), chardonnay);
        Reseña reseña1 = new Reseña("Muy buen Malbec", true, 4.5f, LocalDate.of(2024, 6, 29), malbec);
        malbec.getReseña().add(reseña1);
        Reseña reseña2 = new Reseña("Excelente Cabernet Sauvignon", true, 4.8f, LocalDate.of(2024, 6, 29), cabernetSauvignon);
        cabernetSauvignon.getReseña().add(reseña2);
        Reseña reseña3 = new Reseña("Refrescante Torrontés", true, 4.6f, LocalDate.of(2024, 6, 29), torrontes);
        torrontes.getReseña().add(reseña3);
        Reseña reseña4 = new Reseña("Buen Merlot", true, 4.3f, LocalDate.of(2024, 6, 30), merlot);
        merlot.getReseña().add(reseña4);
        Reseña reseña5 = new Reseña("Excelente Chardonnay", true, 4.9f, LocalDate.of(2024, 6, 29), chardonnay);
        chardonnay.getReseña().add(reseña5);
        Reseña reseña6 = new Reseña("Increíble sabor", true, 4.7f, LocalDate.of(2024, 6, 15), malbec);
        malbec.getReseña().add(reseña6);
        Reseña reseña7 = new Reseña("Perfecto para carnes", true, 4.6f, LocalDate.of(2024, 6, 16), cabernetSauvignon);
        cabernetSauvignon.getReseña().add(reseña7);
        Reseña reseña8 = new Reseña("Muy suave", true, 4.5f, LocalDate.of(2024, 6, 17), torrontes);
        torrontes.getReseña().add(reseña8);
        Reseña reseña9 = new Reseña("Ideal para postres", true, 4.4f, LocalDate.of(2024, 6, 18), merlot);
        merlot.getReseña().add(reseña9);
        Reseña reseña10 = new Reseña("Gran aroma", true, 4.8f, LocalDate.of(2024, 6, 19), chardonnay);
        chardonnay.getReseña().add(reseña10);
        Reseña reseña11 = new Reseña("Mejor de lo esperado", true, 4.6f, LocalDate.of(2024, 6, 20), malbec);
        malbec.getReseña().add(reseña11);
        Reseña reseña12 = new Reseña("Fresco y afrutado", true, 4.7f, LocalDate.of(2024, 6, 21), cabernetSauvignon);
        cabernetSauvignon.getReseña().add(reseña12);
        Reseña reseña13 = new Reseña("Buena relación calidad/precio", true, 4.5f, LocalDate.of(2024, 6, 22), torrontes);
        torrontes.getReseña().add(reseña13);
        Reseña reseña14 = new Reseña("Exquisito", true, 4.9f, LocalDate.of(2024, 6, 23), merlot);
        merlot.getReseña().add(reseña14);
        Reseña reseña15 = new Reseña("Intenso y complejo", true, 4.8f, LocalDate.of(2024, 6, 24), chardonnay);
        chardonnay.getReseña().add(reseña15);
        Reseña reseña16 = new Reseña("Excelente elección", true, 4.9f, LocalDate.of(2024, 6, 25), malbec);
        malbec.getReseña().add(reseña16);
        Reseña reseña17 = new Reseña("Recomendado", true, 4.7f, LocalDate.of(2024, 6, 26), cabernetSauvignon);
        cabernetSauvignon.getReseña().add(reseña17);
        
        
        // Añadir reseñas a los vinos correspondientes
        malbec.getReseña().add(reseñaMalbec);
        cabernetSauvignon.getReseña().add(reseñaCabernetSauvignon);
        torrontes.getReseña().add(reseñaTorrontes);
        merlot.getReseña().add(reseñaMerlot);
        chardonnay.getReseña().add(reseñaChardonnay);
    
        System.out.println("Estoy ejecutando el main");
        Pnl_GenerarRanking pantallaGenerarRanking = new Pnl_GenerarRanking();
        pantallaGenerarRanking.setVinos(vinos);
        InterfazInicioBonVino.main(args, pantallaGenerarRanking);
        System.out.println("CREE TODO");

    }
}