package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

public interface Tag {
	public Tag[] getChildren();
	public Attributes getAttributes();
}
