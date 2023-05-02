package com.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ejercicio.dto.Facultad;
import com.ejercicio.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;  
	
	@GetMapping("/Facultad")
	public List<Facultad> listarFacultad(){
		return facultadServiceImpl.listarFacultads();
	}
	
	
	@PostMapping("/Facultad")
	public Facultad salvarFacultad(@RequestBody Facultad Facultad) {
		
		return facultadServiceImpl.guardarFacultad(Facultad);
	}
	
	
	@GetMapping("/Facultad/{id}")
	public Facultad FacultadXID(@PathVariable(name="id") int id) {
		
		Facultad Facultad_xid= new Facultad();
		
		Facultad_xid=facultadServiceImpl.FacultadXID(id);
		
		System.out.println("Facultad XID: "+Facultad_xid);
		
		return Facultad_xid;
	}
	
	@PutMapping("/Facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="id")int id,@RequestBody Facultad Facultad) {
		
		Facultad Facultad_seleccionado= new Facultad();
		Facultad Facultad_actualizado= new Facultad();
		
		Facultad_seleccionado= facultadServiceImpl.FacultadXID(id);
		
		
		Facultad_seleccionado.setNombre(Facultad.getNombre());

		Facultad_actualizado = facultadServiceImpl.actualizarFacultad(Facultad_seleccionado);
		
		System.out.println("El Facultad actualizado es: "+ Facultad_actualizado);
		
		return Facultad_actualizado;
	}
	
	@DeleteMapping("/Facultad/{id}")
	public void eleiminarFacultad(@PathVariable(name="id")int id) {
		facultadServiceImpl.eliminarFacultad(id);
	}
	
}