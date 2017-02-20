package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Socio_modelo extends Conector {

	public Socio_modelo(String dbIzena) {
		super(dbIzena);
	}

	public ArrayList<Socio> select() {
		ArrayList<Socio> socios = new ArrayList<Socio>();
		try {
			Statement st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");
			while (rs.next()) {
				socios.add(new Socio(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("direccion"), rs.getString("poblacion"), rs.getString("provincia"),
						rs.getString("dni")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socios;
	}

	public void insert(Socio socio) {
		Statement st;
		try {
			st = super.getConexion().createStatement();
			st.execute("INSERT INTO socios (nombre,apellido,direccion,poblacion,provincia,dni) " + "VALUES ('"
					+ socio.getNombre() + "','" + socio.getApellido() + "','" + socio.getDireccion() + "','"
					+ socio.getPoblacion() + "','" + socio.getProvincia() + "','" + socio.getDni() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int update(Socio socio) {
		int lineascambiadas;
		try {
			Statement st = super.getConexion().createStatement();
			lineascambiadas = st.executeUpdate("UPDATE socios " + "SET nombre='" + socio.getNombre() + "'"
					+ ",apellido='" + socio.getApellido() + "'" + ",direccion='" + socio.getDireccion() + "'"
					+ ",poblacion='" + socio.getPoblacion() + "'" + ",provincia='" + socio.getProvincia() + "'"
					+ ",dni='" + socio.getDni() + "'" + " WHERE id=" + socio.getId());
			return lineascambiadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public void delete(int id) {
		try {
			Statement st = super.getConexion().createStatement();
			st.execute("DELETE FROM socios " + "WHERE id= ('" + id + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
