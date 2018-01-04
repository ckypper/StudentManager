/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class StudentAttendance extends CourseSchedule {
    String teacher, status;

    public StudentAttendance(String teacher, String status,int teachingScheduleId, int number, int roomCode, int slot, String day, String date, String subjectCode, String subjectName, String courseCode) {
        super(teachingScheduleId, number, roomCode, slot, day, date, subjectCode, subjectName, courseCode);
        this.teacher = teacher;
        this.status = status;
    }

    
    public StudentAttendance() {
        
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
