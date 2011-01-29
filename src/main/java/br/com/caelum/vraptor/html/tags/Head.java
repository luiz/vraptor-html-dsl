package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;
import br.com.caelum.vraptor.html.tags.interfaces.structure.HeadTagChild;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;
import br.com.caelum.vraptor.html.transformers.TagTransformer;

public class Head implements Tag {

	private final HeadTagChild[] children;
	private final Attributes attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	public Head(Attributes attributes, HeadTagChild... children) {
		this.attributes = attributes;
		this.children = children;
	}

	public Attributes getAttributes() {
		return this.attributes;
	}

	public HeadTagChild[] getChildren() {
		return this.children;
	}

	public String toHtml() {
		return tagTransformer.transform(this);
	}
}
