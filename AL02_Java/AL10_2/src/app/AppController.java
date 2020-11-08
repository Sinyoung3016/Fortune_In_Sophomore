package app;

import experiment.DataGenerator;
import sort.*;

public class AppController {
    private static final int TEST_SIZE = 10000;

    private static final QuickSort<Integer> QuickSortByLeft = new QuickSortByPivotLeft<Integer>(true);
    private static final QuickSort<Integer> QuickSortByMid = new QuickSortByPivotMid<Integer>(true);
    private static final QuickSort<Integer> QuickSortByMedian = new QuickSortByPivotMedian<Integer>(true);
    private static final QuickSort<Integer> QuickSortByRandom = new QuickSortByPivotRandom<Integer>(true);
    private static final QuickSort<Integer> QuickSortWithInsertionSort = new QuickSortWithInsertionSort<Integer>(true);

    private Integer[] _list;
    private String _listTypeName;

    private Integer[] list() {
        return this._list;
    }

    private void setList(Integer[] newList) {
        this._list = newList;
    }

    private String listTypeName() {
        return this._listTypeName;
    }

    private void setListTypeName(String newListTypeName) {
        this._listTypeName = newListTypeName;
    }
    private String sortingOrderName(Sort<Integer> aSort){
        if(aSort.nonDecreasingOrder()) return "오름차순";
        else return "내림차순";
    }
    private void outputValidationMessage(Sort<Integer> aSort,Integer[] aList){
        AppView.output("- ["+this.listTypeName()+"]에 대한 ["+this.sortingOrderName(aSort)+"]의 ["+aSort.getClass().getSimpleName()+"] 결과는 ");
        if(this.sortedListIsValid(aList,aSort.nonDecreasingOrder()))
            AppView.outputLine("올바릅니다.");
        else AppView.outputLine("잘못되었습니다.");
    }
    private Integer[] copyList(Integer[] aList){
        Integer[] copiedList = new Integer[aList.length];
        for(int i=0;i<aList.length;i++) copiedList[i] = aList[i];
        return copiedList;
    }
    private boolean sortedListIsValid(Integer[] aList,boolean nonDecreasing){
        if(nonDecreasing){
            for(int i=0;i<aList.length-1;i++)
                if(aList[i].compareTo(aList[i+1])>0) return false;
            return true;
        }
        else{
            for(int i=0;i<aList.length-1;i++)
                if(aList[i].compareTo(aList[i+1])<0) return false;
            return true;
        }
    }
    private void validateSort(Sort<Integer> aSort){
        Integer[] list = copyList(this.list());
        aSort.sort(list);
        this.outputValidationMessage(aSort,list);
    }
    private void validateSort(){
        this.validateSort(AppController.QuickSortByLeft);
        this.validateSort(AppController.QuickSortByMid);
        this.validateSort(AppController.QuickSortByMedian);
        this.validateSort(AppController.QuickSortByRandom);
        this.validateSort(AppController.QuickSortWithInsertionSort);
        AppView.outputLine("");
    }
    private void validateWithRandomList(){
        this.setListTypeName("무작위 리스트");
        this.setList(DataGenerator.randomList(AppController.TEST_SIZE));
        this.validateSort();
    }
    private void validateWithAscendingList(){
        this.setListTypeName("오름차순 리스트");
        this.setList(DataGenerator.ascendingList(AppController.TEST_SIZE));
        this.validateSort();
    }
    private void validateWithDescendingList(){
        this.setListTypeName("내림차순 리스트");
        this.setList(DataGenerator.descendingList(AppController.TEST_SIZE));
        this.validateSort();
    }
    private void setSortingOrder(boolean aNonDecreasing){
        AppController.QuickSortByLeft.setNonDecreasingOrder(aNonDecreasing);
        AppController.QuickSortByMid.setNonDecreasingOrder(aNonDecreasing);
        AppController.QuickSortByMedian.setNonDecreasingOrder(aNonDecreasing);
        AppController.QuickSortByRandom.setNonDecreasingOrder(aNonDecreasing);
        AppController.QuickSortWithInsertionSort.setNonDecreasingOrder(aNonDecreasing);
    }
    public void run(){
        AppView.outputLine("<<< 정렬 알고리즘들을 검증하는 프로그램을 시작합니다 >>>");
        AppView.outputLine("");

        AppView.outputLine("오름차순 정렬 프로그램의 검증:");
        this.setSortingOrder(true);
        this.validateWithRandomList();
        this.validateWithAscendingList();
        this.validateWithDescendingList();

        AppView.outputLine("내림차순 정렬 프로그램의 검증:");
        this.setSortingOrder(false);
        this.validateWithRandomList();
        this.validateWithAscendingList();
        this.validateWithDescendingList();

        AppView.outputLine("<<< 정렬 알고리즘들을 검증하는 프로그램을 종료합니다 >>>");
    }
}
