package org.containerFolder;

import org.containerFolder.Exceptions.NotValidBalance;
import java.util.ArrayList;

public class Account implements AccountService{
    private Long balance;
    private Account(){}
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    protected Account(Long balance){
        if (balance < 0)
            throw new NotValidBalance("You can not create an account with negative balance");
        this.balance = balance;
    }

    @Override
    public void deposit(int amount){
        try{
            if (amount <= 0)
                throw new NotValidBalance("The amount of money you you want to deposit not Valid \nTry a non null positive amount");
            this.balance += amount;
            transactions.add(new Transaction(balance, amount));
        }
        catch (NotValidBalance e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void withdraw(int amount) {
        try{
            if (amount <= 0)
                throw new NotValidBalance("The amount of money you want to withdraw  not Valid \nTry a non null positive amount");
            if (this.balance < amount)
                throw new NotValidBalance("the amount of money you want to withdraw does not exist in your account\nTRY : " + getBalance());
            this.balance -= amount;
            transactions.add(new Transaction(balance, amount * -1));

        }
        catch(NotValidBalance e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void printStatement() {
        System.out.print("Date       ||");
        System.out.print("      Amount      ");
        System.out.println("|| Balance");
        System.out.println("--------------------------------------------");
        for (int i = transactions.size() - 1; i >= 0; i--){
            System.out.println(transactions.get(i).toString());
        }
        System.out.println("--------------------------------------------");
    }

    private Long getBalance() {
        return balance;
    }
}
