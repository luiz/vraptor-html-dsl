package br.com.caelum.vraptor.html;

/**
 * <p>Just a wrapper to a String containing an URL</p>
 * @author luiz
 */
public class StringLink implements Link {

	private final String url;

	public StringLink(String url) {
		this.url = url;
	}

	public String url() {
		return url;
	}

}
