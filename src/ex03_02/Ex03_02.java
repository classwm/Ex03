package ex03_02;

import ex03_02.account.Account;
import ex03_02.bank.Bank;
import ex03_02.fsc.FSC;
import ex03_02.investment.Investment;
import java.util.Scanner;
import ex03_02.database.DatabaseTool;
import java.sql.SQLException;

public class Ex03_02 {

    Bank bank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bankWithSQL = "PkoBp";  // bank, do którego zostaną wczytane konta z pliku SQLite
        Bank importToBank = FSC.getBank(bankWithSQL);
        separator("=", " ", 40);
        System.out.println("Konta wczytane z pliku SQLite do " + bankWithSQL);
        separator("=", " ", 40);
        try {  // pobiera i wyświetla konta zawarte w pliku SQLite, przypisuje je banku ze zmiennej bankWithSQL
            Account[] acc = DatabaseTool.getAccounts();

            for (Account acc2 : acc) {
                System.out.println("Nazwa konta: " + acc2.getAccountName());
                System.out.println("Imię i nazwisko: " + acc2.getFirstName() + " " + acc2.getLastName());
                System.out.println("Kapitał: " + acc2.getCapital());
                separator("-", " ", 40);
                importToBank.setListOfAccounts(acc2);
            }
        } catch (SQLException ex) {
            System.out.println("Błąd odczytu SQL!");
            System.out.println(ex);
            // IT'S NOT EXACTLY GOOD, BUT I LEAVE IT :)
        }

        System.out.println("");

        String selected = "N";
        while (!selected.equalsIgnoreCase("Y")) {

            System.out.println("Do wyboru są następujące banki:");
            String[] offeredBanks = new String[4]; // pomocnicza tabela do wyświetlania listy wyboru banków, jej rozmiar nie może być mniejszy niż ilość banków + 1
            int i = 1;
            for (String bankName : FSC.getBankList()) {
                System.out.println("[" + i + "] " + bankName);
                offeredBanks[i] = bankName;
                i++;
            }
            System.out.println("Podaj numer banku, który wybierasz:");
            int offeredBankNumber = Integer.parseInt(sc.nextLine());
            String bankName = offeredBanks[offeredBankNumber];
            Bank selectedBank = FSC.getBank(bankName);

            System.out.println("Do wyboru są następujące konta:");
            String[] offeredAccounts = new String[4]; // pomocnicza tabela do wyświetlania listy wyboru kont, rozmiar nie mniejszy niż ilość kont + 1
            i = 1;
            for (String accountName : selectedBank.getAvailableAccountNames()) {
                System.out.println("[" + i + "] " + accountName);
                offeredAccounts[i] = accountName;
                i++;
            }
            System.out.println("Podaj numer rodzaju konta, które wybierasz:");
            int offeredAccountNumber = Integer.parseInt(sc.nextLine());
            String accountName = offeredAccounts[offeredAccountNumber];

            System.out.println("Nazwa wybranego konta: " + accountName);

            System.out.println("Podaj imię:");
            String firstName = sc.nextLine();
            System.out.println("Podaj nazwisko:");
            String lastName = sc.nextLine();
            System.out.println("Kasa?:");
            Float capital = sc.nextFloat();

            Account account = selectedBank.createAccount(accountName, firstName, lastName, capital);
            separator("=", " ", 40);
            selectedBank.setListOfAccounts(account); // dodanie założonego konta do listy kont banku
            System.out.println("Konta założone w banku " + bankName + ":");
            separator("=", " ", 40);
            for (Account acc : selectedBank.getListOfAccounts()) { // wyświetlenie kont założonych w banku
                System.out.println("Nazwa konta: " + acc.getAccountName());
                System.out.println("Imię i nazwisko: " + acc.getFirstName() + " " + acc.getLastName());
                System.out.println("Kapitał: " + acc.getCapital());
                separator("-", " ", 40);
            }

            System.out.println("Do wyboru są następujące lokaty:");
            String[] offeredInvestments = new String[4]; // pomocnicza tabela do wyświetlania listy wyboru lokat, rozmiar nie mniejszy niż ilość lokat + 1
            i = 1;
            for (String investmentName : selectedBank.getAvailableInvestmentsNames()) {
                System.out.println("[" + i + "] " + investmentName);
                offeredInvestments[i] = investmentName;
                i++;
            }
            Float income = 0F;
            String dump = sc.nextLine();
            System.out.println("Czy chcesz wybrać lokatę? [Y,N]"); // opcja wyboru lokaty
            String ifInvestment = sc.nextLine();
            capital = account.getCapital();
            if (ifInvestment.equalsIgnoreCase("Y")) {
                System.out.println("Podaj numer lokaty, którą wybierasz:");
                int offeredInvestmentNumber = Integer.parseInt(sc.nextLine());
                String investmentName = offeredInvestments[offeredInvestmentNumber];
                Investment selectedInvestment = selectedBank.createInvestment(investmentName, capital);
                income = capital * selectedInvestment.getInterestRate() / 100;
                System.out.println("Lokata założona: " + selectedInvestment.getStartDate());
                System.out.println("Roczny procent: " + selectedInvestment.getInterestRate());
            }

            System.out.println("Po roku stan twojego konta będzie wynosił:");
            capital = capital + income;
            System.out.println(capital);

            System.out.println("Czy chcesz zakończyć program? [Y,N]");
            selected = sc.nextLine();
        }
        try {
            DatabaseTool.saveAccounts(importToBank.getListOfAccounts());
            System.out.println("Konta utworzone w " + bankWithSQL + " zostały zapisane do pliku.");
        } catch (SQLException ex) {
            System.out.println("Błąd przy zapisie SQL!");
            System.out.println(ex);
            // IT'S NOT EXACTLY GOOD, BUT I LEAVE IT :)
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