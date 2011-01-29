package br.com.caelum.vraptor.html.example.page;

import static br.com.caelum.vraptor.html.UrlFactory.to;
import static br.com.caelum.vraptor.html.UrlFactory.url;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.attrs;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.href;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.id;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.a;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.body;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.css;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.head;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.html;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.image;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.js;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.span;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.text;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.title;
import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.Url;
import br.com.caelum.vraptor.html.example.ExampleController;
import br.com.caelum.vraptor.html.example.Person;
import br.com.caelum.vraptor.html.tags.Html;

public class IndexPage implements Page {

	public Html render() {
		Url page2 = url(); to(ExampleController.class).page2();
		Url list = url(); to(ExampleController.class).listing();
		Url dontClick = url(to(ExampleController.class).test());
		Url google = url("http://google.com");

		Person person = new Person();
		return html(
				head(
					title("Page generated by VRaptor's HTML DSL"),
					css("/css/example.css"),
					js("https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"),
					js("/js/example.js")
				),
				body(
					image("/images/vraptor-logo.png", "VRaptor Logo"),
					p(
						a(attrs(href("#"), id("hi")), "Hi!")
					),
					p(
						text("This page has a "),
						a(attrs(href(page2)), "complex link"),
						span(" to another page")
					),
					p(
						text("To "),
						a(attrs(href(list)), "a page with a list")
					),
					p(
						text("And for "),
						a(attrs(href(google)), "Google")
					),
					p(
						text("And yet "),
						a(attrs(href(dontClick)), "a link you should not click")
					)
					// TODO make the following work
					//formFor(person, with(person).getName(), with(person).getSex())
				)
			);
	}
}
