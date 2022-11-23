package org.example;

public abstract class AbstractAccount implements Account {
    protected int id;
    protected String type;
    protected double balance;
    protected int rate;
    protected Client owner;

    public boolean isTransactionValid(double money) {
        if (money > 0)
            return true;
        return false;
    };
    public boolean isTransactionValid(int money) {
        if (money > 0)
            return true;
        return false;
    };
    public boolean addMoney(double money) {
        if (isTransactionValid(money)) {
            balance += money;
            return true;
        }
        return false;
    };
    public abstract boolean withdrawMoney(double money);
    public abstract boolean transferMoney(double money, Account transferAccount);

    public int getId() {
        return id;
    }
    public String getType() { return type; }
    public double getBalance() {
        return balance;
    }
    public int getRate() {
        return rate;
    }
    public Client getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "AbstractAccount { id=" + id + ", balance=" + balance + ", rate=" + rate + ", owner=" + owner + " }";
    }

}
