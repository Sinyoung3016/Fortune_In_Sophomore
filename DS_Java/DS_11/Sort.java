package DS_11;

public abstract class Sort <T>{
    //private으로 선언하면 상속 X : 변수, 생성자, 메소드
    //protected으로 선언하면 상속 O : 생성자, 메소드
    //public : 메소드

    protected Sort(){}

    protected void swap(T [] aList, int i, int j){
        T tempElement = aList[i];
        aList[i] = aList[j];
        aList[j] = tempElement;
    }

    public abstract boolean sort(T [] aList, int aSize);
}//end of class Sort
