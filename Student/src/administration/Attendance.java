package administration;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {
    private int id;
    private String className;
    private String location;
    private String teacher;
    private boolean isAbsent;
    private Date date;
    private int classHours;
    private String courseType;

    public Attendance(int id, String className, String location, String teacher, boolean isAbsent, Date date, int classHours, String courseType) {
        this.id = id;
        this.className = className;
        this.location = location;
        this.teacher = teacher;
        this.isAbsent = isAbsent;
        this.date = date;
        this.classHours = classHours;
        this.courseType = courseType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getClassHours() {
        return classHours;
    }

    public void setClassHours(int classHours) {
        this.classHours = classHours;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", location='" + location + '\'' +
                ", teacher='" + teacher + '\'' +
                ", isAbsent=" + isAbsent +
                ", date=" + date +
                ", classHours=" + classHours +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
