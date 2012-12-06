package ex03_02.investment;

import java.util.Date;

public abstract class Investment {

    protected float interestRate;
    private Date startDate;
    private float contribution;

    public Investment(Date startDate, float contribution, float interestRate) {
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.contribution = contribution;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public abstract Date howMuchLonger();
}
