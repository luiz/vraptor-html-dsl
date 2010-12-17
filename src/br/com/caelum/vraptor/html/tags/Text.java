package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.attributes.Attributes;

/**
 * The ugly duck
 * @author luiz
 */
public class Text implements Tag {
	private final String text;

	public Text(String text) {
		this.text = text;
	}

	public Attributes getAttributes() {
		return null;
	}

	public Tag[] getChildren() {
		return null;
	}

	public String getText() {
		return this.text;
	}
}
