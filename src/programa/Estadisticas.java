
package programa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Estadisticas extends javax.swing.JPanel {
    public static DefaultTableModel modelos;
        String peri = "";

    public Estadisticas() {
        initComponents();
        modelos = (DefaultTableModel) estads.getModel();
        conexion objConexion = new conexion();
        ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
        try {
            if (rst.next()) {
                int rowCount = rst.getInt("count");
                if (rowCount != 0) {
                    peri = rst.getString("periodo");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            while (modelos.getRowCount() > 0) {
            modelos.removeRow(0);
            }
            String[] escuelas = {"Civil","Computación","Electrónica","Industrial","Mecánica","Telecomunicaciones"};
            String[] tipo = {"Pasantia","Trabajo de grado"};
            
            
            int trabajosTotales=0; //sumatoria de x+z
            int totalEstudiantesEnTtrabajos=0;//sumatoria de x+y
            int totalDePasantias=0;//sumatoria de x
            int totalDeTrabajosDeGrado=0;//sumatoria de z
            int estudiantesTotalesPasantia=0;//sumatoria de x
            int estudiantesTotalesTrabajoDeGrado=0;//sumatoria de y
           
            for(int j=0;j<=escuelas.length;j++){
                
                int estudiantePasantiaEscuela=0;//x 
                int estudianteTrabajoGradoEscuela=0;//y
                int trabajosDeGradoRegistrados=0;//z
                int subtotalTrabajosEscuela=0; //x+z
                int subtotalEstudiantesEscuela=0;//x+y
                if(j<=5){
                    for(int i=0;i<tipo.length;i++){//ciclo que recorre los tipos de trabajo
                        
                        String sql = "SELECT COUNT(*) FROM estudiantes WHERE Tipo ='" + tipo[i] + "' AND Escuela ='" + escuelas[j] + "'";
                        ResultSet result = objConexion.consultaRegistros(sql);
                        
                    if (result != null && result.next()){//se verificate que el resultado no sea null
                        if (i == 0) {//si el tipo es pasantia...
                            
                            estudiantePasantiaEscuela = result.getInt(1); //se obtiene el estudiante de una escuela que este en pasantia
                            estudiantesTotalesPasantia+=estudiantePasantiaEscuela;    //se suman todos los estudiantes en pasantias
                            totalDePasantias+=estudiantePasantiaEscuela; // el total de pasantias es lo mismo que el total de estudiantes en pasatias
                            
                        } else if (i == 1) {//si el tipo es tg...
              
                            estudianteTrabajoGradoEscuela = result.getInt(1);//se obtienen los estudiantes que estan trabajo de grado de una escuela
                            estudiantesTotalesTrabajoDeGrado+=estudianteTrabajoGradoEscuela;//se suman todos los estudiantes que estan en tg
                            
                            sql= "SELECT COUNT(DISTINCT id_trabajo) FROM estudiantes WHERE Escuela='"+escuelas[j]+"'";
                            result = objConexion.consultaRegistros(sql);
                            
                            if (result != null && result.next()) {
                                
                                trabajosDeGradoRegistrados=result.getInt(1);//se obtienen los id_trabajo de los trabajos de grados
                                totalDeTrabajosDeGrado+=trabajosDeGradoRegistrados;//se suman todos los trabajos de grados 
                            }
                        }
                    }
                    subtotalEstudiantesEscuela = estudiantePasantiaEscuela + estudianteTrabajoGradoEscuela; //subtotal de estudiantes por escuela
                    subtotalTrabajosEscuela = estudiantePasantiaEscuela + trabajosDeGradoRegistrados;//subtotal de trabajos por escuela
                    
                    trabajosTotales+=subtotalTrabajosEscuela;
                    totalEstudiantesEnTtrabajos+=subtotalEstudiantesEscuela;
                    
                    
                    }
                    Object[] est = {
                        escuelas[j],
                        estudiantePasantiaEscuela,
                        estudianteTrabajoGradoEscuela,
                        subtotalEstudiantesEscuela,
                        estudiantePasantiaEscuela,
                        trabajosDeGradoRegistrados,
                        subtotalTrabajosEscuela
                    };
                    modelos.addRow(est);
                }else{
                    
                    
                    Object[] esta = {"Total",
                        estudiantesTotalesPasantia,
                        estudiantesTotalesTrabajoDeGrado,
                        totalEstudiantesEnTtrabajos,
                        totalDePasantias,
                        totalDeTrabajosDeGrado,
                        trabajosTotales
                    };
                    modelos.addRow(esta);
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e);
        }finally{
            objConexion.cerrarConexion();
        }
        
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        estads = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        estads.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Escuela", "IP 1 ", "TG 1", "Sub-total", "IP 1", "TG 1", "Sub-total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estads.setFocusable(false);
        estads.setRequestFocusEnabled(false);
        estads.setShowGrid(true);
        jScrollPane1.setViewportView(estads);
        if (estads.getColumnModel().getColumnCount() > 0) {
            estads.getColumnModel().getColumn(0).setResizable(false);
            estads.getColumnModel().getColumn(1).setResizable(false);
            estads.getColumnModel().getColumn(2).setResizable(false);
            estads.getColumnModel().getColumn(3).setResizable(false);
            estads.getColumnModel().getColumn(4).setResizable(false);
            estads.getColumnModel().getColumn(5).setResizable(false);
            estads.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("                           Estudiantes                                                                                  Trabajos");
        jLabel2.setRequestFocusEnabled(false);

        jButton1.setText("Culminar semestre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Esta opción es irreversible y procedera con la culminación del semestre.\nEsta seguro que desea continuar?", "Confirmar",
            JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String rutaCarpeta = "Historial de semestres";
            String nombreArchivo = peri + ".s3db";
            // Crear el archivo de destino en la carpeta "Historial semestres"
            File archivoDestino = new File(rutaCarpeta, nombreArchivo);
            // Guardar la base de datos en el archivo de destino
            guardarBaseDeDatos(archivoDestino);
            Actualizar();
            Base base = new Base();
            base.cerrarVentana();
        } else if (result == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancelar pulsado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

  private void guardarBaseDeDatos(File archivo) {
        // Aquí implementarás el código para guardar la base de datos en el archivo.
        // Puedes utilizar la biblioteca de tu elección para hacer copias de seguridad de la base de datos.
        // Por ejemplo, si estás utilizando SQLite, puedes copiar el archivo de la base de datos en el archivo seleccionado.
        // Asegúrate de manejar las excepciones adecuadamente.

        // Ejemplo para copiar la base de datos a un archivo de destino
        File baseDeDatos = new File("database.s3db");
        try {
            Files.copy(baseDeDatos.toPath(), archivo.toPath());
            JOptionPane.showMessageDialog(this, "Base de Datos guardada exitosamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la Base de Datos");
        }
    }

    public static void Actualizar() {
        try {
            System.out.println("actualizar");
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
            while (resultado.next()) {
                if ("true".equals(resultado.getString("Estado"))) {
                    String ced = resultado.getString("cedula");
                    if ("9vno".equals(resultado.getString("Nivel"))) {
                        String updateSql = String.format("UPDATE estudiantes SET Nivel = '%s' , Estado = '%s' WHERE Cedula = '" + ced + "'",
                                "10mo",
                                false
                        );

                        objConexion.ejecutarSentenciaSQl(updateSql);
                    } else {
                        String tipo = resultado.getString("Tipo");
                        if (tipo.equals("Trabajo de grado")) {
                            String id_tg = resultado.getString("id_trabajo");
                            String sql = "DELETE FROM trabajo_grado WHERE id_trabajo = '" + id_tg + "'";
                            objConexion.ejecutarSentenciaSQl(sql);
                        } else if (tipo.equals("Diseño")) {
                            String id_d = resultado.getString("id_diseno");
                            String sql = "DELETE FROM Diseno WHERE id_diseno = '" + id_d + "'";
                            objConexion.ejecutarSentenciaSQl(sql);
                        } else if (tipo.equals("Pasantia")) {
                            String id_tg = resultado.getString("id_pasantia");
                            String sql = "DELETE FROM Pasantia WHERE id_pasantia = '" + id_tg + "'";
                            objConexion.ejecutarSentenciaSQl(sql);
                        }

                        String sql2 = "DELETE FROM estudiantes WHERE Cedula = '" + ced + "'";
                        objConexion.ejecutarSentenciaSQl(sql2);
                    }
                }
            }
            String sql = "Delete FROM Periodos";
            objConexion.ejecutarSentenciaSQl(sql);
            objConexion.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable estads;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
