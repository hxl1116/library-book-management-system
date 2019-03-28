package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BufferMenu extends JPanel
{
    // Creates hash map to store all main panels <Name of Panel,Panel Object>
    private Map<String, JPanel> mapPanels = new HashMap<>();
    public static String currentPanel = "MAIN_MENU";
    public static String lastPanel = "MAIN_MENU";
    private MainMenu mainMenu;
    private LoginMenu loginMenu;
    private SignupMenu signupMenu;

    public BufferMenu()
    {
        super();
        initialize();
    }

    /**
     * Function: initialize
     *
     * Calls methods to create panel and components
     */

    public void initialize()
    {
        createComponents();
        initializePanels();
        addComponents();
        setDefaults();
        setOpaque(false);
    }

    /**
     * Function: createComponents
     *
     * initialize object
     * Add panel object in to hashmap (mapPanels)
     */

    public void createComponents()
    {
        // Main Menu
        mainMenu = new MainMenu(this);
        mapPanels.put("MAIN_MENU", mainMenu);

        loginMenu = new LoginMenu(this);
        mapPanels.put("LOGIN_MENU", loginMenu);

        signupMenu = new SignupMenu(this);
        mapPanels.put("SIGNUP_MENU", signupMenu);
    }

    /**
     * Function: initializePanels
     *
     * Initialize (create) all Panels
     */

    public void initializePanels()
    {
        this.setBorder(new LineBorder(Color.BLUE));
        //mainMenu.initialize();
    }

    /**
     * Function: addComponents
     *
     * add all main panel components to panel (Separated in categories)
     */

    public void addComponents()
    {
        // Main Menu
        add(mainMenu);
        add(loginMenu);
        add(signupMenu);
    }

    /**
     * Function: setDefaults
     *
     * Check to see if there is a password in the database (getPassExist)
     * Show login panel or main menu at start of the program
     */

    public void setDefaults()
    {
        showPanel("LOGIN_MENU");
    }

    /**
     * Function: showPanel
     * @param panelName
     * @see new panel
     *
     * Hide all panels in the hashmap using for loop
     * Create holding panel and set to new panel (Passed pram)
     * Set new panel visible
     */

    public void showPanel(String panelName)
    {
        lastPanel = currentPanel;
        currentPanel = panelName;

        for (JPanel panel : mapPanels.values()) // Run through all panels in hashmap
        {
            panel.setVisible(false); // hide all panels in bufferpanel
        }

        JPanel panelToShow = mapPanels.get(panelName); // Create holding panel (panelToShow) and set equal to panelName (Passed Pram)
        panelToShow.setVisible(true); // set new panel visible
    }
}
