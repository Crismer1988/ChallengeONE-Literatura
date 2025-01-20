package com.alura.desafios.Desafio.Literatura.model;

import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;
    private String idioma;
    private int descargas;

    public Libro(String titulo, Autor autor, String idioma, int descargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
    }

    public Libro(DatosLibro dl) {
        this.titulo = dl.titulo();
        this.autor = new Autor(dl.autor().get(0));
        this.idioma = dl.idioma().get(0);
        this.descargas = dl.descargas();
    }

    public Libro() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return " ***** Libro *****" +
                "\nTitulo: " + titulo  +
                "\nAutor: " + autor.getNombre() +
                "\nIdioma: " + idioma  +
                "\nCantidad Descargas: " + descargas;
    }
}
