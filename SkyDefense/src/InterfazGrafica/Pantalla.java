package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Avion.Avion;
import Comun.Direccion;
import Drones.Escuadron;
import Puntaje.Juego;
import Puntaje.SistemaPuntaje;

public class Pantalla {

	public static void iniciar() {
		Avion avion = new Avion(300, 1500, 10);
		Escuadron escuadron = new Escuadron(50,3);
		SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
		Juego juego = new Juego(1, 3, avion, escuadron, sistemaPuntaje);

		JPanel panelInfo = new JPanel();
		int[] pos = juego.getAvion().obtenerPosicion();
		String posX = String.valueOf(pos[0]);
		String posY = String.valueOf(pos[1]);
		String energia = String.valueOf(juego.getAvion().getEnergia());
		String vidas = String.valueOf(juego.getVidas());
		String puntaje = String.valueOf(juego.getSistemaPuntaje().getPuntaje());
		String nivel = String.valueOf(juego.getNivel());
		panelInfo.setLayout(new GridLayout(7, 2));

		JLabel lblPosY = new JLabel(posY);
		JLabel lblPosX = new JLabel(posX);
		JLabel lblEnergia = new JLabel(energia);
		JLabel lblVidas = new JLabel(vidas);
		JLabel lblPuntaje = new JLabel(puntaje);
		JLabel lblNivel = new JLabel(nivel);
		JLabel lblHi = new JLabel(String.valueOf(SistemaPuntaje.getHighScore()));

		panelInfo.add(new JLabel("Posición X:"));
		panelInfo.add(lblPosX);
		panelInfo.add(new JLabel("Posición Y:"));
		panelInfo.add(lblPosY);
		panelInfo.add(new JLabel("Energia:"));
		panelInfo.add(lblEnergia);
		panelInfo.add(new JLabel("Vidas:"));
		panelInfo.add(lblVidas);
		panelInfo.add(new JLabel("Puntaje:"));
		panelInfo.add(lblPuntaje);
		panelInfo.add(new JLabel("Nivel:"));
		panelInfo.add(lblNivel);
		panelInfo.add(new JLabel("High Score:"));
		panelInfo.add(lblHi);

		JPanel panelContenedorInfo = new JPanel();
		panelContenedorInfo.setLayout(new BorderLayout());
		panelContenedorInfo.add(panelInfo, BorderLayout.WEST);

		PanelJuego panelJuego = new PanelJuego(avion, escuadron);

		// teclas de control
		javax.swing.InputMap inputMap = panelJuego.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
		javax.swing.ActionMap actionMap = panelJuego.getActionMap();

		inputMap.put(javax.swing.KeyStroke.getKeyStroke("UP"), "arriba");
		inputMap.put(javax.swing.KeyStroke.getKeyStroke("DOWN"), "abajo");
		inputMap.put(javax.swing.KeyStroke.getKeyStroke("LEFT"), "izquierda");
		inputMap.put(javax.swing.KeyStroke.getKeyStroke("RIGHT"), "derecha");

		actionMap.put("arriba", new javax.swing.AbstractAction() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				juego.desplazar(Direccion.ARRIBA);
				lblPosY.setText(String.valueOf(juego.getAvion().obtenerPosicion()[1]));
				panelJuego.repaint();
			}
		});
		actionMap.put("abajo", new javax.swing.AbstractAction() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				juego.desplazar(Direccion.ABAJO);
				lblPosY.setText(String.valueOf(juego.getAvion().obtenerPosicion()[1]));
				panelJuego.repaint();
			}
		});
		actionMap.put("izquierda", new javax.swing.AbstractAction() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				juego.desplazar(Direccion.IZQUIERDA);
				lblPosX.setText(String.valueOf(juego.getAvion().obtenerPosicion()[0]));
				panelJuego.repaint();
			}
		});
		actionMap.put("derecha", new javax.swing.AbstractAction() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				juego.desplazar(Direccion.DERECHA);
				lblPosX.setText(String.valueOf(juego.getAvion().obtenerPosicion()[0]));
				panelJuego.repaint();
			}
		});

		JPanel panelControl = new JPanel();
		panelControl.setLayout(new GridLayout(4, 3));
		JButton izq = new JButton();
		JButton der = new JButton();
		JButton arriba = new JButton();
		JButton abajo = new JButton();
		izq.setText("⬅️");
		der.setText("➡️");
		arriba.setText("⬆️");
		abajo.setText("⬇️");
		panelControl.add(new JLabel());
		panelControl.add(arriba);
		arriba.addActionListener(new Movimiento(lblPosY, juego, Direccion.ARRIBA));
		panelControl.add(new JLabel());
		panelControl.add(izq);
		izq.addActionListener(new Movimiento(lblPosX, juego, Direccion.IZQUIERDA));
		panelControl.add(new JLabel());
		panelControl.add(der);
		der.addActionListener(new Movimiento(lblPosX, juego, Direccion.DERECHA));
		panelControl.add(new JLabel());
		panelControl.add(abajo);
		abajo.addActionListener(new Movimiento(lblPosY, juego, Direccion.ABAJO));
		panelControl.add(new JLabel());
		/*
		JButton testEnergia = new JButton("Test energía");
		testEnergia.addActionListener(e -> {
			avion.restarEnergia(40);
			juego.verificarEnergia();
			lblEnergia.setText(String.valueOf(avion.getEnergia()));
			lblVidas.setText(String.valueOf(juego.getVidas()));
		});
		
		JButton testVida = new JButton("Test vida");
		testVida.addActionListener(e -> {
			juego.restarVida();
			lblVidas.setText(String.valueOf(juego.getVidas()));
		});

		panelControl.add(testEnergia);
		panelControl.add(testVida);
		panelControl.add(new JLabel());
		*/
		JFrame pantalla = new JFrame("SkyDefence");
		pantalla.add(panelContenedorInfo, BorderLayout.NORTH);
		pantalla.add(panelJuego, BorderLayout.CENTER);
		pantalla.add(panelControl, BorderLayout.SOUTH);
		pantalla.pack();
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);

		juego.iniciarNivel();
		new CicloJuego(lblEnergia, lblVidas, lblPuntaje, lblNivel, juego, escuadron, panelJuego);
	}

	public static void main(String[] args) {
		new MenuInicio();
	}
}