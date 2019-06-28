import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtiles {
	/**
	 * Gracias gonza
	 * 
	 * @param jo
	 */
	public void guardar(JSONObject jo) {
		try {
			FileWriter file = new FileWriter("federacion.txt");
			file.write(jo.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Federacion leer() {
		Federacion fede = new Federacion();
		int i = 0;
		try {
			String aux = new String(Files.readAllBytes(Paths.get("federacion.txt")));
			JSONObject jo = new JSONObject(aux);
			fede.setNombre(jo.getString("nombre"));
			fede.setFechaFundacion(jo.getInt("fechaFundacion"));
			fede.setCantCopas(jo.getInt("cantCopas"));

			jo.getJSONArray("miembros").getJSONArray(0);

			for (i = 0; i < jo.getJSONArray("miembros").getJSONArray(0).length(); i++) {
				Futbolista f = new Futbolista();
				f.setNombre(jo.getJSONArray("miembros").getJSONArray(0).getJSONObject(i).getString("nombre"));
				f.setApellido(jo.getJSONArray("miembros").getJSONArray(0).getJSONObject(i).getString("apellido"));
				f.setEdad(jo.getJSONArray("miembros").getJSONArray(0).getJSONObject(i).getInt("edad"));
				f.setCamiseta(jo.getJSONArray("miembros").getJSONArray(0).getJSONObject(i).getInt("camiseta"));
				f.setPuesto(jo.getJSONArray("miembros").getJSONArray(0).getJSONObject(i).getString("puesto"));
				fede.agregar(f);
			}
			i = 0;

			for (i = 0; i < jo.getJSONArray("miembros").getJSONArray(1).length(); i++) {
				Entrenador e = new Entrenador();
				e.setNombre(jo.getJSONArray("miembros").getJSONArray(1).getJSONObject(i).getString("nombre"));
				e.setApellido(jo.getJSONArray("miembros").getJSONArray(1).getJSONObject(i).getString("apellido"));
				e.setEdad(jo.getJSONArray("miembros").getJSONArray(1).getJSONObject(i).getInt("edad"));
				e.setSistemaJuego(
						jo.getJSONArray("miembros").getJSONArray(1).getJSONObject(i).getString("sistemaJuego"));
				e.setEstilo(jo.getJSONArray("miembros").getJSONArray(1).getJSONObject(i).getString("estilo"));
				fede.agregar(e);
			}

			i = 0;

			for (i = 0; i < jo.getJSONArray("miembros").getJSONArray(2).length(); i++) {
				AyudanteCampo ac = new AyudanteCampo();
				ac.setNombre(jo.getJSONArray("miembros").getJSONArray(2).getJSONObject(i).getString("nombre"));
				ac.setApellido(jo.getJSONArray("miembros").getJSONArray(2).getJSONObject(i).getString("apellido"));
				ac.setEdad(jo.getJSONArray("miembros").getJSONArray(2).getJSONObject(i).getInt("edad"));
				ac.setMetodologia(
						jo.getJSONArray("miembros").getJSONArray(2).getJSONObject(i).getString("metodologia"));
				fede.agregar(ac);
			}
			i = 0;
			for (i = 0; i < jo.getJSONArray("miembros").getJSONArray(3).length(); i++) {
				Masajista m = new Masajista();
				m.setNombre(jo.getJSONArray("miembros").getJSONArray(3).getJSONObject(i).getString("nombre"));
				m.setApellido(jo.getJSONArray("miembros").getJSONArray(3).getJSONObject(i).getString("apellido"));
				m.setEdad(jo.getJSONArray("miembros").getJSONArray(3).getJSONObject(i).getInt("edad"));
				m.setTitulo(jo.getJSONArray("miembros").getJSONArray(3).getJSONObject(i).getString("titulo"));
				m.setExp(jo.getJSONArray("miembros").getJSONArray(3).getJSONObject(i).getInt("exp"));
				fede.agregar(m);
			}

		} catch (JSONException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return fede;

	}

}
