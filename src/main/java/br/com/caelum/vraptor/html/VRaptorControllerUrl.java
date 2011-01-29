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

/**
 * <p>Generates and stores an url to a controller using a proxy of such controller.</p>
 *
 * <p>When the method that is the target of this url is invoked in the proxy, the
 * invocation is intercepted and VRaptor's router is used to generate a path to
 * the invoked method. A {@link UrlFactory} requests an instance of this object from
 * VRaptor's DI Container.</p>
 *
 * @author luiz
 * @see UrlFactory
 */
@Component @PrototypeScoped
public class VRaptorControllerUrl implements Url {

	private String url = null;
	private final Router router;
	private final Proxifier proxifier;
	private final HttpServletRequest request;

	VRaptorControllerUrl(Router router, Proxifier proxifier, HttpServletRequest request) {
		this.router = router;
		this.proxifier = proxifier;
		this.request = request;
	}

	/**
	 * <p>
	 * Generates a proxy of the given class, so that any method call on that
	 * proxy is intercepted and an URL for that method is generated, using
	 * VRaptor's Router.
	 * </p>
	 *
	 * <p>
	 * An example of use would be:
	 * <code>linker.saveUrlTo(MyController.class).myMethod()</code>.
	 * </p>
	 *
	 * @param <T>
	 *            The controller's type
	 * @param controller
	 *            The controller's class
	 * @return A proxy of the given class
	 */
	public <T> T saveUrlTo(final Class<T> controller) {
		return proxifier.proxify(controller, new MethodInvocation<T>() {

			public Object intercept(T proxyController, Method method, Object[] args, SuperMethod superMethod) {
				url = request.getContextPath() + router.urlFor(controller, method, args);
				return null;
			}

		});
	}

	/**
	 * <p>
	 * Retrieves the generated URL, after the method invocation.
	 * </p>
	 *
	 * @exception NullPointerException
	 *                If this method is called before completing the generation
	 *                of the link
	 */
	public String value() {
		checkNotNull(url, "Incomplete URL generation");
		return url;
	}
}
