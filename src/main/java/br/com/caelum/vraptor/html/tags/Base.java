package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;
import br.com.caelum.vraptor.html.transformers.TagTransformer;

public class Base implements Tag {

	private static NestedElement[] EMPTY = new NestedElement[0];
	private final Attribute[] attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public Base(Attribute[] atrtibutes) {
		this.attributes = atrtibutes;
	}

	public NestedElement[] getChildren() {
		return EMPTY;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}

	public String toHtml() {
		return tagTransformer.transform(this);
	}

	public Tag with(NestedElement... children) {
		return this;
	}

	public Tag with(java.lang.Object content) {
		return this;
	}

	public Tag with(NestedElement child) {
		return this;
	}
}
