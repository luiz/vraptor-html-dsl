package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

public class Html implements Tag {
	private final Tag[] children;
	private final Attributes attributes;

	public Html(Attributes attributes, Tag... children) {
		this.attributes = attributes;
		this.children = children;
	}

	public Tag[] getChildren() {
		return this.children;
	}

	public Attributes getAttributes() {
		return this.attributes;
	}

}
