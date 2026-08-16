package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
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
}