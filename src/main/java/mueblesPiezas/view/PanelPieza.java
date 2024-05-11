package mueblesPiezas.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import mueblesPiezas.controller.ControladorMuebleJPA;
import mueblesPiezas.controller.ControladorPiezaJPA;
import mueblesPiezas.model.Mueble;
import mueblesPiezas.model.Pieza;

public class PanelPieza extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTable table;
	private JSlider slider;
	private JLabel lbCantidad;
	private DefaultTableModel dtm = null;
	private Object datosTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosTabla[] = DatosDeTabla.getTitulosColumnas();

	/**
	 * Create the panel.
	 */
	public PanelPieza() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showFirst();
			}
		});
		btnFirst.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/gotostart.png")));
		toolBar.add(btnFirst);
		
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPrevious();
			}
		});
		btnPrevious.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/previous.png")));
		toolBar.add(btnPrevious);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNext();
			}
		});
		btnNext.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/next.png")));
		toolBar.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showLast();
			}
		});
		btnLast.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/gotoend.png")));
		toolBar.add(btnLast);
		
		JButton btnNew = new JButton("Nuevo");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newEntry();
			}
		});
		btnNew.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/nuevo.png")));
		toolBar.add(btnNew);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveEntry();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, 
							"No se ha podido realizar el guardado");
					ex.printStackTrace();
				}
			}
		});
		btnSave.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/guardar.png")));
		toolBar.add(btnSave);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEntry();
			}
		});
		btnDelete.setIcon(new ImageIcon(PanelPieza.class.getResource("/mueblesPiezas/res/eliminar.png")));
		toolBar.add(btnDelete);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de Piezas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 20, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		slider = new JSlider(0,10,0);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lbCantidad.setText(
						slider.getValue() + " Unidades");
			}
		});
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(10, 0, 10, 5);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 3;
		panel.add(slider, gbc_slider);
		
		lbCantidad = new JLabel("Unidades");
		lbCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lbCantidad = new GridBagConstraints();
		gbc_lbCantidad.insets = new Insets(0, 0, 5, 10);
		gbc_lbCantidad.gridx = 2;
		gbc_lbCantidad.gridy = 3;
		panel.add(lbCantidad, gbc_lbCantidad);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mueble:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_3_1.insets = new Insets(10, 0, 0, 5);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 4;
		panel.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(10, 0, 20, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		panel.add(scrollPane, gbc_scrollPane);
		
		JButton btnVerMueble = new JButton("Ver Mueble");
		btnVerMueble.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnVerMueble = new GridBagConstraints();
		gbc_btnVerMueble.insets = new Insets(10, 0, 0, 10);
		gbc_btnVerMueble.gridx = 2;
		gbc_btnVerMueble.gridy = 4;
		panel.add(btnVerMueble, gbc_btnVerMueble);

		/*
		 * Precarga de Datos Y Componentes
		 */
		
		// Inicializamos el DefaultTableModel.
		this.dtm = getDefaultTableModel();
		// Creo la tabla utilizando el DefaultTableModel.
		this.table = new JTable(dtm);
		// Limitamos el modo selección de filas a una única selección.
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		// Agregamos la tabla al ScrollPane.
		scrollPane.setViewportView(table);
		
		// Mostramos el primer posible registro.
		showFirst();
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isCantidadValid() {
		int valor = this.slider.getValue();

		if (valor != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Comprobamos si el nombre está vacío.
	 * @return True or False.
	 */
	private boolean isNameValid() {
		String strName = this.jtfNombre.getText();

		if (!strName.isBlank()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	private void saveEntry() {
		
		/*
		 * Validaciones
		 */
		if (!isNameValid()) {
			JOptionPane.showMessageDialog(null, 
					"El nombre no debe estar vacío");
			return;
		}
		
		Pieza p = new Pieza();
		
		p.setNombre(this.jtfNombre.getText());
		p.setCantidad(this.slider.getValue());
		
		// Procedemos a obtener el Objeto Mueble de la fila seleccionada.
		int indexRow = this.table.getSelectedRow();
		if (indexRow != -1) {
			Integer idCelda = (Integer) this.dtm.getValueAt(indexRow, 0);
			Mueble m = (Mueble) ControladorMuebleJPA
					.getInstance().findById(idCelda);
			// Asignamos el id del Objeto Mueble.
			p.setIdMueble(m.getId());
		} else {
			JOptionPane.showMessageDialog(null, 
					"Seleccione un mueble de la tabla");
			return;
		}
		
		// Comprobamos si debemos realizar un Insert o Update.
		String strId = this.jtfId.getText();
		if (strId.isBlank()) {
			ControladorPiezaJPA.getInstance().insertEntidad(p);
			JOptionPane.showMessageDialog(null, 
					"Registro creado con éxito");
		} else {
			int idActual = Integer.parseInt(strId);
			p.setId(idActual);
			ControladorPiezaJPA.getInstance().updateEntidad(p);
			JOptionPane.showMessageDialog(null, 
					"Registro actualizado con éxito");
		}
		
		// Mostramos el registro.
		showEntry(p);
	}
	
	/**
	 * Método que pregunta al usuario si desea eliminar 
	 * el registro actual de la BBDD. En caso afirmativo, 
	 * se mostrará el posible registro anterior o posterior.
	 */
	private void deleteEntry() {
		String respuestas[] = new String[] { "Sí", "No" };
		int opcionElegida = JOptionPane.showOptionDialog(null,
				"¿Realmente desea eliminar el registro actual?",
				"Eliminación de Registro", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null,
				respuestas, respuestas[1]);
		
		// Puntero para seleccionar el posible siguiente o anterior
		// registro a mostrar.
		Pieza actual = null;

		if (opcionElegida == 0) {	// Si la opción es 0 (= Si).
			
			String str = this.jtfId.getText();
			if (!str.trim().equals("")) {
				int idActual = Integer.parseInt(str);
				// Eliminamos el registro.
				ControladorPiezaJPA.getInstance().removeEntidad(
						ControladorPiezaJPA.getInstance().findById(idActual));
				
				// A continuación, mostraremos en pantalla el registro
				// siguiente.
				actual = (Pieza) ControladorPiezaJPA
						.getInstance().findNext(idActual);
				
				// Si hay registro, es decir, el registro borrado es
				// ocupado por su siguiente registro (id).
				if (actual != null) {
					showEntry(actual);
				} else {
					// Si hay no registro, miramos si hay registro anterior
					// al registro borrado.
					actual = (Pieza) ControladorPiezaJPA
							.getInstance().findPrevious(idActual);
					if (actual != null) {
						showEntry(actual);
					} else {
						// Llegados a este punto, no hay registros previos
						// ni posteriores.
						newEntry();
					}
					
				}
			}
		}
	}
	
	/**
	 * Método que vacía todos los campos para poder insertar 
	 * un nuevo registro.
	 */
	private void newEntry() {
		this.jtfId.setText("");
		this.jtfNombre.setText("");
		this.slider.setValue(0);
		this.table.clearSelection();
	}
	
	/**
	 * Método que devuelve el posible registro anterior.
	 */
	private void showNext() {
		String strId = this.jtfId.getText();
		if (!strId.isBlank()) {
			int idActual = Integer.parseInt(strId);
			Pieza p = (Pieza) ControladorPiezaJPA
					.getInstance().findNext(idActual);
			showEntry(p);
		}
	}
	
	/**
	 * Método que devuelve el posible registro anterior.
	 */
	private void showPrevious() {
		String strId = this.jtfId.getText();
		if (!strId.isBlank()) {
			int idActual = Integer.parseInt(strId);
			Pieza p = (Pieza) ControladorPiezaJPA
					.getInstance().findPrevious(idActual);
			showEntry(p);
		}
	}
	
	/**
	 * Muestra el último registro de la tabla BBDD pieza.
	 */
	private void showLast() {
		Pieza p = (Pieza) ControladorPiezaJPA
				.getInstance().findLast();
		showEntry(p);
	}
	
	/**
	 * Muestra el posible primer registro de la tabla BBDD pieza.
	 */
	private void showFirst() {
		Pieza p = (Pieza) ControladorPiezaJPA
				.getInstance().findFirst();
		showEntry(p);
	}
	
	/**
	 * Muestra en pantalla la información de un Objeto Pieza.
	 * @param p Objeto Pieza.
	 */
	private void showEntry(Pieza p) {
		if (p != null) {
			this.jtfId.setText("" + p.getId());
			
			if (p.getNombre() != null) {
				this.jtfNombre.setText(p.getNombre());
			} else {
				this.jtfNombre.setText("");
			}
			
			if (p.getCantidad() >= 1 && p.getCantidad() <= 10) {
				this.slider.setValue(p.getCantidad());
			} else {
				this.slider.setValue(0);
			}
			
			// Seleccionamos la correspondiente fila de la tabla.
			selectRowById(p);
		}
	}
	
	/**
	 * Selecciona en la tabla la fila correspondiente al 
	 * registro actual de Pieza (idMueble).
	 * @param p Objeto Pieza
	 */
	public void selectRowById(Pieza p) {
		for (int i = 0; i < this.dtm.getRowCount(); i++) {
			Integer idCell = (Integer) this.dtm.getValueAt(i, 0);
			if (idCell == p.getIdMueble()) {
				this.table.setRowSelectionInterval(i, i);
			}
		}
	}
	
	/**
	 * Obtenemos el modelo de la tabla.
	 * @return
	 */
	private DefaultTableModel getDefaultTableModel() {
		// Inicializamos el modelo de la tabla.
		DefaultTableModel dtm = 
				new DefaultTableModel(datosTabla, titulosTabla) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		return dtm;
	}
	
}
