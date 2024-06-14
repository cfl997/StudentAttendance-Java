package administration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListStudent {
    private List<Student> students = new ArrayList<>();

    // 增加学生
    public void addStudent(Student student) {
        students.add(student);
    }

    // 删除学生
    public void deleteStudent(String attendanceId) {
        students.removeIf(student -> student.getAttendanceId().equals(attendanceId));
    }

    // 修改学生信息
    public void updateStudent(String attendanceId, Student newStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAttendanceId().equals(attendanceId)) {
                students.set(i, newStudent);
                return;
            }
        }
    }

    // 查询学生信息
    public Student searchStudentByAttendanceId(String attendanceId) {
        for (Student student : students) {
            if (student.getAttendanceId().equals(attendanceId)) {
                return student;
            }
        }
        return null;
    }

    // 获取所有学生
    public List<Student> getAllStudents() {
        return students;
    }

    // 从文件加载学生信息
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
        }
    }

    // 保存学生信息到文件
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        }
    }
}
