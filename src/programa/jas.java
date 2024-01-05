
package programa;

import java.awt.Color;
import java.awt.Panel;
import java.util.HashMap;
import java.util.Map;
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
 * @author lujop
 */
public class jas extends JFrame {
    private JRViewer jrViewer;
    private JPanel panel;
    public jas(){  
    setSize(900, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema de inventario y facturacion");
        FacturaVistaPrevia();
    }

    public void FacturaVistaPrevia(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(Color.decode("#FFFFFF"));
        

        // Simulamos cargar datos de la factura para el informe
        Map<String, Object> datosFactura = cargarDatosFactura();

        // Cargar el informe compilado
        JasperReport jasperReport = cargarInformeJasper();

        try {
            // Llenar el informe con los datos de la factura
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, datosFactura, new JREmptyDataSource());

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
        // Aquí simulamos cargar datos de la factura en un Map
        // Puedes reemplazar esto con los datos reales de la factura

        Map<String, Object> datosFactura = new HashMap<>();
        //DOLARES
        datosFactura.put("Parameter1", "luisito gay");

        // Agregar más datos según el diseño de tu informe
        return datosFactura;
    }

    private JasperReport cargarInformeJasper() {
        try {

            // Ruta del archivo JRXML generado por JasperSoft Studio
            String rutaInformeJRXML = "Blank_A4.jrxml";
            panel.repaint();
            panel.revalidate();

            // Compilar el archivo JRXML para obtener el JasperReport
            return JasperCompileManager.compileReport(rutaInformeJRXML);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
 /*   public static void main(String[] args) {
        jas ventana = new jas();
        ventana.setVisible(true);
    }*/
}