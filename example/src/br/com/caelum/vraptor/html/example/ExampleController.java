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

import java.util.Arrays;
import java.util.List;

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

	public ExampleController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.use(html()).page(new DecoratorPage(new IndexPage()));
	}

	@Path("/cars")
	public Page listing() {
		List<String> cars = Arrays.asList("GM", "Ford", "VW");
		return new DecoratorPage(new ListPage(cars));
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

	@Path("/cars/{car}")
	public void show(String car) {
		result.use(Results.http()).body(car);
	}

}
