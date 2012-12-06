package ex03_02.account.mbank;

import ex03_02.account.Account;
import ex03_02.investment.Investment;
import java.util.List;

public class EmployeeAccountMBank extends Account {

    public EmployeeAccountMBank(String accountName, String firstName, String lastName, float capital) {
        super(accountName, firstName, lastName, capital);
    }
}
