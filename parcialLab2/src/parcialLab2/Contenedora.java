package parcialLab2;

import java.util.ArrayList;

public class Contenedora<E extends Persona> {
	
	private ArrayList<E> contenedor = null;
	
	public void agregar(E aux) {
		contenedor.add(aux);
	}
	
	public ArrayList<E> getContenedor() {
		return contenedor;
	}
	public int getSize() {
		return contenedor.size();
	}
	public E getObjAt(int i) {
		return contenedor.get(i);
	}
	
	public boolean eliminar(E aux) {
		return contenedor.remove(aux);
	}
	
	public String listar() {
		StringBuilder builder=new StringBuilder();
		
		for(E aux: contenedor) {
			builder.append(aux.toString());
		}
		return builder.toString();
	}
	/**
	 * Compara las clases del objeto recibido con la de cada posicion, sumando al contador en caso de que coincidan
	 * Usa .getClass().getName().equals.() para comparar
	 * @param E Objeto que hereda de persona
	 * @return Cantidad de objetos de la misma clase que E
	 */
	public int contarClase(E obj) {
		int contador=0;
		for(E aux: contenedor) {
			if(aux.getClass().getName().equals(obj.getClass().getName()));
			contador++;
		}
		
		return contador;
	}
}

