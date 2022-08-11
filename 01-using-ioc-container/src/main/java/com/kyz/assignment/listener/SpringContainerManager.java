package com.kyz.assignment.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.GenericXmlApplicationContext;
@WebListener
public class SpringContainerManager implements ServletContextListener {
	public static final String SPRING_CONTEXT = "spring.context";
	private GenericXmlApplicationContext springContext;
	
	
   @Override
   public void contextInitialized(ServletContextEvent sce) {
	   //Start IOC container
	  System.out.println("Initialiazed Ioc Container");
	  //Add Ioc Container to Application scope
	  
	  springContext = new GenericXmlApplicationContext("classpath:application.xml");
	  sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext);
   }
   
   @Override
	public void contextDestroyed(ServletContextEvent sce) {
		//close IOc container
	   System.out.println("close Ioc Container project");
	   if(null != springContext) {
		   springContext.close();
	   }
	}
}
