package br.com.caelum.vraptor.html;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;
import java.util.HashMap;
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
import br.com.caelum.vraptor.proxy.DefaultProxifier;
import br.com.caelum.vraptor.proxy.Proxifier;

@RunWith(MockitoJUnitRunner.class)
public class VRaptorControllerUrlTest {
	private static final String CONTEXT = "/context";

	private @Mock Router router;
	private @Mock ServletContext context;
	private @Mock ParametersControl parametersControl;
	private @Mock ParameterNameProvider parameterNameProvider;

	private Proxifier proxifier;
	private VRaptorControllerUrl link;

	@Before
	public void setUp() throws Exception {
		proxifier = new DefaultProxifier();
		when(context.getContextPath()).thenReturn(CONTEXT);
		link = new VRaptorControllerUrl(router, proxifier, context, parametersControl, parameterNameProvider);
	}

	@Test
	public void generatesLinkForAControllerMethod() throws Exception {
		Class<MyController> controller = MyController.class;
		Object[] args = {};

		when(router.urlFor(controller, MyController.MY_METHOD, args)).thenReturn("/path/to/method");
		when(parameterNameProvider.parameterNamesFor(MyController.MY_METHOD)).thenReturn(new String[] {});

		link.saveUrlTo(controller).myMethod();

		assertEquals(CONTEXT + "/path/to/method", link.value());
	}

	@Test
	public void generatesLinkForAControllerMethodWithArgs() throws Exception {
		Class<MyController> controller = MyController.class;
		Object[] args = { "other" };
		final Map<String, String> pathParameters = new HashMap<String, String>();
		pathParameters.put("method", "other");

		doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) throws Throwable {
				MutableRequest mockRequest = (MutableRequest) invocation.getArguments()[1];
				when(mockRequest.getParameterMap()).thenReturn(pathParameters);
				return null;
			}
		}).when(parametersControl).fillIntoRequest(eq("/path/to/other"), any(MutableRequest.class));
		when(router.urlFor(controller, MyController.OTHER_METHOD, args)).thenReturn("/path/to/other");
		when(parameterNameProvider.parameterNamesFor(MyController.OTHER_METHOD)).thenReturn(new String[] { "method" });

		link.saveUrlTo(controller).otherMethod("other");

		assertEquals(CONTEXT + "/path/to/other", link.value());
	}

	@Test(expected=NullPointerException.class)
	public void throwsExceptionWhenTryingToRetrieveUrlWithoutSavingTheLink() throws Exception {
		VRaptorControllerUrl link = new VRaptorControllerUrl(router, proxifier, context, null, null);
		link.value();
	}

	@Test
	public void generatesLinkWithOneGetParameter() throws Exception {
		Class<MyController> controller = MyController.class;
		Object[] args = { "param" };

		when(router.urlFor(controller, MyController.PARAM_NOT_ON_PATH_METHOD, args)).thenReturn("/path/to");
		when(parameterNameProvider.parameterNamesFor(MyController.PARAM_NOT_ON_PATH_METHOD)).thenReturn(new String[] { "location" });

		link.saveUrlTo(controller).paramNotOnPath("param");

		assertEquals(CONTEXT + "/path/to?location=param", link.value());
	}

	@Test
	public void generatesLinkWithManyGetParameters() throws Exception {
		Class<MyController> controller = MyController.class;
		Integer numberArg = 42;
		Object[] args = { "param", numberArg };

		when(router.urlFor(controller, MyController.PARAMS_NOT_ON_PATH_METHOD, args)).thenReturn("/path/to/params");
		when(parameterNameProvider.parameterNamesFor(MyController.PARAMS_NOT_ON_PATH_METHOD)).thenReturn(new String[] { "location", "number" });

		link.saveUrlTo(controller).paramsNotOnPath("param", numberArg);

		assertEquals(CONTEXT + "/path/to/params?location=param&number=42", link.value());
	}

	@Test
	public void generatesLinkWithObjectGetParameters() throws Exception {
		Class<MyController> controller = MyController.class;
		MyModel myModel = new MyModel("myName", new GregorianCalendar(1987, 4, 25));
		Object[] args = { myModel };

		when(router.urlFor(controller, MyController.OBJECT_PARAM_NOT_ON_PATH_METHOD, args)).thenReturn("/path/to/objectParam");
		when(parameterNameProvider.parameterNamesFor(MyController.OBJECT_PARAM_NOT_ON_PATH_METHOD)).thenReturn(new String[] { "model" });

		link.saveUrlTo(controller).objectParamNotOnPath(myModel);

		assertEquals(CONTEXT + "/path/to/objectParam?model.name=myName&model.date=25/05/1987", link.value());
	}

	@Test
	public void generatesLinkWithComplexObjectGetParameters() throws Exception {
		Class<MyController> controller = MyController.class;
		MyModel myFirstModel = new MyModel("myName", new GregorianCalendar(1987, 4, 25));
		MyModel mySecondtModel = new MyModel("yourName", new GregorianCalendar(1981, 8, 3));
		MyComplexModel myComplexModel = new MyComplexModel(myFirstModel, mySecondtModel);
		Object[] args = { myComplexModel };

		when(router.urlFor(controller, MyController.COMPLEX_OBJECT_PARAM_NOT_ON_PATH_METHOD, args)).thenReturn("/path/to/complexObjectParam");
		when(parameterNameProvider.parameterNamesFor(MyController.COMPLEX_OBJECT_PARAM_NOT_ON_PATH_METHOD)).thenReturn(new String[] { "model" });

		link.saveUrlTo(controller).complexObjectParamNotOnPath(myComplexModel);

		assertThat(link.value(), startsWith(CONTEXT + "/path/to/complexObjectParam?"));
		assertThat(link.value(), containsString("model.models[0].name=myName"));
		assertThat(link.value(), containsString("model.models[0].date=25/05/1987"));
		assertThat(link.value(), containsString("model.models[1].name=yourName"));
		assertThat(link.value(), containsString("model.models[1].date=03/09/1981"));
	}
}
