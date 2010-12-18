package br.com.caelum.vraptor.html.tags;

import static com.google.common.base.Preconditions.checkArgument;

import java.lang.reflect.Method;
import java.util.List;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.vraptor.proxy.DefaultProxifier;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.SuperMethod;

public class TagsBuilder<T> {

	private final class TagsBuilderFormatterInvoker<X> implements
			MethodInvocation<X> {
		private final X page;

		private TagsBuilderFormatterInvoker(X page) {
			this.page = page;
		}

		public Object intercept(X proxyPage, Method formatter, Object[] args,
				SuperMethod superMethod) {
			verifyPassedMethod(formatter);
			for (T object : objects) {
				Tag formatted = (Tag) new Mirror().on(this.page).invoke().method(formatter).withArgs(object);
				tags.append(formatted);
			}
			return null;
		}

		private void verifyPassedMethod(Method formatter) {
			checkArgument(Tag.class.isAssignableFrom(formatter.getReturnType()),
					"The formatting method %s must return a Tag",
					formatter.toGenericString());
			checkArgument(formatter.getParameterTypes().length == 1,
					"The formatting method %s must receive only one argument of type %s",
					formatter.toGenericString(), objects.getClass().getTypeParameters()[0].getName());
		}
	}

	private final List<T> objects;
	private final Tags tags;

	public TagsBuilder(List<T> objects) {
		this.objects = objects;
		this.tags = new Tags();
	}

	@SuppressWarnings("unchecked")
	public <X> X using(final X formatter) {
		MethodInvocation<X> formatterInvoker = new TagsBuilderFormatterInvoker<X>(formatter);
		return (X) new DefaultProxifier().proxify(formatter.getClass(), formatterInvoker);
	}

}
