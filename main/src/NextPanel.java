import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class NextPanel extends JPanel {
    private final spinning_panal orginal_panal;
    private BufferedImage james_image;
    private BufferedImage lance_image;
    private BufferedImage diego_image;

    public NextPanel(spinning_panal orginal_panal, BufferedImage james_image, BufferedImage lance_image, BufferedImage diego_image){
        this.orginal_panal = orginal_panal;

        //putting the imagaes of the devs
        this.james_image = james_image;
        this.lance_image = lance_image;
        this.diego_image = diego_image;

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

        add(title,BorderLayout.NORTH);
    }


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //drawing james
        if (james_image != null){
            g2d.drawImage(james_image, 50, 250, 150, 150, this);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 20));
            g2d.drawString("jamesMFelder", 50, (250 + 150 + 25));
        }
        if(lance_image != null){
            g2d.drawImage(lance_image, 350, 250, 150, 150, this);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 20));
            g2d.drawString("Lanse0123", 350, (250 + 150 + 25));
        }
        if(diego_image != null){
            g2d.drawImage(diego_image, 650, 250, 150, 150, this);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 20));
            g2d.drawString("Spiderasasen", 650, (250 + 150 + 25));
        }
    };
}
