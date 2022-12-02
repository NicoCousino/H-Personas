package dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.annotations.NamedNativeQuery;

import hibernate.HibernateUtil;
import negocio.Persona;


@NamedNativeQuery(
		  name = "getPersonasFiltro", 
		  query = "CALL getpersonasfiltro(:nombre, :edad)", 
		  resultClass = Persona.class
		)


public class PersonaDAO {
	
	private static PersonaDAO instancia;
	
	private PersonaDAO() {};
	
	public static PersonaDAO getInstacia() {
		if (instancia == null) {
			instancia = new PersonaDAO();
		}
		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> getPersonas(){
		List<Persona> resultado = new ArrayList<Persona>();
		Session s = HibernateUtil.getSessionFactory().openSession();
		
		s.beginTransaction();
		
		resultado = s.createQuery("from Persona").list();
		
		s.getTransaction().commit();
		s.close();
		
		return resultado;
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Persona> getPersonasFiltro(String nombre, Integer edad){
		List<Persona> resultado = new ArrayList<Persona>();
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();	
		//resultado = s.getNamedQuery("getPersonasFiltro").setParameter("nombre",nombre).setParameter("edad", edad).list();
		
		resultado = s.createSQLQuery("EXEC getPersonasFiltro :nombre, :edad").addEntity(Persona.class).setParameter("nombre",nombre).setParameter("edad", edad).list();
		s.getTransaction().commit();
		s.close();
		return resultado;
	}
	
	public void persistirPersona(Persona persona) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();	
		s.save(persona);
		s.getTransaction().commit();
		s.close();
		
	}
	
	
	

}
