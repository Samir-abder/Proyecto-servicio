
package programa;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class Pasantiab extends javax.swing.JPanel {

     public static DefaultTableModel modtutores;
        int filaAnterior = -1;
        int filaActual = -2;
    
    public Pasantiab() {
        initComponents();
        modtutores = (DefaultTableModel) this.tutores.getModel();
        ListSelectionModel modeloSeleccion = tutores.getSelectionModel();
        modeloSeleccion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel24 = new javax.swing.JLabel();
        anteSave1 = new javax.swing.JButton();
        anteEdit1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tutorAcad = new javax.swing.JTextField();
        cedulaTutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tutores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        razontext = new javax.swing.JTextArea();
        botonAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cedulatuto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel24.setText("Titulo del proyecto");

        anteSave1.setText("Save");
        anteSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteSave1ActionPerformed(evt);
            }
        });

        anteEdit1.setText("Edit");
        anteEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteEdit1ActionPerformed(evt);
            }
        });

        jLabel26.setText("Tutor Académico");

        tutorAcad.setEnabled(false);

        jLabel1.setText("Tutor");

        jButton1.setText("buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        if (tutores.getColumnModel().getColumnCount() > 0) {
            tutores.getColumnModel().getColumn(0).setResizable(false);
            tutores.getColumnModel().getColumn(1).setResizable(false);
        }

        razontext.setColumns(20);
        razontext.setRows(5);
        jScrollPane2.setViewportView(razontext);

        botonAgregar.setText("agregar");
        botonAgregar.setEnabled(false);
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Cedula");

        jLabel3.setText("Pasantia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tutorAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cedulatuto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cedulaTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonAgregar))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(anteEdit1)
                        .addGap(35, 35, 35)
                        .addComponent(anteSave1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel24))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(botonAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tutorAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cedulatuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anteEdit1)
                    .addComponent(anteSave1))
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void anteSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteSave1ActionPerformed
String cedula1 = Alumnosside.cedulaEst.getText();//cedula del alumno

String razonSocial = razontext.getText();//titulo del proyecto

String tutorAcademico = tutorAcad.getText();//nombre del tutor

String cedulaEstudiante = Alumnosside.cedulaEst.getText();//cedula del alumno otra vez?

String cedulatutor = cedulatuto.getText();//cedula del tutor

String periodo = "Periodo"; // No está claro de dónde obtienes este valor

