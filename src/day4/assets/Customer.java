package day4.assets;

import java.io.Serializable;

//class Wallet {  /// WRONG!!!!! SHOULD BE SERIALIZABLE IF YOU WANT TO DO ANYTHING WITH IT
class Wallet implements Serializable { // CORRECT!!!!!
    public double amount = 0;
}

public class Customer implements Serializable {  // without serializable, NEW will become object,
                                                 // but with it, it will add some interfaces for Serialization
    public String name;
    public transient Wallet custWallet;   // transient - WILL NEVER SERIALIZED

    public Customer(String name) {
        this.name = name;
        this.custWallet = new Wallet();
    }

    public double getAmount() {
        return this.custWallet.amount;
    }
}
