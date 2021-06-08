package com.productosdiversos.api.telocompro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.productosdiversos.api.telocompro.model.ArticleDetail;
import com.productosdiversos.api.telocompro.model.Category;
import com.productosdiversos.api.telocompro.model.ContactForm;
import com.productosdiversos.api.telocompro.model.Image;
import com.productosdiversos.api.telocompro.service.ArticleDetailService;
import com.productosdiversos.api.telocompro.service.CategoryService;
import com.productosdiversos.api.telocompro.service.ContactService;
import com.productosdiversos.api.telocompro.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private ArticleDetailService articleDetailService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Map<String, Object>> getCategories() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        try {

            List<Category> categories = categoryService.getAll();

            Map<String, Object> response = new HashMap<>();
            response.put("categories", categories);

            return ResponseEntity.ok().headers(responseHeaders).contentType(MediaType.APPLICATION_JSON).body(response);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().headers(responseHeaders).build();
        }
    }

    @GetMapping("/articles")
    public ResponseEntity<Map<String, Object>> getArticles(
        @RequestParam(required = false) String titulo,
        @RequestParam(required = false) String categoria,
        @RequestParam(required = false) Float preciobase,
        @RequestParam(required = false) Float preciotope,
        @RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "6") Integer size
    ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<ArticleDetail> pageArticle = articleDetailService.getArticles(titulo, categoria, preciobase, preciotope, pageable);
            List<ArticleDetail> articles = pageArticle.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("articles", articles);
            response.put("currentPage", pageArticle.getNumber());
            response.put("totalItems", pageArticle.getTotalElements());
            response.put("totalPages", pageArticle.getTotalPages());
            return ResponseEntity.ok().headers(responseHeaders).contentType(MediaType.APPLICATION_JSON).body(response);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().headers(responseHeaders).build();
        }
    }

    @GetMapping(value = "/articles/{article.id}/images/{image.id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getArticleImage(
        @PathVariable("article.id") Integer articulo, 
        @PathVariable("image.id") Integer id
    ) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        Optional<Image> imagen = imageService.getImageByIdAndArticuloOptional(id, articulo);
        byte[] img = null;
        if (imagen.isPresent()) {
            img = imagen.get().getImagen();
        }
        return ResponseEntity.ok().headers(responseHeaders).contentType(MediaType.IMAGE_JPEG).body(img);
    }

    @PostMapping("/send-mail")
    public ResponseEntity<String> sendMail(@RequestBody ContactForm contactForm) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        try {
            contactService.sendEmail(contactForm.getCorreo(), contactForm.getNombre(), contactForm.getMensaje());
        } catch (Exception e) {
            ResponseEntity.unprocessableEntity().headers(responseHeaders).body("No se pudo procesar el envío");
        }

        return ResponseEntity.ok().headers(responseHeaders).build();
        
    }

}