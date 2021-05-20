package de.telekom.sea2.ui;

import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;

public class Menu {

	private String result;
	private PersonRepository pr;
	private Scanner scanner = new Scanner(System.in);

	public Menu() throws ClassNotFoundException, SQLException {
		pr = new PersonRepository();
	}

	public void keepAsking() throws IOException, ClassNotFoundException, SQLException {
		do {
			showMenu();
			result = inputMenu();
			checkMenu(result);
		} while (!result.equals("7"));

	}

	private void showMenu() {
		System.out.println("Menu: ");
		System.out.println("1: Create person");
		System.out.println("2: Show person by ID");
		System.out.println("3: Show list");
		System.out.println("4: Delete person by ID");
		System.out.println("5: Delete list");
		System.out.println("6: Update person");
		System.out.println("7: Quit");
	}

	private String inputMenu() {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		var input = scanner.nextLine();
		return input;
	}

	private void checkMenu(String eingabe) throws IOException, ClassNotFoundException, SQLException {
		switch (eingabe) {
		case "1":
			System.out.println("1: Create person");
			try {
				inputPerson();
			} catch (SQLIntegrityConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "2":
			System.out.println("2: Show person by ID");
			getPerson();
			break;
		case "3":
			System.out.println("3: Show list");
			getList();
			break;
		case "4":
			System.out.println("4: Delete person by ID");
			removeByID();
			break;
		case "5":
			System.out.println("5: Delete list");
			removeAll();
			break;
		case "6":
			System.out.println("6: Update person");
			update();
			break;
		case "7":
			System.out.println("7: quit");
			break;
		default:
			System.out.println("wrong task");
		}

	}

	private void update() throws SQLException, SQLDataException {
		System.out.println("Input id for person to change: ");
		long id = Long.parseLong(scanner.nextLine());
		Person p = new Person(); //?
		p = pr.get(id);
		p.setId(id);
		System.out.println("Input salutation to change: ");
		Salutation salutation = Salutation.fromString(scanner.nextLine());
		p.setSalutation(salutation);
		System.out.println("Input firstname to change: ");
		String firstname = scanner.nextLine();
		p.setFirstname(firstname);
		System.out.println("Input lastname to change: ");
		String lastname = scanner.nextLine();
		p.setLastname(lastname);
		pr.update(p);

	}

	private void removeAll() throws SQLException {
		pr.deleteAll();
		// TODO Auto-generated method stub

	}

	private void removeByID() throws SQLException {
		System.out.println("Input id: ");
		long id = Long.parseLong(scanner.nextLine());
		pr.delete(id);

		// TODO Auto-generated method stub

	}

	private void getList() throws SQLException {
		pr.getAll();
		// TODO Auto-generated method stub

	}

	private void getPerson() throws SQLException {
		System.out.println("Input id: ");
		long id = Long.parseLong(scanner.nextLine());
		pr.get(id);// TODO Auto-generated method stub

	}

	private void inputPerson() throws SQLIntegrityConstraintViolationException, SQLException, ClassNotFoundException {
		Person p = new Person();
		System.out.println("Input id: ");
		long id = Long.parseLong(scanner.nextLine());
		p.setId(id);

		System.out.println("Input salutation: ");
		Salutation salutation = Salutation.fromString(scanner.nextLine());
		p.setSalutation(salutation);

		System.out.println("Input firstname: ");
		String firstname = scanner.nextLine();
		p.setFirstname(firstname);

		System.out.println("Input lastname: ");
		String lastname = scanner.nextLine();
		p.setLastname(lastname);
		pr.create(p);
	}
	// TODO Auto-generated method stub

}
