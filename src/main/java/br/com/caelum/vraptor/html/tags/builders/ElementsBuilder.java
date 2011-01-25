package br.com.caelum.vraptor.html.tags.builders;

import static com.google.common.base.Preconditions.checkArgument;

import java.lang.reflect.Method;
import java.util.List;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.proxy.DefaultProxifier;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.SuperMethod;

/**
 * <p>
 * Builder class for an instance of {@link Elements}. Uses a dynamic proxy to
 * intercept an invocation to a method that receives an instance of T and
 * returns the corresponding {@link NestedElement} for it. The intercepted
 * method is then invoked in a real instance, once for each element of the
 * collection given at the constructor of this class. Finally, the proxy returns
 * an instance of {@link Elements}, filled in with the {@link NestedElement}
 * returned from each invocation to the real method.
 * </p>
 *
 * @author luiz
 *
 * @param <T>
 *            Type of the objects to be transformed into a {@link NestedElement}
 *            (HTML elements)
 */
public class ElementsBuilder<T> {

	private final class ElementsBuilderFormatterInvoker<X> implements
			MethodInvocation<X> {
		private final X page;

		private ElementsBuilderFormatterInvoker(X page) {
			this.page = page;
		}

		public java.lang.Object intercept(X proxyPage, Method formatter, java.lang.Object[] args,
				SuperMethod superMethod) {
			verifyPassedMethod(formatter);
			for (T object : objects) {
				NestedElement formatted = (NestedElement) new Mirror().on(this.page).invoke().method(formatter).withArgs(object);
				elements.append(formatted);
			}
			return elements;
		}

		private void verifyPassedMethod(Method formatter) {
			checkArgument(NestedElement.class.isAssignableFrom(formatter.getReturnType()),
					"The formatting method %s must return a NestedElement",
					formatter.toGenericString());
			checkArgument(formatter.getParameterTypes().length == 1,
					"The formatting method %s must receive only one argument",
					formatter.toGenericString());
			checkArgument(formatter.getParameterTypes()[0].equals(objects.get(0).getClass()),
					"The formatting method %s must receive one argument of type %s",
					formatter.toGenericString(), objects.get(0).getClass().getName());
		}
	}

	private final List<T> objects;
	private final Elements elements;

	public ElementsBuilder(List<T> objects) {
		this.objects = objects;
		this.elements = new Elements();
	}

	/**
	 * <p>
	 * Uses a proxy to specify which method should be called for each element of
	 * the collection given at construction time. Intended to be used like
	 * <code>builder.using(object).formatterMethod(null)</code>
	 * </p>
	 *
	 * @param <X>
	 *            Type of the object which contains the formatter method
	 * @param formatter
	 *            The object which contains the formatter method
	 * @return A proxy of the same class as the given object
	 */
	@SuppressWarnings("unchecked")
	public <X> X using(X formatter) {
		MethodInvocation<X> formatterInvoker = new ElementsBuilderFormatterInvoker<X>(formatter);
		return (X) new DefaultProxifier().proxify(formatter.getClass(), formatterInvoker);
	}

}
