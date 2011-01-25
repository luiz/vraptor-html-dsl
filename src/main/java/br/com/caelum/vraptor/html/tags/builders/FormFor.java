package br.com.caelum.vraptor.html.tags.builders;

import static br.com.caelum.vraptor.html.PageAttributeFactory.attrs;
import static br.com.caelum.vraptor.html.PageAttributeFactory.name;
import static br.com.caelum.vraptor.html.PageAttributeFactory.type;
import static br.com.caelum.vraptor.html.PageAttributeFactory.value;
import static br.com.caelum.vraptor.html.PageTagFactory.input;
import static br.com.caelum.vraptor.html.PageTagFactory.text;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.html.attributes.Attributes;
import br.com.caelum.vraptor.html.tags.interfaces.NestedElement;
import br.com.caelum.vraptor.html.tags.interfaces.Tag;
import br.com.caelum.vraptor.html.transformers.DefaultTagTransformer;
import br.com.caelum.vraptor.html.transformers.TagTransformer;
import br.com.caelum.vraptor.proxy.DefaultProxifier;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

public class FormFor implements Tag {

	private final List<NestedElement> children;
	private final java.lang.Object resource;
	private final Attributes attributes;
	private final TagTransformer tagTransformer = new DefaultTagTransformer();

	private final static ThreadLocal<List<NestedElement>> childrenToGo = new ThreadLocal<List<NestedElement>>();
	private final static Proxifier proxifier = new DefaultProxifier();

	public FormFor(java.lang.Object resource, Attributes attributes) {
		this.resource = resource;
		this.attributes = attributes;
		this.children = getChildrenToGo();
		childrenToGo.remove();
	}

	public String toHtml() {
		return tagTransformer.transform(this, "form");
	}

	public NestedElement[] getChildren() {
		return children.toArray(new NestedElement[children.size()]);
	}

	public Attributes getAttributes() {
		return attributes;
	}

	private static List<NestedElement> getChildrenToGo() {
		List<NestedElement> list = childrenToGo.get();
		if (list == null) {
			list = new ArrayList<NestedElement>();
			childrenToGo.set(list);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T with(final T resource) {
		final Class<T> resourceClass = (Class<T>) resource.getClass();
		return proxifier.proxify(resourceClass, new MethodInvocation<T>() {

			public java.lang.Object intercept(T proxyResource, Method getter, java.lang.Object[] args, SuperMethod superMethod) {
				String inputName = inputName(resourceClass, getter);
				java.lang.Object defaultValue = null;
				try {
					defaultValue = getter.invoke(resource);
				} catch (Exception e) {
					e.printStackTrace();
				}
				getChildrenToGo().add(inputFor(inputName, defaultValue));
				return defaultValue;
			}


			private String inputName(Class<T> resourceClass, Method getter) {
				String fieldName = getter.getName().substring(2);
				if (!getterReturnsBoolean(getter)) {
					fieldName = getter.getName().substring(3);
				}
				return lowercaseFirstLetter(resourceClass.getSimpleName()) + "." + lowercaseFirstLetter(fieldName);
			}

			private String lowercaseFirstLetter(String string) {
				return Character.toLowerCase(string.charAt(0)) + string.substring(1);
			}

			private boolean getterReturnsBoolean(Method getter) {
				return Boolean.class.isAssignableFrom(getter.getReturnType()) ||
						boolean.class.isAssignableFrom(getter.getReturnType());
			}


			private NestedElement inputFor(String inputName, java.lang.Object defaultValue) {
				Elements elements = new Elements();
				elements.append(text(inputName));
				if (defaultValue != null) {
					elements.append(input(attrs(type("text"), name(inputName), value(defaultValue.toString()))));
				} else {
					elements.append(input(attrs(type("text"), name(inputName))));
				}
				return elements;
			}
		});
	}

}
