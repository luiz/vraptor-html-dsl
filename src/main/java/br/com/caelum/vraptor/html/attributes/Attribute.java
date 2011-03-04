package br.com.caelum.vraptor.html.attributes;

/**
 * <p>
 * Interface that objects representing tags' attributes should implement.
 * </p>
 *
 * @author luiz
 *
 */
public interface Attribute {
	/**
	 * <p>
	 * Returns the value of this attribute declaration. E.g.: if this object
	 * represents the declaration <code>class="hidden"</code>, then this method
	 * should return the string "hidden".
	 * </p>
	 *
	 * @return The value of this attribute
	 */
	public String getValue();
}
