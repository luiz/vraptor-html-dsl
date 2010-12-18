package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.html.tags.Html;
import br.com.caelum.vraptor.ioc.Component;

/**
 * <p>
 * Transforms a {@link Page} into HTML
 * </p>
 *
 * @author luiz
 */
@Component
public class PageProcessor {

	/**
	 * <p>
	 * Retrieves the root &lt;html&gt; tag of the given {@link Page} and
	 * requests its translation to HTML
	 * </p>
	 *
	 * @param page
	 *            A page to be transformed into HTML
	 * @return A String containing the corresponding HTML
	 */
	public String process(Page page) {
		Html rootTag = page.render();
		return rootTag.toHtml();
	}
}
