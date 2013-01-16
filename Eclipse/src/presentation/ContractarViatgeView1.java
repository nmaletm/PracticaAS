package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ContractarViatgeView1 extends ContractarViatgeViewTemplate {
	//private JTextField messageArea;
	/**
	 * Create the panel.
	 */
	public ContractarViatgeView1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JButton btnContractarViatge = new JButton("Contractar viatge");
		btnContractarViatge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ContractarViatgeController.getInstance().prOkObteCiutats();

			}
		});
		panel.add(btnContractarViatge, "1, 14, fill, default");
		
		JButton btnCancellar = new JButton("Cancel.lar");
		btnCancellar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContractarViatgeController.getInstance().prCancela();
			}
		});
		panel.add(btnCancellar, "1, 20, fill, center");
		
		//messageArea = new JTextField();
		//messageArea.setEditable(false);
		//messageArea.setText("");
		add(messageArea, BorderLayout.SOUTH);
		//messageArea.setColumns(10);

	}
	
//	
//	public void mostraMissatge(String missatge) {
//		messageArea.setText(missatge);
//	}

}
