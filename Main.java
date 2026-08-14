import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedList biblioteca = new LinkedList();

        int opcion;

        do {

            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1. Agregar libro al inicio");
            System.out.println("2. Agregar libro al final");
            System.out.println("3. Insertar libro en posición");
            System.out.println("4. Mostrar libros");
            System.out.println("5. Buscar libro");
            System.out.println("6. Consultar libro por posición");
            System.out.println("7. Eliminar libro");
            System.out.println("8. Eliminar libro por posición");
            System.out.println("9. Mostrar cantidad de libros");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ingrese el código: ");
                    String codigo = scanner.nextLine();

                    Libro libro = new Libro(titulo, autor, codigo);

                    biblioteca.insertarInicio(libro);

                    System.out.println("Libro agregado al inicio correctamente.");

                    break;

                case 2:

                    System.out.print("Ingrese el título: ");
                    String tituloFinal = scanner.nextLine();

                    System.out.print("Ingrese el autor: ");
                    String autorFinal = scanner.nextLine();

                    System.out.print("Ingrese el código: ");
                    String codigoFinal = scanner.nextLine();

                    Libro libroFinal = new Libro(
                        tituloFinal,
                        autorFinal,
                        codigoFinal
                    );

                    biblioteca.insertarFinal(libroFinal);

                    System.out.println("Libro agregado al final correctamente.");

                    break;

                case 3:

                    System.out.print("Ingrese el título: ");
                    String tituloPosicion = scanner.nextLine();

                    System.out.print("Ingrese el autor: ");
                    String autorPosicion = scanner.nextLine();

                    System.out.print("Ingrese el código: ");
                    String codigoPosicion = scanner.nextLine();

                    System.out.print("Ingrese la posición: ");
                    int posicion = scanner.nextInt();
                    scanner.nextLine();

                    Libro libroPosicion = new Libro(
                        tituloPosicion,
                        autorPosicion,
                        codigoPosicion
                    );

                    biblioteca.insertarPosicion(
                        libroPosicion,
                        posicion
                    );

                    System.out.println("Libro insertado correctamente.");

                    break;

                case 4:

                    biblioteca.mostrar();

                    break;

                case 5:

                    System.out.print("Ingrese el código del libro a buscar: ");
                    String codigoBuscar = scanner.nextLine();

                    boolean encontrado = biblioteca.buscar(codigoBuscar);

                    if (encontrado) {
                        System.out.println("Libro encontrado.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }

                    break;

                case 6:

                    System.out.print("Ingrese la posición del libro: ");
                    int posicionConsultar = scanner.nextInt();
                    scanner.nextLine();

                    Libro libroConsultado = biblioteca.obtener(posicionConsultar);

                    if (libroConsultado != null) {

                        System.out.println(
                            "Libro encontrado en la posición "
                            + posicionConsultar + ":"
                        );

                        System.out.println(
                            "Código: " + libroConsultado.codigo
                        );

                        System.out.println(
                            "Título: " + libroConsultado.titulo
                        );

                        System.out.println(
                            "Autor: " + libroConsultado.autor
                        );

                    } else {

                        System.out.println("Posición inválida.");

                    }

                    break;

                case 7:

                    System.out.print(
                        "Ingrese el código del libro a eliminar: "
                    );

                    String codigoEliminar = scanner.nextLine();

                    boolean eliminado =
                            biblioteca.eliminar(codigoEliminar);

                    if (eliminado) {

                        System.out.println(
                            "Libro eliminado correctamente."
                        );

                    } else {

                        System.out.println(
                            "Libro no encontrado."
                        );

                    }

                    break;

                case 8:

                    System.out.print(
                        "Ingrese la posición del libro a eliminar: "
                    );

                    int posicionEliminar = scanner.nextInt();
                    scanner.nextLine();

                    boolean eliminadoPosicion =
                            biblioteca.eliminarPosicion(
                                posicionEliminar
                            );

                    if (eliminadoPosicion) {

                        System.out.println(
                            "Libro eliminado correctamente."
                        );

                    } else {

                        System.out.println(
                            "Posición inválida."
                        );

                    }

                    break;

                case 9:

                    int tamaño = biblioteca.tamaño();

                    System.out.println(
                        "Cantidad de libros: " + tamaño
                    );

                    break;

                case 10:

                    System.out.println(
                        "Saliendo del programa..."
                    );

                    break;

                default:

                    System.out.println(
                        "Opción no válida."
                    );

                    break;
            }

        } while (opcion != 10);

        scanner.close();
    }
}