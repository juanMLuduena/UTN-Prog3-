package parcialLab2;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtiles {
/**
 * Gracias gonza
 * @param jo
 */
	public void guardar(JSONObject jo) {
		try {
			FileWriter file=new FileWriter("federacion.txt");
			file.write(jo.toString());
			file.flush();
			file.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
