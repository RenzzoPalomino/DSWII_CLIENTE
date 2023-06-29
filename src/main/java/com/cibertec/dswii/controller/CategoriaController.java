package com.cibertec.dswii.controller;

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

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CategoriaController {
	
	
	@GetMapping("/listadoCategorias")
    public String inicio2(Model model){
        
       String apiUrl = "http://localhost:8088/categoria/list";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Categoria[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Categoria[].class);
        Categoria[] categorias = response.getBody();
     
        model.addAttribute("categorias", categorias);
        return "index_Categorias";
    }
	
	@GetMapping("/agregar")
	public String guardar(Categoria categoria, Model model) {
		String apiUrl = "http://localhost:8088/categoria/list";
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Categoria[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Categoria[].class);
        Categoria[] categorias = response.getBody();
     
        
          model.addAttribute("categorias",categorias);
		return "editar_Categoria";
	}
	
	@PostMapping("/guardar")
    public String guardar(Categoria x){
    //invocas al metodo de guardado, pero esto necesita   categoriaservice.guardarCategoria(x);
       
		String apiUrlSave = "http://localhost:8088/categoria/save";
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.postForObject(apiUrlSave, x, Void.class);
	    
        return "redirect:/listadoCategorias";
    }
	
	@GetMapping("/editar/{cod_categoria}") 
    public String editarCategoria(@PathVariable("cod_categoria")int id, Model model){
		
		String apiUrl = "http://localhost:8088/categoria/list/"+id;
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Categoria> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Categoria.class);
        //se omiten los corchetes debido a que el registro encontrado SIEMPRE VA SER UNO SOLO
        Categoria categoria = response.getBody();
            model.addAttribute("categoria",categoria);
       
       
        return "editar_Categoria";
    }
	
//  categoria= categoriaservice.encontrarCategoria(categoria);
	
	@GetMapping("/eliminar/{cod_categoria}")
    public String eliminar(@PathVariable("cod_categoria") Categoria categoria){
       String apiUrl = "http://localhost:8088/categoria/delete/" + categoria.getCod_categoria();  
      RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(apiUrl);
        return "redirect:/listadoCategorias";
        
    }
}
