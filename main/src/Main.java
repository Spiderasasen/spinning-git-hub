import javax.swing.*;

void main(String[] args) {
    show(new JFrame());
}

//ADD CODE HERE
public static void show(JFrame parent){
    System.out.println("Creates the page");
    JFrame frame = new JFrame("Spinning GIF");
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //creates a button
    JButton button = new JButton("Click");
    frame.add(button);


    //ALWAYS HAVE THIS AT THE END
    frame.setVisible(true);
    frame.revalidate();
    frame.repaint();
}