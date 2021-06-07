package com.productosdiversos.api.telocompro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articles_detail")
public class ArticleDetail {
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name = "imagen_id", nullable = false)
    private Integer imagen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "ArticleDetail [categoria=" + categoria + ", id=" + id + ", imagen=" + imagen + ", precio=" + precio
                + ", titulo=" + titulo + "]";
    }

}
