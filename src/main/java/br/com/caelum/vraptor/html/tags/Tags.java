package br.com.caelum.vraptor.html.tags;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.vraptor.html.attributes.Attributes;

public class Tags implements Tag {

	private final List<Tag> children = new LinkedList<Tag>();

	@Override
	public Tag[] getChildren() {
		return children.toArray(new Tag[0]);
	}

	@Override
	public Attributes getAttributes() {
		return new Attributes();
	}

	public void append(Tag child) {
		children.add(child);
	}

}
