import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack stack = new Stack();
        Queue queue = new Queue();

        int opcion;

        do {
            System.out.println("\n====================================");
            System.out.println("       CENTRO DE OPERACIONES");
            System.out.println("====================================");
            System.out.println("1. Registrar acción");
            System.out.println("2. Deshacer última acción");
            System.out.println("3. Ver última acción");
            System.out.println("4. Mostrar historial");
            System.out.println();
            System.out.println("5. Agregar tarea");
            System.out.println("6. Procesar siguiente tarea");
            System.out.println("7. Ver siguiente tarea");
            System.out.println("8. Mostrar tareas pendientes");
            System.out.println();
            System.out.println("9. Mostrar estado del sistema");
            System.out.println("0. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
                System.out.print("Seleccione una opción: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("\nIngrese la acción realizada: ");
                    String accion = scanner.nextLine();

                    if (accion.trim().isEmpty()) {
                        System.out.println("La acción no puede estar vacía.");
                    } else {
                        stack.push(accion);
                        System.out.println("Acción registrada correctamente.");
                    }
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("\nNo hay acciones para deshacer.");
                    } else {
                        String accionDeshecha = stack.pop();

                        System.out.println("\nÚltima acción:");
                        System.out.println(accionDeshecha);
                        System.out.println("Acción deshecha correctamente.");
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("\nNo hay acciones registradas.");
                    } else {
                        System.out.println("\nÚltima acción:");
                        System.out.println(stack.peek());
                    }
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.print("\nIngrese la tarea: ");
                    String tarea = scanner.nextLine();

                    if (tarea.trim().isEmpty()) {
                        System.out.println("La tarea no puede estar vacía.");
                    } else {
                        queue.enqueue(tarea);
                        System.out.println("Tarea agregada correctamente.");
                    }
                    break;

                case 6:
                    if (queue.isEmpty()) {
                        System.out.println("\nNo hay tareas pendientes.");
                    } else {
                        String tareaProcesada = queue.dequeue();

                        System.out.println("\nProcesando tarea:");
                        System.out.println(tareaProcesada);
                        System.out.println("Tarea procesada correctamente.");
                    }
                    break;

                case 7:
                    if (queue.isEmpty()) {
                        System.out.println("\nNo hay tareas pendientes.");
                    } else {
                        System.out.println("\nSiguiente tarea:");
                        System.out.println(queue.peek());
                    }
                    break;

                case 8:
                    queue.display();
                    break;

                case 9:
                    System.out.println("\n====================================");
                    System.out.println("          ESTADO DEL SISTEMA");
                    System.out.println("====================================");

                    System.out.println("\nSTACK - Historial");
                    System.out.println("Elementos: " + stack.size());

                    if (stack.isEmpty()) {
                        System.out.println("Estado: Vacía");
                    } else {
                        System.out.println("TOP: " + stack.peek());
                    }

                    System.out.println("\nQUEUE - Tareas");
                    System.out.println("Elementos: " + queue.size());

                    if (queue.isEmpty()) {
                        System.out.println("Estado: Vacía");
                    } else {
                        System.out.println("FRONT: " + queue.peek());
                    }

                    System.out.println("====================================");
                    break;

                case 0:
                    System.out.println("\nCerrando Centro de Operaciones...");
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("\nOpción no válida.");
                    System.out.println("Seleccione una opción del 0 al 9.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}