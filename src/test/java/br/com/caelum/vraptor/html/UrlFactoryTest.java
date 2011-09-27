package br.com.caelum.vraptor.html;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.Map;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import br.com.caelum.vraptor.http.MutableRequest;
import br.com.caelum.vraptor.http.ParameterNameProvider;
import br.com.caelum.vraptor.http.route.ParametersControl;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.ioc.Container;
import br.com.caelum.vraptor.proxy.CglibProxifier;
import br.com.caelum.vraptor.proxy.ObjenesisInstanceCreator;
import br.com.caelum.vraptor.proxy.Proxifier;

import com.google.common.collect.ImmutableMap;

@RunWith(MockitoJUnitRunner.class)
public class UrlFactoryTest {
	private static final String CONTEXT_PATH = "/context";
	private @Mock Container container;
	private @Mock Router router;
	private @Mock ServletContext context;
	private @Mock ParametersControl parametersControl;
	private @Mock ParameterNameProvider parameterNameProvider;
	private Proxifier proxifier;
	private VRaptorControllerUrl link;

	@Before
	public void setUp() throws Exception {
		proxifier = new CglibProxifier(new ObjenesisInstanceCreator());
		link = new VRaptorControllerUrl(router, proxifier, context, parametersControl, parameterNameProvider);

		when(context.getContextPath()).thenReturn(CONTEXT_PATH);

		new UrlFactory(container); // initializes static field
	}

	@Test
	public void makesUrlForVoidControllerMethods() throws Exception {
		when(container.instanceFor(VRaptorControllerUrl.class)).thenReturn(link);
		when(router.urlFor(MyController.class, MyController.MY_METHOD, new Object[] {})).thenReturn("/path/to/method");
		when(parameterNameProvider.parameterNamesFor(MyController.MY_METHOD)).thenReturn(new String[0]);

		Url linkForVoidControllerMethod = UrlFactory.url(); UrlFactory.to(MyController.class).myMethod();
		assertEquals(CONTEXT_PATH + "/path/to/method", linkForVoidControllerMethod.value());
	}

	@Test
	public void makesUrlForNonVoidControllerMethods() throws Exception {
		when(container.instanceFor(VRaptorControllerUrl.class)).thenReturn(link);
		when(router.urlFor(MyController.class, MyController.NON_VOID_METHOD, new Object[] {})).thenReturn("/path/to/nonVoid");
		when(parameterNameProvider.parameterNamesFor(MyController.NON_VOID_METHOD)).thenReturn(new String[0]);

		Url linkForNonVoidControllerMethod = UrlFactory.url(UrlFactory.to(MyController.class).nonVoidMethod());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid", linkForNonVoidControllerMethod.value());
	}

	@Test
	public void makesManyUrls() throws Exception {
		VRaptorControllerUrl nonVoidLink = new VRaptorControllerUrl(router, proxifier, context, parametersControl, parameterNameProvider);
		VRaptorControllerUrl otherLink = new VRaptorControllerUrl(router, proxifier, context, parametersControl, parameterNameProvider);
		VRaptorControllerUrl otherNonVoidLink = new VRaptorControllerUrl(router, proxifier, context, parametersControl, parameterNameProvider);
		when(container.instanceFor(VRaptorControllerUrl.class)).thenReturn(link, nonVoidLink, otherNonVoidLink, otherLink);

		when(router.urlFor(MyController.class, MyController.MY_METHOD, new Object[] {})).thenReturn("/path/to/method");
		when(router.urlFor(MyController.class, MyController.NON_VOID_METHOD, new Object[] {})).thenReturn("/path/to/nonVoid");
		when(router.urlFor(MyController.class, MyController.OTHER_METHOD, new Object[] { "other" })).thenReturn("/path/to/other");
		when(router.urlFor(MyController.class, MyController.OTHER_NON_VOID_METHOD, new Object[] { 42 })).thenReturn("/path/to/nonVoid/42");

		configurePathParametersFor("/path/to/other", ImmutableMap.of("method", "other"));
		configurePathParametersFor("/path/to/nonVoid/42", ImmutableMap.of("number", "42"));

		when(parameterNameProvider.parameterNamesFor(MyController.MY_METHOD)).thenReturn(new String[0]);
		when(parameterNameProvider.parameterNamesFor(MyController.NON_VOID_METHOD)).thenReturn(new String[0]);
		when(parameterNameProvider.parameterNamesFor(MyController.OTHER_METHOD)).thenReturn(new String[] { "method" });
		when(parameterNameProvider.parameterNamesFor(MyController.OTHER_NON_VOID_METHOD)).thenReturn(new String[] { "number" });

		Url linkForVoidControllerMethod = UrlFactory.url(); UrlFactory.to(MyController.class).myMethod();
		Url linkForNonVoidControllerMethod = UrlFactory.url(UrlFactory.to(MyController.class).nonVoidMethod());
		Url linkForOtherNonVoidControllerMethod = UrlFactory.url(UrlFactory.to(MyController.class).otherNonVoidMethod(42));
		Url linkForOtherControllerMethod = UrlFactory.url(); UrlFactory.to(MyController.class).otherMethod("other");

		assertEquals(CONTEXT_PATH + "/path/to/method", linkForVoidControllerMethod.value());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid", linkForNonVoidControllerMethod.value());
		assertEquals(CONTEXT_PATH + "/path/to/nonVoid/42", linkForOtherNonVoidControllerMethod.value());
		assertEquals(CONTEXT_PATH + "/path/to/other", linkForOtherControllerMethod.value());
	}

	private void configurePathParametersFor(String path, final Map<String, String> parameters) {
		doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) throws Throwable {
				MutableRequest mockRequest = (MutableRequest) invocation.getArguments()[1];
				// XXX This is very coupled to the tested code... We are relying on the fact that
				// the current implementation uses a mocked MutableRequest to discover the
				// request parameters in the path. Refactor?
				when(mockRequest.getParameterMap()).thenReturn(parameters);
				return null;
			}
		}).when(parametersControl).fillIntoRequest(eq(path), any(MutableRequest.class));
	}
}