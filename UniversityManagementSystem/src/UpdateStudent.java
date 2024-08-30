import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame {

    JTextField  nameField,fNameField,idField,aField,eField,dField;
    JButton submit,search;
    JComboBox<String> faculty,department;

    UpdateStudent(){
        JLabel title = new JLabel("UPDATE STUDENT DETAILS");
        title.setBounds(210,30,800,30);
        title.setFont(new Font("serif",Font.BOLD,26));
        add(title);


        JLabel name = new JLabel("NAME");
        name.setBounds(92,80,40,70);
        name.setFont(new Font("serif",Font.BOLD,14));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(150,105,180,25);
        add(nameField);

        JLabel fame = new JLabel("FATHER'S NAME");
        fame.setBounds(350,80,200,70);
        fame.setFont(new Font("serif",Font.BOLD,14));
        add(fame);

        fNameField= new JTextField();
        fNameField.setBounds(480,105,180,25);
        add(fNameField);

        JLabel idNo = new JLabel("ID NO");
        idNo.setBounds(90,140,100,70);
        idNo.setFont(new Font("serif",Font.BOLD,14));
        add(idNo);

        idField = new JTextField();
        idField.setBounds(150,160,180,25);
        add(idField);

        JLabel adr = new JLabel("ADDRESS");
        adr.setBounds(390,138,200,70);
        adr.setFont(new Font("serif",Font.BOLD,14));
        add(adr);

        aField = new JTextField();
        aField.setBounds(480,160,180,25);
        add(aField);

        JLabel birth = new JLabel("DATE OF BIRTH");
        birth.setBounds(350,190,200,70);
        birth.setFont(new Font("serif",Font.BOLD,14));
        add(birth);


        dField = new JTextField();
        dField.setBounds(480,213,180,25);
        add(dField);


        JLabel qua = new JLabel("FACULTY");
        qua.setBounds(70,240,120,70);
        qua.setFont(new Font("serif",Font.BOLD,14));
        add(qua);

        String[] c = { "FBE","FSIT","FE","FAHS","FHSS","FGS"};
        faculty = new JComboBox<>(c);
        faculty.setBounds(150,263,180,25);
        faculty.setBackground(Color.WHITE);
        add(faculty);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(80,190,120,70);
        email.setFont(new Font("serif",Font.BOLD,14));
        add(email);

        eField = new JTextField();
        eField.setBounds(150,213,180,25);
        add(eField);

        JLabel dept = new JLabel("DEPARTMENT");
        dept.setBounds(363,240,200,70);
        dept.setFont(new Font("serif",Font.BOLD,14));
        add(dept);

        String[] d = { "CSE","EEE","CE","TE","SWE","GED","MCT","CIS"};
        department= new JComboBox<>(d);
        department.setBounds(480,263,180,25);
        department.setBackground(Color.WHITE);
        add(department);

        submit = new JButton("SUBMIT");
        submit.setBounds(220,390,120,20);
        submit.setBackground(new Color(20,30,60));
        submit.setForeground(Color.white);
        submit.setFont(new Font("arial",Font.BOLD,14));
        add(submit);


        submit.addActionListener(e -> {
            String name1 = nameField.getText();
            String fName = fNameField.getText();
            String id = idField.getText();
            String address = aField.getText();
            String email1 = eField.getText();
            String dob = dField.getText();
            String faculty1 = (String) faculty.getSelectedItem();
            String department1 = (String) department.getSelectedItem();

            if(name1.isEmpty() || fName.isEmpty() || id.isEmpty() || address.isEmpty() || email1.isEmpty() || dob.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Leave request submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                fNameField.setText("");
                idField.setText("");
                aField.setText("");
                eField.setText("");
                dField.setText("");

                try {
                    Database db = new Database();
                    db.statement.executeUpdate("UPDATE `add student` SET `NAME` = '"+name1+"', `ID NO` = '"+id+"', `FATHER'S NAME` = '"+fName+"', `ADDRESS` = '"+address+"', `EMAIL` = '"+email1+"', `faculty` = '"+faculty1+"', `DATE OF BIRTH` = '"+dob+"', `DEPARTMENT` = '"+department1+"' WHERE `add student`.`ID NO` = '"+id+"'");
                } catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }

        });

        search = new JButton("SEARCH");
        search.setBounds(400,390,120,20);
        search.setBackground(new Color(20,30,60));
        search.setForeground(Color.white);
        search.setFont(new Font("arial",Font.BOLD,14));
        add(search);
        search.addActionListener(e -> {
            String id = idField.getText();
            if(id.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    Database db = new Database();
                    ResultSet resultSet = db.statement.executeQuery("SELECT * FROM `add student` WHERE `ID NO`='"+id+"'");
                    if(resultSet.next()){
                        nameField.setText(resultSet.getString("NAME"));
                        fNameField.setText(resultSet.getString("FATHER'S NAME"));
                        aField.setText(resultSet.getString("ADDRESS"));
                        eField.setText(resultSet.getString("EMAIL"));
                        dField.setText(resultSet.getString("DATE OF BIRTH"));
                        faculty.setSelectedItem(resultSet.getString("FACULTY"));
                        department.setSelectedItem(resultSet.getString("DEPARTMENT"));
                    }else{
                        JOptionPane.showMessageDialog(null, "No record found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });



        setSize(720,500);
        setLocation(380,100);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(140,220,236));
        setVisible(true);


    }


}
