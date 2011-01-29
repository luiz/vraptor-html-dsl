package br.com.caelum.vraptor.html.attributes;

public class Rel implements Attribute {

	private final String value;

	public Rel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
