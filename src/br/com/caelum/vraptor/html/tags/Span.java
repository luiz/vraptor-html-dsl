package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

public class Span implements Tag {

	private final Tag[] children;
	private final Attributes attributes;

	public Span(Attributes attributes, Tag... children) {
		this.attributes = attributes;
		this.children = children;
	}

	public Attributes getAttributes() {
		return this.attributes;
	}

	public Tag[] getChildren() {
		return this.children;
	}
}
