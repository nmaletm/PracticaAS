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
import java.util.HashSet;
import java.util.List;

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
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContractarViatgeView4 extends ContractarViatgeViewTemplate {
	//private JTextField messageArea;
	private JTextField textNumTar;
	private JTextField textCadTar;

	/**
	 * Create the panel.
	 */
	public ContractarViatgeView4(String dniCl, Float preuTotal) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Preu total:  ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPreu = new JLabel(preuTotal.toString()+"€");
		panel_1.add(lblPreu);
		
		JLabel lblNewLabel_1 = new JLabel("DNI client");
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblDni = new JLabel(dniCl);
		panel_2.add(lblDni);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de targeta de credit:");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_2);
		
		textNumTar = new JTextField();
		panel_2.add(textNumTar);
		textNumTar.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de caducitat de la targeta de credit (mm/aa):");
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblNewLabel_3);
		
		textCadTar = new JTextField();
		panel_2.add(textCadTar);
		textCadTar.setColumns(10);
		
		Component rigidArea = Box.createRigidArea(new Dimension(0, 27));
		panel_2.add(rigidArea);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DateFormat dateFormat = new SimpleDateFormat("MM/yy");
				try {
					ContractarViatgeController.getInstance().prOkPagarViatge(textNumTar.getText(), dateFormat.parse(textCadTar.getText()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					messageArea.setText("Format de la data de caducitat incorrete");
				}
				
			}
		});
		panel_4.add(btnOk);
		
		JButton btnCancella = new JButton("Cancel.la");
		btnCancella.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ContractarViatgeController.getInstance().prCancela();
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
