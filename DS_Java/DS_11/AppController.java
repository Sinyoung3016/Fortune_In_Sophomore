package DS_11;

public class AppController {
    private static final int TEST_SIZE = 10000;
    private static final int FIRST_PART_SIZE = 5;
    private static final InsertionSort<Integer>  INSERTION_SORT = new InsertionSort<>();
    private static final QuickSort<Integer> QUICK_SORT = new QuickSort<>();

    private Integer[] _list;
    private ListOrder _listOrder;

    //<GETTER SETTER START>
    private Integer[] list(){ return this._list; }
    private void setList(Integer [] newList){ this._list = newList; }
    private ListOrder listOrder(){ return this._listOrder; }
    private void setListOrder(ListOrder newListOrder){ this._listOrder = newListOrder; }
    //<GETTER SETTER END>

    public AppController(){}

    public void run(){
        AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 시작합니다 >>>");
        AppView.outputLine("");
        AppView.outputLine("> 정렬 결과의 검증 : ");
        AppView.outputLine("");
        this.validateWithAscendingList();
        this.validateWithDescendingList();
        this.validateWithRandomList();

        AppView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 종료합니다 >>>");
    }

    private void validateWithAscendingList(){
        this.setListOrder(ListOrder.Ascending);
        this.setList(DataGenerator.ascendingList(AppController.TEST_SIZE));
        this.showFirstPartOfDataList();
        this.validateSortsAndShowResult();
    }
    private void validateWithDescendingList(){
        this.setListOrder(ListOrder.Descending);
        this.setList(DataGenerator.descendingList(AppController.TEST_SIZE));
        this.showFirstPartOfDataList();
        this.validateSortsAndShowResult();
    }
    private void validateWithRandomList(){
        this.setListOrder(ListOrder.Random);
        this.setList(DataGenerator.randomList(AppController.TEST_SIZE));
        this.showFirstPartOfDataList();
        this.validateSortsAndShowResult();
    }

    private void showFirstPartOfDataList(){
        AppView.output("[" + this.listOrder().orderName() + " 리스트] 의 앞부분 : " );
        for(int i = 0; i < 5; i++)
            AppView.output( this.list()[i] + " ");
        AppView.outputLine("");
    }
    private void validateSortsAndShowResult(){
        this.validateSort(AppController.INSERTION_SORT);
        this.validateSort(AppController.QUICK_SORT);
        AppView.outputLine("");
    }
    private void validateSort(Sort<Integer> aSort){
        Integer [] list = this.copyList(this.list());
        aSort.sort(list, list.length);
        this.showValidationMessage(aSort, list);
    }

    private Integer[] copyList (Integer[] aList){
        Integer [] copiedList = new Integer[aList.length];
        for(int i = 0; i <  aList.length; i++)
            copiedList[i] = aList[i];
        return copiedList;
    }

    private boolean sortedListIsValid(Integer[] aList){
        //해당 리스트가 오름차순인가요
        int n = aList.length;
        for(int i = 0; i < (n - 1); i++){
            if(aList[i].compareTo(aList[i+1]) > 0)
                return false;
        }
        return true;
    }

    private void showValidationMessage(Sort<Integer> aSort, Integer[] aList){
        AppView.output(
                "[" + this.listOrder().orderName() + " 리스트]를 ["
        + aSort.getClass().getSimpleName() + "] 한 결과는 ");
        if(this.sortedListIsValid(aList)){
            AppView.outputLine("올바릅니다.");
        }
        else{
            AppView.outputLine("올바르지 않습니다.");
        }
    }

} //End of class 'AppController'
