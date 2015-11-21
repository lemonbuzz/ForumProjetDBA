import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexandre on 2015-11-20.
 */
public class ForumView extends JFrame {
    private JPanel mainPanel;

    public ForumView() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        this.setVisible(true);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);

        this.setContentPane(mainPanel);




    }
}
