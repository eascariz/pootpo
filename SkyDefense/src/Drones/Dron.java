package Drones;

public class Dron extends EntidadVoladora {
	private float velocidad;
	private Misil misil;
	
	public Dron(int posicionX, int posicionY, float velocidad, Misil misil) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
		this.velocidad = velocidad;
		this.misil = misil;
	}

	@Override
	public void actualizarPosicion(String dir) {
		// TODO Auto-generated method stub
	}

	public void aumentarVelocidad(int porc) {
		velocidad = velocidad + porc;
	}
	
	public int[] getPosicion() {
		return new int[] {posicionX, posicionY};
	}
	
	public void patronDron() {
		
	}
	
	public int Spawn() {
		
	}
	
	public void lanzarMisil(int altitud) {
		misil.newMisil(posicionX, posicionY, altitud, velocidad);
	}
}
