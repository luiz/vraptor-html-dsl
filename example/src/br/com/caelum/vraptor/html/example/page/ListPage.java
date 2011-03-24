package br.com.caelum.vraptor.html.example.page;

import static br.com.caelum.vraptor.html.UrlFactory.to;
import static br.com.caelum.vraptor.html.UrlFactory.url;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.clazz;
import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.href;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.a;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.body;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.li;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.ol;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.table;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.td;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.tr;
import static br.com.caelum.vraptor.html.tags.builders.Elements.format;

import java.util.Collection;

import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.Url;
import br.com.caelum.vraptor.html.example.ExampleController;
import br.com.caelum.vraptor.html.example.Person;
import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;

public class ListPage implements Page {

	private final Collection<Person> people;

	public ListPage(Collection<Person> people) {
		this.people = people;
	}

	public Tag render() {
		return body().with(
					p().with("You can construct the list by creating an Elements object:"),
					ol().with(
						peopleAsHtml()
					),
					p().with("Or you can use the \"magic\" Elements.format method:"),
					ol().with(
					  format(people).using(this).tagFor(null)
					),
					p().with("You can also use a method that receives an index, so that you can do a zebra list, like this:"),
					table().with(
					  format(people).using(this).tagFor(null, 0)
					)
				);
	}

	private Elements peopleAsHtml() {
		Elements tags = new Elements();
		for (Person person : people) {
			tags.append(tagFor(person));
		}
		return tags;
	}

	public NestedElement tagFor(Person person, int i) {
		Url linkToPerson = url(); to(ExampleController.class).show(person.getName());
		String parity = i % 2 == 0 ? "odd" : "even";
		return tr(clazz(parity)).with(
					td().with(person.getName()),
					td().with(person.getSex()),
					td().with(person.getFormattedBirthDate()),
					td().with(a(href(linkToPerson)).with("Show"))
				);
	}

	public NestedElement tagFor(Person person) {
		Url linkToPerson = url(); to(ExampleController.class).show(person.getName());
		return li().with(
					a(href(linkToPerson)).with(person.getName())
				);
	}

}
