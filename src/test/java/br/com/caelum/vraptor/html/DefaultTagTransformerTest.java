package br.com.caelum.vraptor.html;

import static br.com.caelum.vraptor.html.PageAttributeFactory.attrs;
import static br.com.caelum.vraptor.html.PageAttributeFactory.lang;
import static br.com.caelum.vraptor.html.PageTagFactory.body;
import static br.com.caelum.vraptor.html.PageTagFactory.html;
import static br.com.caelum.vraptor.html.PageTagFactory.p;
import static br.com.caelum.vraptor.html.PageTagFactory.span;
import static br.com.caelum.vraptor.html.PageTagFactory.text;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.vraptor.html.tags.DefaultTagTransformer;
import br.com.caelum.vraptor.html.tags.Elements;

public class DefaultTagTransformerTest {
	@Test
	public void transformsAnHTMLTagIntoPureHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(html(""));
		assertEquals("<html></html>", result);
	}

	@Test
	public void transformATagWithAttributesIntoCorrectHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(html(attrs(lang("en"))));
		assertEquals("<html lang=\"en\"></html>", result);
	}

	@Test
	public void transformATagWithNestedTagsIntoCorrectHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(html(body()));
		assertEquals("<html><body></body></html>", result);
	}

	@Test
	public void transformAPageWithTagsAndTextIntoCorrectHTML() throws Exception {
		String result = new DefaultTagTransformer().transform(
				html(body(
					text("Some text "),
					span("with"),
					text(" some more text.")
				)));
		assertEquals("<html><body>Some text <span>with</span> some more text.</body></html>", result);
	}

	@Test
	public void transformAPageWithATagsObjectIntoCorrectHTML() throws Exception {
		Elements tags = new Elements();
		tags.append(p("First paragraph"));
		tags.append(p("Second paragraph"));

		String result = new DefaultTagTransformer().transform(html(body(tags)));
		assertEquals("<html><body><p>First paragraph</p><p>Second paragraph</p></body></html>", result);
	}
}
