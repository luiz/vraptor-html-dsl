package br.com.caelum.vraptor.html.factories;

import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.alt;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.href;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.rel;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.src;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.type;
import br.com.caelum.vraptor.html.Url;
import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.tags.A;
import br.com.caelum.vraptor.html.tags.Abbr;
import br.com.caelum.vraptor.html.tags.Acronym;
import br.com.caelum.vraptor.html.tags.Address;
import br.com.caelum.vraptor.html.tags.Area;
import br.com.caelum.vraptor.html.tags.B;
import br.com.caelum.vraptor.html.tags.Base;
import br.com.caelum.vraptor.html.tags.Bdo;
import br.com.caelum.vraptor.html.tags.Big;
import br.com.caelum.vraptor.html.tags.Blockquote;
import br.com.caelum.vraptor.html.tags.Body;
import br.com.caelum.vraptor.html.tags.Br;
import br.com.caelum.vraptor.html.tags.Button;
import br.com.caelum.vraptor.html.tags.Caption;
import br.com.caelum.vraptor.html.tags.Cite;
import br.com.caelum.vraptor.html.tags.Code;
import br.com.caelum.vraptor.html.tags.Col;
import br.com.caelum.vraptor.html.tags.Colgroup;
import br.com.caelum.vraptor.html.tags.Dd;
import br.com.caelum.vraptor.html.tags.Del;
import br.com.caelum.vraptor.html.tags.Dfn;
import br.com.caelum.vraptor.html.tags.Div;
import br.com.caelum.vraptor.html.tags.Dl;
import br.com.caelum.vraptor.html.tags.Dt;
import br.com.caelum.vraptor.html.tags.Em;
import br.com.caelum.vraptor.html.tags.Fieldset;
import br.com.caelum.vraptor.html.tags.Form;
import br.com.caelum.vraptor.html.tags.Frame;
import br.com.caelum.vraptor.html.tags.Frameset;
import br.com.caelum.vraptor.html.tags.H1;
import br.com.caelum.vraptor.html.tags.H2;
import br.com.caelum.vraptor.html.tags.H3;
import br.com.caelum.vraptor.html.tags.H4;
import br.com.caelum.vraptor.html.tags.H5;
import br.com.caelum.vraptor.html.tags.H6;
import br.com.caelum.vraptor.html.tags.Head;
import br.com.caelum.vraptor.html.tags.Hr;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.I;
import br.com.caelum.vraptor.html.tags.Iframe;
import br.com.caelum.vraptor.html.tags.Img;
import br.com.caelum.vraptor.html.tags.Input;
import br.com.caelum.vraptor.html.tags.Ins;
import br.com.caelum.vraptor.html.tags.Kbd;
import br.com.caelum.vraptor.html.tags.Label;
import br.com.caelum.vraptor.html.tags.Legend;
import br.com.caelum.vraptor.html.tags.Li;
import br.com.caelum.vraptor.html.tags.Link;
import br.com.caelum.vraptor.html.tags.Map;
import br.com.caelum.vraptor.html.tags.Meta;
import br.com.caelum.vraptor.html.tags.Noframes;
import br.com.caelum.vraptor.html.tags.Noscript;
import br.com.caelum.vraptor.html.tags.Object;
import br.com.caelum.vraptor.html.tags.Ol;
import br.com.caelum.vraptor.html.tags.Optgroup;
import br.com.caelum.vraptor.html.tags.Option;
import br.com.caelum.vraptor.html.tags.P;
import br.com.caelum.vraptor.html.tags.Param;
import br.com.caelum.vraptor.html.tags.Pre;
import br.com.caelum.vraptor.html.tags.Q;
import br.com.caelum.vraptor.html.tags.Samp;
import br.com.caelum.vraptor.html.tags.Script;
import br.com.caelum.vraptor.html.tags.Select;
import br.com.caelum.vraptor.html.tags.Small;
import br.com.caelum.vraptor.html.tags.Span;
import br.com.caelum.vraptor.html.tags.Strong;
import br.com.caelum.vraptor.html.tags.Style;
import br.com.caelum.vraptor.html.tags.Sub;
import br.com.caelum.vraptor.html.tags.Sup;
import br.com.caelum.vraptor.html.tags.Table;
import br.com.caelum.vraptor.html.tags.Tbody;
import br.com.caelum.vraptor.html.tags.Td;
import br.com.caelum.vraptor.html.tags.Text;
import br.com.caelum.vraptor.html.tags.Textarea;
import br.com.caelum.vraptor.html.tags.Tfoot;
import br.com.caelum.vraptor.html.tags.Th;
import br.com.caelum.vraptor.html.tags.Thead;
import br.com.caelum.vraptor.html.tags.Title;
import br.com.caelum.vraptor.html.tags.Tr;
import br.com.caelum.vraptor.html.tags.Tt;
import br.com.caelum.vraptor.html.tags.Ul;
import br.com.caelum.vraptor.html.tags.Var;
import br.com.caelum.vraptor.html.tags.builders.FormFor;

