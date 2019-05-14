package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AutorPojo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogFichaAutor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton printButton;
	private JTextField txtAutorID;
	private JLabel lblAutorId;
	private JLabel lblAutorApenom;
	private JLabel lblAutorNac;
	private JLabel lblAutorTelf;
	private JLabel lblAutorBiog;
	private JLabel lblAutorDestreza;
	private JLabel lblAutorNacion;
	private JLabel lblAutorMail;
	private JTextField txtAutorApenom;
	private JTextField txtAutorFecha;
	private JTextField txtAutorTelf;
	private JTextField txtAutorNacion;
	private JTextField txtAutorMail;
	private JTextField txtAutorDestreza;
	private JTextArea txtaAutorBiog;
	private JScrollPane scrollPane;
	private AutorPojo autorSel;

	public DialogFichaAutor(AutorPojo autorSel) {
		super();
		this.autorSel = autorSel;
		setTitle("FICHA DE AUTOR");
		inicializar();
		cargarAutorSel(autorSel);
	}

	private void inicializar() {
		// configuracion del JDialog
		setBounds(100, 100, 800, 400);
		getContentPane().setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblAutorId = new JLabel("Código de Autor:");
		lblAutorId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorId.setBounds(45, 50, 145, 20);
		contentPanel.add(lblAutorId);

		lblAutorApenom = new JLabel("Nombre y apellidos:");
		lblAutorApenom.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorApenom.setBounds(45, 80, 145, 20);
		contentPanel.add(lblAutorApenom);

		lblAutorNac = new JLabel("Fecha de Nacimiento:");
		lblAutorNac.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorNac.setBounds(45, 110, 145, 20);
		contentPanel.add(lblAutorNac);

		lblAutorNacion = new JLabel("Nacionalidad:");
		lblAutorNacion.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorNacion.setBounds(415, 110, 135, 20);
		contentPanel.add(lblAutorNacion);

		lblAutorTelf = new JLabel("Teléfono de contacto:");
		lblAutorTelf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorTelf.setBounds(45, 140, 145, 20);
		contentPanel.add(lblAutorTelf);

		lblAutorMail = new JLabel("E-mail de contacto:");
		lblAutorMail.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorMail.setBounds(415, 140, 135, 20);
		contentPanel.add(lblAutorMail);

		lblAutorBiog = new JLabel("Biografía:");
		lblAutorBiog.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorBiog.setBounds(45, 170, 145, 20);
		contentPanel.add(lblAutorBiog);

		lblAutorDestreza = new JLabel("Destreza/s del autor:");
		lblAutorDestreza.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblAutorDestreza.setBounds(45, 297, 145, 20);
		contentPanel.add(lblAutorDestreza);

		txtAutorID = new JTextField();
		txtAutorID.setEditable(false);
		txtAutorID.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorID.setBounds(195, 49, 165, 20);
		contentPanel.add(txtAutorID);
		txtAutorID.setColumns(10);

		txtAutorApenom = new JTextField();
		txtAutorApenom.setEditable(false);
		txtAutorApenom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorApenom.setColumns(10);
		txtAutorApenom.setBounds(195, 79, 165, 20);
		contentPanel.add(txtAutorApenom);

		txtAutorFecha = new JTextField();
		txtAutorFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorFecha.setEditable(false);
		txtAutorFecha.setColumns(10);
		txtAutorFecha.setBounds(195, 109, 165, 20);
		contentPanel.add(txtAutorFecha);

		txtAutorTelf = new JTextField();
		txtAutorTelf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorTelf.setEditable(false);
		txtAutorTelf.setColumns(10);
		txtAutorTelf.setBounds(195, 139, 165, 20);
		contentPanel.add(txtAutorTelf);

		txtAutorNacion = new JTextField();
		txtAutorNacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorNacion.setEditable(false);
		txtAutorNacion.setColumns(10);
		txtAutorNacion.setBounds(577, 109, 165, 20);
		contentPanel.add(txtAutorNacion);

		txtAutorMail = new JTextField();
		txtAutorMail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorMail.setEditable(false);
		txtAutorMail.setColumns(10);
		txtAutorMail.setBounds(577, 139, 165, 20);
		contentPanel.add(txtAutorMail);

		txtAutorDestreza = new JTextField();
		txtAutorDestreza.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAutorDestreza.setEditable(false);
		txtAutorDestreza.setColumns(10);
		txtAutorDestreza.setBounds(195, 296, 280, 20);
		contentPanel.add(txtAutorDestreza);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 190, 697, 96);
		contentPanel.add(scrollPane);

		txtaAutorBiog = new JTextArea();
		txtaAutorBiog.setEditable(false);
		scrollPane.setViewportView(txtaAutorBiog);

		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				printButton = new JButton("Imprimir");
				printButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// Evento asociado al boton IMPRIMIR, que simula el envio del listado a la
						// impresora
						JOptionPane.showMessageDialog(null, "Se ha enviado a la impresora", "Imprimir Listado",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
				printButton.setActionCommand("Cancel");
				buttonPane.add(printButton);
			}
		}

	}

	// método para hacer visible la ficha de autor
	public void hacerVisible() {
		setVisible(true);
	}

	// metodo para cargar los datos que traemos de la tabla en los campos
	private void cargarAutorSel(AutorPojo autorSel) {
		txtAutorID.setText(autorSel.getIdAutor());
		txtAutorApenom.setText(autorSel.getApenomAutor());
		txtAutorFecha.setText(autorSel.getFechaNacAutor());
		txtAutorNacion.setText(autorSel.getNacionalidadAutor());
		txtAutorTelf.setText("" + autorSel.getTelfAutor());
		txtAutorMail.setText(autorSel.getMailAutor());
		txtAutorDestreza.setText(autorSel.getDestrezaAutor());
		txtaAutorBiog.append(autorSel.getBiografiaAutor());
	}
}
