package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

public class Html implements Tag {
	private final NestedElement[] children;
	private final Attributes attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public Html(Attributes attributes, NestedElement... children) {
		this.attributes = attributes;
		this.children = children;
	}

	public NestedElement[] getChildren() {
		return this.children;
	}

	public Attributes getAttributes() {
		return this.attributes;
	}

	public String toHtml() {
		return tagTransformer.transform(this);
	}
}
