package probak;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Libro;
import modelo.Libro_modelo;

public class Main_probalibro {

	public static void main(String[] args) {
		//modeloa instantziatu
		Libro_modelo lm = new Libro_modelo("biblioteka");
		
		//select proba
		ArrayList<Libro> libros = lm.select();
		
		Iterator<Libro> i = libros.iterator();
		while(i.hasNext()){
			i.next().mostrarInfo();
		}
		
		
		//delete proba
		//lm.delete(21); //21a iada borratu dugu
		//System.out.println("21.a ezabatua");
		
		//update proba
		lm.update(new Libro(20, "LA TABLA DE FLANDES", "ARTURO PEREZ REVERTE", 449));
		System.out.println("20.a aldatua");
		
		//insert proba
		lm.insert(new Libro(0, "BILBAO NEW YORK BILBAO", "KIRMEN URIBE", 100));
		System.out.println("inserta eginda");

	}

}
