package ex03_02.bank.pkobp;

import ex03_02.account.Account;
import ex03_02.account.pkobp.EmployeeAccountPkoBp;
import ex03_02.account.pkobp.StudentAccountPkoBp;
import ex03_02.bank.Bank;
import ex03_02.investment.Investment;
import java.util.HashMap;
import java.util.List;

public class BankPkoBp extends Bank {

    {
        availableAccounts = new HashMap<String, Class<? extends Account>>();
        availableAccounts.put("Konto Studenckie PkoBp", StudentAccountPkoBp.class);
        availableAccounts.put("Konto Pracownicze PkoBp", EmployeeAccountPkoBp.class);
        
        
    }
    
    
}
