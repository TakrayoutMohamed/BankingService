package org.containerFolder;

import org.containerFolder.Exceptions.NotValidBalance;

public class Main {
    public static void main(String[] args) {
        try{
            Client client1 = new Client("Mohamed");
            client1.deposit(-1000);
            client1.deposit(2000);
            client1.withdraw(500);
            System.out.println(client1);
            client1.printStatement();
            Client client2 = new Client("Takrayout", 5000L);
            client2.withdraw(5000);
            client2.deposit(400);
            client2.deposit(1);
            client2.deposit(0);
            System.out.println(client2);
            client2.printStatement();
        } catch (NotValidBalance e) {
            System.err.println(e.getMessage());
        }
    }
}