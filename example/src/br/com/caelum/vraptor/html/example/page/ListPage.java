package br.com.caelum.vraptor.html.example.page;

import static br.com.caelum.vraptor.html.UrlFactory.to;
import static br.com.caelum.vraptor.html.UrlFactory.url;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.attrs;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.href;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.a;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.body;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.html;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.li;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.ol;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static br.com.caelum.vraptor.html.tags.builders.Elements.format;

import java.util.List;

import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.Url;
import br.com.caelum.vraptor.html.example.ExampleController;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;

public class ListPage implements Page {

	private final List<String> cars;

	public ListPage(List<String> cars) {
		this.cars = cars;
	}

	public Html render() {
		return html(
				body(
						p("You can construct the list by creating a Tags object:"),
						ol(
							cars()
						),
						p("Or you can use the \"magic\" Tags.format method:"),
						ol(
						  format(cars).using(this).tagFor(null)
						)
				)
			);
	}

	private Elements cars() {
		Elements tags = new Elements();
		for (String car : cars) {
			tags.append(tagFor(car));
		}
		return tags;
	}

	public NestedElement tagFor(String car) {
		Url linkToCar = url(); to(ExampleController.class).show(car);
		return li(
					a(attrs(href(linkToCar)),
						car)
				);
	}

}
