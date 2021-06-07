package com.productosdiversos.api.telocompro.repository;

import java.util.Optional;

import com.productosdiversos.api.telocompro.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    Optional<Image> findByIdAndArticulo(Integer id, Integer articulo);
    
}
