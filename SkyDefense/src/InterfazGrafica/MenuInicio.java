package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuInicio extends JFrame {

	public MenuInicio() {
		setTitle("Sky Defense");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel titulo = new JLabel("SKY DEFENSE", SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 36));

		JButton btnIniciar = new JButton("Iniciar");
		JButton btnSalir = new JButton("Salir");

		btnIniciar.addActionListener(e -> {
			dispose();
			Pantalla.iniciar();
		});

		btnSalir.addActionListener(e -> {
			System.exit(0);
		});

		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(2, 1, 10, 10));
		panelBotones.add(btnIniciar);
		panelBotones.add(btnSalir);

		add(titulo, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		new MenuInicio();
	}
}