package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.attributes.Attributes;
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
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.structure.HeadTag;

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

	public static Abbr abbr(NestedElement... children) {
		return new Abbr(new Attributes(), children);
	}

	public static Abbr abbr(Attributes attributes, NestedElement... children) {
		return new Abbr(attributes, children);
	}

	public static Abbr abbr(String content) {
		return new Abbr(new Attributes(), new Text(content));
	}

	public static Abbr abbr(Attributes attributes, String content) {
		return new Abbr(attributes, new Text(content));
	}

	public static Acronym acronym(NestedElement... children) {
		return new Acronym(new Attributes(), children);
	}

	public static Acronym acronym(Attributes attributes,
			NestedElement... children) {
		return new Acronym(attributes, children);
	}

	public static Acronym acronym(String content) {
		return new Acronym(new Attributes(), new Text(content));
	}

	public static Acronym acronym(Attributes attributes, String content) {
		return new Acronym(attributes, new Text(content));
	}

	public static Address address(NestedElement... children) {
		return new Address(new Attributes(), children);
	}

	public static Address address(Attributes attributes,
			NestedElement... children) {
		return new Address(attributes, children);
	}

	public static Address address(String content) {
		return new Address(new Attributes(), new Text(content));
	}

	public static Address address(Attributes attributes, String content) {
		return new Address(attributes, new Text(content));
	}

	public static Area area(NestedElement... children) {
		return new Area(new Attributes(), children);
	}

	public static Area area(Attributes attributes, NestedElement... children) {
		return new Area(attributes, children);
	}

	public static Area area(String content) {
		return new Area(new Attributes(), new Text(content));
	}

	public static Area area(Attributes attributes, String content) {
		return new Area(attributes, new Text(content));
	}

	public static B b(NestedElement... children) {
		return new B(new Attributes(), children);
	}

	public static B b(Attributes attributes, NestedElement... children) {
		return new B(attributes, children);
	}

	public static B b(String content) {
		return new B(new Attributes(), new Text(content));
	}

	public static B b(Attributes attributes, String content) {
		return new B(attributes, new Text(content));
	}

	public static Bdo bdo(NestedElement... children) {
		return new Bdo(new Attributes(), children);
	}

	public static Bdo bdo(Attributes attributes, NestedElement... children) {
		return new Bdo(attributes, children);
	}

	public static Bdo bdo(String content) {
		return new Bdo(new Attributes(), new Text(content));
	}

	public static Bdo bdo(Attributes attributes, String content) {
		return new Bdo(attributes, new Text(content));
	}

	public static Big big(NestedElement... children) {
		return new Big(new Attributes(), children);
	}

	public static Big big(Attributes attributes, NestedElement... children) {
		return new Big(attributes, children);
	}

	public static Big big(String content) {
		return new Big(new Attributes(), new Text(content));
	}

	public static Big big(Attributes attributes, String content) {
		return new Big(attributes, new Text(content));
	}

	public static Blockquote blockquote(NestedElement... children) {
		return new Blockquote(new Attributes(), children);
	}

	public static Blockquote blockquote(Attributes attributes,
			NestedElement... children) {
		return new Blockquote(attributes, children);
	}

	public static Blockquote blockquote(String content) {
		return new Blockquote(new Attributes(), new Text(content));
	}

	public static Blockquote blockquote(Attributes attributes, String content) {
		return new Blockquote(attributes, new Text(content));
	}

	public static Br br(NestedElement... children) {
		return new Br(new Attributes(), children);
	}

	public static Br br(Attributes attributes, NestedElement... children) {
		return new Br(attributes, children);
	}

	public static Br br(String content) {
		return new Br(new Attributes(), new Text(content));
	}

	public static Br br(Attributes attributes, String content) {
		return new Br(attributes, new Text(content));
	}

	public static Button button(NestedElement... children) {
		return new Button(new Attributes(), children);
	}

	public static Button button(Attributes attributes,
			NestedElement... children) {
		return new Button(attributes, children);
	}

	public static Button button(String content) {
		return new Button(new Attributes(), new Text(content));
	}

	public static Button button(Attributes attributes, String content) {
		return new Button(attributes, new Text(content));
	}

	public static Caption caption(NestedElement... children) {
		return new Caption(new Attributes(), children);
	}

	public static Caption caption(Attributes attributes,
			NestedElement... children) {
		return new Caption(attributes, children);
	}

	public static Caption caption(String content) {
		return new Caption(new Attributes(), new Text(content));
	}

	public static Caption caption(Attributes attributes, String content) {
		return new Caption(attributes, new Text(content));
	}

	public static Cite cite(NestedElement... children) {
		return new Cite(new Attributes(), children);
	}

	public static Cite cite(Attributes attributes, NestedElement... children) {
		return new Cite(attributes, children);
	}

	public static Cite cite(String content) {
		return new Cite(new Attributes(), new Text(content));
	}

	public static Cite cite(Attributes attributes, String content) {
		return new Cite(attributes, new Text(content));
	}

	public static Code code(NestedElement... children) {
		return new Code(new Attributes(), children);
	}

	public static Code code(Attributes attributes, NestedElement... children) {
		return new Code(attributes, children);
	}

	public static Code code(String content) {
		return new Code(new Attributes(), new Text(content));
	}

	public static Code code(Attributes attributes, String content) {
		return new Code(attributes, new Text(content));
	}

	public static Col col(NestedElement... children) {
		return new Col(new Attributes(), children);
	}

	public static Col col(Attributes attributes, NestedElement... children) {
		return new Col(attributes, children);
	}

	public static Col col(String content) {
		return new Col(new Attributes(), new Text(content));
	}

	public static Col col(Attributes attributes, String content) {
		return new Col(attributes, new Text(content));
	}

	public static Colgroup colgroup(NestedElement... children) {
		return new Colgroup(new Attributes(), children);
	}

	public static Colgroup colgroup(Attributes attributes,
			NestedElement... children) {
		return new Colgroup(attributes, children);
	}

	public static Colgroup colgroup(String content) {
		return new Colgroup(new Attributes(), new Text(content));
	}

	public static Colgroup colgroup(Attributes attributes, String content) {
		return new Colgroup(attributes, new Text(content));
	}

	public static Dd dd(NestedElement... children) {
		return new Dd(new Attributes(), children);
	}

	public static Dd dd(Attributes attributes, NestedElement... children) {
		return new Dd(attributes, children);
	}

	public static Dd dd(String content) {
		return new Dd(new Attributes(), new Text(content));
	}

	public static Dd dd(Attributes attributes, String content) {
		return new Dd(attributes, new Text(content));
	}

	public static Del del(NestedElement... children) {
		return new Del(new Attributes(), children);
	}

	public static Del del(Attributes attributes, NestedElement... children) {
		return new Del(attributes, children);
	}

	public static Del del(String content) {
		return new Del(new Attributes(), new Text(content));
	}

	public static Del del(Attributes attributes, String content) {
		return new Del(attributes, new Text(content));
	}

	public static Dfn dfn(NestedElement... children) {
		return new Dfn(new Attributes(), children);
	}

	public static Dfn dfn(Attributes attributes, NestedElement... children) {
		return new Dfn(attributes, children);
	}

	public static Dfn dfn(String content) {
		return new Dfn(new Attributes(), new Text(content));
	}

	public static Dfn dfn(Attributes attributes, String content) {
		return new Dfn(attributes, new Text(content));
	}

	public static Div div(NestedElement... children) {
		return new Div(new Attributes(), children);
	}

	public static Div div(Attributes attributes, NestedElement... children) {
		return new Div(attributes, children);
	}

	public static Div div(String content) {
		return new Div(new Attributes(), new Text(content));
	}

	public static Div div(Attributes attributes, String content) {
		return new Div(attributes, new Text(content));
	}

	public static Dl dl(NestedElement... children) {
		return new Dl(new Attributes(), children);
	}

	public static Dl dl(Attributes attributes, NestedElement... children) {
		return new Dl(attributes, children);
	}

	public static Dl dl(String content) {
		return new Dl(new Attributes(), new Text(content));
	}

	public static Dl dl(Attributes attributes, String content) {
		return new Dl(attributes, new Text(content));
	}

	public static Dt dt(NestedElement... children) {
		return new Dt(new Attributes(), children);
	}

	public static Dt dt(Attributes attributes, NestedElement... children) {
		return new Dt(attributes, children);
	}

	public static Dt dt(String content) {
		return new Dt(new Attributes(), new Text(content));
	}

	public static Dt dt(Attributes attributes, String content) {
		return new Dt(attributes, new Text(content));
	}

	public static Em em(NestedElement... children) {
		return new Em(new Attributes(), children);
	}

	public static Em em(Attributes attributes, NestedElement... children) {
		return new Em(attributes, children);
	}

	public static Em em(String content) {
		return new Em(new Attributes(), new Text(content));
	}

	public static Em em(Attributes attributes, String content) {
		return new Em(attributes, new Text(content));
	}

	public static Fieldset fieldset(NestedElement... children) {
		return new Fieldset(new Attributes(), children);
	}

	public static Fieldset fieldset(Attributes attributes,
			NestedElement... children) {
		return new Fieldset(attributes, children);
	}

	public static Fieldset fieldset(String content) {
		return new Fieldset(new Attributes(), new Text(content));
	}

	public static Fieldset fieldset(Attributes attributes, String content) {
		return new Fieldset(attributes, new Text(content));
	}

	public static Form form(NestedElement... children) {
		return new Form(new Attributes(), children);
	}

	public static Form form(Attributes attributes, NestedElement... children) {
		return new Form(attributes, children);
	}

	public static Form form(String content) {
		return new Form(new Attributes(), new Text(content));
	}

	public static Form form(Attributes attributes, String content) {
		return new Form(attributes, new Text(content));
	}

	public static Frame frame(NestedElement... children) {
		return new Frame(new Attributes(), children);
	}

	public static Frame frame(Attributes attributes, NestedElement... children) {
		return new Frame(attributes, children);
	}

	public static Frame frame(String content) {
		return new Frame(new Attributes(), new Text(content));
	}

	public static Frame frame(Attributes attributes, String content) {
		return new Frame(attributes, new Text(content));
	}

	public static Frameset frameset(NestedElement... children) {
		return new Frameset(new Attributes(), children);
	}

	public static Frameset frameset(Attributes attributes,
			NestedElement... children) {
		return new Frameset(attributes, children);
	}

	public static Frameset frameset(String content) {
		return new Frameset(new Attributes(), new Text(content));
	}

	public static Frameset frameset(Attributes attributes, String content) {
		return new Frameset(attributes, new Text(content));
	}

	public static H1 h1(NestedElement... children) {
		return new H1(new Attributes(), children);
	}

	public static H1 h1(Attributes attributes, NestedElement... children) {
		return new H1(attributes, children);
	}

	public static H1 h1(String content) {
		return new H1(new Attributes(), new Text(content));
	}

	public static H1 h1(Attributes attributes, String content) {
		return new H1(attributes, new Text(content));
	}

	public static H2 h2(NestedElement... children) {
		return new H2(new Attributes(), children);
	}

	public static H2 h2(Attributes attributes, NestedElement... children) {
		return new H2(attributes, children);
	}

	public static H2 h2(String content) {
		return new H2(new Attributes(), new Text(content));
	}

	public static H2 h2(Attributes attributes, String content) {
		return new H2(attributes, new Text(content));
	}

	public static H3 h3(NestedElement... children) {
		return new H3(new Attributes(), children);
	}

	public static H3 h3(Attributes attributes, NestedElement... children) {
		return new H3(attributes, children);
	}

	public static H3 h3(String content) {
		return new H3(new Attributes(), new Text(content));
	}

	public static H3 h3(Attributes attributes, String content) {
		return new H3(attributes, new Text(content));
	}

	public static H4 h4(NestedElement... children) {
		return new H4(new Attributes(), children);
	}

	public static H4 h4(Attributes attributes, NestedElement... children) {
		return new H4(attributes, children);
	}

	public static H4 h4(String content) {
		return new H4(new Attributes(), new Text(content));
	}

	public static H4 h4(Attributes attributes, String content) {
		return new H4(attributes, new Text(content));
	}

	public static H5 h5(NestedElement... children) {
		return new H5(new Attributes(), children);
	}

	public static H5 h5(Attributes attributes, NestedElement... children) {
		return new H5(attributes, children);
	}

	public static H5 h5(String content) {
		return new H5(new Attributes(), new Text(content));
	}

	public static H5 h5(Attributes attributes, String content) {
		return new H5(attributes, new Text(content));
	}

	public static H6 h6(NestedElement... children) {
		return new H6(new Attributes(), children);
	}

	public static H6 h6(Attributes attributes, NestedElement... children) {
		return new H6(attributes, children);
	}

	public static H6 h6(String content) {
		return new H6(new Attributes(), new Text(content));
	}

	public static H6 h6(Attributes attributes, String content) {
		return new H6(attributes, new Text(content));
	}

	public static Hr hr(NestedElement... children) {
		return new Hr(new Attributes(), children);
	}

	public static Hr hr(Attributes attributes, NestedElement... children) {
		return new Hr(attributes, children);
	}

	public static Hr hr(String content) {
		return new Hr(new Attributes(), new Text(content));
	}

	public static Hr hr(Attributes attributes, String content) {
		return new Hr(attributes, new Text(content));
	}

	public static I i(NestedElement... children) {
		return new I(new Attributes(), children);
	}

	public static I i(Attributes attributes, NestedElement... children) {
		return new I(attributes, children);
	}

	public static I i(String content) {
		return new I(new Attributes(), new Text(content));
	}

	public static I i(Attributes attributes, String content) {
		return new I(attributes, new Text(content));
	}

	public static Iframe iframe(NestedElement... children) {
		return new Iframe(new Attributes(), children);
	}

	public static Iframe iframe(Attributes attributes,
			NestedElement... children) {
		return new Iframe(attributes, children);
	}

	public static Iframe iframe(String content) {
		return new Iframe(new Attributes(), new Text(content));
	}

	public static Iframe iframe(Attributes attributes, String content) {
		return new Iframe(attributes, new Text(content));
	}

	public static Img img(NestedElement... children) {
		return new Img(new Attributes(), children);
	}

	public static Img img(Attributes attributes, NestedElement... children) {
		return new Img(attributes, children);
	}

	public static Img img(String content) {
		return new Img(new Attributes(), new Text(content));
	}

	public static Img img(Attributes attributes, String content) {
		return new Img(attributes, new Text(content));
	}

	public static Ins ins(NestedElement... children) {
		return new Ins(new Attributes(), children);
	}

	public static Ins ins(Attributes attributes, NestedElement... children) {
		return new Ins(attributes, children);
	}

	public static Ins ins(String content) {
		return new Ins(new Attributes(), new Text(content));
	}

	public static Ins ins(Attributes attributes, String content) {
		return new Ins(attributes, new Text(content));
	}

	public static Kbd kbd(NestedElement... children) {
		return new Kbd(new Attributes(), children);
	}

	public static Kbd kbd(Attributes attributes, NestedElement... children) {
		return new Kbd(attributes, children);
	}

	public static Kbd kbd(String content) {
		return new Kbd(new Attributes(), new Text(content));
	}

	public static Kbd kbd(Attributes attributes, String content) {
		return new Kbd(attributes, new Text(content));
	}

	public static Label label(NestedElement... children) {
		return new Label(new Attributes(), children);
	}

	public static Label label(Attributes attributes, NestedElement... children) {
		return new Label(attributes, children);
	}

	public static Label label(String content) {
		return new Label(new Attributes(), new Text(content));
	}

	public static Label label(Attributes attributes, String content) {
		return new Label(attributes, new Text(content));
	}

	public static Legend legend(NestedElement... children) {
		return new Legend(new Attributes(), children);
	}

	public static Legend legend(Attributes attributes,
			NestedElement... children) {
		return new Legend(attributes, children);
	}

	public static Legend legend(String content) {
		return new Legend(new Attributes(), new Text(content));
	}

	public static Legend legend(Attributes attributes, String content) {
		return new Legend(attributes, new Text(content));
	}

	public static Map map(NestedElement... children) {
		return new Map(new Attributes(), children);
	}

	public static Map map(Attributes attributes, NestedElement... children) {
		return new Map(attributes, children);
	}

	public static Map map(String content) {
		return new Map(new Attributes(), new Text(content));
	}

	public static Map map(Attributes attributes, String content) {
		return new Map(attributes, new Text(content));
	}

	public static Meta meta(NestedElement... children) {
		return new Meta(new Attributes(), children);
	}

	public static Meta meta(Attributes attributes, NestedElement... children) {
		return new Meta(attributes, children);
	}

	public static Meta meta(String content) {
		return new Meta(new Attributes(), new Text(content));
	}

	public static Meta meta(Attributes attributes, String content) {
		return new Meta(attributes, new Text(content));
	}

	public static Noframes noframes(NestedElement... children) {
		return new Noframes(new Attributes(), children);
	}

	public static Noframes noframes(Attributes attributes,
			NestedElement... children) {
		return new Noframes(attributes, children);
	}

	public static Noframes noframes(String content) {
		return new Noframes(new Attributes(), new Text(content));
	}

	public static Noframes noframes(Attributes attributes, String content) {
		return new Noframes(attributes, new Text(content));
	}

	public static Noscript noscript(NestedElement... children) {
		return new Noscript(new Attributes(), children);
	}

	public static Noscript noscript(Attributes attributes,
			NestedElement... children) {
		return new Noscript(attributes, children);
	}

	public static Noscript noscript(String content) {
		return new Noscript(new Attributes(), new Text(content));
	}

	public static Noscript noscript(Attributes attributes, String content) {
		return new Noscript(attributes, new Text(content));
	}

	public static Object object(NestedElement... children) {
		return new Object(new Attributes(), children);
	}

	public static Object object(Attributes attributes,
			NestedElement... children) {
		return new Object(attributes, children);
	}

	public static Object object(String content) {
		return new Object(new Attributes(), new Text(content));
	}

	public static Object object(Attributes attributes, String content) {
		return new Object(attributes, new Text(content));
	}

	public static Optgroup optgroup(NestedElement... children) {
		return new Optgroup(new Attributes(), children);
	}

	public static Optgroup optgroup(Attributes attributes,
			NestedElement... children) {
		return new Optgroup(attributes, children);
	}

	public static Optgroup optgroup(String content) {
		return new Optgroup(new Attributes(), new Text(content));
	}

	public static Optgroup optgroup(Attributes attributes, String content) {
		return new Optgroup(attributes, new Text(content));
	}

	public static Option option(NestedElement... children) {
		return new Option(new Attributes(), children);
	}

	public static Option option(Attributes attributes,
			NestedElement... children) {
		return new Option(attributes, children);
	}

	public static Option option(String content) {
		return new Option(new Attributes(), new Text(content));
	}

	public static Option option(Attributes attributes, String content) {
		return new Option(attributes, new Text(content));
	}

	public static Param param(NestedElement... children) {
		return new Param(new Attributes(), children);
	}

	public static Param param(Attributes attributes, NestedElement... children) {
		return new Param(attributes, children);
	}

	public static Param param(String content) {
		return new Param(new Attributes(), new Text(content));
	}

	public static Param param(Attributes attributes, String content) {
		return new Param(attributes, new Text(content));
	}

	public static Pre pre(NestedElement... children) {
		return new Pre(new Attributes(), children);
	}

	public static Pre pre(Attributes attributes, NestedElement... children) {
		return new Pre(attributes, children);
	}

	public static Pre pre(String content) {
		return new Pre(new Attributes(), new Text(content));
	}

	public static Pre pre(Attributes attributes, String content) {
		return new Pre(attributes, new Text(content));
	}

	public static Q q(NestedElement... children) {
		return new Q(new Attributes(), children);
	}

	public static Q q(Attributes attributes, NestedElement... children) {
		return new Q(attributes, children);
	}

	public static Q q(String content) {
		return new Q(new Attributes(), new Text(content));
	}

	public static Q q(Attributes attributes, String content) {
		return new Q(attributes, new Text(content));
	}

	public static Samp samp(NestedElement... children) {
		return new Samp(new Attributes(), children);
	}

	public static Samp samp(Attributes attributes, NestedElement... children) {
		return new Samp(attributes, children);
	}

	public static Samp samp(String content) {
		return new Samp(new Attributes(), new Text(content));
	}

	public static Samp samp(Attributes attributes, String content) {
		return new Samp(attributes, new Text(content));
	}

	public static Script script(NestedElement... children) {
		return new Script(new Attributes(), children);
	}

	public static Script script(Attributes attributes,
			NestedElement... children) {
		return new Script(attributes, children);
	}

	public static Script script(String content) {
		return new Script(new Attributes(), new Text(content));
	}

	public static Script script(Attributes attributes, String content) {
		return new Script(attributes, new Text(content));
	}

	public static Select select(NestedElement... children) {
		return new Select(new Attributes(), children);
	}

	public static Select select(Attributes attributes,
			NestedElement... children) {
		return new Select(attributes, children);
	}

	public static Select select(String content) {
		return new Select(new Attributes(), new Text(content));
	}

	public static Select select(Attributes attributes, String content) {
		return new Select(attributes, new Text(content));
	}

	public static Small small(NestedElement... children) {
		return new Small(new Attributes(), children);
	}

	public static Small small(Attributes attributes, NestedElement... children) {
		return new Small(attributes, children);
	}

	public static Small small(String content) {
		return new Small(new Attributes(), new Text(content));
	}

	public static Small small(Attributes attributes, String content) {
		return new Small(attributes, new Text(content));
	}

	public static Strong strong(NestedElement... children) {
		return new Strong(new Attributes(), children);
	}

	public static Strong strong(Attributes attributes,
			NestedElement... children) {
		return new Strong(attributes, children);
	}

	public static Strong strong(String content) {
		return new Strong(new Attributes(), new Text(content));
	}

	public static Strong strong(Attributes attributes, String content) {
		return new Strong(attributes, new Text(content));
	}

	public static Style style(NestedElement... children) {
		return new Style(new Attributes(), children);
	}

	public static Style style(Attributes attributes, NestedElement... children) {
		return new Style(attributes, children);
	}

	public static Style style(String content) {
		return new Style(new Attributes(), new Text(content));
	}

	public static Style style(Attributes attributes, String content) {
		return new Style(attributes, new Text(content));
	}

	public static Sub sub(NestedElement... children) {
		return new Sub(new Attributes(), children);
	}

	public static Sub sub(Attributes attributes, NestedElement... children) {
		return new Sub(attributes, children);
	}

	public static Sub sub(String content) {
		return new Sub(new Attributes(), new Text(content));
	}

	public static Sub sub(Attributes attributes, String content) {
		return new Sub(attributes, new Text(content));
	}

	public static Sup sup(NestedElement... children) {
		return new Sup(new Attributes(), children);
	}

	public static Sup sup(Attributes attributes, NestedElement... children) {
		return new Sup(attributes, children);
	}

	public static Sup sup(String content) {
		return new Sup(new Attributes(), new Text(content));
	}

	public static Sup sup(Attributes attributes, String content) {
		return new Sup(attributes, new Text(content));
	}

	public static Table table(NestedElement... children) {
		return new Table(new Attributes(), children);
	}

	public static Table table(Attributes attributes, NestedElement... children) {
		return new Table(attributes, children);
	}

	public static Table table(String content) {
		return new Table(new Attributes(), new Text(content));
	}

	public static Table table(Attributes attributes, String content) {
		return new Table(attributes, new Text(content));
	}

	public static Tbody tbody(NestedElement... children) {
		return new Tbody(new Attributes(), children);
	}

	public static Tbody tbody(Attributes attributes, NestedElement... children) {
		return new Tbody(attributes, children);
	}

	public static Tbody tbody(String content) {
		return new Tbody(new Attributes(), new Text(content));
	}

	public static Tbody tbody(Attributes attributes, String content) {
		return new Tbody(attributes, new Text(content));
	}

	public static Td td(NestedElement... children) {
		return new Td(new Attributes(), children);
	}

	public static Td td(Attributes attributes, NestedElement... children) {
		return new Td(attributes, children);
	}

	public static Td td(String content) {
		return new Td(new Attributes(), new Text(content));
	}

	public static Td td(Attributes attributes, String content) {
		return new Td(attributes, new Text(content));
	}

	public static Textarea textarea(NestedElement... children) {
		return new Textarea(new Attributes(), children);
	}

	public static Textarea textarea(Attributes attributes,
			NestedElement... children) {
		return new Textarea(attributes, children);
	}

	public static Textarea textarea(String content) {
		return new Textarea(new Attributes(), new Text(content));
	}

	public static Textarea textarea(Attributes attributes, String content) {
		return new Textarea(attributes, new Text(content));
	}

	public static Tfoot tfoot(NestedElement... children) {
		return new Tfoot(new Attributes(), children);
	}

	public static Tfoot tfoot(Attributes attributes, NestedElement... children) {
		return new Tfoot(attributes, children);
	}

	public static Tfoot tfoot(String content) {
		return new Tfoot(new Attributes(), new Text(content));
	}

	public static Tfoot tfoot(Attributes attributes, String content) {
		return new Tfoot(attributes, new Text(content));
	}

	public static Th th(NestedElement... children) {
		return new Th(new Attributes(), children);
	}

	public static Th th(Attributes attributes, NestedElement... children) {
		return new Th(attributes, children);
	}

	public static Th th(String content) {
		return new Th(new Attributes(), new Text(content));
	}

	public static Th th(Attributes attributes, String content) {
		return new Th(attributes, new Text(content));
	}

	public static Thead thead(NestedElement... children) {
		return new Thead(new Attributes(), children);
	}

	public static Thead thead(Attributes attributes, NestedElement... children) {
		return new Thead(attributes, children);
	}

	public static Thead thead(String content) {
		return new Thead(new Attributes(), new Text(content));
	}

	public static Thead thead(Attributes attributes, String content) {
		return new Thead(attributes, new Text(content));
	}

	public static Tr tr(NestedElement... children) {
		return new Tr(new Attributes(), children);
	}

	public static Tr tr(Attributes attributes, NestedElement... children) {
		return new Tr(attributes, children);
	}

	public static Tr tr(String content) {
		return new Tr(new Attributes(), new Text(content));
	}

	public static Tr tr(Attributes attributes, String content) {
		return new Tr(attributes, new Text(content));
	}

	public static Tt tt(NestedElement... children) {
		return new Tt(new Attributes(), children);
	}

	public static Tt tt(Attributes attributes, NestedElement... children) {
		return new Tt(attributes, children);
	}

	public static Tt tt(String content) {
		return new Tt(new Attributes(), new Text(content));
	}

	public static Tt tt(Attributes attributes, String content) {
		return new Tt(attributes, new Text(content));
	}

	public static Ul ul(NestedElement... children) {
		return new Ul(new Attributes(), children);
	}

	public static Ul ul(Attributes attributes, NestedElement... children) {
		return new Ul(attributes, children);
	}

	public static Ul ul(String content) {
		return new Ul(new Attributes(), new Text(content));
	}

	public static Ul ul(Attributes attributes, String content) {
		return new Ul(attributes, new Text(content));
	}

	public static Var var(NestedElement... children) {
		return new Var(new Attributes(), children);
	}

	public static Var var(Attributes attributes, NestedElement... children) {
		return new Var(attributes, children);
	}

	public static Var var(String content) {
		return new Var(new Attributes(), new Text(content));
	}

	public static Var var(Attributes attributes, String content) {
		return new Var(attributes, new Text(content));
	}
}
