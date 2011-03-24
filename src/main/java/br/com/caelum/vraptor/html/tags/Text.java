package br.com.caelum.vraptor.html.tags;

import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;

/**
 * <p>
 * This class represents text inside an HTML document.
 * </p>
 * 
 * @author luiz
 */
public class Text implements NestedElement {
	private final String text;

	public Text(java.lang.Object toBePrinted) {
		this.text = toBePrinted.toString();
	}

	/**
	 * <p>
	 * Just returns the String passed in the constructor
	 * </p>
	 */
	public String toHtml() {
		return this.text;
	}
}
