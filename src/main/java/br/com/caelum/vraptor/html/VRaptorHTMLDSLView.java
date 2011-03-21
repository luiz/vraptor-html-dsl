package br.com.caelum.vraptor.html;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.view.ResultException;

/**
 * <p>
 * VRaptor view for a VRaptor HTML DSL {@link Page}.
 * </p>
 *
 * <p>
 * This class is intended to be used with VRaptor's {@link Result}. For
 * instance, suppose you have an instance of a Result in a variable called
 * <code>result</code> (creative, huh?), and you want to render a page described
 * by a <code>ExamplePage</code> (implementing the Page interface). Then you can
 * do the following in your controller:
 * </p>
 *
 * <code>result.use(VRaptorHTMLDSLView.class).page(new ExamplePage());</code>
 *
 * <p>
 * Or, better, you can use the method {@link VRaptorHTMLDSLView#html()} instead
 * of <code>VRaptorHTMLDSLView.class</code>:
 * </p>
 *
 * <code>result.use(html()).page(new ExamplePage());</code>
 *
 * @author luiz, lucascs
 * @since 1.1.0
 */
@Component
public class VRaptorHTMLDSLView implements View {

	private final PageProcessor pageProcessor;
	private final HttpServletResponse response;

	public VRaptorHTMLDSLView(HttpServletResponse response, PageProcessor pageProcessor) {
		this.response = response;
		this.pageProcessor = pageProcessor;
	}

	/**
	 * <p>Renders the given page</p>
	 *
	 * @param page The page to be rendered
	 */
	public void page(Page page) {
		try {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.getWriter().print(pageProcessor.process(page));
		} catch (IOException e) {
			throw new ResultException(e);
		}
	}

	/**
	 * <p>Use a VRaptor HTML DSL page as a result</p>
	 */
	public static Class<VRaptorHTMLDSLView> html() {
		return VRaptorHTMLDSLView.class;
	}

}
