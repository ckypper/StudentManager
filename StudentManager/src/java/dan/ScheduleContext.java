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
import model.StudentAttendance;
import model.TeachingSchedule;

/**
 *
 * @author admin
 */ 
public class ScheduleContext extends DBContext {

    public List<TeachingSchedule> getCourseTimeTable(int courseId) throws Exception {
        List<TeachingSchedule> list = new ArrayList<TeachingSchedule>();
        String sql = "select * from COURSE_SCHEDULES WHERE CourseId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, courseId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int teachingScheduleId = rs.getInt(1);
            String teachingDate = rs.getString(2);
            int slot = rs.getInt(3);
            int roomCode = rs.getInt(4);
            String description = rs.getString(5);
            int teachingId = rs.getInt(6);
            list.add(new TeachingSchedule(teachingScheduleId, courseId, slot, roomCode, teachingId, description, teachingDate));
        }
        return list;
    }

    public boolean addStudentSchedule(int studentId, int courseId, int teachingScheduleId, String status) throws Exception {
        String sql = "insert into STUDENT_ATTENDANCE values(?,?,?,?)";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        ps.setInt(3, teachingScheduleId);
        ps.setString(4, status);
        return (ps.executeUpdate() != 0);
    }

    public ArrayList<StudentAttendance> getStudentAttendance(int studentId, int courseId, int page_start, int page_size) throws Exception {
        ArrayList<StudentAttendance> list = new ArrayList<StudentAttendance>();
        String sql = "{call getStudentAttendance(?,?,?,?)}";
        CallableStatement cs = super.getConnection().prepareCall(sql);
        cs.setInt(1, studentId);
        cs.setInt(2, courseId);
        cs.setInt(3, page_start);
        cs.setInt(4, page_size);
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            int number = rs.getInt(1);
            String day = rs.getString(2);
            String date = rs.getString(3);
            int roomCode = rs.getInt(4);
            String subjectCode = rs.getString(5);
            String subjectName = rs.getString(6);
            String courseCode = rs.getString(7);
            String teacher = rs.getString(8);
            int slot = rs.getInt(9);
            String status = rs.getString(10);
            int teachingScheduleId = rs.getInt(11);
            list.add(new StudentAttendance(teacher, status, teachingScheduleId, number, roomCode, slot, day, date, subjectCode, subjectName, courseCode));
        }
        return list;
    }
    
    public int count(int studentId, int courseId) throws Exception{
        String sql = "Select COUNT(*) as Total from STUDENT_ATTENDANCE WHERE StudentId = ? and CourseId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt("Total");
                return total;
            }
        return 0;
    }
}
