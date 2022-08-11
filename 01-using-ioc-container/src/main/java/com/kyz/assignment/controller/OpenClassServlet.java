package com.kyz.assignment.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kyz.assignment.domain.Course;
import com.kyz.assignment.domain.OpenClass;
import com.kyz.assignment.model.CourseModel;
import com.kyz.assignment.model.OpenClassModel;

@WebServlet(urlPatterns = {
		"/classes",
		"/class-edit"
})
public class OpenClassServlet extends AbstractBeanFactoryServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  var courseId = req.getParameter("courseId");
		  // find Course
		  var courseModel = getBean("courseModel",CourseModel.class);
		  var course      = courseModel.findById(Integer.parseInt(courseId));
		  
		  req.setAttribute("course", course);
		  
          var page =switch(req.getServletPath()) {
          case "/classes" -> {
        	  
        	  var model = getBean("openClassModel", OpenClassModel.class);
        	  req.setAttribute("classes",model.findByCourse(Integer.parseInt(courseId)));
        	  yield "classes";
          }
          default -> "class-edit";
          };
          
         
          getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Req Parameter
		var courseId = req.getParameter("courseId");
		 System.out.println(courseId);
		var teacher  = req.getParameter("teacher");
		 System.out.println(teacher);
		var startDate = req.getParameter("startDate");
		 System.out.println(startDate);
		 
		 //create Class object
		 
		 var course = new Course();
		 
		 course.setId(Integer.parseInt("courseId"));
		 
		 var oc = new OpenClass();
		 oc.setCourse(course);
		 oc.setStartDate(Date.valueOf("startDate").toLocalDate());
		 oc.setTeacher("teacher");
		 
		 //save to database
		 
		 getBean("openClassModel", OpenClassModel.class).create(oc);
		 
		//redirect to top page
		resp.sendRedirect("/classes?courseId="+courseId);
		 
		 
		 
		 
		 
	}

}
