package de.telekom.sea2;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		SeminarApp app = new SeminarApp();
		try {
			app.run(args);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}
