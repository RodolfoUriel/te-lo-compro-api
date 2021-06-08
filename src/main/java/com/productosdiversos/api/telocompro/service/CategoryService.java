package com.productosdiversos.api.telocompro.service;

import java.util.List;

import com.productosdiversos.api.telocompro.model.Category;
import com.productosdiversos.api.telocompro.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

}
