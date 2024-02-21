/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel; 
import static programa.Estadisticas.Actualizar;

/**
 *
 * @author karly
 */
public class registro extends javax.swing.JPanel {

    Dictionary Registros = new Hashtable();
    static Dictionary totales = new Hashtable();
    String peri = "";
    DefaultTableModel modelo;
    public registro() throws SQLException {
        initComponents();
        
        modelo = (DefaultTableModel) estadisticas.getModel();
        conexion objConexion = new conexion();
        
        String[] escuela = {"Civil", "Computación", "Electrónica", "Industrial", "Mecánica", "Telecomunicaciones", "Arquitectura"};
        String[] nivel = {"9vno", "10mo"};
        String[] tipo = {"id_trabajo", "id_pasantia", "id_diseno"};
        
        Map<String, Integer> registros = new HashMap<>(); // Usaremos un Map para almacenar los resultados
        
        for (String i : escuela) {
            for (String j : nivel) {
                for (String k : tipo) {
                    
                    if (i.equals("Arquitectura")) {
                        if(k.equals("id_trabajo")){
                            System.out.println("Arquitectura no tiene trabajo de grado");
                        }
                        else{
                            int contador = contarRegistros(objConexion, "Arquitectura", j, k);
                            
                            System.out.println("");
                            registros.put("Arquitectura " + "- " + j + " - " + k, contador); 
                        }
                    }
                    
                    else{
                        if(k.equals("id_diseno")){
                            System.out.println(i+ " no tiene Diseño");
                        }
                        else{
                            int contador = contarRegistros(objConexion, i, j, k);
                            System.out.println("");
                            registros.put(i + "-" + j + "-" + k, contador);
                        }
                    }
                    
                    funcionTotal(objConexion, j, k);
                     
                }
            }
        }
        
//        for (String e: escuela) {
        // Imprimimos los resultados
            for (Map.Entry<String, Integer> entry : registros.entrySet()) {
                System.out.println("Escuela: " + entry.getKey() + ", Total respectivo: " + entry.getValue());
                
                
            }
        
        
        
                    //        SUM OPERATIONS
        int civilsub1 = registros.get("Civil-9vno-id_pasantia") + registros.get("Civil-9vno-id_trabajo"), civilsub2= registros.get("Civil-10mo-id_pasantia")+registros.get("Civil-10mo-id_trabajo");
        int compusub1 = registros.get("Computación-9vno-id_pasantia") + registros.get("Computación-9vno-id_trabajo"), compusub2= registros.get("Computación-10mo-id_pasantia")+registros.get("Computación-10mo-id_trabajo");
        int elecsub1 = registros.get("Electrónica-9vno-id_pasantia") + registros.get("Electrónica-9vno-id_trabajo"), elecsub2= registros.get("Electrónica-10mo-id_pasantia")+registros.get("Electrónica-10mo-id_trabajo");
        int insub1 = registros.get("Industrial-9vno-id_pasantia") + registros.get("Industrial-9vno-id_trabajo"), insub2= registros.get("Industrial-10mo-id_pasantia")+registros.get("Industrial-10mo-id_trabajo");
        int mecsub1 = registros.get("Mecánica-9vno-id_pasantia") + registros.get("Mecánica-9vno-id_trabajo"), mecsub2= registros.get("Mecánica-10mo-id_pasantia")+registros.get("Mecánica-10mo-id_trabajo");
        int telesub1 = registros.get("Telecomunicaciones-9vno-id_pasantia") + registros.get("Telecomunicaciones-9vno-id_trabajo"), telesub2= registros.get("Telecomunicaciones-10mo-id_pasantia")+registros.get("Telecomunicaciones-10mo-id_trabajo");
        int arsub1 = registros.get("Arquitectura - 9vno - id_pasantia") + registros.get("Arquitectura - 9vno - id_diseno"), arsub2= registros.get("Arquitectura - 10mo - id_pasantia")+registros.get("Arquitectura - 10mo - id_diseno");
        
//                               TOTALES  
//        int totalP1 = registros.get("Civil-9vno-id_pasantia") + registros.get("Computación-9vno-id_pasantia") + registros.get("Electrónica-9vno-id_pasantia")
//                + registros.get("Industrial-9vno-id_pasantia")+registros.get("Mecánica-9vno-id_pasantia")+registros.get("Telecomunicaciones-9vno-id_pasantia")
//                + registros.get("Arquitectura-9vno-id_pasantia");
//                
//                int totalTG1= registros.get("Civil-9vno-id_trabajo") + registros.get("Computación-9vno-id_trabajo") + registros.get("Electrónica-9vno-id_trabajo")
//                + registros.get("Industrial-9vno-id_trabajo")+registros.get("Mecánica-9vno-id_trabajo")+registros.get("Telecomunicaciones-9vno-id_trabajo");
//                
//               int totalD1= registros.get("Arquitectura - 9vno - id_diseno");
//                
//                int totalP2= registros.get("Civil-10mo-id_pasantia") + registros.get("Computación-10mo-id_pasantia") + registros.get("Electrónica-10mo-id_pasantia")
//                + registros.get("Industrial-10mo-id_pasantia")+registros.get("Mecánica-10mo-id_pasantia")+registros.get("Telecomunicaciones-10mo-id_pasantia")
//                + registros.get("Arquitectura-10mo-id_pasantia");
//                
//                int totalTG2= registros.get("Civil-10mo-id_trabajo") + registros.get("Computación-10mo-id_trabajo") + registros.get("Electrónica-10mo-id_trabajo")
//                + registros.get("Industrial-10mo-id_trabajo")+registros.get("Mecánica-10mo-id_trabajo")+registros.get("Telecomunicaciones-10mo-id_trabajo");
//                
//                int totalD2= registros.get("Arquitectura - 10mo - id_diseno");
                
                
                System.out.println(totales);
                int total1= civilsub1+compusub1+elecsub1+insub1+mecsub1+telesub1+arsub1;
                int total2= civilsub2+compusub2+elecsub2+insub2+mecsub2+telesub2+arsub2;
        
        
        
//                      LLENADO DE LA TABLA DE REGISTROS
        modelo.addRow(new Object[]{"Civil",registros.get("Civil-9vno-id_pasantia"),
            registros.get("Civil-9vno-id_trabajo"),"0",civilsub1,registros.get("Civil-10mo-id_pasantia"),
            registros.get("Civil-10mo-id_trabajo"),"0",civilsub2});
        modelo.addRow(new Object[]{"Computación",registros.get("Computación-9vno-id_pasantia"),registros.get("Computación-9vno-id_trabajo"),"0",compusub1,registros.get("Computación-10mo-id_pasantia"),registros.get("Computación-10mo-id_trabajo"),"0",compusub2});
        modelo.addRow(new Object[]{"Electrónica",registros.get("Electrónica-9vno-id_pasantia"),registros.get("Electrónica-9vno-id_trabajo"),"0",elecsub1,registros.get("Electrónica-10mo-id_pasantia"),registros.get("Electrónica-10mo-id_trabajo"),"0",elecsub2});
        modelo.addRow(new Object[]{"Industrial",registros.get("Industrial-9vno-id_pasantia"),registros.get("Industrial-9vno-id_trabajo"),"0",insub1,registros.get("Industrial-10mo-id_pasantia"),registros.get("Industrial-10mo-id_trabajo"),"0",insub2});
        modelo.addRow(new Object[]{"Mecánica",registros.get("Mecánica-9vno-id_pasantia"),registros.get("Mecánica-9vno-id_trabajo"),"0",mecsub1,registros.get("Mecánica-10mo-id_pasantia"),registros.get("Mecánica-10mo-id_trabajo"),"0",mecsub1});
        modelo.addRow(new Object[]{"Telecomunicaciones",registros.get("Telecomunicaciones-9vno-id_pasantia"),registros.get("Telecomunicaciones-9vno-id_trabajo"),"0",telesub1,registros.get("Telecomunicaciones-10mo-id_pasantia"),registros.get("Telecomunicaciones-10mo-id_trabajo"),"0",telesub2});
        modelo.addRow(new Object[]{"Arquitectura",registros.get("Arquitectura - 9vno - id_pasantia"),"0",registros.get("Arquitectura - 9vno - id_diseno"),arsub1,registros.get("Arquitectura - 10mo - id_pasantia"),"0",registros.get("Arquitectura - 10mo - id_diseno"),arsub2});
        modelo.addRow(new Object[]{"TOTAL",totales.get("id_pasantia-9vno"),totales.get("id_trabajo-9vno"),totales.get("id_diseno-9vno") ,total1,totales.get("id_pasantia-10mo"),totales.get("id_trabajo-10mo"),totales.get("id_diseno-10mo"),total2});
        
        String peri = "2023-2CR";
        conexion habana = new conexion();
        ResultSet rst = habana.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
        try {
            if (rst.next()) {
                int rowCountP = rst.getInt("count");
                if (rowCountP != 0) {
                    peri = rst.getString("periodo");
                    periodoLabel.setText("Periodo: " + peri);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            habana.cerrarConexion();
        }
    }

    
    // Método para contar registros en la base de datos
    private static int contarRegistros(conexion objConexion, String escuela, String nivel, String tipo) {
        System.out.println(tipo);
        String sql = "SELECT COUNT("+tipo+") AS total FROM estudiantes WHERE Escuela = '" + escuela + "' AND Nivel = '" + nivel + "' AND "+tipo+" IS NOT NULL AND "+tipo+" != ''";//AND " + tipo + " IS NOT NULL
        System.out.println(sql);
        ResultSet resulta = objConexion.consultaRegistros(sql);
        int contador = 0;
        try {
            if (resulta.next()) {
                contador = resulta.getInt("total");
            }
            resulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contador;
    }
    
    private static int funcionTotal(conexion objConexion,String nivel, String tipo){
        String sql = "SELECT COUNT("+tipo+") AS total FROM estudiantes WHERE  Nivel = '" + nivel + "' AND "+tipo+" IS NOT NULL AND "+tipo+" != ''";//AND " + tipo + " IS NOT NULL
        System.out.println(sql);
        ResultSet resulta = objConexion.consultaRegistros(sql);
        int totals=0;
        
        
            
            try {
                if (resulta.next()) {
                    totals = resulta.getInt("total");
                    totales.put(tipo+"-"+nivel, totals);
                }
                resulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
       return totals;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        estadisticas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        periodoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        estadisticas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        estadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Escuela", "P1 ", "TG1", "D1", "Sub-total", "P2", "TG2", "D2", "Sub-total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estadisticas.setFocusable(false);
        estadisticas.setRequestFocusEnabled(false);
        estadisticas.setRowSelectionAllowed(false);
        estadisticas.setShowGrid(true);
        jScrollPane1.setViewportView(estadisticas);

        jButton1.setText("Culminar Semestre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        periodoLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        periodoLabel.setText("Periodo:");

        jLabel1.setText("9vno");

        jSeparator1.setBackground(new java.awt.Color(255, 0, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 51));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel2.setText("9vno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(periodoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(periodoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int result = JOptionPane.showConfirmDialog(null, "Esta opción es irreversible y procedera con la culminación del semestre.\nEsta seguro que desea continuar?", "Confirmar",
            JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
             try {
                 String rutaCarpeta = "Historial de semestres";
                 String nombreArchivo = peri + ".s3db";
                 // Crear el archivo de destino en la carpeta "Historial semestres"
                 File archivoDestino = new File(rutaCarpeta, nombreArchivo);
                 // Guardar la base de datos en el archivo de destino
                 guardarBaseDeDatos(archivoDestino);
                 Actualizar();
                 Base base = new Base();
                 base.cerrarVentana();
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
             } catch (InstantiationException ex) {
                 Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IllegalAccessException ex) {
                 Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
             } catch (UnsupportedLookAndFeelException ex) {
                 Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
             }
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
    public static javax.swing.JTable estadisticas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel periodoLabel;
    // End of variables declaration//GEN-END:variables

    private int Integer(ResultSet resulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
