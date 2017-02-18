package modelo;

public class Socio {
	int id;       
	String nombre;
	String apellido;
	String direccion;
	String poblacion;
	String provincia;
	String dni;
	
	public Socio(int id, String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.dni = dni;
	}
	
	public void mostrarInfo(){
		System.out.println("id: " + this.id
				+ " nombre: " + this.nombre
				+ " apellido: " + this.apellido
				+ " direccion: " + this.direccion
				+ " problacion: " + this.poblacion
				+ " provincia: " + this.provincia
				+ " dni: " + this.dni);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	

	
	
	
	
}
