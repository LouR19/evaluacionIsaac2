import java.io.Serializable;

public class Paciente implements Serializable {
    private static final long serialVersionUIO = 1L;
    private int ID;
    private String nombre;
    private int edad;
    private String diagnostico;

    public Paciente(int ID, String nombre, int edad, String diagnostico) {
        this.ID = ID;
        this.nombre = nombre;
        this.edad = edad;
        this.diagnostico = diagnostico;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    @Override
    public String toString(){
        return "\nPacientes:\nID: "+ID+"\nNombre: "+nombre+"\nEdad: "+edad+"\nDiagnostico: "+diagnostico+"\n";
    }
}
