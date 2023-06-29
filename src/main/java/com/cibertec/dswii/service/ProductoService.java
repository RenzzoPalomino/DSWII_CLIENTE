package com.cibertec.dswii.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.dswii.entity.Producto;

public interface ProductoService {

	
	public List<Producto> listProductos();
	
	public Producto saveProducto(Producto bean);
	
	public String deleteProducto(Long id);/*cambiando a boolean por si falla*/
	
	public Optional<Producto> findProducto(Long id);
}
