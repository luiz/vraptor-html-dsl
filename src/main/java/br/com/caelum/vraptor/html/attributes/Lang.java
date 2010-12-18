package br.com.caelum.vraptor.html.attributes;

public class Lang implements Attribute {
	private final String value;
	public Lang(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}
