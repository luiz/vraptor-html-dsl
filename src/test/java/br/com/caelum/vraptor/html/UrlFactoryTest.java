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
public class UrlFactoryTest {
	private static final String CONTEXT_PATH = "/context";
	private @Mock Container container;
	private @Mock Router router;
	private @Mock HttpServletRequest request;
	private DefaultProxifier proxifier;
	private VRaptorControllerUrl link;

	@Before
	public void setUp() throws Exception {
		proxifier = new DefaultProxifier();
		link = new VRaptorControllerUrl(router, proxifier, request);

		when(request.getContextPath()).thenReturn(CONTEXT_PATH);

		new UrlFactory(container); // initializes static field
	}

	@Test
	public void makesUrlForVoidControllerMethods() throws Exception {
		when(container.instanceFor(VRaptorControllerUrl.class)).thenReturn(link);
		when(router.urlFor(MyController.class, MyController.MY_METHOD, new Object[] {})).thenReturn("/path/to/method");

		Url linkForVoidControllerMethod = UrlFactory.url(); UrlFactory.to(MyController.class).myMethod();
		assertEquals(CONTEXT_PATH + "/path/to/method", linkForVoidControllerMethod.value());
	}

	@Test
	public void makesUrlForNonVoidControllerMethods() throws Exception {
		when(container.instanceFor(VRaptorControllerUrl.class)).thenReturn(link);
		when(router.urlFor(MyController.class, MyController.NON_VOID_METHOD, new Object[] {})).thenReturn("/path/to/nonVoid");

		Url linkForNonVoidControllerMethod = UrlFactory.url(UrlFactory.to(MyController.class).nonVoidMethod());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid", linkForNonVoidControllerMethod.value());
	}

	@Test
	public void makesManyUrls() throws Exception {
		VRaptorControllerUrl nonVoidLink = new VRaptorControllerUrl(router, proxifier, request);
		VRaptorControllerUrl otherLink = new VRaptorControllerUrl(router, proxifier, request);
		VRaptorControllerUrl otherNonVoidLink = new VRaptorControllerUrl(router, proxifier, request);
		when(container.instanceFor(VRaptorControllerUrl.class)).thenReturn(link, nonVoidLink, otherNonVoidLink, otherLink);

		when(router.urlFor(MyController.class, MyController.MY_METHOD, new Object[] {})).thenReturn("/path/to/method");
		when(router.urlFor(MyController.class, MyController.NON_VOID_METHOD, new Object[] {})).thenReturn("/path/to/nonVoid");
		when(router.urlFor(MyController.class, MyController.OTHER_METHOD, new Object[] { "other" })).thenReturn("/path/to/other");
		when(router.urlFor(MyController.class, MyController.OTHER_NON_VOID_METHOD, new Object[] { 42 })).thenReturn("/path/to/nonVoid/42");

		Url linkForVoidControllerMethod = UrlFactory.url(); UrlFactory.to(MyController.class).myMethod();
		Url linkForNonVoidControllerMethod = UrlFactory.url(UrlFactory.to(MyController.class).nonVoidMethod());
		Url linkForOtherNonVoidControllerMethod = UrlFactory.url(UrlFactory.to(MyController.class).otherNonVoidMethod(42));
		Url linkForOtherControllerMethod = UrlFactory.url(); UrlFactory.to(MyController.class).otherMethod("other");

		assertEquals(CONTEXT_PATH + "/path/to/method", linkForVoidControllerMethod.value());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid", linkForNonVoidControllerMethod.value());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid/42", linkForOtherNonVoidControllerMethod.value());
		assertEquals(CONTEXT_PATH + "/path/to/other", linkForOtherControllerMethod.value());
	}
}