// Verifica que los campos no estén vacíos
if (!razonSocial.isEmpty() && !tutorAcademico.isEmpty() && !cedulaEstudiante.isEmpty()) {
//    String updateSql = String.format("UPDATE Pasantia SET"
//            + " razon_social = '%s',"
//            + " tutor_academico = '%s',"
//            + " periodo = '%s'"
//            + " WHERE cedula_estudiante = '%s'",
//            razonSocial,
//            tutorAcademico,
//            periodo,
//            cedulaEstudiante);

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
                            String consultatrabajo = "SELECT id_trabajo FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                            ResultSet rstrabajo = habana.consultaRegistros(consultatrabajo);
                            int idtrabajo = rstrabajo.getInt("id_trabajo");

                            try {
                                if (idtrabajo != 0) {//(se verifica que no tenga trabajo de grado)

                                    JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene un trabajo de grado asignado.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    // El estudiante no tiene una pasantía asignada
                                    
                                    String countSql = "SELECT COUNT(*) AS rowCount FROM Pasantia";
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
                                String cod = "FI-" + escuela1 + "-" + formattedRowCount + "-" + peri + "-" + "PS";
                                    String addSql = String.format("INSERT INTO Pasantia (razon_social, tutor_academico, cedula_estudiante, periodo, cedula_tutor, codigo) VALUES"
                                        + "('%s', '%s', '%s', '%s', '%s', '%s')",
                                        razontext.getText(), tutorAcad.getText(), Alumnosside.cedulaEst.getText(),"Periodo", cedulatutor, cod);

                                    habana.ejecutarSentenciaSQl(addSql);
                                    
                                    

                                    // Obtener el último valor autoincremental de la tabla
                                    String getLastIdSql = "SELECT last_insert_rowid()";
                                    ResultSet lastIdResultSet = habana.consultaRegistros(getLastIdSql);
                                    
                                   

                                    if (lastIdResultSet.next()) {
                                        int idGenerado = lastIdResultSet.getInt(1);
                                        // Actualizar la tabla estudiantes con el ID generado
                                        String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_pasantia = %d WHERE Cedula = '%s'", idGenerado, cedula1);
                                        habana.ejecutarSentenciaSQl(updateEstudiantesSql);

                                    }
                                    
                                     String sql2 = "SELECT num_est, periodo, Escuela FROM estudiantes WHERE Cedula = '" + Alumnosside.cedulaEst.getText() + "'";
                
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

                             cod = "FI-" + escuela + "-" + num_est + "-" + periodoC + "-" + "PS";

                            String sql3 = String.format("UPDATE estudiantes SET codigo = '%s', tipo = 'Pasantia' WHERE Cedula = '%s'", cod, Alumnosside.cedulaEst.getText());

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
}else {
    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de actualizar.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
   

}
    }//GEN-LAST:event_anteSave1ActionPerformed

    private void anteEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteEdit1ActionPerformed
       conexion habana = new conexion();
String razonSocial = razontext.getText();
String tutorAcademico = tutorAcad.getText();
String tutorci = cedulatuto.getText();
String cedulaEstudiante = Alumnosside.cedulaEst.getText();
String periodo = "Periodo"; // No está claro de dónde obtienes este valor

// Verifica que los campos no estén vacíos
if (!razonSocial.isEmpty() && !tutorAcademico.isEmpty() && !cedulaEstudiante.isEmpty()) {
try {
    String updateSql = String.format("UPDATE Pasantia SET razon_social = '%s', tutor_academico = '%s', periodo = '%s', cedula_tutor = '%s' WHERE cedula_estudiante = '%s'",
            razonSocial, tutorAcademico, periodo,tutorci, cedulaEstudiante);

    System.out.println("u "+ updateSql);
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
        String busqueda = cedulaTutor.getText();
        String SQL = "SELECT * FROM Docentes WHERE Nombre LIKE '%"+ busqueda +"%' OR Apellido LIKE '%"+ busqueda +"%' OR Cedula LIKE '%"+ busqueda +"%'";
        while (Pasantiab.modtutores.getRowCount() > 0) {
            Pasantiab.modtutores.removeRow(0);
        }
        
        try {
            ResultSet AgregarProf = busquedaProf.consultaRegistros(SQL);
            while(AgregarProf.next()){
                String Nombre = AgregarProf.getString("Nombre") + " " + AgregarProf.getString("Apellido");
                Object[] search = {
                    AgregarProf.getString("Cedula"),
                    Nombre
                };
            modtutores.addRow(search);
            }
            
          } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        }finally{
          busquedaProf.cerrarConexion();
         }
       
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tutoresMouseClicked
        
        botonAgregar.setEnabled(true);
        
        int filaSeleccionada = tutores.getSelectedRow();

        // Si la fila seleccionada es la misma que la fila anterior, deseleccionarla
        if (filaAnterior == filaActual) {
            if (filaSeleccionada == filaAnterior) {
                tutores.clearSelection();
                botonAgregar.setEnabled(false);
            }
        }
        // Actualizar la fila anterior
        filaAnterior = filaSeleccionada;
        filaActual = tutores.getSelectedRow();
        
        
        
    }//GEN-LAST:event_tutoresMouseClicked

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        int filaSeleccionada = tutores.getSelectedRow();
        String cedula = String.valueOf(tutores.getValueAt(filaSeleccionada, 0));
        String nombre = String.valueOf(tutores.getValueAt(filaSeleccionada, 1));
        cedulatuto.setText(cedula);
        tutorAcad.setText(nombre);
    }//GEN-LAST:event_botonAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteEdit1;
    private javax.swing.JButton anteSave1;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JTextField cedulaTutor;
    private javax.swing.JTextField cedulatuto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea razontext;
    public static javax.swing.JTextField tutorAcad;
    public static javax.swing.JTable tutores;
    // End of variables declaration//GEN-END:variables
}
