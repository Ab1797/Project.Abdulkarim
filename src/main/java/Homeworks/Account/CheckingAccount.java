package Homeworks.Account;

public class CheckingAccount extends Account {
    public CheckingAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(int amount){
        if ( balance - amount >= 0){
            balance -= amount;
        }

    }
}
