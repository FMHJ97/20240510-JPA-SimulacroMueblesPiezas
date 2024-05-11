package mueblesPiezas.controller;

import mueblesPiezas.model.Tipomueble;

public class ControladorTipoMuebleJPA extends SuperControladorJPA {
	
	public ControladorTipoMuebleJPA() {
		super("tipomueble", Tipomueble.class);
	}

	private static ControladorTipoMuebleJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipoMuebleJPA getInstance() {
		if (instance == null) {
			instance = new ControladorTipoMuebleJPA();
		}
		return instance;
	}
	
}
