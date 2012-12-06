
package ex03_02.account.mbank;

import ex03_02.account.Account;
import ex03_02.investment.Investment;
import java.util.List;

public class StudentAccountMBank extends Account {

    public StudentAccountMBank(String firstName, String lastName, float capital) {
        super("Konto Studenckie MBank", firstName, lastName, capital);
    }
}
