package br.com.caelum.vraptor.html.tags;

import static br.com.caelum.vraptor.html.PageTagFactory.p;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ElementsBuilderTest {

	@Test
	public void invokesFormatterMethodAndReturnsAnElementsWithTheReturnsOfFormatterMethod() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		NestedElement result = builder.using(new Formatter()).formatInt(null);
		assertEquals(Elements.class, result.getClass());
		Elements elements = (Elements) result;
		assertEquals("<p>2</p><p>3</p><p>4</p>", elements.toHtml());
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAFormatterMethodThatDoesNotAcceptArgumentOfTheNecessaryType() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		builder.using(new Formatter()).formatString(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAFormatterThatDoesNotReturnANestedElement() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		builder.using(new Formatter()).strangeMethod(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAMethodThatReceivesManyArguments() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		builder.using(new Formatter()).strangeMethod(null, null);
	}
}

class Formatter {
	public NestedElement formatInt(Integer n) {
		return p(Integer.valueOf(n + 1).toString());
	}
	public NestedElement formatString(String str) {
		return p(str);
	}
	public void strangeMethod(Integer n) {}
	public NestedElement strangeMethod(Integer n, Integer m) {
		return null;
	}
}