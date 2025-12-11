import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Main{
    public static void main(String[] args) {
        show(new JFrame());
    }

    //ADD CODE HERE
    public static void show(JFrame parent){
        System.out.println("Creates the page");
        JFrame frame = new JFrame("Spinning GIF");
        frame.setSize(900, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //creates a image
        String imageURL = "https://cdn.pixabay.com/photo/2022/01/30/13/33/github-6980894_640.png";

        //loads the image
        BufferedImage image = null;
        try {
            URL url = new URL(imageURL);
            image = ImageIO.read(url); //reads the url
        } catch (IOException e) { //if no image can be loaded then it will have an error
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + imageURL);
        }

        //will print the image into the frame
        if (image != null) {

            spinning_panal panel = new spinning_panal(image);

            //timer to animate the spin
            Timer timer = new Timer(30, e -> {
                panel.angle += 0.05; // speed of spin
                panel.repaint();
            });
            timer.start();

            frame.add(panel);

        } else { //image could not be loaded
            JLabel errorLabel = new JLabel("Could not load image from URL.");
            frame.add(errorLabel);
        }

        //ALWAYS HAVE THIS AT THE END
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
}