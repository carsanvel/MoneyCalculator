package moneycalculator.View;

import java.util.Map;
import moneycalculator.Model.Currency;

interface CurrencyLoader {
    
    void load(Map<String, Currency> currencies);
}
