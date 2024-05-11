package mueblesPiezas.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipomueble database table.
 * 
 */
@Entity
@Table(name="tipomueble")
@NamedQuery(name="Tipomueble.findAll", query="SELECT t FROM Tipomueble t")
public class Tipomueble extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String descripcion;

	public Tipomueble() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}