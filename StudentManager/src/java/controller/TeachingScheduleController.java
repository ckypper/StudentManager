/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dan.TeachingScheduleContext;
import dan.ScheduleContext;
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
import model.CourseSchedule;
import model.StudentAttendance;

/**
 *
 * @author admin
 */
public class TeachingScheduleController extends HttpServlet {

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
        HttpSession session = request.getSession();
        ArrayList list  = null;
        int teacherId =  Integer.parseInt((String) session.getAttribute("logged"));
        TeachingScheduleContext tsc = new TeachingScheduleContext();
        try {
            list = (ArrayList) tsc.getTeacherCourse(teacherId);
        } catch (Exception ex) {
            Logger.getLogger(TeachingScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("teacherCourseList", list);
        String courseId = request.getParameter("courseId");
        if (courseId == null && session.getAttribute("courseId") != null) {
            courseId = (String) session.getAttribute("courseId");
        }
        if (courseId != null) {
            session.setAttribute("courseId", courseId);
            String raw_page = request.getParameter("page");
            int page = -1;
            int page_size = 29;
            page = (raw_page == null) ? 1 : Integer.parseInt(raw_page);
            int current_record = ((page - 1) * page_size) + 1;
            ArrayList<CourseSchedule> courseSchedule = null;
            int totalRecord = -1;
            try {
                courseSchedule = tsc.getCourseSchedule(teacherId, Integer.parseInt(courseId), current_record, page_size);
                totalRecord = tsc.count(teacherId, Integer.parseInt(courseId));
                System.out.println(totalRecord);
            } catch (Exception ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            int totalPage = (totalRecord % page_size == 0)
                    ? (totalRecord / page_size) : (totalRecord / page_size) + 1;
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("page", page);
            request.setAttribute("courseSchedule", courseSchedule);
            request.setAttribute("loadPage", "true");
        }
        request.getRequestDispatcher("teachingschedule.jsp").forward(request, response);
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
