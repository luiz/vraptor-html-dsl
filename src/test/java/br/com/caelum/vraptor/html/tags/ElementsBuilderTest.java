package br.com.caelum.vraptor.html.tags;

import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import br.com.caelum.vraptor.html.tags.builders.Elements;
import br.com.caelum.vraptor.html.tags.builders.ElementsBuilder;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;

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
		builder.using(new Formatter()).strangeMethod(null, null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAMethodThatReturnsASubclassOfNestedElement() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		builder.using(new Formatter()).formatIntAndReturnTag(null);
	}

	@Test
	public void doesNotCrashWhenFormattingAnEmptyList() throws Exception {
		List<Integer> objects = Collections.emptyList();
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		builder.using(new Formatter()).formatInt(null);
	}

	@Test
	public void doesNotCrashWhenUsingAFormatterThatCallsMethodsOnItsConstructorParameters() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		builder.using(new ProblematicFormatter(42)).formatIntAndReturnTag(null);
	}

	@Test
	public void invokesFormatterMethodWithIndexAndReturnsAnElementsWithTheReturnsOfFormatterMethod() throws Exception {
		List<String> objects = Arrays.asList("1", "2", "3");
		ElementsBuilder<String> builder = new ElementsBuilder<String>(objects);
		NestedElement result = builder.using(new Formatter()).formatWithIndex(null, 0);
		assertEquals(Elements.class, result.getClass());
		Elements elements = (Elements) result;
		assertEquals("<p>10</p><p>21</p><p>32</p>", elements.toHtml());
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAMethodThatDoesNotReceiveANumberAsIndexArgument() throws Exception {
		List<String> objects = Arrays.asList("1", "2", "3");
		ElementsBuilder<String> builder = new ElementsBuilder<String>(objects);
		builder.using(new Formatter()).formatWithStrangeIndex(null, null);
	}
}

class Formatter {
	public NestedElement formatInt(Integer n) {
		return formatIntAndReturnTag(n);
	}
	public Tag formatIntAndReturnTag(Integer n) {
		return p().with(Integer.valueOf(n + 1).toString());
	}
	public NestedElement formatString(String str) {
		return p().with(str);
	}
	public NestedElement formatWithIndex(String str, int index) {
		return p().with(str + index);
	}
	public NestedElement formatWithStrangeIndex(String str, String stringIsNotIndex) {
		return p().with(str + stringIsNotIndex);
	}
	public void strangeMethod(Integer n) {}
	public NestedElement strangeMethod(Integer n, Integer m, Integer problem) {
		return null;
	}
}

class ProblematicFormatter {
	private final String myNumber;

	public ProblematicFormatter(Integer number) {
		this.myNumber = number.toString();
	}

	public NestedElement formatIntAndReturnTag(Integer toFormat) {
		return p().with(myNumber + ": " + toFormat);
	}
}