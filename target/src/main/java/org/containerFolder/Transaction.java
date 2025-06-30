package org.containerFolder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final Integer amount;
    private final Long balance;
    private final String date;

    public Transaction(Long balance, Integer amount) {
        this.date = dateAsString();
        this.balance = balance;
        this.amount = amount;
    }
    /* getters */
    public Integer getAmount(){
        return this.amount;
    }
    public Long getBalance(){
        return this.balance;
    }
    public String getDate(){
        return this.date;
    }

    private String dateAsString() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return (today.format(formatter));
    }
    @Override
    public String toString(){
        String spaces = " ".repeat((18 - getAmount().toString().length()) / 2);
        String tmp = "";
        if (getAmount().toString().length() % 2 != 0)
            tmp += " ";
        return getDate() + " ||"
                + " ".repeat((18 - getAmount().toString().length()) / 2)
                + getAmount()
                + " ".repeat((18 - getAmount().toString().length()) / 2)
                + tmp + "|| "
                + getBalance();
    }
}
