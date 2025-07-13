package Menu;

import BST.ArbolBinarioBusqueda;  // Importar la clase ArbolBinarioBusqueda
import java.util.Scanner;

public class GestionRegistrar {
    private static Scanner scanner = new Scanner(System.in);  // Scanner global
    private static ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();  // Instancia del árbol

    // Función para limpiar la consola (dependiendo del sistema operativo)
    public static void limpiarConsola() {
        try {
            String sistemaOperativo = System.getProperty("os.name").toLowerCase();
            if (sistemaOperativo.contains("win")) {
                // Comando para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para sistemas basados en Unix (Mac/Linux)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la consola.");
        }
    }

    // Función que gestiona el menú de registro histórico de expedientes
    public static void gestionarRegistroHistoricoExpedientes() {
        while (true) {
            // Limpiar la consola
            limpiarConsola();

            // Menú Principal
            System.out.println("|-===============================================-|");
            System.out.println("|--- Gestion Registro Histórico de Expedientes ---|");
            System.out.println("|-===============================================-|");
            System.out.println("|(1). Registrar un nuevo expediente               |");
            System.out.println("|(2). Buscar un registro (por ID)                 |");
            System.out.println("|(3). Listar todos los registros                  |");
            System.out.println("|(4). Regresar al menú principal                  |");
            System.out.println("|-===============================================-|");
            System.out.print("|Seleccione una opción: ");

            // Validar la opción de usuario
            while (!scanner.hasNextInt()) {
                System.out.println("¡Opción inválida! Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
            }
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    limpiarConsola();
                    System.out.println("Registrar nuevo expediente");
                    // Pedir datos del nuevo expediente
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el sexo del paciente: ");
                    String sexo = scanner.nextLine();
                    System.out.print("Ingrese la fecha de nacimiento del paciente: ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Ingrese el diagnóstico del paciente: ");
                    String diagnostico = scanner.nextLine();

                    // Registrar el expediente
                    arbol.registrarExpediente(nombre, sexo, fechaNacimiento, diagnostico);
                    System.out.println("Expediente registrado correctamente.");
                    break;

                case 2:
                    limpiarConsola();
                    System.out.println("Buscando un registro por ID...");
                    break;

                case 3:
                    limpiarConsola();
                    System.out.println("Listando todos los registros...");
                    arbol.listarRegistros();
                    break;

                case 4:
                    limpiarConsola();
                    System.out.println("Regresando al menú principal...");
                    return;  // Sale de este método y regresa al menú principal

                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }

            // Pausar para ver la salida y continuar
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();  // Esperar entrada del usuario
        }
    }
}
