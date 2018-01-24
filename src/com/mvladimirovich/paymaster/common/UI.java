package com.mvladimirovich.paymaster.common;

import com.mvladimirovich.paymaster.users.User;

import java.util.List;
import java.util.Scanner;

public class UI {

    private final static Scanner scanner = new Scanner(System.in);

    private static String wrapPrompt(String s) {
        return s + " /> ";
    }
    private static void printPrompt(String s) { System.out.print(wrapPrompt(s));}

    private static String wrapTitle(String s) { return "[" + s  + "]"; }
    public static void printLnTitle(String s) { System.out.println(wrapTitle(s));}

    public static void printMenuText() {
        System.out.println();
        System.out.println("::    Paymaster 9000 ::");
        System.out.println(":: 1 - Create new account");
        System.out.println(":: 2 - Calculate payment");
        System.out.println(":: 3 - List uses");
        System.out.println(":: 4 - Exit");
    }

    public static int getMainMenuOption() {
        UI.printPrompt("enter option");
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

    public static String getUserNameFromPrompt() {
        UI.printPrompt("please enter new user name");
        return scanner.nextLine();
    }

    public static Double getWorkingHoursFromPrompt() {
        UI.printPrompt("please enter amount of working hours");
        String option = scanner.nextLine();
        return Double.parseDouble(option);
    }

    public static String getUserAccDesiredTypeFromPrompt() {
        UI.printPrompt("please enter new user account type: (S)avings or (C)hecking");
        return scanner.nextLine();
    }

    public static String getSortingOptionFromPrompt() {
        UI.printPrompt("please select sorting option (n)ame or (i)d");
        return scanner.nextLine();
    }

    public static void printUsers(List<User> users) {
        printLnTitle("Users list");
        System.out.println();
        users.forEach(System.out::println);
        System.out.println();
    }
}
