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

import java.util.Arrays;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.html.Page;
import br.com.caelum.vraptor.html.PageProcessor;
import br.com.caelum.vraptor.html.example.page.IndexPage;
import br.com.caelum.vraptor.html.example.page.ListPage;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ExampleController {

	private final Result result;
	private final PageProcessor pageProcessor;

	public ExampleController(Result result, PageProcessor pageProcessor) {
		this.result = result;
		this.pageProcessor = pageProcessor;
	}

	@Path("/")
	public Page index() {
		result.use(Results.http()).body(pageProcessor.process(new IndexPage()));
		//return new IndexPage();
		return null;
	}

	@Path("/listing")
	public void listing() {
		List<String> cars = Arrays.asList("GM", "Ford", "VW");
		result.use(Results.http()).body(pageProcessor.process(new ListPage(cars)));
	}

	@Path("/complex/route/to/page2")
	public void page2() {
		result.use(Results.http()).body("Voila!");
	}

	@Path("/magicNumber")
	public Integer test() {
		return 42;
	}

}
