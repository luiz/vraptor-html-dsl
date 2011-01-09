package br.com.caelum.vraptor.html.attributes;

public class Type implements Attribute {
	private final String value;
	public Type(String value) {
		this.value = value;
	}
	@Override
	public String getValue() {
		return value;
	}

}
