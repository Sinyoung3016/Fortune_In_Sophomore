package DS_06;

public class Coin implements Comparable<Coin> {
    private static final int DEFAULT_VALUE = 0;
    private int _value;

    //<Coin 생성자 start>
    public Coin(){
        this._value = DEFAULT_VALUE;
    }
    public Coin(int givenValue ){ this._value = givenValue; }
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

    public int compareTo(Coin aCoin){
        if(this.value() < aCoin.value()) return -1;
        else if(this.value() < aCoin.value()) return 1;
        else return 0;
    }
}
