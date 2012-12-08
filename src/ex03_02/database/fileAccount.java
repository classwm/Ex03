
package ex03_02.database;

import ex03_02.account.Account;

/**
 * Przechowuje odczytane z pliku SQL dane o kontach
 * 
 * @param accountName Nazwa konta w systemie bankowym
 * @param firstName Imię posiadacza konta
 * @param lastName Nazwisko posiadacza konta
 * @param capital ilość pieniędzy na koncie
 */

public class fileAccount extends Account {

    public fileAccount(String accountName, String firstName, String lastName, float capital) {
        super(accountName, firstName, lastName, capital);
    }
}

