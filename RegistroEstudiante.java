import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * 
 */

/**
 * @author jiio2
 *2/06/2021 - 10:43:18
 * 
 */
public class RegistroEstudiante {

	private JFrame miau1;
	private JTextField Nombre;
	private JTextField carne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEstudiante window = new RegistroEstudiante();
					window.miau1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroEstudiante() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		miau1 = new JFrame();
		miau1.setTitle("Registro de Estudiantes");
		miau1.setBounds(100, 100, 345, 300);
		miau1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miau1.getContentPane().setLayout(null);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistrarse.setBounds(22, 166, 145, 38);
		miau1.getContentPane().add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String name = Nombre.getText();
				int id = Integer.parseInt(carne.getText());
				try ( Manejador m = new Manejador( "bolt://localhost:7687", "javi", "123" ) )
				{
					m.createEstudiante(name,id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente");
				Menu.main(null);
				miau1.dispose();
				
			}
		});
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVolverAlMen.setBounds(22, 210, 288, 38);
		miau1.getContentPane().add(btnVolverAlMen);
		btnVolverAlMen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Menu.main(null);
				miau1.dispose();
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSalir.setBounds(165, 166, 145, 38);
		miau1.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		JLabel lblBienvenidoAlRegistro = new JLabel("Bienvenido al registro de estudiantes\r\n\r\n");
		lblBienvenidoAlRegistro.setBounds(20, 0, 290, 20);
		miau1.getContentPane().add(lblBienvenidoAlRegistro);
		
		JLabel lblNewLabel_1 = new JLabel("Por favor llena la informaci\u00F3n que se te pide a continuaci\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(20, 29, 294, 14);
		miau1.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Completo");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 54, 247, 14);
		miau1.getContentPane().add(lblNewLabel_2);
		
		Nombre = new JTextField();
		Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		Nombre.setColumns(10);
		Nombre.setBounds(20, 79, 290, 20);
		miau1.getContentPane().add(Nombre);
		
		JLabel lblNewLabel_2_1 = new JLabel("N\u00FAmero de carn\u00E9");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(20, 110, 247, 14);
		miau1.getContentPane().add(lblNewLabel_2_1);
		
		carne = new JTextField();
		carne.setHorizontalAlignment(SwingConstants.RIGHT);
		carne.setColumns(10);
		carne.setBounds(20, 135, 290, 20);
		miau1.getContentPane().add(carne);
	}
}
