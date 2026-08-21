public class Queue {

    private Node front;
    private Node rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Agregar una tarea al final de la cola
    public void enqueue(String data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Eliminar y devolver la primera tarea
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }

        String data = front.data;

        front = front.next;

        size--;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Consultar la primera tarea sin eliminarla
    public String peek() {
        if (isEmpty()) {
            return null;
        }

        return front.data;
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Obtener cantidad de elementos
    public int size() {
        return size;
    }

    // Mostrar las tareas pendientes
    public void display() {
        if (isEmpty()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }

        Node current = front;

        System.out.println("\n===== TAREAS PENDIENTES =====");
        System.out.println("FRONT");
        System.out.println("|");

        while (current != null) {
            System.out.println("|-- " + current.data);
            current = current.next;
        }

        System.out.println("|");
        System.out.println("REAR");
    }
}