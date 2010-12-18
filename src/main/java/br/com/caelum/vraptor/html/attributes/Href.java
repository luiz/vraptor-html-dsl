package br.com.caelum.vraptor.html.attributes;

import br.com.caelum.vraptor.html.Link;

public class Href implements Attribute {
	private final Link value;
	public Href(Link nextPageLink) {
		this.value = nextPageLink;
	}
	public String getValue() {
		return value.url();
	}
}
