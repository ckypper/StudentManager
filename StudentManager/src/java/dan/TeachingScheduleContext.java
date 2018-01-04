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
import model.CourseSchedule;

/**
 *
 * @author admin
 */
public class TeachingScheduleContext extends DBContext {
    public List getTeacherCourse(int teacherId) throws Exception {
        List list = new ArrayList();
        String sql = "select CourseId from COURSES where TeacherId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, teacherId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int teacherCourse = rs.getInt(1);
            list.add(teacherCourse);
        }
        rs.close();
        return list;
    }
    
    public ArrayList<CourseSchedule> getCourseSchedule(int teacherId,int courseId,int page_start,int page_size) throws Exception {
        ArrayList<CourseSchedule> list = new ArrayList<>();
        String sql ="{call getTeachingSchedule(?,?,?,?)}";
        CallableStatement cs = super.getConnection().prepareCall(sql);
        cs.setInt(1, teacherId);
        cs.setInt(2, courseId);
        cs.setInt(3, page_start);
        cs.setInt(4, page_size);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            int number = rs.getInt(1);
            String day = rs.getString(2);
            String date = rs.getString(3);
            int roomCode = rs.getInt(4);
            String subjectCode = rs.getString(5);
            String subjectName = rs.getString(6);
            String courseCode = rs.getString(7);
            int slot = rs.getInt(8);
            int teachingScheduleId = rs.getInt(9);
            list.add(new CourseSchedule(teachingScheduleId, number, roomCode, slot, day, date, subjectCode, subjectName, courseCode));
        }
        rs.close();
        return list;
    }
    
    public int count(int teacherId, int courseId) throws Exception{
        String sql = "Select COUNT(*) as Total from COURSE_SCHEDULES WHERE TeacherId = ? and CourseId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setInt(1, teacherId);
        ps.setInt(2, courseId);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt("Total");
                return total;
            }
        return 0;
    }
}
