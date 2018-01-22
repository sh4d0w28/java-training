package paymaster.users;

import paymaster.accounts.Account;
import paymaster.accounts.AccountTypeEnum;
import paymaster.accounts.CheckingAccount;
import paymaster.accounts.SavingsAccount;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {

    private static int userCnts = 1;

    private int id;
    private String name;

    private AccountTypeEnum accountType;

    private Account account;

    public User(String name, AccountTypeEnum accountType) {
        this.name = name;
        this.accountType = accountType;

        switch (accountType) {
            case CHECKING:
                this.account = new CheckingAccount(name, 0);
                this.id = User.userCnts++;
                break;
            case SAVINGS:
                this.account = new SavingsAccount(name, 0);
                this.id = User.userCnts++;
                break;
            default:
                break;
        }
    }

    public User(String name, AccountTypeEnum accountType, double initBalance) {
        this.name = name;
        this.accountType = accountType;

        switch (accountType) {
            case CHECKING:
                this.account = new CheckingAccount(name, initBalance);
                this.id = User.userCnts++;
                break;
            case SAVINGS:
                this.account = new SavingsAccount(name, initBalance);
                this.id = User.userCnts++;
                break;
            default:
                break;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public int compareTo(User user) {
        return this.name.compareTo(user.name);
    }
}
