package DS_01;

public class Model_Board {
    private static int EMPTY_CELL = -1;
    private int _order;
    private int [][] _cell;

    public Model_Board(int givenOrder){
        this.setOrder(givenOrder);
        this.setCells(new int[givenOrder][givenOrder]);
        //모든칸을 을 -1로 채우기
        for(int row = 0; row < givenOrder; row++)
            for(int col =0; col < givenOrder; col++)
                this.setCellValue(row, col, Model_Board.EMPTY_CELL);

    }
    //차수를 얻음.
    public int order(){
        return this._order;
    }
    private void setOrder(int newOrder){
        this._order = newOrder;
    }

    private void setCells(int [][] newCells){
        this._cell = newCells;
    }

    public int cellValue (Model_CellLocation location){
        return this._cell [location.row()][location.col()];
    }
    public void setCellValue (Model_CellLocation location, int value){
        this._cell [location.row()][location.col()] = value;
    }
    //class 내부에서만 쓰이는 메소드
    private void setCellValue (int row, int col, int value){
        this._cell [row][col] = value;
    }
    //주어진 위치의 cell이 비어있는지 여부를 알려줌
    public boolean cellsEmpty (Model_CellLocation location){
        return (this.cellValue(location) == EMPTY_CELL);
    }
}
