package administration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputStudent extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField classField;
    private JTable table;
    private DefaultTableModel tableModel;

    public InputStudent() {
        // 设置窗体属性
        setTitle("录入窗口");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // 姓名标签
        JLabel nameLabel = new JLabel("姓名");
        nameLabel.setBounds(50, 20, 50, 25);
        panel.add(nameLabel);

        // 姓名输入框
        nameField = new JTextField();
        nameField.setBounds(100, 20, 100, 25);
        panel.add(nameField);

        // 年龄标签
        JLabel ageLabel = new JLabel("年龄");
        ageLabel.setBounds(250, 20, 50, 25);
        panel.add(ageLabel);

        // 年龄输入框
        ageField = new JTextField();
        ageField.setBounds(300, 20, 100, 25);
        panel.add(ageField);

        // 班级标签
        JLabel classLabel = new JLabel("班级名");
        classLabel.setBounds(450, 20, 50, 25);
        panel.add(classLabel);

        // 班级输入框
        classField = new JTextField();
        classField.setBounds(500, 20, 100, 25);
        panel.add(classField);

        // 确定按钮
        JButton confirmButton = new JButton("确定");
        confirmButton.setBounds(650, 20, 80, 25);
        panel.add(confirmButton);

        // 表格模型
        tableModel = new DefaultTableModel(new Object[]{"姓名", "年龄", "班级"}, 0);
        table = new JTable(tableModel);

        // 表格面板
        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setBounds(50, 60, 680, 400);
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
        String name = nameField.getText();
        String age = ageField.getText();
        String className = classField.getText();

        // 添加数据到表格
        tableModel.addRow(new Object[]{name, age, className});

        // 清空输入框
        nameField.setText("");
        ageField.setText("");
        classField.setText("");
    }

}
