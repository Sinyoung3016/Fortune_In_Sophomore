package model;
import list.ArrayList;
public class PointSet extends ArrayList<Point>{
    public PointSet(int givenCapacity){
        super(givenCapacity);
    }
    public Point pointReferencedByIndex (ReferenceList referenceList, int index) {
        if ( referenceList.orderIsValid (index) ) {
            return this.elementAt ( referenceList.elementAt (index) ) ;
        }
        else return null;
    }
}
