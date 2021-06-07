package com.productosdiversos.api.telocompro.service;

import java.util.Optional;

import com.productosdiversos.api.telocompro.model.Image;
import com.productosdiversos.api.telocompro.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Optional<Image> getImageByIdAndArticuloOptional(Integer id, Integer articulo) {
        return imageRepository.findByIdAndArticulo(id, articulo);
    }
    
}
