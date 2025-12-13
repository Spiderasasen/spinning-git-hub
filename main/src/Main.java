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
        String imageURL = "https://images.icon-icons.com/3685/PNG/512/github_logo_icon_229278.png";
        String BackgroundImageURL = "https://img.freepik.com/free-vector/realistic-galaxy-background_23-2148991322.jpg?semt=ais_hybrid&w=740&q=80";
        String James = "https://avatars.githubusercontent.com/u/54397470?s=130&v=4";

        BufferedImage image = loadImage(imageURL);
        BufferedImage backGround = loadImage(BackgroundImageURL);
        //the devs
        BufferedImage JamesImage = loadImage(James);

        //will print the image into the frame
        if ((image != null) && (backGround != null) && (JamesImage != null)) {

            spinning_panal panel = new spinning_panal(image, backGround, JamesImage);

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

    //making the image system
    public static BufferedImage loadImage(String imageURL){
        //loads the image
        BufferedImage image = null;
        try {
            URL url = new URL(imageURL);
            image = ImageIO.read(url); //reads the url
        } catch (IOException e) { //if no image can be loaded then it will have an error
            e.printStackTrace();
            System.err.println("Error loading image from URL: " + imageURL);
        }
        return image; //returns the image now processed and ready to use
    }
}