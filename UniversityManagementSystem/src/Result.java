import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {

    JTextField roll,nameField,course,cou,cour,cours,co,c;

    JComboBox<?> department,semester;

    JButton viewResult;

    Result(){

        ImageIcon fee = new ImageIcon("Icons/result.png");
        Image fee1 = fee.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon fee2 = new ImageIcon(fee1);
        JLabel img = new JLabel(fee2);
        img.setBounds(450,40,300,200);
        add(img);

        JLabel title= new JLabel("ENTER MARKS");
        title.setBounds(200,10,350,70);
        title.setFont(new Font("arial",Font.BOLD,40));
        add(title);

        JLabel id= new JLabel("ROLL NUMBER");
        id.setBounds(20,80,120,70);
        id.setFont(new Font("arial",Font.BOLD,16));
        add(id);

        roll= new JTextField();
        roll.setBounds(170,100,200,30);
        add(roll);

        JLabel name= new JLabel("NAME");
        name.setBounds(20,120,120,70);
        name.setFont(new Font("arial",Font.BOLD,16));
        add(name);

        nameField= new JTextField();
        nameField.setBounds(170,140,200,30);
        add(nameField);

        JLabel dept= new JLabel("DEPARTMENT");
        dept.setBounds(20,160,160,70);
        dept.setFont(new Font("arial",Font.BOLD,16));
        add(dept);

        String[] d = { "CSE","EEE","CE","TE","SWE","GED","MCT","CIS"};
        department = new JComboBox<>(d);
        department.setBounds(170,180,200,30);
        add(department);

        JLabel sem= new JLabel("SEMESTER");
        sem.setBounds(20,200,160,70);
        sem.setFont(new Font("arial",Font.BOLD,16));
        add(sem);

        String[] s = { "1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        semester = new JComboBox<>(s);
        semester.setBounds(170,220,200,30);
        add(semester);

        JLabel course1= new JLabel("COURSE 1");
        course1.setBounds(20,260,120,70);
        course1.setFont(new Font("arial",Font.BOLD,16));
        add(course1);

        course= new JTextField();
        course.setBounds(150,280,200,30);
        add(course);

        JLabel course2= new JLabel("COURSE 2");
        course2.setBounds(20,300,120,70);
        course2.setFont(new Font("arial",Font.BOLD,16));
        add(course2);

        cou= new JTextField();
        cou.setBounds(150,320,200,30);
        add(cou);

        JLabel course3= new JLabel("COURSE 3");
        course3.setBounds(20,340,120,70);
        course3.setFont(new Font("arial",Font.BOLD,16));
        add(course3);

        cour= new JTextField();
        cour.setBounds(150,360,200,30);
        add(cour);

        JLabel course4= new JLabel("COURSE 4");
        course4.setBounds(400,260,120,70);
        course4.setFont(new Font("arial",Font.BOLD,16));
        add(course4);

        cours= new JTextField();
        cours.setBounds(520,280,200,30);
        add(cours);

        JLabel course5= new JLabel("COURSE 5");
        course5.setBounds(400,300,120,70);
        course5.setFont(new Font("arial",Font.BOLD,16));
        add(course5);

        co= new JTextField();
        co.setBounds(520,320,200,30);
        add(co);

        JLabel course6= new JLabel("COURSE 6");
        course6.setBounds(400,340,120,70);
        course6.setFont(new Font("arial",Font.BOLD,16));
        add(course6);

        c= new JTextField();
        c.setBounds(520,360,200,30);
        add(c);



        viewResult = new JButton("SUBMIT");
        viewResult.setBounds(300,420,200,30);
        viewResult.setBackground(new Color(10,50,150));
        viewResult.setForeground(Color.white);
        viewResult.setFont(new Font("arial",Font.BOLD,14));
        add(viewResult);
        viewResult.addActionListener(e -> {
            String rollNumber = roll.getText();
            String name1 = nameField.getText();
            String semester = (String) this.semester.getSelectedItem();
            String course_1 = course.getText();
            String course_2 = cou.getText();
            String course_3 = cour.getText();
            String course_4 = cours.getText();
            String course_5 = co.getText();
            String course_6 = c.getText();

            if (rollNumber.isEmpty() || name1.isEmpty() || course_1.isEmpty() || course_2.isEmpty() || course_3.isEmpty() || course_4.isEmpty() || course_5.isEmpty() || course_6.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill up all the fields");
            } else {
                try {
                    Database db  = new Database();
                    String query = "INSERT INTO result VALUES('" + rollNumber + "','" + name1 + "','" + semester + "','" + course_1 + "','" + course_2 + "','" + course_3 + "','" + course_4 + "','" + course_5 + "','" + course_6 + "')";
                    db.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Result Submitted Successfully");
                    setVisible(false);
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }

        });


        setResizable(false);
        setSize(750,500);
        setLocation(350,100);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(Color.LIGHT_GRAY);
    }

}
