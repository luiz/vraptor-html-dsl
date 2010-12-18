package br.com.caelum.vraptor.html.tags;

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

}