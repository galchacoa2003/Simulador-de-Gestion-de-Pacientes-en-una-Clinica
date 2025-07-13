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
                System.out.println("|(!) ¡Opción inválida! Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
            }
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                String nombre;
                String sexo;
                String fechaNacimiento;
                String diagnostico;
                    limpiarConsola();
                    System.out.println("Registrar nuevo expediente");

                    // Pedir datos del nuevo expediente
                    while (true) {             
                        System.out.print("Ingrese el nombre del paciente: ");
                        nombre = scanner.nextLine();       
                        // Verifica si el nombre está vacío, contiene números o tiene espacios
                        if (nombre.trim().isEmpty()) {
                            System.out.println("El nombre no puede estar vacío. Intenta nuevamente.");
                        } else if (nombre.matches(".*\\d.*")) {
                            System.out.println("El nombre no puede contener números. Intenta nuevamente.");
                        } else if (!nombre.matches("[A-Za-záéíóúÁÉÍÓÚñÑ]+")) {
                            System.out.println("El nombre solo puede contener letras. Intenta nuevamente.");
                        } else {
                            break; // Sale del bucle si el nombre es válido
                        }
                    }

                    while (true) {
                        System.out.print("Ingrese el sexo del paciente (Masculino/Femenino): ");
                        sexo = scanner.nextLine().trim().toLowerCase();  // Convierte todo a minúsculas
                        
                        // Verifica que el sexo sea "masculino" o "femenino"
                        if (sexo.equals("masculino") || sexo.equals("femenino")) {
                            break; // Sale del bucle si el sexo es válido
                        } else {
                             System.out.println("Por favor, ingrese masculino o femenino. Intenta nuevamente.");
                        }
                    }

                    while (true) {
                        System.out.print("Ingrese la fecha de nacimiento del paciente (DD/MM/AAAA): ");
                        fechaNacimiento = scanner.nextLine().trim();

                        // Verifica si la fecha tiene el formato correcto y solo contiene números
                        if (fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}")) {
                            // Verifica que no haya letras en la fecha
                            String[] partes = fechaNacimiento.split("/");
                            // Verifica que el día, mes y año sean números válidos
                            int dia = Integer.parseInt(partes[0]);
                            int mes = Integer.parseInt(partes[1]);
                            int anio = Integer.parseInt(partes[2]);

                            // Validaciones adicionales para los días, meses y años
                            if (mes < 1 || mes > 12) {
                                System.out.println("El mes debe estar entre 01 y 12. Intenta nuevamente.");
                            } else if (dia < 1 || dia > 31) {
                                System.out.println("El día debe estar entre 01 y 31. Intenta nuevamente.");
                            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                                System.out.println("El mes seleccionado tiene solo 30 días. Intenta nuevamente.");
                            } else if (mes == 2) {
                                // Verifica el mes de febrero (28 o 29 días dependiendo del año)
                                boolean esBisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
                                if ((esBisiesto && dia > 29) || (!esBisiesto && dia > 28)) {
                                    System.out.println("Febrero solo tiene 28 o 29 días. Intenta nuevamente.");
                                } else {
                                    break; // Si todas las validaciones son correctas, sale del bucle
                                }
                            } else {
                                break; // Si todo es válido, sale del bucle
                            }
                        } else {
                                System.out.println("El formato de la fecha es incorrecto. Asegúrese de usar DD/MM/AAAA.");
                            }
                    }
                  
                    while (true) {
                        System.out.print("Ingrese el diagnóstico del paciente: ");
                        diagnostico = scanner.nextLine().trim();

                        // Verifica si el diagnóstico no está vacío ni contiene caracteres especiales
                        if (diagnostico.isEmpty()) {
                            System.out.println("El diagnóstico no puede estar vacío. Intenta nuevamente.");
                        } else if (!diagnostico.matches("[A-Za-záéíóúÁÉÍÓÚñÑ0-9\\s]+")) {
                            System.out.println("El diagnóstico solo puede contener letras, números y espacios. Intenta nuevamente.");
                        } else {
                            break; // Sale del bucle si el diagnóstico es válido
                        }
                    }   

                    // Registrar el expediente
                    arbol.registrarExpediente(nombre, sexo, fechaNacimiento, diagnostico);
                    System.out.println("Expediente registrado correctamente.");
                    break;

                case 2:
                    limpiarConsola();
                    System.out.println("Ingrese el ID del registro que desea buscar:");
                    int idBuscado = scanner.nextInt();  // Usamos un Scanner para leer el ID del usuario
                    arbol.buscarRegistroPorId(idBuscado);  // Llamamos al método con el ID ingresado
                    // Pausar y esperar que el usuario presione Enter para continuar
                    System.out.println("\nPresione Enter para salir de este apartado...");
                    scanner.nextLine();
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
                    System.out.println("|(!) Opción no válida, por favor intente nuevamente.");
            }

            // Pausar para ver la salida y continuar
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();  // Esperar entrada del usuario
        }
    }
}
