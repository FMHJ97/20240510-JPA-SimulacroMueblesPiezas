package mueblesPiezas.controller;

import mueblesPiezas.model.Carpintero;

public class ControladorCarpinteroJPA extends SuperControladorJPA {
	
	public ControladorCarpinteroJPA() {
		super("carpintero", Carpintero.class);
	}

	private static ControladorCarpinteroJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorCarpinteroJPA getInstance() {
		if (instance == null) {
			instance = new ControladorCarpinteroJPA();
		}
		return instance;
	}
	
}
