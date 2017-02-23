package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Libro_modelo extends Conector{

	public Libro_modelo(String dbIzena) {
		super(dbIzena);
	}
	
	public ArrayList <Libro> select(){
		ArrayList<Libro> libros = new ArrayList<Libro>(); 
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros");
			while(rs.next()){
				libros.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("num_pag")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}
	
	public Libro select(int id){
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros WHERE id ='" + id + "';");
			rs.next();
			Libro libro = new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("num_pag"));
			return libro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Libro> select(String autor){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros WHERE autor ='" + autor + "'");
			while(rs.next()){
				Libro libro = new Libro(rs.getInt("id"),rs.getString("titulo"),rs.getString("autor"),rs.getInt("num_pag"));
				libros.add(libro);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}

	
	public void insert(Libro libro){
		try {
			PreparedStatement ps = this.conexion.prepareStatement("insert into libros (titulo, autor, num_pag) values(?,?,?)");
			
			ps.setString(1, libro.getTitulo()); //lehen galdera ikurra bete
			ps.setString(2, libro.getAutor()); //bigarren galdera ikurra bete
			ps.setInt(3, libro.getNum_pag()); //hirugarren galdera ikurra
		
			ps.execute();
//			Statement st = this.conexion.createStatement();
//
//			st.execute("INSERT INTO `libros`(`titulo`, `autor`, `num_pag`) VALUES ('" + libro.getTitulo()+"', '" +libro.getAutor()+"','"+libro.getNum_pag()+ "')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int update(Libro libro){
		PreparedStatement ps;
		try {
			ps = this.conexion.prepareStatement("update libros set titulo=?, autor=?, num_pag=? where id=?");
			//set
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setInt(3, libro.getNum_pag());
			//where
			ps.setInt(4, libro.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void delete(int id_libro){
		try {
			Statement st = this.conexion.createStatement();
			st.execute("delete from libros where id=" + id_libro);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
