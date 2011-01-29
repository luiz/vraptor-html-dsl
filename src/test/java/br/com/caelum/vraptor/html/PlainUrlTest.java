package br.com.caelum.vraptor.html;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlainUrlTest {
	private @Mock HttpServletRequest request;
	private PlainUrl url;

	@Before
	public void setUp() throws Exception {
		this.url = new PlainUrl(request);
	}
	@Test
	public void storesUnmodifiedUrlWhenItDoesNotStartWithASlash() throws Exception {
		this.url.saveUrlTo("relative/to/current");
		assertEquals("relative/to/current", this.url.value());

		this.url.saveUrlTo("http://google.com");
		assertEquals("http://google.com", this.url.value());
	}

	@Test
	public void storesUrlRelativeToHostWhenItStartsWithASlash() throws Exception {
		when(request.getContextPath()).thenReturn("/someContext");
		this.url.saveUrlTo("/relative/to/context");
		assertEquals("/someContext/relative/to/context", this.url.value());
	}
}
