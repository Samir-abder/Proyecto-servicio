/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    }
    //EntrevistaEdit botE = new EntrevistaEdit();
    //PresentacionEdit botP = new PresentacionEdit();
    
    String url="jdbc:sqlite:database.s3db";
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

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        baseAgenda.setLayout(new java.awt.BorderLayout());
        add(baseAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 720, 480));

        comboEscuela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una escuela", "Arquitectura", "Civil", "Computación", "Electrónica", "Industrial", "Mecanica", "Telecomunicaciones" }));
        add(comboEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, -1));

        botonEntrevistas.setText("Entrevistas");
        botonEntrevistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrevistasActionPerformed(evt);
            }
        });
        add(botonEntrevistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 120, -1));

        botonPresentaciones.setText("Presentaciones");
        botonPresentaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPresentacionesActionPerformed(evt);
            }
        });
        add(botonPresentaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 120, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Trabajo de grado", "Pasantia","Diseño" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 120, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void botonEntrevistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrevistasActionPerformed
        
        
        Entrevistas entr = new Entrevistas();
        baseAgenda.removeAll();baseAgenda.add(entr);baseAgenda.revalidate();baseAgenda.repaint();
        
        while (Entrevistas.modeloEntre.getRowCount() > 0) { //tabla de entrevistas
            Entrevistas.modeloEntre.removeRow(0);
        }
        
        
        String escuela=comboEscuela.getSelectedItem().toString();
        Entrevistas.escuela= escuela;
        
        String tipo = comboTipo.getSelectedItem().toString();
        
        if(escuela != "Seleccione una escuela" && tipo != "Tipo"){
//            EntrevistaEdit a = new EntrevistaEdit();
//            if(tipo == "Pasantia") {
//                
//                
//                a.botonAgregar.setEnabled(true);
//                a.botonAgregar1.setEnabled(false);
//            }
//            else{
//                a.botonAgregar.setEnabled(true);
//                a.botonAgregar1.setEnabled(true);
//            }
            
            
            
            try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Escuela = '"+escuela+"' AND Tipo = '"+tipo+"' AND Nivel = '9vno'");
            
                System.out.println("SELECT * FROM estudiantes WHERE Escuela = '"+escuela+"' AND Tipo = '"+tipo+"' AND Nivel = '9vno'");
            
            while (resultado.next()) {
                String nombreCompleto = resultado.getString("Nombre") + " "  + resultado.getString("Apellido");
                Object[] UsuarioD = {resultado.getString("Cedula"),
                    nombreCompleto,
                    resultado.getString("nombrejurado1"),
                    resultado.getString("ci_jurado1"),
                    resultado.getString("nombrejurado2"),
                    resultado.getString("ci_jurado2"),
                    resultado.getString("fecha_hora_entrevista"),
                    resultado.getString("lugar_entrevista")};

                Entrevistas.modeloEntre.addRow(UsuarioD);
//                
            }
            objConexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }
        }
        else{
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
        String escuela=comboEscuela.getSelectedItem().toString();
                Presentacion.escuela= escuela;
        String tipo = comboTipo.getSelectedItem().toString();  
        
        
        if(escuela != "Seleccione una escuela" && tipo != "Tipo") {
                
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Escuela = '"+escuela+"' AND Tipo = '"+tipo+"' AND Nivel = '10mo'");
            
            
            while (resultado.next()) {
                String nombreCompleto = resultado.getString("Nombre") + " "+ resultado.getString("Apellido");
                Object[] UsuarioD = {resultado.getString("Cedula"),
                    nombreCompleto,
                    resultado.getString("nombrejurado1"),
                    resultado.getString("ci_jurado1"),
                    resultado.getString("nombrejurado2"),
                    resultado.getString("ci_jurado2"),
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
    private javax.swing.JComboBox<String> comboEscuela;
    public static javax.swing.JComboBox<String> comboTipo;
    // End of variables declaration//GEN-END:variables
}
