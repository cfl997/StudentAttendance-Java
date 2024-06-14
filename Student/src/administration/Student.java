package administration;

import java.io.Serializable;

public class Student implements Serializable {
    private String attendanceId;
    private String name;
    private String location;
    private String teacher;
    private String absence;
    private String date;
    private String periods;
    private String courseType;

    public Student(String attendanceId, String name, String location, String teacher, String absence, String date, String periods, String courseType) {
        this.attendanceId = attendanceId;
        this.name = name;
        this.location = location;
        this.teacher = teacher;
        this.absence = absence;
        this.date = date;
        this.periods = periods;
        this.courseType = courseType;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAbsence() {
        return absence;
    }

    public void setAbsence(String absence) {
        this.absence = absence;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "attendanceId='" + attendanceId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", teacher='" + teacher + '\'' +
                ", absence='" + absence + '\'' +
                ", date='" + date + '\'' +
                ", periods='" + periods + '\'' +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
