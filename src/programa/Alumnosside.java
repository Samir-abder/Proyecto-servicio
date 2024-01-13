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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Alumnosside extends javax.swing.JPanel {

    public Alumnosside() {
        initComponents();

    }


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
        agregarEstudiante = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreEst = new javax.swing.JTextField();
        apellidoEst = new javax.swing.JTextField();
        editB = new javax.swing.JButton();
        tipo = new javax.swing.JComboBox<>();
        nivel = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ComboModo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        base = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Tipo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 50, -1));
        jPanel1.add(cedulaEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, -1));

        jLabel5.setText("Escuela:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel6.setText("Cedula:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        escuelaEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Arquitectura", "Civil", "Computación", "Electrónica", "Industrial", "Mecánica", "Telecomunicaciones" }));
        escuelaEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuelaEstActionPerformed(evt);
            }
        });
        jPanel1.add(escuelaEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 170, -1));

        agregarEstudiante.setText("Guardar");
        agregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(agregarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));

        cancelar.setText("Cancel");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

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
        jPanel1.add(editB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Trabajo de grado", "Pasantia", "Diseño", "Sin asignar" }));
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        jPanel1.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 170, -1));

        nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre","9vno", "10mo"}));
        nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivelActionPerformed(evt);
            }
        });
        jPanel1.add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 170, -1));

        jLabel3.setText("Modo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        ComboModo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Pareja" }));
        jPanel1.add(ComboModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 170, -1));

        jLabel7.setText("Semestre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

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

    Alumnos.botonAgr.setEnabled(true);
    Base base = (Base) this.getRootPane().getParent();
    JPanel Fondo = (JPanel) base.getContentPane().getComponent(0);
    Fondo.removeAll();

    // Agregar el panel Alumnos
    Alumnos alumnos = new Alumnos();
    alumnos.setSize(Fondo.getWidth(), Fondo.getHeight());
    alumnos.setLocation(0, 0);
    Fondo.add(alumnos, BorderLayout.CENTER);
    
    // Validar y repintar el panel Fondo
    Fondo.revalidate();
    Fondo.repaint();

    }//GEN-LAST:event_cancelarActionPerformed

    
    private void escuelaEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuelaEstActionPerformed

        if(escuelaEst.getSelectedIndex()!=1){
            tipo.setModel(new DefaultComboBoxModel<>(new String[]{ "Tipo",
                "Trabajo de grado",
                "Pasantia",
                "Sin asignar" }));
        }else{
            tipo.setModel(new DefaultComboBoxModel<>(new String[]{ "Tipo",
                "Trabajo de grado",
                "Pasantia",
                "Diseño",
                "Sin asignar" }));

        }
        if(escuelaEst.getSelectedIndex()==1){
            tipo.setSelectedIndex(3);
            tipo.setEnabled(false);
            ComboModo.setEnabled(false);
        }else{
            tipo.setSelectedIndex(0);
            tipo.setEnabled(true);
            ComboModo.setEnabled(true);
        }  
      
    }//GEN-LAST:event_escuelaEstActionPerformed

    private void agregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstudianteActionPerformed
        
        
        if(tipo.getSelectedIndex()==1){ //si se selecciona el trabajo de grado
            
            if(ComboModo.getSelectedIndex()==0){//si se trabaja individual
                
                base.removeAll();
                Tg tg = new Tg();
                tg.setBounds(0,0, base.getWidth(), 600);
                base.add(tg);
                Base bas = (Base)this.getRootPane().getParent();
                bas.setMinimumSize(new Dimension(1000,600));
                bas.setLocationRelativeTo(null);
                bas.repaint();
                bas.revalidate();
                
            }else if(ComboModo.getSelectedIndex()==1){//si se trabaja en pareja
                
                base.removeAll();
                Tg tg = new Tg();
                tg.setBounds(0,0, base.getWidth(), 600);
                base.add(tg);
                Base bas = (Base)this.getRootPane().getParent();
                bas.setMinimumSize(new Dimension(1000,600));
                bas.setLocationRelativeTo(null);
                bas.repaint();
                bas.revalidate();
                
            }
        }else if(tipo.getSelectedIndex()==2){//si se selecciona las pasantias
            base.removeAll();
            Pasantiab ps = new Pasantiab();
            ps.setBounds(0,0, base.getWidth(), 600);
            base.add(ps);
            Base bas = (Base)this.getRootPane().getParent();
            bas.setMinimumSize(new Dimension(1000,600));
            bas.setLocationRelativeTo(null);
            bas.repaint();
            bas.revalidate();
        }else if(tipo.getSelectedIndex()==3){
        
        }
        
        
        
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

                nombreEst.setEnabled(false);
                apellidoEst.setEnabled(false);
                cedulaEst.setEnabled(false) ;
                escuelaEst.setEnabled(false);
                nivel.setEnabled(false);
                tipo.setEnabled(false);
                ComboModo.setEnabled(false);
                agregarEstudiante.setEnabled(false);

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

    
    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        // TODO add your handling code here:

        conexion objConexion = new conexion();
        if (!nombreEst.getText().isEmpty() && !apellidoEst.getText().isEmpty()
                && !cedulaEst.getText().isEmpty()
                && escuelaEst.getSelectedItem() != "Default") {
            try {
                String updateSql = String.format("UPDATE estudiantes SET Nombre = '%s', Apellido = '%s', Escuela = '%s' WHERE Cedula = '" + Alumnos.cedula + "'",
                        nombreEst.getText(),
                        apellidoEst.getText(),
                        
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

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
          if (tipo.getSelectedIndex()==1) {
            // Si es el ítem 1, activa el botón
            ComboModo.setEnabled(true);
        } else {
            // Si no es el ítem 1, desactiva el botón
            ComboModo.setSelectedIndex(0);
            ComboModo.setEnabled(false);
            
        }
    
    }//GEN-LAST:event_tipoActionPerformed

    private void nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nivelActionPerformed

public void codigoAlumno(String nombre, String apellido,String cedula,String escuela, String fecha, String nivel, String tipo) {
    try {
        conexion objConexion = new conexion();
    String peri = "2023-2CR";

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
    private javax.swing.JComboBox<String> ComboModo;
    public static javax.swing.JButton agregarEstudiante;
    public static javax.swing.JTextField apellidoEst;
    private javax.swing.JPanel base;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    public static javax.swing.JTextField cedulaEst;
    public static javax.swing.JButton editB;
    private javax.swing.JComboBox<String> escuelaEst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nivel;
    public static javax.swing.JTextField nombreEst;
    private javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
