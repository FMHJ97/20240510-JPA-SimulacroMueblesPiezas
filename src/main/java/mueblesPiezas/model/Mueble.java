package mueblesPiezas.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mueble database table.
 * 
 */
@Entity
@Table(name="mueble")
@NamedQuery(name="Mueble.findAll", query="SELECT m FROM Mueble m")
public class Mueble extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String color;

	private int idCarpintero;

	private int idDistribuidor;

	private int idTipoMueble;

	private String nombre;

	private String serie;

	public Mueble() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getIdCarpintero() {
		return this.idCarpintero;
	}

	public void setIdCarpintero(int idCarpintero) {
		this.idCarpintero = idCarpintero;
	}

	public int getIdDistribuidor() {
		return this.idDistribuidor;
	}

	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public int getIdTipoMueble() {
		return this.idTipoMueble;
	}

	public void setIdTipoMueble(int idTipoMueble) {
		this.idTipoMueble = idTipoMueble;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

}