/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Alumnosside extends javax.swing.JPanel {

    public Alumnosside() {
        initComponents();
//        buttonGroup1.add(TraGr);
//        buttonGroup1.add(Pas);
//         base.removeAll();
//        Pasantia ps = new Pasantia();
//        ps.setBounds(0,0, base.getWidth(), 600);
//        base.add(ps);
//        Base bas = (Base)this.getRootPane().getParent();
//        bas.setMinimumSize(new Dimension(1000,600));
//        bas.setLocationRelativeTo(null);
//        bas.repaint();
//        bas.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cedulaEst = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        escuelaEst = new javax.swing.JComboBox<>();
        facultadEst = new javax.swing.JTextField();
        agregarEstudiante = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreEst = new javax.swing.JTextField();
        apellidoEst = new javax.swing.JTextField();
        editB = new javax.swing.JButton();
        tipo = new javax.swing.JComboBox<>();
        nivel = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TraGr = new javax.swing.JRadioButton();
        Pas = new javax.swing.JRadioButton();
        base = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Facultad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 50, -1));
        jPanel1.add(cedulaEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, -1));

        jLabel5.setText("Escuela:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel6.setText("Cedula:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        escuelaEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Arquitectura", "Civil", "Computación", "Electrónica", "Industrial", "Mecánica", "Telecomunicaciones" }));
        escuelaEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuelaEstActionPerformed(evt);
            }
        });
        jPanel1.add(escuelaEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 170, -1));

        facultadEst.setEditable(false);
        facultadEst.setText("Ingeniería");
        facultadEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultadEstActionPerformed(evt);
            }
        });
        jPanel1.add(facultadEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 170, -1));

        agregarEstudiante.setText("Guardar");
        agregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(agregarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        cancelar.setText("Cancel");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel1.add(nombreEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, -1));
        jPanel1.add(apellidoEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 170, -1));

        editB.setText("edit");
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });
        jPanel1.add(editB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Trabajo de grado", "Pasantia", "Diseño", "Sin asignar" }));
        jPanel1.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 170, -1));

        nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre","9vno", "10mo"}));
        jPanel1.add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 170, -1));

        jLabel10.setText("Tipo de proyecto");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        TraGr.setText("Trabajo de grado");
        TraGr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TraGrMouseClicked(evt);
            }
        });
        TraGr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraGrActionPerformed(evt);
            }
        });
        jPanel1.add(TraGr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        Pas.setText("Pasantia");
        Pas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PasMouseClicked(evt);
            }
        });
        jPanel1.add(Pas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 170));

        base.setBackground(new java.awt.Color(0, 0, 51));
        base.setFocusable(false);
        base.setPreferredSize(new java.awt.Dimension(100, 483));

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        add(base, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 570, 460));
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        //forma correcta
        Alumnos.botonAgr.setEnabled(true);
        this.setVisible(false);

        /*forma incorrecta de hacer las cosas down below
        // Obtener la referencia al frame principal

        Base base = (Base) this.getRootPane().getParent();

        // Obtener la referencia al panel Fondo
        JPanel Fondo = (JPanel) base.getContentPane().getComponent(0);

        // Eliminar el panel AlumnosAgregar
        Fondo.removeAll();

        // Agregar el panel Alumnos
        Alumnos alumnos = new Alumnos();
        alumnos.setSize(Fondo.getWidth(), Fondo.getHeight());
        alumnos.setLocation(0, 0);
        Fondo.add(alumnos, BorderLayout.CENTER);

        // Validar y repintar el panel Fondo
        Fondo.revalidate();
        Fondo.repaint();
         */
    }//GEN-LAST:event_cancelarActionPerformed

