package mueblesPiezas.controller;

import mueblesPiezas.model.Pieza;

public class ControladorPiezaJPA extends SuperControladorJPA {
	
	public ControladorPiezaJPA() {
		super("pieza", Pieza.class);
	}

	private static ControladorPiezaJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorPiezaJPA getInstance() {
		if (instance == null) {
			instance = new ControladorPiezaJPA();
		}
		return instance;
	}
	
}
