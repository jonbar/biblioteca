package modelo;

public class Libro {
	private int id;
	private String titulo;
	private String autor;
	private int num_pag;
	
	public Libro(int id, String titulo, String autor, int num_pag) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.num_pag = num_pag;
	}
	
	public void mostrarInfo(){
		System.out.println("id: "+ this.id
				+ " titulo: " + this.titulo
				+ " autor: " + this.autor 
				+ " paginas: " + this.num_pag);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNum_pag() {
		return num_pag;
	}

	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}
	
	
}
