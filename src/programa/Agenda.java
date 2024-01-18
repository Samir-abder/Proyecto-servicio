/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


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
    }

    
    String url="jdbc:sqlite:database.s3db";
    Connection connect;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baseAgenda = new javax.swing.JPanel();
        comboEscuela = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        baseAgenda.setLayout(new java.awt.BorderLayout());

        comboEscuela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una escuela", "Arquitectura", "Civil", "Computación", "Electronica", "Industrial", "Mecanica" }));

        jButton1.setText("Entrevistas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Presentaciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(comboEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(baseAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(5, 5, 5)
                .addComponent(baseAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Entrevistas entr = new Entrevistas();
        baseAgenda.removeAll();
        baseAgenda.add(entr);
        baseAgenda.revalidate();
        baseAgenda.repaint();
        
        while (Entrevistas.modeloEntre.getRowCount() > 0) {
            Entrevistas.modeloEntre.removeRow(0);
        }
        String escuela=comboEscuela.getSelectedItem().toString();
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Escuela='"+escuela+"'");
            
            
            while (resultado.next()) {
                String nombreCompleto = resultado.getString("Nombre") + " "  + resultado.getString("Apellido");
                Object[] UsuarioD = {resultado.getString("Cedula"),
                    nombreCompleto,
                    resultado.getString("entrevistador"),
                    resultado.getString("ci_entrevistador"),
                    resultado.getString("fecha_hora_entrevista"),
                    resultado.getString("lugar_entrevista")};

                Entrevistas.modeloEntre.addRow(UsuarioD);
//                
            }
            objConexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Presentacion present = new Presentacion();
        baseAgenda.removeAll();
        baseAgenda.add(present);
        baseAgenda.revalidate();
        baseAgenda.repaint();
        
        
        while (Entrevistas.modeloEntre.getRowCount() > 0) {
            Entrevistas.modeloEntre.removeRow(0);
        }
        String escuela=comboEscuela.getSelectedItem().toString();
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Escuela='"+escuela+"'");
            
            
            while (resultado.next()) {
                String nombreCompleto = resultado.getString("Nombre") + " "  + resultado.getString("Apellido");
                Object[] UsuarioD = {resultado.getString("Cedula"),
                    nombreCompleto,
                    resultado.getString("jurado"),
                    resultado.getString("ci_jurado"),
                    resultado.getString("fecha_hora_presentacion"),
                    resultado.getString("lugar_presentacion")};

                Presentacion.modelopres.addRow(UsuarioD);
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel baseAgenda;
    private javax.swing.JComboBox<String> comboEscuela;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
