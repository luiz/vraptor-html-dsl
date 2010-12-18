package br.com.caelum.vraptor.html.example.page;
import static br.com.caelum.vraptor.html.PageTagFactory.body;
import static br.com.caelum.vraptor.html.PageTagFactory.html;
import static br.com.caelum.vraptor.html.PageTagFactory.li;
import static br.com.caelum.vraptor.html.PageTagFactory.ol;

import java.util.List;

import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.Tags;

public class ListPage implements Page {

	private final List<String> cars;

	public ListPage(List<String> cars) {
		this.cars = cars;
	}

	@Override
	public Html render() {
		return html(
				body(
						ol(
						  cars()
						)
				)
			);
	}

//	private Tag toTag(String car) {
//		...;
//	}

	private Tags cars() {
		//Tags.foreach(cars).use(TablePage.class).toTag(null);


		Tags tags = new Tags();
		for (String car : cars) {
			tags.append(li(car));
		}
		return tags;
	}

}
