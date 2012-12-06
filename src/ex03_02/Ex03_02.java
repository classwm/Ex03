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
                System.out.println("* " + accountName);
            }
            String accountName = sc.nextLine();
            System.out.println("Nazwa konta: " + accountName);
            System.out.println("Podaj imię:");
            String firstName = sc.nextLine();

            System.out.println("Podaj nazwisko:");
            String lastName = sc.nextLine();
            System.out.println("Kasa?:");
            Float capital = sc.nextFloat();
            Account account = selectedBank.createAccount(accountName, firstName, lastName, capital);

            System.out.println("Nazwa konta: " + account.getAccountName());
            System.out.println("Imię: " + account.getFirstName());
            System.out.println("Nazwisko: " + account.getLastName());
            System.out.println("Stan konta: " + account.getCapital());

//            selectedBank.setListOfAccounts(account);
//            System.out.println("Konta: " + selectedBank.listOfAccounts);

            Account selectedAccount;

            System.out.println("Do wyboru sa nastepujace lokaty:");
            for (String investmentName : selectedBank.getAvailableInvestmentsNames()) {
                System.out.println("* " + investmentName);
            }
            Float income = 0F;
            String dump = sc.nextLine();
            System.out.println("Czy chcesz wybrać lokatę? [Y,N]");
            String ifInvestment = sc.nextLine();
            capital = account.getCapital();            
            if (ifInvestment.equalsIgnoreCase("Y")) {
                System.out.println("Która lokatę wybierasz?");                
                String investmentName = sc.nextLine();
                Investment selectedInvestment = selectedBank.createInvestment(investmentName, capital);
                income = capital * selectedInvestment.getInterestRate() / 100;
                System.out.println("Lokata założona: " + selectedInvestment.getStartDate()); 
                System.out.println("Roczny procent: " + selectedInvestment.getInterestRate());
            }

            System.out.println("Po roku stan twojego konta bedzie wynosił:");
            capital = capital + income;
            System.out.println(capital);
            
            System.out.println("Czy chcesz zakonczyć program? [Y,N]");
            selected = sc.nextLine();
        }

        sc.close();
    }
}