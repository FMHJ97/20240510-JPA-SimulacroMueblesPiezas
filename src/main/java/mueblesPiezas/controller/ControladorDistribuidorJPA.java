package mueblesPiezas.controller;

import mueblesPiezas.model.Distribuidor;

public class ControladorDistribuidorJPA extends SuperControladorJPA {
	
	public ControladorDistribuidorJPA() {
		super("distribuidor", Distribuidor.class);
	}

	private static ControladorDistribuidorJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorDistribuidorJPA getInstance() {
		if (instance == null) {
			instance = new ControladorDistribuidorJPA();
		}
		return instance;
	}
	
}
