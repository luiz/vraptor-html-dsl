package br.com.caelum.vraptor.html.tags;

/**
 * <p>
 * A class that represents a HTML element, either text or a tag.
 * </p>
 *
 * @author luiz
 */
public interface NestedElement {
	/**
	 * <p>
	 * Requests the HTML representation of the object. Usually the
	 * transformation is delegated to {@link DefaultTagTransformer}. The
	 * exceptions are {@link Text} and {@link Tags}, which are not real HTML
	 * tags.
	 * </p>
	 *
	 * @see DefaultTagTransformer
	 */
	public String toHtml();
}
