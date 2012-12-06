package ex03_02;

import ex03_02.account.Account;
import ex03_02.bank.Bank;
import ex03_02.fsc.FSC;
import ex03_02.investment.Investment;
import java.util.Scanner;

public class Ex03_02 {

    Bank bank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String selected = "N";
        while (!selected.equalsIgnoreCase("Y")) {

            System.out.println("Do wyboru sa następujące banki:");
            Object[] banks = FSC.getBankList().toArray();
            int i = 1;
            for (String bankName : FSC.getBankList()) {
                System.out.println("[" + i + "] " + bankName);
                i++;
            }
            System.out.println("Podaj numer banku, który wybierasz:");
            int bankNumber = Integer.parseInt(sc.nextLine());
            String bankName = (String) banks[bankNumber - 1];
            Bank selectedBank = FSC.getBank(bankName);

            System.out.println("Do wyboru są następujące konta:");
            Object[] accounts = selectedBank.getAvailableAccountNames().toArray();
            i = 1;
            for (String accountName : selectedBank.getAvailableAccountNames()) {
                System.out.println("[" + i + "] " + accountName);
                i++;
            }
            System.out.println("Podaj numer konta, które wybierasz:");
            int accountNumber = Integer.parseInt(sc.nextLine());
            String accountName = (String) accounts[accountNumber - 1];

            System.out.println("Nazwa wybranego konta: " + accountName);

            System.out.println("Podaj imię:");
            String firstName = sc.nextLine();

            System.out.println("Podaj nazwisko:");
            String lastName = sc.nextLine();
            System.out.println("Kasa?:");
            Float capital = sc.nextFloat();
            Account account = selectedBank.createAccount(accountName, firstName, lastName, capital);
            separator("=", " ", 40);
            selectedBank.setListOfAccounts(account);
            System.out.println("Konta założone w banku " + bankName + ":");
            separator("=", " ", 40);
            for (Account acc : selectedBank.getListOfAccounts()) {
                System.out.println("Nazwa konta: " + acc.getAccountName());
                System.out.println("Imię i nazwisko: " + acc.getFirstName() + " " + acc.getLastName());
                System.out.println("Kapitał: " + acc.getCapital());
                separator("-", " ", 40);
            }           

            System.out.println("Do wyboru są nastepujące lokaty:");
            Object[] investments = selectedBank.getAvailableInvestmentsNames().toArray();
            i = 1;
            for (String investmentName : selectedBank.getAvailableInvestmentsNames()) {
                System.out.println("[" + i + "] " + investmentName);
                i++;
            }
            Float income = 0F;
            String dump = sc.nextLine();
            System.out.println("Czy chcesz wybrać lokatę? [Y,N]");
            String ifInvestment = sc.nextLine();
            capital = account.getCapital();
            if (ifInvestment.equalsIgnoreCase("Y")) {
                System.out.println("Podaj numer lokaty, którą wybierasz:");
                int investmentNumber = Integer.parseInt(sc.nextLine());
                String investmentName = (String) investments[investmentNumber - 1];
                Investment selectedInvestment = selectedBank.createInvestment(investmentName, capital);
                income = capital * selectedInvestment.getInterestRate() / 100;
                System.out.println("Lokata założona: " + selectedInvestment.getStartDate());
                System.out.println("Roczny procent: " + selectedInvestment.getInterestRate());
            }

            System.out.println("Po roku stan twojego konta bedzie wynosił:");
            capital = capital + income;
            System.out.println(capital);

            System.out.println("Czy chcesz zakończyć program? [Y,N]");
            selected = sc.nextLine();
        }
        sc.close();
    } // main

    /**
     * Formatowanie wyjścia danych programu.
     *
     * @param sep Ciąg znaków separatora.
     * @param info String z opisem następnego bloku wypisanych danych.
     * @param i Ilośc powtórzen wyświetlenia separatora.
     */
    private static void separator(String sep, String info, int i) {
        while (i > 0) {
            System.out.print(sep);
            i--;
        }
        System.out.println(" " + info + " ");
    }
} // Ex03_02