package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private BufferMenu bufferMenu; // Bufferpanel object

    public MainMenu(BufferMenu bufferMenu) {
        super();
        this.bufferMenu = bufferMenu; // inharet object.

        initialize();
        layoutComponents();
        addListeners();
    }


    public void initialize() {
        setOpaque(false); // set panel see through
        setLayout(new BoxLayout(this, 1));
    }

    public void layoutComponents() {
        add(Box.createRigidArea(new Dimension(0, 50)));
    }

    public void addListeners() {

    }
}
