package com.cibertec.dswii.controller;

import org.jboss.jandex.VoidType;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cibertec.dswii.entity.Categoria;
import com.cibertec.dswii.entity.Proveedor;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProveedorController {
	
	String apiUrl = "http://localhost:8088/proveedor/list/";
	
	String apiUrlSave = "http://localhost:8088/proveedor/save/";
	String apiUrlDelete = "http://localhost:8088/proveedor/delete/";
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/listadoProveedores")
    public String inicioproveedores(Model model){
        
       
        ResponseEntity<Proveedor[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Proveedor[].class);
        Proveedor[] proveedores = response.getBody();
        

        model.addAttribute("proveedores", proveedores);
        return "index_Proveedores";
    }
	
	
	@GetMapping("/agregarProveedor")
	public String guardar(Proveedor proveedor, Model model) {
        ResponseEntity<Proveedor[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Proveedor[].class);
        Proveedor[] prov = response.getBody();
          
        model.addAttribute("proveedores",prov);
		return "editar_Proveedor";
		
	}
	
	@PostMapping("/guardarProveedor")
	public String editarProveedor(Proveedor x) {
		
		restTemplate.postForObject(apiUrlSave, x, Void.class);
		
		return "redirect:/listadoProveedores";
	}
	
	@GetMapping("editarProveedor/{cod_proveedor}")
	public String editarProveedor(@PathVariable("cod_proveedor")int cod_proveedor, Model model) {
		String urlfind = apiUrl+ cod_proveedor;
		ResponseEntity<Proveedor> response = restTemplate.exchange(urlfind, HttpMethod.GET, null, Proveedor.class);
        //se omiten los corchetes debido a que el registro encontrado SIEMPRE VA SER UNO SOLO
		Proveedor proveedor = response.getBody();
		 model.addAttribute("proveedor",proveedor);
	       
		return "editar_Proveedor";
	}
	

	@GetMapping("eliminarProveedor/{cod_proveedor}")
	public String eliminarProveedor(@PathVariable("cod_proveedor") Proveedor prov){
		String urldelete = apiUrlDelete+prov.getCod_proveedor();
		restTemplate.delete(urldelete);
		return "redirect:/listadoProveedores";
		
	}
	
	
}
