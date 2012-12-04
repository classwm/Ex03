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
            System.out.println("Do wyboru sa nastepujace banki:");
            for (String bankName : FSC.getBankList()) {
                System.out.println("* " + bankName);
            }
            System.out.println("Który bank wybierasz?");
            String bankName = sc.nextLine();
            Bank selectedBank = FSC.getBank(bankName);
            
            System.out.println("Do wyboru sa nastepujace konta:");
            for (String accountName : selectedBank.getAvailableAccountNames()) {
            System.out.println("* " +  accountName);
            }
            String accountName = sc.nextLine();
            
            System.out.println("Podaj imię:");
            String firstName = sc.nextLine();
            
            System.out.println("Podaj nazwisko:");
            String lastName = sc.nextLine();
            System.out.println("Kasa?:");
            Float capital = sc.nextFloat();
            Account account = selectedBank.createAccount(accountName, firstName, lastName, capital);
            System.out.println("Stan konta " + account.getCapital());
            
            Account selectedAccount;

            System.out.println("Do wyboru sa nastepujace lokaty:");
            for (String investmentName : selectedBank.getAvailableInvestmentsNames()) {
            System.out.println("* " +  investmentName);
            }
            System.out.println("Która lokatę wybierasz?");
            String investmentName = sc.nextLine();
            
            Investment selectedInvestment = null; // TODO

            System.out.println("Po roku stan twojego konta bedzie nastpujacy:");

            System.out.println("Czy chcesz zakonczyc program? [Y,N]");
            selected = sc.next();
        }

        sc.close();
    }
}