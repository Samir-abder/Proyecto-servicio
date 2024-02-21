/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahmu
 */
public class Diseno extends javax.swing.JPanel {

    public static DefaultTableModel modprofes;
    int filaAnterior = -1;
    int filaActual = -2;

    public Diseno() {
        initComponents();
        modprofes = (DefaultTableModel) this.profes.getModel();
        ListSelectionModel modeloSelecciond = profes.getSelectionModel();
        modeloSelecciond.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        anteEdit1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tutorA = new javax.swing.JTextField();
        cedulaT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cedulatuto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        profes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        razontext = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        anteSave1 = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        anteEdit1.setText("Editar");
        anteEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteEdit1ActionPerformed(evt);
            }
        });
        add(anteEdit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 313, -1, -1));

        jLabel26.setText("Tutor Académico");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 276, -1, -1));

        tutorA.setEditable(false);
        add(tutorA, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 273, 185, -1));
        add(cedulaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 92, 203, -1));

        jLabel1.setText("Tutor");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 95, -1, -1));

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 92, -1, -1));

        jLabel2.setText("Cedula");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 276, -1, -1));

        cedulatuto.setEditable(false);
        add(cedulatuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 273, 121, -1));

        profes.setAutoCreateRowSorter(true);
        profes.setModel(new javax.swing.table.DefaultTableModel(
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
        profes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(profes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 121, -1, 134));

        razontext.setColumns(20);
        razontext.setLineWrap(true);
        razontext.setRows(5);
        razontext.setWrapStyleWord(true);
        jScrollPane2.setViewportView(razontext);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 36, 452, 50));

        jLabel24.setText("Titulo del proyecto");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 14, 120, -1));

        anteSave1.setText("Guardar");
        anteSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteSave1ActionPerformed(evt);
            }
        });
        add(anteSave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 313, -1, -1));

        botonAgregar.setText("agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 92, -1, -1));

        jLabel3.setText("Diseno");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 0, 79, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void anteEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteEdit1ActionPerformed
        conexion habana = new conexion();
        String razonSocial = razontext.getText();
        String tutorAcademico = tutorA.getText();
        String tutorci = cedulatuto.getText();
        String cedulaEstudiante = Alumnosside.cedulaEst.getText();
        String periodo = "Periodo"; // No está claro de dónde obtienes este valor

        // Verifica que los campos no estén vacíos
        if (!razonSocial.isEmpty() && !tutorAcademico.isEmpty() && !cedulaEstudiante.isEmpty()) {
            String updateSql = String.format("UPDATE Diseno SET razon_social = '%s', tutor_academico = '%s', periodo = '%s', cedula_tutor = '%s' WHERE cedula_estudiante = '%s'",
                    razonSocial, tutorAcademico, periodo, tutorci, cedulaEstudiante);

            try {
                habana.ejecutarSentenciaSQl(updateSql);
                JOptionPane.showMessageDialog(null, "La pasantía del estudiante con cédula " + cedulaEstudiante + " ha sido editada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                habana.cerrarConexion();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar la pasantía: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                habana.cerrarConexion();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de actualizar.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            habana.cerrarConexion();

        }
    }//GEN-LAST:event_anteEdit1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        conexion busquedaProf = new conexion();
        String busqueda = cedulaT.getText();
        String SQL = "SELECT * FROM Docentes WHERE Nombre LIKE '%" + busqueda + "%' OR Apellido LIKE '%" + busqueda + "%' OR Cedula LIKE '%" + busqueda + "%'";
        while (Diseno.modprofes.getRowCount() > 0) {
            Diseno.modprofes.removeRow(0);
        }

        try {
            ResultSet AgregarProf = busquedaProf.consultaRegistros(SQL);
            while (AgregarProf.next()) {
                String Nombre = AgregarProf.getString("Nombre") + " " + AgregarProf.getString("Apellido");
                Object[] search = {
                    AgregarProf.getString("Cedula"),
                    Nombre
                };
                modprofes.addRow(search);
            }

        } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        } finally {
            busquedaProf.cerrarConexion();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void profesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profesMouseClicked

        botonAgregar.setEnabled(true);

        int filaSeleccionada = profes.getSelectedRow();

        // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla
        if (filaAnterior == filaActual) {
            if (filaSeleccionada == filaAnterior) {
                profes.clearSelection();
                botonAgregar.setEnabled(false);
            }
        }
        // Actualizar la fila anterior
        filaAnterior = filaSeleccionada;
        filaActual = profes.getSelectedRow();

    }//GEN-LAST:event_profesMouseClicked

    private void anteSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteSave1ActionPerformed
        String cedula1 = Alumnosside.cedulaEst.getText();//cedula del alumno

        String razonSocial = razontext.getText();//titulo del proyecto

        String tutorAcademico = tutorA.getText();//nombre del tutor

        String cedulaEstudiante = Alumnosside.cedulaEst.getText();//cedula del alumno otra vez?

        String cedulatutor = cedulatuto.getText();//cedula del tutor

        String periodo = "Periodo"; // No está claro de dónde obtienes este valor

        // Verifica que los campos no estén vacíos
        if (!razonSocial.isEmpty() && !tutorAcademico.isEmpty() && !cedulaEstudiante.isEmpty()) {

            conexion habana = new conexion();

            String find = String.format("SELECT COUNT(*) FROM estudiantes Where Cedula = '" + cedula1 + "'");
            ResultSet rs = habana.consultaRegistros(find);

            try {
                if (rs.next()) {//verifica cuantos estudiantes con la cedula dada estan en la tabla (para ver si ya hay estudiantes con esa cedula)

                    int cantidad = rs.getInt(1); //se agrega 1 a una variable entera

                    if (cantidad > 0) {//si cantidad es mayor a 0 es que tenemos un estudiante con esa cedula y procedemos a agregar la pasantia

                        try {
                            //aqui verificamos que ya el estudiante no tenga una pasantia asignada
                            String consultaPasantia = "SELECT id_pasantia FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                            ResultSet rsPasantia = habana.consultaRegistros(consultaPasantia);
                            int idPasantia = rsPasantia.getInt("id_pasantia");

                            if (idPasantia != 0) {//si tiene una pasantia asignada se manda mensaje de error (se verifica que no tenga pasantia)

                                // Aquí tienes el valor de id_pasantia para el estudiante con la cédula especificada
                                JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene una pasantia asignada.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                //si no se tiene una pasantia asignada se le asigna una
                                String consultatrabajo = "SELECT id_diseno FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                                ResultSet rstrabajo = habana.consultaRegistros(consultatrabajo);
                                int iddiseno = rstrabajo.getInt("id_diseno");

                                try {
                                    if (iddiseno != 0) {//(se verifica que no tenga trabajo de grado)

                                        JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene un diseño asignado.", "Error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        // El estudiante no tiene una pasantía asignada

                                        String countSql = "SELECT COUNT(*) AS rowCount FROM Diseno";
                                        ResultSet resultSet = habana.consultaRegistros(countSql);

// Inicializar una variable para almacenar el número de filas
                                        int rowCount = 0;

                                        try {
                                            // Verificar si se obtuvo un resultado
                                            if (resultSet.next()) {
                                                // Obtener el número de filas
                                                rowCount = resultSet.getInt("rowCount");
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            // Cerrar el ResultSet
                                            try {
                                                resultSet.close();
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }
                                        }

// Formatear el número de filas como un string de 3 dígitos
                                        String formattedRowCount = String.format("%03d", rowCount + 1);
                                        String peri = "2023-2CR";
                                        ResultSet rst = habana.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
                                        if (rst.next()) {
                                            int rowCountP = rst.getInt("count");
                                            if (rowCountP != 0) {
                                                peri = rst.getString("periodo");
                                            }
                                        }

                                        String escuela1 = (String) Alumnosside.escuelaEst.getSelectedItem();
                                        String niveld = (String) Alumnosside.nivel.getSelectedItem();
                                        switch (escuela1) {
                                            case "Computación":

                                                escuela1 = "C";
                                                break;
                                            case "Industrial":
                                                escuela1 = "I";
                                                break;
                                            case "Civil":
                                                escuela1 = "L";
                                                break;
                                            case "Electrónica":
                                                escuela1 = "Et";
                                                break;
                                            case "Telecomunicaciones":
                                                escuela1 = "T";
                                                break;
                                            case "Mecánica":
                                                escuela1 = "N";
                                                break;
                                            case "Arquitectura":
                                                escuela1 = "Q";
                                                break;
                                            default:
                                            // código que se ejecuta si no se cumple ninguna de las opciones anteriores
                                        }
                                        String cod = "";
                                        if (niveld.equals("9vno")) {
                                            cod = "FI-" + escuela1 + "-" + formattedRowCount + "-" + peri + "-" + "DIX";
                                        } else if (niveld.equals("10mo")) {
                                            cod = "FI-" + escuela1 + "-" + formattedRowCount + "-" + peri + "-" + "DX";
                                        }
                                        
                                        String addSql = String.format("INSERT INTO Diseno (razon_social, tutor_academico, cedula_estudiante, periodo, cedula_tutor, codigo) VALUES"
                                                + "('%s', '%s', '%s', '%s', '%s', '%s')",
                                                razontext.getText(), tutorA.getText(), Alumnosside.cedulaEst.getText(), "Periodo", cedulatutor, cod);

                                        habana.ejecutarSentenciaSQl(addSql);

                                        // Obtener el último valor autoincremental de la tabla
                                        String getLastIdSql = "SELECT last_insert_rowid()";
                                        ResultSet lastIdResultSet = habana.consultaRegistros(getLastIdSql);

                                        if (lastIdResultSet.next()) {
                                            int idGenerado = lastIdResultSet.getInt(1);
                                            // Actualizar la tabla estudiantes con el ID generado
                                            String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_diseno = %d WHERE Cedula = '%s'", idGenerado, cedula1);
                                            habana.ejecutarSentenciaSQl(updateEstudiantesSql);
                                            JOptionPane.showMessageDialog(null, "El proyecto de diseño fue registrado exitosamente");


                                        }

                                        String sql2 = "SELECT num_est, periodo, Escuela FROM estudiantes WHERE Cedula = '" + Alumnosside.cedulaEst.getText() + "'";

                                        ResultSet rsC = habana.consultaRegistros(sql2);

                                        // Obtener los valores de las columnas y guardarlos en variables
                                        String num_est = rsC.getString("num_est");
                                        String periodoC = rsC.getString("periodo");
                                        String escuela = rsC.getString("Escuela");
                                        String nivel = rsC.getString("Nivel");
                                        String dedo = "";//para codigo de diseno
                                        if (nivel.equals("9vno")) {
                                            dedo = "DIX";
                                        } else {
                                            dedo = "DX";
                                        }
                                        switch (escuela) {
                                            case "Computación":

                                                escuela = "C";
                                                break;
                                            case "Industrial":
                                                escuela = "I";
                                                break;
                                            case "Civil":
                                                escuela = "L";
                                                break;
                                            case "Electrónica":
                                                escuela = "Et";
                                                break;
                                            case "Telecomunicaciones":
                                                escuela = "T";
                                                break;
                                            case "Mecánica":
                                                escuela = "N";
                                                break;
                                            case "Arquitectura":
                                                escuela = "Q";
                                                break;
                                            default:
                                            // código que se ejecuta si no se cumple ninguna de las opciones anteriores
                                        }

                                        cod = "FI-" + escuela + "-" + num_est + "-" + periodoC + "-" + dedo;

                                        String sql3 = String.format("UPDATE estudiantes SET codigo = '%s', tipo = 'Diseño' WHERE Cedula = '%s'", cod, Alumnosside.cedulaEst.getText());

                                        habana.ejecutarSentenciaSQl(sql3);
                                    }
                                } catch (SQLException ex) {

                                }
                            }
                        } catch (SQLException ex) {

                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                // Manejar excepciones de SQL
                e.printStackTrace();
            }
            habana.cerrarConexion();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de actualizar.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_anteSave1ActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        int filaSeleccionada = profes.getSelectedRow();
        String cedula = String.valueOf(profes.getValueAt(filaSeleccionada, 0));
        String nombre = String.valueOf(profes.getValueAt(filaSeleccionada, 1));
        cedulatuto.setText(cedula);
        tutorA.setText(nombre);
    }//GEN-LAST:event_botonAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteEdit1;
    private javax.swing.JButton anteSave1;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JTextField cedulaT;
    public static javax.swing.JTextField cedulatuto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable profes;
    public static javax.swing.JTextArea razontext;
    public static javax.swing.JTextField tutorA;
    // End of variables declaration//GEN-END:variables
}
