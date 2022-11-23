package org.example;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class AccountManagement {
    public static List<Client> listClients = new ArrayList<>();
    public static int idClient = 0;
    public static Client currentClient = null;
    public static List<Account> listAccounts = new ArrayList<>();
    public static int idAccount = 0;
    public static Account currentAccount = null;

    public static void PrintClients() {
        for (int i = 0; i < listClients.size(); i++) {
            System.out.println("ID = " + i + " " + listClients.get(i));
        }
    }

    public static void PrintAccounts() {
        for (int i = 0; i < listAccounts.size(); i++) {
            System.out.println("ID = " + i + " " + listAccounts.get(i));
        }
    }

    public static void PrintAccounts(Client owner) {
        for (int i = 0; i < listAccounts.size(); i++) {
            if (listAccounts.get(i).getOwner() == owner)
                System.out.println("ID = " + i + " " + listAccounts.get(i));
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
        Account account = new DebitAccount(idAccount, Type.Дебитовый.name(), balance, rate, currentClient);
        listAccounts.add(account);
        currentAccount = account;
    }

    public static void CreateCreditAccount(int limit, int rate) {
        idAccount += 1;
        Account account = new CreditAccount(idAccount, Type.Кредитный.name(), limit, rate, currentClient);
        listAccounts.add(account);
        currentAccount = account;
    }

    public static void createManually() {
        idClient++;
        Client client1 = new Client(idClient, "Клюев Я.А.", "password");
        idClient++;
        Client client2 = new Client(idClient, "Иванов И.И.", "qwerty123");
        idAccount++;
        Account acc1 = new DebitAccount(idAccount, Type.Дебитовый.name(), 23500, 2, client1);
        idAccount++;
        Account acc2 = new CreditAccount(idAccount, Type.Кредитный.name(), 100000, 21, client1);
        idAccount++;
        Account acc3 = new CreditAccount(idAccount, Type.Кредитный.name(), 60000, 19, client1);
        idAccount++;
        Account acc4 = new DebitAccount(idAccount, Type.Дебитовый.name(), 53200, 4, client2);
        idAccount++;
        Account acc5 = new DebitAccount(idAccount, Type.Дебитовый.name(), 17800, 2, client2);
        idAccount++;
        Account acc6 = new DebitAccount(idAccount, Type.Дебитовый.name(), 126450, 0, client2);
        idAccount++;
        Account acc7 = new CreditAccount(idAccount, Type.Кредитный.name(), 200000, 21, client2);

        listClients.add(client1);
        listClients.add(client2);
        listAccounts.add(acc1);
        listAccounts.add(acc2);
        listAccounts.add(acc3);
        listAccounts.add(acc4);
        listAccounts.add(acc5);
        listAccounts.add(acc6);
        listAccounts.add(acc7);

    }

    public static void createInCycle() {
        int operation = 0;
        boolean isWork = true;

        Scanner inputOperationName = new Scanner(System.in);
        Scanner inputOperation = new Scanner(System.in);

        while (isWork) {
            writeParagraph('=');
            System.out.println(FontColor.ANSI_GREEN +
                    "Напишите: -1, если хотите выйти из программы." +
                    FontColor.ANSI_RESET);
            switch (operation) {
                case 0:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 0" + FontColor.ANSI_RESET);
                    System.out.println (FontColor.ANSI_GREEN +
                            "Напишите: 1, если хотите посмотреть всех клиентов.\n" +
                            "Напишите: 2, если хотите посмотреть все счета и их владельцев.\n" +
                            "Напишите: 3, если хотите создать клиента.\n" +
                            "Напишите: 4, если хотите создать дебитовый счет.\n" +
                            "Напишите: 5, если хотите создать кредитный счет." +
                            FontColor.ANSI_RESET);
                    break;
                case 1:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 1 ч.1" + FontColor.ANSI_RESET);
                    System.out.println (FontColor.ANSI_GREEN +
                            "Выберите номер клиента. Введите: [номер клиента id]" +
                            FontColor.ANSI_RESET);
                    break;
                case 2:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 2 ч.1" + FontColor.ANSI_RESET);
                    System.out.println (FontColor.ANSI_GREEN +
                            "Выберите номер счета. Введите: [номер счета id]" +
                            FontColor.ANSI_RESET);
                    break;
                case 3:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 3 ч.1" + FontColor.ANSI_RESET);
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный клиент: " + AccountManagement.currentClient.toString() + "\n" +
                            FontColor.ANSI_GREEN +
                            "Напишите: 3, если хотите создать еще одного нового клиента.\n" +
                            "Напишите: 4, если хотите создать дебитовый счет для клиента.\n" +
                            "Напишите: 5, если хотите создать кредитный счет для клиента." +
                            FontColor.ANSI_RESET);
                    break;
                case 4:
                case 5:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 4-5 ч.1" + FontColor.ANSI_RESET);
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный клиент: " + AccountManagement.currentClient.toString() + "\n" +
                            FontColor.ANSI_GREEN +
                            "Напишите: 4, если хотите создать еще один дебитовый счет для клиента.\n" +
                            "Напишите: 5, если хотите создать еще один кредитный счет для клиента." +
                            FontColor.ANSI_RESET);
                    break;
                case 7:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 7 ч.1" + FontColor.ANSI_RESET);
                    System.out.println("Что нужно сделать со счетом?");
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный счет: " + AccountManagement.currentAccount.toString() + "\n" +
                            FontColor.ANSI_GREEN +
                            "Напишите: плюс, если хотите добавить сумму к счету.\n" +
                            "Напишите: минус, если хотите снять сумму со счета.\n" +
                            "Напишите: перевод, если хотите перевести сумму на другой счет.\n" +
                            "Напишите: остаток, если хотите начислить ежемесячный процент.\n" +
                            "Напишите: баланс, если хотите узнать баланс.\n" +
                            "Напишите: процент, если хотите узнать процент по счету." +
                            FontColor.ANSI_RESET);
                    break;
                case 8:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 8 ч.1" + FontColor.ANSI_RESET);
                    System.out.println("Что нужно сделать со счетом?");
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный счет: " + AccountManagement.currentAccount.toString() + "\n" +
                            FontColor.ANSI_GREEN +
                            "Напишите: плюс, если хотите добавить сумму к счету.\n" +
                            "Напишите: минус, если хотите снять сумму со счета.\n" +
                            "Напишите: перевод, если хотите перевести сумму на другой счет.\n" +
                            "Напишите: остаток, если хотите начислить ежемесячный процент.\n" +
                            "Напишите: баланс, если хотите узнать баланс.\n" +
                            "Напишите: лимит, если хотите узнать лимит по кредитному счету.\n" +
                            "Напишите: процент, если хотите узнать процент по счету." +
                            FontColor.ANSI_RESET);
                    break;
            }

            if (operation > 2)
                System.out.println (FontColor.ANSI_GREEN +
                        "Напишите: 0 или 6, если хотите в начало." +
                        FontColor.ANSI_RESET);
            writeParagraph('-');

            if (operation < 7) {
                System.out.print(FontColor.ANSI_YELLOW +
                        "Выберите операцию: " +
                        FontColor.ANSI_RESET);
                operation = inputOperation.nextInt();
            }

            double money;
            String operationName;
            switch (operation) {
                case -1:
                    isWork = false;
                    break;
                case 0:
                    break;
                case 1:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 1 ч.2" + FontColor.ANSI_RESET);
                    AccountManagement.PrintClients();

                    System.out.print("Выберите ID клиента из списка выше: ");
                    int clientNumber = inputOperation.nextInt();
                    currentClient = listClients.get(clientNumber);
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный клиент: " + AccountManagement.currentClient.toString() + "\n" +
                            FontColor.ANSI_RESET);
                    System.out.println("Счета клиента:");
                    AccountManagement.PrintAccounts(currentClient);

                    System.out.print("Выберите ID счета клиента из списка выше: ");
                    int accountNumber = inputOperation.nextInt();
                    currentAccount = listAccounts.get(accountNumber);
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный счет: " + AccountManagement.currentAccount.toString() + "\n" +
                            FontColor.ANSI_RESET);

                    if (currentAccount.getType() == Type.Дебитовый.name())
                        operation = 7;
                    if (currentAccount.getType() == Type.Кредитный.name())
                        operation = 8;
                    break;
                case 2:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 2 ч.2" + FontColor.ANSI_RESET);
                    AccountManagement.PrintAccounts();

                    System.out.print("Выберите ID счета из списка выше: ");
                    int accountNumber2 = inputOperation.nextInt();
                    currentAccount = listAccounts.get(accountNumber2);
                    System.out.println (FontColor.ANSI_BLUE +
                            "Выбранный счет: " + AccountManagement.currentAccount.toString() + "\n" +
                            FontColor.ANSI_RESET);

                    if (currentAccount.getType() == Type.Дебитовый.name())
                        operation = 7;
                    if (currentAccount.getType() == Type.Кредитный.name())
                        operation = 8;
                    break;
                case 3:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 3 ч.2" + FontColor.ANSI_RESET);
                    System.out.print("Input name: ");
                    String name = inputOperation.nextLine();
                    System.out.print("Input password: ");
                    String password = inputOperation.nextLine();
                    System.out.printf("Вы ввели Name: %s  Password: %s" + "\n", name, password);
                    //inputOperation.close();
                    AccountManagement.CreateClient(name, password);
                    System.out.println("Клиент создан: " + AccountManagement.currentClient.toString());
                    break;
                case 4:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 4 ч.2" + FontColor.ANSI_RESET);
                    System.out.print("Input balance: ");
                    int balance = inputOperation.nextInt();
                    System.out.print("Input rate: ");
                    int rate = inputOperation.nextInt();
                    System.out.printf("Вы ввели Balance: %s  Rate: %s" + "\n", balance, rate);
                    //inputOperation.close();
                    AccountManagement.CreateDebitAccount(balance, rate);
                    System.out.println("Дебитовый счет создан: " + AccountManagement.currentAccount.toString());
                    break;
                case 5:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 5 ч.2" + FontColor.ANSI_RESET);
                    System.out.print("Input limit: ");
                    int limit = inputOperation.nextInt();
                    System.out.print("Input rate: ");
                    rate = inputOperation.nextInt();
                    System.out.printf("Вы ввели Balance: %s  Rate: %s" + "\n", limit, rate);
                    //inputOperation.close();
                    AccountManagement.CreateCreditAccount(limit, rate);
                    System.out.println("Кредитный счет создан: " + AccountManagement.currentAccount.toString());
                    break;
                case 6:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 6 ч.2" + FontColor.ANSI_RESET);
                    operation = 0;
                    break;
                case 7:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 7 ч.2" + FontColor.ANSI_RESET);
                    System.out.print("операция: ");
                    operationName = inputOperationName.nextLine();
                    switch (operationName) {
                        case "плюс":
                            System.out.print("Введите сумму: ");
                            money = inputOperation.nextDouble();
                            if(currentAccount.addMoney(money)) {
                                System.out.println("Зачисление " + money + " выполнено.");
                                System.out.println("Баланс счета: " + currentAccount.getBalance());
                            } else
                                System.out.println(FontColor.ANSI_RED +
                                        "Не смогли зачислить сумму!" +
                                        FontColor.ANSI_RESET);
                            break;
                        case "минус":
                            System.out.print("Введите сумму: ");
                            money = inputOperation.nextDouble();
                            if(currentAccount.withdrawMoney(money)) {
                                System.out.println("Сумма " + money + " снята.");
                                System.out.println("Баланс счета: " + currentAccount.getBalance());
                            } else
                                System.out.println(FontColor.ANSI_RED +
                                        "Недостаточно суммы на счете!" +
                                        FontColor.ANSI_RESET);
                            break;
                        case "перевод":
                            System.out.print("Введите сумму: ");
                            money = inputOperation.nextDouble();
                            System.out.print("Введите ID счета: ");
                            int id = inputOperation.nextInt();
                            if(currentAccount.transferMoney(money, listAccounts.get(id))) {
                                System.out.println("Сумма " + money + " переведена.");
                                System.out.println("Баланс счета: " + currentAccount.getBalance());
                                System.out.println("Баланс счета: " + listAccounts.get(id).getBalance());
                            } else
                                System.out.println(FontColor.ANSI_RED +
                                        "Перевод не возможен!" +
                                        FontColor.ANSI_RESET);
                            break;
                        case "остаток":
                            currentAccount.percentageOnBalance();
                            System.out.println("Процент на остаток счета зачислен.");
                            break;
                        case "баланс":
                            System.out.println(currentAccount.getBalance());
                            break;
                        case "процент":
                            System.out.println(currentAccount.getRate() + "%");
                            break;
                        case "0":
                        case "6":
                            operation = 0;
                            break;
                        default:
                            System.out.println(FontColor.ANSI_RED + "Нет такой операции!" + FontColor.ANSI_RESET);
                    }
                    break;
                case 8:
                    System.out.println(FontColor.ANSI_BLACK + "Операция 8 ч.2" + FontColor.ANSI_RESET);
                    System.out.print("операция: ");
                    operationName = inputOperationName.nextLine();
                    switch (operationName) {
                        case "плюс":
                            System.out.print("Введите сумму: ");
                            money = inputOperation.nextDouble();
                            if(currentAccount.addMoney(money)) {
                                System.out.println("Зачисление " + money + " выполнено.");
                                System.out.println("Баланс счета: " + currentAccount.getBalance());
                            } else
                                System.out.println(FontColor.ANSI_RED +
                                        "Не смогли зачислить сумму!" +
                                        FontColor.ANSI_RESET);
                            break;
                        case "минус":
                            System.out.print("Введите сумму: ");
                            money = inputOperation.nextDouble();
                            if(currentAccount.withdrawMoney(money)) {
                                System.out.println("Сумма " + money + " снята.");
                                System.out.println("Баланс счета: " + currentAccount.getBalance());
                            } else
                                System.out.println(FontColor.ANSI_RED +
                                        "Недостаточно суммы на счете!" +
                                        FontColor.ANSI_RESET);
                            break;
                        case "перевод":
                            System.out.print("Введите сумму: ");
                            money = inputOperation.nextDouble();
                            System.out.print("Введите ID счета: ");
                            int id = inputOperation.nextInt();
                            if(currentAccount.transferMoney(money, listAccounts.get(id))) {
                                System.out.println("Сумма " + money + " переведена.");
                                System.out.println("Баланс счета: " + currentAccount.getBalance());
                                System.out.println("Баланс счета: " + listAccounts.get(id).getBalance());
                            } else
                                System.out.println(FontColor.ANSI_RED +
                                        "Перевод невозможен! Это кредитный счет." +
                                        FontColor.ANSI_RESET);
                            break;
                        case "остаток":
                            currentAccount.percentageOnBalance();
                            System.out.println("Процент на остаток счета зачислен.");
                            break;
                        case "баланс":
                            System.out.println(currentAccount.getBalance());
                            break;
                        //case "лимит":
                            //System.out.println((CreditAccount)currentAccount.getLimit());
                            //break;
                        case "процент":
                            System.out.println(currentAccount.getRate() + "%");
                            break;
                        case "0":
                        case "6":
                            operation = 0;
                            break;
                        default:
                            System.out.println(FontColor.ANSI_RED + "Нет такой операции!" + FontColor.ANSI_RESET);
                    }
                    break;
            }

        }
        System.out.println("До свидания!");

    }

    public static void writeParagraph(char c) {
        for (int i = 0; i < 75; i++)
            System.out.print(c);
        System.out.println();
    }

    enum Type
    {
        Дебитовый,
        Кредитный
    }

}
