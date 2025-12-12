import javax.swing.*;
import java.awt.*;

public class NextPanel extends JPanel {
    private final spinning_panal orginal_panal;

    public NextPanel(spinning_panal orginal_panal){
        this.orginal_panal = orginal_panal;
        setBackground(new Color(61, 37, 135));
        setLayout(new BorderLayout());

        JLabel title = new JLabel("The Devs", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        //making "The Devs" a clickable button
        title.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Going back to the orginal screen");
                // trigger to go back to the orginal panal
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(NextPanel.this);
                if(topFrame != null){
                    topFrame.setContentPane(orginal_panal);
                    topFrame.revalidate();
                    orginal_panal.resetFade();
                    topFrame.setContentPane(orginal_panal);
                    topFrame.revalidate();
                    orginal_panal.transitionIn();
                }
            }
        });

        add(title,BorderLayout.CENTER);
    }
}
