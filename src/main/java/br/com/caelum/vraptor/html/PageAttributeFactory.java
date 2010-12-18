package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.attributes.Href;
import br.com.caelum.vraptor.html.attributes.Lang;

/**
 * <p>
 * Collection of factory methods to objects that represent HTML tags'
 * attributes.
 * </p>
 *
 * @author luiz
 */
public class PageAttributeFactory {

	public static Href href(Link value) {
		return new Href(value);
	}

	public static Lang lang(String value) {
		return new Lang(value);
	}

	public static Attributes attrs(Attribute... attributes) {
		return new Attributes(attributes);
	}

}
