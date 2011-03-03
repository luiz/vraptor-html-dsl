package br.com.caelum.vraptor.html;

import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.lang;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.body;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.html;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.span;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.text;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;

public class DefaultTagTransformerTest {
	@Test
	public void transformsAnHTMLTagIntoPureHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(html());
		assertEquals("<html></html>", result);
	}

	@Test
	public void transformATagWithAttributesIntoCorrectHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(html(lang("en")));
		assertEquals("<html lang=\"en\"></html>", result);
	}

	@Test
	public void transformATagWithNestedTagsIntoCorrectHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(html().with(body()));
		assertEquals("<html><body></body></html>", result);
	}

	@Test
	public void transformAPageWithTagsAndTextIntoCorrectHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(
				html().with(
					body().with(
						text("Some text "),
						span().with("with"),
						text(" some more text.")
					)
				));
		assertEquals("<html><body>Some text <span>with</span> some more text.</body></html>", result);
	}

	@Test
	public void transformAPageWithATagsObjectIntoCorrectHTML() throws Exception {
		Elements tags = new Elements();
		tags.append(p().with("First paragraph"));
		tags.append(p().with("Second paragraph"));

		String result = new DefaultTagTransformer().transform(html().with(body().with(tags)));
		assertEquals("<html><body><p>First paragraph</p><p>Second paragraph</p></body></html>", result);
	}
}
