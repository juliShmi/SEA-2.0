package de.telekom.sea2;

import java.io.IOException;
import java.sql.SQLException;

import de.telekom.sea2.lookup.Salutation;
import de.telekom.sea2.model.Person;
import de.telekom.sea2.persistence.PersonRepository;
import de.telekom.sea2.ui.Menu;

import java.util.Scanner;

public class SeminarApp {

	public void run(String[] args) throws ClassNotFoundException, SQLException {
		Menu menu = new Menu();
		try {
			menu.keepAsking();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
