
package programa;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.Index;
import org.netbeans.lib.awtextra.AbsoluteLayout;



/**
 *
 * @author lujop
 */
public class Alumnos extends javax.swing.JPanel {

    public static DefaultTableModel modeloa;
    public static ButtonModel botonAgr;      
    int filaAnterior = -1;
    int filaActual =-2;
    public static String cedula;
    
    public Alumnos() {
        initComponents();
        modeloa = (DefaultTableModel) this.jTable1.getModel();
        botonAgr = (ButtonModel) this.botonAgregar.getModel();
        botonImprimir.setEnabled(false);
        botonEliminar.setEnabled(false);
        botonEditar.setEnabled(false);
        ListSelectionModel modeloSeleccion = jTable1.getSelectionModel();
        modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baseAlumnos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botonAgregar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();
        escf = new javax.swing.JComboBox<>();
        semestre = new javax.swing.JComboBox<>();
        tipoDeProyecto = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        TGmodo = new javax.swing.JComboBox<>();
        paneltablaAlumnos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        baseAlumnos.setBackground(new java.awt.Color(153, 153, 255));
        baseAlumnos.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        botonImprimir.setText("Imprimir");
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(botonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        escf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Escuela", "Computación", "Arquitectura", "Mecanica", "Civil","Electronica","Telecomunicaciones","Industrial"}));
        escf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escfActionPerformed(evt);
            }
        });
        jPanel2.add(escf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Semestre","9vno", "10mo"}));
        jPanel2.add(semestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 120, -1));

        tipoDeProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo","Trabajo de grado", "Pasantia", "Diseño", "Sin asignar"}));
        tipoDeProyecto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoDeProyectoItemStateChanged(evt);
            }
        });
        tipoDeProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDeProyectoActionPerformed(evt);
            }
        });
        jPanel2.add(tipoDeProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 120, -1));

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        TGmodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Equipo" }));
        TGmodo.setSelectedIndex(-1);
        TGmodo.setEnabled(false);
        TGmodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TGmodoActionPerformed(evt);
            }
        });
        jPanel2.add(TGmodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 110, -1));

        baseAlumnos.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        paneltablaAlumnos.setBackground(new java.awt.Color(153, 153, 255));
        paneltablaAlumnos.setLayout(new java.awt.BorderLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Tipo", "Escuela", "estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        paneltablaAlumnos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        baseAlumnos.add(paneltablaAlumnos, java.awt.BorderLayout.CENTER);

        add(baseAlumnos, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
     
        botonAgregar.setEnabled(false);
        Alumnosside alsi = new Alumnosside();
Alumnosside.editB.setEnabled(false);
        Alumnosside.agregarEstudiante.setEnabled(true);   
        baseAlumnos.removeAll();
        
        JPanel aux =new JPanel(new GridBagLayout());
        //aux.setPreferredSize(null);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0; 
        gbc1.weightx = 2;
        gbc1.fill = GridBagConstraints.BOTH;
        aux.add(paneltablaAlumnos,gbc1);
        
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.weightx = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        
        aux.add(alsi,gbc1);
        
        baseAlumnos.add(aux);

        
        Base base = (Base)this.getRootPane().getParent();
        base.setMinimumSize(new Dimension(1000,600));
        base.setLocationRelativeTo(null);
        base.repaint();
        base.revalidate();
        
        //Base obj = new Base();
        //obj.cargar();


    }//GEN-LAST:event_botonAgregarActionPerformed
    
    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
            String Cedula =(String) jTable1.getValueAt(jTable1.getSelectedColumn(),1);
            String Nombre =(String)jTable1.getValueAt(jTable1.getSelectedColumn(),2);
            String Apellido =(String)jTable1.getValueAt(jTable1.getSelectedColumn(),3);
            String Facultad =(String)jTable1.getValueAt(jTable1.getSelectedColumn(),4);
        
        
    }//GEN-LAST:event_botonImprimirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        botonImprimir.setEnabled(true);
        botonEliminar.setEnabled(true);
        botonEditar.setEnabled(true);
        int filaSeleccionada = jTable1.getSelectedRow();
                
                // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla
                if(filaAnterior==filaActual){
                    if(filaSeleccionada == filaAnterior){
                        jTable1.clearSelection();
                        botonImprimir.setEnabled(false);
                        botonEliminar.setEnabled(false);
                        botonEditar.setEnabled(false);
                    }
                }
                // Actualizar la fila anterior
                filaAnterior = filaSeleccionada;
                filaActual=jTable1.getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        // aqui se coloca el panel Alumnosside 
        botonEditar.setEnabled(false);
        botonAgregar.setEnabled(false);
       
        Alumnosside alsi = new Alumnosside();
         Alumnosside.editB.setEnabled(true);
        Alumnosside.agregarEstudiante.setEnabled(false);
        baseAlumnos.removeAll();
        JPanel aux =new JPanel(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0; 
        gbc1.weightx = 2;
        gbc1.fill = GridBagConstraints.BOTH;
        aux.add(paneltablaAlumnos,gbc1);
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.weightx = 0;
        gbc1.fill = GridBagConstraints.BOTH;
        aux.add(alsi,gbc1);
        baseAlumnos.add(aux);
        Base base = (Base)this.getRootPane().getParent();
        base.setMinimumSize(new Dimension(1000,600));
        base.setLocationRelativeTo(null);
        base.repaint();
        base.revalidate();
        //En esta parte se le da la funcion de editar
        
        int filaSeleccionada = jTable1.getSelectedRow();
        cedula=String.valueOf(jTable1.getValueAt(filaSeleccionada, 0));
        Alumnosside.cedulaEst.setText(cedula);
        Alumnosside.nombreEst.setText((String) jTable1.getValueAt(filaSeleccionada, 1));
        Alumnosside.apellidoEst.setText((String) jTable1.getValueAt(filaSeleccionada, 2));
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes where" + cedula);
            
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Facultad")
                    , resultado.getString("Escuela")};

               // Alumnos.modeloa.addRow(UsuarioD);
               //objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }
        
        Base obj = new Base();
        obj.cargar();
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model; 
        model = (DefaultTableModel) this.jTable1.getModel();
        jTable1.setModel(model);
        conexion objConexion = new conexion();
        int selectedRow = jTable1.getSelectedRow();
        
        if (selectedRow != -1) { // Verifica si se ha seleccionado una fila
            String cedula = (String) jTable1.getValueAt(selectedRow, 0);
            try {
                String sql = "DELETE FROM estudiantes WHERE Cedula = '" + cedula +"'";
                objConexion.ejecutarSentenciaSQl(sql);
                System.out.println(cedula);               // Elimina la fila de la tabla
                model.removeRow(selectedRow);
            } catch (Exception ex) {
                System.out.println("Error al eliminar los datos de la base de datos");
            }
        } else {
            jTable1.setValueAt(false,selectedRow,0);
        }
        
        Base obj = new Base();
        obj.cargar();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//       String semestre = (String) escf.getSelectedItem();
        cargarFiltros();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void escfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escfActionPerformed

    private void TGmodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TGmodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TGmodoActionPerformed

    private void tipoDeProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDeProyectoActionPerformed

    }//GEN-LAST:event_tipoDeProyectoActionPerformed

    private void tipoDeProyectoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoDeProyectoItemStateChanged
       
    }//GEN-LAST:event_tipoDeProyectoItemStateChanged

