/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.caelum.vraptor.html.example;

import static br.com.caelum.vraptor.html.VRaptorHTMLDSLView.html;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.example.page.DecoratorPage;
import br.com.caelum.vraptor.html.example.page.IndexPage;
import br.com.caelum.vraptor.html.example.page.ListPage;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ExampleController {

	private final Result result;
	private final Map<String, Person> people;

	public ExampleController(Result result) {
		this.result = result;
		this.people = new HashMap<String, Person>();

		this.people.put("John", new Person("John", new GregorianCalendar(1970, 0, 25), Sex.MALE));
		this.people.put("Mary", new Person("Mary", new GregorianCalendar(1981, 6, 15), Sex.FEMALE));
		this.people.put("William", new Person("William", new GregorianCalendar(1990, 9, 2), Sex.MALE));
	}

	@Path("/")
	public void index() {
		result.use(html()).page(new DecoratorPage(new IndexPage()));
	}

	@Path("/people")
	public Page listing() {
		return new DecoratorPage(new DecoratorPage(new ListPage(this.people.values())));
	}

	@Path("/complex/route/to/page2")
	public void page2() {
		result.use(Results.http()).body("Voila!");
	}

	@Path("/magicNumber")
	public Integer test() {
		result.use(Results.http()).body("42");
		return 42;
	}

	@Path("/people/{personName}")
	public void show(String personName) {
		Person person = this.people.get(personName);
		result.use(Results.http()).body(person.toString());
	}

}
