package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ReleveDB {

	static String db = "jdbc:mysql://localhost:3306/examen";
	static String user = "root";
	static String pwd = "";

	static {

		try {

		//	Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection openConnection() {

		Connection cn;
		try {
			cn = DriverManager.getConnection(db, user, pwd);
			return cn;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return null;
	}

	

	public static ArrayList<Note> getNotes(String cin) {

		ArrayList<Note> notes = new ArrayList<Note>();
		Note note;
		Connection cnx = openConnection();

		try {
			PreparedStatement ps = cnx.prepareStatement("select * from notes where cin = ? ");
			ps.setString(1, cin);
			ResultSet res = ps.executeQuery();

			while (res.next()) {

				note = new Note(res.getString(3), res.getDouble(4), res.getDouble(5));
				notes.add(note);
			}
			cnx.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return notes;

	}

	public static Etudiant seConnecter(String login, String pwd) {

		Etudiant etu = null;
		Connection cnx = openConnection();

		try {
			PreparedStatement ps = cnx.prepareStatement("select * from etudiants where login =? and pwd= ? ");
			ps.setString(1, login);
			ps.setString(2, pwd);
			ResultSet res = ps.executeQuery();

			if (res.next())

				etu = new Etudiant(res.getString(2), res.getString(3), res.getString(4));

			cnx.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return etu;

	}

}
