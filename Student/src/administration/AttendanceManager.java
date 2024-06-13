package administration;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AttendanceManager {
    private List<Attendance> attendanceList = new ArrayList<>();

    // 考勤信息录入功能
    public void addAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    // 考勤信息文件读取功能
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            attendanceList = (List<Attendance>) ois.readObject();
        }
    }

    // 考勤信息文件保存功能
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(attendanceList);
        }
    }

    // 考勤信息浏览功能
    public List<Attendance> getAttendances() {
        return attendanceList;
    }

    // 查询功能: 按 ID 查询
    public Attendance searchById(int id) {
        for (Attendance attendance : attendanceList) {
            if (attendance.getId() == id) {
                return attendance;
            }
        }
        return null;
    }

    // 查询功能: 按类型查询
    public List<Attendance> searchByCourseType(String courseType) {
        List<Attendance> result = new ArrayList<>();
        for (Attendance attendance : attendanceList) {
            if (attendance.getCourseType().equals(courseType)) {
                result.add(attendance);
            }
        }
        return result;
    }

    // 修改功能: 根据 ID 修改相应信息
    public void modifyAttendance(int id, Attendance newAttendance) {
        for (int i = 0; i < attendanceList.size(); i++) {
            if (attendanceList.get(i).getId() == id) {
                attendanceList.set(i, newAttendance);
                return;
            }
        }
    }

    // 删除考勤功能: 删除相应 ID 的考勤信息
    public void deleteAttendance(int id) {
        attendanceList.removeIf(attendance -> attendance.getId() == id);
    }

    // 排序功能: 由用户指定按照课程类型或ID;指定升序或降序
    public void sortAttendances(String criteria, boolean ascending) {
        Comparator<Attendance> comparator;

        if ("courseType".equalsIgnoreCase(criteria)) {
            comparator = Comparator.comparing(Attendance::getCourseType);
        } else {
            comparator = Comparator.comparingInt(Attendance::getId);
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        attendanceList.sort(comparator);
    }

    // 退出功能 (在此处可选择退出整个应用程序)
    public void exit() {
        System.out.println("Exiting the system.");
        System.exit(0);
    }
}
