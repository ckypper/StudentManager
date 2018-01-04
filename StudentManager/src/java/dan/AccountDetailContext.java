/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Student;
import model.Teacher;

/**
 *
 * @author admin
 */
public class AccountDetailContext extends DBContext {

    public Student getStudent(int studentId) throws Exception {
        Student std = null;
        String sql = "select * from STUDENTS where StudentId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String rollNumber = rs.getString(1);
            String firstName = rs.getString(2);
            String midName = rs.getString(3);
            String lastName = rs.getString(4);
            String dateOfBirth = rs.getString(5);
            String phoneNumber = rs.getString(6);
            String country = rs.getString(7);
            String address = rs.getString(8);
            String email = rs.getString(9);
            String password = rs.getString(10);
            std = new Student(rollNumber, firstName, lastName, midName, dateOfBirth, phoneNumber, country, address, email, password);
        }
        rs.close();
        return std;
    }

    public boolean updateTeacher(int teacherId, String password) throws Exception {
        String sql = "UPDATE TEACHERS SET Password =? where TeacherId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(2, teacherId);
        ps.setString(1, password);
        return (ps.executeUpdate() != 0);
    }

    public Teacher getTeacher(int teacherId) throws Exception {
        Teacher tcr = null;
        String sql = "select * from TEACHERS where TeacherId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, teacherId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String firstName = rs.getString(2);
            String midName = rs.getString(3);
            String lastName = rs.getString(4);
            int yearOfExp = rs.getInt(5);
            String status = rs.getString(6);
            String password = rs.getString(7);
            tcr = new Teacher(teacherId, yearOfExp, firstName, midName, lastName, status, password);
        }
        rs.close();
        return tcr;
    }

    public boolean updateStudent(int studentId, String phoneNumber, String email, String password) throws Exception {
        String sql = "UPDATE STUDENTS SET PhoneNumber = ? , Email = ? , Password = ? Where StudentId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setString(1, phoneNumber);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setInt(4, studentId);
        return (ps.executeUpdate() != 0);
    }
}
