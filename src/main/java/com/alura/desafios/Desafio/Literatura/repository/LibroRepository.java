package com.alura.desafios.Desafio.Literatura.repository;

import com.alura.desafios.Desafio.Literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface LibroRepository extends JpaRepository<Libro, Long>{
    List<Libro> findAll();
    List<Libro> findTop5ByOrderByDescargasDesc();
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByIdiomaContainingIgnoreCase(String idioma);
}
