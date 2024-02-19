/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import static programa.Pasantiab.modtutores;
import static programa.Pasantiab.tutores;

/**
 *
 * @author USUARIO
 */
public class Tg extends javax.swing.JPanel {

    public static DefaultTableModel modcompa;
    public static DefaultTableModel modprof;
    int filaAnterior = -1;
    int filaActual = -2;

    public Tg() {
        initComponents();
        //tabla de alumnos
        modcompa = (DefaultTableModel) this.companeros.getModel();
        ListSelectionModel modeloSeleccion = companeros.getSelectionModel();
        modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //tabla de profes
        modprof = (DefaultTableModel) this.profes.getModel();
        ListSelectionModel modeloSeleccionp = profes.getSelectionModel();
        modeloSeleccionp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulop = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        nombreTutor = new javax.swing.JTextField();
        aSave = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        aDelete = new javax.swing.JButton();
        cedulacompi = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profes = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        cedulaTutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NomCompa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        companeros = new javax.swing.JTable();
        botonAgregar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CiCompa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        citutor = new javax.swing.JTextField();

        titulop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulopActionPerformed(evt);
            }
        });

        jLabel15.setText("Titulo proyecto");

        nombreTutor.setEditable(false);

        aSave.setText("Guardar");
        aSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aSaveActionPerformed(evt);
            }
        });

        Eliminar.setText("Editar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        aDelete.setText("Borrar");
        aDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aDeleteActionPerformed(evt);
            }
        });

        jLabel30.setText("Buscar compañero:");

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

        botonAgregar.setText("agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar tutor");

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre del tutor");

        jLabel3.setText("Nombre ");

        NomCompa.setEditable(false);
        NomCompa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomCompaActionPerformed(evt);
            }
        });

        companeros.setAutoCreateRowSorter(true);
        companeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
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
        companeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companerosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(companeros);

        botonAgregar1.setText("agregar");
        botonAgregar1.setEnabled(false);
        botonAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregar1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Cedula");

        CiCompa.setEditable(false);
        CiCompa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiCompaActionPerformed(evt);
            }
        });

        jLabel5.setText("Cedula");

        citutor.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Eliminar)
                        .addGap(47, 47, 47)
                        .addComponent(aSave)
                        .addGap(35, 35, 35)
                        .addComponent(aDelete))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titulop, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cedulacompi, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonAgregar1))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cedulaTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonAgregar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NomCompa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CiCompa))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(citutor)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(cedulacompi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(botonAgregar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NomCompa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CiCompa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(botonAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(citutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eliminar)
                    .addComponent(aDelete)
                    .addComponent(aSave))
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aSaveActionPerformed
        // TODO add your handling code here:
        String cedula1 = Alumnosside.cedulaEst.getText();
        String cedula2 = CiCompa.getText();
        String cedulaTutor = citutor.getText();
        String titulo = Tg.titulop.getText();

        conexion habana = new conexion();
        if (cedula2.isEmpty()) {
            String find = String.format("SELECT COUNT(*) FROM estudiantes Where Cedula = '" + cedula1 + "'");
            ResultSet rs = habana.consultaRegistros(find);

            try {
                if (rs.next()) {
                    int cantidad = rs.getInt(1);
                    if (cantidad > 0) {

                        String consultaPasantia = "SELECT id_pasantia FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                        ResultSet rsPasantia = habana.consultaRegistros(consultaPasantia);
                        int idPasantia = rsPasantia.getInt("id_pasantia");

                        if (idPasantia != 0) {

                            // Aquí tienes el valor de id_pasantia para el estudiante con la cédula especificada
                            habana.cerrarConexion();
                            JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene una pasantia asignada.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String consultatrabajo = "SELECT id_trabajo FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                            ResultSet rstrabajo = habana.consultaRegistros(consultatrabajo);
                            int idtrabajo = rstrabajo.getInt("id_trabajo");

                            if (idtrabajo != 0) {
                                habana.cerrarConexion();
                                JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene un trabajo de grado asignado.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                String countSql = "SELECT COUNT(*) AS rowCount FROM trabajo_grado";
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
                                String cod = "FI-" + escuela1 + "-" + formattedRowCount + "-" + peri + "-" + "TG";

                                String addSql = String.format("INSERT INTO trabajo_grado (titulo, cedula_estudiante, tutor, periodo, cedula_tutor, codigo) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                                        titulo, cedula1, nombreTutor.getText(), "Periodo", cedulaTutor, cod);

                                habana.ejecutarSentenciaSQl(addSql);
                                System.out.println("add " + addSql);
                                // Obtener el último valor autoincremental de la tabla
                                String getLastIdSql = "SELECT last_insert_rowid()";
                                ResultSet lastIdResultSet = habana.consultaRegistros(getLastIdSql);

                                if (lastIdResultSet.next()) {
                                    int idGenerado = lastIdResultSet.getInt(1);
                                    // Actualizar la tabla estudiantes con el ID generado
                                    String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_trabajo = %d WHERE Cedula = '%s'", idGenerado, cedula1);
                                    habana.ejecutarSentenciaSQl(updateEstudiantesSql);
                                    habana.cerrarConexion();
                                }
//                                codigo(cedulacompi.getText());
                            }
                        }

                    }
                }
            } catch (SQLException e) {
                // Manejar excepciones de SQL
                e.printStackTrace();
            }

        } else {
            habana.cerrarConexion();
            if (ambosEstudiantesExisten(cedula1, cedula2)) {
                if (ningunEstudianteTieneTrabajoDeGrado(cedula1, cedula2)) {
                    if (ningunEstudianteTienePasantia(cedula1, cedula2)) {
                        // Ambos estudiantes existen, ninguno tiene trabajos de grado asignados y ninguno tiene pasantías asignadas
                        // Puedes continuar con la inserción del trabajo de grado.
                        System.out.println("antes");
                        conexion objconexion = new conexion();
                        System.out.println("despues");

                        try { String countSql = "SELECT COUNT(*) AS rowCount FROM trabajo_grado";
                                ResultSet resultSet = objconexion.consultaRegistros(countSql);

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
                                ResultSet rst = objconexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
                                if (rst.next()) {
                                    int rowCountP = rst.getInt("count");
                                    if (rowCountP != 0) {
                                        peri = rst.getString("periodo");
                                    }
                                }

                                String escuela1 = (String) Alumnosside.escuelaEst.getSelectedItem();
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
                                String cod = "FI-" + escuela1 + "-" + formattedRowCount + "-" + peri + "-" + "TG";
                            String addSql = String.format("INSERT INTO trabajo_grado (titulo, cedula_estudiante, cedula_estudiante2, tutor, periodo, cedula_tutor, codigo) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                                    titulo, cedula1, cedula2, nombreTutor.getText(), "Periodo", cedulaTutor, cod);

                            objconexion.ejecutarSentenciaSQl(addSql);

                            // Obtener el último valor autoincremental de la tabla
                            String getLastIdSql = "SELECT last_insert_rowid()";
                            ResultSet lastIdResultSet = objconexion.consultaRegistros(getLastIdSql);

                            if (lastIdResultSet.next()) {
                                int idGenerado = lastIdResultSet.getInt(1);
                                // Actualizar la tabla estudiantes con el ID generado
                                String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_trabajo = %d WHERE Cedula = '%s'", idGenerado, cedula1);
                                objconexion.ejecutarSentenciaSQl(updateEstudiantesSql);
                                String updateEstudiantesSql1 = String.format("UPDATE estudiantes SET id_trabajo = %d WHERE Cedula = '%s'", idGenerado, cedula2);
                                objconexion.ejecutarSentenciaSQl(updateEstudiantesSql1);
                                objconexion.cerrarConexion();
                            }
                            codigo(cedulacompi.getText());
                            codigo(Tg.titulop.getText());
                        } catch (SQLException ex) {

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Uno de los estudiantes ya tiene una pasantía asignada.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Uno de los estudiantes ya tiene un trabajo de grado asignado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Uno de los estudiantes no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        //find.ejecutarSentenciaSQl(addSql);
    }//GEN-LAST:event_aSaveActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        String cedula1 = Alumnosside.cedulaEst.getText();
        String cedula2 = CiCompa.getText();
        String cedulaTutor = citutor.getText();
        String titulo = Tg.titulop.getText();
        conexion habana = new conexion();
        if (cedula2.isEmpty()) {
            String updateSql = String.format("UPDATE trabajo_grado SET titulo = '%s', cedula_estudiante = '%s', cedula_estudiante2 = '%s', tutor = '%s', periodo = '%s', cedula_tutor = '%s' WHERE (cedula_estudiante = '%s' AND cedula_estudiante2 = '%s') OR (cedula_estudiante = '%s' AND cedula_estudiante2 = '%s')",
                    titulo, cedula1, cedula2, nombreTutor.getText(), "Periodo", cedulaTutor, cedula1, cedula2, cedula2, cedula1);

            try {
                habana.ejecutarSentenciaSQl(updateSql);
//                JOptionPane.showMessageDialog(null, "Registro de trabajo de grado actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                habana.cerrarConexion();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el registro de trabajo de grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            String updateSql = String.format("UPDATE trabajo_grado SET titulo = '%s', tutor = '%s', periodo = '%s', cedula_tutor = '%s' WHERE (cedula_estudiante = '%s' AND cedula_estudiante2 = '%s') OR (cedula_estudiante = '%s' AND cedula_estudiante2 = '%s')",
                    titulo, nombreTutor.getText(), "Periodo", cedulaTutor, cedula1, cedula2, cedula2, cedula1);

            try {
                habana.ejecutarSentenciaSQl(updateSql);
//                JOptionPane.showMessageDialog(null, "Registro de trabajo de grado actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                habana.cerrarConexion();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar el registro de trabajo de grado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        habana.cerrarConexion();
    }//GEN-LAST:event_EliminarActionPerformed

    private void aDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aDeleteActionPerformed
        // TODO add your handling code here:
        String cedula1 = cedulacompi.getText();
        String cedula2 = titulop.getText();
        conexion habana = new conexion();
        if (cedula2.isEmpty()) {
            String deleteSql = String.format("DELETE FROM trabajo_grado WHERE cedula_estudiante = '%s'", cedula1);

            try {
                habana.ejecutarSentenciaSQl(deleteSql);
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Luego de la eliminación exitosa, actualiza la tabla Estudiantes para vaciar la columna id_pasantia
                String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_trabajo = NULL WHERE Cedula = '%s'", cedula1);

                habana.ejecutarSentenciaSQl(updateEstudiantesSql);

                JOptionPane.showMessageDialog(null, "La columna id_trabajo en la tabla Estudiantes ha sido vaciada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                habana.cerrarConexion();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                habana.cerrarConexion();

            }
        } else {
            String deleteSql = String.format("DELETE FROM trabajo_grado WHERE (cedula_estudiante = '%s' AND cedula_estudiante2 = '%s') OR (cedula_estudiante = '%s' AND cedula_estudiante2 = '%s')",
                    cedula1, cedula2, cedula2, cedula1);

            try {
                habana.ejecutarSentenciaSQl(deleteSql);
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Luego de la eliminación exitosa, actualiza la tabla Estudiantes para vaciar la columna id_trabajo
                String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_trabajo = NULL WHERE (Cedula = '%s' OR Cedula = '%s')", cedula1, cedula2);

                habana.ejecutarSentenciaSQl(updateEstudiantesSql);

                JOptionPane.showMessageDialog(null, "La columna id_trabajo en la tabla Estudiantes ha sido vaciada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                habana.cerrarConexion();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                habana.cerrarConexion();
            }
            habana.cerrarConexion();
        }
    }//GEN-LAST:event_aDeleteActionPerformed

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

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        int filaSeleccionada = profes.getSelectedRow();
        String cedula = String.valueOf(profes.getValueAt(filaSeleccionada, 0));
        String nombre = String.valueOf(profes.getValueAt(filaSeleccionada, 1));

        citutor.setText(cedula);
        nombreTutor.setText(nombre);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        conexion busquedaProf = new conexion();
        String busqueda = cedulaTutor.getText();
        String SQL = "SELECT * FROM Docentes WHERE Nombre LIKE '%" + busqueda + "%' OR Apellido LIKE '%" + busqueda + "%' OR Cedula LIKE '%" + busqueda + "%'";
        while (Tg.modprof.getRowCount() > 0) {
            Tg.modprof.removeRow(0);
        }

        try {
            ResultSet AgregarProf = busquedaProf.consultaRegistros(SQL);
            while (AgregarProf.next()) {
                String Nombre = AgregarProf.getString("Nombre") + " " + AgregarProf.getString("Apellido");
                Object[] search = {
                    AgregarProf.getString("Cedula"),
                    Nombre
                };
                modprof.addRow(search);
            };

        } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        } finally {
            busquedaProf.cerrarConexion();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        conexion busquedaProf = new conexion();
        String busqueda = cedulacompi.getText();
        String SQL = "SELECT * FROM estudiantes WHERE Nombre LIKE '%" + busqueda + "%' OR Apellido LIKE '%" + busqueda + "%' OR Cedula LIKE '%" + busqueda + "%'";
        while (Tg.modcompa.getRowCount() > 0) {
            Tg.modcompa.removeRow(0);
        }

        try {
            ResultSet AgregarProf = busquedaProf.consultaRegistros(SQL);
            while (AgregarProf.next()) {
                String Nombre = AgregarProf.getString("Nombre") + " " + AgregarProf.getString("Apellido");
                Object[] search = {
                    AgregarProf.getString("Cedula"),
                    Nombre
                };
                modcompa.addRow(search);
            }
        } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        } finally {
            busquedaProf.cerrarConexion();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void companerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companerosMouseClicked
        botonAgregar1.setEnabled(true);

        int filaSeleccionada = companeros.getSelectedRow();

        // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla
        if (filaAnterior == filaActual) {
            if (filaSeleccionada == filaAnterior) {
                companeros.clearSelection();
                botonAgregar1.setEnabled(false);
            }
        }
        // Actualizar la fila anterior
        filaAnterior = filaSeleccionada;
        filaActual = companeros.getSelectedRow();


    }//GEN-LAST:event_companerosMouseClicked

    private void botonAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregar1ActionPerformed
        int filaSeleccionada = companeros.getSelectedRow();
        String cedula = String.valueOf(companeros.getValueAt(filaSeleccionada, 0));
        String nombre = String.valueOf(companeros.getValueAt(filaSeleccionada, 1));
        NomCompa.setText(nombre);
        CiCompa.setText(cedula);
    }//GEN-LAST:event_botonAgregar1ActionPerformed

    private void NomCompaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomCompaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomCompaActionPerformed

    private void CiCompaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiCompaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiCompaActionPerformed

    private void titulopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulopActionPerformed
        
    }//GEN-LAST:event_titulopActionPerformed
    private boolean ambosEstudiantesExisten(String cedula1, String cedula2) {
        conexion habana = new conexion();
        String consultaEstudiante1 = String.format("SELECT COUNT(*) FROM estudiantes WHERE Cedula = '%s'", cedula1);
        String consultaEstudiante2 = String.format("SELECT COUNT(*) FROM estudiantes WHERE Cedula = '%s'", cedula2);

        ResultSet rs1 = habana.consultaRegistros(consultaEstudiante1);
        ResultSet rs2 = habana.consultaRegistros(consultaEstudiante2);

        try {
            if (rs1.next() && rs2.next()) {
                int cantidadEstudiante1 = rs1.getInt(1);
                int cantidadEstudiante2 = rs2.getInt(1);
                habana.cerrarConexion();
                return cantidadEstudiante1 > 0 && cantidadEstudiante2 > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        habana.cerrarConexion();
        return false; // Si hay un error, considera que no existen ambos estudiantes
    }

    private boolean ningunEstudianteTieneTrabajoDeGrado(String cedula1, String cedula2) {
        conexion habana = new conexion();
        String consultaTrabajo1 = String.format("SELECT id_trabajo FROM estudiantes WHERE Cedula = '%s'", cedula1);
        String consultaTrabajo2 = String.format("SELECT id_trabajo FROM estudiantes WHERE Cedula = '%s'", cedula2);

        ResultSet rs1 = habana.consultaRegistros(consultaTrabajo1);
        ResultSet rs2 = habana.consultaRegistros(consultaTrabajo2);

        try {
            if (rs1.next() && rs2.next()) {
                int idTrabajo1 = rs1.getInt("id_trabajo");
                int idTrabajo2 = rs2.getInt("id_trabajo");
                habana.cerrarConexion();
                return idTrabajo1 == 0 && idTrabajo2 == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        habana.cerrarConexion();
        return false; // Si hay un error, considera que ambos estudiantes tienen trabajos de grado asignados
    }

    private boolean ningunEstudianteTienePasantia(String cedula1, String cedula2) {
        conexion habana = new conexion();
        String consultaPasantia1 = String.format("SELECT id_pasantia FROM estudiantes WHERE Cedula = '%s'", cedula1);
        String consultaPasantia2 = String.format("SELECT id_pasantia FROM estudiantes WHERE Cedula = '%s'", cedula2);

        ResultSet rs1 = habana.consultaRegistros(consultaPasantia1);
        ResultSet rs2 = habana.consultaRegistros(consultaPasantia2);

        try {
            if (rs1.next() && rs2.next()) {
                int idPasantia1 = rs1.getInt("id_pasantia");
                int idPasantia2 = rs2.getInt("id_pasantia");
                habana.cerrarConexion();
                return idPasantia1 == 0 && idPasantia2 == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        habana.cerrarConexion();
        return false; // Si hay un error, considera que ambos estudiantes tienen pasantías asignadas
    }

    private void codigo(String tf) throws SQLException {
        conexion habana = new conexion();
        System.out.println("tf" + tf);
        String sql2 = "SELECT num_est, periodo, Escuela FROM estudiantes WHERE Cedula = '" + tf + "'";

        ResultSet rsC = habana.consultaRegistros(sql2);

        // Obtener los valores de las columnas y guardarlos en variables
        String num_est = rsC.getString("num_est");
        String periodoC = rsC.getString("periodo");
        String escuela = rsC.getString("Escuela");

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

        String cod = "FI-" + escuela + "-" + num_est + "-" + periodoC + "-" + "TG";

        String sql3 = String.format("UPDATE estudiantes SET codigo = '%s', tipo = 'Trabajo de grado' WHERE Cedula = '%s'", cod, tf);

        habana.ejecutarSentenciaSQl(sql3);
        habana.cerrarConexion();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CiCompa;
    private javax.swing.JButton Eliminar;
    public static javax.swing.JTextField NomCompa;
    private javax.swing.JButton aDelete;
    private javax.swing.JButton aSave;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAgregar1;
    private javax.swing.JTextField cedulaTutor;
    public static javax.swing.JTextField cedulacompi;
    public static javax.swing.JTextField citutor;
    public static javax.swing.JTable companeros;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField nombreTutor;
    public static javax.swing.JTable profes;
    public static javax.swing.JTextField titulop;
    // End of variables declaration//GEN-END:variables
}
