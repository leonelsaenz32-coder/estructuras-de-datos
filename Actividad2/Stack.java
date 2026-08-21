public class Stack {

    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // Agregar una acción a la pila
    public void push(String data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // Eliminar y devolver la última acción
    public String pop() {
        if (isEmpty()) {
            return null;
        }

        String data = top.data;
        top = top.next;

        size--;

        return data;
    }

    // Consultar la última acción sin eliminarla
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    // Verificar si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Obtener cantidad de elementos
    public int size() {
        return size;
    }

    // Mostrar el historial
    public void display() {
        if (isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }

        Node current = top;

        System.out.println("\n===== HISTORIAL DE ACCIONES =====");
        System.out.println("TOP");
        System.out.println("|");

        while (current != null) {
            System.out.println("|-- " + current.data);
            current = current.next;
        }

        System.out.println("|");
        System.out.println("FIN");
    }
}