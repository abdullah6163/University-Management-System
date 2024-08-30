import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FeeStructure extends JFrame {
    JPanel panel;
    JLabel title;
    JTable table;

    FeeStructure() {
        initComponent();
        windowComponent();
        setVisible(true);
    }



    private void initComponent() {
        setTitle("Fee Structure");
        setSize(1000, 700);
        panel = (JPanel) getContentPane();
        panel.setLayout(null);
        panel.setBackground(new Color(0x70B5F3));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void windowComponent() {
        title = new JLabel("Fee Structure");
        panel.add(title);
        title.setOpaque(true);
        title.setFont(new Font("Roboto", Font.BOLD, 50));
        title.setBackground(new Color(0x1E90FF));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(JLabel.CENTER);

        table = new JTable();
        table.setBackground(new Color(0x95C5F1));
        table.setModel(new Table("payment").model);

        JScrollPane scrollPane = new JScrollPane(table);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                title.setSize(getWidth(), 100);
                add(scrollPane);
                scrollPane.setBounds(0,100,getWidth(),getHeight()-200);
            }
        });


    }

}
