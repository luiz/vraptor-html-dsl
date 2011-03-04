package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;

/**
 * <p>
 * This is the interface that a page written using the DSL should implement.
 * </p>
 *
 * @author luiz
 *
 */
public interface Page {
	/**
	 * <p>
	 * This method returns the root element of the page. This element will be
	 * later processed by the {@link PageProcessor} and transformed into raw
	 * HTML.
	 * </p>
	 * <p>
	 * If there is no single root element, you can return a {@link Elements}.
	 * </p>
	 *
	 * @return An object that represents the HTML to be generated
	 * @see PageProcessor#process(Page)
	 * @see Elements
	 */
	public NestedElement render();
}
