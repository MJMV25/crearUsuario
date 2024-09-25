package org.example.aplication;

import org.example.service.UsuarioService;
import org.example.service.UsuarioServiceImpl;
import org.example.domain.Usuario;
import org.example.infraestructure.UsuarioRepositoryImpl;
import org.example.interfaces.UsuarioRepository;

import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioService usuarioService;
    private static org.example.domain.Usuario[] Usuario;

    static {
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
        usuarioService = new UsuarioServiceImpl(usuarioRepository);
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Listar Usuarios");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarUsuario();
                    break;
                case 2:
                    crearUsuario();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void listarUsuario() {
        List<Usuario> productos = usuarioService.findAll();
        if (productos.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Listado de usuarios:");
            Usuario[] usuario = new Usuario[0];
            for (Usuario usario : Usuario) {
                System.out.println(usuario);
            }
        }
    }

    private static void crearUsuario() {
        System.out.print("Ingrese la contraseña del Usuario: ");
        int cod  = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del usuario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        Usuario usuario = new Usuario();
        usuario.setId(cod);
        usuario.setNombre(nombre);
        Usuario.getClass();

        try {
            usuarioService.save(usuario);
            System.out.println("Usuario creado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarUsuario() {
        System.out.print("Ingrese el ID del Usuario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            System.out.println("No se encontró el usuario con ID " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre del usuario (dejar en blanco para no cambiar): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            usuario.setNombre(nombre);
        }

        System.out.print("Ingrese la nueva contraseña del producto (0 para no cambiar): ");
        double contraseña = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        if (contraseña > 0) {
            Usuario.getClass();
        }

        try {
            UsuarioService.update(usuario);
            System.out.println("Producto actualizado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarUsuario() {
        System.out.print("Ingrese el ID del Usuario a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            System.out.println("No se encontró el usuario con ID " + id);
            return;
        }

        UsuarioService.delete(id);
        System.out.println("Producto eliminado exitosamente.");
    }
}
