package View;

import javax.swing.*;
import java.awt.*;

public class SignUpMenu extends JPanel {
    private BufferMenu bufferMenu;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNumberField;
    private JTextField addressField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton cancelButton;
    private JButton signupButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel passwordNameLabel = new JLabel("Password");
    private JLabel phoneNumberLabel = new JLabel("Phone Number");
    private JLabel addressLabel = new JLabel("Address");
    private JLabel usernameLabel = new JLabel("Username");


    public SignUpMenu(BufferMenu bufferMenu)
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

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(200,20));
        firstNameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(200,20));
        lastNameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        phoneNumberField = new JTextField();
        phoneNumberField.setPreferredSize(new Dimension(200,20));
        phoneNumberField.setAlignmentX(Component.CENTER_ALIGNMENT);

        phoneNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200,20));
        addressField.setAlignmentX(Component.CENTER_ALIGNMENT);

        addressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200,20));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,20));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100,20));
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        signupButton = new JButton("Sign Up");
        signupButton.setPreferredSize(new Dimension(200,20));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void layoutComponents()
    {

        add(Box.createRigidArea(new Dimension(0,30)));
        add(firstNameLabel);
        add(firstNameField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(lastNameLabel);
        add(lastNameField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(addressLabel);
        add(addressField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(usernameLabel);
        add(usernameField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(passwordNameLabel);
        add(passwordField);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(signupButton);
        add(Box.createRigidArea(new Dimension(0,25)));
        add(cancelButton);

    }

    public void addListeners()
    {
        cancelButton.addActionListener(arg0 -> bufferMenu.showPanel("LOGIN_MENU"));
//
//        signupButton.addActionListener(e -> System.out.println("signipButton"));
    }

}
