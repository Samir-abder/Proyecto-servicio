package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;
import static programa.Alumnos.modeloa;

public class jas extends JFrame {

    private JRViewer jrViewer;
    private JPanel panel;
    private String decano;
                    conexion objConexion = new conexion();


    public jas() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Carta de aprobacion de trabajo de grado");
        FacturaVistaPrevia(3); // Cambiar a la cantidad de páginas deseadas
        pack();
        setSize(900, 768);
        setLocationRelativeTo(null);
        setVisible(true);
            
    }

    public void FacturaVistaPrevia(int cantidadPaginas) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(new Dimension(700, 769));

        this.getContentPane().add(panel);
        panel.setBackground(Color.decode("#FFFFFF"));

        // Crear un JasperPrint para almacenar todas las páginas
        JasperPrint jasperPrintCombined = new JasperPrint();
//        JasperPrint jasperPrintCombined = new JasperPrint();
        jasperPrintCombined.setPageWidth(595); // Ancho de página en puntos (A4)
        jasperPrintCombined.setPageHeight(842); // Altura de página en puntos (A4)

        // Cargar el informe compilado
        JasperReport jasperReport = cargarInformeJasper();
try (
        ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, nombre FROM configuracion")) {
                if (rst.next()) {
                    int rowCount = rst.getInt("count");
                    if (rowCount != 0) {
                        decano = rst.getString("nombre");
                        rst.close();
                    }
                }
            } catch (SQLException ex) {
            Logger.getLogger(jas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM Trabajo_grado");
                //
                //
                String numR;
                numR = JOptionPane.showInputDialog(null, "Ingrese el numero de reunion:");
                //
                //
                while (resultado.next()) {

// Simulamos cargar datos para el informe
                    Map<String, Object> datosInforme = cargarDatosInforme(numR,resultado.getString("id_trabajo"), "Trabajo de grado",
                            resultado.getString("tutor"), resultado.getString("cedula_tutor"), resultado.getString("titulo"),
                            resultado.getString("codigo"));

                    // Llenar el informe con los datos
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, datosInforme, new JREmptyDataSource());

                    //Agregar cada página al JasperPrint combinado
                    for (int pageIndex = 0; pageIndex < jasperPrint.getPages().size(); pageIndex++) {
                        jasperPrintCombined.addPage(jasperPrint.getPages().get(pageIndex));
                    }  
                }
                
                resultado = objConexion.consultaRegistros("SELECT * FROM Pasantia");
                while (resultado.next()) {

                    // Simulamos cargar datos para el informe
                    Map<String, Object> datosInforme = cargarDatosInforme(numR,resultado.getString("id_pasantia"), "Pasantia",
                            resultado.getString("tutor_academico"), resultado.getString("cedula_tutor"), resultado.getString("razon_social"),
                            resultado.getString("codigo"));

                    // Llenar el informe con los datos
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, datosInforme, new JREmptyDataSource());

//                 Agregar cada página al JasperPrint combinado
                    for (int pageIndex = 0; pageIndex < jasperPrint.getPages().size(); pageIndex++) {
                        jasperPrintCombined.addPage(jasperPrint.getPages().get(pageIndex));
                    }
//                
                }
                resultado = objConexion.consultaRegistros("SELECT * FROM Diseno");
                while (resultado.next()) {

// Simulamos cargar datos para el informe
                    Map<String, Object> datosInforme = cargarDatosInforme(numR,resultado.getString("id_diseno"), "Diseño",
                            resultado.getString("tutor_academico"), resultado.getString("cedula_tutor"), resultado.getString("razon_social"),
                            resultado.getString("codigo"));

                    // Llenar el informe con los datos
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, datosInforme, new JREmptyDataSource());

//                 Agregar cada página al JasperPrint combinado
                    for (int pageIndex = 0; pageIndex < jasperPrint.getPages().size(); pageIndex++) {
                        jasperPrintCombined.addPage(jasperPrint.getPages().get(pageIndex));
                    }
