
package programa;


import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static programa.Alumnosside.cedulaEst;


/**
 *
 * @author lujop
 */
public class profesoresside extends javax.swing.JPanel {


    public profesoresside() {
        initComponents();
        cedulaP.setEnabled(true);
        
        beditar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreP = new javax.swing.JTextField();
        apellidoP = new javax.swing.JTextField();
        cedulaP = new javax.swing.JTextField();
        baceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        beditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        profesion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(386, 394));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel4.setText("Cedula");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));
        jPanel1.add(nombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 230, -1));
        jPanel1.add(apellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 230, -1));

        cedulaP.setActionCommand("<Not Set>");
        cedulaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaPActionPerformed(evt);
            }
        });
        jPanel1.add(cedulaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 230, -1));

        baceptar.setText("Aceptar");
        baceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baceptarActionPerformed(evt);
            }
        });
        jPanel1.add(baceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        beditar.setText("Editar");
        beditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditarActionPerformed(evt);
            }
        });
        jPanel1.add(beditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        jLabel1.setText("Profesión:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        profesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profesionActionPerformed(evt);
            }
        });
        jPanel1.add(profesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 230, -1));

        jLabel5.setText("Profesore");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
    
    Profesores.botonagr.setEnabled(true);
    this.setVisible(false);
   
    cedulaP.setText("");
    nombreP.setText("");
    apellidoP.setText("");
    profesion.setText("");
    
    
    }//GEN-LAST:event_cancelarActionPerformed

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        //se abre la conexion a la base de datos
        conexion objConexion = new conexion();

        //Se prepara la consulta para verificar si es que el profesor existe en la base de datos
        String consultaVerificar = "SELECT * FROM Docentes WHERE Cedula = '" + cedulaP.getText() + "'";
        ResultSet rsVerificar = objConexion.consultaRegistros(consultaVerificar);
        try {
            //Se verifica si el profesor esta repetido usando su numero de cedula
            if (rsVerificar.next()) {
            JOptionPane.showMessageDialog(null, "El profesor con la cedula "+cedulaP.getText()+" Existe");
            //objConexion.cerrarConexion();
            
            }
            else{
                
                try {
                    //Se Verifica si alguno de los campos esta vacio
                    if (!nombreP.getText().isEmpty() && !apellidoP.getText().isEmpty()
                            && cedulaP.getText().matches("\\d{7,8}") && !profesion.getText().isEmpty()) {
                        //Si no estan vacios se procede a tomar los valores de los campos e incertarlos en la base de datos
                        String addSql = String.format("INSERT INTO Docentes (Nombre, Apellido, Cedula,Profesion) VALUES"
                                + "('" + nombreP.getText()
                                + "','" + apellidoP.getText()
                                + "','" + cedulaP.getText()
                                + "','" + profesion.getText()+ "') ");
                        objConexion.ejecutarSentenciaSQl(addSql);
                        
                        nombreP.setText("");
                        apellidoP.setText("");
                        cedulaP.setText("");
                        profesion.setText("");                   
                    } else {
                        System.out.println("Llene todos los campos...");
                        JOptionPane.showMessageDialog(null, "llene los campos correctamente y asegurese que la cedula tenga 8 digitos");
                    }
                    
                    
                } catch (Exception e) {
                    System.out.println("Error al guardar los datos con la base de datos");
                }
                
               
            }
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(profesoresside.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //se renueva la tabla 
        try {
            while (Profesores.modelP.getRowCount() > 0) {
                Profesores.modelP.removeRow(0);
            }                     
            ResultSet resulta = objConexion.consultaRegistros("SELECT * FROM Docentes");
            while (resulta.next()) {
                Object[] oUsuarioD = { 
                resulta.getString("Nombre"),
                resulta.getString("Apellido"),
                resulta.getString("Cedula"),
                resulta.getString("Profesion")
                };
            Profesores.modelP.addRow(oUsuarioD);
            }
            }catch (SQLException e) {
                System.out.println("este es " + e);
            }
        //Se cierra la conexion
        objConexion.cerrarConexion();
         
        
    }//GEN-LAST:event_baceptarActionPerformed

    private void beditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditarActionPerformed
        // TODO add your handling code here:
        conexion objConexion = new conexion();
        
        if(!nombreP.getText().isEmpty() && 
                !apellidoP.getText().isEmpty()
                && cedulaP.getText().matches("\\d{8}") 
                && !profesion.getText().isEmpty()){
            
            String sql = String.format("UPDATE Docentes SET Nombre = '%s', Apellido = '%s', Cedula = '%s', Profesion = '%s' WHERE Cedula = '" + Profesores.cedula + "'",
                nombreP.getText(),
                apellidoP.getText(),
                cedulaP.getText(),
                profesion.getText());
        
            objConexion.ejecutarSentenciaSQl(sql);
            System.out.println("updatio?");
            nombreP.setText("");
            apellidoP.setText("");
            cedulaP.setText("");
            profesion.setText("");
            
        try {
            while (Profesores.modelP.getRowCount() > 0) {
                Profesores.modelP.removeRow(0);
            }                     
            ResultSet resulta = objConexion.consultaRegistros("SELECT * FROM Docentes");
            while (resulta.next()) {
                Object[] oUsuarioD = { 
                resulta.getString("Nombre"),
                resulta.getString("Apellido"),
                resulta.getString("Cedula"),
                resulta.getString("Profesion")
                };
            Profesores.modelP.addRow(oUsuarioD);
            }
            }catch (SQLException e) {
                System.out.println("este es " + e);
            }
         Base.cargarProfesores();
         objConexion.cerrarConexion();}
        
        else{JOptionPane.showMessageDialog(null, "llene los campos correctamente y asegurese que la cedula tenga 8 digitos");}
    }//GEN-LAST:event_beditarActionPerformed

    private void profesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profesionActionPerformed

    private void cedulaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaPActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cedulaPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField apellidoP;
    public static javax.swing.JButton baceptar;
    public static javax.swing.JButton beditar;
    private javax.swing.JButton cancelar;
    public static javax.swing.JTextField cedulaP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField nombreP;
    public static javax.swing.JTextField profesion;
    // End of variables declaration//GEN-END:variables
}
