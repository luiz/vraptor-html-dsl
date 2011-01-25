package br.com.caelum.vraptor.html.tags.interfaces;

import br.com.caelum.vraptor.html.attributes.Attributes;

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
	public Attributes getAttributes();

}
