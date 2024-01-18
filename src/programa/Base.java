package programa;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Base extends javax.swing.JFrame {

    /**
     * Creates new form Base
     */
   public Base() {

        super("Coordinacion de trabajos de grado y pasantias");

        initComponents();
        this.setMinimumSize(new Dimension(800, 650));
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Fondo.setLayout(new BorderLayout());

        conexion objConexion = new conexion();
        ResultSet rs = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
        try {
            if (rs.next()) {
                int rowCount = rs.getInt("count");
                if (rowCount == 0) {

                    objConexion.cerrarConexion();
                    jMenuBar1.setVisible(false);
                    Periodo periodo = new Periodo();
                    periodo.setLocation(0, 0);
                    Fondo.removeAll();
                    Fondo.add(periodo);
                    Fondo.revalidate();
                    Fondo.repaint();
//                    jMenuBar1.setVisible(true);

                } else {
                    Alumnos alumnos = new Alumnos();
                    alumnos.setSize(Fondo.getWidth(), Fondo.getHeight());
                    //alumnos.setBounds(0,0,900,500);
                    Fondo.removeAll();
                    Fondo.add(alumnos, BorderLayout.CENTER);
                    Fondo.revalidate();
                    Fondo.repaint();
                    this.pack();
                    this.setMinimumSize(new Dimension(alumnos.getWidth(), alumnos.getHeight()));
                    
                    try {
            
                        ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
                        while (resultado.next()) {
                            Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                                resultado.getString("Apellido"),resultado.getString("Nivel")
                                , resultado.getString("Tipo"), resultado.getString("Escuela"),
                                Boolean.parseBoolean(resultado.getString("Estado"))};

                            Alumnos.modeloa.addRow(UsuarioD);
           
                        }
                    } catch (SQLException e) {
                        System.out.println("este es " + e);
                    }finally{
                        objConexion.cerrarConexion();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        objConexion.cerrarConexion();
    }

    
    String url="jdbc:sqlite:database.s3db";
    Connection connect;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        Fondo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        semestreActual = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        listaAlumnos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        listadeprofes = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(204, 0, 51));
        Fondo.setLayout(new java.awt.CardLayout());
        getContentPane().add(Fondo, java.awt.BorderLayout.CENTER);
        Fondo.getAccessibleContext().setAccessibleDescription("");

        jMenu1.setText("Opciones");

        semestreActual.setText("Cargar semestre actual");
        semestreActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestreActualActionPerformed(evt);
            }
        });
        jMenu1.add(semestreActual);

        jMenuItem2.setText("Cargar historico");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Culminar semestre");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Modificación decanato");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Alumnos");

        listaAlumnos.setText("Lista de alumnos");
        listaAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAlumnosActionPerformed(evt);
            }
        });
        jMenu2.add(listaAlumnos);

        jMenuItem1.setText("Agenda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem8.setText("Carga masiva");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Profesores");

        listadeprofes.setText("Lista de profesores");
        listadeprofes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadeprofesActionPerformed(evt);
            }
        });
        jMenu3.add(listadeprofes);

        jMenuItem6.setText("Carga masiva profesores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Plantillas");

        jMenuItem9.setText("Plantillas");
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Log in");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listadeprofesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadeprofesActionPerformed
       Profesores profes = new Profesores();

        profes.setLocation(0,0);
        Fondo.removeAll();
        Fondo.add(profes);
        Fondo.revalidate();
        Fondo.repaint();
        this.setMinimumSize(new Dimension(900,600));
        this.setLocationRelativeTo(null);
        cargarProfesores();
        
        
    }//GEN-LAST:event_listadeprofesActionPerformed

    private void listaAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAlumnosActionPerformed
        Alumnos alumnos = new Alumnos();
        alumnos.setLocation(0,0);
   
        Fondo.removeAll();
        Fondo.add(alumnos);
        Fondo.revalidate();
        Fondo.repaint();
        this.setMinimumSize(new Dimension(900,600));
        this.setLocationRelativeTo(null);

        /*try {
            connect = DriverManager.getConnection(url);
            if(connect!=null){
                JOptionPane.showMessageDialog(null, "Conectado!!!!");
            }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }*/
        while (Alumnos.modeloa.getRowCount() > 0) {
            Alumnos.modeloa.removeRow(0);
        }
        conexion objConexion = new conexion();
        try {
            
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Nivel")
                    , resultado.getString("Tipo"), resultado.getString("Escuela"),
                    Boolean.parseBoolean(resultado.getString("Estado"))};

                Alumnos.modeloa.addRow(UsuarioD);
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }finally{
            objConexion.cerrarConexion();
        }
    }//GEN-LAST:event_listaAlumnosActionPerformed

    private void semestreActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestreActualActionPerformed

        try {
            connect = DriverManager.getConnection(url);
            if(connect!=null){
                //JOptionPane.showMessageDialog(null, "Conectado");
                System.out.println("Conectado");
            }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        while (Alumnos.modeloa.getRowCount() > 0) {
            Alumnos.modeloa.removeRow(0);
        }
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
            while (resultado.next()) {
                Object[] UsuarioD = {
                    resultado.getString("Cedula"),
                    resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),
                    resultado.getString("Nivel"),
                    resultado.getString("Tipo"),
                    resultado.getString("Escuela"),
                    Boolean.parseBoolean(resultado.getString("Estado"))};

                Alumnos.modeloa.addRow(UsuarioD);
//              objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }
    }//GEN-LAST:event_semestreActualActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Fondo.removeAll();
        Agenda agnd = new Agenda();
        Fondo.add(agnd);
        Fondo.revalidate();
        Fondo.repaint();        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        cargaM carga = new cargaM();
        carga.setLocation(0,0);
        Fondo.removeAll();
        Fondo.add(carga);
        Fondo.revalidate();
        Fondo.repaint();
        this.setMinimumSize(new Dimension(900,600));
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos SQLite", "db", "s3db"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String nuevaRuta = fileChooser.getSelectedFile().getAbsolutePath();
            conexion miConexion = new conexion(); // Crear una instancia de conexion
        miConexion.setConexionDB(nuevaRuta);
        Alumnos alumnos = new Alumnos();
        alumnos.setLocation(0,0);
   
        Fondo.removeAll();
        Fondo.add(alumnos);
        Fondo.revalidate();
        Fondo.repaint();
        this.setMinimumSize(new Dimension(900,600));
        this.setLocationRelativeTo(null);

        /*try {
            connect = DriverManager.getConnection(url);
            if(connect!=null){
                JOptionPane.showMessageDialog(null, "Conectado!!!!");
            }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }*/
        while (Alumnos.modeloa.getRowCount() > 0) {
            Alumnos.modeloa.removeRow(0);
        }
        conexion objConexion = new conexion();
        try {
            
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Nivel")
                    , resultado.getString("Tipo"), resultado.getString("Escuela"),
                    Boolean.parseBoolean(resultado.getString("Estado"))};

                Alumnos.modeloa.addRow(UsuarioD);
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
            System.out.println("este es " + e);
        }finally{
            objConexion.cerrarConexion();
        }
        Alumnos.cargar();
        } else {
            // El usuario canceló la selección de archivo.
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
   
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Semestre semestre = new Semestre();
        semestre.setLocation(0,0);
        Fondo.removeAll();
        Fondo.add(semestre);
        Fondo.revalidate();
        Fondo.repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       try {
           // TODO add your handling code here:
           Decanat dec = new Decanat();
           dec.setLocation(0,0);
           Fondo.removeAll();
           Fondo.add(dec);
           Fondo.revalidate();
           Fondo.repaint();
       } catch (SQLException ex) {
           Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
       
           // TODO add your handling code here:
           CargaProfe carg = new CargaProfe();
           carg.setLocation(0,0);
           Fondo.removeAll();
           Fondo.add(carg);
           Fondo.revalidate();
           Fondo.repaint();
      
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    public static void cargar() {
       
        while (Alumnos.modeloa.getRowCount() > 0) {
            Alumnos.modeloa.removeRow(0);
        }
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
            while (resultado.next()) {
                Object[] UsuarioD = {resultado.getString("Cedula"),resultado.getString("Nombre"), 
                    resultado.getString("Apellido"),resultado.getString("Facultad")
                    , resultado.getString("Escuela")};

                Alumnos.modeloa.addRow(UsuarioD);
                System.out.println(UsuarioD);
//                objConexion.cerrarConexion();
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
    
    public static void cargarProfesores() {
        while (Profesores.modelP.getRowCount() > 0) {
            Profesores.modelP.removeRow(0);
        }
        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM Docentes");
            while (resultado.next()) {
                Object[] oUsuarioD = { 
                    resultado.getString("Nombre"),
                    resultado.getString("Apellido"),
                    resultado.getString("Cedula"),
                    resultado.getString("Profesion")
                };

                Profesores.modelP.addRow(oUsuarioD);

//                objConexion.cerrarConexion();
            }
        } catch (Exception e) {
            System.out.println("este es " + e);

        }

    }
    
    public void cerrarVentana() {
        // Obtiene el comando de inicio del programa actual
        String javaCmd = System.getProperty("java.home") + "/bin/java";
        String classpath = System.getProperty("java.class.path");
        String className = Base.class.getCanonicalName();

        // Lanza una nueva instancia del programa
        ProcessBuilder processBuilder = new ProcessBuilder(javaCmd, "-cp", classpath, className);
        try {
            processBuilder.start();
        } catch (IOException ex) {
            
        }

        // Cierra la ventana actual
        System.exit(0);

    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem listaAlumnos;
    private javax.swing.JMenuItem listadeprofes;
    private javax.swing.JMenuItem semestreActual;
    // End of variables declaration//GEN-END:variables
}
