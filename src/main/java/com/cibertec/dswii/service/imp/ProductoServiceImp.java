package com.cibertec.dswii.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.dswii.dao.ProductoDAO;
import com.cibertec.dswii.entity.Producto;
import com.cibertec.dswii.service.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{

	@Autowired
	ProductoDAO repo;
	
	@Override
	public List<Producto> listProductos() {
		return  (List<Producto>)repo.findAll();
	}

	@Override
	public Producto saveProducto(Producto bean) {
		return this.repo.save(bean);
	}

	@Override
	public String deleteProducto(Long id) {
		try {
			repo.deleteById(id);
			return "Registro de id "+id+" eliminado";
		} catch (Exception e) {
			return "error en eliminacion";
		}
	}

	@Override
	public Optional<Producto> findProducto(Long id) {
		return repo.findById(id);
	}

}
