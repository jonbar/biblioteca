package probak;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Socio;
import modelo.Socio_modelo;

public class Main_probasocio {

	public static void main(String[] args) {
		//modeloa instantziatu
		Socio_modelo sm = new Socio_modelo("biblioteka");
		
		//select proba
		ArrayList<Socio> socios = sm.select();
		
		Iterator<Socio> i = socios.iterator();
		while(i.hasNext()){
			i.next().mostrarInfo();
		}
		
		
		//delete proba
//		sm.delete(7); //7a iada borratu dugu
//		System.out.println("7.a ezabatua");
//		
//		//update proba
		sm.update(new Socio(8, "Amaia", "Arrieta Badiola", "San Ignazio", "Ondarroa", "Bizkaia", "11223344v"));
		System.out.println("8.a aldatua");
//		
//		//insert proba
		sm.insert(new Socio(0, "Joxe", "Badiola Badiola", "Kalandi", "Ondarroa", "Bizkaia", "11223355v"));
		System.out.println("inserta eginda");

	}

}
