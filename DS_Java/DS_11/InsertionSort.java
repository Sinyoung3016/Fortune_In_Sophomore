package DS_11;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

    public InsertionSort(){}

    public boolean sort (T [] aList, int aSize){
        if((aSize < 1) || (aSize > aList.length)) return false;

        int minLoc = 0;
        for(int i = 1; i < aSize; i++){
            if (aList[i].compareTo(aList[minLoc]) < 0)
                minLoc = i;
        }//가장 작은 값의 위치

        this.swap(aList, 0, minLoc);
        //가장 작은 값을 맨 앞으로

        for(int i = 2; i < aSize; i++){
            T insertedElement = aList[i];
            int insertionLoc = i-1;
            while(aList[insertionLoc].compareTo(insertedElement) > 0){
                aList[insertionLoc+1] = aList[insertionLoc];
                insertionLoc--;
            }
            aList[insertionLoc+1] = insertedElement;
        }//end of for
        return true;
    }
}//end of class InsertionSort
