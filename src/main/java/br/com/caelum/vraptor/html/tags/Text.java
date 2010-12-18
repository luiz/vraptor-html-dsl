package br.com.caelum.vraptor.html.tags;

/**
 * <p>
 * This class represents text inside an HTML document.
 * </p>
 *
 * @author luiz
 */
public class Text implements NestedElement {
	private final String text;

	public Text(String text) {
		this.text = text;
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