/**
 * <p>
 * Collection of factory methods to objects that represent HTML tags
 * </p>
 *
 * @author luiz
 */
public class PageTagFactory {
	/*
	 * Shortcuts methods
	 */
	public static FormFor formFor(Object resource, Object... fields) {
		return new FormFor(resource);
	}

	public static A link(Url destination) {
		return a(href(destination));
	}

	public static Link css(String cssFile) {
		return link(rel("stylesheet"), type("text/css"), href(cssFile));
	}

	public static Script js(String jsFile) {
		return script(type("text/javascript"), src(jsFile));
	}

	public static Img image(String imageFile, String altText) {
		return img(src(imageFile), alt(altText));
	}

	/*
	 * Tags factory methods
	 */
	public static A a(Attribute... attributes) {
		return new A(attributes);
	}

	public static Abbr abbr(Attribute... attributes) {
		return new Abbr(attributes);
	}

	public static Acronym acronym(Attribute... attributes) {
		return new Acronym(attributes);
	}

	public static Address address(Attribute... attributes) {
		return new Address(attributes);
	}

	public static Area area(Attribute... attributes) {
		return new Area(attributes);
	}

	public static B b(Attribute... attributes) {
		return new B(attributes);
	}

	public static Base base(Attribute... attributes) {
		return new Base(attributes);
	}

	public static Bdo bdo(Attribute... attributes) {
		return new Bdo(attributes);
	}

	public static Big big(Attribute... attributes) {
		return new Big(attributes);
	}

	public static Blockquote blockquote(Attribute... attributes) {
		return new Blockquote(attributes);
	}

	public static Body body(Attribute... attributes) {
		return new Body(attributes);
	}

	public static Br br(Attribute... attributes) {
		return new Br(attributes);
	}

	public static Button button(Attribute... attributes) {
		return new Button(attributes);
	}

	public static Caption caption(Attribute... attributes) {
		return new Caption(attributes);
	}

	public static Cite cite(Attribute... attributes) {
		return new Cite(attributes);
	}

	public static Code code(Attribute... attributes) {
		return new Code(attributes);
	}

	public static Col col(Attribute... attributes) {
		return new Col(attributes);
	}

	public static Colgroup colgroup(Attribute... attributes) {
		return new Colgroup(attributes);
	}

	public static Dd dd(Attribute... attributes) {
		return new Dd(attributes);
	}

	public static Del del(Attribute... attributes) {
		return new Del(attributes);
	}

	public static Dfn dfn(Attribute... attributes) {
		return new Dfn(attributes);
	}

	public static Div div(Attribute... attributes) {
		return new Div(attributes);
	}

	public static Dl dl(Attribute... attributes) {
		return new Dl(attributes);
	}

	public static Dt dt(Attribute... attributes) {
		return new Dt(attributes);
	}

	public static Em em(Attribute... attributes) {
		return new Em(attributes);
	}

	public static Fieldset fieldset(Attribute... attributes) {
		return new Fieldset(attributes);
	}

	public static Form form(Attribute... attributes) {
		return new Form(attributes);
	}

	public static Frame frame(Attribute... attributes) {
		return new Frame(attributes);
	}

	public static Frameset frameset(Attribute... attributes) {
		return new Frameset(attributes);
	}

	public static H1 h1(Attribute... attributes) {
		return new H1(attributes);
	}

	public static H2 h2(Attribute... attributes) {
		return new H2(attributes);
	}

	public static H3 h3(Attribute... attributes) {
		return new H3(attributes);
	}

