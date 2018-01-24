package com.mvladimirovich.paymaster;

import com.mvladimirovich.paymaster.accounts.AccountTypeEnum;
import com.mvladimirovich.paymaster.common.Log;
import com.mvladimirovich.paymaster.common.UI;
import com.mvladimirovich.paymaster.users.IUserStorage;
import com.mvladimirovich.paymaster.users.User;
import com.mvladimirovich.paymaster.users.UserFileStorage;

import java.util.Comparator;

public class App {

    private static IUserStorage userStorage;

    public static void main(String[] args) {

        userStorage = new UserFileStorage();

        int selectedOption;
        do {
            UI.printMenuText();
            selectedOption = UI.getMainMenuOption();

            switch (selectedOption) {
                case 1:
                    userCreateProcess();
                    break;
                case 2:
                    calculatePaymentProcess();
                    break;
                case 3:
                    userDisplayProcess();
                    break;
                case 0:
                    Log.printlnGood("exiting...");
                    break;
            }
        } while( selectedOption != 0);
    }

    private static void userCreateProcess() {

        UI.printLnTitle("Creating new user");
        String username = UI.getUserNameFromPrompt();
        String accType = UI.getUserAccDesiredTypeFromPrompt();

        if (accType.length() == 0) {
            Log.printlnError("you provide wrong account type");
            return;
        }
        User toAdd = null;
        switch (accType.substring(0,1).toLowerCase()) {
            case "s":
                toAdd = new User(username, AccountTypeEnum.SAVINGS, 0);
                Log.printlnGood("creating savings user");
                break;
            case "c":
                toAdd = new User(username, AccountTypeEnum.CHECKING, 0);
                Log.printlnGood("creating checking user");
                break;
            default:
                Log.printlnError("you provide wrong account type");
                break;
        }
        if (toAdd != null && userStorage.add(toAdd)) {
            Log.printlnGood("user saved");
        } else {
            Log.printlnGood("user not saved");
        }
    }

    private static void userDisplayProcess() {
        UI.printLnTitle("Displaying users");

        String sortField = UI.getSortingOptionFromPrompt();

        if (sortField.length() == 0) {
            Log.printlnError("you provide wrong sort field");
            return;
        }
        switch (sortField.substring(0,1).toLowerCase()) {
            case "i":
                UI.printUsers(userStorage.sort(Comparator.comparing(User::getId)));
                break;
            case "n":
                UI.printUsers(userStorage.sort(Comparator.comparing(User::getName)));
                break;
            default:
                Log.printlnError("this sorting not available");
                UI.printUsers(userStorage.list());
                break;
        }
    }

    private static void calculatePaymentProcess() {
        UI.printLnTitle("Calculation payments");
        String username = UI.getUserNameFromPrompt();
        User foundUser = userStorage.get(username);
        if (foundUser == null) {
            return;
        }
        double workingHrsAmount = UI.getWorkingHoursFromPrompt();
        double net = Calculator.calculateGrossNet(workingHrsAmount);
        foundUser.doDeposit(net);
        if(userStorage.update(foundUser)) {
            Log.printlnGood("update success");
        } else {
            Log.printlnGood("update failed");
        }
    }
}
