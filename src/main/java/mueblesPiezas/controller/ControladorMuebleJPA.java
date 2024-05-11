package mueblesPiezas.controller;

import mueblesPiezas.model.Mueble;

public class ControladorMuebleJPA extends SuperControladorJPA {
	
	public ControladorMuebleJPA() {
		super("mueble", Mueble.class);
	}

	private static ControladorMuebleJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorMuebleJPA getInstance() {
		if (instance == null) {
			instance = new ControladorMuebleJPA();
		}
		return instance;
	}
	
}
