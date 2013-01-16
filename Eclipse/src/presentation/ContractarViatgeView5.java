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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContractarViatgeView5 extends ContractarViatgeViewTemplate {
	//protected JTextField messageArea;

	/**
	 * Create the panel.
	 */
	public ContractarViatgeView5() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblVolsReservarUna = new JLabel("El pagament s'ha realitzat correctament.");
		lblVolsReservarUna.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblVolsReservarUna);
		
		Component verticalGlue = Box.createVerticalGlue();
		panel.add(verticalGlue);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel.add(verticalGlue_1);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ContractarViatgeController.getInstance().prOkMissatgeFi();
				
			}
		});
		panel_1.add(btnOk);
		
		//messageArea = new JTextField();
		//messageArea.setEditable(false);
		add(messageArea, BorderLayout.SOUTH);
		//messageArea.setColumns(10);

	}

}
