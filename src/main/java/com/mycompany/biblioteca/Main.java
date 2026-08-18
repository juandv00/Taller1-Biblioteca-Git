package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion(1, 4);
            switch (opcion) {
                case 1 -> menuClientes();
                case 2 -> menuLibros();
                case 3 -> menuPrestamos();
                case 4 -> System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                case -1 -> { }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4 && opcion != -1);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE GESTIÓN DE BIBLIOTECA =====");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de libros");
        System.out.println("3. Gestión de préstamos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(1, 6);
            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();
                case 6 -> System.out.println("Volviendo al menú principal...");
                case -1 -> { }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6 && opcion != -1);
    }

    private static void menuLibros() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(1, 6);
            switch (opcion) {
                case 1 -> crearLibro();
                case 2 -> listarLibros();
                case 3 -> {
                    System.out.print("Ingrese el código del libro: ");
                    String codigo = sc.nextLine();
                    buscarLibro(codigo);
                }
                case 4 -> actualizarLibro();
                case 5 -> eliminarLibro();
                case 6 -> System.out.println("Volviendo al menú principal...");
                case -1 -> { }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6 && opcion != -1);
    }

    private static void menuPrestamos() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Listar préstamos activos");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(1, 4);
            switch (opcion) {
                case 1 -> crearPrestamo();
                case 2 -> devolverPrestamo();
                case 3 -> listarPrestamos();
                case 4 -> System.out.println("Volviendo al menú principal...");
                case -1 -> { }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4 && opcion != -1);
    }

    private static int leerOpcion(int min, int max) {
        try {
            int opcion = Integer.parseInt(sc.nextLine());
            if (opcion < min || opcion > max) {
                System.out.println("Opción fuera de rango.");
                return -1;
            }
            return opcion;
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
            return -1;
        }
    }

    public static void crearCliente() {
        System.out.println("=== Crear Cliente ===");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente nuevo = new Cliente(id, nombre, telefono, email);
        clientes.add(nuevo);

        System.out.println("Cliente creado exitosamente.");
    }

    public static void listarClientes() {
        System.out.println("=== Lista de Clientes ===");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public static void buscarCliente() {
        System.out.println("=== Buscar Cliente ===");
        System.out.print("Ingrese el ID del cliente: ");
        String id = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                System.out.println("Cliente encontrado:");
                System.out.println(c);
                return;
            }
        }
        System.out.println("No se encontró ningún cliente con ese ID.");
    }

    public static void actualizarCliente() {
        System.out.println("=== Actualizar Cliente ===");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String id = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
                String nombre = sc.nextLine();
                System.out.print("Nuevo teléfono (" + c.getTelefono() + "): ");
                String telefono = sc.nextLine();
                System.out.print("Nuevo email (" + c.getEmail() + "): ");
                String email = sc.nextLine();

                c.setNombre(nombre);
                c.setTelefono(telefono);
                c.setEmail(email);

                System.out.println("Cliente actualizado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún cliente con ese ID.");
    }

    public static void eliminarCliente() {
        System.out.println("=== Eliminar Cliente ===");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String id = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                clientes.remove(c);
                System.out.println("Cliente eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún cliente con ese ID.");
    }

    public static void crearLibro() {
        System.out.println("=== Crear Libro ===");
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicación: ");
        String anioPublic = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro nuevo = new Libro(codigo, titulo, anioPublic, autor);
        libros.add(nuevo);

        System.out.println("Libro creado exitosamente.");
    }

    public static void listarLibros() {
        System.out.println("=== Lista de Libros ===");

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public static void buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                System.out.println("Libro encontrado:");
                System.out.println(l);
                return;
            }
        }
        System.out.println("No se encontró ningún libro con ese código.");
    }

    public static void actualizarLibro() {
        System.out.println("=== Actualizar Libro ===");
        System.out.print("Ingrese el código del libro a actualizar: ");
        String codigo = sc.nextLine();

        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                System.out.print("Nuevo título (" + l.getTitulo() + "): ");
                String titulo = sc.nextLine();
                System.out.print("Nuevo año de publicación (" + l.getAnioPublic() + "): ");
                String anioPublic = sc.nextLine();
                System.out.print("Nuevo autor (" + l.getAutor() + "): ");
                String autor = sc.nextLine();

                l.setTitulo(titulo);
                l.setAnioPublic(anioPublic);
                l.setAutor(autor);

                System.out.println("Libro actualizado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún libro con ese código.");
    }

    public static void eliminarLibro() {
        System.out.println("=== Eliminar Libro ===");
        System.out.print("Ingrese el código del libro a eliminar: ");
        String codigo = sc.nextLine();

        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                libros.remove(l);
                System.out.println("Libro eliminado exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún libro con ese código.");
    }

    public static void crearPrestamo() {
        System.out.println("=== Registrar Préstamo ===");
        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente c : clientes) {
            if (c.getId().equals(idCliente)) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("No se encontró ningún cliente con ese ID.");
            return;
        }

        System.out.print("Código del libro: ");
        String codigoLibro = sc.nextLine();
        Libro libroEncontrado = null;
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigoLibro)) {
                libroEncontrado = l;
                break;
            }
        }

        if (libroEncontrado == null) {
            System.out.println("No se encontró ningún libro con ese código.");
            return;
        }

        if (!libroEncontrado.isDisponible()) {
            System.out.println("Este libro no está disponible actualmente.");
            return;
        }

        Prestamo nuevo = new Prestamo(idPrestamo, clienteEncontrado, libroEncontrado, LocalDate.now(), "activo");
        prestamos.add(nuevo);
        libroEncontrado.setDisponible(false);

        System.out.println("Préstamo registrado exitosamente.");
    }

    public static void devolverPrestamo() {
        System.out.println("=== Registrar Devolución ===");
        System.out.print("ID del préstamo: ");
        String idPrestamo = sc.nextLine();

        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo)) {
                if (p.getEstado().equals("devuelto")) {
                    System.out.println("Este préstamo ya fue devuelto anteriormente.");
                    return;
                }

                p.setEstado("devuelto");
                p.getLibro().setDisponible(true);

                System.out.println("Devolución registrada exitosamente.");
                return;
            }
        }

        System.out.println("No se encontró ningún préstamo con ese ID.");
    }

    public static void listarPrestamos() {
        System.out.println("=== Préstamos Activos ===");

        boolean hayActivos = false;
        for (Prestamo p : prestamos) {
            if (p.getEstado().equals("activo")) {
                System.out.println(p);
                hayActivos = true;
            }
        }

        if (!hayActivos) {
            System.out.println("No hay préstamos activos.");
        }
    }
}