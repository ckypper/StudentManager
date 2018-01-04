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
public class CourseSchedule {
    private int number,roomCode,slot,teachingScheduleId;
    private String day,date,subjectCode,subjectName,courseCode;

    public CourseSchedule() {
    }

    public CourseSchedule(int teachingScheduleId,int number, int roomCode, int slot, String day, String date, String subjectCode, String subjectName, String courseCode) {
        this.number = number;
        this.roomCode = roomCode;
        this.slot = slot;
        this.day = day;
        this.date = date;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.courseCode = courseCode;
        this.teachingScheduleId = teachingScheduleId;
    }

    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    
}
