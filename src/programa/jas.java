package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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

    public jas() {
           setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        panel.setSize(new Dimension(700,769));
        
        this.getContentPane().add(panel);
        panel.setBackground(Color.decode("#FFFFFF"));

        // Crear un JasperPrint para almacenar todas las páginas
        JasperPrint jasperPrintCombined = new JasperPrint();
//        JasperPrint jasperPrintCombined = new JasperPrint();
        jasperPrintCombined.setPageWidth(595); // Ancho de página en puntos (A4)
        jasperPrintCombined.setPageHeight(842); // Altura de página en puntos (A4)

        // Cargar el informe compilado
        JasperReport jasperReport = cargarInformeJasper();

        try {
            try {
                conexion objConexion = new conexion();
                ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes");
                while (resultado.next()) {
                   
// Simulamos cargar datos para el informe
                    Map<String, Object> datosInforme = cargarDatosInforme(resultado.getString("Cedula"));

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

    private Map<String, Object> cargarDatosInforme(String cedula) {
        Map<String, Object> datosInforme = new HashMap<>();

        try {
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Cedula = '" + cedula + "'");
            while (resultado.next()) {
                String nombret = "";
                String cedulat = "";
                String titulo = "";
                String tipo = resultado.getString("Tipo");

                datosInforme.put("Nombre", resultado.getString("Nombre"));
                datosInforme.put("Cedula", resultado.getString("Cedula"));
                datosInforme.put("Apellido", resultado.getString("Apellido"));
                datosInforme.put("Codigo", resultado.getString("Codigo"));
                if (tipo.equals("Pasantia")) {
                    String sql = "SELECT * FROM Pasantia WHERE id_pasantia = '" + resultado.getString("id_pasantia") + "'";

                    try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
                        nombret = resulta.getString("tutor_academico");
//          cedulat = resulta.getString("cedula_tutor");
                        titulo = resulta.getString("razon_social");
                    } catch (SQLException ex) {
                        //Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (tipo.equals("Trabajo de grado")) {
                    String sql = "SELECT * FROM trabajo_grado WHERE id_trabajo = '" + resultado.getString("id_trabajo") + "'";

                    try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
                        nombret = resulta.getString("tutor");
//          cedulat = resulta.getString("cedula_tutor");
                        titulo = resulta.getString("titulo");
                    } catch (SQLException ex) {
                        //Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                
                Date fechaActual = new Date();
                Locale localeEspanol = new Locale("es", "ES");

        // Fecha cort
        SimpleDateFormat formatoCorto = new SimpleDateFormat("dd/MM/yyyy");
        String fechaCorta = formatoCorto.format(fechaActual);
        System.out.println("Fecha Corta: " + fechaCorta);

        // Fecha larga
        Date fechaActual2 = new Date();
        SimpleDateFormat formatoLargo = new SimpleDateFormat("EEEE, dd 'de' MMMM 'del' yyyy", localeEspanol);
        String fechaLarga = formatoLargo.format(fechaActual2);
        System.out.println("Fecha Larga: " + fechaLarga);
                
                datosInforme.put("NombreProyecto", titulo);
                datosInforme.put("fechalarga", fechaLarga);

                datosInforme.put("fechacorta", fechaCorta);
                datosInforme.put("Ingeniero", resultado.getString("Escuela"));
                datosInforme.put("Tutor", "Nombre de Tutor");
                datosInforme.put("Cedulatutor", "123945678");
                //Falta poner los datos de todo lo q pida la carta igual q arriba
            }
        
        }
        
//        try {
//            conexion objConexion = new conexion();
//            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Cedula = '" + cedula + "'");
//            while (resultado.next()) {
//                datosInforme.put("Nombre", resultado.getString("Nombre"));
//                datosInforme.put("Cedula", resultado.getString("Cedula"));
//                datosInforme.put("Apellido", resultado.getString("Apellido"));
//                datosInforme.put("Codigo", resultado.getString("Codigo"));
//                datosInforme.put("NombreProyecto", "AQUI VA EL TITULO DEL PROYECTO DE GRADO, PASANTIA O DISEÑO DEL ESTUDIANTE");
//                datosInforme.put("fechalarga", "Viernes 11 de Marzo del 2024");
//                datosInforme.put("fechacorta", "11/03/2024");
//                datosInforme.put("Ingeniero", resultado.getString("Escuela"));
//                datosInforme.put("Tutor", "miguel");
//                datosInforme.put("Cedulatutor", "12394");
//                //Falta poner los datos de todo lo q pida la carta igual q arriba
//                
//                
//
//            }
//            objConexion.cerrarConexion();
//        } 
        catch (Exception e) {
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