	public static H4 h4(Attribute... attributes) {
		return new H4(attributes);
	}

	public static H5 h5(Attribute... attributes) {
		return new H5(attributes);
	}

	public static H6 h6(Attribute... attributes) {
		return new H6(attributes);
	}

	public static Head head(Attribute... attributes) {
		return new Head(attributes);
	}

	public static Hr hr(Attribute... attributes) {
		return new Hr(attributes);
	}

	public static Html html(Attribute... attributes) {
		return new Html(attributes);
	}

	public static I i(Attribute... attributes) {
		return new I(attributes);
	}

	public static Iframe iframe(Attribute... attributes) {
		return new Iframe(attributes);
	}

	public static Img img(Attribute... attributes) {
		return new Img(attributes);
	}

	public static Input input(Attribute... attributes) {
		return new Input(attributes);
	}

	public static Ins ins(Attribute... attributes) {
		return new Ins(attributes);
	}

	public static Kbd kbd(Attribute... attributes) {
		return new Kbd(attributes);
	}

	public static Label label(Attribute... attributes) {
		return new Label(attributes);
	}

	public static Legend legend(Attribute... attributes) {
		return new Legend(attributes);
	}

	public static Li li(Attribute... attributes) {
		return new Li(attributes);
	}

	public static Link link(Attribute... attributes) {
		return new Link(attributes);
	}

	public static Map map(Attribute... attributes) {
		return new Map(attributes);
	}

	public static Meta meta(Attribute... attributes) {
		return new Meta(attributes);
	}

	public static Noframes noframes(Attribute... attributes) {
		return new Noframes(attributes);
	}

	public static Noscript noscript(Attribute... attributes) {
		return new Noscript(attributes);
	}

	public static Object object(Attribute... attributes) {
		return new Object(attributes);
	}

	public static Ol ol(Attribute... attributes) {
		return new Ol(attributes);
	}

	public static Optgroup optgroup(Attribute... attributes) {
		return new Optgroup(attributes);
	}

	public static Option option(Attribute... attributes) {
		return new Option(attributes);
	}

	public static P p(Attribute... attributes) {
		return new P(attributes);
	}

	public static Param param(Attribute... attributes) {
		return new Param(attributes);
	}

	public static Pre pre(Attribute... attributes) {
		return new Pre(attributes);
	}

	public static Q q(Attribute... attributes) {
		return new Q(attributes);
	}

	public static Samp samp(Attribute... attributes) {
		return new Samp(attributes);
	}

	public static Script script(Attribute... attributes) {
		return new Script(attributes);
	}

	public static Select select(Attribute... attributes) {
		return new Select(attributes);
	}

	public static Small small(Attribute... attributes) {
		return new Small(attributes);
	}

	public static Span span(Attribute... attributes) {
		return new Span(attributes);
	}

	public static Strong strong(Attribute... attributes) {
		return new Strong(attributes);
	}

	public static Style style(Attribute... attributes) {
		return new Style(attributes);
	}

	public static Sub sub(Attribute... attributes) {
		return new Sub(attributes);
	}

	public static Sup sup(Attribute... attributes) {
		return new Sup(attributes);
	}

	public static Table table(Attribute... attributes) {
		return new Table(attributes);
	}

	public static Tbody tbody(Attribute... attributes) {
		return new Tbody(attributes);
	}

	public static Td td(Attribute... attributes) {
		return new Td(attributes);
	}

	public static Text text(String content) {
		return new Text(content);
	}

	public static Textarea textarea(Attribute... attributes) {
		return new Textarea(attributes);
	}

	public static Tfoot tfoot(Attribute... attributes) {
		return new Tfoot(attributes);
	}

	public static Th th(Attribute... attributes) {
		return new Th(attributes);
	}

	public static Thead thead(Attribute... attributes) {
		return new Thead(attributes);
	}

	public static Title title(Attribute... attributes) {
		return new Title(attributes);
	}

	public static Tr tr(Attribute... attributes) {
		return new Tr(attributes);
	}

	public static Tt tt(Attribute... attributes) {
		return new Tt(attributes);
	}

	public static Ul ul(Attribute... attributes) {
		return new Ul(attributes);
	}

	public static Var var(Attribute... attributes) {
		return new Var(attributes);
	}
}
