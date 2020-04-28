package DS_04;

public class Coin {
    private static final int DEFAULT_VALUE = 0;
    private int _value; //동전의 금액

    //<Coin 생성자 start>
    public Coin(){
        this._value = DEFAULT_VALUE;
    }
    public Coin( int givenValue ){
        this._value = givenValue;
    }
    //<Coin 생성자 end>

    public int value(){
        return _value;
    }
    public void setValue(int newValue){
        this._value = newValue;
    }
    public boolean equals(Object otherCoin){
     if(otherCoin.getClass() != Coin.class)  return false;
     else return (this.value() == ((Coin) otherCoin).value());
    }
}
