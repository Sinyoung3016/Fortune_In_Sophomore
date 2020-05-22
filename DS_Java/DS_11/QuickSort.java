package DS_11;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    public QuickSort(){}

    private int pivot (T [] aList, int left, int right){
        //피봇의 위치를 결정
        return left;
    }
    private int partition(T [] aList, int left, int right){
        //주어진 구간을 partition
        //피봇을 기준으로 왼쪽에는 작은 수, 오른 쪽에는 큰 수를 정렬
        int pivot = this.pivot(aList, left, right);
        int toRight = left;
        int toLeft = right+1;
        do{
          do{
              toRight++;
          }while(aList[toRight].compareTo(aList[pivot]) < 0);
          do{
              toLeft--;
          }while(aList[toLeft].compareTo(aList[pivot]) > 0);
          if(toRight < toLeft) swap(aList, toRight, toLeft);
        }while(toRight < toLeft);

        swap(aList, pivot, toLeft);
        return toLeft;
    }
    private void quickSortRecursively(T [] aList, int left, int right){
        if (left < right) { //탈출조건
            int mid = partition(aList, left, right); //DIVIDE
            quickSortRecursively(aList, left, mid-1); //CONQUER
            quickSortRecursively(aList, mid+1, right); //CONQUER
        }
    }

    public boolean sort(T [] aList, int aSize){
        if((aSize < 1) || (aSize > aList.length)) return false;
        int maxLoc = 0;
        for(int i = 1; i < aSize; i++){
            if (aList[i].compareTo(aList[maxLoc]) > 0)
                maxLoc = i;
        }//가장 큰 값의 위치
        this.swap(aList, maxLoc, aSize-1);

        this.quickSortRecursively(aList,0,aSize-2);
        return true;
    }
}//end of class QuickSort
