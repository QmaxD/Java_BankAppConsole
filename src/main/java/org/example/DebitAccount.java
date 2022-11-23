package org.example;

public class DebitAccount extends AbstractAccount {
    private double overdraft = 0;

    public DebitAccount(int id, double balance, int rate, Client owner) {
        this.id = id;
        this.balance = balance;
        this.rate = rate;
        this.owner = owner;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        if (isTransactionValid(overdraft)) {
            if (isTransactionValid(this.overdraft))
                balance -= overdraft;
            this.overdraft = overdraft;
            balance += overdraft;
        } else if (overdraft == 0) {
            if (isTransactionValid(this.overdraft))
                balance -= overdraft;
            this.overdraft = overdraft;
        }
    }
    @Override
    public boolean withdrawMoney(double money) {
        if (isTransactionValid(money) && balance >= money) {
            balance -= money;
            return true;
        }
        return false;
    };

    @Override
    public boolean transferMoney(double money, Account transferAccount) {
        if (isTransactionValid(money) && balance - money >= 0) {
            withdrawMoney(money);
            transferAccount.addMoney(money);
            return true;
        }
        return false;
    };

    @Override
    public void percentageOnBalance() {
        if (isTransactionValid(rate)) {
            addMoney(balance * rate / 100);
        }
    };

}
