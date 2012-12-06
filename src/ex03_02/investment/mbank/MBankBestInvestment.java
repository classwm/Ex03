package ex03_02.investment.mbank;

import ex03_02.investment.Investment;
import java.util.Date;


public class MBankBestInvestment extends Investment {

    public MBankBestInvestment(Date startDate, float contribution, float interestRate) {
        super(startDate, contribution, fixedInterest);
    }

    private static final Float fixedInterest = 10F;
    
    @Override
    public float getInterestRate() {
        return interestRate;
    }

    @Override
    public Date howMuchLonger() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
}