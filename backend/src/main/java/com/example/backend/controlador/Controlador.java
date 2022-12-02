package com.example.backend.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import dao.PersonaDAO;
import negocio.Persona;
import view.PersonaView;

@Controller
public class Controlador {
	
	private static Controlador instancia;
	
	private Controlador() {}
	
	public static Controlador getInstancia() {
		if(instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}
	
	public List<PersonaView> getPersonas(){
		List<PersonaView> personasView = new ArrayList<PersonaView>();
		List<Persona> personas = PersonaDAO.getInstacia().getPersonas();
		for (Persona p : personas) {
			personasView.add(p.toView());
		}
		
		return personasView;
	}

	public List<PersonaView> getPersonasFiltro(String nombre, Integer edad){
		List<PersonaView> personasView = new ArrayList<PersonaView>();
		List<Persona> personas = PersonaDAO.getInstacia().getPersonasFiltro(nombre, edad);
		for (Persona p : personas) {
			personasView.add(p.toView());
		}
		return personasView;
	}
	
	public void persistirPersona(Persona persona) {
		PersonaDAO.getInstacia().persistirPersona(persona);
	} 
}
