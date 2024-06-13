package administration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Main extends JFrame {
    private AttendanceManager attendanceManager = new AttendanceManager();
    private ArrayListStudent studentManager = new ArrayListStudent();
    
    private JTable table;
    private DefaultTableModel tableModel;
    
    private static InputStudent m_inputStudentui=new InputStudent();

    public Main() {
        setTitle("学生考勤管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 表格模型
        tableModel = new DefaultTableModel(new Object[]{"ID", "课程名称", "地点", "教师", "缺勤", "日期", "节数", "课程类型"}, 0);
        table = new JTable(tableModel);

        // 添加组件
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("添加考勤");
        JButton loadButton = new JButton("读取考勤文件");
        JButton saveButton = new JButton("保存考勤文件");
        JButton searchButton = new JButton("查询考勤");
        JButton modifyButton = new JButton("修改考勤");
        JButton deleteButton = new JButton("删除考勤");
        JButton sortButton = new JButton("排序考勤");
        JButton addStudentButton = new JButton("添加学生");
        JButton viewStudentsButton = new JButton("查看学生");
        JButton exitButton = new JButton("退出");

        buttonPanel.add(addButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(addStudentButton);
        buttonPanel.add(viewStudentsButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);

        // 事件处理
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAttendance();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAttendanceFromFile();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAttendanceToFile();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAttendance();
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyAttendance();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAttendance();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortAttendances();
            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        viewStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attendanceManager.exit();
            }
        });
    }

    private void addAttendance() {
        // TODO: 实现添加考勤记录的界面和功能
        // 示例数据录入
        attendanceManager.addAttendance(new Attendance(1, "Math", "Room 101", "Mr. Smith", false, new Date(), 2, "必修"));
        refreshTable();
    }

    private void loadAttendanceFromFile() {
        // TODO: 实现从文件读取考勤记录的功能
        try {
            attendanceManager.loadFromFile("attendance.dat");
            refreshTable();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveAttendanceToFile() {
        // TODO: 实现保存考勤记录到文件的功能
        try {
            attendanceManager.saveToFile("attendance.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchAttendance() {
        // TODO: 实现查询考勤记录的界面和功能
    }

    private void modifyAttendance() {
        // TODO: 实现修改考勤记录的界面和功能
    }

    private void deleteAttendance() {
        // TODO: 实现删除考勤记录的界面和功能
    }

    private void sortAttendances() {
        // TODO: 实现排序考勤记录的界面和功能
    }

    private void addStudent() {
        // TODO: 实现添加学生的界面和功能
        studentManager.addStudent(new Student(1, "John Doe", "Computer Science"));
    }

    private void viewStudents() {
        // TODO: 实现查看学生的界面和功能
        List<Student> students = studentManager.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<Attendance> attendances = attendanceManager.getAttendances();
        for (Attendance attendance : attendances) {
            tableModel.addRow(new Object[]{
                    attendance.getId(), attendance.getClassName(), attendance.getLocation(),
                    attendance.getTeacher(), attendance.isAbsent(), attendance.getDate(),
                    attendance.getClassHours(), attendance.getCourseType()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
                m_inputStudentui.setVisible(true);
            }
        });
    }
}

