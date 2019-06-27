package parcialLab2;

import org.json.JSONException;
import org.json.JSONObject;

public class Entrenador extends Persona implements Ijugador, Ipreparador {
	private String sistemaJuego;
	private String estilo;

	public Entrenador() {
		super();
		sistemaJuego = " ";
		estilo = " ";
	}

	public Entrenador(String nombre, String apellido, int edad, String sistemaJuego, String estilo) {
		super(nombre, apellido, edad);
		this.sistemaJuego = sistemaJuego;
		this.estilo = estilo;
	}

	public Entrenador(Entrenador e) {
		super(e.getNombre(), e.getApellido(), e.getEdad());
		sistemaJuego = e.sistemaJuego;
		estilo = e.estilo;
	}

	public String getSistemaJuego() {
		return sistemaJuego;
	}

	public void setSistemaJuego(String sistemaJuego) {
		this.sistemaJuego = sistemaJuego;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String toString() {
		return "Entrenador " + super.toString() + "\nSistema de juego: " + sistemaJuego + ". Estilo: " + estilo;
	}

	@Override
	public String prepararEntrenamiento() {
		return getNombre() + " esta preparando el entrenamiento";
	}

	@Override
	public String jugar() {
		return getNombre() + " esta dirigiendo su equipo!!";
	}

	public JSONObject getJsonObject() throws JSONException{
		JSONObject jo = new JSONObject();
		
			jo = super.getJsonObject();
			jo.put("sistemaJuego", sistemaJuego);
			jo.put("estilo", estilo);
		
		return jo;
	}

}
