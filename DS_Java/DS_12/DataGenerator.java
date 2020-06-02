package DS_12;
import java.util.Random;
//실험에 필요한 매개변수 값들을 보관
public final class DataGenerator {
    //Static class : static으로 구성된 상수, 변수, 메소드만 존재, 객체 인스턴스 없음.
    //final을 class 이름 앞에 선언

    private DataGenerator(){}
    //private으로 객체 생성을 막음
    //모든 공개함수는 static

    public static Integer[] ascendingList (int aSize){
        Integer [] list = null;
        if(aSize > 0){
            list = new Integer[aSize];
            for(int i = 0; i < aSize; i++)
                list[i] = i;
        }
        return list;
    }
    public static Integer[] descendingList (int aSize){
        Integer [] list = null;
        if(aSize > 0){
            list = new Integer[aSize];
            for(int i = 0; i < aSize; i++)
                list[i] = (aSize - i);
        }
        return list;
    }
    public static Integer[] randomList(int aSize){
        Integer [] list = null;
        if(aSize > 0){
            list = new Integer[aSize];
            for(int i = 0;i < aSize; i++)
                list[i] = i;
        }
        //Ascending order list

        Random random = new Random();
        for(int i = 0; i < aSize; i++){
            int r = random.nextInt(aSize);
            Integer temp = list[i];
            list[i] = list[r];
            list[r] = temp;
        }
        return list;
    }

}//end of class DataGenerator
