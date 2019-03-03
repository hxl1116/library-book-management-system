package View;

public class LoginMenu extends MenuAbstract
{

    @Override
    public void displayMenu() {

            setMenu();

            switch (getCurrentmenu()) {
                case LOGIN:
                    showLoginMenu();

                    System.out.println("");

                    break;
                case SIGNUP:
                    signUpMenu();
                    break;
                default:
                    displayMenu();
                    break;
            }

    }

    public static void showLoginMenu() {
        System.err.println("\tPress 0 to exit\n");
    }

    public static void signUpMenu() {
        System.err.print("\tPress 0 to exit\n");
        System.out.print("Enter a Username: ");

    }
}