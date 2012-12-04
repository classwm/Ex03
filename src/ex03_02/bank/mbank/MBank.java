package ex03_02.bank.mbank;

import ex03_02.account.Account;
import ex03_02.account.mbank.EmployeeAccountMBank;
import ex03_02.account.mbank.StudentAccountMBank;
import ex03_02.bank.Bank;
import ex03_02.investment.Investment;
import ex03_02.investment.mbank.MBankBestInvestment;
import ex03_02.investment.mbank.MBankWorstInvestment;
import java.util.HashMap;
import java.util.List;

public class MBank extends Bank {

    {
        availableAccounts = new HashMap<String, Class<? extends Account>>();
        availableAccounts.put("Konto Studenckie MBank", StudentAccountMBank.class);
        availableAccounts.put("Konto Pracownicze MBank", EmployeeAccountMBank.class);
        
        availableInvestments = new HashMap<String, Class<? extends Investment>>();
        availableInvestments.put("Najgorsza lokata w MBanku", MBankWorstInvestment.class);
        availableInvestments.put("Najlepsza lokata w MBanku", MBankBestInvestment.class);
    }    
}