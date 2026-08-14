public class LinkedList {

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertarInicio(Libro libro) {

        Node nuevo = new Node(libro);

        nuevo.next = head;

        head = nuevo;
    }

    public void insertarFinal(Libro libro) {

        Node nuevo = new Node(libro);

        if (head == null) {
            head = nuevo;
            return;
        }

        Node actual = head;

        while (actual.next != null) {
            actual = actual.next;
        }

        actual.next = nuevo;
    }

    public void insertarPosicion(Libro libro, int posicion) {

        if (posicion < 0) {
            System.out.println("Posición inválida.");
            return;
        }

        Node nuevo = new Node(libro);

        if (posicion == 0) {
            nuevo.next = head;
            head = nuevo;
            return;
        }

        Node actual = head;

        for (int i = 0; i < posicion - 1 && actual != null; i++) {
            actual = actual.next;
        }

        if (actual == null) {
            System.out.println("Posición inválida.");
            return;
        }

        nuevo.next = actual.next;
        actual.next = nuevo;
    }

    public void mostrar() {

        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node actual = head;

        while (actual != null) {

            System.out.println("Código: " + actual.libro.codigo);
            System.out.println("Título: " + actual.libro.titulo);
            System.out.println("Autor: " + actual.libro.autor);
            System.out.println("----------------------");

            actual = actual.next;
        }
    }

    public boolean buscar(String codigo) {

        Node actual = head;

        while (actual != null) {

            if (actual.libro.codigo.equals(codigo)) {
                return true;
            }

            actual = actual.next;
        }

        return false;
    }

    public Libro obtener(int posicion) {

        if (posicion < 0) {
            return null;
        }

        Node actual = head;

        for (int i = 0; i < posicion && actual != null; i++) {
            actual = actual.next;
        }

        if (actual == null) {
            return null;
        }

        return actual.libro;
    }

    public boolean eliminar(String codigo) {

        if (head == null) {
            return false;
        }

        if (head.libro.codigo.equals(codigo)) {
            head = head.next;
            return true;
        }

        Node actual = head;

        while (actual.next != null) {

            if (actual.next.libro.codigo.equals(codigo)) {
                actual.next = actual.next.next;
                return true;
            }

            actual = actual.next;
        }

        return false;
    }

    public boolean eliminarPosicion(int posicion) {

        if (head == null || posicion < 0) {
            return false;
        }

        if (posicion == 0) {
            head = head.next;
            return true;
        }

        Node actual = head;

        for (int i = 0; i < posicion - 1 && actual.next != null; i++) {
            actual = actual.next;
        }

        if (actual.next == null) {
            return false;
        }

        actual.next = actual.next.next;

        return true;
    }

    public int tamaño() {

        int contador = 0;

        Node actual = head;

        while (actual != null) {
            contador++;
            actual = actual.next;
        }

        return contador;
    }
}