package com.cibertec.dswii.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name ="categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Integer cod_categoria;
    
    @Column(name = "nombre_categoria")
    private String nombre;
    
    @JsonIgnore
    @OneToMany(mappedBy ="categoria")
    private List<Producto> listaProductos;

	public Integer getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(Integer cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
    
    
    //
}