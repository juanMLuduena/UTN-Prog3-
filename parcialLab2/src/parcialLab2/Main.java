package parcialLab2;

import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		int i=0;
		
		Federacion fede=new Federacion();
		Entrenador entre=new Entrenador("Gonzalito","Benoffi",30,"442","Defensivo");
		fede.agregar(entre);
		for(i=0;i<5;i++) {
			Futbolista fut=new Futbolista ("Futbolista","Generico",20,i,"Programador");
			System.out.println(fede.agregar(fut));
		}
		Masajista masa=new Masajista("Masajista","Json",25,"Super majasista",2);
		fede.agregar(masa);
		AyudanteCampo ayu=new AyudanteCampo("Ayudante de","campo",60,"Metodologia de la investigacion");
		fede.agregar(ayu);
		
		JsonUtiles ju=new JsonUtiles();
		JSONObject jo=new JSONObject();
		jo=fede.jsonObjectFederacion();
		ju.guardar(jo);
	}

}
