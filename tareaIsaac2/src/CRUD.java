import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUD {
   public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static void serializar() {
        try (FileOutputStream archivo = new FileOutputStream("Pacientes.bin")) {
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(pacientes);
            System.out.println("Datos Serializado...");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    public static void deserializar() {
        try (FileInputStream entrada = new FileInputStream("Pacientes.bin");
             ObjectInputStream entradaObjeto = new ObjectInputStream(entrada)) {
            pacientes = (ArrayList<Paciente>) entradaObjeto.readObject();
            System.out.println("Datos Deserializados...");
        } catch (FileNotFoundException ex) {
            System.out.println("=>Archivo no encontrado, se creará uno nuevo cuando se guarden datos.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al cargar los datos: " + ex.getMessage());
        }
    }
    public void agregar(Paciente paciente){
        pacientes.add(paciente);
        System.out.println("Agregado exitosamente...");
        serializar();
    }
    public void mostrar(){
        if (pacientes.isEmpty()){
            System.out.println("Vacio...");
        }
        pacientes.forEach(System.out::println);
    }
    public void actualizar(int ID){
        Scanner scanner = new Scanner(System.in);
        String nnombre = null;
        int nedad = 0;
        String ndiagnostico = null;
        for (Paciente paciente:pacientes){
            if (paciente.getID() == ID){
                while (nnombre==null){
                    System.out.println("Ingrese nombre actualizado.");
                    try {
                        nnombre=Validador.validarString(scanner.next());
                        scanner.nextLine();
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }
                }
                while (nedad==0){
                    System.out.println("Ingrese edad actualizada.");
                    try {
                        nedad = Validador.validarEdad(scanner.nextInt());
                        scanner.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("La Edad debe ser un numero entero");
                        scanner.nextLine();
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }
                }
                while (ndiagnostico==null){
                    System.out.println("Ingrese Diagnostico actualizado.");
                    try {
                        ndiagnostico=Validador.validarString(scanner.next());
                        scanner.nextLine();
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }
                }
                paciente.setNombre(nnombre);
                paciente.setEdad(nedad);
                paciente.setDiagnostico(ndiagnostico);
                System.out.println("Paciente Actualizado...");
                serializar();
                return;
            }
        }
        System.out.println("Paciente no encontrado...");
    }
    public void eliminar(int ID){
        Scanner scanner = new Scanner(System.in);
        if (pacientes.isEmpty()){
            System.out.println("Vacio...");
        }else {
            for (Paciente paciente : pacientes) {
                if (paciente.getID() == ID) {
                    System.out.println("Esta seguro que lo desea eliminar? 1-Si. / 2-No.");
                    int sino = Integer.parseInt(scanner.next());
                    if (sino == 1) {
                        pacientes.remove(paciente);
                        System.out.println("Paciente con ID " + ID + " eliminado.");
                        serializar();
                    } else {
                        System.out.println("Eliminacion Cancelada...");
                    }
                    break;
                }
            }
        }
    }
    public void generarReporte() {
        Scanner scanner = new Scanner(System.in);
        int edadMinima = 0;
        while (edadMinima==0){
            System.out.print("Ingrese la edad mínima para el reporte: ");
            try {
                edadMinima = Validador.validarEdad(scanner.nextInt());
            }catch (InputMismatchException e){
                System.out.println("La Edad debe ser un numero entero");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        try (PrintWriter wreport = new PrintWriter("reporte_pacientes.txt")) {
            wreport.println("Reporte de Pacientes mayores de " + edadMinima + " años:");
            wreport.println("-----------------------------------------");

            for (Paciente paciente : pacientes) {
                if (paciente.getEdad() >= edadMinima) {
                    wreport.println("ID: " + paciente.getID()+"\nNombre: " + paciente.getNombre()+"\nEdad: " + paciente.getEdad()+"\nDiagnóstico: " + paciente.getDiagnostico()+"-----------------------------------------");
                }
            }
            System.out.println("Reporte generado en reporte_pacientes.txt.");
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }

//    public void generarReporte() {
}