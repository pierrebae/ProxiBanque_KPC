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



	public String logout() throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.invalidateSession();
		//externalContext.setResponseStatus(401);
		//externalContext.getResponseOutputWriter()
		//		.write("<html><head><meta http-equiv='refresh' content='0; url=http://localhost:8080/ProxiBanque_KPC/listClients.xhtml'></head></html>");
		//externalContext.redirect("http://localhost:8080/ProxiBanque_KPC/listClients.xhtml");
		facesContext.responseComplete();
		return "/listClients?faces-redirect=true";
		
		
		
	}

}
