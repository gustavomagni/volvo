package com.meta.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Classe que registra e realiza start do processo de configuracao.
 * 
 * @author Gustavo Magni
 * @since 16/10
 *
 */
public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Config.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
