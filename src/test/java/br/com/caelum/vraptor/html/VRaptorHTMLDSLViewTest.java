package br.com.caelum.vraptor.html;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class VRaptorHTMLDSLViewTest {

	@Test
	public void setsResponseMimeTypeAndWritesPageProcessorResultOnResponseBody() throws Exception {
		HttpServletResponse response = mock(HttpServletResponse.class);
		PageProcessor pageProcessor = mock(PageProcessor.class);
		PrintWriter responseWriter = mock(PrintWriter.class);
		Page renderedPage = mock(Page.class);
		String pageProcessorResult = "renderResult";

		when(response.getWriter()).thenReturn(responseWriter);
		when(pageProcessor.process(renderedPage)).thenReturn(pageProcessorResult);

		VRaptorHTMLDSLView view = new VRaptorHTMLDSLView(response, pageProcessor);
		view.page(renderedPage);

		verify(response).setHeader("Content-Type", "text/html;charset=UTF-8");
		verify(responseWriter).print(pageProcessorResult);
	}
}
