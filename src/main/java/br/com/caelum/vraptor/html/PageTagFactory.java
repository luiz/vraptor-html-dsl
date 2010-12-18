package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.attributes.Href;
import br.com.caelum.vraptor.html.tags.A;
import br.com.caelum.vraptor.html.tags.Body;
import br.com.caelum.vraptor.html.tags.Head;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.P;
import br.com.caelum.vraptor.html.tags.Span;
import br.com.caelum.vraptor.html.tags.Tag;
import br.com.caelum.vraptor.html.tags.Text;
import br.com.caelum.vraptor.html.tags.Title;

public class PageTagFactory {
	public static Html html(Tag... children) {
		return new Html(new Attributes(), children);
	}

	public static Html html(Attributes attributes, Tag... children) {
		return new Html(attributes, children);
	}

	public static Html html(String content) {
		return new Html(new Attributes(), new Text(content));
	}

	public static Html html(Attributes attributes, String content) {
		return new Html(attributes, new Text(content));
	}
	public static Head head(Tag... children) {
		return new Head(new Attributes(), children);
	}

	public static Head head(Attributes attributes, Tag... children) {
		return new Head(attributes, children);
	}

	public static Head head(String content) {
		return new Head(new Attributes(), new Text(content));
	}

	public static Head head(Attributes attributes, String content) {
		return new Head(attributes, new Text(content));
	}
	public static Title title(Tag... children) {
		return new Title(new Attributes(), children);
	}

	public static Title title(Attributes attributes, Tag... children) {
		return new Title(attributes, children);
	}

	public static Title title(String content) {
		return new Title(new Attributes(), new Text(content));
	}

	public static Title title(Attributes attributes, String content) {
		return new Title(attributes, new Text(content));
	}
	public static Body body(Tag... children) {
		return new Body(new Attributes(), children);
	}

	public static Body body(Attributes attributes, Tag... children) {
		return new Body(attributes, children);
	}

	public static Body body(String content) {
		return new Body(new Attributes(), new Text(content));
	}

	public static Body body(Attributes attributes, String content) {
		return new Body(attributes, new Text(content));
	}
	public static P p(Tag... children) {
		return new P(new Attributes(), children);
	}

	public static P p(Attributes attributes, Tag... children) {
		return new P(attributes, children);
	}

	public static P p(String content) {
		return new P(new Attributes(), new Text(content));
	}

	public static P p(Attributes attributes, String content) {
		return new P(attributes, new Text(content));
	}
	public static A a(Tag... children) {
		return new A(new Attributes(), children);
	}

	public static A a(Attributes attributes, Tag... children) {
		return new A(attributes, children);
	}

	public static A a(String content) {
		return new A(new Attributes(), new Text(content));
	}

	public static A a(Attributes attributes, String content) {
		return new A(attributes, new Text(content));
	}
	public static Text text(String content) {
		return new Text(content);
	}
	public static Attributes attrs(Attribute... attributes) {
		return new Attributes(attributes);
	}
	public static Href href(Link value) {
		return new Href(value);
	}
	public static Span span(Tag... children) {
		return new Span(new Attributes(), children);
	}

	public static Span span(Attributes attributes, Tag... children) {
		return new Span(attributes, children);
	}

	public static Span span(String content) {
		return new Span(new Attributes(), new Text(content));
	}

	public static Span span(Attributes attributes, String content) {
		return new Span(attributes, new Text(content));
	}
}
