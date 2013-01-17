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
import java.util.Locale;

import javax.swing.Box;
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
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContractarViatgeView2 extends ContractarViatgeViewTemplate {
	private JTextField textDni;
	private JTextField textDataIni;
	private JTextField textDataFi;
	//private JTextField messageArea;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public ContractarViatgeView2(HashSet<Pair<String, Float>> cjCiutats) {
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
		
		textDni = new JTextField();
		panel_2.add(textDni);
		textDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data inici (dd/mm/aaaa):");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_1);
		
		textDataIni = new JTextField();
		panel_2.add(textDataIni);
		textDataIni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data tornada (dd/mm/aaaa):");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_2);
		
		textDataFi = new JTextField();
		panel_2.add(textDataFi);
		textDataFi.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ciutat de desti:");
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_3);
		
		
		String[] ciutats = new String[cjCiutats.size()];
		int i = 0;
		for (Pair<String, Float> c : cjCiutats) {
			ciutats[i++] = (c.getFirst() + " " + c.getSecond().toString() + "€");
		}
		comboBox = new JComboBox(ciutats);
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
				String ciutatIPreu = (String) comboBox.getSelectedItem();
				String ciutat = ciutatIPreu.substring(0, ciutatIPreu.lastIndexOf(" "));
				String dniCl = textDni.getText();
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String tDataIni = textDataIni.getText();
				Date dataIni = null;
				try {
					dataIni = dateFormat.parse(tDataIni);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					messageArea.setText("Format de la data d'inici incorrecte");
					
				}
				String tDataFi = textDataFi.getText();
				Date dataFi = null;
				try {
					dataFi = dateFormat.parse(tDataFi);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					messageArea.setText("Format de la data de tornada incorrete");
				}
				
				ContractarViatgeController.getInstance().prOkAssignaViatge(ciutat, dniCl, dataIni, dataFi);
			}
		});
		panel_4.add(btnOk);
		
		JButton btnCancella = new JButton("Cancel.la");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContractarViatgeController.getInstance().prCancela();
			}
		});
		panel_4.add(btnCancella);
			
		
		//messageArea = new JTextField();
		//messageArea.setEditable(false);
		add(messageArea, BorderLayout.SOUTH);
		//messageArea.setColumns(10);

	}


}
