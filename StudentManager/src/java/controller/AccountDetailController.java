/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dan.AccountDetailContext;
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
import model.Student;
import model.Teacher;

/**
 *
 * @author admin
 */
public class AccountDetailController extends HttpServlet {

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
        String usr = (String) session.getAttribute("logged");
        String level = (String) session.getAttribute("level");
        String save = request.getParameter("save");
        AccountDetailContext adc = new AccountDetailContext();
        int studentId = -1;
        int teacherId = -1;
        String id = request.getParameter("id");
        if (id != null) {
            Student std;
            studentId = Integer.parseInt(id);
            std = adc.getStudent(studentId);
            request.setAttribute("account", std);
            request.setAttribute("view", "true");
        } else {
            if (level.equals("student")) {
                Student std;
                studentId = (int) session.getAttribute("studentId");
                std = adc.getStudent(studentId);
                request.setAttribute("account", std);
            } else if (level.equals("teacher")) {
                Teacher tcr;
                teacherId = Integer.parseInt(usr);
                tcr = adc.getTeacher(teacherId);
                request.setAttribute("account", tcr);
            }
            if (save != null) {
                if (level.equals("student")) {
                    String phoneNumber = request.getParameter("phonenumber");
                    String email = request.getParameter("email");
                    String pwd = request.getParameter("pwd");
                    if (adc.updateStudent(studentId, phoneNumber, email, pwd)) {
                        response.sendRedirect("login");
                    }
                } else if (level.equals("teacher")) {
                    String pwd = request.getParameter("pwd");
                    if (adc.updateTeacher(teacherId, pwd)) {
                        response.sendRedirect("login");
                    }
                }
            }
        }
        request.getRequestDispatcher("accountdetail.jsp").forward(request, response);
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
            Logger.getLogger(AccountDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccountDetailController.class.getName()).log(Level.SEVERE, null, ex);
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
