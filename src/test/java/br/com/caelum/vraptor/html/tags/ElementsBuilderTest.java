package br.com.caelum.vraptor.html.tags;

import static br.com.caelum.vraptor.html.factories.PageAttributeFactory.clazz;
import static br.com.caelum.vraptor.html.factories.PageTagFactory.p;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import br.com.caelum.vraptor.html.tags.builders.ElementsBuilder;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;

public class ElementsBuilderTest {

	@Test
	public void invokesFormatterMethodAndReturnsANestedElementWithTheReturnsOfFormatterMethod() throws Exception {
		List<Integer> objects = Arrays.asList(1, 2, 3);
		ElementsBuilder<Integer> builder = new ElementsBuilder<Integer>(objects);
		NestedElement result = builder.using(new Formatter()).formatInt(null);
		assertEquals("<p>2</p><p>3</p><p>4</p>", result.toHtml());
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
		assertEquals("<p>10</p><p>21</p><p>32</p>", result.toHtml());
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAMethodThatDoesNotReceiveANumberAsIndexArgument() throws Exception {
		List<String> objects = Arrays.asList("1", "2", "3");
		ElementsBuilder<String> builder = new ElementsBuilder<String>(objects);
		builder.using(new Formatter()).formatWithStrangeIndex(null, null);
	}

	@Test
	public void formatsListOfObjectsCallingAMethodOnEachOneOfThem() throws Exception {
		List<IKnowHowToFormatMyself> formattingElements = new LinkedList<IKnowHowToFormatMyself>();
		formattingElements.add(new IKnowHowToFormatMyself("abc"));
		formattingElements.add(new IKnowHowToFormatMyself("123"));
		ElementsBuilder<IKnowHowToFormatMyself> builder = new ElementsBuilder<IKnowHowToFormatMyself>(formattingElements);
		NestedElement result = builder.using(IKnowHowToFormatMyself.class).formatMe("myClass");
		assertEquals("<p class=\"myClass\">abc</p><p class=\"myClass\">123</p>", result.toHtml());
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAFormatterMethodThatDoesNotReturnANestedElement() throws Exception {
		List<IKnowHowToFormatMyself> formattingElements = new LinkedList<IKnowHowToFormatMyself>();
		formattingElements.add(new IKnowHowToFormatMyself("abc"));
		formattingElements.add(new IKnowHowToFormatMyself("123"));
		ElementsBuilder<IKnowHowToFormatMyself> builder = new ElementsBuilder<IKnowHowToFormatMyself>(formattingElements);
		builder.using(IKnowHowToFormatMyself.class).dontFormatMe();
	}

	@Test(expected=IllegalArgumentException.class)
	public void throwsExceptionWhenTryingToUseAFormatterMethodThatReturnsASubclassOfNestedElement() throws Exception {
		List<IKnowHowToFormatMyself> formattingElements = new LinkedList<IKnowHowToFormatMyself>();
		formattingElements.add(new IKnowHowToFormatMyself("abc"));
		formattingElements.add(new IKnowHowToFormatMyself("123"));
		ElementsBuilder<IKnowHowToFormatMyself> builder = new ElementsBuilder<IKnowHowToFormatMyself>(formattingElements);
		builder.using(IKnowHowToFormatMyself.class).formatMeReturningTag();
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

class IKnowHowToFormatMyself {

	private final String value;

	public IKnowHowToFormatMyself(String value) {
		this.value = value;
	}

	public Tag formatMeReturningTag() {
		return p();
	}

	public NestedElement formatMe(String customClass) {
		return p(clazz(customClass)).with(value);
	}

	public String dontFormatMe() {
		return "";
	}
}