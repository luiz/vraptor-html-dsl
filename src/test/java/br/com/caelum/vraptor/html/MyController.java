package br.com.caelum.vraptor.html;

import java.lang.reflect.Method;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.vraptor.Path;

class MyController {
	public static Method MY_METHOD = new Mirror().on(MyController.class).reflect().method("myMethod").withoutArgs();
	public static Method OTHER_METHOD = new Mirror().on(MyController.class).reflect().method("otherMethod").withArgs(String.class);
	public static Method NON_VOID_METHOD = new Mirror().on(MyController.class).reflect().method("nonVoidMethod").withoutArgs();
	public static Method OTHER_NON_VOID_METHOD = new Mirror().on(MyController.class).reflect().method("otherNonVoidMethod").withArgs(Integer.class);

	@Path("/path/to/method")
	public void myMethod() {}

	@Path("/path/to/{method}")
	public void otherMethod(String method) {}

	@Path("/path/to/nonVoid")
	public Integer nonVoidMethod() { return 0; }

	@Path("/path/to/nonVoid/{number}")
	public Integer otherNonVoidMethod(Integer number) { return number; }
}
