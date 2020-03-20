package DS_01;

public class Model_MagicSquare {
    private static final int DEFAULT_MAX_ORDER = 99;
    private int _maxOrder;

    //setter
    public int maxOrder() {
        //마방진의 현 상태의 최대차수를 얻을때
        return this._maxOrder;
    }

    //getter
    private void setMaxOrder(int newMaxOrder) {
        this._maxOrder = newMaxOrder;
    }

    //기본생성자
    public Model_MagicSquare() {
        this.setMaxOrder(Model_MagicSquare.DEFAULT_MAX_ORDER);
    }

    //최대차수를 사용자가 지정하는 생성자
    public Model_MagicSquare(int givenMaxOrder) {
        this.setMaxOrder(givenMaxOrder);
    }

    public Model_Board solve(int anOrder) {
        //
        if (Model_OrderValidity.validityOf(anOrder) != Model_OrderValidity.Valid) {
            return null;
        } else {
            Model_Board board = new Model_Board(anOrder);
            //출발위치(Board 맨윗줄 한가운데)이 현재위치
            Model_CellLocation currentLoc = new Model_CellLocation(0, anOrder / 2);
            Model_CellLocation nextLoc = new Model_CellLocation();

            board.setCellValue(currentLoc, 1);

            int lastValue = anOrder * anOrder;
            for (int cellValue = 2; cellValue <= lastValue; cellValue++) {
                int r = (currentLoc.row() + anOrder - 1) % anOrder;
                int c = (currentLoc.col() + 1) % anOrder;
                nextLoc = new Model_CellLocation(r, c);
                if (!board.cellsEmpty(nextLoc)) {
                    nextLoc.setRow((currentLoc.row()+1) % anOrder);
                    nextLoc.setCol(currentLoc.col());
                }
                currentLoc.setRow(nextLoc.row());
                currentLoc.setCol(nextLoc.col());
                board.setCellValue(currentLoc, cellValue);
            }
            return board;
        }
    }
}