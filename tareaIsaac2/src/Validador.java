import java.util.InputMismatchException;

public class Validador {
    public static int validarOpcion(int opc) throws IllegalArgumentException {
        try {
            if (opc < 1 || opc > 6) {
                throw new IllegalArgumentException("Opción inválida. Debe ingresar un número entre 1 y 6.");
            }
            return opc;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }
    }
    public static int validarId(int ID) throws IllegalArgumentException{
        try {
            if (ID <= 0) {
                throw new IllegalArgumentException("El ID debe ser un número positivo.");
            }
            for (Paciente paciente : CRUD.pacientes) {
                if (paciente.getID() == ID) {
                    throw new IllegalArgumentException("El ID ya existe. Por favor, use un ID único.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return ID;
    }
    public static String validarString(String string) throws IllegalArgumentException{

        if (!string.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑäëïöüÄËÏÖÜ]+")){
            throw new IllegalArgumentException("Opcion invalida. Se espera letras Aa-Zz");
        }
        return string;
    }
    public static int validarEdad(int edad) throws IllegalArgumentException{
        try {
            if (edad < 1 || edad > 200) {
                throw new IllegalArgumentException("Opción inválida. Debe ingresar un número");
            }
            return edad;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }
    }
    public static int validarEntrada(int ID) throws IllegalArgumentException{
        try {
            if (ID <= 0) {
                throw new IllegalArgumentException("El ID debe ser un número positivo.");
            }
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Error: Debe ingresar un número entero.");
        }
        return ID;
    }

}