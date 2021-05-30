package de.telekom.sea2.persistence;

import de.telekom.sea2.model.Person;

public interface CRUD {

	boolean create(Person person);

	Person read(long id);

	boolean update(Person person);

	boolean delete(long id);

}
