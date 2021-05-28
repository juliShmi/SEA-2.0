package de.telekom.sea2.model;

import de.telekom.sea2.lookup.Salutation;

public class Person {

	private long id;
	private Salutation salutation;
	private String firstname;
	private String lastname;

	public Salutation getSalutation() {
		return salutation;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSalutation(Salutation salutation) {
		if (salutation instanceof Salutation) {
			this.salutation = salutation;
		}
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		try {
			this.firstname = firstname;
		} catch (NullPointerException | StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		try {
			this.lastname = lastname;
		} catch (NullPointerException | StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}
