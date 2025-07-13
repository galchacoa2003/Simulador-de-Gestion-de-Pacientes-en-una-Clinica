package BST;  // Define el paquete donde se encuentra la clase Nodo

// Definición de la clase Nodo
public class Nodo {
    // Atributos del Nodo
    int id;  // Identificador único para cada nodo (probablemente usado como clave)
    String nombre;  // Nombre de la persona asociada al nodo
    String sexo;  // Sexo de la persona
    String fechaNacimiento;  // Fecha de nacimiento de la persona
    String diagnostico;  // Diagnóstico asociado con la persona
    Nodo izquierdo;  // Referencia al hijo izquierdo (subárbol izquierdo)
    Nodo derecho;  // Referencia al hijo derecho (subárbol derecho)

    // Constructor de la clase Nodo
    public Nodo(int id, String nombre, String sexo, String fechaNacimiento, String diagnostico) {
        // Inicializa los atributos del nodo con los valores recibidos como parámetros
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.diagnostico = diagnostico;
        
        // Inicializa los hijos como nulos, ya que este nodo no tiene hijos cuando es creado
        this.izquierdo = null;
        this.derecho = null;
    }
}
