package DS_06;

public class Experiment {
    private static final int DEFAULT_NUMBER_OF_ITRATION = 5;
    private static final int DEFAULT_SIZE = 10000; //첫번째 실험 데이터 크기
    private static final int DEFAULT_SIZE_INCREMENT = 10000; //실험 데이터 크기 증가량

    private int _numberOfIteration;
    private int _firstSize;
    private int _sizeIncrement;
    private Coin[] _data;
    private MeasuredResult[] _measuredResults;

    //GETTER SETTER START
    public int numberOfIteration(){return this._numberOfIteration;}
    public void setNumberOfIteration(int newNumberOfIteration){ this._numberOfIteration = newNumberOfIteration; }
    public int firstSize(){return this._firstSize;}
    public void setFirstSize(int newFirstSize){ this._firstSize = newFirstSize; }
    public int sizeIncrement(){ return this._sizeIncrement; }
    public void setSizeIncrement(int newSizeIncrement){ this._sizeIncrement = newSizeIncrement; }

    public int maxSize(){ return (this.firstSize() + this.sizeIncrement() * (this.numberOfIteration() - 1)); }

    public Coin[] data(){ return this._data;}
    public void setData(Coin[] newCoin){ this._data = newCoin; }
    public MeasuredResult[] measuredResults(){ return this._measuredResults; }
    public void setMeasuredResults(MeasuredResult[] newMeasuredResults){ this._measuredResults = newMeasuredResults; }
    //GETTER SETTER END

    //CONSTRUCTURE START
    public Experiment(){
        this(DEFAULT_NUMBER_OF_ITRATION, DEFAULT_SIZE, DEFAULT_SIZE_INCREMENT);
    }
    public Experiment(int givenNumberOfIteraton, int givenFirstSize, int givenSizeIncrement){
        this.setNumberOfIteration(givenNumberOfIteraton);
        this.setFirstSize(givenFirstSize);
        this.setSizeIncrement(givenSizeIncrement);

        this.setData(new Coin[this.maxSize()]); //실험 데이터를 담은 배열 공간 확보
        this.setMeasuredResults(new MeasuredResult[this.numberOfIteration()]); //실험 결과를 저장할 배열 공간 획보
    }
    //CONSTRUCTURE END

    public void generateData(){
        //성능 측정에 사용할 데이터를 생성, 여기서는 50000개의 원소를 담을 수 있는 배열이 만들어짐
        java.util.Random random = new java.util.Random();
        for(int i = 0; i < this.maxSize(); i++){
            int randomCoinValue = random.nextInt(this.maxSize());
            this.data()[i] = new Coin(randomCoinValue);
        }
    }

    public void measureForSortedArrayList(){
        //Sorted Array로 구현한 List의 성능을 측정함

        Coin maxCoin;
        long durationForAdd = 0, durationForMax = 0;
        long start, stop;

        int dataSize = this.firstSize(); //10000

        for(int iteration = 0; iteration < this.numberOfIteration(); iteration++){ //5번 반복
            SortedArrayList<Coin> list = new SortedArrayList(dataSize);
            for(int i = 0;  i < dataSize; i++){ //10000번 for반복
                //<ADD START>
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);
                //<ADD END>

                //<MAX START>
                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);
                //<MAX END>
            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize += this.sizeIncrement(); // dataSize + 10000
        }

    }

    public void measureForUnSortedArrayList(){
        //Array로 구현한 List의 성능을 측정함
        @SuppressWarnings("unused")
        Coin maxCoin;

        long durationForAdd = 0, durationForMax = 0;
        long start, stop;

        int dataSize = this.firstSize();

        for(int iteration = 0; iteration < this.numberOfIteration(); iteration++){
            UnSortedArrayList<Coin> list = new UnSortedArrayList<Coin>(dataSize);
            for(int i = 0;  i < dataSize; i++){
                //<ADD START>
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);
                //<ADD END>

                //<MAX START>
                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);
                //<MAX END>
            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize += this.sizeIncrement();
        }
    }

    public void measureForSortedLinkedList(){
        //Sorted Linked로 구현한 List의 성능을 측정함
        @SuppressWarnings("unused")
        Coin maxCoin;

        long durationForAdd = 0, durationForMax = 0;
        long start, stop;

        int dataSize = this.firstSize();

        for(int iteration = 0; iteration < this.numberOfIteration(); iteration++){
            SortedLinkedList<Coin> list = new SortedLinkedList<Coin>();
            for(int i = 0;  i < dataSize; i++){
                //<ADD START>
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);
                //<ADD END>

                //<MAX START>
                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);
                //<MAX END>
            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize += this.sizeIncrement();
        }
    }

    public void measureForUnSortedLinkedList(){
        //Linked로 구현한 List의 성능을 측정함
        @SuppressWarnings("unused")
        Coin maxCoin;

        long durationForAdd = 0, durationForMax = 0;
        long start, stop;

        int dataSize = this.firstSize();

        for(int iteration = 0; iteration < this.numberOfIteration(); iteration++){
            UnSortedLinkedList<Coin> list = new UnSortedLinkedList<Coin>();
            for(int i = 0;  i < dataSize; i++){
                //<ADD START>
                start = System.nanoTime();
                list.add(this.data()[i]);
                stop = System.nanoTime();
                durationForAdd += (stop - start);
                //<ADD END>

                //<MAX START>
                start = System.nanoTime();
                maxCoin = list.max();
                stop = System.nanoTime();
                durationForMax += (stop - start);
                //<MAX END>
            }
            this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
            dataSize += this.sizeIncrement();
        }
    }
}
