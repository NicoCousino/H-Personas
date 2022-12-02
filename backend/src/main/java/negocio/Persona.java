package negocio;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import view.PersonaView;

@Entity
@Table(name = "personas")
public class Persona {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;
	
	public Persona() {}
	
	public Persona(Integer idPersona, String nombre, String apellido, String direccion, Integer edad, Date fechaNacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Date fechaNacimiento;
	
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
	
	public boolean nacidaBisiesto() {
		
		if ((fechaNacimiento.getYear() % 4 == 0 && fechaNacimiento.getYear() % 100 != 0) || fechaNacimiento.getYear() % 400 == 0 ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String toString() {
		return idPersona + "-" + nombre + "-" + apellido;
		
	}
	
	public PersonaView toView() {
		return new PersonaView(idPersona, nombre, apellido, direccion, edad, fechaNacimiento);
	}
}
