package moneycalculator.View;

import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;

interface ExchangeRateLoader {

    ExchangeRate load(Currency currencyFrom, Currency currencyTo);
}
