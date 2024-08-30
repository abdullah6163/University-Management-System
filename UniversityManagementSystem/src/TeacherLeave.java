import javax.swing.*;
import java.awt.*;

public class TeacherLeave extends JFrame {
    Font font = new Font("Arial", Font.BOLD, 20);

    TeacherLeave() {
        initComponent();
        windowContent();
        this.setVisible(true);
    }
    private void initComponent() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Teacher Leave");
        this.setSize(500, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    private void windowContent() {
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(null);
        panel.setBackground(new Color(0xA6CEF5));

        JLabel title = new JLabel("Teacher Leave");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(150, 10, 250, 30);
        panel.add(title);

        JLabel teacherName = new JLabel("Teacher Name");
        teacherName.setFont(font);
        teacherName.setBounds(50, 100, 200, 20);
        panel.add(teacherName);

        JTextField teacherNameField = new JTextField();
        teacherNameField.setFont(font);
        teacherNameField.setBounds(250, 100, 200, 20);
        panel.add(teacherNameField);

        JLabel teacherID = new JLabel("Teacher ID");
        teacherID.setFont(font);
        teacherID.setBounds(50, 150, 200, 20);
        panel.add(teacherID);

        JTextField teacherIDField = new JTextField();
        teacherIDField.setFont(font);
        teacherIDField.setBounds(250, 150, 200, 20);
        panel.add(teacherIDField);

        JLabel teacherDepartment = new JLabel("Teacher Department");
        teacherDepartment.setFont(font);
        teacherDepartment.setBounds(50, 200, 200, 20);
        panel.add(teacherDepartment);

        JTextField teacherDepartmentField = new JTextField();
        teacherDepartmentField.setFont(font);
        teacherDepartmentField.setBounds(250, 200, 200, 20);
        panel.add(teacherDepartmentField);

        JLabel teacherLeaveDate = new JLabel("Leave Date");
        teacherLeaveDate.setFont(font);
        teacherLeaveDate.setBounds(50, 250, 200, 20);
        panel.add(teacherLeaveDate);

        JTextField teacherLeaveDateField = new JTextField();
        teacherLeaveDateField.setFont(font);
        teacherLeaveDateField.setBounds(250, 250, 200, 20);
        panel.add(teacherLeaveDateField);

        JLabel teacherReturnDate = new JLabel("Return Date");
        teacherReturnDate.setFont(font);
        teacherReturnDate.setBounds(50, 300, 200, 20);
        panel.add(teacherReturnDate);

        JTextField teacherReturnDateField = new JTextField();
        teacherReturnDateField.setFont(font);
        teacherReturnDateField.setBounds(250, 300, 200, 20);
        panel.add(teacherReturnDateField);

        JLabel teacherReason = new JLabel("Reason");
        teacherReason.setFont(font);
        teacherReason.setBounds(50, 350, 200, 20);
        panel.add(teacherReason);

        JTextField teacherReasonField = new JTextField();
        teacherReasonField.setFont(font);
        teacherReasonField.setBounds(250, 350, 200, 20);
        panel.add(teacherReasonField);

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 25));
        submit.setForeground(Color.BLACK);
        submit.setBounds(120, 420, 120, 30);
        panel.add(submit);

        submit.addActionListener(
                (e)-> {
                    String name = teacherNameField.getText();
                    String id = teacherIDField.getText();
                    String department = teacherDepartmentField.getText();
                    String leaveDate = teacherLeaveDateField.getText();
                    String returnDate = teacherReturnDateField.getText();
                    String reason = teacherReasonField.getText();
                    if (name.isEmpty() || id.isEmpty() || department.isEmpty() || leaveDate.isEmpty() || returnDate.isEmpty() || reason.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Leave request submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                        teacherNameField.setText("");
                        teacherIDField.setText("");
                        teacherDepartmentField.setText("");
                        teacherLeaveDateField.setText("");
                        teacherReturnDateField.setText("");
                        teacherReasonField.setText("");

                        try {
                            Database db = new Database();
                            db.statement.executeUpdate("INSERT INTO `Teacher Leave` VALUES ('"+name+"','"+id+"','"+department+"','"+leaveDate+"','"+returnDate+"','"+reason+"');");
                        } catch (Exception e1) {
                            throw new Error(e1);
                        }


                    }


                });

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 25));
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(270, 420, 120, 30);
        panel.add(cancel);
        cancel.addActionListener((e)-> this.dispose());

    }

}

