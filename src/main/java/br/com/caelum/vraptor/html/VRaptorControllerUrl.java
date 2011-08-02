package br.com.caelum.vraptor.html;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import br.com.caelum.vraptor.http.MutableRequest;
import br.com.caelum.vraptor.http.ParameterNameProvider;
import br.com.caelum.vraptor.http.VRaptorRequest;
import br.com.caelum.vraptor.http.route.ParametersControl;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.PrototypeScoped;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

import com.google.common.collect.Sets;

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
	private final ServletContext context;
	private final ParametersControl parametersControl;
	private final ParameterNameProvider parameterNameProvider;

	VRaptorControllerUrl(Router router, Proxifier proxifier, ServletContext context, ParametersControl parametersControl, ParameterNameProvider parameterNameProvider) {
		this.router = router;
		this.proxifier = proxifier;
		this.context = context;
		this.parametersControl = parametersControl;
		this.parameterNameProvider = parameterNameProvider;
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
				String vraptorPath = router.urlFor(controller, method, args);
				url = context.getContextPath() + vraptorPath;
				Map<String, String> pathParameters = getPathParameters(vraptorPath);
				Map<String, Object> unusedParameters = findUnusedParameters(pathParameters, method, args);
				StringBuilder extraParams = new StringBuilder("?");
				for (String unusedParameter : unusedParameters.keySet()) {
					extraParams.append('&');
					extraParams.append(unusedParameter);
					extraParams.append('=');
					extraParams.append(unusedParameters.get(unusedParameter));
				}
				if (!unusedParameters.isEmpty()) {
					String getParameters = extraParams.deleteCharAt(1).toString();
					url += getParameters;
				}
				return null;
			}

			private Map<String, Object> findUnusedParameters(Map<String, String> pathParameters, Method method, Object[] args) {
				String[] allParameterNames = parameterNameProvider.parameterNamesFor(method);
				Set<String> pathParameterNames = new HashSet<String>(pathParameters.keySet());
				Set<String> allParameterNamesSet = Sets.newHashSet(allParameterNames);
				Set<String> unusedParameterNames = Sets.difference(allParameterNamesSet, pathParameterNames);
				Map<String, Object> unusedParameters = new HashMap<String, Object>();
				for (int i = 0; i < args.length; i++) {
					String currentParameterName = allParameterNames[i];
					if (unusedParameterNames.contains(currentParameterName)) {
						unusedParameters.put(currentParameterName, args[i]);
					}
				}
				return unusedParameters;
			}

			@SuppressWarnings("unchecked")
			private Map<String, String> getPathParameters(String vraptorPath) {
				MutableRequest mockRequest = new VRaptorRequest(mock(MutableRequest.class));
				parametersControl.fillIntoRequest(vraptorPath, mockRequest);
				return mockRequest.getParameterMap();
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
