import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static {
        CRUD.deserializar();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CRUD crud = new CRUD();
        int opc;
        do {
            System.out.println("Menu principal:\n 1-Agregar.\n 2-Mostar.\n 3-Actualizar.\n 4-Eliminar.\n 5-Generar Reporte.\n 6-Salir");
            try {
                opc = Validador.validarOpcion(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                opc = 0;
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                opc = 0;
            }

            switch (opc){
                case 1:
                    int ID = 0;
                    while (ID==0){
                        System.out.println("Ingrese ID del paciente:");
                        try {
                            ID = Validador.validarId(scanner.nextInt());
                        } catch (InputMismatchException e) {
                            System.out.println("Error: El ID debe ser un número entero.");
                            scanner.nextLine();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    String nombre = null;
                    while(nombre==null){
                        System.out.println("Ingrese nombre del paciente:");
                        try {
                            nombre=Validador.validarString(scanner.next());
                            scanner.nextLine();
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    int edad = 0;
                    while (edad == 0){
                        System.out.println("Ingrese edad del paciente:");
                        try {
                            edad = Validador.validarEdad(scanner.nextInt());
                            scanner.nextLine();
                        }catch (InputMismatchException e){
                            System.out.println("La Edad debe ser un numero entero");
                            scanner.nextLine();
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    String diagnostico = null;
                    while (diagnostico == null){
                        System.out.println("Ingrese diagnostico del paciente:");
                        try {
                            diagnostico=Validador.validarString(scanner.next());
                            scanner.nextLine();
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    crud.agregar(new Paciente(ID, nombre, edad, diagnostico));
                case 2:
                    crud.mostrar();
                    break;
                case 3:
                    int acID = 0;
                    while (acID == 0){
                        System.out.println("Ingrese ID del paciente a actualizar:");
                        try {
                            acID=Validador.validarEntrada(scanner.nextInt());
                            scanner.nextLine();
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e) {
                            System.out.println("La Edad debe ser un numero entero");
                            scanner.nextLine();
                        }
                    }
                    crud.actualizar(acID);
                case 4:
                    int deID = 0;
                    while (deID==0){
                        System.out.println("Ingrese ID del paciente a eliminar");
                        try {
                            deID=Validador.validarEntrada(scanner.nextInt());
                            scanner.nextLine();
                        }catch (IllegalArgumentException e){
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }catch (InputMismatchException e) {
                            System.out.println("La Edad debe ser un numero entero");
                            scanner.nextLine();
                        }
                    }
                    crud.eliminar(deID);
                case 5:
                    crud.generarReporte();
                    break;
                case 6:
                    System.out.println("Estas seguro que deseas salir? 1-Si / 2-No");
                    int sinoo = Integer.parseInt(scanner.next());
                    if (sinoo==1){
                        System.out.println("Cerrando...");
                        return;
                    }
                default:
                    break;
            }
        }while (opc!=6);

    }
}