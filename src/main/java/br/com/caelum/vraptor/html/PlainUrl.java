package br.com.caelum.vraptor.html;

/**
 * <p>Just a wrapper to a String containing an URL</p>
 * @author luiz
 */
public class PlainUrl implements Url {

	private final String url;

	public PlainUrl(String url) {
		this.url = url;
	}

	public String value() {
		return url;
	}

}
