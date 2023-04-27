package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Producto;
import com.ejercicio.service.ProductoServiceImpl;



@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/Producto")
	public List<Producto> listarProducto(){
		return productoServiceImpl.listarProducto();
	}
	
	@PostMapping("/Producto")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}
	
	@GetMapping("/Producto/{codigoproductoproducto}")
	public Producto productoById(@PathVariable(name="codigoproductoproducto") int codigoproducto) {
		Producto producto= new Producto();
		producto=productoServiceImpl.productoById(codigoproducto);
		return producto;
	}
	
	@PutMapping("/Producto/{codigoproducto}")
	public Producto actualizarProducto(@PathVariable(name="codigoproducto")int codigoproducto,@RequestBody Producto producto) {
		
		Producto producto_seleccionado= new Producto();
		Producto producto_actualizado= new Producto();
		producto_seleccionado= productoServiceImpl.productoById(codigoproducto);
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_seleccionado.setVenta(producto.getVenta());
		
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/Producto/{codigoproducto}")
	public void eliminarProducto(@PathVariable(name="codigoproducto")int codigoproducto) {
		productoServiceImpl.eliminarProducto(codigoproducto);
	}

}
