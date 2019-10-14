package moneycalculator;


public class Money {

    double amount;
    Currency currency;
    

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
     
    
    
}
