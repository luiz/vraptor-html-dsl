package br.com.caelum.vraptor.html.attributes;

public class Id implements Attribute {

	private final String value;

	public Id(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
