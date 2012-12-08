package ex03_02.bank;

import ex03_02.account.Account;
import ex03_02.investment.Investment;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class Bank {

    /**
     * Dodaje konto do listy kont utworzonych w danym banku
     * 
     * @param account 
     */
    public void setListOfAccounts(Account account) {
        listOfAccounts.add(account);
    }

    /**
     * Zwraca listę kont z danego banku
     * 
     * @return 
     */
    public Set<Account> getListOfAccounts() {
        return listOfAccounts;
    }
    
    /**
     * Lista kont w danym banku
     * 
     */
    private Set<Account> listOfAccounts = new HashSet<Account>();
    
    protected HashMap<String, Class<? extends Account>> availableAccounts;

    public final List<String> getAvailableAccountNames() {
        {
            return new ArrayList<String>(availableAccounts.keySet());
        }
    }

    public final Account createAccount(String accountName, String firstName, String lastName,
            float capital) {
        Class<? extends Account> accountClass = availableAccounts.get(accountName);

        try {
            return accountClass.getConstructor(String.class, String.class, String.class, float.class).newInstance(accountName, firstName, lastName, capital); 
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }        
        return null;
    }

    public final Investment createInvestment(String investmentName, float capital) {
        Class<? extends Investment> investmentClass = availableInvestments.get(investmentName); 

        Calendar today = Calendar.getInstance();
        Date time = today.getTime();

        try {
            return investmentClass.getConstructor(Date.class, float.class, float.class).newInstance(time, capital, 0); // wartość oprocentowania nadpisywana jest później w klasie odpowiedniej lokaty
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }
        return null;
    }
    
    protected HashMap<String, Class<? extends Investment>> availableInvestments;

    public final List<String> getAvailableInvestmentsNames() {
        return new ArrayList<String>(availableInvestments.keySet());
    }
    
} // Bank
