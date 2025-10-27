package ejercicio1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.Scanner;

public class ejercicio1 {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:ejercicio1.db");
			con.setAutoCommit(false);

			if (con != null) {
				System.out.println("Se creó y/o abrió la base de datos:");
			}

			PreparedStatement createTable = con.prepareStatement(
				"CREATE TABLE IF NOT EXISTS Personaje (id INTEGER PRIMARY KEY, nombre TEXT, ataque INTEGER, defensa INTEGER );"
			);
			createTable.executeUpdate();
			System.out.println("Creación de tabla exitosa");

			boolean check = true;
			final String CLAVE = "ejercicio1"; 

			while (check) {
				System.out.println();
				System.out.println("Bienvenido al menu de opciones, elija un operación:");
				System.out.println("1. Ingresar datos");
				System.out.println("2. Eliminar datos");
				System.out.println("3. Actualizar datos");
				System.out.println("4. Mostrar datos");
				System.out.println("5. Salir del programa");

				int opcion;
				try {
					opcion = Integer.parseInt(myObj.nextLine());
				} catch (Exception ex) {
					System.out.println("Entrada no válida, intente de nuevo.");
					continue;
				}

				switch (opcion) {
				case 1: // Ingresar datos
					try {
						System.out.print("Ingrese id (entero): ");
						int id = Integer.parseInt(myObj.nextLine());
						System.out.print("Ingrese nombre: ");
						String nombre = myObj.nextLine();
						System.out.print("Ingrese ataque (entero): ");
						int ataque = Integer.parseInt(myObj.nextLine());
						System.out.print("Ingrese defensa (entero): ");
						int defensa = Integer.parseInt(myObj.nextLine());

						PreparedStatement insert = con.prepareStatement(
							"INSERT INTO Personaje (id, nombre, ataque, defensa) VALUES (?, ?, ?, ?);"
						);
						insert.setInt(1, id);
						insert.setString(2, nombre);
						insert.setInt(3, ataque);
						insert.setInt(4, defensa);
						insert.executeUpdate();

						System.out.print("Ingrese la clave para confirmar inserción: ");
						String clave = myObj.nextLine();
						if (CLAVE.equals(clave)) {
							con.commit();
							System.out.println("Inserción confirmada y commit realizado.");
						} else {
							con.rollback();
							System.out.println("Clave incorrecta. Inserción revertida (rollback).");
						}
					} catch (Exception e) {
						try { con.rollback(); } catch (Exception ex) {}
						System.out.println("Error al ingresar datos: " + e.getMessage());
					}
					break;

				case 2: // Eliminar datos
					try {
						System.out.print("Ingrese el id del registro a eliminar: ");
						int idDel = Integer.parseInt(myObj.nextLine());

						PreparedStatement delete = con.prepareStatement(
							"DELETE FROM Personaje WHERE id = ?;"
						);
						delete.setInt(1, idDel);
						int afectados = delete.executeUpdate();

						if (afectados == 0) {
							System.out.println("No existe un registro con ese id.");
							con.rollback();
							break;
						}

						System.out.print("Ingrese la clave para confirmar eliminación: ");
						String clave = myObj.nextLine();
						if (CLAVE.equals(clave)) {
							con.commit();
							System.out.println("Eliminación confirmada y commit realizado.");
						} else {
							con.rollback();
							System.out.println("Clave incorrecta. Eliminación revertida (rollback).");
						}
					} catch (Exception e) {
						try { con.rollback(); } catch (Exception ex) {}
						System.out.println("Error al eliminar datos: " + e.getMessage());
					}
					break;

				case 3: // Actualizar datos
					try {
						System.out.print("Ingrese el id del registro a actualizar: ");
						int idUpd = Integer.parseInt(myObj.nextLine());

						PreparedStatement exists = con.prepareStatement("SELECT COUNT(*) FROM Personaje WHERE id = ?;");
						exists.setInt(1, idUpd);
						ResultSet rsExists = exists.executeQuery();
						boolean encontrado = false;
						if (rsExists.next()) {
							encontrado = rsExists.getInt(1) > 0;
						}
						rsExists.close();

						if (!encontrado) {
							System.out.println("No existe un registro con ese id.");
							con.rollback();
							break;
						}

						System.out.print("Ingrese nuevo nombre: ");
						String nuevoNombre = myObj.nextLine();
						System.out.print("Ingrese nuevo ataque (entero): ");
						int nuevoAtaque = Integer.parseInt(myObj.nextLine());
						System.out.print("Ingrese nueva defensa (entero): ");
						int nuevaDefensa = Integer.parseInt(myObj.nextLine());

						PreparedStatement update = con.prepareStatement(
							"UPDATE Personaje SET nombre = ?, ataque = ?, defensa = ? WHERE id = ?;"
						);
						update.setString(1, nuevoNombre);
						update.setInt(2, nuevoAtaque);
						update.setInt(3, nuevaDefensa);
						update.setInt(4, idUpd);
						update.executeUpdate();

						System.out.print("Ingrese la clave para confirmar actualización: ");
						String clave = myObj.nextLine();
						if (CLAVE.equals(clave)) {
							con.commit();
							System.out.println("Actualización confirmada y commit realizado.");
						} else {
							con.rollback();
							System.out.println("Clave incorrecta. Actualización revertida (rollback).");
						}
					} catch (Exception e) {
						try { con.rollback(); } catch (Exception ex) {}
						System.out.println("Error al actualizar datos: " + e.getMessage());
					}
					break;

				case 4: // Mostrar datos
					try {
						PreparedStatement select = con.prepareStatement("SELECT * FROM Personaje;");
						ResultSet rs = select.executeQuery();
						boolean any = false;
						while (rs.next()) {
							any = true;
							System.out.println(
								rs.getInt("id") + " " +
								rs.getString("nombre") + " " +
								rs.getInt("ataque") + " " +
								rs.getInt("defensa")
							);
						}
						if (!any) {
							System.out.println("No hay registros para mostrar.");
						}
						rs.close();
						
					} catch (Exception e) {
						System.out.println("Error al mostrar datos: " + e.getMessage());
					}
					break;

				case 5:
					check = false;
					System.out.println("Se cerrará el programa.");
					break;

				default:
					System.out.println("No eligió una opción válida.");
				}
			}

			con.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			myObj.close();
		}
	}
}
