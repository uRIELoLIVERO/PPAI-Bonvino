/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineapp;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Facundo
 */
public class InterfazInicioBonVino extends javax.swing.JFrame {

    /**
     * Creates new form InterfazBonVino
     */
    public InterfazInicioBonVino() {
        initComponents();
         this.setLocationRelativeTo(null);
         SetImageLabel (jLabel1, "src/wineapp/resources/images/fotoVinoPrueba.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PanelMenu = new javax.swing.JPanel();
        opcGenerarRankingVinos = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(166, 57, 57));
        setMinimumSize(new java.awt.Dimension(1080, 720));

        jPanel2.setBackground(new java.awt.Color(166, 57, 57));
        jPanel2.setMaximumSize(new java.awt.Dimension(1080, 321321));
        jPanel2.setMinimumSize(new java.awt.Dimension(1080, 720));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Gilda Display", 1, 56)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bonvino");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 230, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wineapp/resources/images/botonMenu.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 50, 60));

        PanelMenu.setBackground(new java.awt.Color(135, 44, 44));
        PanelMenu.setToolTipText("");
        PanelMenu.setAlignmentX(0.0F);
        PanelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelMenu.setEnabled(false);
        PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opcGenerarRankingVinos.setBackground(new java.awt.Color(135, 44, 44));
        opcGenerarRankingVinos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        opcGenerarRankingVinos.setForeground(new java.awt.Color(255, 255, 255));
        opcGenerarRankingVinos.setText("GENERAR RANKING VINOS");
        opcGenerarRankingVinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcGenerarRankingVinosActionPerformed(evt);
            }
        });
        PanelMenu.add(opcGenerarRankingVinos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 50));

        jButton4.setBackground(new java.awt.Color(135, 44, 44));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("IMPORTAR ACTUALIZACIÓN DE VINOS DE BODEGA");
        PanelMenu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        jPanel2.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 340, 110));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 450));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handing code here:
        if (PanelMenu.isVisible()){
            PanelMenu.setVisible(false);
        }else{
        PanelMenu.setVisible(true);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void opcGenerarRankingVinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcGenerarRankingVinosActionPerformed
        // TODO add your handling code here:
        Pnl_GenerarRanking pantallaGenerarRanking= new Pnl_GenerarRanking();
        pantallaGenerarRanking.setVisible(true);
        pantallaGenerarRanking.opcGenerarRankingVinos();
    }//GEN-LAST:event_opcGenerarRankingVinosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioBonVino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioBonVino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioBonVino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioBonVino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InterfazInicioBonVino().setVisible(true);
        });
    }
    private void SetImageLabel (JLabel labelName, String root){
        ImageIcon image = new ImageIcon (root);
        labelName.setIcon(null);
    
        Icon icon = new ImageIcon(
            image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMenu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton opcGenerarRankingVinos;
    // End of variables declaration//GEN-END:variables
}
