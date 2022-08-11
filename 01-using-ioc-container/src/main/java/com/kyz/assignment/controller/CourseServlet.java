package com.kyz.assignment.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;

import com.kyz.assignment.domain.Course;
import com.kyz.assignment.listener.SpringContainerManager;
import com.kyz.assignment.model.CourseModel;

@WebServlet(urlPatterns = { 
		"/", "/courses", "/course-edit"

})
public class CourseServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var page = switch (req.getServletPath()) {
		case "/course-edit" -> "/course-edit.jsp";
		default -> {
			// Load Course and set result to request scope
			var model = getBean("courseModel", CourseModel.class);
			req.setAttribute("courses", model.getAll());
            yield "/index.jsp";
		}
		};

		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //get Request Parameter
		var name = req.getParameter("name");
		var duration = req.getParameter("duration");
		var fees = req.getParameter("fees");
		var description = req.getParameter("description");

		
		//Create Course Object
		 var course = new Course();
		 course.setName(name);
		 course.setDescription(description);
		 course.setDuration(Integer.parseInt(duration));
		 course.setFees(Integer.parseInt(fees));
		 
		// Save to db
		getBean("courseModel", CourseModel.class).save(course);
		
		//redirect to top page
		resp.sendRedirect("/");
		
	}

}
