package br.com.caelum.vraptor.html;

import java.lang.reflect.Method;
import java.util.Calendar;

import net.vidageek.mirror.dsl.Mirror;
import br.com.caelum.vraptor.Path;

class MyController {
	public static Method MY_METHOD = new Mirror().on(MyController.class).reflect().method("myMethod").withoutArgs();
	public static Method OTHER_METHOD = new Mirror().on(MyController.class).reflect().method("otherMethod").withArgs(String.class);
	public static Method PARAM_NOT_ON_PATH_METHOD = new Mirror().on(MyController.class).reflect().method("paramNotOnPath").withArgs(String.class);
	public static Method PARAMS_NOT_ON_PATH_METHOD = new Mirror().on(MyController.class).reflect().method("paramsNotOnPath").withArgs(String.class, Integer.class);
	public static Method OBJECT_PARAM_NOT_ON_PATH_METHOD = new Mirror().on(MyController.class).reflect().method("objectParamNotOnPath").withArgs(MyModel.class);
	public static Method NON_VOID_METHOD = new Mirror().on(MyController.class).reflect().method("nonVoidMethod").withoutArgs();
	public static Method OTHER_NON_VOID_METHOD = new Mirror().on(MyController.class).reflect().method("otherNonVoidMethod").withArgs(Integer.class);

	@Path("/path/to/method")
	public void myMethod() {}

	@Path("/path/to/{method}")
	public void otherMethod(String method) {}

	@Path("/path/to")
	public void paramNotOnPath(String location) {}

	@Path("/path/to/params")
	public void paramsNotOnPath(String location, Integer number) {}

	@Path("/path/to/objectParam")
	public void objectParamNotOnPath(MyModel model) {}

	@Path("/path/to/nonVoid")
	public Integer nonVoidMethod() { return 0; }

	@Path("/path/to/nonVoid/{number}")
	public Integer otherNonVoidMethod(Integer number) { return number; }
}

class MyModel {
	private String name;
	private Calendar date;
	public MyModel(String name, Calendar date) {
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
}