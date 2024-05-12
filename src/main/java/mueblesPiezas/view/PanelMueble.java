package mueblesPiezas.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import mueblesPiezas.controller.ControladorCarpinteroJPA;
import mueblesPiezas.controller.ControladorDistribuidorJPA;
import mueblesPiezas.controller.ControladorMuebleJPA;
import mueblesPiezas.model.Carpintero;
import mueblesPiezas.model.Distribuidor;
import mueblesPiezas.model.Mueble;

public class PanelMueble extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfSerie;
	private JTextField jtfColor;
	private JComboBox<Distribuidor> jcbDistribuidor;
	private JScrollPane jspLista;
	private JList<Carpintero> list;
	private JRadioButton jrbMesitaNoche;
	private JRadioButton jrbMesa;
	private JRadioButton jrbSilla;
	private Mueble selectedMueble;
	private JColorChooser jColorChooser;
	private Color colorPanel;
	private DefaultListModel<Carpintero> dlm = null;
	private DefaultTableModel dtm;
	private JTable tablePieza;

	/**
	 * Create the panel.
	 * @param tableP 
	 */
	public PanelMueble(Mueble m, DefaultTableModel dtm, JTable tablePieza) {
		
		this.selectedMueble = m;
		this.dtm = dtm;
		this.tablePieza = tablePieza;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Muebles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 15, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Serie:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		jtfSerie = new JTextField();
		jtfSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfSerie.setColumns(10);
		GridBagConstraints gbc_jtfSerie = new GridBagConstraints();
		gbc_jtfSerie.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSerie.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSerie.gridx = 1;
		gbc_jtfSerie.gridy = 3;
		add(jtfSerie, gbc_jtfSerie);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Color:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 4;
		add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		jtfColor = new JTextField();
		jtfColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfColor.setEnabled(false);
		jtfColor.setColumns(10);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 4;
		add(jtfColor, gbc_jtfColor);
		
		JButton btnSelectColor = new JButton("Seleccionar Color");
		btnSelectColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectColor();
			}
		});
		btnSelectColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSelectColor = new GridBagConstraints();
		gbc_btnSelectColor.insets = new Insets(0, 0, 5, 10);
		gbc_btnSelectColor.gridx = 2;
		gbc_btnSelectColor.gridy = 4;
		add(btnSelectColor, gbc_btnSelectColor);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Tipo de Mueble:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(20, 10, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 5;
		add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);
		
		JPanel panelGButtons = new JPanel();
		GridBagConstraints gbc_panelGButtons = new GridBagConstraints();
		gbc_panelGButtons.insets = new Insets(20, 0, 5, 5);
		gbc_panelGButtons.fill = GridBagConstraints.BOTH;
		gbc_panelGButtons.gridx = 1;
		gbc_panelGButtons.gridy = 5;
		add(panelGButtons, gbc_panelGButtons);
		panelGButtons.setLayout(new BoxLayout(panelGButtons, BoxLayout.Y_AXIS));
		
		jrbMesitaNoche = new JRadioButton("Mesita de noche");
		jrbMesitaNoche.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelGButtons.add(jrbMesitaNoche);
		
		jrbMesa = new JRadioButton("Mesa");
		jrbMesa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelGButtons.add(jrbMesa);
		
		jrbSilla = new JRadioButton("Silla");
		jrbSilla.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelGButtons.add(jrbSilla);
		
		/*
		 * Button Group
		 */
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbMesitaNoche);
		bg.add(jrbMesa);
		bg.add(jrbSilla);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Distribuidor:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(20, 0, 20, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 6;
		add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);
		
		jcbDistribuidor = new JComboBox<Distribuidor>();
		jcbDistribuidor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jcbDistribuidor = new GridBagConstraints();
		gbc_jcbDistribuidor.insets = new Insets(20, 0, 20, 5);
		gbc_jcbDistribuidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbDistribuidor.gridx = 1;
		gbc_jcbDistribuidor.gridy = 6;
		add(jcbDistribuidor, gbc_jcbDistribuidor);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Carpintero:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1_1_1_1_1_1_1.insets = new Insets(0, 0, 20, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridy = 7;
		add(lblNewLabel_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1);
		
		JPanel panelLista = new JPanel();
		GridBagConstraints gbc_panelLista = new GridBagConstraints();
		gbc_panelLista.insets = new Insets(0, 0, 20, 5);
		gbc_panelLista.fill = GridBagConstraints.BOTH;
		gbc_panelLista.gridx = 1;
		gbc_panelLista.gridy = 7;
		add(panelLista, gbc_panelLista);
		panelLista.setLayout(new BorderLayout(0, 0));
		
		jspLista = new JScrollPane();
		panelLista.add(jspLista, BorderLayout.CENTER);
		
		// Inicializamos la lista con el modelo.
		list = new JList<Carpintero>(this.getDefaultListModel());
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jspLista.setViewportView(list);
		
		JButton btnGuardar = new JButton("Guardar Mueble");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					updateEntry();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, 
							"No se ha podido realizar el guardado");
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 20, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 8;
		add(btnGuardar, gbc_btnGuardar);

		/*
		 * Precarga de Datos
		 */
		loadAllDistribuidores();
		loadAllCarpinteros();
		
		showEntryMueble();
	}
	
	/**
	 * 
	 */
	private void updateEntry() {
		
		/*
		 * Validaciones.
		 */
		
		Mueble m = new Mueble();
		
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setNombre(this.jtfNombre.getText());
		m.setSerie(this.jtfSerie.getText());
		
		// Guardamos el color.
		if (!this.jtfColor.getText().isBlank()) {
			m.setColor(this.jtfColor.getText());
		} else {
			m.setColor(null);
		}
		
		// Guardamos el JRadioButton seleccionado.
		if (this.jrbMesitaNoche.isSelected()) {
			m.setIdTipoMueble(1);
		} else if (this.jrbMesa.isSelected()) {
			m.setIdTipoMueble(2);
		} else {
			m.setIdTipoMueble(3);
		}
		
		// Guardamos el id del Objeto Distribuidor seleccionado
		// en el JComboBox.
		m.setIdDistribuidor(
			((Distribuidor) this.jcbDistribuidor.getSelectedItem())
				.getId());
		
		// Guardamos el carpintero de la lista seleccionado.
		if (this.list.getSelectedValue() != null) {
			m.setIdCarpintero(
					this.list.getSelectedValue().getId());
		} else {
			JOptionPane.showMessageDialog(null, 
					"Seleccione un carpintero de la lista");
			return;
		}
		
		ControladorMuebleJPA.getInstance().updateEntidad(m);
		
		JOptionPane.showMessageDialog(null, 
				"El registro actual ha sido actualizado correctamente");
		
		// Actualizamos los datos de la tabla del panel PanelPieza.
		this.dtm.setDataVector(DatosDeTabla.getDatosDeTabla(),
				DatosDeTabla.getTitulosColumnas());
		this.dtm.fireTableDataChanged();
		// Seleccionamos el registro correspondiente al Mueble actual
		// en la tabla del panel PanelPieza.
		for (int i = 0; i < this.dtm.getRowCount(); i++) {
			Integer idCell = (Integer) this.dtm.getValueAt(i, 0);
			if (idCell == selectedMueble.getId()) {
				this.tablePieza.setRowSelectionInterval(i, i);
			}
		}
		
	}
	
	/**
	 * Mostramos la información del mueble seleccionado en el 
	 * panel panelPieza.
	 */
	private void showEntryMueble() {
		if (selectedMueble != null) {
			this.jtfId.setText("" + selectedMueble.getId());
			
			if (selectedMueble.getNombre() != null) {
				this.jtfNombre.setText(selectedMueble.getNombre());
			} else {
				this.jtfNombre.setText("");
			}
			
			if (selectedMueble.getSerie() != null) {
				this.jtfSerie.setText(selectedMueble.getSerie());
			} else {
				this.jtfSerie.setText("");
			}
			
			for (int i = 0; i < this.jcbDistribuidor.getItemCount(); i++) {
				if (this.jcbDistribuidor.getItemAt(i).getId()
						== selectedMueble.getIdDistribuidor()) {
					this.jcbDistribuidor.setSelectedIndex(i);
				}
			}
			
			int opcion = selectedMueble.getIdTipoMueble();
			switch (opcion) {
			case 1:
				this.jrbMesitaNoche.setSelected(true);
				break;
			case 2:
				this.jrbMesa.setSelected(true);
				break;
			case 3:
				this.jrbSilla.setSelected(true);
				break;
			}
			
			// Mostramos el posible color preferido del registro actual.
			try {
				if (selectedMueble.getColor() != null) {
					colorPanel = Color.decode(selectedMueble.getColor());
					this.jtfColor.setText(selectedMueble.getColor());
					this.setBackground(colorPanel);
				} else {
					this.setBackground(null);
					this.jtfColor.setText("");
				}
			} catch (NumberFormatException e) {
				this.setBackground(null);
				this.jtfColor.setText("");
			}
			
			for (int i = 0; i < this.dlm.size(); i++) {
				if (selectedMueble.getIdCarpintero()
						== this.dlm.getElementAt(i).getId()) {
					this.list.setSelectedIndex(i);
				}
			}
			
		}
	}
	
	/**
	 * Carga todos los carpinteros en el modelo de la JList.
	 */
	private void loadAllCarpinteros() {
		@SuppressWarnings("unchecked")
		List<Carpintero> carpinteros =
				(List<Carpintero>) ControladorCarpinteroJPA
					.getInstance().findAll();
		
		for (Carpintero carpintero : carpinteros) {
			this.dlm.addElement(carpintero);
		}
	}
	
	/**
	 * Carga todos los distribuidores en el JComboBox.
	 */
	private void loadAllDistribuidores() {
		@SuppressWarnings("unchecked")
		List<Distribuidor> distribuidores =
				(List<Distribuidor>) ControladorDistribuidorJPA
					.getInstance().findAll();
		
		for (Distribuidor distribuidor : distribuidores) {
			this.jcbDistribuidor.addItem(distribuidor);
		}
	}
	
	/**
	 * Seleccionamos un color gracias a JColorChooser.
	 */
	@SuppressWarnings("static-access")
	private void selectColor() {
		colorPanel = this.jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		if (colorPanel != null) {
			String strColor = "#"+Integer.toHexString(colorPanel.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.setBackground(colorPanel);;
		}
	}
	
	/**
	 * Inicializamos el modelo de la lista parametrizada.
	 * @return Modelo List
	 */
	private DefaultListModel<Carpintero> getDefaultListModel() {
		this.dlm = new DefaultListModel<Carpintero>();
		return this.dlm;
	}

}
