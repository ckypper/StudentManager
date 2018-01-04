/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dan.AttendanceContext;
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
import model.Student;

/**
 *
 * @author admin
 */
public class AttendanceController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        HttpSession session = request.getSession();
        String teachingScheduleId = request.getParameter("teachingScheduleId");
        if (teachingScheduleId == null) {
            teachingScheduleId = (String) session.getAttribute("teachingScheduleId");
        }
        session.setAttribute("teachingScheduleId", teachingScheduleId);
        AttendanceContext ac = new AttendanceContext();
        ArrayList<Student> list = null;
        list = ac.getStudentList(Integer.parseInt(teachingScheduleId));
        request.setAttribute("studentList", list);
        String save = request.getParameter("save");
        if (save != null) {
            for (Student i : list) {
                String status = request.getParameter(String.valueOf(i.getStudentID()));
                if (status != null) {
                    if (status.equals("present")) {
                        ac.updateStatus("PRESENT", i.getStudentID(), Integer.parseInt(teachingScheduleId));
                    } else if (status.equals("absent")) {
                        ac.updateStatus("ABSENT", i.getStudentID(), Integer.parseInt(teachingScheduleId));
                    }
                }
            }
            response.sendRedirect("teachingschedule");
        }
        
        request.getRequestDispatcher("attendance.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
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
