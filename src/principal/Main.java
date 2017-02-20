package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class Main {

	public static void main(String[] args) {
		// MAIN DE PRUEBA PARA LIBRO

		// Instanciar

		Libro_modelo lm = new Libro_modelo("Biblioteca");
		Socio_modelo sm = new Socio_modelo("Biblioteca");

		int opcion;
		do {
			System.out.println("~~~~~ MENÚ PRINCIPAL ~~~~~");
			System.out.println("1. Insertar libro");
			System.out.println("2. Insertar socio");
			System.out.println("3. Ver libros");
			System.out.println("0. Salir del menú");
			Scanner scan = new Scanner(System.in);
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {

			case 1: // INSERT LIBRO

				break;

			case 2: // INSERT SOCIO
				Scanner datos_socio = new Scanner(System.in);
				System.out.println("Mete los siguientes datos requeridos.");
				System.out.print("Nombre:");
				String nombre = datos_socio.nextLine();
				System.out.print("Apellido:");
				String apellido = datos_socio.nextLine();
				System.out.print("Direccion:");
				String direccion = datos_socio.nextLine();
				System.out.print("Poblacion:");
				String poblacion = datos_socio.nextLine();
				System.out.print("Provincia:");
				String provincia = datos_socio.nextLine();
				System.out.print("DNI:");
				String dni = datos_socio.nextLine();

				Socio socio = new Socio(0,nombre,apellido,direccion,poblacion,provincia,dni);
				sm.insert(socio);
				break;

			case 3: // VER LIBROS
				break;
				
			case 4: // VER SOCIOS
				break;

			default:
				System.out.println("Elige una de las opciones del menú.");
			}
		} while (opcion != 0);

	}

}
