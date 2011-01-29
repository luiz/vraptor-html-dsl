package br.com.caelum.vraptor.html.factories;

import br.com.caelum.vraptor.html.Url;
import br.com.caelum.vraptor.html.attributes.Alt;
import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.attributes.Href;
import br.com.caelum.vraptor.html.attributes.Id;
import br.com.caelum.vraptor.html.attributes.Lang;
import br.com.caelum.vraptor.html.attributes.Name;
import br.com.caelum.vraptor.html.attributes.Rel;
import br.com.caelum.vraptor.html.attributes.Src;
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

	public static Href href(String value) {
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
	public static Rel rel(String value) {
		return new Rel(value);
	}

	public static Src src(Url jsFile) {
		return new Src(jsFile);
	}

	public static Src src(String jsFile) {
		return new Src(jsFile);
	}

	public static Alt alt(String value) {
		return new Alt(value);
	}

	public static Id id(String value) {
		return new Id(value);
	}
}
