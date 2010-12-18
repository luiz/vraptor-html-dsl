package br.com.caelum.vraptor.html.tags;

import static java.lang.String.format;
import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.attributes.Attributes;

/**
 * <p>
 * The default implementation of {@link TagTransformer}. Uses the tag's class
 * name as the tag name in the HTML output, process its attributes using also
 * their classes names to generate the corresponding HTML and requests the
 * processing of each one of its children.
 * </p>
 *
 * @author luiz
 *
 */
public class DefaultTagTransformer implements TagTransformer {

	public String transform(Tag tag) {
		String tagName = tag.getClass().getSimpleName().toLowerCase();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		sb.append(tagName);
		sb.append(transformToHtml(tag.getAttributes()));
		sb.append('>');
		for (NestedElement child : tag.getChildren()) {
			sb.append(child.toHtml());
		}
		sb.append("</");
		sb.append(tagName);
		sb.append('>');
		return sb.toString();
	}

	private String transformToHtml(Attributes attributes) {
		StringBuilder sb = new StringBuilder();
		for (Attribute attribute : attributes.array()) {
			sb.append(' ');
			sb.append(transformToHtml(attribute));
		}
		return sb.toString();
	}

	private String transformToHtml(Attribute attribute) {
		String attributeName = attribute.getClass().getSimpleName().toLowerCase();
		return format("%s=\"%s\"", attributeName, attribute.getValue());
	}

}
