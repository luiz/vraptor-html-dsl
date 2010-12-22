package br.com.caelum.vraptor.html.tags;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Represents a collection of HTML elements (tags or not). Useful for inserting
 * many elements at once into another tag.
 * </p>
 *
 * @author luiz
 *
 */
public class Elements implements NestedElement {

	private final List<NestedElement> children = new LinkedList<NestedElement>();

	/**
	 * <p>
	 * Adds a {@link NestedElement} to the end of this collection of elements.
	 * </p>
	 *
	 * @param child
	 *            The element to be inserted
	 */
	public void append(NestedElement child) {
		children.add(child);
	}

	/**
	 * <p>
	 * Factory method to an instance of {@link ElementsBuilder}. Used for the sake
	 * of readability.
	 * </p>
	 *
	 * @param <T>
	 *            Type of the objects to be transformed into HTML elements
	 * @param objects
	 *            List of objects to be transformed into HTML elements
	 * @return A fresh new instance of a {@link ElementsBuilder} for the given
	 *         object list
	 */
	public static <T> ElementsBuilder<T> format(List<T> objects) {
		return new ElementsBuilder<T>(objects);
	}

	/**
	 * <p>
	 * Transforms each {@link NestedElement} previously appended to HTML.
	 * </p>
	 *
	 * @return The concatenation of each nested element's transformation to
	 *         HTML.
	 * @see NestedElement#toHtml()
	 */
	public String toHtml() {
		StringBuilder sb = new StringBuilder();
		for (NestedElement child : children) {
			sb.append(child.toHtml());
		}
		return sb.toString();
	}

}
