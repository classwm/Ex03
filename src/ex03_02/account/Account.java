package ex03_02.account;

import ex03_02.investment.Investment;
import java.util.HashMap;
import java.util.List;

public abstract class Account {

    public Account(String firstName, String lastName, float capital) {
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
    private String accountName;
    private String firstName;
    private String lastName;
    private float capital;
}
