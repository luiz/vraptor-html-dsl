package br.com.caelum.vraptor.html.example.page;

import static br.com.caelum.vraptor.html.UrlFactory.to;
import static br.com.caelum.vraptor.html.UrlFactory.url;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.href;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.id;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.a;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.body;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.image;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.span;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.text;
import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.Url;
import br.com.caelum.vraptor.html.example.ExampleController;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;

public class IndexPage implements Page {

	public Tag render() {
		Url page2 = url(); to(ExampleController.class).page2();
		Url list = url(); to(ExampleController.class).listing();
		Url dontClick = url(to(ExampleController.class).test());
		Url google = url("http://google.com");

		return body().with(
					image("/images/vraptor-logo.png", "VRaptor Logo"),
					p().with(
						a(href("#"), id("hi")).with("Hi!")
					),
					p().with(
						text("This page has a "),
						a(href(page2)).with("complex link"),
						span().with(" to another page")
					),
					p().with(
						text("To "),
						a(href(list)).with("a page with a list")
					),
					p().with(
						text("And for "),
						a(href(google)).with("Google")
					),
					p().with(
						text("And yet "),
						a(href(dontClick)).with("a link you should not click")
					)
					// TODO make the following work
					//formFor(person, with(person).getName(), with(person).getSex())
				);
	}
}
