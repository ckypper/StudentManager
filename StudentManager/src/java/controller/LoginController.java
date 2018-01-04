/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dan.LoginContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Courses;
import model.Student;
import model.Teacher;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        boolean log = false;
        LoginContext lc = new LoginContext();
        ArrayList<Student> studentList = null;
        ArrayList<Teacher> teacherList = null;
        try {
            studentList = lc.getStudentDetail();
            teacherList = lc.getTeacherDetail();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Student i : studentList) {
            if (i.getRollNumber().equals(usr)) {
                if (i.getPassword().equals(pwd)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("logged", usr);
                    int studentId = -1;
                    ArrayList studentCourseList = null;
                    try {
                        studentId = lc.getStudentId(usr);
                        studentCourseList = (ArrayList) lc.getStudentCourse((String) session.getAttribute("logged"));
                    } catch (Exception ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    session.setAttribute("studentCourseList", studentCourseList);
                    session.setAttribute("studentId", studentId);
                    session.setAttribute("level","student");
                    log = true;
                    break;
                }
            }
        }
        for(Teacher i : teacherList){
            String teacherId = String.valueOf(i.getTeacherId());
            if(teacherId.equals(usr)){
                if(i.getPassword().equals(pwd)){
                    HttpSession session = request.getSession();
                    session.setAttribute("logged", usr);
                    session.setAttribute("level","teacher");
                    log = true;
                    break;
                }
            }
        }
        if (log) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("logged", "false");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
