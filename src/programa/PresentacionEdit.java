/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PresentacionEdit extends javax.swing.JPanel {

    
    public static DefaultTableModel jurados;
    int filaAnterior = -1;
    int filaActual = -2;
    
    public PresentacionEdit() {
        initComponents();
        jurados = (DefaultTableModel) this.tutores.getModel();
        ListSelectionModel modeloSeleccion = tutores.getSelectionModel();
        modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        new TextPrompt("  Buscar jurados", cedulaTutor2);
        new TextPrompt("  1er Jurado", jurado1);
        new TextPrompt("  2do Jurado", jurado2);
        new TextPrompt("00:00 AM/PM", hora);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        lugarpresentacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        guardarPre = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        hora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        jurado1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tutores = new javax.swing.JTable();
        date = new com.toedter.calendar.JDateChooser();
        jurado2 = new javax.swing.JTextField();
        cedulaTutor2 = new javax.swing.JTextField();
        botonAgregar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Aula/Lugar:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 60, -1));

        lugarpresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugarpresentacionActionPerformed(evt);
            }
        });
        add(lugarpresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 77, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha y hora:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        guardarPre.setText("Guardar");
        guardarPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarPreActionPerformed(evt);
            }
        });
        add(guardarPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        jButton3.setText(" Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horaActionPerformed(evt);
            }
        });
        add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 86, -1));

        jLabel7.setText("(00:00 AM/PM)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 80, 20));

        botonAgregar.setText("agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 80, -1));
        add(jurado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, -1));

        jLabel1.setText("Jurados");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jButton2.setText("buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        tutores.setAutoCreateRowSorter(true);
        tutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tutores);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 370, 100));
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 100, -1));
        add(jurado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 180, -1));
        add(cedulaTutor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 203, -1));

        botonAgregar1.setText("agregar");
        botonAgregar1.setEnabled(false);
        botonAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregar1ActionPerformed(evt);
            }
        });
        add(botonAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 80, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void lugarpresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugarpresentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugarpresentacionActionPerformed

    private void guardarPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarPreActionPerformed
        conexion objConexion = new conexion();
        
        
         int filaSeleccionada = Presentacion.tablaPresentacion.getSelectedRow();
        
         Date selectedDate = date.getDate();

    //fecha como una cadena antes de guardarla en la base de datos
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");      
        String datestg = sdf.format(selectedDate);
        //System.out.println("Fecha formateada: " + datestg);
         

         if(Agenda.comboTipo.getSelectedItem().toString().equals("Pasantia")){
             
             Object[] Vector = jurado1.getText().split(",");
             
        String sql = String.format("UPDATE Estudiantes SET ci_jurado1 = '%s', nombrejurado1 = '%s',"
                + " fecha_hora_presentacion = '%s', lugar_presentacion = '%s' "
                + "WHERE Cedula = '" +  Presentacion.tablaPresentacion.getValueAt(filaSeleccionada, 0) + "'",
                    Vector[1], 
                    Vector[0],
                datestg + " / "+ hora.getText(),
                lugarpresentacion.getText());
        
        objConexion.ejecutarSentenciaSQl(sql);
        //cientrevistador.setText("");
        //nombrentrevistador.setText("");
        hora.setText("");
        lugarpresentacion.setText("");
        
        try {
            while (Presentacion.modelopres.getRowCount() > 0) {
               Presentacion.modelopres.removeRow(0);
            }                     
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM Estudiantes");
            while (resultado.next()) {
                 String nombreCompleto = resultado.getString("Nombre") + " "  + resultado.getString("Apellido");
                Object[] UsuarioD = {
                    resultado.getString("Cedula"),
                    nombreCompleto,
                    resultado.getString("nombrejurado1"),
                    resultado.getString("ci_jurado1"),
                    resultado.getString("fecha_hora_presentacion"),
                    resultado.getString("lugar_presentacion")
                };
            Presentacion.modelopres.addRow(UsuarioD);
            }
            }catch (SQLException e) {
                System.out.println("este es " + e);
            }
         
         objConexion.cerrarConexion();
        }  
         else{
             //conexion objConexion = new conexion();
        
         //if(Agenda.comboTipo.getSelectedItem().toString().equals("Pasantia")){
             
             Object[] Vector = jurado1.getText().split(",");
             Object[] Vector1 = jurado2.getText().split(",");
             
        String sql = String.format("UPDATE Estudiantes SET ci_jurado1 = '%s', nombrejurado1 = '%s', ci_jurado2 = '%s', nombrejurado2 = '%s' "
                + " fecha_hora_presentacion = '%s', lugar_presentacion = '%s' "
                + "WHERE Cedula = '" +  Presentacion.tablaPresentacion.getValueAt(filaSeleccionada, 0) + "'",
                    Vector[1], 
                    Vector[0],
                    Vector1[1],
                    Vector[0],
                datestg + " / "+ hora.getText(),
                lugarpresentacion.getText());
        
        objConexion.ejecutarSentenciaSQl(sql);
        //cientrevistador.setText("");
        //nombrentrevistador.setText("");
        hora.setText("");
        lugarpresentacion.setText("");
        
        try {
            while (Presentacion.modelopres.getRowCount() > 0) {
               Presentacion.modelopres.removeRow(0);
            }                     
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM Estudiantes");
            while (resultado.next()) {
                 String nombreCompleto = resultado.getString("Nombre") + " "  + resultado.getString("Apellido");
                Object[] UsuarioD = {resultado.getString("Cedula"),
                    nombreCompleto,
                    resultado.getString("nombrejurado1"),
                    resultado.getString("ci_jurado1"),
                    resultado.getString("nombrejurado2"),
                    resultado.getString("ci_jurado2"),
                    resultado.getString("fecha_hora_presentacion"),
                    resultado.getString("lugar_presentacion")
                };
            Presentacion.modelopres.addRow(UsuarioD);
            }
            }catch (SQLException e) {
                System.out.println("este es " + e);
            }
         
         objConexion.cerrarConexion();
        }
    }//GEN-LAST:event_guardarPreActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horaActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        int filaSeleccionada = tutores.getSelectedRow();
        String cedula = String.valueOf(tutores.getValueAt(filaSeleccionada, 0));
        String nombre = String.valueOf(tutores.getValueAt(filaSeleccionada, 1));
        //cedulatuto.setText(cedula);
        jurado1.setText(nombre +", "+ cedula);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        conexion busquedaProf = new conexion();
        String busqueda = cedulaTutor2.getText();
        String SQL = "SELECT * FROM Docentes WHERE Nombre LIKE '%"+ busqueda +"%' OR Apellido LIKE '%"+ busqueda +"%' OR Cedula LIKE '%"+ busqueda +"%'";
        while (jurados.getRowCount() > 0) {
            jurados.removeRow(0);
        }

        try {
            ResultSet AgregarProf = busquedaProf.consultaRegistros(SQL);
            while(AgregarProf.next()){
                String Nombre = AgregarProf.getString("Nombre") + " " + AgregarProf.getString("Apellido");
                Object[] search = {
                    AgregarProf.getString("Cedula"),
                    Nombre
                };
                jurados.addRow(search);
            }

        } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        }finally{
            busquedaProf.cerrarConexion();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutoresMouseClicked

        //        botonAgregar.setEnabled(true);
        //        botonAgregar1.setEnabled(true);

        int filaSeleccionada = tutores.getSelectedRow();

        // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla

        if (filaAnterior == filaActual) {
            if (filaSeleccionada == filaAnterior) {
                tutores.clearSelection();
                //botonAgregar.setEnabled(false);
            }
        }
        // Actualizar la fila anterior
        filaAnterior = filaSeleccionada;
        filaActual = tutores.getSelectedRow();
    }//GEN-LAST:event_tutoresMouseClicked

    private void botonAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregar1ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tutores.getSelectedRow();
        String cedula = String.valueOf(tutores.getValueAt(filaSeleccionada, 0));
        String nombre = String.valueOf(tutores.getValueAt(filaSeleccionada, 1));
        //cedulatuto.setText(cedula);
        jurado2.setText(nombre +", "+ cedula);
    }//GEN-LAST:event_botonAgregar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonAgregar;
    public javax.swing.JButton botonAgregar1;
    private javax.swing.JTextField cedulaTutor2;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton guardarPre;
    public static javax.swing.JTextField hora;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jurado1;
    private javax.swing.JTextField jurado2;
    public static javax.swing.JTextField lugarpresentacion;
    public static javax.swing.JTable tutores;
    // End of variables declaration//GEN-END:variables
}
