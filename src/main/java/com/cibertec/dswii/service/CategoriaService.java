package com.cibertec.dswii.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.dswii.entity.Categoria;

public interface CategoriaService {

	public List<Categoria> listCategorias();
	
	public Categoria saveCategoria(Categoria bean);
	
	public String deleteCategoria(Integer id);/*cambiando a boolean por si falla*/
	
	public Optional<Categoria> findCategoria(Integer id);
	
}
