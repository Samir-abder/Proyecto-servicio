/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lujop
 */
public class Agenda extends javax.swing.JPanel {

    /**
     * Creates new form Agenda
     */
    public Agenda() {
        initComponents();
        String peri = "2023-2CR";
        conexion habana = new conexion();
        ResultSet rst = habana.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
        try {
            if (rst.next()) {
                int rowCountP = rst.getInt("count");
                if (rowCountP != 0) {
                    peri = rst.getString("periodo");
                    periodoLabel.setText("Periodo: " + peri);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            habana.cerrarConexion();
        }
    }
    //EntrevistaEdit botE = new EntrevistaEdit();
    //PresentacionEdit botP = new PresentacionEdit();

    String url = "jdbc:sqlite:database.s3db";
    Connection connect;
    public String tipo = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baseAgenda = new javax.swing.JPanel();
        comboEscuela = new javax.swing.JComboBox<>();
        botonEntrevistas = new javax.swing.JButton();
        botonPresentaciones = new javax.swing.JButton();
        comboTipo = new javax.swing.JComboBox<>();
        periodoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        baseAgenda.setLayout(new java.awt.BorderLayout());

        comboEscuela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una escuela", "Arquitectura", "Civil", "Computación", "Electrónica", "Industrial", "Mecanica", "Telecomunicaciones" }));

        botonEntrevistas.setText("Entrevistas");
        botonEntrevistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrevistasActionPerformed(evt);
            }
        });

        botonPresentaciones.setText("Presentaciones");
        botonPresentaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPresentacionesActionPerformed(evt);
            }
        });

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Trabajo de grado", "Pasantia","Diseño" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        periodoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        periodoLabel.setText("Periodo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(comboEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonEntrevistas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonPresentaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(periodoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(baseAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonPresentaciones)
                            .addComponent(periodoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEntrevistas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(baseAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntrevistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrevistasActionPerformed

        Entrevistas entr = new Entrevistas();
        baseAgenda.removeAll();
        baseAgenda.add(entr);
        baseAgenda.revalidate();
        baseAgenda.repaint();

        while (Entrevistas.modeloEntre.getRowCount() > 0) { //tabla de entrevistas
            Entrevistas.modeloEntre.removeRow(0);
        }

        String escuela = comboEscuela.getSelectedItem().toString();
        Entrevistas.escuela = escuela;

        String tipo = comboTipo.getSelectedItem().toString();

        if (escuela != "Seleccione una escuela" && tipo != "Tipo") {

            conexion objConexion = new conexion();
            try {

                ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Escuela = '" + escuela + "' AND Tipo = '" + tipo + "' AND Nivel = '9vno'");

                System.out.println("SELECT * FROM estudiantes WHERE Escuela = '" + escuela + "' AND Tipo = '" + tipo + "' AND Nivel = '9vno'");

                while (resultado.next()) {
                    String nombreCompleto = resultado.getString("Nombre") + " " + resultado.getString("Apellido");
                    Object[] UsuarioD = {resultado.getString("Cedula"),
                        nombreCompleto,
                        resultado.getString("nombrejurado1"),
                        resultado.getString("ci_jurado1"),
                        //                    resultado.getString("nombrejurado2"),
                        //                    resultado.getString("ci_jurado2"),
                        resultado.getString("fecha_hora_entrevista"),
                        resultado.getString("lugar_entrevista")};

                    Entrevistas.modeloEntre.addRow(UsuarioD);
                }

            } catch (SQLException e) {
                System.out.println("este es " + e);
            } finally {
                objConexion.cerrarConexion();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Asegurese de seleccionar Escuela y tipo");
        }


    }//GEN-LAST:event_botonEntrevistasActionPerformed

    private void botonPresentacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPresentacionesActionPerformed

        Presentacion present = new Presentacion();
        baseAgenda.removeAll();
        baseAgenda.add(present);
        baseAgenda.revalidate();
        baseAgenda.repaint();

        while (Presentacion.modelopres.getRowCount() > 0) {
            Presentacion.modelopres.removeRow(0);
        }
        String escuela = comboEscuela.getSelectedItem().toString();
        Presentacion.escuela = escuela;
        String tipo = comboTipo.getSelectedItem().toString();

        if (escuela != "Seleccione una escuela" && tipo != "Tipo") {

            try {
                conexion objConexion = new conexion();
                ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Escuela = '" + escuela + "' AND Tipo = '" + tipo + "' AND Nivel = '10mo'");

                while (resultado.next()) {
                    String nombreCompleto = resultado.getString("Nombre") + " " + resultado.getString("Apellido");
                    Object[] UsuarioD = {resultado.getString("Cedula"),
                        nombreCompleto,
                        resultado.getString("nombrejurado1"),
                        resultado.getString("ci_jurado1"),
                        //                    resultado.getString("nombrejurado2"),
                        //                    resultado.getString("ci_jurado2"),
                        resultado.getString("fecha_hora_presentacion"),
                        resultado.getString("lugar_presentacion")};

                    Presentacion.modelopres.addRow(UsuarioD);
//                objConexion.cerrarConexion();
                }
            } catch (SQLException e) {
                System.out.println("este es " + e);
            }
        }

    }//GEN-LAST:event_botonPresentacionesActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel baseAgenda;
    private javax.swing.JButton botonEntrevistas;
    private javax.swing.JButton botonPresentaciones;
    public static javax.swing.JComboBox<String> comboEscuela;
    public static javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel periodoLabel;
    // End of variables declaration//GEN-END:variables
}
