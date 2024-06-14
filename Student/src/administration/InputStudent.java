package administration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InputStudent extends JFrame {
    private JTextField attendanceIdField;
    private JComboBox<String> nameComboBox;
    private JComboBox<String> locationComboBox;
    private JComboBox<String> teacherComboBox;
    private JComboBox<String> absenceComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> periodsComboBox;
    private JComboBox<String> courseTypeComboBox;
    private JTable table;
    public DefaultTableModel tableModel;

    private StudentListener studentListener;

    public InputStudent() {
        // 设置窗体属性
        setTitle("录入窗口");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 考勤ID标签
        JLabel attendanceIdLabel = new JLabel("考勤ID");
        attendanceIdLabel.setBounds(50, 20, 50, 25);
        panel.add(attendanceIdLabel);

        // 考勤ID输入框
        attendanceIdField = new JTextField();
        attendanceIdField.setBounds(100, 20, 100, 25);
        panel.add(attendanceIdField);

        // 上课名称标签
        JLabel nameLabel = new JLabel("上课名称");
        nameLabel.setBounds(250, 20, 50, 25);
        panel.add(nameLabel);

        // 上课名称下拉框
        nameComboBox = new JComboBox<>(new String[]{"课程1", "课程2", "课程3"});
        nameComboBox.setBounds(300, 20, 100, 25);
        panel.add(nameComboBox);

        // 上课地点标签
        JLabel locationLabel = new JLabel("上课地点");
        locationLabel.setBounds(450, 20, 50, 25);
        panel.add(locationLabel);

        // 上课地点下拉框
        locationComboBox = new JComboBox<>(new String[]{"地点1", "地点2", "地点3"});
        locationComboBox.setBounds(500, 20, 100, 25);
        panel.add(locationComboBox);

        // 上课教师标签
        JLabel teacherLabel = new JLabel("上课教师");
        teacherLabel.setBounds(50, 60, 50, 25);
        panel.add(teacherLabel);

        // 上课教师下拉框
        teacherComboBox = new JComboBox<>(new String[]{"教师1", "教师2", "教师3"});
        teacherComboBox.setBounds(100, 60, 100, 25);
        panel.add(teacherComboBox);

        // 是否缺勤标签
        JLabel absenceLabel = new JLabel("是否缺勤");
        absenceLabel.setBounds(250, 60, 50, 25);
        panel.add(absenceLabel);

        // 是否缺勤下拉框
        absenceComboBox = new JComboBox<>(new String[]{"是", "否"});
        absenceComboBox.setBounds(300, 60, 100, 25);
        panel.add(absenceComboBox);

        // 上课日期标签
        JLabel dateLabel = new JLabel("上课日期");
        dateLabel.setBounds(450, 60, 50, 25);
        panel.add(dateLabel);

        // 上课日期下拉框
        dateComboBox = new JComboBox<>(new String[]{"2023-01-01", "2023-01-02", "2023-01-03"});
        dateComboBox.setBounds(500, 60, 100, 25);
        panel.add(dateComboBox);

        // 上课节数标签
        JLabel periodsLabel = new JLabel("上课节数");
        periodsLabel.setBounds(50, 100, 50, 25);
        panel.add(periodsLabel);

        // 上课节数下拉框
        periodsComboBox = new JComboBox<>(new String[]{"1", "2", "3"});
        periodsComboBox.setBounds(100, 100, 100, 25);
        panel.add(periodsComboBox);

        // 课程类型标签
        JLabel courseTypeLabel = new JLabel("课程类型");
        courseTypeLabel.setBounds(250, 100, 50, 25);
        panel.add(courseTypeLabel);

        // 课程类型下拉框
        courseTypeComboBox = new JComboBox<>(new String[]{"必修", "选修"});
        courseTypeComboBox.setBounds(300, 100, 100, 25);
        panel.add(courseTypeComboBox);

        // 确定按钮
        JButton confirmButton = new JButton("确定");
        confirmButton.setBounds(650, 100, 80, 25);
        panel.add(confirmButton);

        // 表格模型
        tableModel = new DefaultTableModel(new Object[]{"考勤ID", "上课名称", "上课地点", "上课教师", "是否缺勤", "上课日期", "上课节数", "课程类型"}, 0);
        table = new JTable(tableModel);

        // 表格面板
        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setBounds(50, 150, 680, 400);
        panel.add(tablePanel);

        // 确定按钮事件
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        // 添加面板到窗体
        add(panel);
    }

    private void addStudent() {
        String attendanceId = attendanceIdField.getText();
        String name = (String) nameComboBox.getSelectedItem();
        String location = (String) locationComboBox.getSelectedItem();
        String teacher = (String) teacherComboBox.getSelectedItem();
        String absence = (String) absenceComboBox.getSelectedItem();
        String date = (String) dateComboBox.getSelectedItem();
        String periods = (String) periodsComboBox.getSelectedItem();
        String courseType = (String) courseTypeComboBox.getSelectedItem();

        // Create a new Student object
        Student student = new Student(attendanceId, name, location, teacher, absence, date, periods, courseType);

        // Add student to table
        tableModel.addRow(new Object[]{attendanceId, name, location, teacher, absence, date, periods, courseType});

        // Notify listener
        if (studentListener != null) {
            studentListener.studentAdded(student);
        }

        // Clear input fields
        attendanceIdField.setText("");
    }

    public void setStudentListener(StudentListener listener) {
        this.studentListener = listener;
    }
}
