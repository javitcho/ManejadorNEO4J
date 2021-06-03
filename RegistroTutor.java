import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBoxMenuItem;

/**
 * 
 */

/**
 * @author jiio2
 *2/06/2021 - 00:41:03
 * 
 */
public class RegistroTutor {

	private JFrame miau;
	private JTextField NombreUsuario;
	private JTextField Carne;
	private JTextField Carrera;
	private JTextField correo;
	private JTextField telefono;
	ArrayList cursos = new ArrayList();

	/**
	 * Launch the application.
	 * @return 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroTutor window = new RegistroTutor();
					window.miau.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public RegistroTutor() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		miau = new JFrame();
		miau.setTitle("Registro de tutores");
		miau.setBounds(100, 100, 521, 469);
		miau.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miau.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al registro de tutores\r\n\r\n");
		lblNewLabel.setBounds(10, 11, 290, 20);
		miau.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Por favor llena la informaci\u00F3n que se te pide a continuaci\u00F3n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 40, 294, 14);
		miau.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Completo");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 65, 247, 14);
		miau.getContentPane().add(lblNewLabel_2);
		
		NombreUsuario = new JTextField();
		NombreUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		NombreUsuario.setBounds(10, 90, 290, 20);
		miau.getContentPane().add(NombreUsuario);
		NombreUsuario.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("N\u00FAmero de carn\u00E9");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 121, 247, 14);
		miau.getContentPane().add(lblNewLabel_2_1);
		
		Carne = new JTextField();
		Carne.setHorizontalAlignment(SwingConstants.RIGHT);
		Carne.setColumns(10);
		Carne.setBounds(10, 146, 290, 20);
		miau.getContentPane().add(Carne);
		
		JLabel lblNewLabel_2_2 = new JLabel("Carrera");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(10, 177, 247, 14);
		miau.getContentPane().add(lblNewLabel_2_2);
		
		Carrera = new JTextField();
		Carrera.setHorizontalAlignment(SwingConstants.RIGHT);
		Carrera.setColumns(10);
		Carrera.setBounds(10, 202, 290, 20);
		miau.getContentPane().add(Carrera);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo institucional");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(10, 233, 247, 14);
		miau.getContentPane().add(lblNewLabel_2_3);
		
		correo = new JTextField();
		correo.setHorizontalAlignment(SwingConstants.RIGHT);
		correo.setColumns(10);
		correo.setBounds(10, 258, 290, 20);
		miau.getContentPane().add(correo);
		
		JLabel lblNewLabel_2_4 = new JLabel("N\u00FAmero de tel\u00E9fono");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(10, 289, 247, 14);
		miau.getContentPane().add(lblNewLabel_2_4);
		
		telefono = new JTextField();
		telefono.setHorizontalAlignment(SwingConstants.RIGHT);
		telefono.setColumns(10);
		telefono.setBounds(10, 314, 290, 20);
		miau.getContentPane().add(telefono);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 345, 145, 38);
		miau.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String Name = NombreUsuario.getText();
				int id = Integer.parseInt(Carne.getText());
				String bach = Carrera.getText();
				String mail = correo.getText();
				int phone = Integer.parseInt(telefono.getText());
				ArrayList courses = cursos;
				try ( Manejador m = new Manejador( "bolt://localhost:7687", "javi", "123" ) )
				{
					m.createTutor(Name,id,bach,mail,phone,courses.toArray());
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente");
				Menu.main(null);
				miau.dispose();
				
				
			}
		});
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVolverAlMen.setBounds(10, 385, 290, 38);
		miau.getContentPane().add(btnVolverAlMen);
		btnVolverAlMen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Menu.main(null);
				miau.dispose();
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSalir.setBounds(161, 345, 139, 38);
		miau.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		
		JCheckBox AlgebralLineal = new JCheckBox("\u00C1lgebra Lineal 1");
		AlgebralLineal.setBounds(321, 69, 179, 23);
		miau.getContentPane().add(AlgebralLineal);
		AlgebralLineal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(AlgebralLineal.getText());
				
			}
		});
		
		JCheckBox Calculo1 = new JCheckBox("C\u00E1lculo 1");
		Calculo1.setBounds(321, 95, 179, 23);
		miau.getContentPane().add(Calculo1);
		Calculo1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Calculo1.getText());
				
			}
		});
		
		JCheckBox Calculo2 = new JCheckBox("C\u00E1lculo 2");
		Calculo2.setBounds(321, 121, 179, 23);
		miau.getContentPane().add(Calculo2);
		Calculo2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Calculo2.getText());
				
			}
		});
		
		JCheckBox Calculo3 = new JCheckBox("C\u00E1lculo 3");
		Calculo3.setBounds(321, 147, 179, 23);
		miau.getContentPane().add(Calculo3);
		Calculo3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Calculo3.getText());
				
			}
		});
		
		JCheckBox Ecuas1 = new JCheckBox("Ecuaciones Diferenciales 1");
		Ecuas1.setBounds(321, 173, 179, 23);
		miau.getContentPane().add(Ecuas1);
		Ecuas1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Ecuas1.getText());
				
			}
		});
		
		JCheckBox Ecuas2 = new JCheckBox("Ecuaciones Diferenciales 2");
		Ecuas2.setBounds(321, 199, 179, 23);
		miau.getContentPane().add(Ecuas2);
		Ecuas2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Ecuas2.getText());
				
			}
		});
		
		
		JCheckBox Estats1 = new JCheckBox("Estad\u00EDstica 1");
		Estats1.setBounds(321, 225, 179, 23);
		miau.getContentPane().add(Estats1);
		Estats1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Estats1.getText());
				
			}
		});
		
		JCheckBox Estats2 = new JCheckBox("Estad\u00EDstica 2");
		Estats2.setBounds(321, 251, 179, 23);
		miau.getContentPane().add(Estats2);
		Estats2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Estats2.getText());
				
			}
		});
		
		JCheckBox MateDiscreta = new JCheckBox("Matem\u00E1tica Discreta");
		MateDiscreta.setBounds(321, 277, 179, 23);
		miau.getContentPane().add(MateDiscreta);
		MateDiscreta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(MateDiscreta.getText());
				
			}
		});
		
		JCheckBox Metodos1 = new JCheckBox("M\u00E9todos Num\u00E9ricos 1");
		Metodos1.setBounds(321, 303, 179, 23);
		miau.getContentPane().add(Metodos1);
		Metodos1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(Metodos1.getText());
				
			}
		});
		
		
		JCheckBox pensa = new JCheckBox("Pensamiento Cuantitativo");
		pensa.setBounds(321, 329, 179, 23);
		miau.getContentPane().add(pensa);
		pensa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(pensa.getText());
				
			}
		});
		
		JCheckBox razo = new JCheckBox("Razonamiento Cuantitativo");
		razo.setBounds(321, 355, 179, 23);
		miau.getContentPane().add(razo);
		razo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cursos.add(razo.getText());
				
			}
		});
		
		JLabel lblNewLabel_2_6 = new JLabel("Selecciones los cursos");
		lblNewLabel_2_6.setBounds(321, 48, 165, 14);
		miau.getContentPane().add(lblNewLabel_2_6);
	}
}
