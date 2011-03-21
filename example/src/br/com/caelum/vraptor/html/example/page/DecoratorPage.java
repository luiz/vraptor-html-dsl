package br.com.caelum.vraptor.html.example.page;

import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;

public class DecoratorPage implements Page {

	private final Page decorated;

	public DecoratorPage(Page decorated) {
		this.decorated = decorated;
	}

	public NestedElement render() {
		return decorated.render();
	}

}
