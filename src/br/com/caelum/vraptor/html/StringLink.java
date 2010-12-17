package br.com.caelum.vraptor.html;

public class StringLink implements Link {

	private final String url;

	public StringLink(String url) {
		this.url = url;
	}

	public String url() {
		return url;
	}

}
