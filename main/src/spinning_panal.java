import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class spinning_panal extends JPanel {
    double angle = 0;
    BufferedImage image;

    //calls the image from main
    spinning_panal(BufferedImage img){
        this.image = img;
        System.out.println("gets the image");
    }

    @Override
    protected void paintComponent(Graphics g){
        System.out.println("Starts spinning the image");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

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

        //restoring the orginal location
        g2d.setTransform(old);
    }
}
