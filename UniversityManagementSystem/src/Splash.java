import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Splash extends JFrame {
    ImageIcon i1 = new ImageIcon("Icons/cover.jpg");
    Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
    ImageIcon splashPic = new ImageIcon(i2);
    JPanel mainPanel = new JPanel();
    JLabel mainLabel = new JLabel();
    JLabel nextPage = new JLabel("Click To Go Next",JLabel.CENTER);
    Splash(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,600);
        this.setTitle("UniversityManagementSystem");
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
        windowComponents();
        this.setVisible(true);

    }

    void windowComponents(){
        mainLabel.setIcon(splashPic);
        mainPanel.add(mainLabel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(-12,0,0,0));
        mainLabel.add(nextPage);

        nextPage.setBounds(0, 512,800,50);
        nextPage.setOpaque(true);
        nextPage.setBackground(new Color(0x629EE5EF, true));
        nextPage.setForeground(new Color(0xFF000000, true));
        nextPage.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        mainLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LogIn();
                dispose();
            }}
        );
    }
}

