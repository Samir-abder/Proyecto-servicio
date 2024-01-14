package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
        
        
        
        
        
        
       // setSize(900, 768);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setTitle("Carta de aprobacion de trabajo de grado");
       // FacturaVistaPrevia(3); // Cambiar a la cantidad de páginas deseadas
    }

    public void FacturaVistaPrevia(int cantidadPaginas) {
        panel = new JPanel();
        panel.setLayout(null);
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
            jrViewer.setBounds(20, 20, 850, 700);
            panel.add(jrViewer);
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
                datosInforme.put("Nombre", resultado.getString("Nombre"));
                datosInforme.put("Cedula", resultado.getString("Nombre"));
                datosInforme.put("Apellido", resultado.getString("Nombre"));
                datosInforme.put("Codigo", resultado.getString("Nombre"));
                datosInforme.put("NombreProyecto", "las nalgas de juanga");
                datosInforme.put("fechalarga", "Viernes 11 de Marzo del 2024");
                datosInforme.put("fechacorta", "11/03/2024");
                datosInforme.put("Ingeniero", resultado.getString("Escuela"));
                datosInforme.put("Tutor", "miguel");
                datosInforme.put("Cedulatutor", "12394");
                //Falta poner los datos de todo lo q pida la carta igual q arriba
                
                
                
            }
            objConexion.cerrarConexion();
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
