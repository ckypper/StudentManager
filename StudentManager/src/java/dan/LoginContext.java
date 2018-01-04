/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dan;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List;
import model.Student;
import model.Teacher;

/**
 *
 * @author admin
 */
public class LoginContext extends DBContext {

    public ArrayList<Student> getStudentDetail() throws Exception {
        ArrayList<Student> d = new ArrayList<>();
        String sql = "select * from STUDENTS";
        //sql = "{call GetDepartments(?)}";//call a store from sql
        CallableStatement cs = super.getConnection().prepareCall(sql);
        //Statement st  = super.getConnection().createStatement();
        //send sql to sql server
        ResultSet rs = cs.executeQuery();
        //travel to all rows/records of rs
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
            //save to list
            d.add(new Student(rollNumber, firstName, lastName, midName, dateOfBirth, phoneNumber, country, address, email, password));
        }
        rs.close();
        return d;
    }
    
    
    
    public Teacher getTeacher(int teacherId) throws Exception{
        Teacher tcr = null;
        String sql = "select * from TEACHERS where TeacherId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, teacherId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
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

    public boolean addStudent(Student student) throws Exception {
        String sql = "insert into STUDENTS values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setString(1, student.getRollNumber());
        ps.setString(2, student.getFirstName());
        ps.setString(3, student.getMidName());
        ps.setString(4, student.getLastName());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        date = format.parse(student.getDateOfBirth());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        ps.setDate(5, sqlDate);
        ps.setString(6, student.getPhoneNumber());
        ps.setString(7, student.getCountry());
        ps.setString(8, student.getAddress());
        ps.setString(9, student.getEmail());
        ps.setString(10, student.getPassword());
        return (ps.executeUpdate() != 0);
    }

    public int getStudentId(String rollnumber) throws Exception {
        int studentId = -1;
        String sql = "select StudentId from STUDENTS WHERE Roll# = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setString(1, rollnumber);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            studentId = rs.getInt(1);
        }
        rs.close();
        return studentId;
    }
    
     public List getStudentCourse(String rollnumber) throws Exception {
        List d = new ArrayList<>();
        String sql ="{call getStudentCourse(?)}";
        CallableStatement cs = super.getConnection().prepareCall(sql);
        cs.setString(1, rollnumber);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            d.add(rs.getInt(1));
        }
        rs.close();
        return d;
    }
     
    public ArrayList<Teacher> getTeacherDetail() throws Exception{
        ArrayList<Teacher> list = new ArrayList<>();
        String sql = "select * from TEACHERS";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int teacherId = rs.getInt(1);
            String firstName = rs.getString(2);
            String midName = rs.getString(3);
            String lastName = rs.getString(4);
            int yearOfExp = rs.getInt(5);
            String status = rs.getString(6);
            String password = rs.getString(7);
            list.add(new Teacher(teacherId, yearOfExp, firstName, midName, lastName, status, password));
        }
        rs.close();
        return list;
    }

}
