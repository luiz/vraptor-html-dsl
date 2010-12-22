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
import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.proxy.DefaultProxifier;

@RunWith(MockitoJUnitRunner.class)
public class LinkerTest {
	private static final String CONTEXT_PATH = "/context";
	private @Mock Container container;
	private @Mock Router router;
	private @Mock HttpServletRequest request;
	private DefaultProxifier proxifier;
	private UrlForLink link;

	@Before
	public void setUp() throws Exception {
		proxifier = new DefaultProxifier();
		link = new UrlForLink(router, proxifier, request);

		when(request.getContextPath()).thenReturn(CONTEXT_PATH);

		new Linker(container); // initializes static field
	}

	@Test
	public void makesLinkForVoidControllerMethods() throws Exception {
		when(container.instanceFor(UrlForLink.class)).thenReturn(link);
		when(router.urlFor(MyController.class, MyController.MY_METHOD, new Object[] {})).thenReturn("/path/to/method");

		Link linkForVoidControllerMethod = Linker.link(); Linker.to(MyController.class).myMethod();
		assertEquals(CONTEXT_PATH + "/path/to/method", linkForVoidControllerMethod.url());
	}

	@Test
	public void makesLinkForNonVoidControllerMethods() throws Exception {
		when(container.instanceFor(UrlForLink.class)).thenReturn(link);
		when(router.urlFor(MyController.class, MyController.NON_VOID_METHOD, new Object[] {})).thenReturn("/path/to/nonVoid");

		Link linkForNonVoidControllerMethod = Linker.link(Linker.to(MyController.class).nonVoidMethod());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid", linkForNonVoidControllerMethod.url());
	}

	@Test
	public void makesManyLinks() throws Exception {
		UrlForLink nonVoidLink = new UrlForLink(router, proxifier, request);
		UrlForLink otherLink = new UrlForLink(router, proxifier, request);
		UrlForLink otherNonVoidLink = new UrlForLink(router, proxifier, request);
		when(container.instanceFor(UrlForLink.class)).thenReturn(link, nonVoidLink, otherNonVoidLink, otherLink);

		when(router.urlFor(MyController.class, MyController.MY_METHOD, new Object[] {})).thenReturn("/path/to/method");
		when(router.urlFor(MyController.class, MyController.NON_VOID_METHOD, new Object[] {})).thenReturn("/path/to/nonVoid");
		when(router.urlFor(MyController.class, MyController.OTHER_METHOD, new Object[] { "other" })).thenReturn("/path/to/other");
		when(router.urlFor(MyController.class, MyController.OTHER_NON_VOID_METHOD, new Object[] { 42 })).thenReturn("/path/to/nonVoid/42");

		Link linkForVoidControllerMethod = Linker.link(); Linker.to(MyController.class).myMethod();
		Link linkForNonVoidControllerMethod = Linker.link(Linker.to(MyController.class).nonVoidMethod());
		Link linkForOtherNonVoidControllerMethod = Linker.link(Linker.to(MyController.class).otherNonVoidMethod(42));
		Link linkForOtherControllerMethod = Linker.link(); Linker.to(MyController.class).otherMethod("other");

		assertEquals(CONTEXT_PATH + "/path/to/method", linkForVoidControllerMethod.url());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid", linkForNonVoidControllerMethod.url());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid/42", linkForOtherNonVoidControllerMethod.url());
		assertEquals(CONTEXT_PATH + "/path/to/other", linkForOtherControllerMethod.url());
	}
}