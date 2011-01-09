package br.com.caelum.vraptor.html.attributes;

public class Value implements Attribute {
	private final String value;
	public Value(String value) {
		this.value = value;
	}
	@Override
	public String getValue() {
		return value;
	}

}
