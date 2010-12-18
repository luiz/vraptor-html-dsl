package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

public class Li implements Tag {
	private final Attributes attributes;
	private final Tag[] children;

	public Li(Attributes attributes, Tag... children) {
		this.attributes = attributes;
		this.children = children;

	}

	@Override
	public Tag[] getChildren() {
		return children;
	}

	@Override
	public Attributes getAttributes() {
		return attributes;
	}

}
