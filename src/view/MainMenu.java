package view;

public class MainMenu extends MenuAbstract {
    private static MainMenu mainMenu = new MainMenu();
    private static LoginMenu loginMenu = new LoginMenu();

    public static void main(String[] args) {
        mainMenu = new MainMenu();
        loginMenu = new LoginMenu();
        mainMenu.displayMenu();
    }

    @Override
    public void displayMenu() {
        int menuSelection = -60;

        while (menuSelection != 3)
        {
            setMenu();
            switch (getCurrentmenu()) {
                case MAIN_LOGIN:
                    showLoginMenu();
                    switch (getSelection("Enter Menu Selection")){
                        case 1:
                            setCurrentMenu(MenuAbstract.MenuOptions.LOGIN);
                            loginMenu.displayMenu();
                            break;
                        case 3:
                            menuSelection = 3;
                            break;
                        default:
                            break;
                    }
                    break;
                case MAIN:
                    showMainMenu();
                    break;
                case ADMIN:
                    showAdminMenu();
                    break;
                default:
                    break;
            }
        }
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
