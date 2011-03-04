package br.com.caelum.vraptor.html.tags.interfaces;

import br.com.caelum.vraptor.html.attributes.Attribute;

/**
 * <p>
 * A class that represents a HTML tag.
 * </p>
 *
 * @author luiz
 */
public interface Tag extends NestedElement {

	/**
	 * <p>
	 * Requests every nested tag of this tag.
	 * </p>
	 *
	 * @return An array with the nested tags
	 */
	public NestedElement[] getChildren();

	/**
	 * <p>
	 * Requests the attributes of this tag.
	 * </p>
	 *
	 * @return An object that represents this tag's attributes
	 */
	public Attribute[] getAttributes();

	/**
	 * <p>
	 * Set the children of this tag.
	 * </p>
	 *
	 * @param children
	 *            The NestedElements representing the children of this tag
	 * @return This method should return the object itself, as to allow the
	 *         following use: <code>html().with(body().with(text("Hi")))</code>
	 */
	public Tag with(NestedElement... children);

	/**
	 * <p>
	 * Set the text inside this tag
	 * </p>
	 *
	 * @param content
	 *            The text to be placed inside this tag
	 * @return This method should return the object itself, as to allow the
	 *         following use: <code>html().with(body().with("Hi"))</code>
	 */
	public Tag with(String content);
}
