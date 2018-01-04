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
import model.Student;

/**
 *
 * @author admin
 */
public class AttendanceContext extends DBContext{
    public ArrayList<Student> getStudentList(int teachingScheduleId) throws Exception{
        ArrayList<Student> list = new ArrayList<>();
        String sql ="{call getStudentList(?)}";
        CallableStatement cs = super.getConnection().prepareCall(sql);
        cs.setInt(1, teachingScheduleId);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            int studentId = rs.getInt(1);
            String fullName = rs.getString(2);
            String rollNumber = rs.getString(3);
            String status = rs.getString(4);
            list.add(new Student(fullName, studentId,rollNumber,status));
        }
        rs.close();
        return list;
    }
    
    
    public boolean updateStatus(String status,int StudentId,int teachingScheduleId) throws Exception{
        String sql ="UPDATE STUDENT_ATTENDANCE SET Status = ? WHERE StudentId = ? and TeachingScheduleId = ?";
        PreparedStatement ps = super.getConnection().prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, StudentId);
        ps.setInt(3, teachingScheduleId);
        return (ps.executeUpdate() != 0);
    }
}
