package br.com.caelum.vraptor.html.attributes;

public class Name implements Attribute{
	private final String value;
	public Name(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}
