package br.com.caelum.vraptor.html.tags.interfaces;

import br.com.caelum.vraptor.html.tags.Text;
import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;

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
	 * exceptions are {@link Text} and {@link Elements}, which are not real HTML
	 * tags.
	 * </p>
	 *
	 * @see DefaultTagTransformer
	 */
	public String toHtml();
}
