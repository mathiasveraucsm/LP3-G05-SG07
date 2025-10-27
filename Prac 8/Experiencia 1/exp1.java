package exp1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class exp1 {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:exp1.db");
			con.setAutoCommit(false); 

			if (con != null) {
				System.out.println("Se creó y/o abrió la base de datos:");
			}

			PreparedStatement createTable = con.prepareStatement(
				"CREATE TABLE IF NOT EXISTS Libro (id INTEGER PRIMARY KEY, titulo TEXT, autor TEXT);"
			);
			createTable.executeUpdate();
			System.out.println("Creación de tabla exitosa");

			PreparedStatement insert = con.prepareStatement("INSERT INTO Libro VALUES (?, ?, ?)");
			insert.setInt(1, 1);
			insert.setString(2, "Harry Potter");
			insert.setString(3, "J.K. Rowling");
			insert.executeUpdate();

			insert.setInt(1, 2);
			insert.setString(2, "El Hobbit");
			insert.setString(3, "J.R.R. Tolkien");
			insert.executeUpdate();

			insert.setInt(1, 3);
			insert.setString(2, "La Metamorfosis");
			insert.setString(3, "Franz Kafka");
			insert.executeUpdate();

			System.out.println("Inserción exitosa");

			PreparedStatement select = con.prepareStatement("SELECT * FROM Libro");
			ResultSet rs = select.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

			PreparedStatement update = con.prepareStatement(
				"UPDATE Libro SET titulo = ? WHERE id = ?"
			);
			update.setString(1, "El Señor de los Anillos");
			update.setInt(2, 2);
			update.executeUpdate();

			System.out.println("******************************************");
			System.out.println("Actualización exitosa");
			rs = select.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

			PreparedStatement delete = con.prepareStatement("DELETE FROM Libro WHERE id = ?");
			delete.setInt(1, 1);
			delete.executeUpdate();

			System.out.println("******************************************");
			System.out.println("Eliminación exitosa");
			rs = select.executeQuery();
			while (rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

			con.commit(); 
			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
