package DS_01;

public class AppController {

    public static final int MIN_ORDER = 3;
    public static final int MAX_ORDER = 99;

    private Model_MagicSquare _magicSquare;

    public AppController() {
        this._magicSquare = new Model_MagicSquare(AppController.MAX_ORDER);
    }

    public void run() {
        AppView.outputLine("<<< 마방진 풀이를 시작합니다 >>>");
        AppView.outputLine("");
        //차수를 입력받음
        int currentOrder = AppView.inputOrder();
        Model_OrderValidity currentValidity = Model_OrderValidity.validityOf(currentOrder);
        //차수가 음수인지 검사(음수이면 종료)
        while (currentValidity != Model_OrderValidity.EndOfRun) {
            //차수가 유효한지 검사
            if (currentValidity == Model_OrderValidity.Valid) {
                AppView.outputTitleWithOrder(currentOrder);
                //객체에게 주어진 차수의 마방진을 풀게해 결과판을 얻음
                Model_Board solvedBoard = this._magicSquare.solve(currentOrder);
                //마방진을 화면에 보여줌
                this.showBoard(solvedBoard);
            } else {
                this.showOrderValidityErrorMessage(currentValidity);
            }
            //다른 마방진을 위해 차수를 입력받음.
            currentOrder = AppView.inputOrder();
            currentValidity = Model_OrderValidity.validityOf(currentOrder);
        }
        AppView.outputLine("");
        AppView.outputLine("<<<마방진 풀이를 종료합니다>>>");
    }

    private void showOrderValidityErrorMessage(Model_OrderValidity orderValidity){
        switch(orderValidity){
            case TooSmall :
                AppView.outputLine(
                        "[오류] 차수가 너무 작습니다." + AppController.MIN_ORDER + "보다 크거나 같아야 합니다."
                );
                break;
            case TooLarge :
                AppView.outputLine(
                        "[오류] 차수가 너무 큽니다." + AppController.MAX_ORDER + "보다 작거나 같아야 합니다."
                );
                break;
            case NotOddNumber :
                AppView.outputLine(
                        "[오류] 차수가 짝수입니다. 홀수이어야 합니다."
                );
                break;
            default:
                break;
        }
    }

    private void showBoard(Model_Board board){
        Model_CellLocation currentLoc = new Model_CellLocation();
        this.showTitleForColumnIndexes(board.order());
        for(int row = 0; row < board.order(); row++){
            AppView.outputRowNumber(row);
            for(int col = 0; col < board.order(); col++){
                currentLoc.setRow(row);
                currentLoc.setCol(col);
                AppView.outputCellValue(board.cellValue(currentLoc));
            }
            AppView.outputLine("");
        }
    }

    private void showTitleForColumnIndexes(int order){
        AppView.output("     ");
        for(int col = 0; col < order; col++) {
            AppView.output(String.format("[%3d]", col));
        }
        AppView.outputLine("");
    }

}
