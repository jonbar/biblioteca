package principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class Main {

	public static void main(String[] args) {
		//MAIN DE PRUEBA PARA LIBRO
		
			//Instanciar
				
			Libro_modelo lm = new Libro_modelo("Biblioteca");
				
				int opcion;
				do {
					System.out.println("~~~~~ MENÚ PRINCIPAL ~~~~~");
					System.out.println("1. Insertar libro");
					System.out.println("2. Insertar socio");
					System.out.println("3. Salir del menú");
					Scanner scan = new Scanner(System.in);
					opcion = Integer.parseInt(scan.nextLine());
					switch (opcion) {

					case 1: //INSERT LIBRO
						
						break;

					case 2: //INSERT SOCIO
						break;

					default:
						System.out.println("Elige una de las opciones del menú.");
					}
				} while (opcion != 3);

			}

	}

