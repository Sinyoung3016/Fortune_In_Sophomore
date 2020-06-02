package DS_12;
//실험에 필요한 매개변수 값들을 보관
public class ParameterSet {

    private int _startingSize;
    private int _numberOfSizeIncreasingSteps;
    private int _incrementSize;

    //<GETTER SETTER START>
    public int startingSize(){ return this._startingSize; }
    public void setStartingSize(int newStartingSize){ this._startingSize = newStartingSize; }
    public int numberOfSizeIncreasingSteps(){ return this._numberOfSizeIncreasingSteps; }
    public void setNumberOfSizeIncreasingSteps(int newNumberOfSizeIncreasingSteps){ this._numberOfSizeIncreasingSteps = newNumberOfSizeIncreasingSteps; }
    public int incrementSize(){ return this._incrementSize; }
    public void setIncrementSize(int newIncrementSize){ this._incrementSize = newIncrementSize; }
    //<GETTER SETTER END>

    public int maxDataSize(){
        return (this.startingSize() + ((this.numberOfSizeIncreasingSteps() - 1) * this.incrementSize()));
    }

    public ParameterSet(int givenStartingSize, int givenNumberOfSizeIncreasingSteps, int givenIncrementSize){
        this.setStartingSize(givenStartingSize);
        this.setIncrementSize(givenIncrementSize);
        this.setNumberOfSizeIncreasingSteps(givenNumberOfSizeIncreasingSteps);
    }
}
