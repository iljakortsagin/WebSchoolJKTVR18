/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Person;
import entity.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.PersonFacade;
import session.SubjectFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "WebController", urlPatterns = {
    "/addPerson",
    "/addSubject",
    
})
    
public class WebController extends HttpServlet {
@EJB PersonFacade personFacade;
@EJB SubjectFacade subjectFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/addPerson":
                String firstName=request.getParameter("firstName");
                String lastName=request.getParameter("lastName");
                String status=request.getParameter("status");
                Person person = new Person(firstName, lastName, status);
                personFacade.create(person);
                
                break;
            case "/addSubject":
                String name=request.getParameter("name");
                String hours=request.getParameter("hours");
                String teacher=request.getParameter("teacher");
                Subject subject = new Subject(name, hours, teacher);
                subjectFacade.create(subject);
                
                break;
            default:
                throw new AssertionError();
            
        }
    
    }
        
}

   

