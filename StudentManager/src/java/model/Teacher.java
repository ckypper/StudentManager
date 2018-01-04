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
public class Teacher {
    private int teacherId,yearOfExp;
    private String teacherFirstName,teacherMidName,teacherLastName,status,password;   

    public Teacher() {
    }

    public Teacher(int teacherId, int yearOfExp, String teacherFirstName, String teacherMidName, String teacherLastName, String status, String password) {
        this.teacherId = teacherId;
        this.yearOfExp = yearOfExp;
        this.teacherFirstName = teacherFirstName;
        this.teacherMidName = teacherMidName;
        this.teacherLastName = teacherLastName;
        this.status = status;
        this.password = password;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherMidName() {
        return teacherMidName;
    }

    public void setTeacherMidName(String teacherMidName) {
        this.teacherMidName = teacherMidName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
