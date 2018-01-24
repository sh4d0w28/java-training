package paymaster;
import paymaster.log.Log;
import paymaster.accounts.AccountTypeEnum;
import paymaster.users.User;
import paymaster.users.UserDbStorage;
import paymaster.users.UserStorage;

import java.util.Comparator;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    private static UserStorage saveLoader = new UserStorage();
    //private static UserDbStorage dbStorage = new UserDbStorage();

    public static void main(String[] args) {

        saveLoader.load();
        //dbStorage.loadUsers(); // NEW

        int selectedOption;
        do {
            selectedOption = menu();

            switch (selectedOption) {
                case 1:
                    createUserProcess();
                    break;
                case 2:
                    calculatePaymentProcess();
                    break;
                case 3:
                    displayUsersProcess();
                    break;
                case 0:
                    break;
            }
        } while( selectedOption != 0);

        saveLoader.Save();
    }

    private static int menu()
    {
        common.displayMenu(saveLoader.getSize());
        //common.displayMenu(dbStorage.getSize()); // NEW ONE
        Log.printPromt("enter option");
        return common.getMainMenuOption();
    }

    private static void calculatePaymentProcess() {
        System.out.println(Log.wrapTitle("Calculation payments"));
        Log.printPromt("please enter name of user");
        String username = App.scanner.nextLine();
        User foundUser = saveLoader.findUser(username);
        //User foundUser = dbStorage.findUser(username);
        if (foundUser == null) {
            return;
        }

        Log.printPromt("please enter amount of working hours");
        String option = App.scanner.nextLine();
        double workingHrsAmount = Double.parseDouble(option);
        double net = Calculator.calculateGrossNet(workingHrsAmount);

        foundUser.getAccount().deposit(net);
    }

    private static void displayUsersProcess() {
        System.out.println(Log.wrapTitle("Displaying users"));

        Log.printPromt("please select sorting option (n)ame or (i)d");
        String sortField = App.scanner.nextLine();
        if (sortField.length() == 0) {
            Log.printlnError("you provide wrong sort field");
            return;
        }
        switch (sortField.substring(0,1).toLowerCase()) {
            case "i":
                saveLoader.sort(Comparator.comparing(User::getId));
                //dbStorage.sort(Comparator.comparing(User::getId));
                break;
            case "n":
                saveLoader.sort(Comparator.comparing(User::getName));
                //dbStorage.sort(Comparator.comparing(User::getName));
                break;
        }
        saveLoader.printUsers();
        //dbStorage.printUsers();
    }

    private static void createUserProcess() {
        System.out.println(Log.wrapTitle("Creating new user"));
        Log.printPromt("please enter new user name");
        String username = App.scanner.nextLine();

        Log.printPromt("please enter new user account type: (S)avings or (C)hecking");
        String accType = App.scanner.nextLine();
        if (accType.length() == 0) {
            Log.printlnError("you provide wrong account type");
        }
        switch (accType.substring(0,1).toLowerCase()) {
            case "s":
                saveLoader.addUser(new User(username, AccountTypeEnum.SAVINGS));
                //dbStorage.addUser(new User(username, AccountTypeEnum.SAVINGS));
                break;
            case "c":
                saveLoader.addUser(new User(username, AccountTypeEnum.CHECKING));
                //dbStorage.addUser(new User(username, AccountTypeEnum.CHECKING));
                break;
            default:
                Log.printlnError("you provide wrong account type");
                break;
        }

    }
}