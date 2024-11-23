/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu36;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author MATIAS
 */
public class CU36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estado estado1 = new Estado("Disponible","RT");
        Estado estado2 = new Estado("Cancelado","RT");
        Estado estado3 = new Estado("Reservado","T");
        Estado estado4 = new Estado("Pendiente de Confirmacion","T");
        Estado estado5 = new Estado("CanceladoPorMantCorrectivo","T");
        Estado estado6 = new Estado("ConIngresoEnMantenimientoCorrectivo","T");
        ArrayList<Estado> todosLosEstados = new ArrayList<Estado>();
        
        
        CambioEstadoRT cambioEst1 = new CambioEstadoRT(estado1,LocalDateTime.now());
        CambioEstadoRT cambioEst2 = new CambioEstadoRT(estado2,LocalDateTime.now());
        CambioEstadoRT cambioEst3 = new CambioEstadoRT(estado1,LocalDateTime.now());
        Modelo mod1 = new Modelo("FPI300");
        Modelo mod2 = new Modelo("FPI340");
        Modelo mod3 = new Modelo("AA-30");
        Marca marca1 = new Marca("FORD",mod1);
        Marca marca2 = new Marca("BGH",mod1);
        TipoRecursoTecnologico tr1 = new TipoRecursoTecnologico("TORNO");
        TipoRecursoTecnologico tr2 = new TipoRecursoTecnologico("HORNO");
        TipoRecursoTecnologico tr3 = new TipoRecursoTecnologico("PC");
        ArrayList<PersonalCientifico> personal = new ArrayList<PersonalCientifico>();
        Usuario u1 = new Usuario("gaton");
        Usuario u2 = new Usuario("maria");
        Usuario u3 = new Usuario("APSNV");
        Usuario u4 = new Usuario("masdas");
        Usuario u5 = new Usuario("qovoma");
        Usuario u6 = new Usuario("924n9boa");
        Usuario u7 = new Usuario("pzxmvoo");
        Sesion s1 = new Sesion(u1);
        
        
        PersonalCientifico p1 = new PersonalCientifico("gastonlopez@gmail.com","gastonlopez@gmail.com",89,"GASTON LOPEZ",30231345,15408220,u1);
        PersonalCientifico p2 = new PersonalCientifico("maria@gmail.com","maria@outlock.com",81,"MARIA RODRIGUEZ",40231345,15439909,u2);
        personal.add(p1);
        personal.add(p2);

        
        PersonalCientifico p3 = new PersonalCientifico("gbsSR@gmail.com","gbsSR@gmail.com",70,"PEPE LOPEZ",30231345,15409920,u3);
        PersonalCientifico p4 = new PersonalCientifico("mSBsgrsr@gmail.com","mSBsgrsr@gmail.com",71,"DIEGO RODRIGUEZ",40231345,15689909,u4);
        PersonalCientifico p5 = new PersonalCientifico("sbSBl.com","sbSBl.com",72,"MARTA VIDAL",40231345,15439909,u5);
        PersonalCientifico p6 = new PersonalCientifico("mDBBSDBSDBSDBia@gmail.com","mDBBSDBSDBSDBia@gmail.com",73,"LAURA DIAS",40231345,15409909,u6);
        PersonalCientifico p7 = new PersonalCientifico("QQQQQ@gmail.com","QQQQQ@gmail.com",74,"CARLOS GONZALES",24231345,15439009,u7);
        AsignacionCientificoDelCI aCI1 = new AsignacionCientificoDelCI(LocalDate.of(2022,05,01),LocalDate.of(2022,05,01),p3);
        AsignacionCientificoDelCI aCI2 = new AsignacionCientificoDelCI(LocalDate.of(2022,05,01),LocalDate.of(2022,05,01),p4);
        AsignacionCientificoDelCI aCI3 = new AsignacionCientificoDelCI(LocalDate.of(2022,05,01),LocalDate.of(2022,05,01),p5);
        AsignacionCientificoDelCI aCI4 = new AsignacionCientificoDelCI(LocalDate.of(2022,05,01),LocalDate.of(2022,05,01),p6);
        AsignacionCientificoDelCI aCI5 = new AsignacionCientificoDelCI(LocalDate.of(2022,05,01),LocalDate.of(2022,05,01),p7);
        
        CambioEstadoTurno cambioEstT1 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT2 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        CambioEstadoTurno cambioEstT3 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        CambioEstadoTurno cambioEstT4 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        CambioEstadoTurno cambioEstT5 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT6 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT7 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT8 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        CambioEstadoTurno cambioEstT9 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        CambioEstadoTurno cambioEstT10 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT11 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT12 = new CambioEstadoTurno(estado3,LocalDateTime.now());
        CambioEstadoTurno cambioEstT13 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        CambioEstadoTurno cambioEstT14 = new CambioEstadoTurno(estado4,LocalDateTime.now());
        Turnos t1 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT1,aCI1);
        Turnos t2 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT2,aCI4);
        Turnos t3 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT3,aCI4);
        Turnos t4 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT4,aCI3);
        Turnos t5 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT5,aCI2);
        Turnos t6 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT6,aCI5);
        Turnos t7 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT7,aCI1);
        Turnos t8 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT8,aCI1);
        Turnos t9 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT9,aCI5);
        Turnos t10 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT10,aCI2);
        Turnos t11 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT11,aCI2);
        Turnos t12 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT12,aCI3);
        Turnos t13 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT13,aCI2);
        Turnos t14 = new Turnos(LocalDate.of(2022,05,01),LocalDateTime.of(2022,03,20,15,00),LocalDateTime.of(2022,03,20,17,00),cambioEstT14,aCI4);
        
        ArrayList<Turnos> turnosR1 = new ArrayList<Turnos>();
        ArrayList<Turnos> turnosR2 = new ArrayList<Turnos>();
        ArrayList<Turnos> turnosR3 = new ArrayList<Turnos>();
        turnosR1.add(t1);
        turnosR1.add(t2);
        turnosR1.add(t3);
        turnosR1.add(t4);
        turnosR2.add(t5);
        turnosR2.add(t6);
        turnosR2.add(t7);
        turnosR2.add(t8);
        turnosR2.add(t9);
        turnosR2.add(t10);
        turnosR3.add(t11);
        turnosR3.add(t12);
        turnosR3.add(t13);
        turnosR3.add(t14);
        RecursoTecnologico r1 = new RecursoTecnologico(cambioEst1,marca2,380,tr2,turnosR1);
        RecursoTecnologico r2 = new RecursoTecnologico(cambioEst2,marca2,380,tr3,turnosR2);
        RecursoTecnologico r3 = new RecursoTecnologico(cambioEst3,marca1,380,tr1,turnosR3);
        ArrayList<RecursoTecnologico> todosLosRT = new ArrayList<RecursoTecnologico>();
        todosLosRT.add(r1);
        todosLosRT.add(r2);
        todosLosRT.add(r3);
        ArrayList<RecursoTecnologico> asignacion1 = new ArrayList<RecursoTecnologico>();
        asignacion1.add(r1);
        asignacion1.add(r2);
        ArrayList<RecursoTecnologico> asignacion2 = new ArrayList<RecursoTecnologico>();
        asignacion2.add(r1);
        asignacion2.add(r3);
        
        
        AsignacionRTRT a1 = new AsignacionRTRT(LocalDateTime.now(),LocalDateTime.of(2022, 9, 10, 8, 0),asignacion1,p1);
        AsignacionRTRT a2 = new AsignacionRTRT(LocalDateTime.now(),LocalDateTime.of(2022, 9, 10, 8, 0),asignacion2,p2);
        ArrayList<AsignacionRTRT> asignaciones1 = new ArrayList<AsignacionRTRT>();
        asignaciones1.add(a1);
        ArrayList<AsignacionRTRT> asignaciones2 = new ArrayList<AsignacionRTRT>();
        asignaciones2.add(a2);
        p1.setAsignacion(asignaciones1);
        p2.setAsignacion(asignaciones2);
        
        
        PantRegIngresoRTenMantCorrectivo pantalla = new PantRegIngresoRTenMantCorrectivo(personal,s1,todosLosRT,todosLosEstados);
        pantalla.opcionRegistrarReserva();
    }
    
}
