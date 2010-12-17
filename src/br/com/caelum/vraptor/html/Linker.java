package br.com.caelum.vraptor.html;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.Container;

@Component @ApplicationScoped
public class Linker {

	private static Container container;

	private static ThreadLocal<UrlForLink> last = new ThreadLocal<UrlForLink>();

	private static final Logger LOGGER = LoggerFactory.getLogger(Linker.class);

	public Linker(Container container) {
		Linker.container = container;
	}

	@PostConstruct
	public void initialize() {
		LOGGER.info("Initializing Linker");
	}

	public static Link link() {
		UrlForLink link = container.instanceFor(UrlForLink.class);
		last.set(link);
		return link;
	}

	public static Link link(String url) {
		return new StringLink(url);
	}

	public static Link link(Object whatever) {
		UrlForLink link = last.get(); last.set(null);
		return link;
	}
	public static <T> T to(Class<T> controller) {
		UrlForLink link = last.get(); last.set(null);
		if (link == null) {
			link = (UrlForLink) link();
		}

		return link.saveLinkTo(controller);
	}

}
