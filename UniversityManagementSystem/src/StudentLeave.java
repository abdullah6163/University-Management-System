import javax.swing.*;
import java.awt.*;

public class StudentLeave extends JFrame {
    Font font = new Font("Arial", Font.BOLD, 20);

    StudentLeave() {
        initComponent();
        windowContent();
        this.setVisible(true);
    }
    private void initComponent() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Student Leave");
        this.setSize(500, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    private void windowContent() {
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(null);
        panel.setBackground(new Color(0xA6CEF5));

        JLabel title = new JLabel("Student Leave");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(150, 10, 250, 30);
        panel.add(title);

        JLabel studentName = new JLabel("Student Name");
        studentName.setFont(font);
        studentName.setBounds(50, 100, 200, 20);
        panel.add(studentName);

        JTextField studentNameField = new JTextField();
        studentNameField.setFont(font);
        studentNameField.setBounds(250, 100, 200, 20);
        panel.add(studentNameField);

        JLabel studentID = new JLabel("Student ID");
        studentID.setFont(font);
        studentID.setBounds(50, 150, 200, 20);
        panel.add(studentID);

        JTextField studentIDField = new JTextField();
        studentIDField.setFont(font);
        studentIDField.setBounds(250, 150, 200, 20);
        panel.add(studentIDField);

        JLabel studentSemester = new JLabel("Student Semester");
        studentSemester.setFont(font);
        studentSemester.setBounds(50, 200, 200, 20);
        panel.add(studentSemester);

        JTextField studentSemesterField = new JTextField();
        studentSemesterField.setFont(font);
        studentSemesterField.setBounds(250, 200, 200, 20);
        panel.add(studentSemesterField);

        JLabel studentLeaveDate = new JLabel("Leave Date");
        studentLeaveDate.setFont(font);
        studentLeaveDate.setBounds(50, 250, 200, 20);
        panel.add(studentLeaveDate);

        JTextField studentLeaveDateField = new JTextField();
        studentLeaveDateField.setFont(font);
        studentLeaveDateField.setBounds(250, 250, 200, 20);
        panel.add(studentLeaveDateField);

        JLabel studentReturnDate = new JLabel("Return Date");
        studentReturnDate.setFont(font);
        studentReturnDate.setBounds(50, 300, 200, 20);
        panel.add(studentReturnDate);

        JTextField studentReturnDateField = new JTextField();
        studentReturnDateField.setFont(font);
        studentReturnDateField.setBounds(250, 300, 200, 20);
        panel.add(studentReturnDateField);

        JLabel studentReason = new JLabel("Reason");
        studentReason.setFont(font);
        studentReason.setBounds(50, 350, 200, 20);
        panel.add(studentReason);

        JTextField studentReasonField = new JTextField();
        studentReasonField.setFont(font);
        studentReasonField.setBounds(250, 350, 200, 20);
        panel.add(studentReasonField);

        JButton submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 25));
        submit.setForeground(Color.BLACK);
        submit.setBounds(100, 420, 120, 30);
        panel.add(submit);

        submit.addActionListener(
                (e)-> {
                    String name = studentNameField.getText();
                    String id = studentIDField.getText();
                    String semester = studentSemesterField.getText();
                    String leaveDate = studentLeaveDateField.getText();
                    String returnDate = studentReturnDateField.getText();
                    String reason = studentReasonField.getText();
                    if (name.isEmpty() || id.isEmpty() || semester.isEmpty() || leaveDate.isEmpty() || returnDate.isEmpty() || reason.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Leave request submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                        studentNameField.setText("");
                        studentIDField.setText("");
                        studentSemesterField.setText("");
                        studentLeaveDateField.setText("");
                        studentReturnDateField.setText("");
                        studentReasonField.setText("");
                    }
                    try {
                        Database db = new Database();
                        db.statement.executeUpdate("INSERT INTO `student leave` VALUES ('"+name+"','"+id+"','"+semester+"','"+leaveDate+"','"+returnDate+"','"+reason+"');");
                    } catch (Exception e1) {
                        throw new Error(e1);
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
