package parcialLab2;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		JsonUtiles ju=new JsonUtiles();
		Federacion fede=new Federacion();
		JSONObject jo=new JSONObject();
		jo=fede.jsonObjectFederacion();
		ju.guardar(jo);
	}

}
