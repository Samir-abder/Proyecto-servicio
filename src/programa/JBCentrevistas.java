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
import javax.swing.JFrame;

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
import static programa.JasperByCollectionBeanData.escuela;
import static programa.JasperByCollectionBeanData.tipo;

public class JBCentrevistas extends JFrame { //Cartas de Entrevistas ~ 

    public static String escuela;
    public static String tipo;

    public JBCentrevistas() throws SQLException, FileNotFoundException, JRException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /* Output file location to create report in pdf form */
        String outputFile = "JasperReportExample.pdf";

        /* List to hold Items */
        List<Employee> listItems = new ArrayList<Employee>();
        conexion objConexion = new conexion();
        String ni = "9vno";
        // Paso 1: Obtener resultados
        if (tipo.equals("Trabajo de grado")) {
            String sqlEstudiantes = "SELECT DISTINCT id_trabajo FROM estudiantes WHERE Escuela = '" + escuela + "' AND id_trabajo IS NOT NULL AND id_trabajo <> '' AND Nivel = '" + ni + "'";

            try (ResultSet resultados = objConexion.consultaRegistros(sqlEstudiantes)) {
                int i = 0;
                while (resultados.next()) {
                    i++;
                    String idTrabajo = resultados.getString("id_trabajo");
                    String nombree = "";
                    String cedul = "";
                    String nombrej = "";
                    String fecha = "";
                    String aula = "";
                    String cedulaj = "";

                    String sqlTrabajo = "SELECT * FROM trabajo_grado WHERE id_trabajo = '" + idTrabajo + "'";
                    try (ResultSet rst = objConexion.consultaRegistros(sqlTrabajo)) {
                        while (rst.next()) {
                            ResultSet rstE1 = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE cedula = '" + rst.getString("cedula_estudiante") + "'");
                            ResultSet rstE2 = objConexion.consultaRegistros("SELECT * FROM estudiantes WHERE cedula = '" + rst.getString("cedula_estudiante2") + "'");
                            nombrej = rstE1.getString("nombrejurado1") + "\n" + rstE1.getString("nombrejurado2");
                                                        cedulaj = rstE1.getString("ci_jurado1") + "\n" + rstE1.getString("ci_jurado2");

                            fecha = rstE1.getString("fecha_hora_entrevista");
                            aula = rstE1.getString("lugar_entrevista");
                            if (!rstE2.next()) {
                                nombree = rstE1.getString("Nombre") + " "+rstE1.getString("Apellido");
                                cedul = rst.getString("cedula_estudiante");
                            } else {
                                nombree = rstE1.getString("Nombre") +" "+rstE1.getString("Apellido")+ "\n" + rstE2.getString("Nombre")+" "+rstE2.getString("Apellido");
                                cedul = rst.getString("cedula_estudiante") + "\n" + rst.getString("cedula_estudiante2");
                            }

                            Employee p1 = new Employee();
                            p1.setId(i);
                            p1.setNombreE(nombree);
                            p1.setCedulaE(cedul);
                            p1.setNombreT(rst.getString("tutor"));
                            p1.setCedulaT(rst.getString("cedula_tutor"));
                            p1.settitulo(rst.getString("titulo"));
                            p1.setNombreJ(nombrej);
                            p1.setCedulaJ(cedulaj);
                            p1.setFecha(fecha);
                            p1.setAula(aula);
                            listItems.add(p1);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo adecuado de excepciones, puedes cambiar esto según tus necesidades
            }

            // Ahora, después de obtener todos los datos, puedes crear el informe y mostrarlo
            // (Coloca esta parte fuera del bucle)
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
            String peri = "2023-2CR";
            ResultSet rst3 = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
            if (rst3.next()) {
                int rowCount = rst3.getInt("count");
                if (rowCount != 0) {
                    peri = rst3.getString("periodo");
                }
            }

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("Parameter", itemsJRBean);
            parameters.put("Escuela", escuela);
            parameters.put("tipo", tipo);
            parameters.put("periodo", peri);

            try {
                InputStream input = new FileInputStream(new File("agenda-entrevistas.jrxml"));
                JasperDesign jasperDesign = JRXmlLoader.load(input);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
                jasperViewer.setVisible(true);

                // Aquí también puedes exportar a PDF si es necesario
            } catch (JRException | FileNotFoundException ex) {
                ex.printStackTrace(); // Manejo adecuado de excepciones, puedes cambiar esto según tus necesidades
            }
        } else {
            String consulta = "";
            if (tipo.equals("Pasantia")) {
                consulta = "SELECT * FROM estudiantes WHERE Tipo = '" + tipo + "' AND Nivel = '" + ni + "' AND Escuela = '" + escuela + "' AND id_pasantia IS NOT NULL AND id_pasantia <> ''";
            } else if (tipo.equals("Diseño")) {
                consulta = "SELECT * FROM estudiantes WHERE Tipo = '" + tipo + "' AND Nivel = '" + ni + "' AND Escuela = '" + escuela + "' AND id_diseno IS NOT NULL AND id_diseno <> ''";

            }
            ResultSet resultados = objConexion.consultaRegistros(consulta);
            int i = 0;
            try {
                while (resultados.next()) {
                    i = i + 1;
                    Employee p1 = new Employee();
                    String cedul = resultados.getString("Cedula");
                    String nombree = resultados.getString("Nombre") +" "+resultados.getString("Apellido");
                    String nombret = "";
                    String cedulat = "";
                    String titulo = "";
                    String nombrej = resultados.getString("nombrejurado1") + "\n" + resultados.getString("nombrejurado2");
                     String cedulaj = resultados.getString("ci_jurado1") + "\n" + resultados.getString("ci_jurado2");
                    String fecha = resultados.getString("fecha_hora_entrevista");
                    String aula = resultados.getString("lugar_entrevista");
                    if (tipo.equals("Pasantia")) {
                        String sql = "SELECT * FROM Pasantia WHERE id_pasantia = '" + resultados.getString("id_pasantia") + "'";

                        try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
                            nombret = resulta.getString("tutor_academico");
                            cedulat = resulta.getString("cedula_tutor");
                            titulo = resulta.getString("razon_social");
                        } catch (SQLException ex) {
                            Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
                        }

//                    } else if (tipo.equals("Trabajo de grado")) {
//                        String sql = "SELECT * FROM trabajo_grado WHERE id_trabajo = '" + resultados.getString("id_trabajo") + "'";
//
//                        try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
//                            nombret = resulta.getString("tutor");
////          cedulat = resulta.getString("cedula_tutor");
//                            titulo = resulta.getString("titulo");
//                        } catch (SQLException ex) {
//                            Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    } else if (tipo.equals("Diseño")) {
                        String sql = "SELECT * FROM Diseno WHERE id_diseno = '" + resultados.getString("id_diseno") + "'";

                        try (ResultSet resulta = objConexion.consultaRegistros(sql)) {
                            nombret = resulta.getString("tutor_academico");
                            cedulat = resulta.getString("cedula_tutor");
                            titulo = resulta.getString("razon_social");
                        } catch (SQLException ex) {
                            Logger.getLogger(JasperByCollectionBeanData.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    p1.setId(i);
                    p1.setNombreE(nombree);
                    p1.setCedulaE(cedul);
                    p1.setNombreT(nombret);
                    p1.setCedulaT(cedulat);
                    p1.settitulo(titulo);
                    p1.setNombreJ(nombrej);
                    p1.setCedulaJ(cedulaj);
                    p1.setFecha(fecha);
                    p1.setAula(aula);
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
            InputStream input = new FileInputStream(new File("agenda-entrevistas.jrxml"));

            JasperDesign jasperDesign = JRXmlLoader.load(input);

            /*compiling jrxml with help of JasperReport class*/
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            /* Using jasperReport object to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            /*call jasper engine to display report in jasperviewer window*/
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false); // El segundo parámetro indica si debe cerrar la aplicación al cerrar la ventana
            jasperViewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE); // Configura el comportamiento al cerrar la ventana

            jasperViewer.setVisible(true);

            /* outputStream to create PDF */
            //OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            //JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            System.out.println("File Generated");

        }
    }
}
