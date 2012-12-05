package ex03_02.bank.pkobp;

import ex03_02.account.Account;
import ex03_02.account.pkobp.EmployeeAccountPkoBp;
import ex03_02.account.pkobp.StudentAccountPkoBp;
import ex03_02.bank.Bank;
import ex03_02.investment.Investment;
import ex03_02.investment.pkobp.PkoBpBestInvestment;
import ex03_02.investment.pkobp.PkoBpWorstInvestment;
import java.util.HashMap;
import java.util.List;

public class BankPkoBp extends Bank {

    {
        availableAccounts = new HashMap<String, Class<? extends Account>>();
        availableAccounts.put("Konto Studenckie PkoBp", StudentAccountPkoBp.class);
        availableAccounts.put("Konto Pracownicze PkoBp", EmployeeAccountPkoBp.class);
        
        availableInvestments = new HashMap<String, Class<? extends Investment>>();
        availableInvestments.put("Najgorsza lokata w PkoBp", PkoBpWorstInvestment.class);
        availableInvestments.put("Najlepsza lokata w PkoBp", PkoBpBestInvestment.class);
    }    
    
}
