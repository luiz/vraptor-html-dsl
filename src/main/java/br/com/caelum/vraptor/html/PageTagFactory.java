package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.tags.A;
import br.com.caelum.vraptor.html.tags.Base;
import br.com.caelum.vraptor.html.tags.Body;
import br.com.caelum.vraptor.html.tags.FormFor;
import br.com.caelum.vraptor.html.tags.Head;
import br.com.caelum.vraptor.html.tags.HeadTag;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.Input;
import br.com.caelum.vraptor.html.tags.Li;
import br.com.caelum.vraptor.html.tags.NestedElement;
import br.com.caelum.vraptor.html.tags.Ol;
import br.com.caelum.vraptor.html.tags.P;
import br.com.caelum.vraptor.html.tags.Span;
import br.com.caelum.vraptor.html.tags.Text;
import br.com.caelum.vraptor.html.tags.Title;

/**
 * <p>
 * Collection of factory methods to objects that represent HTML tags
 * </p>
 *
 * @author luiz
 */
public class PageTagFactory {
	public static Html html(NestedElement... children) {
		return new Html(new Attributes(), children);
	}

	public static Html html(Attributes attributes, NestedElement... children) {
		return new Html(attributes, children);
	}

	public static Html html(String content) {
		return new Html(new Attributes(), new Text(content));
	}

	public static Html html(Attributes attributes, String content) {
		return new Html(attributes, new Text(content));
	}

	public static Head head(HeadTag... children) {
		return new Head(new Attributes(), children);
	}

	public static Head head(Attributes attributes, HeadTag... children) {
		return new Head(attributes, children);
	}

	public static Title title(NestedElement... children) {
		return new Title(new Attributes(), children);
	}

	public static Title title(Attributes attributes, NestedElement... children) {
		return new Title(attributes, children);
	}

	public static Title title(String content) {
		return new Title(new Attributes(), new Text(content));
	}

	public static Title title(Attributes attributes, String content) {
		return new Title(attributes, new Text(content));
	}

	public static Body body(NestedElement... children) {
		return new Body(new Attributes(), children);
	}

	public static Body body(Attributes attributes, NestedElement... children) {
		return new Body(attributes, children);
	}

	public static Body body(String content) {
		return new Body(new Attributes(), new Text(content));
	}

	public static Body body(Attributes attributes, String content) {
		return new Body(attributes, new Text(content));
	}

	public static P p(NestedElement... children) {
		return new P(new Attributes(), children);
	}

	public static P p(Attributes attributes, NestedElement... children) {
		return new P(attributes, children);
	}

	public static P p(String content) {
		return new P(new Attributes(), new Text(content));
	}

	public static P p(Attributes attributes, String content) {
		return new P(attributes, new Text(content));
	}

	public static A a(NestedElement... children) {
		return new A(new Attributes(), children);
	}

	public static A a(Attributes attributes, NestedElement... children) {
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

	public static Span span(NestedElement... children) {
		return new Span(new Attributes(), children);
	}

	public static Span span(Attributes attributes, NestedElement... children) {
		return new Span(attributes, children);
	}

	public static Span span(String content) {
		return new Span(new Attributes(), new Text(content));
	}

	public static Span span(Attributes attributes, String content) {
		return new Span(attributes, new Text(content));
	}

	public static Li li(NestedElement... children) {
		return new Li(new Attributes(), children);
	}

	public static Li li(Attributes attributes, NestedElement... children) {
		return new Li(attributes, children);
	}

	public static Li li(String content) {
		return new Li(new Attributes(), new Text(content));
	}

	public static Li li(Attributes attributes, String content) {
		return new Li(attributes, new Text(content));
	}

	public static Ol ol(NestedElement... children) {
		return new Ol(new Attributes(), children);
	}

	public static Ol ol(Attributes attributes, NestedElement... children) {
		return new Ol(attributes, children);
	}

	public static Ol ol(String content) {
		return new Ol(new Attributes(), new Text(content));
	}

	public static Ol ol(Attributes attributes, String content) {
		return new Ol(attributes, new Text(content));
	}

	public static Base base(Attributes attributes) {
		return new Base(attributes);
	}
	
	public static FormFor formFor(Object resource, Object... fields) {
		return new FormFor(resource, new Attributes());
	}
	
	public static Input input(Attributes attributes) {
		return new Input(attributes);
	}
	
	public static Input input(NestedElement... children) {
		return new Input(new Attributes(), children);
	}

	public static Input input(Attributes attributes, NestedElement... children) {
		return new Input(attributes, children);
	}
}
