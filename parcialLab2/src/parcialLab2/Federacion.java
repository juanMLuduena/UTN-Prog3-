package parcialLab2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Federacion {
	private String nombre;
	private int fechaFundacion;
	private int cantCopas;
	private Contenedora<Persona> miembros;

	private final int MAX_ENTRENADOR = 1;
	private final int MAX_FUTBOLISTA = 4;

	public Federacion() {
		nombre = " ";
		fechaFundacion = 0;
		cantCopas = 0;
		miembros = new Contenedora<Persona>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(int fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public int getCantCopas() {
		return cantCopas;
	}

	public void setCantCopas(int cantCopas) {
		this.cantCopas = cantCopas;
	}

	public Federacion(String nombre, int fechaFundacion, int cantCopas) {
		this.nombre = nombre;
		this.fechaFundacion = fechaFundacion;
		this.cantCopas = cantCopas;
	}

	/**
	 * 
	 * @param Persona a agregar
	 * @return Un mensaje dependiendo si se agrego o no, en no retorna el msg de
	 *         error
	 * @throws FutbolistaException si ya hay demasiados
	 * @throws EntrenadorException si ya hay demasiados
	 */
	public String agregar(Persona p) {

		String rta;
		try {
			if (p instanceof Futbolista) { // aca creo que puedo hacer un switch y se va a ver mejor

				if (MAX_FUTBOLISTA >= miembros.contarClase(p)) {
					miembros.agregar(p);
					rta = "Futbolista agregado!";
				} else {
					throw new FutbolistaException("No se pueden agregar mas futbolistas");
				}

			} else {
				if (p instanceof Entrenador) {
					if (MAX_ENTRENADOR >= miembros.contarClase(p)) {
						miembros.agregar(p);
						rta = "Entrenador agregado!";
					} else {
						throw new EntrenadorException("No se pueden agregar mas entrenadores");

					}
				} else {
					miembros.agregar(p);
					rta = "Miembro agregado!";
				}

			}
		} catch (FutbolistaException e) {
			rta = e.getMessage();
		} catch (EntrenadorException e) {
			rta = e.getMessage();
		}
		return rta;

	}

	public boolean quitar(Persona p) {
		return miembros.eliminar(p);
	}

	public String toString() {
		return nombre + "Año fundacion: " + fechaFundacion + ". Copas: " + cantCopas + ".\nPlantel: \n"
				+ miembros.toString();
	}

	public String listar() {
		return miembros.toString();
	}

	/**
	 * 
	 * @return un arreglo JSON de futbolistas
	 */
	public JSONArray jsonArrayFutbolista() throws JSONException{
		int i = 0;
		JSONArray ja = new JSONArray();

		for (i = 0; i < miembros.getSize(); i++) {
			if (miembros.getObjAt(i) instanceof Futbolista) {
				ja.put(miembros.getObjAt(i).getJsonObject());
			}
		}

		return ja;
	}

	/**
	 * 
	 * @return un arreglo JSON de entrenadores
	 */
	public JSONArray jsonArrayEntrenador() throws JSONException{
		int i = 0;
		JSONArray ja = new JSONArray();
		for (i = 0; i < miembros.getSize(); i++) {
			if (miembros.getObjAt(i) instanceof Entrenador) {
				ja.put(miembros.getObjAt(i).getJsonObject());
			}
		}
		return ja;
	}

	/**
	 * 
	 * @return un arreglo JSON de ayudantes de campo
	 */
	public JSONArray jsonArrayAyudanteCampo() throws JSONException{
		int i = 0;
		JSONArray ja = new JSONArray();
		for (i = 0; i < miembros.getSize(); i++) {
			if (miembros.getObjAt(i) instanceof AyudanteCampo) {
				ja.put(miembros.getObjAt(i).getJsonObject());
			}
		}
		return ja;
	}

	/**
	 * 
	 * @return un arreglo JSON de masajistas
	 */
	public JSONArray jsonArrayMasajista() throws JSONException{
		int i = 0;
		JSONArray ja = new JSONArray();
		for (i = 0; i < miembros.getSize(); i++) {
			if (miembros.getObjAt(i) instanceof Masajista) {
				ja.put(miembros.getObjAt(i).getJsonObject());
			}
		}
		return ja;
	}

	/**
	 * En cada posicion del jsonArray hay otro jsonArray por cada tipo de miembro
	 * 
	 * @return JsonArray de miembros
	 */
	public JSONArray jsonArrayMiembros() throws JSONException{
		JSONArray ja = new JSONArray();
		
		ja.put(jsonArrayFutbolista());
		ja.put(jsonArrayEntrenador());
		ja.put(jsonArrayAyudanteCampo());
		ja.put(jsonArrayMasajista());
		
	
		return ja;
	}

	/**
	 * Hace un JsonObject completo sin perdida de datos
	 * 
	 * @return jsonObject de la federacion
	 */
	public JSONObject jsonObjectFederacion() {
		JSONObject jo = new JSONObject();
		try {
			jo.put("nombre", getNombre());
			jo.put("fechaFundacion", getFechaFundacion());
			jo.put("cantCopas", getCantCopas());
			jo.put("miembros", jsonArrayMiembros());

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jo;
	}
}
