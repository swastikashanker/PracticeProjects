import java.util.Arrays;
import java.util.List;

public class SavingAccount extends BankAccount{


    public SavingAccount(Double amount, Double rateOfInterest, Transaction... transactions) {
        super(amount, rateOfInterest, Arrays.asList(transactions));
    }

    @Override
    public Double getInterest(Integer duration) {
        Double interest = 0d;
        Double P = getAmount();
        Double r = getRateOfInterest();
        int N = 12;
        interest=P*(Math.pow(1+(r/N),N*duration)-P);

        return interest;
    }
}
