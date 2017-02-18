package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Socio_modelo extends Conector{

	Socio_modelo(String dbIzena) {
		super(dbIzena);
	}
	
	ArrayList <Socio> select(){
		ArrayList<Socio> socios = new ArrayList<Socio>(); 
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");
			while(rs.next()){
				socios.add(new Socio(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("poblacion"), rs.getString("provincia"), rs.getString("dni")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socios;
	}

}
