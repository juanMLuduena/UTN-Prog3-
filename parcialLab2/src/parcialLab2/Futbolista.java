package parcialLab2;

import org.json.JSONException;
import org.json.JSONObject;

public class Futbolista extends Persona implements Ijugador{
	private int camiseta;
	private String puesto;
	
	public Futbolista() {
		super();
		camiseta=0;
		puesto=" ";
	}
	
	
	public Futbolista(String nombre,String apellido,int edad,int camiseta, String puesto) {
		super(nombre,apellido,edad);
		this.camiseta = camiseta;
		this.puesto = puesto;
	}


	public int getCamiseta() {
		return camiseta;
	}


	public void setCamiseta(int camiseta) {
		this.camiseta = camiseta;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String toString() {
		return "Futbolista " +super.toString()+ "\nCamiseta: "+camiseta+". Puesto: "+puesto;
	}
	

	@Override
	public String jugar() {
		// TODO Auto-generated method stub
		return getNombre()+ " esta jugando el partido!!";
	}

	public JSONObject getJsonObject() {
		JSONObject jo = new JSONObject();
		try {
			jo = super.getJsonObject();
			jo.put("camiseta", camiseta);
			jo.put("puesto", puesto);
		} catch (JSONException e) {
			e.getMessage();
		}
		return jo;
	}
	
	

}	
