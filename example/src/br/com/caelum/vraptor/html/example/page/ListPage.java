package br.com.caelum.vraptor.html.example.page;

import static br.com.caelum.vraptor.html.Linker.link;
import static br.com.caelum.vraptor.html.Linker.to;
import static br.com.caelum.vraptor.html.PageAttributeFactory.attrs;
import static br.com.caelum.vraptor.html.PageAttributeFactory.href;
import static br.com.caelum.vraptor.html.PageTagFactory.a;
import static br.com.caelum.vraptor.html.PageTagFactory.body;
import static br.com.caelum.vraptor.html.PageTagFactory.html;
import static br.com.caelum.vraptor.html.PageTagFactory.li;
import static br.com.caelum.vraptor.html.PageTagFactory.ol;
import static br.com.caelum.vraptor.html.PageTagFactory.p;
import static br.com.caelum.vraptor.html.tags.Tags.format;

import java.util.List;

import br.com.caelum.vraptor.html.Link;
import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.example.ExampleController;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.NestedElement;
import br.com.caelum.vraptor.html.tags.Tags;

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

	private Tags cars() {
		Tags tags = new Tags();
		for (String car : cars) {
			tags.append(tagFor(car));
		}
		return tags;
	}

	public NestedElement tagFor(String car) {
		Link linkToCar = link(); to(ExampleController.class).show(car);
		return li(
					a(attrs(href(linkToCar)),
						car)
				);
	}

}
