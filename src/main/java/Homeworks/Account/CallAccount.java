package Homeworks.Account;

public class CallAccount {

    public static void main(String[] args) {
//        Account a1 = new Account("Abdullah", 5132);
//        Account a2 = new Account("Abdulrhman", 415.512);

        SavingAccount s1 = new SavingAccount("Ali",  1000, 100);
        CheckingAccount c1 = new CheckingAccount("Ahmed", 48512);

//        a1.getMonthlyRate();
        s1.withdraw(127);
        c1.withdraw(200);

        printDetails(s1);
        System.out.println("______________________");
        printDetails(c1);
    }

    public static void printDetails(Account a){
        System.out.println(a.name);
        System.out.println(a.getBalance());
        if (a instanceof SavingAccount){
            System.out.println(((SavingAccount) a).getLimit());
        }
    }
}