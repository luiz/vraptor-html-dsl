package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;
import br.com.caelum.vraptor.html.transformers.TagTransformer;

public class P implements Tag {

	private NestedElement[] children = new NestedElement[0];
	private final Attribute[] attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public P(Attribute... attributes) {
		this.attributes = attributes;
	}

	public Attribute[] getAttributes() {
		return this.attributes;
	}

	public NestedElement[] getChildren() {
		return this.children;
	}

	public String toHtml() {
		return tagTransformer.transform(this);
	}

	public Tag with(NestedElement... children) {
		this.children = children;
		return this;
	}

	public Tag with(java.lang.Object content) {
		return with(new Text(content));
	}

	public Tag with(NestedElement child) {
		this.children = new NestedElement[] { child };
		return this;
	}
}
