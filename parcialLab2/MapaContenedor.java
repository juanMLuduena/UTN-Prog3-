package parcialLab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Codigo del mapa generico, no se puede implementar en federacion porque
 * Persona no tiene un identificador unico
 * 
 * @author juan y bianca
 *
 * @param <E>
 * @param <K>
 * @param <T>
 */
public class MapaContenedor<E, K, T extends Persona> {

	private HashMap<K, T> contenedor;

	public void agregar(K key, T value) {
		contenedor.put(key, value);
	}

	public HashMap<K, T> getMapaContenedor() {
		return contenedor;
	}

	public T eliminar(K key) {// hacer un boolean
		return contenedor.remove(key);
	}

	public String listar() {
		StringBuilder builder = new StringBuilder();
		Iterator it = contenedor.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry entrada = (HashMap.Entry) it.next();
			builder.append(entrada.toString());
		}
		return builder.toString();
	}

	public int contarClase(T value) {
		int contador = 0;
		Iterator it = contenedor.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry entrada = (HashMap.Entry) it.next();
			if (value.getClass().getName().equals(entrada.getClass().getName())) {
				contador++;
			}
		}
		return contador;
	}
}