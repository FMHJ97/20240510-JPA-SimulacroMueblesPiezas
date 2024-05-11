package mueblesPiezas.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the carpintero database table.
 * 
 */
@Entity
@Table(name="carpintero")
@NamedQuery(name="Carpintero.findAll", query="SELECT c FROM Carpintero c")
public class Carpintero extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String apellido1;

	private String apellido2;

	private String email;

	private String nombre;

	private String telefono;

	public Carpintero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}