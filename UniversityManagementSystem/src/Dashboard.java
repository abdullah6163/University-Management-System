import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Dashboard extends JFrame {

    Dashboard(){
        JLabel dashboard = new JLabel();
        add(dashboard);
        this.setSize(1000,600);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ImageIcon i1 = new ImageIcon("Icons/dashboard.jpg");
                Image i2 = i1.getImage().getScaledInstance(getWidth(),getHeight(), Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);

                dashboard.setIcon(i3);
            }});

        ImageIcon i1 = new ImageIcon("C:\\Users\\Shaki\\OneDrive\\Desktop\\JavaProject\\UniversityManagementSystem\\Icons\\dashboard.jpg");
        Image i2 = i1.getImage().getScaledInstance(1000,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        dashboard.setIcon(i3);

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.CYAN);


        JMenu info = new JMenu(" ADD INFORMATION ");
        info.setForeground(Color.BLACK);
        menu.add(info);

        JMenuItem faculty = new JMenuItem(" ADD FACULTY ");
        faculty.setBackground(Color.WHITE);
        info.add(faculty);
        faculty.addActionListener(e -> new AddFaculty());

        JMenuItem student = new JMenuItem(" ADD STUDENT ");
        student.setBackground(Color.WHITE);
        info.add(student);
        student.addActionListener(e -> new AddStudent());


        JMenu viewInfo = new JMenu(" VIEW INFORMATION ");
        viewInfo.setForeground(Color.BLACK);
        menu.add(viewInfo);

        JMenuItem viewFaculty = new JMenuItem(" FACULTY INFORMATION ");
        viewFaculty.setBackground(Color.WHITE);
        viewInfo.add(viewFaculty);
        viewFaculty.addActionListener(e -> new FacultyInformation());

        JMenuItem viewStudent = new JMenuItem(" STUDENT INFORMATION ");
        viewStudent.setBackground(Color.WHITE);
        viewInfo.add(viewStudent);
        viewStudent.addActionListener(e -> new StudentInformation());


        JMenu leave = new JMenu(" APPLY LEAVE ");
        leave.setForeground(Color.BLACK);
        menu.add(leave);

        JMenuItem facultyLeave = new JMenuItem(" FACULTY LEAVE ");
        facultyLeave.setBackground(Color.WHITE);
        leave.add(facultyLeave);
        facultyLeave.addActionListener(e -> new TeacherLeave());

        JMenuItem studentLeave = new JMenuItem(" STUDENT LEAVE ");
        studentLeave.setBackground(Color.WHITE);
        leave.add(studentLeave);
        studentLeave.addActionListener(e -> new StudentLeave());


        JMenu viewLeave = new JMenu(" LEAVE DETAILS ");
        viewLeave.setForeground(Color.BLACK);
        menu.add(viewLeave);


        JMenuItem fLeave = new JMenuItem(" FACULTY LEAVE DETAILS ");
        fLeave.setBackground(Color.WHITE);
        viewLeave.add(fLeave);
        fLeave.addActionListener(e -> new TeacherLeaveDetails());

        JMenuItem sLeave = new JMenuItem(" STUDENT LEAVE DETAILS ");
        sLeave.setBackground(Color.WHITE);
        viewLeave.add(sLeave);
        sLeave.addActionListener(e -> new StudentLeaveDetails());


        JMenu exam = new JMenu(" RESULT ");
        exam.setForeground(Color.BLACK);
        menu.add(exam);

        JMenuItem mark = new JMenuItem(" ENTER MARKS ");
        mark.setBackground(Color.WHITE);
        exam.add(mark);
        mark.addActionListener(e -> new Result());

        JMenuItem result = new JMenuItem(" VIEW RESULT ");
        result.setBackground(Color.WHITE);
        exam.add(result);
        result.addActionListener(e -> new ViewResult());

        JMenu fee = new JMenu(" PAYMENT & FEES ");
        fee.setForeground(Color.BLACK);
        menu.add(fee);

        JMenuItem money = new JMenuItem(" FEE STRUCTURE ");
        money.setBackground(Color.WHITE);
        fee.add(money);
        money.addActionListener(e -> new FeeStructure());

        JMenuItem addFee = new JMenuItem(" STUDENT PAYMENT ");
        addFee.setBackground(Color.WHITE);
        fee.add(addFee);
        addFee.addActionListener(e -> new Payment());

        JMenu update = new JMenu(" UPDATE INFORMATION ");
        update.setForeground(Color.BLACK);
        menu.add(update);

        JMenuItem fUpdate = new JMenuItem(" UPDATE FACULTY INFORMATION ");
        fUpdate.setBackground(Color.WHITE);
        update.add(fUpdate);
        fUpdate.addActionListener(e -> new UpdateFaculty());

        JMenuItem sUpdate = new JMenuItem(" UPDATE STUDENT INFORMATION ");
        sUpdate.setBackground(Color.WHITE);
        update.add(sUpdate);
        sUpdate.addActionListener(e -> new UpdateStudent());


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setJMenuBar(menu);
        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
