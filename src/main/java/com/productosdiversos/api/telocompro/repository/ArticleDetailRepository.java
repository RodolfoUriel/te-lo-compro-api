package com.productosdiversos.api.telocompro.repository;

import com.productosdiversos.api.telocompro.model.ArticleDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDetailRepository extends JpaRepository<ArticleDetail, Integer> {

    Page<ArticleDetail> findByTituloContaining(String titulo, Pageable pageable);
    Page<ArticleDetail> findByCategoriaIgnoreCase(String categoria, Pageable pageable);
    Page<ArticleDetail> findByPrecioBetween(Float preciobase, Float preciotope, Pageable pageable);
    Page<ArticleDetail> findByTituloContainingAndCategoriaIgnoreCase(String titulo, String categoria, Pageable pageable);
    Page<ArticleDetail> findByTituloContainingAndPrecioBetween(String titulo, Float preciobase, Float preciotope, Pageable pageable);
    Page<ArticleDetail> findByCategoriaIgnoreCaseAndPrecioBetween(String categoria, Float preciobase, Float preciotope, Pageable pageable);
    Page<ArticleDetail> findByTituloContainingAndCategoriaIgnoreCaseAndPrecioBetween(String titulo, String categoria, Float preciobase, Float preciotope, Pageable pageable);

}