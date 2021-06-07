package com.productosdiversos.api.telocompro.service;

import com.productosdiversos.api.telocompro.model.ArticleDetail;
import com.productosdiversos.api.telocompro.repository.ArticleDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleDetailService {

    @Autowired
    private ArticleDetailRepository articleDetailRepository;

    public Page<ArticleDetail> getArticles(String titulo, String categoria, Float preciobase, Float preciotope, Pageable pageable) {
        Page<ArticleDetail> pageArticle;

        if (null != titulo && null != categoria && null != preciobase && null != preciotope) {
            pageArticle = articleDetailRepository.findByTituloContainingAndCategoriaIgnoreCaseAndPrecioBetween(titulo, categoria, preciobase, preciotope, pageable);
        } else if (null != titulo && null == categoria && null != preciobase && null != preciotope) {
            pageArticle = articleDetailRepository.findByTituloContainingAndPrecioBetween(titulo, preciobase, preciotope, pageable);
        } else if (null == titulo && null != categoria && null != preciobase && null != preciotope) {
            pageArticle = articleDetailRepository.findByCategoriaIgnoreCaseAndPrecioBetween(categoria, preciobase, preciotope, pageable);
        } else if (null != titulo && null != categoria && null == preciobase && null == preciotope) {
            pageArticle = articleDetailRepository.findByTituloContainingAndCategoriaIgnoreCase(titulo, categoria, pageable);
        } else if (null != titulo && null == categoria && null == preciobase && null == preciotope) {
            pageArticle = articleDetailRepository.findByTituloContaining(titulo, pageable);
        } else if (null == titulo && null != categoria && null == preciobase && null == preciotope) {
            pageArticle = articleDetailRepository.findByCategoriaIgnoreCase(categoria, pageable);
        } else if (null == titulo && null == categoria && null != preciobase && null != preciotope) {
            pageArticle = articleDetailRepository.findByPrecioBetween(preciobase, preciotope, pageable);
        } else {
            pageArticle = articleDetailRepository.findAll(pageable);
        }

        return pageArticle;
    }

}
