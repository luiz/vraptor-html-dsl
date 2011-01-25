package br.com.caelum.vraptor.html.transformers;

import br.com.caelum.vraptor.html.tags.interfaces.Tag;

/**
 * <p>
 * An interface for classes that transform Tags into HTML in a standard fashion,
 * not taking into account the type of the tag.
 * </p>
 *
 * @author luiz
 *
 */
public interface TagTransformer {

	public String transform(Tag tag);

	public String transform(Tag tag, String name);

}