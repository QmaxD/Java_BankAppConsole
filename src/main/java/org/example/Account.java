package org.example;

public interface Account {
    boolean addMoney(double money);
    boolean withdrawMoney(double money);
    boolean transferMoney(double money, Account transferAccount);
    double getBalance();
    String getType();
    int getRate();
    Client getOwner();
    void percentageOnBalance();

}
