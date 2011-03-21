package br.com.caelum.vraptor.html;

import static br.com.caelum.vraptor.html.factories.PageTagFactory.text;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import net.vidageek.mirror.dsl.Mirror;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.MethodInfo;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.resource.ResourceMethod;

@RunWith(MockitoJUnitRunner.class)
public class PageProcessorInterceptorTest {
	private @Mock Result result;
	private @Mock MethodInfo methodInfo;

	private PageProcessorInterceptor interceptor;

	@Before
	public void setUp() throws Exception {
		this.interceptor = new PageProcessorInterceptor(result, methodInfo);
	}

	@Test
	public void acceptsMethodThatReturnsAPage() throws Exception {
		ResourceMethod resourceMethodThatReturnsPage = createMockResouceMethodForMethod("methodThatReturnsPage");

		assertTrue("Accepts a method that returns a Page", interceptor.accepts(resourceMethodThatReturnsPage));
	}

	@Test
	public void acceptsMethodThatReturnsAPageSubclass() throws Exception {
		ResourceMethod resourceMethodThatReturnsPageSubclass = createMockResouceMethodForMethod("methodThatReturnsPageSubclass");

		assertTrue("Accepts a method that returns a subclass of Page", interceptor.accepts(resourceMethodThatReturnsPageSubclass));
	}

	@Test
	public void doesNotAcceptMethodThatReturnsNothing() throws Exception {
		ResourceMethod resourceMethodThatReturnsNothing = createMockResouceMethodForMethod("methodThatReturnsNothing");

		assertFalse("Does not accept a method that returns nothing", interceptor.accepts(resourceMethodThatReturnsNothing));

	}

	@Test
	public void doesNotAcceptMethodThatReturnsSomethingOutOfPageHierarchy() throws Exception {
		ResourceMethod resourceMethodThatReturnsObject = createMockResouceMethodForMethod("methodThatReturnsObject");

		assertFalse("Does not accept a method that returns an instance of a class that does not implement Page",
				interceptor.accepts(resourceMethodThatReturnsObject));
	}

	@Test
	public void usesVRaptorHTMLDSLResultOnMethodReturnWhenIntercepting() throws Exception {
		VRaptorHTMLDSLView mockView = mock(VRaptorHTMLDSLView.class);
		Page pageReturnedByController = mock(Page.class);

		when(result.use(VRaptorHTMLDSLView.class)).thenReturn(mockView);
		when(methodInfo.getResult()).thenReturn(pageReturnedByController);

		interceptor.intercept(null, null, null);

		verify(mockView).page(pageReturnedByController);
	}

	private ResourceMethod createMockResouceMethodForMethod(String methodName) {
		Method method = new Mirror().on(PageProcessorTestController.class).reflect().method(methodName).withoutArgs();
		ResourceMethod resourceMethod = mock(ResourceMethod.class);
		when(resourceMethod.getMethod()).thenReturn(method);
		return resourceMethod;
	}
}

class EmptyPage implements Page {
	public NestedElement render() { return text(""); }
}

class PageProcessorTestController {
	public void methodThatReturnsNothing() {}
	public Object methodThatReturnsObject() { return "Hi"; }
	public EmptyPage methodThatReturnsPageSubclass() { return new EmptyPage(); }
	public Page methodThatReturnsPage() { return new EmptyPage(); }
}
