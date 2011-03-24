package br.com.caelum.vraptor.html.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
	private final String name;
	private final Calendar birthDate;
	private final Sex sex;

	public Person(String name, Calendar birthDate, Sex sex) {
		this.name = name;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + this.name + ", birthDate=" + this.getFormattedBirthDate()
				+ ", sex=" + this.sex + "]";
	}

	public String getFormattedBirthDate() {
		return new SimpleDateFormat("MM/dd/yyyy").format(getBirthDate().getTime());
	}
}
