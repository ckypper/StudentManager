/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dan.CourseContext;
import dan.LoginContext;
import dan.ScheduleContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Courses;
import model.StudentAttendance;
import model.TeachingSchedule;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author admin
 */
public class CourseController extends HttpServlet {

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
            out.println("<title>Servlet CourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseController at " + request.getContextPath() + "</h1>");
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
        //Join In Class
        int studentId = -1;
        String courseId = request.getParameter("id");
        HttpSession session = request.getSession();
        CourseContext c = new CourseContext();
        LoginContext lc = new LoginContext();
        if (courseId != null) {
            try {
                studentId = (int) session.getAttribute("studentId");
                System.out.println(studentId);
            } catch (Exception ex) {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (studentId != -1) {
                try {
                    int cid = Integer.parseInt(courseId);
                    //add student to the course
                    if (c.addStudentCourse(studentId, cid)) {
                        //update capacity when student join
                        if (c.updateCapacity(cid)) {
                            //add schedule for student
                            ScheduleContext sc = new ScheduleContext();
                            ArrayList<TeachingSchedule> list = null;
                            list = (ArrayList<TeachingSchedule>) sc.getCourseTimeTable(cid);
                            for(TeachingSchedule i : list){
                                System.out.println(studentId + cid + i.getTeachingScheduleId());
                                boolean joined = sc.addStudentSchedule(studentId, cid, i.getTeachingScheduleId(), "NOT YET");
                            }
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //List Course 
        ArrayList<Courses> list = null;
        ArrayList<Courses> studentCourseList = null;
        try {
            list = (ArrayList<Courses>) c.getCourse();
            studentCourseList = (ArrayList<Courses>) lc.getStudentCourse((String) session.getAttribute("logged"));
        } catch (Exception ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("studentCourseList", studentCourseList);
        request.setAttribute("list", list);
        request.getRequestDispatcher("joinclass.jsp").forward(request, response);
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
