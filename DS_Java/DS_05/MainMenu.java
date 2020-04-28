package DS_05;

public enum MainMenu {
    //ordinal()은 선언된 순서를 불러옴
    //values()는 이넘클래스의 모든 enum값을 순서대로 배열로 만들어 줌.
    Error, //0
    DoesContain, //1
    ElementAt, //2
    First, //3
    Last, //4
    OrderOf, //5
    AddTo, //6
    AddToFirst, //7
    AddToLast, //8
    Add, //9
    RemoveFrom, //10
    RemoveFirst, //11
    RemoveLast, //12
    RemoveAny, //13
    ReplaceAt, //14
    EndOfRun; //99

    public static final int END_OF_RUN = 99;

    public static MainMenu value(int menuNumber){
        //해당 이넘클래스의 이넘을 이용한 배열의 인덱스를 가진 원소 출력
        if(menuNumber == END_OF_RUN)
            return MainMenu.EndOfRun;
        else if(menuNumber < DoesContain.ordinal() || menuNumber > ReplaceAt.ordinal())
            return MainMenu.Error;
        else return MainMenu.values()[menuNumber];
    }
}
