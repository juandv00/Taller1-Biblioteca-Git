package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Aquí irá el menú (Fase 8)
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
}