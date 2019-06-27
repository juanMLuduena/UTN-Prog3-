package parcialLab2;

import org.json.JSONException;
import org.json.JSONObject;

public class Masajista extends Persona implements Iasistencia{
private String titulo;
private int exp;

public Masajista() {
	super();
	titulo=" ";
	exp=0;
}
public Masajista(String nombre,String apellido,int edad, String titulo,int exp) {
	super(nombre,apellido,edad);
	this.titulo=titulo;
	this.exp=exp;
}






public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getExp() {
	return exp;
}
public void setExp(int exp) {
	this.exp = exp;
}

public String toString() {
	return "Masajista " +super.toString()+ "\nTitulo: "+titulo+". Años experiencia: "+exp;
}

@Override
public String asistir() {
	return null;
}

public JSONObject getJsonObject() throws JSONException{
	JSONObject jo = new JSONObject();

		jo = super.getJsonObject();
		jo.put("titulo", titulo);
		jo.put("exp",exp);
	
	return jo;
}


}
