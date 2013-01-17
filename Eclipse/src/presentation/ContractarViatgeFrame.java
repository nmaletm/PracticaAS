package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Date;
import java.util.HashSet;

import javax.swing.JFrame;

import utility.Pair;

public class ContractarViatgeFrame extends JFrame {

	private ContractarViatgeViewTemplate contentPane;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractarViatgeFrame frame = new ContractarViatgeFrame();
					frame.setTitle("Contractar viatge");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public void mostra() {
		setTitle("Contractar viatge");
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * Create the frame.
	 */
	public ContractarViatgeFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ContractarViatgeView1();
		setSize(300, 200);
		setContentPane(contentPane);
	}

	public void mostraInici(){
		canviPanel(new ContractarViatgeView1());
		setSize(300, 200);
	}
	
	public void mostraMissatge(String missatge) {
		contentPane.mostraMissatge(missatge);
		//repaint();
	}
	
	public void mostraCiutats(HashSet<Pair<String, Float>> cjCiutats) {
		canviPanel(new ContractarViatgeView2(cjCiutats));
		setSize(300,325);
	}
	
	public void preguntaReservaHabitacio() {
		canviPanel(new ContractarViatgeView3_1());
		setSize(300,200);
	}
	
	public void mostraHotelsCiutat(HashSet<Pair<String,Float>> hotels, String dniCl, Date dataIni, Date dataFi) {

		canviPanel(new ContractarViatgeView3_2(hotels, dniCl, dataIni, dataFi));
		setSize(300,325);
	}
	
	public void mostraPagarViatge(String dniCl, Float preuTotal) {

		canviPanel(new ContractarViatgeView4(dniCl, preuTotal));
		setSize(350,325);
	}
	
	public void mostraMissatgeFi() {
		canviPanel(new ContractarViatgeView5());
		setSize(400,200);
	}
	
	public void tancar() {
		dispose();
	}
	
	private void canviPanel(ContractarViatgeViewTemplate panel) {
		remove(contentPane);
		contentPane = panel;
		setContentPane(contentPane);
		validate();
		repaint();
	}
	

}
