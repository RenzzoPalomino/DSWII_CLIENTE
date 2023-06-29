package com.cibertec.dswii.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.dswii.dao.ProveedorDAO;
import com.cibertec.dswii.entity.Proveedor;

@Service
public class ProveedorServiceImp implements com.cibertec.dswii.service.ProveedorService {

	@Autowired
	ProveedorDAO repo;
	
	
	@Override
	public List<Proveedor> listProveedores() {
		return (List<Proveedor>)repo.findAll();
	}

	@Override
	public Proveedor saveProveedor(Proveedor bean) {
		return this.repo.save(bean);
	}

	@Override
	public String deleteProveedor(Integer id) {
		try {
			repo.deleteById(id);
			return "Registro de id "+id+" eliminado";
		} catch (Exception e) {
			return "error en eliminacion";
		}
	}

	@Override
	public Optional<Proveedor> findProveedor(Integer id) {
		return repo.findById(id);
	}

}
