package programa;



public class Employee
{
    private String escuela;
    private String periodo;
    private int id;
    private String titulo;
    private String nombreE;
    private String cedulaE;
    private String nombreT;
    private String cedulaT;
    private String nombreJ;
    private String fecha;
    private String aula;

    //contador de la tabla
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    //titulo del proyecto del estudiante
    public String gettitulo() {
        return titulo;
    }
    public void settitulo(String titulo) {
        this.titulo = titulo;
    }
    
    // Datos estudiante
public String getNombreE() {
    return nombreE;
}

public void setNombreE(String nombre) {
    this.nombreE = nombre;
}

public String getCedulaE() {
    return cedulaE;
}

public void setCedulaE(String cedula) {
    this.cedulaE = cedula;
}

    
    //Datos tutore
    // Datos tutor
public String getNombreT() {
    return nombreT;
}

public void setNombreT(String nombre) {
    this.nombreT = nombre;
}

public String getCedulaT() {
    return cedulaT;
}

public void setCedulaT(String cedula) {
    this.cedulaT = cedula;
}

public String getNombreJ() {
    return nombreJ;
}

public void setNombreJ(String nombre) {
    this.nombreJ = (!nombre.equals("null\nnull")) ? nombre : "Sin asignar";
}

public String getFecha() {
    return fecha;
}

public void setFecha(String fec) {
    this.fecha = (fec != null) ? fec : "Sin asignar";
}
public String getAula() {
    return aula;
}

public void setAula(String aul) {
    this.aula = (aul != null) ? aul : "Sin asignar";
}
}