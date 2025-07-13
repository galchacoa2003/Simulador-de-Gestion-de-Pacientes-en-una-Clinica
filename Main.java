import java.util.InputMismatchException;
import java.util.Scanner;
import Menu.GestionRegistrar;  // Importa la clase GestionRegistrar del paquete Menu
import Menu.GestionCola; // Importa la clase GestionCola del paquete Menu


public class Main {
    static Scanner scanner = new Scanner(System.in);

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
    
    public static void main(String[] args) {
        while (true) {
            // Limpiar la consola
            limpiarConsola();
            
            // Menú Principal
            System.out.println("|-==============================================-|");
            System.out.println("|--- Menú Principal del Sistema de la Clínica ---|");
            System.out.println("|-==============================================-|");
            System.out.println("|(1). Gestionar Registro Histórico de Expedientes|");
            System.out.println("|(2). Gestionar Cola de Atención Activa          |");
            System.out.println("|(3). Salir del Sistema                          |");
            System.out.println("|-==============================================-|");
                        
            int opcion = 0;
            boolean opcionValida = false;
            
            // Asegurarse de que la opción sea válida (1, 2 o 3)
            while (!opcionValida) {
                try {
                    System.out.print("|Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    
                    if (opcion >= 1 && opcion <= 3) {
                        opcionValida = true;  // Opción válida
                    } else {
                        System.out.println("|(!) Opción no válida. Por favor, ingrese un número entre 1 y 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("|(!) Entrada inválida. Por favor ingrese un número entre 1 y 3.");
                    scanner.nextLine();  // Limpiar el buffer para evitar un bucle infinito
                }
            }

            switch (opcion) {
                case 1:
                    limpiarConsola();
                     GestionRegistrar.gestionarRegistroHistoricoExpedientes();  
                    break;
                case 2:
                    limpiarConsola();
                    GestionCola.gestionarColaAtencionActiva();
                    break;
                case 3:
                    limpiarConsola();
                    System.out.println("Saliendo del Sistema...");
                    return;  // Sale del programa
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }

            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();  // Esperar entrada del usuario
        }
    }

    
}
