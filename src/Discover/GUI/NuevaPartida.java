/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.GUI;

/**
 *
 * @author dany
 */
public class NuevaPartida extends javax.swing.JFrame {

    /**
     * Creates new form NuevoTablero
     */
    public NuevaPartida() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCantJugadoresMax = new javax.swing.JLabel();
        labelCanDineroInicial = new javax.swing.JLabel();
        labelCantDineroVuelta = new javax.swing.JLabel();
        labelCantDados = new javax.swing.JLabel();
        labelCantCasasMax = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelCantHotelesMax = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jSliderCantidadJugadores = new javax.swing.JSlider();
        jSliderCantidadDados = new javax.swing.JSlider();
        txtCantidadHotelesMax = new javax.swing.JTextField();
        txtCantidadCasasMax1 = new javax.swing.JTextField();
        txtCantidadDineroVuelta = new javax.swing.JTextField();
        txtCantidadDineroInical = new javax.swing.JTextField();
        txtCantidadCasillas = new javax.swing.JTextField();
        labelCanCasillas = new javax.swing.JLabel();
        txtCantidadTarjetas = new javax.swing.JTextField();
        labelCantTarjetas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Tablero");
        setName("nuevoTablero"); // NOI18N

        labelCantJugadoresMax.setText("Cantidad  de Juagadores Max.");

        labelCanDineroInicial.setText("Cantidad de dinero Inicial");

        labelCantDineroVuelta.setText("Cantidad de dinero por vuelta");

        labelCantDados.setText("Cantidad de dados");

        labelCantCasasMax.setText("Cantidad de casas Max. ");

        labelCantHotelesMax.setText("Cantidad de hoteles Max. ");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jSliderCantidadJugadores.setMajorTickSpacing(1);
        jSliderCantidadJugadores.setMaximum(6);
        jSliderCantidadJugadores.setMinimum(2);
        jSliderCantidadJugadores.setPaintLabels(true);
        jSliderCantidadJugadores.setPaintTicks(true);
        jSliderCantidadJugadores.setValue(2);
        jSliderCantidadJugadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jSliderCantidadDados.setMajorTickSpacing(1);
        jSliderCantidadDados.setMaximum(3);
        jSliderCantidadDados.setMinimum(1);
        jSliderCantidadDados.setPaintLabels(true);
        jSliderCantidadDados.setPaintTicks(true);
        jSliderCantidadDados.setValue(2);
        jSliderCantidadDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtCantidadHotelesMax.setText("4");

        txtCantidadCasasMax1.setText("4");

        txtCantidadDineroVuelta.setText("220");
        txtCantidadDineroVuelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadDineroVueltaActionPerformed(evt);
            }
        });

        txtCantidadDineroInical.setText("5000");

        txtCantidadCasillas.setText("12");
        txtCantidadCasillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadCasillasActionPerformed(evt);
            }
        });

        labelCanCasillas.setText("Cantidad casillas");

        txtCantidadTarjetas.setText("12");
        txtCantidadTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadTarjetasActionPerformed(evt);
            }
        });

        labelCantTarjetas.setText("Cantidad Tarjetas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSliderCantidadDados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCantidadTarjetas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelCantDados, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelCantHotelesMax, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSliderCantidadJugadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(labelCantJugadoresMax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCantTarjetas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCantidadHotelesMax, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelCantCasasMax)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(txtCantidadCasasMax1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCantidadDineroVuelta, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCantDineroVuelta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCantidadDineroInical, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(labelCanDineroInicial))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadCasillas)
                            .addComponent(labelCanCasillas))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCantJugadoresMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderCantidadJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCanCasillas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidadCasillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantDados)
                    .addComponent(labelCanDineroInicial))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSliderCantidadDados, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelCantTarjetas)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtCantidadDineroInical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(labelCantDineroVuelta)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadDineroVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCantHotelesMax)
                            .addComponent(labelCantCasasMax))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadHotelesMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadCasasMax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static public int cantidadCasillas;
    static public int cantidadCasillasUsuario = (cantidadCasillas * 4) - 2;
    static public int cantidadDados;
    static public int cantidadCasas;
    static public int cantidadHoteles;
    static public int cantidadJugadores;
    static public int cantidadDineroInicial;
    static public int cantidadDineroVuelta;

/**
 * los datos del usuario los guarda en las variables correspondientes 
 * @param evt 
 */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed

        cantidadCasillas = (Integer.parseInt(txtCantidadCasillas.getText()));
        cantidadDados=jSliderCantidadDados.getValue();
        cantidadJugadores=jSliderCantidadJugadores.getValue();
        cantidadCasas=Integer.parseInt(txtCantidadCasasMax1.getText());
        cantidadHoteles=Integer.parseInt(txtCantidadHotelesMax.getText());
        cantidadDineroInicial=Integer.parseInt(txtCantidadDineroInical.getText());
        cantidadDineroVuelta=Integer.parseInt(txtCantidadDineroVuelta.getText());
        
        dispose();

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();

    }//GEN-LAST:event_botonCancelarActionPerformed

    private void txtCantidadDineroVueltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadDineroVueltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadDineroVueltaActionPerformed

    private void txtCantidadCasillasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadCasillasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadCasillasActionPerformed

    private void txtCantidadTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadTarjetasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadTarjetasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSlider jSliderCantidadDados;
    private javax.swing.JSlider jSliderCantidadJugadores;
    private javax.swing.JLabel labelCanCasillas;
    private javax.swing.JLabel labelCanDineroInicial;
    private javax.swing.JLabel labelCantCasasMax;
    private javax.swing.JLabel labelCantDados;
    private javax.swing.JLabel labelCantDineroVuelta;
    private javax.swing.JLabel labelCantHotelesMax;
    private javax.swing.JLabel labelCantJugadoresMax;
    private javax.swing.JLabel labelCantTarjetas;
    private javax.swing.JTextField txtCantidadCasasMax1;
    private javax.swing.JTextField txtCantidadCasillas;
    private javax.swing.JTextField txtCantidadDineroInical;
    private javax.swing.JTextField txtCantidadDineroVuelta;
    private javax.swing.JTextField txtCantidadHotelesMax;
    private javax.swing.JTextField txtCantidadTarjetas;
    // End of variables declaration//GEN-END:variables
}