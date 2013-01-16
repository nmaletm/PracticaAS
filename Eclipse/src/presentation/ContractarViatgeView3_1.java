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
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContractarViatgeView3_1 extends ContractarViatgeViewTemplate {
	//protected JTextField messageArea;

	/**
	 * Create the panel.
	 */
	public ContractarViatgeView3_1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblVolsReservarUna = new JLabel("Vols reservar una habitacio?");
		lblVolsReservarUna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblVolsReservarUna);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnSi = new JButton("Si");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContractarViatgeController.getInstance().prSiReservar();
			}
		});
		panel_1.add(btnSi);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContractarViatgeController.getInstance().prNoReservar();
			}
		});
		panel_1.add(btnNo);
		
		//messageArea = new JTextField();
		//messageArea.setEditable(false);
		add(messageArea, BorderLayout.SOUTH);
		//messageArea.setColumns(10);

	}
	
}
