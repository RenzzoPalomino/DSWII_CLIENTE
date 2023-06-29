package com.cibertec.dswii.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.dswii.entity.Categoria;

@Repository
public interface CategoriaDAO extends CrudRepository<Categoria, Integer>{

}
