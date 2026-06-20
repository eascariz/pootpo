package InterfazGrafica;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;

import Drones.Escuadron;
import Drones.Explosion;
import Drones.Misil;
import Puntaje.Juego;

public class CicloJuego implements ActionListener {
	private JLabel energia;
	private JLabel vida;
	private JLabel puntaje;
	private Juego juego;
	private Escuadron escuadron;
	private PanelJuego panelJuego;

	public CicloJuego(JLabel energia, JLabel vida, JLabel puntaje, Juego juego, Escuadron escuadron, PanelJuego panelJuego) {
		super();
		this.energia = energia;
		this.vida = vida;
		this.puntaje = puntaje;
		this.juego = juego;
		this.escuadron = escuadron;
		this.panelJuego = panelJuego;
		Timer timer = new Timer(1000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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

		System.out.println("Drones activos: " + escuadron.cantidadDeEscuadrones() + " - Contador: " + escuadron.getContador());
	}
}