package ex03_02.account;

import ex03_02.investment.Investment;

public abstract class Account {

    public Account(String accountName, String firstName, String lastName, float capital) {
        this.accountName = accountName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.capital = capital;
    }

    public float getCapital() {
        return capital;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getAccountName() {
        return accountName;
    }
    
    private String accountName;
    private String firstName;
    private String lastName;
    private float capital;
    
} //Account
