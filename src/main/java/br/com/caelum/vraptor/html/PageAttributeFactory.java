package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.attributes.Href;
import br.com.caelum.vraptor.html.attributes.Lang;
import br.com.caelum.vraptor.html.attributes.Name;
import br.com.caelum.vraptor.html.attributes.Type;
import br.com.caelum.vraptor.html.attributes.Value;

/**
 * <p>
 * Collection of factory methods to objects that represent HTML tags'
 * attributes.
 * </p>
 *
 * @author luiz
 */
public class PageAttributeFactory {

	public static Href href(Url value) {
		return new Href(value);
	}

	public static Lang lang(String value) {
		return new Lang(value);
	}

	public static Attributes attrs(Attribute... attributes) {
		return new Attributes(attributes);
	}

	public static Type type(String value) {
		return new Type(value);
	}
	public static Value value(String value) {
		return new Value(value);
	}
	public static Name name(String value) {
		return new Name(value);
	}
}
