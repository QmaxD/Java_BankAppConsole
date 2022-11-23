package org.example;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //AccountManagement.createManually();// если хотите развлекаться вручную

        int operation = 0;
        boolean isWork = true;

        Scanner inputOperation = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        while (isWork) {
            System.out.println ("Напишите: -1, если хотите выйти из программы.");
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
                            "Напишите: 5, если хотите создать еще один кредитный счет для клиента.\n");
                    break;
            }
            if (operation > 2)
                System.out.println ("Напишите: 6, если хотите в начало.");

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
}