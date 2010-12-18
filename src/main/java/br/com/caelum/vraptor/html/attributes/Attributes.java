package br.com.caelum.vraptor.html.attributes;

public class Attributes {
	private final Attribute[] attributes;

	public Attributes(Attribute...attributes) {
		this.attributes = attributes;
	}

	public Attribute[] array() {
		return this.attributes;
	}
}
