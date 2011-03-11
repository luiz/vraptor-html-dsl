package br.com.caelum.vraptor.html.attributes;

public class Class implements Attribute {

	private final String value;

	public Class(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
