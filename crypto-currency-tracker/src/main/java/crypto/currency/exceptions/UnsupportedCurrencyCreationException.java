package crypto.currency.exceptions;

public class UnsupportedCurrencyCreationException extends Exception{
    public UnsupportedCurrencyCreationException (String errorMessage){
        super(errorMessage);
    }
}
