	package com.curso.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Producto;
import com.curso.excepciones.GestionProductoException;
import com.curso.service.ProductoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" } , 
methods = {RequestMethod.GET, 
		RequestMethod.POST, 
		RequestMethod.DELETE, 
		RequestMethod.PUT,
		RequestMethod.OPTIONS})
public class ProductoRESTController {
	
	@Autowired
	private ProductoService service;
	
	/**
	 * devuelve la lista de todos los productos
	 */
	@GetMapping("/rest/productos")
	public List<Producto> listaProductos(){
		return service.getTodosProductos();
	}

	  @PostMapping("/rest/productos")
	  public  Producto nuevoProducto(@RequestBody Producto nuevoProducto) throws GestionProductoException {  
			return service.crearProducto(nuevoProducto);
	  }
	  
	  @GetMapping("/rest/productos/{id}")
	  public  Producto getProducto(@PathVariable String id) throws GestionProductoException {
	    
	    Producto producto = service.getProductoPorId(id);
	    if (producto == null) {
	    	throw new GestionProductoException(id, "Producto no encontrado");
	    }
	    return producto;
	  }
 
	//modificar
	  @PutMapping("/rest/productos/{id}")
	  public  Producto  modificarProdu(
			  @RequestBody Producto productoModificado, 
			  @PathVariable String id) throws GestionProductoException {
	    
	      return service.modificarProducto(productoModificado);
	  }
	  
	  @DeleteMapping("/rest/productos/{id}")
	  public void borrarProducto(@PathVariable String id) throws GestionProductoException {
		  service.borrarProducto(id);
	  }
	  
	
	
}
