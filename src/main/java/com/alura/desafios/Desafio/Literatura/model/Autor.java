package com.alura.desafios.Desafio.Literatura.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int fechaNac;
    private int fechaMuerte;
    @OneToMany(mappedBy = "autor", orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(Autor autor) {
        this.id = autor.id;
        this.nombre = autor.nombre;
        this.fechaNac = autor.fechaNac;
        this.fechaMuerte = autor.fechaMuerte;
        this.libros = autor.libros;
    }

    public Autor(String nombre, int fechaNac, int fechaMuerte) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.fechaMuerte = fechaMuerte;
    }

    public Autor (DatosAutor da){
        this.nombre = da.nombre();
        this.fechaNac = da.fechaNac();
        this.fechaMuerte = da.fechaMuerte();
    }

    public Autor() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(int fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(int fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public String getNombre() {return nombre;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nombre, autor.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    private String listarLibros(){
        StringBuilder listaLibros= new StringBuilder();
        for (Libro l : libros){
            listaLibros.append(l.getTitulo()).append("\n");
        }
        return listaLibros.toString();
    }

    @Override
    public String toString() {
        return "***** Autor *****" +
                "\nNombre: " + nombre +
                "\nFecha de Nacimiento: " + fechaNac +
                "\nFecha de Muerte: " + fechaMuerte +
                "\nLibros: " + listarLibros();
    }
}