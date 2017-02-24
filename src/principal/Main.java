package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import modelo.*;

public class Main {
	
	public final static int INSERTAR_LIBRO = 1;
	public final static int INSERTAR_SOCIO = 2;
	public final static int VER_LIBROS = 3;
	public final static int VER_SOCIOS = 4;
	public final static int VER_LIBROS_POR_ID = 5;
	public final static int VER_SOCIO_POR_ID = 6;
	public final static int ELIMINAR_LIBRO = 7;
	public final static int ELIMINAR_SOCIO = 8;
	public final static int VER_LIBROS_POR_AUTOR = 9;
	public final static int VER_PRESTAMO = 10;
	public final static int SALIR = 0;
	

	public static void main(String[] args) throws ParseException {
		// MAIN DE PRUEBA PARA LIBRO

		// Instanciar

		Libro_modelo lm = new Libro_modelo("biblioteka");
		Socio_modelo sm = new Socio_modelo("biblioteka");
		Prestamo_modelo pm = new Prestamo_modelo("biblioteka");
		
		Scanner scan = new Scanner(System.in);
		Scanner autorMetido = new Scanner(System.in);

		int opcion;
		do {
			System.out.println("\n~~~~~ MENÚ PRINCIPAL ~~~~~");
			System.out.println("1. Insertar libro");
			System.out.println("2. Insertar socio");
			System.out.println("3. Ver libros");
			System.out.println("4. Ver socios");
			System.out.println("5. Ver libro por id");
			System.out.println("6. Ver socio por id");
			System.out.println("7. Eliminar libro");
			System.out.println("8. Eliminar socio");
			System.out.println("9. Ver libros por autor");
			System.out.println("10. Ver prestamo");
			System.out.println("0. Salir del menú\n");
			
			opcion = scan.nextInt();
			switch (opcion) {

			case INSERTAR_LIBRO: // INSERT LIBRO
				System.out.println("Introduce el titulo del libro:");
				String titulo = scan.nextLine();
				
				System.out.println("Introduce el autor del libro:");
				String autor = scan.nextLine();
				System.out.println("Introduce el numero de paginas del libro:");
				int num_pag = Integer.parseInt(scan.nextLine());
				
				lm.insert(new Libro(0, titulo, autor, num_pag));
				break;

			case INSERTAR_SOCIO: // INSERT SOCIO
				
				System.out.println("Mete los siguientes datos requeridos.");
				System.out.print("Nombre:");
				String nombre = scan.nextLine();
				System.out.print("Apellido:");
				String apellido = scan.nextLine();
				System.out.print("Direccion:");
				String direccion = scan.nextLine();
				System.out.print("Poblacion:");
				String poblacion = scan.nextLine();
				System.out.print("Provincia:");
				String provincia = scan.nextLine();
				System.out.print("DNI:");
				String dni = scan.nextLine();

				Socio socio = new Socio(0,nombre,apellido,direccion,poblacion,provincia,dni);
				sm.insert(socio);
				break;

			case VER_LIBROS: // VER LIBROS
				ArrayList<Libro> libros = lm.select();
				Iterator<Libro> il = libros.iterator();
				
				while(il.hasNext()){
					il.next().mostrarInfo();
				}
				break;
				
			case VER_SOCIOS: // VER SOCIOS
				ArrayList<Socio> socios = sm.select();
				Iterator<Socio> is = socios.iterator();
				
				while(is.hasNext()){
					is.next().mostrarInfo();
				}
				break;
			case VER_LIBROS_POR_ID:
				System.out.println("-BUSCAR LIBRO POR ID-");
				System.out.print("Id del libro del que deseas informacion: ");
				int idLibro = scan.nextInt();
				lm.select(idLibro).mostrarInfo();
				break;
				
			case VER_SOCIO_POR_ID:
				System.out.println("-BUSCAR SOCIO POR ID-");
				System.out.print("Id del socio del que deseas informacion: ");
				int idSocio = scan.nextInt();
				sm.select(idSocio).mostrarInfo();
				break;
				
			case ELIMINAR_LIBRO:
				System.out.println("-ELIMINAR LIBRO POR ID-");
				System.out.print("Id del libro que desees eliminar: ");
				int idLibroElim = scan.nextInt();
				lm.delete(idLibroElim);
				break;
				
			case ELIMINAR_SOCIO:
				System.out.println("-ELIMINAR SOCIO POR ID-");
				System.out.print("Id del socio que deseas eliminar: ");
				int idSocioElim = scan.nextInt();
				sm.delete(idSocioElim);
				break;
				
			case VER_LIBROS_POR_AUTOR:
				System.out.println("-BUSCAR LIBRO POR AUTOR-");
				System.out.print("Nombre del autor del que deseas informacion: ");
				String NombreAutor = autorMetido.nextLine();
				Iterator<Libro> i = lm.select(NombreAutor).iterator();
				while (i.hasNext()){
					i.next().mostrarInfo();
				}
				break;		
				
			case VER_PRESTAMO:
				SimpleDateFormat eus_format = new SimpleDateFormat("yyyy/MM/dd");

				Date fecha = eus_format.parse("2017/02/08");
				pm.select(1,3,fecha).mostrarInfo();

				break;
			
			case SALIR:
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("Elige una de las opciones del menú.");
			}
		} while (opcion != 0);

	}

}
