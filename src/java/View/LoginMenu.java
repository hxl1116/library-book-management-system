package view;

import javax.swing.*;
import java.awt.*;

public class LoginMenu extends JPanel
{
    private BufferMenu bufferMenu;
    private JTextField usernameField;
    private JButton signinButton;
    private JButton signupButton;


    public LoginMenu(BufferMenu bufferMenu)
    {
        super();
        this.bufferMenu = bufferMenu;

        initialize();
        layoutComponents();
        addListeners();
    }

    public void initialize()
    {
        setLayout(new BoxLayout(this,1));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200,20));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        signinButton = new JButton("Sign In");
        signinButton.setPreferredSize(new Dimension(100,20));
        signinButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        signupButton = new JButton("Sign Up");
        signupButton.setPreferredSize(new Dimension(200,20));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void layoutComponents()
    {
        add(Box.createRigidArea(new Dimension(0,50)));
        add(usernameField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(signinButton);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(signupButton);

    }

    public void addListeners()
    {
        // add action listener to button
        signinButton.addActionListener(arg0 -> bufferMenu.showPanel("MAIN_MENU"));

        signupButton.addActionListener(e -> bufferMenu.showPanel("SIGNUP_MENU"));
    }
}

