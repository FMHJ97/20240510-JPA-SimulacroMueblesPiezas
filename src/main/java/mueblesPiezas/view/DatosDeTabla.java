package mueblesPiezas.view;

import java.util.List;

import mueblesPiezas.controller.ControladorMuebleJPA;
import mueblesPiezas.model.Mueble;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "Serie", "Color"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		
		@SuppressWarnings("unchecked")
		List<Mueble> muebles = (List<Mueble>) ControladorMuebleJPA
			.getInstance().findAll();
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[muebles.size()][4];
		
		for (int i = 0; i < muebles.size(); i++) {
			Mueble m = muebles.get(i);
			
			datos[i][0] = m.getId();
			datos[i][1] = m.getNombre();
			datos[i][2] = m.getSerie();
			datos[i][3] = m.getColor();
		}
		
		return datos;
	}
	
	
}
