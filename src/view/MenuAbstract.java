package view;

import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class MenuAbstract {
    private static MenuOptions currentmenu = MenuOptions.MAIN_LOGIN;

    enum MenuOptions {
        MAIN_LOGIN, MAIN, ADMIN, // Menu option for the main menu
        LOGIN, SIGNUP            // Menu options for the login menu.
    }

    abstract void displayMenu();

    public static void setMenu()
    {
        clearMenu();
        displayHeadderMessage();
    }

    public static MenuOptions getCurrentmenu() {
        return currentmenu;
    }

    public static void setCurrentMenu(MenuOptions menuOption) {
        currentmenu = menuOption;
    }

    public static int getSelection(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n" + prompt + ": ");
        return scan.nextInt();
    }

    public static void displayHeadderMessage() {
        System.out.print(".: Library Book Management System :.");
    }

    public static void clearMenu() {
        for (int i = 0; i < 100; i++)
            System.out.println("\n");
    }
}
