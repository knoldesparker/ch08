import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("casper",500,0);
        BankAccount account2 = new BankAccount("freja", 200,0);


        //account1.withdraw(200);              //Withdraw #11
        //System.out.println(account1);          //ToString #12
        account1.transfer(account2,100);
    }

    public static class BankAccount{
        Scanner input = new Scanner(System.in);
        String name;
        double balance;
        double transactionFee = 0.00;

        public void deposit(double amount){
            balance = balance + Math.abs(amount);
        }

        public void transfer(BankAccount account, double amount){
            double tempbalance = this.balance;
            System.out.println("You have " + balance + " on your account" );
            System.out.println("Enter amout to transfer to " + account.name);
            amount = input.nextDouble();
            transactionFee = 5.00;

            tempbalance = tempbalance - amount - transactionFee;
            System.out.println(tempbalance + " temp balance");

            if (tempbalance <= 0){
                System.out.println("No Funds");
            } else {
                balance = tempbalance;
                account.balance = account.balance + amount;
                System.out.println("You transferd " + amount + " to " + account.name);
                System.out.println("your new balance: " + "$" + balance);
                System.out.println(account.name +" new balance: "+"$" +account.balance);
            }
        }


        //Edit for assignment 11 Remove comments for manual input
        public void withdraw(double amount){
            double tempbalance = balance;
            //System.out.println("Enter withdraw amout");
            //mount = Math.abs(input.nextDouble());
            //System.out.println("Enter fee amout");
            //transactionFee = Math.abs(input.nextDouble());

            tempbalance = tempbalance - amount - transactionFee;
            if (tempbalance < 0){
                System.out.println("No Funds");
            } else {
                balance = tempbalance;
                System.out.println("withdraw" + amount);
                System.out.println("new balance " + "$"+ balance);
            }

        }

        public BankAccount(String name, double balance, double transactionFee) {
            this.name = name;
            this.balance = balance;
            this.transactionFee = transactionFee;
        }
        @Override
        public String toString(){
            //Edits the name so that the first letter in the string gets UpperCased, and the rest of the sting gets LowerCased
            name = name.substring(0,1).toUpperCase()+ name.substring(1).toLowerCase();
            //Returns the convertet name and adds a doller sign '$' in front of ballance
            return name + ", " + "$"+balance;
        }

    }

}
