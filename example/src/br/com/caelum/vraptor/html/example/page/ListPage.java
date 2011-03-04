package br.com.caelum.vraptor.html.example.page;

import static br.com.caelum.vraptor.html.UrlFactory.to;
import static br.com.caelum.vraptor.html.UrlFactory.url;
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
import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;

public class ListPage implements Page {

	private final List<String> cars;

	public ListPage(List<String> cars) {
		this.cars = cars;
	}

	public Tag render() {
		return html().with(
				body().with(
					p().with("You can construct the list by creating an Elements object:"),
					ol().with(
						cars()
					),
					p().with("Or you can use the \"magic\" Elements.format method:"),
					ol().with(
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
		return li().with(
					a(href(linkToCar)).with(car)
				);
	}

}
