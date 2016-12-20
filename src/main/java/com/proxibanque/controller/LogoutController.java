package com.proxibanque.controller;

import java.io.IOException;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component("logoutController")
@ViewScoped
public class LogoutController {

	// @RequestMapping(method = RequestMethod.GET)
	// public String logout(HttpSession session) {
	// session.invalidate();
	// return "redirect:/login";
	// }

//	public void logout() throws IOException {
//		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
//				.getRequest();
//		try {
//			request.logout();
//		} catch (ServletException ex) {
//			throw new IOException(ex);
//		}
//	}

	public String logout() throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.invalidateSession();
		externalContext.setResponseStatus(401);
		externalContext.getResponseOutputWriter()
				.write("<html><head><meta http-equiv='refresh' content='0;URL=http://localhost:8080/ProxiBanque_KPC/login.xhtml'></head></html>");
		facesContext.responseComplete();
		return null;
	}

}
