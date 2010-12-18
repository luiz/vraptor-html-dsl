package br.com.caelum.vraptor.html;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.PrototypeScoped;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

@Component @PrototypeScoped
public class UrlForLink implements Link {

	private String url = null;
	private final Router router;
	private final Proxifier proxifier;
	private final HttpServletRequest request;

	UrlForLink(Router router, Proxifier proxifier, HttpServletRequest request) {
		this.router = router;
		this.proxifier = proxifier;
		this.request = request;
	}

	public <T> T saveLinkTo(final Class<T> controller) {
		return proxifier.proxify(controller, new MethodInvocation<T>() {

			public Object intercept(T instance, Method method, Object[] args, SuperMethod superMethod) {
				url = request.getContextPath() + router.urlFor(controller, method, args);
				return null;
			}

		});
	}

	public String url() {
		checkNotNull(url, "Incomplete URL generation");
		return url;
	}
}
