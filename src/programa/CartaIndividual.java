package programa;

import java.awt.Color;
import java.awt.Panel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 *
 */
public class CartaIndividual extends JFrame {

    private JRViewer jrViewer;
    private JPanel panel;
    public  static String cedulaE;

    public CartaIndividual() {
        setSize(900, 768);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Sistema de inventario y facturacion");
        Informe();
    }

    public void Informe() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.decode("#FFFFFF"));

        // Simulamos cargar datos de la factura para el informe
        Map<String, Object> datosInforme = cargarDatosFactura();

        // Cargar el informe compilado
        JasperReport jasperReport = cargarInformeJasper();

        try {
            // Llenar el informe con los datos de la factura
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, datosInforme, new JREmptyDataSource());

            // Componente de JasperReports para visualizar el informe
            jrViewer = new JRViewer(jasperPrint);
            jrViewer.setBounds(20, 20, 850, 700);
            //add(jrViewer);
            panel.add(jrViewer);
            panel.repaint();
            panel.revalidate();

            // Botón para guardar como PDF (similar al ejemplo anterior)
            // Mostrar la vista previa
//            pack();
//            setLocationRelativeTo(null);
//            setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> cargarDatosFactura() {
        Map<String, Object> datosInforme = new HashMap<>();
        try {
            // Aquí simulamos cargar datos de la factura en un Map
            // Puedes reemplazar esto con los datos reales de la factura
            conexion objConexion = new conexion();
            ResultSet resultado = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Cedula = '" + cedulaE + "'");
            System.out.println("sql "+ "SELECT * FROM estudiantes WHERE Cedula = '" + cedulaE + "'");
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
        } catch (SQLException ex) {
            Logger.getLogger(CartaIndividual.class.getName()).log(Level.SEVERE, null, ex);
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

//   public static void main(String[] args) {
//        CartaIndividual ventana = new CartaIndividual();
//        ventana.setVisible(true);
//    }
}
