package br.com.caelum.vraptor.html.attributes;

import br.com.caelum.vraptor.html.Url;

public class Href implements Attribute {
	private final Url value;
	public Href(Url nextPageLink) {
		this.value = nextPageLink;
	}
	public String getValue() {
		return value.value();
	}
}