//                
                }

                objConexion.cerrarConexion();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e);
            }

            // Crear un JRViewer para el JasperPrint combinado
            jrViewer = new JRViewer(jasperPrintCombined);
            panel.add(jrViewer, BorderLayout.CENTER);

        } catch (JRException e) {
            e.printStackTrace();
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Map<String, Object> cargarDatosInforme(String numR,String id, String tipo, String nombret, String cedulat, String titulo, String codigoTrabajo) {
        Map<String, Object> datosInforme = new HashMap<>();

        try {
            /*String numR = "";
            numR = JOptionPane.showInputDialog(null, "Ingrese el numero de reunion:");*/
            
            // Consultar el valor actual en la tabla Reunion
            /*
            try (ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, valor FROM Reunion")) {
                if (rst.next()) {
                    int rowCount = rst.getInt("count");
                    if (rowCount != 0) {
                        numR = rst.getString("valor");
                        rst.close();
                    }
                }
            }
            */

            ResultSet resultado = null;
            if (tipo.equals("Trabajo de grado")) {
                resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE id_trabajo = '" + id + "'");
            } else if (tipo.equals("Pasantia")) {
                resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE id_pasantia = '" + id + "'");
            } else if (tipo.equals("Diseño")) {
                resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE id_diseno = '" + id + "'");
            }

            ArrayList<String> datos = new ArrayList();
            String escuela = "";
            while (resultado.next()) {
                datos.add(resultado.getString("Nombre"));
                datos.add(resultado.getString("Apellido"));
                datos.add(resultado.getString("Cedula"));
                escuela = resultado.getString("Escuela");
            }
            resultado.close();
            Date fechaActual = new Date();
            Locale localeEspanol = new Locale("es", "ES");

            // Fecha cort
            SimpleDateFormat formatoCorto = new SimpleDateFormat("dd/MM/yyyy");
            String fechaCorta = formatoCorto.format(fechaActual);
            System.out.println("Fecha Corta: " + fechaCorta);

            SimpleDateFormat formatoAno = new SimpleDateFormat("yyyy");
            String fechaAno = formatoAno.format(fechaActual);
//            System.out.println("Fecha Corta: " + fechaAno);

            // Fecha larga
            Date fechaActual2 = new Date();
            SimpleDateFormat formatoLargo = new SimpleDateFormat("EEEE, dd 'de' MMMM 'del' yyyy", localeEspanol);
            String fechaLarga = formatoLargo.format(fechaActual2);
            System.out.println("Fecha Larga: " + fechaLarga);

            datosInforme.put("Nombre", datos.get(0));
            datosInforme.put("Apellido", datos.get(1));
            datosInforme.put("Cedula", "C.I."+datos.get(2));
            if (datos.size() == 6) {
                datosInforme.put("Nombre2", datos.get(3));
                datosInforme.put("Apellido2", datos.get(4));
                datosInforme.put("Cedula2", "C.I."+datos.get(5));
            } else if (datos.size() == 3) {
                datosInforme.put("Nombre2", "");
                datosInforme.put("Apellido2", "");
                datosInforme.put("Cedula2", "");
            }
            datosInforme.put("Codigo", codigoTrabajo);
            datosInforme.put("NombreProyecto", titulo);
            datosInforme.put("fechalarga", fechaLarga);
            datosInforme.put("fechacorta", fechaCorta);
            if(escuela.equals("Arquitectura")){
                            datosInforme.put("Ingeniero","Arquitecto)");

            }if(escuela.equals("Computación")){
                            datosInforme.put("Ingeniero","Ingeniero en computación");

            }if(escuela.equals("Mecánica")){
                            datosInforme.put("Ingeniero","Ingeniero mecánico");

            }if(escuela.equals("Telecomunicaciones")){
                            datosInforme.put("Ingeniero","Ingeniero en telecomunicaciones");

            }if(escuela.equals("Civil")){
                            datosInforme.put("Ingeniero","Ingeniero civil");

            }if(escuela.equals("Industrial")){
                            datosInforme.put("Ingeniero","Ingeniero industrial");

            }if(escuela.equals("Electrónica")){
                            datosInforme.put("Ingeniero","Ingeniero electronico");

            }
            datosInforme.put("Tutor", nombret);
            datosInforme.put("Cedulatutor", cedulat);
            datosInforme.put("decano", decano);
            datosInforme.put("Reunion", numR + "-" + fechaAno);
            int currentCount = Integer.parseInt(numR) + 1;
        String newCount = currentCount+"";

        // Actualizar la tabla Reunion con el nuevo valor
        String updateSql = String.format("UPDATE Reunion SET valor = '%s'", newCount);
        System.out.println("sql " + updateSql);
        objConexion.ejecutarSentenciaSQl(updateSql);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }

        return datosInforme;
    }

    private JasperReport cargarInformeJasper() {
        try {
            // Ruta del archivo JRXML generado por JasperSoft Studio
            String rutaInformeJRXML = "Proyecto.jrxml";
            panel.repaint();
            panel.revalidate();

            // Compilar el archivo JRXML para obtener el JasperReport
            return JasperCompileManager.compileReport(rutaInformeJRXML);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*public static void main(String[] args) {
        jas ventana = new jas();
        ventana.setVisible(true);
    }*/
}
