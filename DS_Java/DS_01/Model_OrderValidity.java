package DS_01;

public enum Model_OrderValidity {
    EndOfRun,
    Valid,
    TooSmall,
    TooLarge,
    NotOddNumber;

    public static Model_OrderValidity validityOf(int order){
        if(order < 0) {
            return Model_OrderValidity.EndOfRun;
        }
        else if (order < AppController.MIN_ORDER){
            return Model_OrderValidity.TooSmall;
        }
        else if (order > AppController.MAX_ORDER){
            return Model_OrderValidity.TooLarge;
        }
        else if ((order % 2) == 0){
            return Model_OrderValidity.NotOddNumber;
        }
        else{
            return Model_OrderValidity.Valid;
        }
    }
}
