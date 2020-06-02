package DS_12;

public enum ListOrder {
    Ascending,  //오름차순 리스트
    Descending, //내림차순 리스트
    Random;     //무작위순서 리스트

    public static final String [] ORDER_NAMES = {"오름차순", "내림차순", "무작위"};

    public String orderName(){
        //각 값에 문자열 이름을 부여하여, Enum 값에 해당하는 문자열을 얻기 위함.
        return ListOrder.ORDER_NAMES[this.ordinal()];
        //ordinal() : 선언된 값의 이넘안에서의 순서를 정수로 얻을 수 있음.
        //Ascending.ordinal()은 0을 출력함.
    }

    //ListOrder order = ListOrder.Random;
    //AppView.outputLine(order.orderName());
}
