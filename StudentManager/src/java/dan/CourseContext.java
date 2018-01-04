/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dan;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Courses;

/**
 *
 * @author admin
 */
public class CourseContext extends DBContext {

    public List<Courses> getCourse() throws Exception {
        List<Courses> d = new ArrayList<>();
        String sql = "{call getCourse}";
        CallableStatement cs = super.getConnection().prepareCall(sql);
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            int courseId = rs.getInt(1);
            String courseCode = rs.getString(2);
            String subjectCode = rs.getString(3);
            String subjectName = rs.getString(4);
            String teacherName = rs.getString(5);
            String termName = rs.getString(6);
            String fromDate = rs.getString(7);
            String toDate = rs.getString(8);
            int capacity = rs.getInt(9);
            d.add(new Courses(courseId, capacity, courseCode, subjectCode, subjectName, teacherName, termName, fromDate, toDate));
        }
        rs.close();
        return d;
    }

    
    public boolean addStudentCourse(int studentId,int courseId) throws Exception {
        String sql = "insert into STUDENT_COURSE values(?,?)";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        return (ps.executeUpdate() != 0);
    }
    
    public boolean updateCapacity(int courseId) throws Exception{
        String sql = "UPDATE COURSES "
                + "SET Capacity = Capacity-1 "
                + "WHERE CourseId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, courseId);
        return (ps.executeUpdate() != 0);
    }
    
}
