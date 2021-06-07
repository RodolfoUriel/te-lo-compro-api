package com.productosdiversos.api.telocompro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "images")
public class Image {
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "article_id", nullable = false)
    private Integer articulo;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "image", length = Integer.MAX_VALUE, nullable = false)
    private byte[] imagen;

    @Column(name = "content_type", nullable = false)
    private String tipo;

    @Column(name = "name", nullable = false)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticulo() {
        return articulo;
    }

    public void setArticulo(Integer articulo) {
        this.articulo = articulo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Image [articulo=" + articulo + ", id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
    }

}
