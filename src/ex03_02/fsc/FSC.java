package ex03_02.fsc;

import ex03_02.bank.Bank;
import ex03_02.bank.mbank.MBank;
import ex03_02.bank.pkobp.BankPkoBp;
import java.util.HashMap;
import java.util.Set;

public abstract class FSC { // financial supervisory committee

    private static HashMap<String, Bank> availableBanks = new HashMap<String, Bank>();

    static {
        availableBanks.put("PkoBp", new BankPkoBp());
        availableBanks.put("MBank", new MBank());
        // blok statyczny uruchamia się raz przy wczytywaniu klasy
    }
    
    public static Set<String> getBankList() {
        return availableBanks.keySet();
    }

    public static Bank getBank(String bankName) {
        return availableBanks.get(bankName);
    }
}
