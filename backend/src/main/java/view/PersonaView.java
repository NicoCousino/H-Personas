package view;

import java.io.Serializable;
import java.sql.Date;

import negocio.Persona;

public class PersonaView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5628874708853802659L;
	private Integer idPersona;
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Date fechaNacimiento;


	public PersonaView() {}
	
	
	public PersonaView(Integer idPersona, String nombre, String apellido, String direccion, Integer edad, Date fechaNacimiento) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento; 
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String toString() {
		return idPersona + "-" + nombre + "-" + apellido;
		
	}
	public Persona toModelo() {
		return new Persona(idPersona, nombre, apellido, direccion, edad, fechaNacimiento);
		
	}
}
