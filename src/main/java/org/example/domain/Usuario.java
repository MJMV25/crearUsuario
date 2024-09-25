package org.example.domain;

public class Usuario {
    private String nombre;
    private String contraseña;
    private int id;
    private int edad;

    public Usuario() {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public static void setContraseña() {
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String   toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", id=" + id +
                ", edad=" + edad +
                '}';
    }
}
