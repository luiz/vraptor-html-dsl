package br.com.caelum.vraptor.html;

import static java.lang.String.format;
import br.com.caelum.vraptor.html.attributes.Attribute;
import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.html.tags.Tag;
import br.com.caelum.vraptor.html.tags.Text;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PageProcessor {

	public String process(Page result) {
		Html rootTag = result.render();
		return transformToHtml(rootTag);
	}

	private String transformToHtml(Tag tag) {
		String tagName = tag.getClass().getSimpleName().toLowerCase();
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		sb.append(tagName);
		sb.append(transformToHtml(tag.getAttributes()));
		sb.append('>');
		for (Tag child : tag.getChildren()) {
			// The ugly duck strikes back
			if (child instanceof Text) {
				sb.append(((Text) child).getText());
			} else {
				sb.append(transformToHtml(child));
			}
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
