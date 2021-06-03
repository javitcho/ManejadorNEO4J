import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * 
 */

/**
 * @author jiio2
 *2/06/2021 - 01:18:56
 * 
 */
public class Menu {

	private JFrame frmMen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMen = new JFrame();
		frmMen.setTitle("Men\u00FA");
		frmMen.setBounds(100, 100, 582, 185);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(239, 17, 106, 24);
		frmMen.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrarse como tutor");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(201, 102, 205, 39);
		frmMen.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				RegistroTutor.main(null);
				frmMen.dispose();

				
				
			}
		});

		
		JButton btnRegistrarTutoras = new JButton("Registrar tutor\u00EDas");
		btnRegistrarTutoras.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegistrarTutoras.setBounds(10, 102, 181, 39);
		frmMen.getContentPane().add(btnRegistrarTutoras);
		btnRegistrarTutoras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RegistroTutoria.main(null);
				frmMen.dispose();
				
			}
		});
		
		JButton btnRegistrarseComoEstudiante = new JButton("Registrarse como estudiante");
		btnRegistrarseComoEstudiante.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegistrarseComoEstudiante.setBounds(291, 52, 265, 39);
		frmMen.getContentPane().add(btnRegistrarseComoEstudiante);
		btnRegistrarseComoEstudiante.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RegistroEstudiante.main(null);
				frmMen.dispose();
				
			}
		});

		
		JButton btnRecomendacionesDeTutor = new JButton("Recomendaciones de tutor");
		btnRecomendacionesDeTutor.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRecomendacionesDeTutor.setBounds(10, 52, 265, 39);
		frmMen.getContentPane().add(btnRecomendacionesDeTutor);
		btnRecomendacionesDeTutor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Recomendacion.main(null);
				frmMen.dispose();
				
			}
		});
		
		JButton btnRegistrarTutoras_1_1 = new JButton("Salir");
		btnRegistrarTutoras_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegistrarTutoras_1_1.setBounds(418, 102, 138, 39);
		frmMen.getContentPane().add(btnRegistrarTutoras_1_1);
		btnRegistrarTutoras_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
	}


}
