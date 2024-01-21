/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
//import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lujop
 */
public class Profesores extends javax.swing.JPanel {

    public static ButtonModel botonagr;
    public static ButtonModel botonedit;
    public static DefaultTableModel modelP;
    public static String cedula;
    int filaAnterior = -1;
    int filaActual = -2;

    public Profesores() {
        
        
        initComponents();
        modelP = (DefaultTableModel) jTable1.getModel();
        botonagr = (ButtonModel) botonAgProf.getModel();
        botonedit = (ButtonModel) profed.getModel();
        profed.setEnabled(false);
        profbo.setEnabled(false);
        ListSelectionModel modeloSeleccion = jTable1.getSelectionModel();
        modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                profed.setVisible(false);
                if (!conexion.strconexionDB.equals("database.s3db")) {
            botonAgProf.setVisible(false);
            profbo.setVisible(false);
        } else {
            botonAgProf.setVisible(true);
            profbo.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baseProfes = new javax.swing.JPanel();
        paneltablaProfes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botonAgProf = new javax.swing.JButton();
        profed = new javax.swing.JButton();
        profbo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(685, 483));
        setLayout(new java.awt.BorderLayout());

        baseProfes.setBackground(new java.awt.Color(204, 204, 204));
        baseProfes.setLayout(new java.awt.BorderLayout());

        paneltablaProfes.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Cedula", "Profesion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setShowGrid(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout paneltablaProfesLayout = new javax.swing.GroupLayout(paneltablaProfes);
        paneltablaProfes.setLayout(paneltablaProfesLayout);
        paneltablaProfesLayout.setHorizontalGroup(
            paneltablaProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );
        paneltablaProfesLayout.setVerticalGroup(
            paneltablaProfesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltablaProfesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        baseProfes.add(paneltablaProfes, java.awt.BorderLayout.CENTER);

        add(baseProfes, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        botonAgProf.setText("Agregar");
        botonAgProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgProfActionPerformed(evt);
            }
        });

        profed.setText("Editar");
        profed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profedActionPerformed(evt);
            }
        });

        profbo.setText("Borrar");
        profbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(botonAgProf)
                .addGap(18, 18, 18)
                .addComponent(profed)
                .addGap(18, 18, 18)
                .addComponent(profbo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgProf)
                    .addComponent(profed)
                    .addComponent(profbo))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgProfActionPerformed

        
    
        botonAgProf.setEnabled(false);
        profesoresside profagr = new profesoresside();
        JPanel aux2 = new JPanel(new GridBagLayout());
        baseProfes.removeAll();
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 3;
        gbc1.fill = GridBagConstraints.BOTH;
        aux2.add(paneltablaProfes, gbc1);
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.BOTH;
        aux2.add(profagr, gbc1);
        aux2.setLocation(0, 0);
        baseProfes.add(aux2);
        baseProfes.repaint();
        baseProfes.revalidate();
        Base base = (Base) this.getRootPane().getParent();
        base.setMinimumSize(new Dimension(900, 600));
        base.setLocationRelativeTo(null);
        profesoresside.beditar.setEnabled(false);
    }//GEN-LAST:event_botonAgProfActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        profbo.setEnabled(true);
        profed.setEnabled(true);
        int filaSeleccionada = jTable1.getSelectedRow();

        // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla
        if (filaAnterior == filaActual) {
            if (filaSeleccionada == filaAnterior) {
                jTable1.clearSelection();
                profbo.setEnabled(false);
                profed.setEnabled(false);
            }
        }
        // Actualizar la fila anterior
        filaAnterior = filaSeleccionada;
        filaActual = jTable1.getSelectedRow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void profedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profedActionPerformed
  

            int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) { // Verifica si se ha seleccionado una fila
            
            
            botonAgProf.setEnabled(false);
            profbo.setEnabled(false);
            
                    profed.setEnabled(false);
                    profesoresside profagr = new profesoresside();
                    profesoresside.baceptar.setEnabled(false);
                    JPanel aux2 = new JPanel(new GridBagLayout());
                    baseProfes.removeAll();
                    GridBagConstraints gbc1 = new GridBagConstraints();
                    gbc1.gridx = 0; gbc1.gridy = 0; gbc1.weightx = 3; gbc1.fill = GridBagConstraints.BOTH;
                    aux2.add(paneltablaProfes, gbc1); gbc1.gridx = 1; gbc1.gridy = 0;
                    gbc1.weightx = 1; gbc1.fill = GridBagConstraints.BOTH;
                    aux2.add(profagr, gbc1);aux2.setLocation(0, 0);baseProfes.add(aux2);
                    baseProfes.repaint();baseProfes.revalidate(); Base base = (Base) this.getRootPane().getParent();
                    base.setMinimumSize(new Dimension(900, 600));base.setLocationRelativeTo(null);
                    profesoresside.cedulaP.setEnabled(true);
                    profesoresside.cedulaP.setEditable(true);
                    
                    
                    
                    String nombre = (String) modelP.getValueAt(selectedRow, 0);
                    String apellido = (String) modelP.getValueAt(selectedRow, 1);
                    cedula = (String) modelP.getValueAt(selectedRow, 2);
                    String profesionp = (String) modelP.getValueAt(selectedRow,3);
                    
                    profesoresside.nombreP.setText(nombre);
                    profesoresside.apellidoP.setText(apellido);
                    profesoresside.cedulaP.setText(cedula);
                    profesoresside.profesion.setText(profesionp);

                    
        } else {
            jTable1.setValueAt(false,selectedRow,0);
        }
                    
    }//GEN-LAST:event_profedActionPerformed

    private void profboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profboActionPerformed
        // TODO add your handling code here:
        /////
        profed.setEnabled(false);
        profbo.setEnabled(false);
        
        DefaultTableModel model; 
        model = (DefaultTableModel) this.jTable1.getModel();
        jTable1.setModel(model);
        conexion objConexion = new conexion();
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) { // Verifica si se ha seleccionado una fila
            String cedula = (String) jTable1.getValueAt(selectedRow, 2);
             int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este registro?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
               
             
        if (confirmacion == JOptionPane.YES_OPTION){ 
            try {
                String sql = "DELETE FROM Docentes WHERE Cedula = '" + cedula +"'";
                objConexion.ejecutarSentenciaSQl(sql);
                System.out.println(cedula);               // Elimina la fila de la tabla
                model.removeRow(selectedRow);
            } catch (Exception ex) {
                System.out.println("Error al eliminar los datos de la base de datos");
            }
        } else {
            jTable1.setValueAt(false,selectedRow,0);
        }
        
        Base.cargarProfesores();
        System.out.println("Holiwissss");
        }
    }//GEN-LAST:event_profboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel baseProfes;
    public static javax.swing.JButton botonAgProf;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel paneltablaProfes;
    public static javax.swing.JButton profbo;
    public static javax.swing.JButton profed;
    // End of variables declaration//GEN-END:variables
}
