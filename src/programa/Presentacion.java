/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import static programa.Entrevistas.agendaEntrevista;
import static programa.Entrevistas.escuela;


public class Presentacion extends javax.swing.JPanel {

    public static DefaultTableModel modelopres;
    int filaAnterior = -1;
    int filaActual =-2;
        public static String escuela;

    
    public Presentacion() {
        initComponents();
        modelopres = (DefaultTableModel) Presentacion.tablaPresentacion.getModel();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImprimirPresentacion = new javax.swing.JButton();
        boton_edit = new javax.swing.JButton();
        basePresentacion = new javax.swing.JPanel();
        paneltablapresentacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPresentacion = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(720, 470));

        ImprimirPresentacion.setText("Imprimir");
        ImprimirPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirPresentacionActionPerformed(evt);
            }
        });

        boton_edit.setText("Editar");
        boton_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boton_edit.setEnabled(false);
        boton_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editActionPerformed(evt);
            }
        });

        basePresentacion.setLayout(new java.awt.BorderLayout());

        tablaPresentacion.setAutoCreateRowSorter(true);
        tablaPresentacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alumno", "C.I. Alumno", "Jurado", "C.I. Jurado", "Fecha y hora", "Lugar"
            }
        ));
        tablaPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPresentacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPresentacion);

        javax.swing.GroupLayout paneltablapresentacionLayout = new javax.swing.GroupLayout(paneltablapresentacion);
        paneltablapresentacion.setLayout(paneltablapresentacionLayout);
        paneltablapresentacionLayout.setHorizontalGroup(
            paneltablapresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        paneltablapresentacionLayout.setVerticalGroup(
            paneltablapresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        basePresentacion.add(paneltablapresentacion, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(boton_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ImprimirPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(basePresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImprimirPresentacion)
                    .addComponent(boton_edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(basePresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editActionPerformed
        
        PresentacionEdit pred = new PresentacionEdit(); 
        String tipo = Agenda.comboTipo.getSelectedItem().toString();
        
        
        if (tipo.equals("Trabajo de grado")) {
            
            pred.botonAgregar.setEnabled(true);
            pred.botonAgregar1.setEnabled(true);
        }
        else {
            
            pred.botonAgregar.setEnabled(true);
            pred.botonAgregar1.setEnabled(false);
        }
        
        basePresentacion.removeAll(); //se quita todo lo que esta en la base
        pred.setMinimumSize(new Dimension(200, 500));
        paneltablapresentacion.setPreferredSize(new Dimension(800, 500));
        //baseAlumnos.setLayout(new FlowLayout());
        BoxLayout boxlayout = new BoxLayout(basePresentacion, BoxLayout.X_AXIS);
        basePresentacion.setLayout(boxlayout);
        
        basePresentacion.add(paneltablapresentacion);
        basePresentacion.add(pred);
        
        
        Base base = (Base)this.getRootPane().getParent();
        base.setMinimumSize(new Dimension(1000,600));
        base.setLocationRelativeTo(null);
        base.repaint();
        base.revalidate();
        
        int filaSeleccionada = tablaPresentacion.getSelectedRow();
//        EntrevistaEdit.nombrentrevistador.setText((String) agendaEntrevista.getValueAt(filaSeleccionada, 2));
//        EntrevistaEdit.cientrevistador.setText((String) agendaEntrevista.getValueAt(filaSeleccionada, 3));
        PresentacionEdit.hora.setText((String) tablaPresentacion.getValueAt(filaSeleccionada, 4));
        PresentacionEdit.lugarpresentacion.setText((String) tablaPresentacion.getValueAt(filaSeleccionada, 5));
        

        
        
        
        
        
    }//GEN-LAST:event_boton_editActionPerformed

    private void tablaPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPresentacionMouseClicked
        boton_edit.setEnabled(true);
        ImprimirPresentacion.setEnabled(true);
        
        int filaSeleccionada = tablaPresentacion.getSelectedRow();
                
                // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla
                if(filaAnterior==filaActual){
                    if(filaSeleccionada == filaAnterior){
                        tablaPresentacion.clearSelection();
                        boton_edit.setEnabled(false);
                        ImprimirPresentacion.setEnabled(false);
                        
                    }
                }
                // Actualizar la fila anterior
                filaAnterior = filaSeleccionada;
                filaActual=tablaPresentacion.getSelectedRow();
    }//GEN-LAST:event_tablaPresentacionMouseClicked

    private void ImprimirPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirPresentacionActionPerformed
        // TODO add your handling code here:
        
        String tipo = (String) Agenda.comboTipo.getSelectedItem();
        if(!tipo.equals("Tipo")){
            try {
                JasperByCollectionBeanData.tipo=tipo;
                JasperByCollectionBeanData.escuela=escuela;
                JasperByCollectionBeanData jbc = new JasperByCollectionBeanData();
            } catch (SQLException ex) {
                Logger.getLogger(Presentacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Presentacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(Presentacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ImprimirPresentacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImprimirPresentacion;
    private javax.swing.JPanel basePresentacion;
    private javax.swing.JButton boton_edit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paneltablapresentacion;
    public static javax.swing.JTable tablaPresentacion;
    // End of variables declaration//GEN-END:variables
}
