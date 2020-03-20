package DS_01;

public class Model_CellLocation {
    private static final int UndefinedIndex = -1;
    private int _row;
    private int _col;

    public Model_CellLocation(){
        this.setRow(UndefinedIndex);
        this.setCol(UndefinedIndex);
    };
    public Model_CellLocation(int givenRow, int givenCol){
        //주어진 좌표 (givenRow, givenCol)을 갖는 객체를 생성함.
        this.setRow(givenRow);
        this.setCol(givenCol);
    }
    //setter
    public void setRow(int newRow){
        this._row = newRow;
    }
    //getter
    public int row(){
        return this._row;
    }
    //setter
    public void setCol(int newCol){
        this._col = newCol;
    }
    //getter
    public int col(){
        return this._col;
    }
}
