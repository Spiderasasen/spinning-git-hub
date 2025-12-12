import javax.swing.*;
import java.awt.*;

public class NextPanel extends JPanel {
    public NextPanel(){
        setBackground(new Color(61, 37, 135));
        setLayout(new BorderLayout());

        JLabel title = new JLabel("The Devs", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        add(title,BorderLayout.CENTER);
    }
}
