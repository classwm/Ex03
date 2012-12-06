package ex03_02.bank;

import ex03_02.account.Account;
import ex03_02.investment.Investment;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
// import java.util.Date;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class Bank {
    
    
    public void setListOfAccounts(Account account) {
        listOfAccounts.add(account);
    }
     
    public Set<Account> listOfAccounts = new HashSet<Account>();
    

    protected HashMap<String, Class<? extends Account>> availableAccounts; // wartościa hasha jest klasa Account

    public final List<String> getAvailableAccountNames() {
        {

            return new ArrayList<String>(availableAccounts.keySet());
        }
    }

    public final Account createAccount(String accountName, String firstName, String lastName,
            float capital) {
        Class<? extends Account> accountClass = availableAccounts.get(accountName); //uzyskane z wywołania klasy

        try {
            return accountClass.getConstructor(String.class, String.class, String.class, float.class).newInstance(accountName, firstName, lastName, capital); //"get" wybiera konstruktor z klasy, "new instance" go "uruchamia"
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }
        // availableAccounts.put("obj", StudentAccountPkoBp.class); przykład użycia HashMapy

        return null;
    }

    public final Investment createInvestment(String investmentName, float capital) {
        Class<? extends Investment> investmentClass = availableInvestments.get(investmentName); //uzyskane z wywołania klasy

        Calendar today = Calendar.getInstance();
        Date time = today.getTime();
        

        try {
            return investmentClass.getConstructor(Date.class, float.class, float.class).newInstance(time, capital, 0); //"get" wybiera konstruktor z klasy, "new instance" go "uruchamia"
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            // IT'S WRONG, BUT LEAVE IT
        }
        
        return null;
    }
    
    protected HashMap<String, Class<? extends Investment>> availableInvestments;

    public final List<String> getAvailableInvestmentsNames() {
        return new ArrayList<String>(availableInvestments.keySet());
    }
    
    
    
    // public abstract Investment createInvestement(String investmentName, float contribution);   
//    public final Investment createInvestement(String investmentName, float contribution) {
//        // TODO użyć refleksji, na klasie wywołany konstruktor
//        return null;
//    }
}
