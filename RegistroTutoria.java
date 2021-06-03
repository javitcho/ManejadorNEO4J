import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 * 
 */

/**
 * @author jiio2
 *2/06/2021 - 11:04:29
 * 
 */
public class RegistroTutoria {

	private JFrame miau2;
	private JTextField nombre;
	private JTextField carne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroTutoria window = new RegistroTutoria();
					window.miau2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public RegistroTutoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		miau2 = new JFrame();
		miau2.setTitle("Registro de tutorias");
		miau2.setBounds(100, 100, 371, 508);
		miau2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miau2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Completo");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 11, 247, 14);
		miau2.getContentPane().add(lblNewLabel_2);
		
		nombre = new JTextField();
		nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		nombre.setColumns(10);
		nombre.setBounds(10, 36, 327, 20);
		miau2.getContentPane().add(nombre);
		
		JLabel lblNewLabel_2_1 = new JLabel("N\u00FAmero de carn\u00E9");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 67, 247, 14);
		miau2.getContentPane().add(lblNewLabel_2_1);
		
		carne = new JTextField();
		carne.setHorizontalAlignment(SwingConstants.RIGHT);
		carne.setColumns(10);
		carne.setBounds(10, 92, 327, 20);
		miau2.getContentPane().add(carne);
		
		JLabel lblSeleccioneUnCurso = new JLabel("Seleccione un curso");
		lblSeleccioneUnCurso.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeleccioneUnCurso.setBounds(10, 123, 177, 14);
		miau2.getContentPane().add(lblSeleccioneUnCurso);
		
		JComboBox curso = new JComboBox();
		curso.setModel(new DefaultComboBoxModel(new String[] {"\u00C1lgebra Lineal 1", "C\u00E1lculo 1", "C\u00E1lculo 2", "C\u00E1lculo 3", "Ecuaciones Diferenciales 1", "Ecuaciones Diferenciales 2", "Estad\u00EDstica 1", "Estad\u00EDstica 2", "M\u00E9todos Num\u00E9ricos. 1", "Pensamiento Cuantitativo", "Razonamiento Ciantitativo"}));
		curso.setBounds(10, 147, 177, 22);
		miau2.getContentPane().add(curso);
		
		JLabel lblHorasRecibidas = new JLabel("Horas recibidas");
		lblHorasRecibidas.setFont(new Font("Arial", Font.PLAIN, 18));
		lblHorasRecibidas.setBounds(197, 123, 140, 14);
		miau2.getContentPane().add(lblHorasRecibidas);
		
		JComboBox horas = new JComboBox();
		horas.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		horas.setBounds(197, 147, 140, 22);
		miau2.getContentPane().add(horas);
		
		JLabel lblSeleccioneNombreDel = new JLabel("Seleccione nombre del tutor");
		lblSeleccioneNombreDel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeleccioneNombreDel.setBounds(10, 188, 327, 14);
		miau2.getContentPane().add(lblSeleccioneNombreDel);
		Vector tutores = null;
		try ( Manejador m = new Manejador( "bolt://localhost:7687", "javi", "123" ) )
		{
			tutores = m.tutores();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(tutores);

		JComboBox tutor = new JComboBox(model);
		tutor.setBounds(10, 212, 327, 22);
		miau2.getContentPane().add(tutor);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\u00BFSu tutor fue puntual?");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(10, 245, 247, 28);
		miau2.getContentPane().add(lblNewLabel_2_2_1);
		
		JComboBox puntualidad = new JComboBox();
		puntualidad.setModel(new DefaultComboBoxModel(new String[] {"si", "no"}));
		puntualidad.setBounds(10, 284, 177, 22);
		miau2.getContentPane().add(puntualidad);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Dominio del tema");
		lblNewLabel_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2_1_1.setBounds(197, 245, 140, 28);
		miau2.getContentPane().add(lblNewLabel_2_2_1_1);
		
		JComboBox dominio = new JComboBox();
		dominio.setModel(new DefaultComboBoxModel(new String[] {"1 (m\u00E1s bajo)", "2", "3", "4", "5 (m\u00E1s alto)"}));
		dominio.setBounds(197, 284, 140, 22);
		miau2.getContentPane().add(dominio);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("\u00BFEntendi\u00F3 la explicaci\u00F3n?");
		lblNewLabel_2_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_2_1_2.setBounds(10, 317, 247, 28);
		miau2.getContentPane().add(lblNewLabel_2_2_1_2);
		
		JComboBox explicacion = new JComboBox();
		explicacion.setModel(new DefaultComboBoxModel(new String[] {"si", "talvez", "no"}));
		explicacion.setBounds(10, 356, 177, 22);
		miau2.getContentPane().add(explicacion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistrar.setBounds(10, 389, 156, 38);
		miau2.getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String name = nombre.getText();
				int id = Integer.parseInt(carne.getText());
				String course = (String) (curso.getSelectedItem());
				String TUTOR = (String) tutor.getSelectedItem();
				int hours = horas.getSelectedIndex() + 1;
				int dom = dominio.getSelectedIndex() + 1;
				int exp;
				int punt;
				if(((String) puntualidad.getSelectedItem()).equalsIgnoreCase("si")) {
					// 0 es si 
					//1 para no
					
					 punt = 0;
					
				}else {
					 punt = 1; 
					
				}
				
				if(((String) explicacion.getSelectedItem()).equalsIgnoreCase("si")) {
					// 0 es si 
					//1 para talvez
					//2 para no
					
					exp = 0;
					
				}else if (((String) explicacion.getSelectedItem()).equalsIgnoreCase("talvez")) {
					exp = 1; 
					
				} else {
					exp = 2;
				}
				try ( Manejador m = new Manejador( "bolt://localhost:7687", "javi", "123" ) )
				{
					m.registrarTutoria(TUTOR,id,course,exp,dom,hours,punt);
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente");
				Menu.main(null);
				miau2.dispose();
				
				
			}
		});
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVolverAlMen.setBounds(10, 427, 327, 38);
		miau2.getContentPane().add(btnVolverAlMen);
		btnVolverAlMen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Menu.main(null);
				miau2.dispose();
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSalir.setBounds(181, 389, 156, 38);
		miau2.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
