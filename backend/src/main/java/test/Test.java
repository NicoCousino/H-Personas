package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.controlador.Controlador;

import negocio.Persona;
import view.PersonaView;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*
		List<PersonaView> personas = new ArrayList<PersonaView>();
		//personas = Controlador.getInstancia().getPersonas();
		personas = Controlador.getInstancia().getPersonasFiltro("", -1);
		System.out.println();
		for (int i = 0; i<personas.size();i++) {
			System.out.println(personas.get(i).toString());
			}
		*/
		
		//TEST DE AÑO BISIESTO
		
		
		//Divisible por 4, por 100 y por 400
		Persona p = new Persona(1,"Nombre 1", "Apellido 1", "Direccion 1", 10, new Date(2000,11,10));
		System.out.println("Esperado: true | " + p.nacidaBisiesto());
		
		//No divisibles por 4
		p.setFechaNacimiento(new Date(2001,11,10));
		System.out.println("Esperado: false | " + p.nacidaBisiesto());
		p.setFechaNacimiento(new Date(2002,11,10));
		System.out.println("Esperado: false | " + p.nacidaBisiesto());
		p.setFechaNacimiento(new Date(2003,11,10));
		System.out.println("Esperado: false | " + p.nacidaBisiesto());
		p.setFechaNacimiento(new Date(1957,11,10));
		System.out.println("Esperado: false | " + p.nacidaBisiesto());
		
		
		//Divisibles por 4 y no por 100
		p.setFechaNacimiento(new Date(2004,11,10));
		System.out.println("Esperado: true | " + p.nacidaBisiesto());
		p.setFechaNacimiento(new Date(1956,11,10));
		System.out.println("Esperado: true | " + p.nacidaBisiesto());
		
		//Divisible por 4 y por 100 pero no por 400
		p.setFechaNacimiento(new Date(2100,11,10));
		System.out.println("Esperado: false | " + p.nacidaBisiesto());

	}

}
