package programa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperByCollectionBeanData { //Cartas de Presentaciones ~ TG y P
    
    public static String escuela;
    public static String tipo;

    public static void main(String[] args) throws JRException, FileNotFoundException, SQLException {

        /* Output file location to create report in pdf form */
        String outputFile = "JasperReportExample.pdf";

        /* List to hold Items */
        List<Employee> listItems = new ArrayList<Employee>();
        conexion objConexion = new conexion();
        String ni = "10mo";
        // Paso 1: Obtener resultados

ResultSet resultados = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE Tipo = '" + tipo + "' AND Nivel = '" + ni + "' AND Escuela = '" + escuela + "'");


        int i = 0;
        try {
            while (resultados.next()) {
                i = i + 1;
                Employee p1 = new Employee();
                String cedul = resultados.getString("Cedula");
                String nombree = resultados.getString("Nombre");
                String nombret = "";
                String cedulat = "";
                String titulo = "";
                if(tipo.equals("Pasantia")){
                    String sql = "SELECT * FROM Pasantia WHERE id_pasantia = '" + resultados.getString("id_pasantia") + "'";

                    try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
                        nombret = resulta.getString("tutor");
//          cedulat = resulta.getString("cedula_tutor");
                        titulo = resulta.getString("titulo");
                    } catch (SQLException ex) {
                        Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }else if(tipo.equals("Trabajo de grado")){
                    String sql = "SELECT * FROM trabajo_grado WHERE id_trabajo = '" + resultados.getString("id_trabajo") + "'";

                    try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
                        nombret = resulta.getString("tutor");
//          cedulat = resulta.getString("cedula_tutor");
                        titulo = resulta.getString("titulo");
                    } catch (SQLException ex) {
                        Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
                p1.setId(i);
                p1.setNombreE(nombree);
                p1.setCedulaE(cedul);
                p1.setNombreT(nombret);
                p1.setCedulaT("cedula tutor");
                p1.settitulo(titulo);

                listItems.add(p1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
            String peri = "2023-2CR";
            ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
            if (rst.next()) {
                int rowCount = rst.getInt("count");
                if (rowCount != 0) {
                    peri = rst.getString("periodo");
                }
            }
        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("Parameter", itemsJRBean);
                parameters.put("Escuela", escuela);
                parameters.put("tipo", tipo);
                parameters.put("periodo", peri);

        

        //read jrxml file and creating jasperdesign object
        InputStream input = new FileInputStream(new File("agenda-presentaciones.jrxml"));

        JasperDesign jasperDesign = JRXmlLoader.load(input);

        /*compiling jrxml with help of JasperReport class*/
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        /* Using jasperReport object to generate PDF */
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        /*call jasper engine to display report in jasperviewer window*/
        JasperViewer.viewReport(jasperPrint);

        /* outputStream to create PDF */
        //OutputStream outputStream = new FileOutputStream(new File(outputFile));
        /* Write content to PDF file */
        //JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
        System.out.println("File Generated");

    }

}
