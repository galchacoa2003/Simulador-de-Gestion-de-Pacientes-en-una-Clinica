package BST;

public class ArbolBinarioBusqueda {

    private Nodo raiz;
    private int contadorId;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
        this.contadorId = 1;  // El primer ID será 1
    }

    // Método para registrar un nuevo expediente (autoasigna el ID)
    public void registrarExpediente(String nombre, String sexo, String fechaNacimiento, String diagnostico) {
        // Generamos el ID (autoasignado secuencialmente)
        int id = contadorId++; // Asigna el ID y luego incrementa el contador
        insertar(id, nombre, sexo, fechaNacimiento, diagnostico);
    }

    // Método para insertar el expediente en el árbol
    private void insertar(int id, String nombre, String sexo, String fechaNacimiento, String diagnostico) {
        raiz = insertarRecursivo(raiz, id, nombre, sexo, fechaNacimiento, diagnostico);
    }

    // Método recursivo para insertar un nuevo expediente en el árbol
    private Nodo insertarRecursivo(Nodo raiz, int id, String nombre, String sexo, String fechaNacimiento, String diagnostico) {
        if (raiz == null) {
            return new Nodo(id, nombre, sexo, fechaNacimiento, diagnostico);
        }

        if (id < raiz.id) {
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo, id, nombre, sexo, fechaNacimiento, diagnostico);
        } else if (id > raiz.id) {
            raiz.derecho = insertarRecursivo(raiz.derecho, id, nombre, sexo, fechaNacimiento, diagnostico);
        }

        return raiz;
    }

    // Método para listar todos los registros en orden
    public void listarRegistros() {
        if (raiz == null) {
            System.out.println("No hay registros.");
        } else {
            listarRecursivo(raiz);  // Llamamos al método recursivo para listar los nodos
        }
    }

    // Método recursivo para listar todos los registros (recorrido en inorden)
    private void listarRecursivo(Nodo nodo) {
        if (nodo != null) {
            // Primero visitamos el subárbol izquierdo
            listarRecursivo(nodo.izquierdo);

            // Imprimimos el registro del nodo actual
            System.out.println("ID: " + nodo.id + ", Nombre: " + nodo.nombre + ", Sexo: " + nodo.sexo + 
                               ", Fecha de Nacimiento: " + nodo.fechaNacimiento + ", Diagnóstico: " + nodo.diagnostico);

            // Luego visitamos el subárbol derecho
            listarRecursivo(nodo.derecho);
        }
    }
}
