package presentation;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

import utility.Pair;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import java.awt.Choice;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.event.ListDataListener;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContractarViatgeView3_2 extends ContractarViatgeViewTemplate {
	//private JTextField messageArea;
	JComboBox comboBox;

	public ContractarViatgeView3_2(HashSet<Pair<String, Float>> hotels, String dniCl, Date dataIni, Date dataFi) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("DNI client:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel);
		
		
		JLabel lblDni = new JLabel(dniCl);
		panel_2.add(lblDni);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		
		JLabel lblNewLabel_1 = new JLabel("Data inici (dd/mm/aaaa):");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblDataIni = new JLabel(dateFormat.format(dataIni)); //TODO: revisar a veure si ho posa be
		panel_2.add(lblDataIni);
		
		JLabel lblNewLabel_2 = new JLabel("Data tornada (dd/mm/aaaa):");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblDataFi = new JLabel(dateFormat.format(dataFi)); //TODO: revisar a veure si ho posa be
		panel_2.add(lblDataFi);
		
		JLabel lblNewLabel_3 = new JLabel("Hotel:");
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_3);
		
		String[] h = new String[hotels.size()];
		int i=0;
		for (Pair<String, Float> c : hotels) {
			h[i++] = (c.getFirst() + " " + c.getSecond().toString()+"e");
			
		}
		comboBox = new JComboBox(h);
		panel_2.add(comboBox);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"hola", "Barcelona 2300", "Los Angeles 1555"}));
		
		Component rigidArea = Box.createRigidArea(new Dimension(0, 27));
		panel_2.add(rigidArea);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String hotelIPreu = (String) comboBox.getSelectedItem();
				String hotel = hotelIPreu.substring(0, hotelIPreu.lastIndexOf(" "));
				
				ContractarViatgeController.getInstance().prOkReserva(hotel);
			}
		});
		panel_4.add(btnOk);
		
		JButton btnCancella = new JButton("Cancel.la");
		btnCancella.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContractarViatgeController.getInstance().prCancelaReserva();				
			}
		});
		panel_4.add(btnCancella);
		
		
		//messageArea = new JTextField();
		//messageArea.setEditable(false);
		//messageArea.setText("");
		add(messageArea, BorderLayout.SOUTH);
		//messageArea.setColumns(10);

	}


}
