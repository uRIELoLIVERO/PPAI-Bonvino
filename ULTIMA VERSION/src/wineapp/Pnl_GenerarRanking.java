/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineapp;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public class Pnl_GenerarRanking extends javax.swing.JFrame {
    private ArrayList<Vino> vinos = new ArrayList<Vino>();
    private GestorRanking gestor;
    private ArrayList<String> formasVisualizacion = new ArrayList<String>();
    public Pnl_GenerarRanking() {
        
        initComponents();
        setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(Calendary, "src/wineapp/resources/images/calendary.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(Reseña, "src/wineapp/resources/images/reseña.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(fotoVisualizacion, "src/wineapp/resources/images/formaVisualizacion.png");
        //rsscalelabel.RSScaleLabel.setScaleLabel(flecha, "src/wineapp/resources/images/flecha.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(pdf, "src/wineapp/resources/images/pdf.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(xls, "src/wineapp/resources/images/xls.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(compu, "src/wineapp/resources/images/compu.png");
        
        setPanelEnabled(PanelTReseña, false);
        setPanelEnabled(PanelFVisualizacion, false);
        setPanelEnabled(panelBoton, false);
        
        
        botonConfirmar.setForeground(Color.BLACK); // Inicialmente, el color del texto es negro
        botonConfirmar.setBackground(Color.decode("#cccccc"));
        botonConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonConfirmar.setBackground(Color.decode("#a83232")); // Color más claro cuando el mouse pasa por encima
                botonConfirmar.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
        }

            @Override
            public void mouseExited(MouseEvent e) {
                botonConfirmar.setBackground(Color.decode("#cccccc")); // Color de fondo inicial
                botonConfirmar.setForeground(Color.BLACK); // Volver el color del texto a negro
        }
        
        });
        
        // Añadir PropertyChangeListener a fechaDesde
        fechaDesde.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                validarFechas();
            }
        });
        // Añadir PropertyChangeListener a fechaHasta
        fechaHasta.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                validarFechas();
            }
        });
        
        // Añadir ActionListener a jComboBox1
        comboBoxReseña.addActionListener((ActionEvent e) -> {
            if (comboBoxReseña.getSelectedItem() != null && !comboBoxReseña.getSelectedItem().toString().trim().isEmpty()) {
                PanelFVisualizacion.setEnabled(true);
                for (java.awt.Component c : PanelFVisualizacion.getComponents()) c.setEnabled(true);
            } else {
                PanelFVisualizacion.setEnabled(false);
                for (java.awt.Component c : PanelFVisualizacion.getComponents()) c.setEnabled(false);
            }
        });
        ActionListener radioButtonListener = (ActionEvent e) -> {
            panelBoton.setEnabled(true);
            for (java.awt.Component c : panelBoton.getComponents()) {
                c.setEnabled(true);
            }
        };
        
        botonPdf.addActionListener(radioButtonListener);
        botonXls.addActionListener(radioButtonListener);
        botonCompu.addActionListener(radioButtonListener);
        
        botonConfirmar.setText("Confirmar");
        botonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(evt);
                }
        });
    }
    private void validarFechas() {
        Date fromDate = fechaDesde.getDate();
        Date toDate = fechaHasta.getDate();

        if (fromDate != null && toDate != null) {
            if (fromDate.after(toDate)) {
                JOptionPane.showMessageDialog(null, "Las fechas no son validas", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                fechaHasta.setDate(null);
                setPanelEnabled(PanelTReseña, false);
                setPanelEnabled(PanelFVisualizacion, false);
                setPanelEnabled(panelBoton, false);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(fromDate);
                System.out.println("Fecha desde: " + dateString);
                solicitarSelecTipoReseña();
            }
        }
    }
    public void solicitarFechasRanking(){
        fechaDesde.setEnabled(true);
        fechaHasta.setEnabled(true);
        if (!gestor.validarFechas(tomarSelecFechaInicio(), tomarSelecFechaFin())){
            JOptionPane.showMessageDialog(null, "Las fechas no son validas", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
                fechaHasta.setDate(null);
                setPanelEnabled(PanelTReseña, false);
                setPanelEnabled(PanelFVisualizacion, false);
                setPanelEnabled(panelBoton, false);
            } else {
                setPanelEnabled(PanelTReseña, true);
                System.out.print("anda");
        };
    }

    private LocalDate tomarSelecFechaInicio(){
        Date date = fechaDesde.getDate();
        Instant instant = date.toInstant();
        
        // Convierte el Instant a LocalDate
        LocalDate fechaDesde = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return fechaDesde;
    }
    
    private LocalDate tomarSelecFechaFin(){
        Date date = fechaHasta.getDate();
        Instant instant = date.toInstant();
        
        LocalDate fechaHasta = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        return fechaHasta;
    }
    
    private void solicitarSelecTipoReseña(){
        setPanelEnabled(PanelTReseña, true);
        comboBoxReseña.setEnabled(true);
        tomarSelecTipoReseña();
    }
    public void tomarSelecTipoReseña(){
        String tipoReseñaSelect = (String) comboBoxReseña.getSelectedItem();
        gestor.tomarTipoReseñasSelec(tipoReseñaSelect);
        
    }
    public void mostrarFormaVisualizacionParaSelec(ArrayList<String> formasVisualizacion){
        PanelFVisualizacion.setEnabled(true);
        this.formasVisualizacion = formasVisualizacion;
        tomarSelecFormaVisualizacion();
        
    }
    public void tomarSelecFormaVisualizacion(){
        String formaVisualizacionSelec = "";
        if (botonPdf.isSelected()) {
        formaVisualizacionSelec = formasVisualizacion.get(0);
    } else if (botonXls.isSelected()) {
        formaVisualizacionSelec = formasVisualizacion.get(1);
    } else if (botonCompu.isSelected()) {
        formaVisualizacionSelec = formasVisualizacion.get(2);
    }
        gestor.tomarSelecFormaVisualizacion(formaVisualizacionSelec);
    }
    
    public void solicitarConfirmacion(){
      panelBoton.setEnabled(true); 
      tomarConfirmacion();
    }
    
    private void botonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        InterfazRegistroBonVino interfazMensaje= new InterfazRegistroBonVino();
        interfazMensaje.setVisible(true);
        this.setVisible(false);
    }
    
    private void setPanelEnabled(javax.swing.JPanel panel, boolean isEnabled) {
        panel.setEnabled(isEnabled);
        for (java.awt.Component component : panel.getComponents()) {
            component.setEnabled(isEnabled);
        }
    }
    public void opcGenerarRankingVinos() {
        this.gestor = new GestorRanking();
        gestor.setVinos(vinos);
        gestor.setPantalla(this);
        habilitarVentana();
        gestor.generarRankingVinos();
    }
    public void habilitarVentana(){
        setVisible(true);
    }
    public void setVinos(ArrayList<Vino> vinos){
        this.vinos = vinos;
    }
    
    public void tomarConfirmacion(){
        gestor.tomarConfirmacion();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        fondo = new javax.swing.JPanel();
        FondoCentro = new javax.swing.JPanel();
        PanelCalendary = new javax.swing.JPanel();
        Calendary = new javax.swing.JLabel();
        FechaDesde = new javax.swing.JLabel();
        FechaHasta = new javax.swing.JLabel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        PanelTReseña = new javax.swing.JPanel();
        Reseña = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxReseña = new javax.swing.JComboBox<>();
        PanelFVisualizacion = new javax.swing.JPanel();
        fotoVisualizacion = new javax.swing.JLabel();
        formaVisualizacion = new javax.swing.JLabel();
        botonPdf = new javax.swing.JRadioButton();
        botonXls = new javax.swing.JRadioButton();
        botonCompu = new javax.swing.JRadioButton();
        pdf = new javax.swing.JLabel();
        xls = new javax.swing.JLabel();
        compu = new javax.swing.JLabel();
        panelBoton = new javax.swing.JPanel();
        botonConfirmar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));

        fondo.setBackground(new java.awt.Color(166, 57, 57));
        fondo.setPreferredSize(new java.awt.Dimension(1080, 720));

        FondoCentro.setMinimumSize(new java.awt.Dimension(880, 480));

        Calendary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wineapp/resources/images/calendary.png"))); // NOI18N

        FechaDesde.setForeground(new java.awt.Color(166, 57, 57));
        FechaDesde.setText("FECHA DESDE");

        FechaHasta.setForeground(new java.awt.Color(166, 57, 57));
        FechaHasta.setText("FECHA HASTA");

        fechaDesde.setBackground(new java.awt.Color(166, 57, 57));

        fechaHasta.setBackground(new java.awt.Color(166, 57, 57));

        javax.swing.GroupLayout PanelCalendaryLayout = new javax.swing.GroupLayout(PanelCalendary);
        PanelCalendary.setLayout(PanelCalendaryLayout);
        PanelCalendaryLayout.setHorizontalGroup(
            PanelCalendaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCalendaryLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(PanelCalendaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Calendary)
                    .addGroup(PanelCalendaryLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(PanelCalendaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FechaHasta)
                            .addComponent(FechaDesde)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        PanelCalendaryLayout.setVerticalGroup(
            PanelCalendaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCalendaryLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(Calendary)
                .addGap(20, 20, 20)
                .addComponent(FechaDesde)
                .addGap(18, 18, 18)
                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(FechaHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        Reseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wineapp/resources/images/calendary.png"))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(166, 57, 57));
        jLabel1.setText("TIPO DE RESEÑA");

        comboBoxReseña.setBackground(new java.awt.Color(236, 236, 236));
        comboBoxReseña.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normales", "De Amigos", "De Sommelier" }));

        javax.swing.GroupLayout PanelTReseñaLayout = new javax.swing.GroupLayout(PanelTReseña);
        PanelTReseña.setLayout(PanelTReseñaLayout);
        PanelTReseñaLayout.setHorizontalGroup(
            PanelTReseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTReseñaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(PanelTReseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Reseña, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        PanelTReseñaLayout.setVerticalGroup(
            PanelTReseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTReseñaLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(Reseña, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(comboBoxReseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fotoVisualizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wineapp/resources/images/calendary.png"))); // NOI18N

        formaVisualizacion.setForeground(new java.awt.Color(166, 57, 57));
        formaVisualizacion.setText("FORMA DE VISUALIZACION");

        grupoBotones.add(botonPdf);

        grupoBotones.add(botonXls);

        grupoBotones.add(botonCompu);

        javax.swing.GroupLayout PanelFVisualizacionLayout = new javax.swing.GroupLayout(PanelFVisualizacion);
        PanelFVisualizacion.setLayout(PanelFVisualizacionLayout);
        PanelFVisualizacionLayout.setHorizontalGroup(
            PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFVisualizacionLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formaVisualizacion)
                    .addComponent(fotoVisualizacion)
                    .addGroup(PanelFVisualizacionLayout.createSequentialGroup()
                        .addGroup(PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonCompu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonXls, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonPdf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xls, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        PanelFVisualizacionLayout.setVerticalGroup(
            PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFVisualizacionLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(fotoVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(formaVisualizacion)
                .addGroup(PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFVisualizacionLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(botonPdf))
                    .addGroup(PanelFVisualizacionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonXls)
                    .addComponent(xls, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFVisualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCompu)
                    .addComponent(compu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonConfirmar.setText("Confirmar");

        javax.swing.GroupLayout panelBotonLayout = new javax.swing.GroupLayout(panelBoton);
        panelBoton.setLayout(panelBotonLayout);
        panelBotonLayout.setHorizontalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(65, 65, 65))
        );
        panelBotonLayout.setVerticalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addComponent(botonConfirmar)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FondoCentroLayout = new javax.swing.GroupLayout(FondoCentro);
        FondoCentro.setLayout(FondoCentroLayout);
        FondoCentroLayout.setHorizontalGroup(
            FondoCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoCentroLayout.createSequentialGroup()
                        .addComponent(PanelCalendary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelTReseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoCentroLayout.createSequentialGroup()
                        .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(PanelFVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoCentroLayout.setVerticalGroup(
            FondoCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelFVisualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCalendary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTReseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        regresar.setBackground(new java.awt.Color(135, 44, 44));
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wineapp/resources/images/flechaFinal.png"))); // NOI18N
        regresar.setText("regresar");
        regresar.setPreferredSize(new java.awt.Dimension(62, 45));

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(FondoCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(FondoCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        getContentPane().add(fondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Después de inicializar el botón "regresar"
    

    
    public static void main(String args[]) {

        JButton botonConfirmar = new JButton();
        botonConfirmar.setBackground(Color.decode("#cccccc"));

        // Añadir el MouseListener
        botonConfirmar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonConfirmar.setBackground(Color.decode("#ffaaaa"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonConfirmar.setBackground(Color.decode("#cccccc"));
            }
        });
        
        java.awt.EventQueue.invokeLater(() -> {
            new Pnl_GenerarRanking().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Calendary;
    private javax.swing.JLabel FechaDesde;
    private javax.swing.JLabel FechaHasta;
    private javax.swing.JPanel FondoCentro;
    private javax.swing.JPanel PanelCalendary;
    private javax.swing.JPanel PanelFVisualizacion;
    private javax.swing.JPanel PanelTReseña;
    private javax.swing.JLabel Reseña;
    private javax.swing.JRadioButton botonCompu;
    private javax.swing.JButton botonConfirmar;
    private javax.swing.JRadioButton botonPdf;
    private javax.swing.JRadioButton botonXls;
    private javax.swing.JComboBox<String> comboBoxReseña;
    private javax.swing.JLabel compu;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel formaVisualizacion;
    private javax.swing.JLabel fotoVisualizacion;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JLabel pdf;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel xls;
    // End of variables declaration//GEN-END:variables
}
