package DS_09;

public class CalculatorException extends Exception {

    private CalculatorError _error;

    //<GETTER SETTER START>
    public CalculatorError error(){ return this._error; }
    public void setError(CalculatorError newError){ this._error = newError;}
    //<GETTER SETTER END>

    //<CONSTRUCTOR START>
    public CalculatorException(){ this.setError(CalculatorError.Undefined); }
    public CalculatorException(CalculatorError givenError){ this.setError(givenError); }
    //<CONSTRUCTOR END>

}
