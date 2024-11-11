package com.Proyectochacras.FoodOrganic.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity

public class Productor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String contrasena; // Contraseña en texto plano (en producción deberías cifrarla)


    @Enumerated(EnumType.STRING)
    private Rol rol; // Rol del productor (USUARIO, ADMINISTRADOR)

    @OneToMany(mappedBy = "productor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference


    private List<Publicacion> publicaciones; // Relación uno a muchos con publicaciones

    // Constructor vacío, necesario para crear una instancia de Productor
    public Productor() {}


    // Constructor con parámetros (si lo necesitas)
    public Productor(String nombre, String correo, String contrasena, Rol rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    // Métodos para agregar y eliminar publicaciones
    public void agregarPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
        publicacion.setProductor(this); // Establece la relación inversa
    }

    public void eliminarPublicacion(Publicacion publicacion) {
        this.publicaciones.remove(publicacion);
        publicacion.setProductor(null); // Elimina la relación inversa
    }
}
