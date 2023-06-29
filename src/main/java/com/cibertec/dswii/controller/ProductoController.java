package com.cibertec.dswii.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.cibertec.dswii.entity.Categoria;
import com.cibertec.dswii.entity.Producto;
import com.cibertec.dswii.entity.Proveedor;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProductoController {
	
	String apiUrlList="http://localhost:8088/producto/list/";
	String apiUrlListProvedor = "http://localhost:8088/proveedor/list/";
	String apiUrlListCategoria = "http://localhost:8088/categoria/list/";
	
	
	String apiUrlSave="http://localhost:8088/producto/save/";
	String apiUrlDelete="http://localhost:8088/producto/delete/";
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("listadoProductos")
	public String inicioProd(Model model) {
		ResponseEntity<Producto[]> response = restTemplate.exchange(apiUrlList, HttpMethod.GET, null, Producto[].class);
		Producto[] productos = response.getBody();
        
		model.addAttribute("productos", productos);
	
		return "index_productos";
	}
	
	@GetMapping("/agregarProducto")
	public String guardarProd(Producto producto, Model model) {
		
		//para productos
		ResponseEntity<Producto[]> response = restTemplate.exchange(apiUrlList, HttpMethod.GET, null, Producto[].class);
		Producto[] productos = response.getBody();
		
		//para categorias
		ResponseEntity<Categoria[]> responseC = restTemplate.exchange(apiUrlListCategoria, HttpMethod.GET, null, Categoria[].class);
		Categoria[] categorias = responseC.getBody();
		//para proveedores
		ResponseEntity<Proveedor[]> responseP = restTemplate.exchange(apiUrlListProvedor, HttpMethod.GET, null, Proveedor[].class);
		Proveedor[] proveedores = responseP.getBody();
        
		model.addAttribute("productos", productos);
		model.addAttribute("categorias", categorias);
		model.addAttribute("proveedores", proveedores);
		return "editar_Producto";
	}
	
	
	@PostMapping("/guardarProducto")
	public String editarProducto(Producto x) {
		restTemplate.postForObject(apiUrlSave, x, Void.class);
		
		return "redirect:/index_productos";
	}
	
	
	@GetMapping("editarProducto/{cod_producto}")
	public String editarProd(@PathVariable("cod_producto") int cod_producto, Model model) {
		
		String urlfind= apiUrlList+cod_producto;
		
		//para el producto
		ResponseEntity<Producto> response = restTemplate.exchange(urlfind, HttpMethod.GET, null, Producto.class);
		Producto producto = response.getBody();
		//para categorias
		ResponseEntity<Categoria[]> responseC = restTemplate.exchange(apiUrlListCategoria, HttpMethod.GET, null, Categoria[].class);
		Categoria[] categorias = responseC.getBody();
		//para proveedores
		ResponseEntity<Proveedor[]> responseP = restTemplate.exchange(apiUrlListProvedor, HttpMethod.GET, null, Proveedor[].class);
		Proveedor[] proveedores = responseP.getBody();		
		
		model.addAttribute("producto",producto);
		model.addAttribute("categorias", categorias);
		model.addAttribute("proveedores", proveedores);
		
		return "editar_Producto";
	}
	
	@GetMapping("eliminarProducto/{cod_producto}")
	public String eliminarProd(@PathVariable("cod_producto") Producto prod) {
		String urldelete= apiUrlDelete+prod.getCod_producto();
		restTemplate.delete(urldelete);
		
		return "redirect:/listadoProductos";
	}
	
	
	
	
}
