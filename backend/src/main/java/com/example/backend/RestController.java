package com.example.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.backend.controlador.Controlador;
import org.springframework.web.bind.annotation.RequestParam;

import negocio.Persona;
import view.PersonaView;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private Controlador controlador;
	
	
	@CrossOrigin(origins = "http://localhost:3000") //Es el puerto del front
	@GetMapping("/getPersonas") 
	public List<PersonaView> getPersonas() {
		return controlador.getPersonas();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public String getHolaMundo() {
		return "Hola Mundo";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getPersonasFiltro")
	public List<PersonaView> getPersonasFiltro(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "edad") Integer edad) {
		return controlador.getPersonasFiltro(nombre, edad);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addPersona")
	public void persistirPersona(@RequestBody PersonaView persona) {
		Persona p = persona.toModelo();
		Controlador.getInstancia().persistirPersona(p);
	}
}
