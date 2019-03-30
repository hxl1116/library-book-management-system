package View;

import javax.swing.*;
import java.awt.*;

public class LaunchApp {

    public static JFrame frame = new JFrame();
    static BufferMenu bufferMenu = new BufferMenu();
    public static final int Window_Width = 700;
    public static final int Window_Height = 500;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            createAndShowGUI(); // Method Call to create program.
        });
    }

    private static void createAndShowGUI(){
        frame.setSize(Window_Width,Window_Height); //sets size restraints
        frame.setMinimumSize(new Dimension(Window_Width,Window_Height));
        frame.setTitle(".:LBMS:.");
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // End program when 'x' is Clicked.


        bufferMenu.setSize(frame.getWidth(),frame.getHeight());

        frame.getContentPane().add(bufferMenu);
        //frame.getContentPane().setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);
    }


    public static void showLoginMenu() {
        System.out.println("\n1 - Login");
        System.out.println("2 - Sign Up");
        System.out.println("3 - Exit");
    }

    public static void showMainMenu() {
        System.out.println("\n1 - Library Book Search");
        System.out.println("2 - Borrow Book");
        System.out.println("3 - Find Borrowed Books");
        System.out.println("4 - Return Book");
        System.out.println("5 - Pay Fine");
    }

    public static void showAdminMenu() {
        System.out.println("\n1 - Book Store Search");
        System.out.println("2 - Book Purchase");
        System.out.println("3 - Library Statistics Report");
        System.out.println("4 - Advance Time");
    }
}
