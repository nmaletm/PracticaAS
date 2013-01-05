package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Date;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utility.Pair;

public class ContractarViatgeFrame extends JFrame {

	private ContractarViatgeViewTemplate contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractarViatgeFrame frame = new ContractarViatgeFrame();
					frame.setTitle("Contractar viatge");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContractarViatgeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ContractarViatgeView1();
		setMinimumSize(new Dimension(300, 200));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

	
	public void mostraMissatge(String missatge) {
		contentPane.mostraMissatge(missatge);
	}
	
	public void mostraCiutats(HashSet<Pair<String, Float>> cjCiutats) {

		contentPane = new ContractarViatgeView2(cjCiutats);
		//setContentPane(contentPane);
	}
	
	public void preguntaReservaHabitacio() {
		//TODO	
		
	}
	
	public void mostraHotelsCiutat(HashSet<Pair<String,Float>> hotels, String dniCl, Date dataIni, Date dataFi) {
		//TODO
	}
	
	public void mostraPagarViatge(String dniCl, Float preuTotal) {
		//TODO
	}
	
	public void mostraMissatgeFi() {
		//TODO
	}
	
	public void tancar() {
		//TODO
	}
	

}
