package programa;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class conexion {
    public static String strconexionDB; // Hacerla estática para conservar la última ruta
    Connection conn= null;
    
    public conexion(){
       if (getConexionDB() != null) {
            try {
                Class.forName("org.sqlite.JDBC");
                String path = new File(getConexionDB()).getAbsolutePath();
                conn = DriverManager.getConnection("jdbc:sqlite:" + path);
                System.out.println("Conexión establecida");
            } catch (Exception e) {
                System.out.println("Error de conexión " + e);
            }
        } else {
             strconexionDB = "database.s3db";
            // El usuario canceló la selección de archivo o no eligió uno válido.
            System.out.println("No se seleccionó una base de datos.");
             try {
                Class.forName("org.sqlite.JDBC");
                String path = new File(strconexionDB).getAbsolutePath();
                conn = DriverManager.getConnection("jdbc:sqlite:" + path);
                System.out.println("Conexión establecida");
            } catch (Exception e) {
                System.out.println("Error de conexión " + e);
            }
        }
    }
    
     public void setConexionDB(String nuevaRuta) {
        strconexionDB = nuevaRuta;
    }

    public String getConexionDB() {
        return strconexionDB;
    }
    
    public int ejecutarSentenciaSQl(String strSentenciaSQL){
            try {
                PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
                pstm.execute();
                int a = 1;
                return a;
            } catch (SQLException e) {
                System.out.println(e);
                int a = 2;  
                return a;
            }
    }
    public ResultSet consultaRegistros(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta= pstm.executeQuery();
            
            return respuesta;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }  
    }
    
    public ResultSet consultaRegistrosParametrizados(String strSentenciaSQL, List<Object> parametros) {
    try {
        PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);

        // Configurar los parámetros en la consulta
        int index = 1;
        for (Object parametro : parametros) {
            pstm.setObject(index++, parametro);
        }

        ResultSet respuesta = pstm.executeQuery();
        return respuesta;
    } catch (SQLException e) {
        System.out.println(e);
        return null;
    }
}


    public boolean ejecutarSentenciaSQl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void cerrarConexion() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión a la base de datos cerrada.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
