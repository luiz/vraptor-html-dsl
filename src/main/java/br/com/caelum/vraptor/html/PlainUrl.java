package br.com.caelum.vraptor.html;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.PrototypeScoped;

/**
 * <p>Just a wrapper to a String containing an URL.</p>
 * @author luiz
 */
@Component @PrototypeScoped
public class PlainUrl implements Url {

	private String url;
	private final HttpServletRequest request;

	PlainUrl(HttpServletRequest request) {
		this.request = request;
	}

	public String value() {
		checkNotNull(url, "Incomplete PlainUrl generation");
		return url;
	}

	public void saveUrlTo(String url) {
		if (url.startsWith("/")) {
			this.url = request.getContextPath() + url;
		} else {
			this.url = url;
		}
	}

}
