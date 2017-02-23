package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Prestamo_modelo extends Conector {

	Prestamo_modelo(String dbIzena) {
		super(dbIzena);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Prestamo> select() {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from prestamo");
			while (rs.next()) {
				prestamos.add(new Prestamo(rs.getInt("id_libro"), rs.getInt("id_socio"), rs.getDate("fecha"),
						rs.getBoolean("devuelto")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prestamos;
	}
	
	public Prestamo select(int id_libro, int id_socio, Date fecha){
		
		return null;
	}
	
	public void insert(Prestamo prestamo){
		try {
			PreparedStatement ps;
			ps = this.conexion.prepareStatement("insert into prestamos (id_libro,id_socio,fecha,devuelto) values(?,?,?,?)");
			
			ps.setInt(1, prestamo.getId_libro()); 
			ps.setInt(2, prestamo.getId_socio()); 
			java.sql.Date fecha_sql = new java.sql.Date(prestamo.getFecha().getTime());
			ps.setDate(3, fecha_sql); 
			ps.setBoolean(3,false );
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