public static void cargar() {
       
        while (modeloa.getRowCount() > 0) {
            modeloa.removeRow(0);
        }
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Tipo")
                    , resultado.getString("Escuela")};

                modeloa.addRow(UsuarioD);
               
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

public static void cargarTG() {
       
        while (modeloa.getRowCount() > 0) {
            modeloa.removeRow(0);
        }
        try {
            conexion objConexion = new conexion();
            String sql="SELECT * FROM estudiantes WHERE id_trabajo != ''";
            ResultSet resultado = objConexion.consultaRegistros(sql);
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Facultad")
                    , resultado.getString("Escuela")};

                modeloa.addRow(UsuarioD);
                
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

public static void cargarPS() {
       
        while (modeloa.getRowCount() > 0) {
            modeloa.removeRow(0);
        }
        try {
            conexion objConexion = new conexion();
            String sql="SELECT * FROM estudiantes WHERE id_pasantia != ''";
            ResultSet resultado = objConexion.consultaRegistros(sql);
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Facultad")
                    , resultado.getString("Escuela")};

                modeloa.addRow(UsuarioD);
                
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
public void cargarFiltros() {
       conexion objConexion = new conexion();
        if(TGmodo.getSelectedIndex()==1){ //si el trabajo de grado es en equipo se ejecuta este codigo
            modeloa.setColumnIdentifiers(new Object[] {"Nombre de proyecto","Cedula 1","Alumno 1","Cedula 2","Alumno 2"});
            while (modeloa.getRowCount() > 0) {
                   modeloa.removeRow(0);
            }   
            try{
                //Consulta para mostrar los nombres de los trabajos de grado en pareja
                String sql = "SELECT * FROM trabajo_grado";
                ResultSet resulta = objConexion.consultaRegistros(sql);
                
                while (resulta.next()) {
                       Object[] UsuarioD1 = new Object[5];
                       UsuarioD1[0]=resulta.getString("titulo");
                       //Consulta para sacar los datos de los estudiantes
                       
                       String id_tr = resulta.getString("id_trabajo");
                       String sql2 = "SELECT * FROM estudiantes WHERE id_trabajo="+id_tr;
                       
                       ResultSet resulta2 = objConexion.consultaRegistros(sql2);
                       int i=0;
                       int n=2;
                       while(resulta2.next()) {
                            
                            String nom = resulta2.getString("Nombre");
                            String ape = resulta2.getString("Apellido");
                            String nombreCompleto = nom + " " + ape;
                            UsuarioD1[n*i+1]=nombreCompleto;
                            UsuarioD1[n*i+2]=resulta2.getString("Cedula");
                            i++;
                       }
                       
                       modeloa.addRow(UsuarioD1);
                }
            }catch(SQLException e){
                 JOptionPane.showMessageDialog(null, "Error" + e);
            }finally {
                objConexion.cerrarConexion();
            }
            
            
            
            
        }else{//si el trabajo de grado es individual se ejecuta este codigo
//            modeloa.setColumnIdentifiers(new Object[] {"Cedula","Nombre","Apellido","Tipo", "Escuela","estado"});
            String sql = "SELECT * FROM estudiantes WHERE 1 = 1";
            while (modeloa.getRowCount() > 0) {
                   modeloa.removeRow(0);
            }  

            // Agrega las condiciones según los campos seleccionados
            ArrayList<Object> parametros = new ArrayList<>();
            
            if (!escf.getSelectedItem().equals("Escuela")) {
                sql += " AND Escuela = ?";
                parametros.add(escf.getSelectedItem());
            }

            if (!semestre.getSelectedItem().equals("Semestre")) {
                sql += " AND Nivel = ?";
                parametros.add(semestre.getSelectedItem());
            }

            if (!tipoDeProyecto.getSelectedItem().equals("Tipo")) {
                sql += " AND Tipo = ?";
                parametros.add(tipoDeProyecto.getSelectedItem());
            }
            if (tipoDeProyecto.getSelectedIndex()!=1){
                TGmodo.setEnabled(false);
            }else{
                
                TGmodo.setEnabled(true);
                
            }

            while (modeloa.getRowCount() > 0) {
                   modeloa.removeRow(0);
               }
               try {
                   ResultSet resultado = objConexion.consultaRegistrosParametrizados(sql,parametros);
                   while (resultado.next()) {
                       Object[] UsuarioD = {
                           
                           resultado.getString("Cedula"),
                           resultado.getString("Nombre"),
                           resultado.getString("Apellido"),
                           resultado.getString("Tipo"),
                           resultado.getString("Escuela"),
                           false
                       };

                       modeloa.addRow(UsuarioD);

                   }
               } catch (SQLException e) {
                   JOptionPane.showMessageDialog(null, "Error" + e);
               } finally {
                   objConexion.cerrarConexion();
               }
            
            
            
            
        }
 
 
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TGmodo;
    private javax.swing.JPanel baseAlumnos;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JComboBox<String> escf;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JPanel paneltablaAlumnos;
    private javax.swing.JComboBox<String> semestre;
    private javax.swing.JComboBox<String> tipoDeProyecto;
    // End of variables declaration//GEN-END:variables


}
