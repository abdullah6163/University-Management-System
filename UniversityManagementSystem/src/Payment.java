import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;

public class Payment extends JFrame {

    JTextField roll,nameField,fField;

    JComboBox<?> department, semester;

    JButton pay,back;

    Payment(){
        ImageIcon fee = new ImageIcon("Icons/fee.png");
        Image fee1 = fee.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon fee2 = new ImageIcon(fee1);
        JLabel img = new JLabel(fee2);
        img.setBounds(400,120,300,200);
        add(img);

        JLabel title= new JLabel("STUDENT PAYMENT");
        title.setBounds(200,30,350,70);
        title.setFont(new Font("arial",Font.BOLD,30));
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

        JLabel fname= new JLabel("FATHERS NAME");
        fname.setBounds(20,160,160,70);
        fname.setFont(new Font("arial",Font.BOLD,16));
        add(fname);

        fField= new JTextField();
        fField.setBounds(170,180,200,30);
        add(fField);

        JLabel dept= new JLabel("DEPARTMENT");
        dept.setBounds(20,200,160,70);
        dept.setFont(new Font("arial",Font.BOLD,16));
        add(dept);

        String[] d = { "CSE","EEE","CE","TE","SWE","GED","MCT","CIS"};
        department = new JComboBox<>(d);
        department.setBounds(170,220,200,30);
        add(department);

        JLabel sem= new JLabel("SEMESTER");
        sem.setBounds(20,240,160,70);
        sem.setFont(new Font("arial",Font.BOLD,16));
        add(sem);

        String[] s = { "1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        semester = new JComboBox<>(s);
        semester.setBounds(170,260,200,30);
        add(semester);

        pay = new JButton("PAY");
        pay.setBounds(260,390,100,30);
        pay.setBackground(new Color(10,50,150));
        pay.setForeground(Color.white);
        pay.setFont(new Font("arial",Font.BOLD,14));
        add(pay);
        pay.addActionListener(e -> {
            if(roll.getText().isEmpty() || nameField.getText().isEmpty() || fField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill up all the fields");
            }
            else{
                try {
                    Database db = new Database();
                    if(Objects.equals(semester.getSelectedItem(), "1st Semester")){
                        db.statement.executeUpdate("INSERT INTO `payment` (`ID NO`, `Name`, `1st Semester`, `2nd Semester`, `3rd Semester`, `4th Semester`, `5th Semester`, `6th Semester`, `7th Semester`, `8th Semester`) VALUES ('"+roll.getText()+"', '"+nameField.getText()+"', '150000', '0', '0', '0', '0', '0', '0', '0')");
                    } else{
                        db.statement.executeUpdate("UPDATE payment SET `"+semester.getSelectedItem()+"` = '100000' WHERE `ID NO` = " + roll.getText() + ";");
                    }
                    JOptionPane.showMessageDialog(null,"Payment Successful");
                    roll.setText("");
                    nameField.setText("");
                    fField.setText("");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        back = new JButton("BACK");
        back.setBounds(440,390,100,30);
        back.setBackground(new Color(10,50,150));
        back.setForeground(Color.white);
        back.setFont(new Font("arial",Font.BOLD,14));
        add(back);
        back.addActionListener(e -> dispose());

        setSize(750,500);
        setLocation(350,100);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        getContentPane().setBackground(Color.LIGHT_GRAY);

    }

}