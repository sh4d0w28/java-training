package paymaster;

import paymaster.log.Log;

import java.util.Scanner;

public class common {

    public static Scanner scanner = new Scanner(System.in);

    public static void displayMenu(int userSize) {

        System.out.println();
        System.out.println("::    Paymaster 9000 ::");
        System.out.println(":: 1 - Create new account");
        System.out.println(":: 2 - Calculate payment");
        System.out.println(":: 3 - List uses (total "+ userSize +")");
        System.out.println(":: 4 - Exit");
    }

    public static int getMainMenuOption() {
        Log.printPromt("enter option");
        String option = scanner.nextLine();
        try {
            int selectedOption = Integer.parseInt(option);
            switch (selectedOption){
                case 1:
                case 2:
                case 3:
                    return selectedOption;
                default:
                    return 0;
            }
        } catch(NumberFormatException ex) {
            Log.printlnError("input is incorrect");
            return 0;
        }
    }
}
