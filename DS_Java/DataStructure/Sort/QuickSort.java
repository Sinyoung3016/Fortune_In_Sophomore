package DataStructure.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    //Recursion
    /*원소들의 특정 값(Pivot)을 기준으로 두 부분으로 나누고,(partition)
    특정 값보다 작은 원소들을 왼쪽에 큰 원소들을 오른쪽에 오게 하고
    그 사이에 특정값이 놓이게 하는 것 = 오름차순 정렬
    quickSort하는 구간의 크기가 0또는 1일 경우, 탈출
    */

    public QuickSort(){}

    private int partition(T [] aList, int left, int right){
        //주어진 구간을 partition
        //피봇을 기준으로 왼쪽에는 작은 수, 오른 쪽에는 큰 수를 정렬
        int pivot = left;
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
