package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.structure.HeadTagChild;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;
import br.com.caelum.vraptor.html.transformers.TagTransformer;

public class Title implements HeadTagChild {

	private final NestedElement[] children;
	private final Attributes attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public Title(Attributes attributes, NestedElement... children) {
		this.attributes = attributes;
		this.children = children;
	}

	public Attributes getAttributes() {
		return this.attributes;
	}

	public NestedElement[] getChildren() {
		return this.children;
	}

	public String toHtml() {
		return tagTransformer.transform(this);
	}
}
