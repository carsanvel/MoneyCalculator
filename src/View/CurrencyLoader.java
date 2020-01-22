package View;

import java.util.Map;
import Model.Currency;

interface CurrencyLoader {
    
    void load(Map<String, Currency> currencies);
}
