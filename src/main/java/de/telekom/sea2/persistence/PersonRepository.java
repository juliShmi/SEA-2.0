package de.telekom.sea2.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.telekom.sea2.model.Person;

public class PersonRepository {
	private Person p;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	final static String DRIVER = "org.mariadb.jdbc.Driver";

	public PersonRepository() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seadb", "seauser", "seapass");
		this.statement = connection.createStatement();
	}

	public boolean create(Person p) throws SQLException {
		while (true) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO personen ( ID, ANREDE, VORNAME, NACHNAME) VALUES ( ?, ?, ?, ? )");
			preparedStatement.setLong(1, p.getId());
			preparedStatement.setObject(2, p.getSalutation()); // Object?
			preparedStatement.setString(3, p.getFirstname());
			preparedStatement.setString(4, p.getLastname());
			preparedStatement.execute();
		}
	}

	public boolean update(Person p) {
		return true;
	}

	public void get(long id) throws SQLException {
		resultSet = statement.executeQuery("SELECT * FROM personen WHERE ID = " + id + "");

	}

	public String[] getAll() throws SQLException {
		resultSet = statement.executeQuery("SELECT * FROM personen");
		while (resultSet.next()) {
			System.out.println("ID: " + resultSet.getLong(1)); // ID
			System.out.println("Anrede: " + resultSet.getObject(2)); // Anrede
			System.out.println("Vorname: " + resultSet.getString(3)); // Vorname
			System.out.println("Nachname: " + resultSet.getString(4)); // Nachname
		}
		return null;
	}

	public boolean delete(Person p) throws SQLException {
		resultSet = statement.executeQuery("SELECT * FROM personen WHERE ID = " + p.getId() + ", ANREDE = " + p.getSalutation() + " , FIRSTNAME = " + p.getFirstname() + " , LASTNAME = " + p.getLastname() + "");
		return true;
	}

	public boolean deleteAll() throws SQLException {
		resultSet = statement.executeQuery("DELETE from personen");
		return true;
	}

	public boolean delete(long id) throws SQLException {
		resultSet = statement.executeQuery("DELETE FROM personen WHERE ID = " + id + "");
		return true;
	}

}
