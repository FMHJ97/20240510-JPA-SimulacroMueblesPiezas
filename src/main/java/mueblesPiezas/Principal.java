package mueblesPiezas;

import javax.swing.JFrame;

import mueblesPiezas.utils.Apariencia;
import mueblesPiezas.view.PanelPieza;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * Constructor.
	 */
	public Principal() {
		super("Simulacro Examen - Muebles y Piezas");
		
		this.setBounds(100, 100, 700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		PanelPieza panelPieza = new PanelPieza();
		
		this.getContentPane().add(panelPieza);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}

}
