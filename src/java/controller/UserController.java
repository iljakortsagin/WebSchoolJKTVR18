/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Person;
import entity.Subject;
import java.io.IOException;
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
@WebServlet(name = "UserController", urlPatterns = {
    "/showAddSubject",
    "/showAddStudent",
    "/addStudent",
    "/addSubject",

})
public class UserController extends HttpServlet {
    @EJB private PersonFacade personFacade;
    @EJB private SubjectFacade subjectFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
       
            case "/showAddSubject":
                request.getRequestDispatcher("/WEB-INF/showAddSubject.jsp")
                        .forward(request, response);
                break;
            case "/showAddStudent":
                
                request.getRequestDispatcher("/WEB-INF/showAddStudent.jsp")
                        .forward(request, response);
                break;
            case "/addStudent":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String status = request.getParameter("status");
               
                try{
                    Person person = new Person(null, firstname, lastname, status);
                    personFacade.create(person);
                    request.setAttribute("person", person);
                    request.setAttribute("info", "Студент добавлен");
                }catch(NumberFormatException e){
                    request.setAttribute("info", "Некорректные данные"); 
                    request.setAttribute("firstname", firstname);
                    request.setAttribute("lastname", lastname);
                    request.setAttribute("status", status);
                }
                request.getRequestDispatcher("/WEB-INF/showAddStudent.jsp")
                        .forward(request, response);    
                break;
            case "/addSubject":
                String hours = request.getParameter("hours");
                String name = request.getParameter("name");
                String personId = request.getParameter("personId");
                Person person = personFacade.find(Long.parseLong(personId));
                try{
                    Subject subject = new Subject(name, Integer.parseInt(hours), person);
                    subjectFacade.create(subject);
                    request.setAttribute("subject", subject);
                    request.setAttribute("info", "Предмет добавлен");
                }catch(NumberFormatException e){
                    request.setAttribute("info", "Некорректные данные"); 
                    request.setAttribute("hours", hours);
                    request.setAttribute("name", name);
                    request.setAttribute("person", person);
                }
                request.getRequestDispatcher("/WEB-INF/showAddSubject.jsp")
                        .forward(request, response);    
                break;        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
