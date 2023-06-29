package com.cibertec.dswii.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name ="Producto")
public class Producto {
   //  private static final long serialVersionUID=1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_producto;
    
    
    @Column(name = "nombre_producto")
    private String nombre;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "stock")
    private int stock;
    
    
    
    @ManyToOne 
    @JoinColumn(name = "cod_categoria")
    private Categoria categoria;
    
    @ManyToOne 
    @JoinColumn(name = "cod_proveedor")
    private Proveedor proveedor;
    
    @Column(name = "imagen")
    private String imagen;

	public Long getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(Long cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
    
    
    //
    
    
}