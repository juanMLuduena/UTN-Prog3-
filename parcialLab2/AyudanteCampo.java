package parcialLab2;

import org.json.JSONException;
import org.json.JSONObject;

public class AyudanteCampo extends Persona implements Ijugador, Ipreparador {
	private String metodologia;

	public AyudanteCampo() {
		super();
		metodologia = " ";
	}

	public AyudanteCampo(String nombre, String apellido, int edad, String metodologia) {
		super(nombre, apellido, edad);
		this.metodologia = metodologia;
	}

	public AyudanteCampo(AyudanteCampo ac) {
		super(ac.getNombre(), ac.getApellido(), ac.getEdad());
		metodologia = ac.metodologia;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String toString() {
		return "Ayudante de campo " + super.toString() + "\nMetodologia: " + metodologia;
	}

	public String prepararEntrenamiento() {
		return getNombre() + " esta ayudando a preparar el entrenamiento!!";

	}

	public String jugar() {

		return getNombre() + " esta ayudando durante el partido!! ";
	}

	public JSONObject getJsonObject() throws JSONException{
		JSONObject jo = new JSONObject();
		
			jo = super.getJsonObject();
			jo.put("metodologia", metodologia);
		
		return jo;

	}

}
