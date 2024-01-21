
package programa;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Estadisticas extends javax.swing.JPanel {
    public static DefaultTableModel modelos;
    public Estadisticas() {
        initComponents();
        modelos = (DefaultTableModel) estads.getModel();
        conexion objConexion = new conexion();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable estads;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
