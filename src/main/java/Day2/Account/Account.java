package Day2.Account;

public class Account {

    String name;
    double balance;
    static double anualRate = 0.04;

    public Account(String name,double balance){

        this.name = name;
        this.balance = balance;
    }

    public double getMonthlyRate(){

        return anualRate / 12;
    }

    public double getMonthlyIntrest(){

        return balance * getMonthlyRate();
    }

    public void deposit( int amount){

        amount += balance;
    }

    public void withdraw(int amount){

        amount -= balance;
    }

    public double getBalance(){

        return balance;
    }
}