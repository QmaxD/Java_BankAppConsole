package org.example;

public class CreditAccount extends AbstractAccount {
    private double limit = 0;

    public CreditAccount(int id, String type, double limit, int rate, Client owner) {
        this.id = id;
        this.type = type;
        this.balance = limit;
        this.limit = limit;
        this.rate = rate;
        this.owner = owner;
        owner.listClientAccounts.add(this);
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        if (isTransactionValid(limit)){
            double tempLimit = limit - this.limit;
            this.limit = limit;
            balance += tempLimit;
        } else if (limit == 0) {
            this.balance = this.limit - this.balance;
            this.limit = limit;
            balance *= -1;
        }
    }
    @Override
    public boolean withdrawMoney(double money) {
        if (isTransactionValid(money) && balance >= money && limit >= money) {
            balance -= money;
            return true;
        }
        return false;
    };

    @Override// вообще-то с кредитного счета можно только оплачивать (хотя есть исключения по банкам)
    public boolean transferMoney(double money, Account transferAccount) {
        /*if (isTransactionValid(money) && balance - money >= 0 && limit >= money) {
            withdrawMoney(money);
            transferAccount.addMoney(money);
            return true;
        }*/
        return false;
    };

    @Override
    public void percentageOnBalance() {
        if (isTransactionValid(rate)) {
            withdrawMoney(balance * rate / 100);
        }
    };

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " { id=" + id + ", balance=" + balance + ", rate=" + rate + ", owner=" + owner + " }";
    }

}
