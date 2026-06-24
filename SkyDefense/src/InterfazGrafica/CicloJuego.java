package InterfazGrafica;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Drones.Escuadron;
import Drones.Explosion;
import Drones.Misil;
import Puntaje.Juego;
import Puntaje.SistemaPuntaje;

public class CicloJuego implements ActionListener {
	private JLabel energia;
	private JLabel vida;
	private JLabel puntaje;
	private JLabel nivel;
	private Juego juego;
	private Escuadron escuadron;
	private PanelJuego panelJuego;

	public CicloJuego(JLabel energia, JLabel vida, JLabel puntaje, JLabel nivel, Juego juego, Escuadron escuadron, PanelJuego panelJuego) {
		super();
		this.energia = energia;
		this.vida = vida;
		this.puntaje = puntaje;
		this.nivel = nivel;
		this.juego = juego;
		this.escuadron = escuadron;
		this.panelJuego = panelJuego;
		Timer timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(juego.isJuegoTerminado()) {
			((Timer)e.getSource()).stop();
			mostrarGameOver();
			return;
		}

		List<Misil> misiles = escuadron.getMisiles();
		for (int i = misiles.size() - 1; i >= 0; i--) {
			Misil misil = misiles.get(i);
			misil.actualizarPosicion(null);
			if (misil.verificarAltitud()) {
				Explosion explosion = misil.detonar(50);
				juego.calcularDanio(explosion);
				misiles.remove(i);
			}
		}

		escuadron.patronEscuadron();
		juego.pasarNivel();
		vida.setText(String.valueOf(juego.getVidas()));
		puntaje.setText(String.valueOf(juego.getSistemaPuntaje().getPuntaje()));
		energia.setText(String.valueOf(juego.getAvion().getEnergia()));
		nivel.setText(String.valueOf(juego.getNivel()));

		System.out.println("Drones activos: " + escuadron.cantidadDeEscuadrones() + " - Contador: " + escuadron.getContador());
		panelJuego.repaint();
	}

	private void mostrarGameOver() {
		juego.getSistemaPuntaje().actualizarHighScore();
		int puntajeFinal = juego.getSistemaPuntaje().getPuntaje();
		int hi = SistemaPuntaje.getHighScore();

		JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(panelJuego);

		int opcion = JOptionPane.showOptionDialog(
				ventana,
				"¡Game Over!\nPuntaje: " + puntajeFinal + "\nHI: " + hi,
				"Game Over",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				new String[]{"Volver a jugar", "Salir"},
				"Volver a jugar"
		);

		if(opcion == 0) {
			ventana.dispose();
			Pantalla.iniciar();
		} else {
			System.exit(0);
		}
	}
}