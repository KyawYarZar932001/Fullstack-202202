package com.kyz.assignment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyz.assignment.domain.OpenClass;
import com.kyz.assignment.domain.Registration;
import com.kyz.assignment.model.OpenClassModel;
import com.kyz.assignment.model.RegistrationModel;

@WebServlet(urlPatterns = {
		
		 "/registration",
		 "/registration-edit"
})
public class RegistrationServlet extends AbstractBeanFactoryServlet{

	
	private static final long serialVersionUID = 1L;
	
  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,NumberFormatException {
        var classId = req.getParameter("classId");	
	   //find class
	   var classmodel = getBean("openClassModel",OpenClassModel.class);
	   var openClass  = classmodel.findById(Integer.parseInt(classId));
	   req.setAttribute("openClass", openClass);
	   var page = switch(req.getServletPath()) {
	   case"/registration" -> {
		   
		   var model = getBean("registrationModel", RegistrationModel.class);
		   req.setAttribute("re", model.findByClass(Integer.parseInt(classId)));
		   yield"/registration";
	   }
	   default -> "registration-edit";
	   };
	   getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	   
    }
  
  
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	    	var classId = req.getParameter("classId");
			var student = req.getParameter("student");
			var phone = req.getParameter("phone");
			var email = req.getParameter("email");

			// Create Registration Object

			OpenClass oc = new OpenClass();
			oc.setId(Integer.parseInt(classId));
			Registration re = new Registration();
			re.setOpenClass(oc);
			re.setStudent(student);
			re.setPhone(phone);
			re.setEmail(email);

			// Save To database

		     getBean("registrationModel", RegistrationModel.class).save(re);

			// Redirect Process

		     resp.sendRedirect("/registration?classId="+classId);
	    	
	    }
	

}
