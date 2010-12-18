package br.com.caelum.vraptor.html.tags;

import java.util.LinkedList;
import java.util.List;

public class Tags implements NestedElement {

	private final List<NestedElement> children = new LinkedList<NestedElement>();

	public void append(NestedElement formatted) {
		children.add(formatted);
	}

	public static <T> TagsBuilder<T> format(List<T> objects) {
		return new TagsBuilder<T>(objects);
	}

	public String toHtml() {
		StringBuilder sb = new StringBuilder();
		for (NestedElement child : children) {
			sb.append(child.toHtml());
		}
		return sb.toString();
	}

}
