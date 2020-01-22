package View;

import Model.Currency;
import Model.ExchangeRate;

interface ExchangeRateLoader {

    ExchangeRate load(Currency currencyFrom, Currency currencyTo);
}
