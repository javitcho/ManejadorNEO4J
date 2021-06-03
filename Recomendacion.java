import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * 
 */

/**
 * @author jiio2
 *2/06/2021 - 10:46:40
 * 
 */
public class Recomendacion {

	private JFrame frmRecomendaciones;
	private JTextField carne;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recomendacion window = new Recomendacion();
					window.frmRecomendaciones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Recomendacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecomendaciones = new JFrame();
		frmRecomendaciones.setTitle("Recomendaciones");
		frmRecomendaciones.setBounds(100, 100, 480, 366);
		frmRecomendaciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecomendaciones.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese n\u00FAmero de carn\u00E9");
		lblNewLabel.setBounds(10, -1, 213, 38);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		frmRecomendaciones.getContentPane().add(lblNewLabel);
		
		carne = new JTextField();
		carne.setBounds(10, 36, 213, 20);
		frmRecomendaciones.getContentPane().add(carne);
		carne.setColumns(10);
		
		JLabel lblSeleccioneUnCurso = new JLabel("Seleccione un curso");
		lblSeleccioneUnCurso.setBounds(273, 11, 177, 14);
		lblSeleccioneUnCurso.setFont(new Font("Arial", Font.PLAIN, 18));
		frmRecomendaciones.getContentPane().add(lblSeleccioneUnCurso);
		
		JComboBox curso = new JComboBox();
		curso.setBounds(273, 35, 177, 22);
		curso.setModel(new DefaultComboBoxModel(new String[] {"\u00C1lgebra Lineal 1", "C\u00E1lculo 1", "C\u00E1lculo 2", "C\u00E1lculo 3", "Ecuaciones Diferenciales 1", "Ecuaciones Diferenciales 2", "Estad\u00EDstica 1", "Estad\u00EDstica 2", "M\u00E9todos Num\u00E9ricos. 1", "Pensamiento Cuantitativo", "Razonamiento Ciantitativo", "Matemática Discreta"}));
		frmRecomendaciones.getContentPane().add(curso);
		
		JButton btnListo = new JButton("Listo");
		btnListo.setBounds(10, 232, 213, 38);
		btnListo.setFont(new Font("Arial", Font.PLAIN, 20));
		frmRecomendaciones.getContentPane().add(btnListo);
		btnListo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int id = Integer.parseInt(carne.getText());
				String course = curso.getSelectedItem().toString();
				try ( Manejador m = new Manejador( "bolt://localhost:7687", "javi", "123" ) )
				{
					table.setModel(m.tablaDeTutores(id,course));

					table.repaint();
					frmRecomendaciones.revalidate();
					frmRecomendaciones.repaint();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.setBounds(237, 232, 213, 38);
		btnVolverAlMen.setFont(new Font("Arial", Font.PLAIN, 20));
		frmRecomendaciones.getContentPane().add(btnVolverAlMen);
		btnVolverAlMen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Menu.main(null);
				frmRecomendaciones.dispose();
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 281, 440, 38);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 20));
		frmRecomendaciones.getContentPane().add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 440, 134);
		frmRecomendaciones.getContentPane().add(scrollPane);

		String cols[] = {"Nombre","Dominio","Claridad","Puntualidad","Telefono"};
		DefaultTableModel model = new DefaultTableModel(cols,0);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
