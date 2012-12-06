package ex03_02.investment.pkobp;

import ex03_02.investment.Investment;
import java.util.Date;


public class PkoBpBestInvestment extends Investment {

    public PkoBpBestInvestment(Date startDate, float contribution, float interestRate) {
        super(startDate, contribution, 20F);
    }

    
    @Override
    public float getInterestRate() {
        return interestRate;
    }

    @Override
    public Date howMuchLonger() {
        throw new UnsupportedOperationException("Not supported yet.");
    }  
    
        
}
