package paymaster.accounts;

import java.io.Serializable;
import com.lazada.assets.Log;

public abstract class Account implements IWithdrawable, IDepositable, Serializable {

	public static String ERR_CANNOTAFFORD = "you cannot afford it";

	private static int accCnts = 1;

	private int id;
	private String holderName;
	private double balance;
	
	public Account(String holder, double initBalance) {
		this.holderName = holder;
		this.balance = initBalance;
		this.id = accCnts++;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}
	
	protected void setBalance(double balance) {
		this.balance = balance;
	}

	protected void printBalance() {
		System.out.println(
				Log.wrapGood(
						String.format("%s, your balance is %.2f now\n", holderName, getBalance())
				)
		);
	}
	
	@Override
	public String toString() {
		return String.format("[ID]:%d [HOLDER]:%s [BALANCE]:\t $%.2f", id, holderName, balance);
	}
}
