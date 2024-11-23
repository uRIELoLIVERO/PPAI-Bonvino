/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronObserver;

/**
 *
 * @author MATIAS
 */
public class InterfazMail implements IObservador{

    @Override
    public void notificarCientificosRTMantenimiento(String motivo, String mail) {
        enviarMail(motivo,mail);
    }

    private void enviarMail(String motivo, String mail) {
        System.out.println("se mando el mail a "+mail+"; con el motivo: "+motivo);
    }

    
}
