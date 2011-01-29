package br.com.caelum.vraptor.html.attributes;

public class Alt implements Attribute {

	private final String value;

	public Alt(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
