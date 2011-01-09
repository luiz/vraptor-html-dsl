package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

public class Input implements Tag {

	private final NestedElement[] children;
	private final Attributes attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public Input(Attributes attributes, NestedElement... children) {
		this.attributes = attributes;
		this.children = children;
	}
	
	@Override
	public String toHtml() {
		return tagTransformer.transform(this);
	}

	@Override
	public NestedElement[] getChildren() {
		return children;
	}

	@Override
	public Attributes getAttributes() {
		return attributes;
	}

}
