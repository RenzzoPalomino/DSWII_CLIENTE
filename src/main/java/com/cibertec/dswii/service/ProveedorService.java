package com.cibertec.dswii.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.dswii.entity.Proveedor;

public interface ProveedorService {
public List<Proveedor> listProveedores();
	
	public Proveedor saveProveedor(Proveedor bean);
	
	public String deleteProveedor(Integer id);/*cambiando a boolean por si falla*/
	
	public Optional<Proveedor> findProveedor(Integer id);

}
