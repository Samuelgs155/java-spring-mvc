package com.spring.mvc.apirest.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.mvc.apirest.repository.LogRepository;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;

	// Se ejecuta antes de entrar en el controlador PRIMERO
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("starTime", System.currentTimeMillis());
		return true;
	}

	// Se ejecuta antes de mostrar la vista SEGUNDO
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("starTime");
		String url = request.getRequestURL().toString();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if (auth != null && auth.isAuthenticated()) {
			username = auth.getName();
		}
		com.spring.mvc.apirest.entity.Log log = new com.spring.mvc.apirest.entity.Log(new Date(),
				auth.getDetails().toString(), username, url);
		
		logRepository.save(log);

		LOG.info("URL to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "' ms ");
	}

}
