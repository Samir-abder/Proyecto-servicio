/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Alumnosside extends javax.swing.JPanel {

    public static String tipoEC;
    public static String escuelaEC;

    public Alumnosside() {
        initComponents();

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
        baseSide = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Tipo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 50, -1));
        jPanel1.add(cedulaEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 170, -1));

        jLabel5.setText("Escuela:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel6.setText("Cedula:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        escuelaEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Arquitectura", "Civil", "Computación", "Electrónica", "Industrial", "Mecánica", "Telecomunicaciones" }));
        escuelaEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escuelaEstActionPerformed(evt);
            }
        });
        jPanel1.add(escuelaEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 170, -1));

        agregarEstudiante.setText("Guardar");
        agregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(agregarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 120, 90, -1));

        cancelar.setText("X");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        jPanel1.add(nombreEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 170, -1));
        jPanel1.add(apellidoEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 170, -1));

        editB.setText("edit");
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });
        jPanel1.add(editB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Trabajo de grado", "Pasantia", "Diseño", "Sin asignar" }));
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });
        jPanel1.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 170, -1));

        nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre","9vno", "10mo"}));
        jPanel1.add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 170, -1));

        jLabel3.setText("Modo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        ComboModo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Pareja" }));
        jPanel1.add(ComboModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 170, -1));

        jLabel7.setText("Semestre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 170));

        baseSide.setBackground(new java.awt.Color(0, 0, 51));
        baseSide.setFocusable(false);
        baseSide.setPreferredSize(new java.awt.Dimension(100, 483));

        javax.swing.GroupLayout baseSideLayout = new javax.swing.GroupLayout(baseSide);
        baseSide.setLayout(baseSideLayout);
        baseSideLayout.setHorizontalGroup(
            baseSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        baseSideLayout.setVerticalGroup(
            baseSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        add(baseSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 570, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        
        int tip = Alumnos.tipoDeProyecto.getSelectedIndex();
        int esc = Alumnos.escf.getSelectedIndex();
        int semes = Alumnos.semestre.getSelectedIndex();
        int TGmod = Alumnos.semestre.getSelectedIndex();
        
        Alumnos.botonAgr.setEnabled(true);
        nombreEst.setText("");
        apellidoEst.setText("");
        cedulaEst.setText("");
        escuelaEst.setSelectedIndex(0);
        nivel.setSelectedIndex(0);
        tipo.setSelectedIndex(0);
        ComboModo.setSelectedIndex(0);
        agregarEstudiante.setEnabled(false);

        Base base = (Base) this.getRootPane().getParent();
        JPanel Fondo = (JPanel) base.getContentPane().getComponent(0);
        Fondo.removeAll();

        // Agregar el panel Alumnos
        Alumnos alumnos = new Alumnos();
        alumnos.setSize(Fondo.getWidth(), Fondo.getHeight());
        alumnos.setLocation(0, 0);
        Fondo.add(alumnos, BorderLayout.CENTER);
        
        //recargar la tabla
            
        Alumnos.tipoDeProyecto.setSelectedIndex(tip);
        Alumnos.escf.setSelectedIndex(esc);
        Alumnos.semestre.setSelectedIndex(semes);
        Alumnos.semestre.setSelectedIndex(TGmod);
        Alumnos.cargarFiltros();
       
        // Validar y repintar el panel Fondo
        Fondo.revalidate();
        Fondo.repaint();

    }//GEN-LAST:event_cancelarActionPerformed

    private void escuelaEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escuelaEstActionPerformed

        if (escuelaEst.getSelectedIndex() != 1) {
            tipo.setModel(new DefaultComboBoxModel<>(new String[]{"Tipo",
                "Trabajo de grado",
                "Pasantia",
                "Sin asignar"}));
        } else {
            tipo.setModel(new DefaultComboBoxModel<>(new String[]{"Tipo",
                "Pasantia",
                "Diseño",
                "Sin asignar"}));

        }
        if (escuelaEst.getSelectedIndex() == 1) {
            tipo.setSelectedIndex(3);
            tipo.setEnabled(true);
            ComboModo.setEnabled(false);
        } else {
            tipo.setSelectedIndex(0);
            tipo.setEnabled(true);
            ComboModo.setEnabled(true);
        }

    }//GEN-LAST:event_escuelaEstActionPerformed

    private void agregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarEstudianteActionPerformed

        conexion objConexion = new conexion();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date creacion = new Date();
        String hoy = formato.format(creacion);

        try {

            if (!nombreEst.getText().isEmpty()
                    && !apellidoEst.getText().isEmpty()
                    && cedulaEst.getText().matches("\\d{8}")
                    && !"Default".equals(escuelaEst.getSelectedItem())
                    && !"Semestre".equals(nivel.getSelectedItem())
                    && !"Tipo".equals(tipo.getSelectedItem())) {

                codigoAlumno(nombreEst.getText(), apellidoEst.getText(), cedulaEst.getText(), escuelaEst.getSelectedItem().toString(),
                        hoy, nivel.getSelectedItem().toString(), tipo.getSelectedItem().toString(), ComboModo.getSelectedItem().toString());

//                nombreEst.setEnabled(false);
//                apellidoEst.setEnabled(false);
//                cedulaEst.setEnabled(false);
//                escuelaEst.setEnabled(false);
//                nivel.setEnabled(false);
//                tipo.setEnabled(false);
//                ComboModo.setEnabled(false);
//                agregarEstudiante.setEnabled(false);
                objConexion.cerrarConexion();
                
            if (tipo.getSelectedIndex() == 1) { //si se selecciona el trabajo de grado

            if (ComboModo.getSelectedIndex() == 0) {//si se trabaja individual

                baseSide.removeAll();
                Tg tg = new Tg();
                tg.setBounds(0, 0, baseSide.getWidth(), 400);
                baseSide.add(tg);
                Base bas = (Base) this.getRootPane().getParent();
                bas.setMinimumSize(new Dimension(1000, 600));
                bas.setLocationRelativeTo(null);
                Alumnos.mostrarProfesTg();
                bas.repaint();
                bas.revalidate();

            } else if (ComboModo.getSelectedIndex() == 1) {//si se trabaja en pareja

                baseSide.removeAll();
                Tg tg = new Tg();
                tg.setBounds(0, 0, baseSide.getWidth(), 400);
                baseSide.add(tg);
                Base bas = (Base) this.getRootPane().getParent();
                bas.setMinimumSize(new Dimension(1000, 600));
                bas.setLocationRelativeTo(null);
                Alumnos.mostrarProfesTg();
                bas.repaint();
                bas.revalidate();

            }
        } else if (tipo.getSelectedIndex() == 2) {//si se selecciona las pasantias
            
            baseSide.removeAll();
            Pasantiab ps = new Pasantiab();
            ps.setBounds(0, 0, baseSide.getWidth(), 400);
            baseSide.add(ps);
            Base bas = (Base) this.getRootPane().getParent();
            bas.setMinimumSize(new Dimension(1000, 600));
            bas.setLocationRelativeTo(null);
            //se cargan los profesores
            Alumnos.mostrarProfesPasantia();
            
            bas.repaint();
            bas.revalidate(); 
            
        } else if (tipo.getSelectedIndex() == 3) {//si se selecciona diseño
            baseSide.removeAll();
            Diseno ps = new Diseno();
            ps.setBounds(0, 0, baseSide.getWidth(), 600);
            baseSide.add(ps);
            Base bas = (Base) this.getRootPane().getParent();
            bas.setMinimumSize(new Dimension(1000, 600));
            bas.setLocationRelativeTo(null);
            bas.repaint();
            bas.revalidate();
        }
            } else {

                //System.out.println("Asegurese de llenar todos los campos del formulario correctamente");
                JOptionPane.showMessageDialog(null, "Por favor asegurese que el campo de cedula solo contenga números(8) y rellenar los campos del formulario correctamente");
                objConexion.cerrarConexion();
            }
            objConexion.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error al guardar los datos con la base de datos");
            objConexion.cerrarConexion();
        }
        objConexion.cerrarConexion();

        Alumnos.cargar();
    }//GEN-LAST:event_agregarEstudianteActionPerformed


    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date creacion = new Date();
        String hoy = formato.format(creacion);
        conexion objConexion = new conexion();
        if (!nombreEst.getText().isEmpty() && !apellidoEst.getText().isEmpty()
                && cedulaEst.getText().matches("\\d{8}")
                && escuelaEst.getSelectedItem() != "Default" && nivel.getSelectedItem() != "Tipo" && tipo.getSelectedItem() != "Semestre") {
            try {
                String updateSql = String.format("UPDATE estudiantes SET Nombre = '%s', Apellido = '%s', Escuela = '%s', Nivel = '%s', Tipo = '%s', Cedula = '%s', Modo = '%s' WHERE Cedula = '" + Alumnos.cedula + "'",
                        nombreEst.getText(),
                        apellidoEst.getText(),
                        escuelaEst.getSelectedItem().toString(),
                        nivel.getSelectedItem().toString(),
                        tipo.getSelectedItem().toString(),
                        cedulaEst.getText(),
                        ComboModo.getSelectedItem().toString()
                );

                objConexion.ejecutarSentenciaSQl(updateSql);
                codigoAlumno(nombreEst.getText(), apellidoEst.getText(), cedulaEst.getText(), escuelaEst.getSelectedItem().toString(),
                        hoy, nivel.getSelectedItem().toString(), tipo.getSelectedItem().toString(), ComboModo.getSelectedItem().toString());

            } catch (Exception e) {
                System.out.println("Error al guardar los datos con la base de datos");
                objConexion.cerrarConexion();
            }

        } else {
            //System.out.println("Llene todos los campos...");
            JOptionPane.showMessageDialog(null, "Por favor asegurese que el campo de cedula solo contenga números(8) y rellenar los campos del formulario correctamente");
            objConexion.cerrarConexion();
        }
//        Alumnos al = new Alumnos();
//        al.cargarFiltros();

//        Base.cargar();
        objConexion.cerrarConexion();
        Alumnos.cargar();
        try {
            objConexion = new conexion();

            // Paso 1: Obtener resultados
            ResultSet resultados = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Tipo = '" + tipoEC + "' AND Escuela = '" + escuelaEC + "'");

            // Paso 2 y 3: Iterar sobre los resultados y actualizar numest
            int nuevoNumEst = 1;
            String peri = "2023-2CR";
            ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
            if (rst.next()) {
                int rowCount = rst.getInt("count");
                if (rowCount != 0) {
                    peri = rst.getString("periodo");
                }
            }
            while (resultados.next()) {
                String tipo = resultados.getString("Tipo");
                String cedul = resultados.getString("Cedula");
                String escuela = resultados.getString("Escuela");
                String nivel = resultados.getString("Nivel");
                System.out.println("numero" + nuevoNumEst);

                // Actualizar numest para todas las filas que coinciden con tipo y escuela
                actualizarNumEstYCodigo(objConexion, tipo, escuela, nuevoNumEst, cedul, peri, nivel);
                nuevoNumEst = nuevoNumEst + 1;
            }

            // Cerrar la conexión
            objConexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_editBActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        if(escuelaEst.getSelectedIndex()!=1){
            if (tipo.getSelectedIndex() == 1) {
                // Si es el ítem 1, activa el botón
                ComboModo.setEnabled(true);
            } else {
                // Si no es el ítem 1, desactiva el botón
                ComboModo.setSelectedIndex(0);
                ComboModo.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tipoActionPerformed

    public void codigoAlumno(String nombre, String apellido, String cedula, String escuela, String fecha, String nivel, String tipo, String modo) {
        try {

            conexion objConexion = new conexion();
            String peri = "2023-2CR";
            ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
            if (rst.next()) {
                int rowCount = rst.getInt("count");
                if (rowCount != 0) {
                    peri = rst.getString("periodo");
                }
            }
            String sql = "select count(*) FROM estudiantes WHERE Tipo = '" + tipo + "' AND Escuela = '" + escuela + "'";

            ResultSet count = objConexion.consultaRegistros(sql);
            int resultado = 0;
            if (count.next()) {

                resultado = Integer.parseInt(count.getString(1)) + 1;

            }

            String formatonum = "%03d";
            String resultadoC = String.format(formatonum, resultado);
            boolean existeEstudiante = estudianteExiste(cedula);
            if (existeEstudiante) {
                JOptionPane.showMessageDialog(null, "El estudiante con la cedula " + cedula + " ya existe en la base de datos");
            } 
            else {
                String addSql = String.format("INSERT INTO estudiantes (Nombre, Apellido, Cedula, Facultad, Escuela, fecha_registro, periodo, num_est, Nivel, Tipo, Modo) VALUES"
                        + "('" + nombre
                        + "','" + apellido + "','" + cedula + "','" + "Ingeniería"
                        + "','" + escuela + "','" + fecha + "','" + peri + "','" + resultadoC + "','" + nivel + "','" + tipo + "','" + modo + "') ");
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
            String cod = "FI-" + escuela1 + "-" + resultadoC + "-" + peri + "-" + "";
            if (tipo == "Trabajo de grado") {
                cod = "FI-" + escuela1 + "-" + resultadoC + "-" + peri + "-" + "TG";
            } else if (tipo == "Pasantia") {
                cod = "FI-" + escuela1 + "-" + resultadoC + "-" + peri + "-" + "PS";
            } else if (tipo == "Diseño" && nivel == "9vno") {
                cod = "FI-" + escuela1 + "-" + resultadoC + "-" + peri + "-" + "DIX";
            } else {
                cod = "FI-" + escuela1 + "-" + resultadoC + "-" + peri + "-" + "DX";
            }
            String sql3 = String.format("UPDATE estudiantes SET codigo = '%s' WHERE Cedula = '" + cedula + "'",
                    cod);
            objConexion.ejecutarSentenciaSQl(sql3);
            objConexion.cerrarConexion();
            
            
        } 
            catch (SQLException ex) {
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

    public String primeraMayuscula(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        } else {
            return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
        }
    }

    private static void actualizarNumEstYCodigo(conexion objConexion, String tipo, String escuela, int nuevoNumEst, String cedulac, String peri, String nivel) throws SQLException {
        // Formatear el nuevo número como cadena de tres dígitos
        String formatoNumEst = "%03d";
        String nuevoNumEstFormateado = String.format(formatoNumEst, nuevoNumEst);
        String escuelaW = escuela;
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

        String cod = "FI-" + escuela + "-" + nuevoNumEstFormateado + "-" + peri + "-";
        if ("Trabajo de grado".equals(tipo)) {
            cod += "TG";
        } else if ("Pasantia".equals(tipo)) {
            cod += "PS";
        } else if ("Diseño".equals(tipo) && "9vno".equals(nivel)) {
            cod += "DIX";
        } else if ("Diseño".equals(tipo) && "10mo".equals(nivel)) {
            cod += "DX";
        }

        // Sentencia SQL para actualizar num_est y codigo
        String updateSql = String.format("UPDATE estudiantes SET num_est = '%s', codigo = '%s' WHERE Tipo = '%s' AND Escuela = '%s' AND Cedula = '%s'", nuevoNumEstFormateado, cod, tipo, escuelaW, cedulac);
        System.out.println(updateSql);
        // Ejecutar la actualización
        objConexion.ejecutarSentenciaSQl(updateSql);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> ComboModo;
    public static javax.swing.JButton agregarEstudiante;
    public static javax.swing.JTextField apellidoEst;
    public static javax.swing.JPanel baseSide;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    public static javax.swing.JTextField cedulaEst;
    public static javax.swing.JButton editB;
    public static javax.swing.JComboBox<String> escuelaEst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JComboBox<String> nivel;
    public static javax.swing.JTextField nombreEst;
    public static javax.swing.JComboBox<String> tipo;
    // End of variables declaration//GEN-END:variables
}
