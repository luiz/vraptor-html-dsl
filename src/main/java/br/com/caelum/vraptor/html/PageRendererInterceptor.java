package br.com.caelum.vraptor.html;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.core.MethodInfo;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

/**
 * <p>An interceptor to transform a Page object returned from a controller into HTML. Not working yet.</p>
 * @author luiz
 */
//@Intercepts
public class PageRendererInterceptor implements Interceptor {

	private final HttpServletResponse response;
	private final MethodInfo methodInfo;
	private final PageProcessor pageProcessor;

	public PageRendererInterceptor(MethodInfo methodInfo, PageProcessor pageProcessor, HttpServletResponse response) {
		this.methodInfo = methodInfo;
		this.pageProcessor = pageProcessor;
		this.response = response;
	}

	public boolean accepts(ResourceMethod method) {
		return Page.class.isAssignableFrom(method.getMethod().getReturnType());
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {
		if (accepts(method)) {
			Page result = (Page) methodInfo.getResult();
			try {
				response.getWriter().println(pageProcessor.process(result));
			} catch (IOException e) {
				throw new InterceptionException(e);
			}
		} else {
			stack.next(method, resourceInstance);
		}
	}

}
