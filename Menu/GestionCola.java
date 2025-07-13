package Menu;

import java.util.Scanner;

public class GestionCola {
    private static Scanner scanner = new Scanner(System.in);  // Scanner global

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

    // Función que gestiona la cola de atención activa
    public static void gestionarColaAtencionActiva() {
        while (true) {
            // Limpiar la consola
            limpiarConsola();

            // Menú Principal
            System.out.println("|-===============================================-|");
            System.out.println("|----     Gestion Cola de Atención Activa     ----|");
            System.out.println("|-===============================================-|");
            System.out.println("|(1). Registrar/Actualizar un paciente en espera  |");
            System.out.println("|(2). Buscar un paciente en espera (por ID)       |");
            System.out.println("|(3). Eliminar un paciente de la cola (por ID)    |");
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
                    System.out.println("Gestionando Registro/Actualización de paciente en espera...");
                    break;
                case 2:
                    limpiarConsola();
                    System.out.println("Buscando paciente en espera por ID...");
                    break;
                case 3:
                    limpiarConsola();
                    System.out.println("Eliminando paciente de la cola por ID...");
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
