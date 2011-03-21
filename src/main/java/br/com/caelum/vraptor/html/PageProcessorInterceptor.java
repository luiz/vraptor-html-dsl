package br.com.caelum.vraptor.html;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Lazy;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.core.MethodInfo;
import br.com.caelum.vraptor.interceptor.ExecuteMethodInterceptor;
import br.com.caelum.vraptor.interceptor.ForwardToDefaultViewInterceptor;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

/**
 * <p>VRaptor interceptor that renders a {@link Page} returned by a controller action.</p>
 *
 * @author luiz, lucascs
 * @since 1.1.0
 */

@Intercepts(after=ExecuteMethodInterceptor.class, before=ForwardToDefaultViewInterceptor.class)
@Lazy
public class PageProcessorInterceptor implements Interceptor {

	private final Result result;
	private final MethodInfo methodInfo;

	public PageProcessorInterceptor(Result result, MethodInfo methodInfo) {
		this.result = result;
		this.methodInfo = methodInfo;
	}

	public boolean accepts(ResourceMethod method) {
		return Page.class.isAssignableFrom(method.getMethod().getReturnType());
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object instance) throws InterceptionException {
		result.use(VRaptorHTMLDSLView.class).page((Page) methodInfo.getResult());
	}

}
