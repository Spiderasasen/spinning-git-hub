import javax.swing.*;

void main(String[] args) {
    System.out.println("Creates the page");
    JFrame frame = new JFrame("Spinning GIF");
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //creates a button
    JButton button = new JButton("Click");
    frame.add(button);

    frame.setVisible(true);
}