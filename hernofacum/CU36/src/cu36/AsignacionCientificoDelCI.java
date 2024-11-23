package cu36;

import java.time.LocalDate;

public class AsignacionCientificoDelCI {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private PersonalCientifico personalCientifico;

    public AsignacionCientificoDelCI(LocalDate fechaDesde, LocalDate fechaHasta, PersonalCientifico personalCientifico) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.personalCientifico=personalCientifico;
    }

    public String buscarCientifico(){
        return personalCientifico.mostrarPersonalCientifico();
    }

    public boolean esCientificoActivo(){
        return false;
    }

    public void misTurnos(){

    }

    public void mostrarCientificoDelCI(){

    }

    public String notificarCientificosRTMantenimiento(){
        return personalCientifico.notificarCientificosRTMantenimiento();
    }


    //GETTERS Y SETTERS
    public LocalDate getFechaDesde() {
        return this.fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return this.fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

}
