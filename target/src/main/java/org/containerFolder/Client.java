package org.containerFolder;

public class Client extends Account{
    private Long balance = 0L;
    private final String name;

    public Client(String name, Long balance){
        super(balance);
        this.name = name;
        this.balance = balance;
    }
    public Client(String name){
        super(0L);
        this.name = name;
    }

    public Long getBalance(){
        return this.balance;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return ("Name : "+ getName() + " with balance : "+ getBalance());
    }

}
