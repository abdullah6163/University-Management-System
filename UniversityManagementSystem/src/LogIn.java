import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class LogIn extends JFrame {


    JPanel mainPanel = new JPanel();
    ImageIcon i1 = new ImageIcon("Icons/cover.jpg");
    Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
    ImageIcon cover = new ImageIcon(i2);
    JLabel mainLabel = new JLabel();
    JLabel logInLabel = new JLabel();
    JLabel nameLabel = new JLabel("Name: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JTextArea nameText = new JTextArea();
    JPasswordField passwordField = new JPasswordField();
    JButton logInButton = new JButton("Log In");
    Font font = new Font(Font.SANS_SERIF,Font.BOLD,20);
    Font font1 = new Font(Font.SANS_SERIF,Font.BOLD,25);
    LogIn(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
        windowComponents();
        this.setVisible(true);
    }

    private void windowComponents() {
        mainPanel.setBorder(BorderFactory.createEmptyBorder(-12,0,0,0));
        mainPanel.add(mainLabel);
        mainLabel.setIcon(cover);
        mainLabel.add(logInLabel);
        logInLabel.setOpaque(true);
        logInLabel.setBounds(150,200,500,200);
        logInLabel.setBackground(new Color(0xB083ECC6, true));

        logInLabel.add(nameLabel);
        nameLabel.setBounds(20,10,120,50);
        nameLabel.setOpaque(true);
        nameLabel.setFont(font);

        logInLabel.add(passwordLabel);
        passwordLabel.setBounds(20,70,120,50);
        passwordLabel.setOpaque(true);
        passwordLabel.setFont(font);

        logInLabel.add(nameText);
        nameText.setBounds(180,10,290,50);
        nameText.setFont(font1);

        logInLabel.add(passwordField);
        passwordField.setBounds(180,70,290,50);
        passwordField.setFont(font1);

        logInLabel.add(logInButton);
        logInButton.setBounds(200,130,100,40);
        logInButton.setBackground(new Color(0xFFC3E7DE, true));
        logInButton.setFont(font);

        logInButton.addActionListener(
                (e) -> {
                    String name = nameText.getText();
                    String password = passwordField.getText();
                    String query = "select * from admin where name = '"+name+"' and password = '"+password+"'";
                    try {
                        Database database = new Database();
                        ResultSet resultSet = database.statement.executeQuery(query);
                        if (resultSet.next()){
                            System.out.println("Logged In");
                            new Dashboard();
                            dispose();
                        }
                        else{
                            System.out.println("Invalid Username or Password");
                                if (nameText.getText().isEmpty() || passwordField.getText().isEmpty())
                                    JOptionPane.showMessageDialog(null, "Please Enter Name and Password", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                                else{
                                    JOptionPane.showMessageDialog(null, "Invalid Name or Password", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                                    nameText.setText("");
                                    passwordField.setText("");
                                }
                        }
                    }catch(Exception e1){
                        System.out.println(e1+ "Not Found");
                    }
                }

        );

    }

}
