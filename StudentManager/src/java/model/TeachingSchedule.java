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
public class TeachingSchedule {
    private int teachingScheduleId,courseId,slot,roomCode,teacherId;
    private String descripion,teachingDate;

    public TeachingSchedule() {
    }

    public TeachingSchedule(int teachingScheduleId, int courseId, int slot, int roomCode, int teacherId, String descripion, String teachingDate) {
        this.teachingScheduleId = teachingScheduleId;
        this.courseId = courseId;
        this.slot = slot;
        this.roomCode = roomCode;
        this.teacherId = teacherId;
        this.descripion = descripion;
        this.teachingDate = teachingDate;
    }

    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public String getTeachingDate() {
        return teachingDate;
    }

    public void setTeachingDate(String teachingDate) {
        this.teachingDate = teachingDate;
    }
    
}
