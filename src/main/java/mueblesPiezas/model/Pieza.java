package mueblesPiezas.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pieza database table.
 * 
 */
@Entity
@Table(name="pieza")
@NamedQuery(name="Pieza.findAll", query="SELECT p FROM Pieza p")
public class Pieza extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int cantidad;

	private int idMueble;

	private String nombre;

	public Pieza() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdMueble() {
		return this.idMueble;
	}

	public void setIdMueble(int idMueble) {
		this.idMueble = idMueble;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}