//    private void cargar() {
//        Alumnos al = new Alumnos();
//        while (al.modeloa.getRowCount() > 0) {
//            al.modeloa.removeRow(0);
//        }
//        try {
//            conexion objConexion = new conexion();
//            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
//            while (resultado.next()) {
//                Object[] oUsuarioD = {false, resultado.getString("Nombre"),
//                    resultado.getString("Apellido"), resultado.getString("Cedula"),
//                    resultado.getString("Facultad"), resultado.getString("Escuela")};
//
//                al.modeloa.addRow(oUsuarioD);
//
////                objConexion.cerrarConexion();
//            }
//        } catch (Exception e) {
//            System.out.println("este es " + e);
//
//        }
//
//    }
    private void escuelaEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuelaEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escuelaEstActionPerformed

    private void agregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstudianteActionPerformed
        // TODO add your handling code here:
        conexion objConexion = new conexion();
//        Connection conn = null;
// PreparedStatement pstmt = null;
// conn = SQLiteConnection.connect();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date creacion = new Date();
        String hoy = formato.format(creacion);

        try {

            if (!nombreEst.getText().isEmpty() && !apellidoEst.getText().isEmpty()
                    && !cedulaEst.getText().isEmpty()
                    && escuelaEst.getSelectedItem() != "Default" && tipo.getSelectedItem() != "Tipo" && nivel.getSelectedItem() != "Semestre") {

                codigoAlumno(nombreEst.getText(), apellidoEst.getText(), cedulaEst.getText(),  escuelaEst.getSelectedItem().toString(), 
                        hoy, tipo.getSelectedItem().toString(), nivel.getSelectedItem().toString());

                nombreEst.setText("");
                apellidoEst.setText("");
                cedulaEst.setText("");
                escuelaEst.setSelectedIndex(0);

            } else {
                System.out.println("Llene todos los campos...");
                JOptionPane.showMessageDialog(null, "llene todos los campos...");
                objConexion.cerrarConexion();
            }
            objConexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error al guardar los datos con la base de datos");
            objConexion.cerrarConexion();
        }
        objConexion.cerrarConexion();

        Base.cargar();
    }//GEN-LAST:event_agregarEstudianteActionPerformed

    private void facultadEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultadEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultadEstActionPerformed

    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        // TODO add your handling code here:

        conexion objConexion = new conexion();
        if (!nombreEst.getText().isEmpty() && !apellidoEst.getText().isEmpty()
                && !cedulaEst.getText().isEmpty()
                && escuelaEst.getSelectedItem() != "Default") {
            try {
                String updateSql = String.format("UPDATE estudiantes SET Nombre = '%s', Apellido = '%s', Facultad = '%s', Escuela = '%s' WHERE Cedula = '" + Alumnos.cedula + "'",
                        nombreEst.getText(),
                        apellidoEst.getText(),
                        facultadEst.getText(),
                        escuelaEst.getSelectedItem().toString(),
                        cedulaEst.getText()
                );

                objConexion.ejecutarSentenciaSQl(updateSql);
            } catch (Exception e) {
                System.out.println("Error al guardar los datos con la base de datos");
                objConexion.cerrarConexion();
            }

        } else {
            System.out.println("Llene todos los campos...");
            JOptionPane.showMessageDialog(null, "llene todos los campos...");
            objConexion.cerrarConexion();
        }
        Alumnos.cargar();
    }//GEN-LAST:event_editBActionPerformed

    private void TraGrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TraGrMouseClicked
        base.removeAll();
        Tg tg = new Tg();
        tg.setBounds(0,0, base.getWidth(), 600);
        base.add(tg);
        Base bas = (Base)this.getRootPane().getParent();
        bas.setMinimumSize(new Dimension(1000,600));
        bas.setLocationRelativeTo(null);
        bas.repaint();
        bas.revalidate();
        //luis jose mrk
    }//GEN-LAST:event_TraGrMouseClicked

    private void TraGrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraGrActionPerformed

    }//GEN-LAST:event_TraGrActionPerformed

    private void PasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasMouseClicked
        base.removeAll();
        Pasantiab ps = new Pasantiab();
        ps.setBounds(0,0, base.getWidth(), 600);
        base.add(ps);
        Base bas = (Base)this.getRootPane().getParent();
        bas.setMinimumSize(new Dimension(1000,600));
        bas.setLocationRelativeTo(null);
        bas.repaint();
        bas.revalidate();
    }//GEN-LAST:event_PasMouseClicked

