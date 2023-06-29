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
@Table(name = "Proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_proveedor;

	@Column(name = "nombre_proveedor")
	private String nombre;

	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
	private List<Producto> listaProductos;

	
	
	//
	public Integer getCod_proveedor() {
		return cod_proveedor;
	}

	public void setCod_proveedor(Integer cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
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

	///

}
