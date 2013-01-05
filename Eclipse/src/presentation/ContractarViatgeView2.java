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
import java.util.HashSet;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import utility.Pair;

public class ContractarViatgeView2 extends ContractarViatgeViewTemplate {
	//private JTextField messageArea;

	/**
	 * Create the panel.
	 */
	public ContractarViatgeView2(HashSet<Pair<String, Float>> cjCiutats) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		DefaultListModel listModel = new DefaultListModel();
		
		//TODO: elements per mirar com es veu la llista
		cjCiutats.add(new Pair<String, Float>("Barcelona", (float) 100.0));
		cjCiutats.add(new Pair<String, Float>("Barcelona", (float) 100.0));
		cjCiutats.add(new Pair<String, Float>("Barcelona", (float) 100.0));
		cjCiutats.add(new Pair<String, Float>("Barcelona", (float) 100.0));
		cjCiutats.add(new Pair<String, Float>("Barcelona", (float) 100.0));
		cjCiutats.add(new Pair<String, Float>("Barcelona", (float) 100.0));
		
		
		for (Pair<String, Float> c : cjCiutats) {
			listModel.addElement(c.getFirst() + " " + c.getSecond().toString());
		}
		JList list = new JList(listModel);
		panel_1.add(list);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		
		//messageArea = new JTextField();
		//messageArea.setEditable(false);
		messageArea.setText("");
		add(messageArea, BorderLayout.SOUTH);
		//messageArea.setColumns(10);

	}


}
