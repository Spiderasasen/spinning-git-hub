import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class spinning_panal extends JPanel {
    double angle = 0;
    BufferedImage image;
    BufferedImage background_image;

    Rectangle imageBounds; //trackable image area

    //calls the image from main
    spinning_panal(BufferedImage img, BufferedImage background_image){
        this.image = img;
        this.background_image = background_image;
        System.out.println("gets the image and background image");

        //mouse listener
        addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                if(imageBounds != null && imageBounds.contains(e.getPoint())){
                    System.out.println("Image Clicked");
                    transitionEffect();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
//        System.out.println("Starts spinning the image");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        /*Drawing the background*/
        if (background_image != null){
            g2d.drawImage(background_image, 0, 0, getWidth(), getHeight(), null);
//            System.out.println("background drawn");
        }

        /*Spinning code*/
        //getting the width and height of the image
        int w = image.getWidth();
        int h = image.getHeight();

        //Used to center the item by getting the height and the width of the panel
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        double scaleX = Math.cos(angle);

        //saving the transform
        AffineTransform old = g2d.getTransform();

        g2d.translate(cx, cy); //moves the panel with the help of cy and cx
        g2d.scale(scaleX, 1); //spins horizantol
        g2d.drawImage(image, -w / 2, -h / 2, null); //gets the high and length of the image and draws it

        //saving the clickable bounds
        imageBounds = new Rectangle(cx - w / 2, cy - h / 2, w, h);

        //transition screen section
        if (fadeAlpha > 0f){
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, fadeAlpha));
            g2d.setColor(new Color(61, 37, 135));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setComposite(AlphaComposite.SrcOver); // reset

        }

        //restoring the orginal location
        g2d.setTransform(old);
    }

    //transition effect
    private void transitionEffect(){
        Timer timer = new Timer(30, null);
        timer.addActionListener(e -> {
            fadeAlpha += 0.05f; // increase opacity
            if (fadeAlpha >= 1f) {
                ((Timer)e.getSource()).stop();
                // Swap to next panel
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.setContentPane(new NextPanel());
                topFrame.revalidate();
            }
            repaint(); // trigger paintComponent again
        });
        timer.start();

    }

    private float fadeAlpha = 0f;
}
