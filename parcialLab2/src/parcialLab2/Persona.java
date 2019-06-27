package parcialLab2;

import org.json.JSONException;
import org.json.JSONObject;

public class Persona {
private String nombre;
private String apellido;
private int edad;

public Persona() {
	nombre=" ";
	apellido=" ";
	edad=0;
}

public Persona(String nombre,String apellido,int edad) {
	this.nombre=nombre;
	this.apellido=apellido;
	this.edad=edad;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
} 

public String toString() {
	return nombre+ " "+apellido+ ". "+ edad+ " años";
}

public String concentrar() {
	return nombre+" esta concentrando!!";
}

public String viajar() {
return nombre+" esta viajando!!";
}

/**
 * Cada clase que hereda de esta implementa su propia version completa de esto
 * @return JsonObject de persona
 */
public JSONObject getJsonObject() {
	JSONObject jo=new JSONObject();
	try {
	jo.put("nombre", nombre);
	jo.put("apellido", apellido);
	jo.put("edad", edad);
	}
	catch(JSONException e) {
		e.getMessage();
	}
	return jo;
	
}
}
