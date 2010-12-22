package br.com.caelum.vraptor.html;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import javax.servlet.http.HttpServletRequest;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.proxy.DefaultProxifier;
import br.com.caelum.vraptor.proxy.Proxifier;

@RunWith(MockitoJUnitRunner.class)
public class UrlForLinkTest {
	private static final String CONTEXT = "/context";

	private @Mock Router router;
	private @Mock HttpServletRequest request;

	private Proxifier proxifier;
	private UrlForLink link;

	@Before
	public void setUp() throws Exception {
		proxifier = new DefaultProxifier();
		when(request.getContextPath()).thenReturn(CONTEXT);
		link = new UrlForLink(router, proxifier, request);
	}

	@Test
	public void generatesLinkForAControllerMethod() throws Exception {
		Class<MyController> controller = MyController.class;
		Object[] args = new Object[] {};

		when(router.urlFor(controller, MyController.MY_METHOD, args)).thenReturn("/path/to/method");

		link.saveLinkTo(controller).myMethod();

		assertEquals(CONTEXT + "/path/to/method", link.url());
	}

	@Test
	public void generatesLinkForAControllerMethodWithArgs() throws Exception {
		Class<MyController> controller = MyController.class;
		Object[] args = new Object[] { "other" };

		when(router.urlFor(controller, MyController.OTHER_METHOD, args)).thenReturn("/path/to/other");

		link.saveLinkTo(controller).otherMethod("other");

		assertEquals(CONTEXT + "/path/to/other", link.url());
	}

	@Test(expected=NullPointerException.class)
	public void throwsExceptionWhenTryingToRetrieveUrlWithoutSavingTheLink() throws Exception {
		UrlForLink link = new UrlForLink(router, proxifier, request);
		link.url();
	}
}
