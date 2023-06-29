package com.cibertec.dswii.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.dswii.dao.CategoriaDAO;
import com.cibertec.dswii.entity.Categoria;
import com.cibertec.dswii.service.CategoriaService;


@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	private CategoriaDAO repo;
	
	@Override
	public List<Categoria> listCategorias() {
		return (List<Categoria>)repo.findAll();
		
	}

	@Override
	public Categoria saveCategoria(Categoria bean) {
		return this.repo.save(bean);
	}

	@Override
	public String deleteCategoria(Integer id) {
		try {
			repo.deleteById(id);
			return "Registro de id "+id+" eliminado";
		} catch (Exception e) {
			return "error en eliminacion";
		}
	}

	@Override
	public Optional<Categoria> findCategoria(Integer id) {
		return repo.findById(id);
	}

}
