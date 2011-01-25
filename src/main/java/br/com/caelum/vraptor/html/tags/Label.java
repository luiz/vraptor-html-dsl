package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;
import br.com.caelum.vraptor.html.transformers.TagTransformer;

public class Label implements Tag {

	private final NestedElement[] children;
	private final Attributes attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public Label(Attributes attributes, NestedElement... children) {
		this.attributes = attributes;
		this.children = children;
	}

	public NestedElement[] getChildren() {
		return children;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public String toHtml() {
		return tagTransformer.transform(this);
	}
}
