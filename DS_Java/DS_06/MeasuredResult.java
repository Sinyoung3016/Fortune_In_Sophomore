package DS_06;

public class MeasuredResult {
    private int _size;
    private long _durationForAdd;
    private long _durationForMax;
    //시간 측정 결과의 자료형이 : long이기 때문에, nano second


    //<GETTER SETTER START>
    public int size(){ return this._size; }
    public void setSize(int newSize){ this._size = newSize; }
    public long durationForAdd(){ return this._durationForAdd; }
    public void setDurationForAdd(long newDurationForAdd){ this._durationForAdd = newDurationForAdd; }
    public long durationForMax(){ return this._durationForMax; }
    public void setDurationForMax(long newDurationForMax){ this._durationForMax = newDurationForMax; }
    //<GETTER SETTER END>


    //<CONSTRUCTURE START>
    public MeasuredResult(){
        this(0,0,0);
    }
    public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax){
        this.setSize(givenSize);
        this.setDurationForAdd(givenDurationForAdd);
        this.setDurationForMax(givenDurationForMax);
    }
    //<CONSTRUCTURE END>


}
