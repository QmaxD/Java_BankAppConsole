package org.example;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

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

    public static void createInCycle() {
        int operation = 0;
        boolean isWork = true;

        Scanner inputOperation = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        while (isWork) {
            writeParagraph('=');
            System.out.println("Напишите: -1, если хотите выйти из программы.");
            switch (operation) {
                case 0:
                case 1:
                case 2:
                    System.out.println ("Напишите: 1, если хотите посмотреть всех клиентов.\n" +
                            "Напишите: 2, если хотите посмотреть все аккаунты и их владельцев.\n" +
                            "Напишите: 3, если хотите создать клиента.\n" +
                            "Напишите: 4, если хотите создать дебитовый счет.\n" +
                            "Напишите: 5, если хотите создать кредитный счет.");
                    break;
                case 3:
                    System.out.println ("Выбранный клиент: " + AccountManagement.currentClient.toString() + "\n" +
                            "Напишите: 3, если хотите создать еще одного нового клиента.\n" +
                            "Напишите: 4, если хотите создать дебитовый счет для клиента.\n" +
                            "Напишите: 5, если хотите создать кредитный счет для клиента.\n");
                    break;
                case 4:
                case 5:
                    System.out.println ("Выбранный клиент: " + AccountManagement.currentClient.toString() + "\n" +
                            "Напишите: 4, если хотите создать еще один дебитовый счет для клиента.\n" +
                            "Напишите: 5, если хотите создать еще один кредитный счет для клиента.");
                    break;
            }
            if (operation > 2)
                System.out.println ("Напишите: 6, если хотите в начало.");
            writeParagraph('-');
            System.out.print("Выберите номер операции: ");
            operation = inputOperation.nextInt();

            switch (operation) {
                case -1:
                    isWork = false;
                    break;
                case 1:
                    AccountManagement.PrintClients();
                    break;
                case 2:
                    AccountManagement.PrintAccounts();
                    break;
                case 3:
                    System.out.print("Input name: ");
                    String name = input.nextLine();
                    System.out.print("Input password: ");
                    String password = input.nextLine();
                    System.out.printf("Вы ввели Name: %s  Password: %s" + "\n", name, password);
                    //input.close();
                    AccountManagement.CreateClient(name, password);
                    System.out.println("Клиент создан: " + AccountManagement.currentClient.toString());
                    break;
                case 4:
                    System.out.print("Input balance: ");
                    int balance = input.nextInt();
                    System.out.print("Input rate: ");
                    int rate = input.nextInt();
                    System.out.printf("Вы ввели Balance: %s  Rate: %s" + "\n", balance, rate);
                    //input.close();
                    AccountManagement.CreateDebitAccount(balance, rate);
                    System.out.println("Дебитовый счет создан: " + AccountManagement.currentAccount.toString());
                    break;
                case 5:
                    System.out.print("Input limit: ");
                    int limit = input.nextInt();
                    System.out.print("Input rate: ");
                    rate = input.nextInt();
                    System.out.printf("Вы ввели Balance: %s  Rate: %s" + "\n", limit, rate);
                    //input.close();
                    AccountManagement.CreateCreditAccount(limit, rate);
                    System.out.println("Кредитный счет создан: " + AccountManagement.currentAccount.toString());
                    break;
                case 6:
                    operation = 0;
                    break;
            }

        }
        System.out.println("До свидания!");

    }

    public static void writeParagraph(char c) {
        System.out.println();
        for (int i = 0; i < 75; i++)
            System.out.print(c);
        System.out.println();
    }

}