public void codigoAlumno(String nombre, String apellido,String cedula,String escuela, String fecha, String nivel, String tipo) {
    try {
        conexion objConexion = new conexion();
    String peri = "2023-2CR";
ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
if (rst.next()) {
                int rowCount = rst.getInt("count");
                if (rowCount == 0) {
 peri = rst.getString("periodo");
                }}
                    System.out.println(peri);
                String sql = "select count(*) FROM estudiantes WHERE periodo = '" + peri + "' AND Escuela = '" + escuela + "'";
                System.out.println("sentencia" + sql);

                ResultSet count = objConexion.consultaRegistros(sql);
                int resultado = 0;
                if (count.next()) {
        
            resultado = Integer.parseInt(count.getString(1)) + 1;
        
                }
                System.out.println("count" + resultado);

                String formatonum = "%03d";
                String resultadoC = String.format(formatonum, resultado);
boolean existeEstudiante = estudianteExiste(cedula);
if (existeEstudiante) {
    System.out.println("El estudiante existe en la base de datos.");
} else {
     System.out.println("ESTE ES COUNT"+objConexion.ejecutarSentenciaSQl(sql));
                String addSql = String.format("INSERT INTO estudiantes (Nombre, Apellido, Cedula, Facultad, Escuela, fecha_registro, periodo, num_est, Nivel, Tipo) VALUES"
                        + "('" + nombre
                        + "','" + apellido + "','" + cedula + "','" + "Ingeniería"
                        + "','" + escuela + "','" + fecha + "','" + peri + "','" + resultadoC + "','" + nivel + "','" + tipo + "') ");
                objConexion.ejecutarSentenciaSQl(addSql);
}
//              

                String sql2 = "SELECT num_est, periodo, Escuela FROM estudiantes WHERE Cedula = '" + cedula + "'";
                ResultSet rs = objConexion.consultaRegistros(sql2);

                // Obtener los valores de las columnas y guardarlos en variables
                String num_est = rs.getString("num_est");
                String periodo = rs.getString("periodo");
                String escuela1 = rs.getString("Escuela");

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
                String cod = "FI-" + escuela + "-" + resultadoC + "-" + periodo + "-" + "";
if(tipo=="Trabajo de grado"){
                cod = "FI-" + escuela + "-" + resultadoC + "-" + periodo + "-" + "TG";
}
else if(tipo == "Pasantia"){
    cod = "FI-" + escuela + "-" + resultadoC + "-" + periodo + "-" + "PS";
}
else if(tipo == "Diseño" && nivel=="9vno") {
    cod = "FI-" + escuela + "-" + resultadoC + "-" + periodo + "-" + "DIX";
}
else{
    cod = "FI-" + escuela + "-" + resultadoC + "-" + periodo + "-" + "DX";
    }
                String sql3 = String.format("UPDATE estudiantes SET codigo = '%s' WHERE Cedula = '" + cedula + "'",
                        cod);
                objConexion.ejecutarSentenciaSQl(sql3);
                objConexion.cerrarConexion();
                } catch (SQLException ex) {
                    System.out.println("errororor");
            Logger.getLogger(Alumnosside.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public boolean estudianteExiste(String cedula) {
    conexion objConexion = new conexion();
    String sql = "SELECT 1 FROM estudiantes WHERE Cedula = ?";

    try {
        
        

        ResultSet resultado = objConexion.consultaRegistros("SELECT 1 FROM estudiantes WHERE Cedula = '" + cedula + "'");

        boolean existe = resultado.next(); // true si se encuentra al menos un registro
        resultado.close();
        return existe;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        objConexion.cerrarConexion();
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Pas;
    private javax.swing.JRadioButton TraGr;
    public static javax.swing.JButton agregarEstudiante;
    public static javax.swing.JTextField apellidoEst;
    private javax.swing.JPanel base;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    public static javax.swing.JTextField cedulaEst;
    public static javax.swing.JButton editB;
    private javax.swing.JComboBox<String> escuelaEst;
    private javax.swing.JTextField facultadEst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nivel;
    public static javax.swing.JTextField nombreEst;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
