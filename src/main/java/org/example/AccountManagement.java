package org.example;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
    public static List<Client> listClients = new ArrayList<>();
    public static List<AbstractAccount> listAccounts = new ArrayList<>();

    public static int idClient = 0;
    public static int idAccount = 0;
    public static int operation = 0;
    public static Client currentClient = null;
    public static AbstractAccount currentAccount = null;

    public static void PrintClients() {
        for (int i = 0; i < listClients.size(); i++) {
            System.out.println(listClients.get(i));
        }
    }

    public static void PrintAccounts() {
        for (int i = 0; i < listAccounts.size(); i++) {
            System.out.println(listAccounts.get(i));
        }
    }

    public static void CreateClient(String name, String password) {
        idClient += 1;
        Client client = new Client(idClient, name, password);
        listClients.add(client);
        currentClient = client;
    }

    public static void CreateDebitAccount(int balance, int rate) {
        idAccount += 1;
        AbstractAccount account = new DebitAccount(idAccount, balance, rate, currentClient);
        listAccounts.add(account);
        currentAccount = account;
    }

    public static void CreateCreditAccount(int limit, int rate) {
        idAccount += 1;
        AbstractAccount account = new CreditAccount(idAccount, limit, rate, currentClient);
        listAccounts.add(account);
        currentAccount = account;
    }

    public static void createManually() {
        Client client1 = new Client(1, "Клюев Я.А.", "password");
        Client client2 = new Client(2, "Иванов И.И.", "qwerty123");

        currentClient = client1;
        Account acc1 = new DebitAccount(1, 23500, 2, client1);
        Account acc2 = new CreditAccount(2, 100000, 21, client1);
        Account acc3 = new CreditAccount(3, 60000, 19, client1);

        Account acc4 = new DebitAccount(4, 53200, 4, client2);
        Account acc5 = new CreditAccount(5, 200000, 21, client2);


    }

}
