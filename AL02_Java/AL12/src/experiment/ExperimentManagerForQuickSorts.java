package experiment;

import app.AppView;
import sort.*;

public class ExperimentManagerForQuickSorts extends ExperimentManager {
    private static final boolean DEBUG_MODE = false;
    private static void showDebugMessage(String aMessage){
        if (DEBUG_MODE)
            AppView.outputDebugMessage(aMessage);
    }

    private static final QuickSortByPivotLeft<Integer> QuickSortByPivotLeft = new QuickSortByPivotLeft<Integer>(true);
    private static final QuickSortByPivotMid<Integer> QuickSortByPivotMid = new QuickSortByPivotMid<Integer>(true);
    private static final QuickSortByPivotMedian<Integer> QuickSortByPivotMedian = new QuickSortByPivotMedian<Integer>(true);
    private static final QuickSortByPivotRandom<Integer> QuickSortByPivotRandom = new QuickSortByPivotRandom<Integer>(true);
    private static final QuickSortWIthInsertionSort<Integer> QuickSortWithInsertionSort = new QuickSortWIthInsertionSort<Integer>(true);

    private long[] _measurementForQuickSortByPivotLeft;
    private long[] _measurementForQuickSortByPivotMid;
    private long[] _measurementForQuickSortByPivotMedian;
    private long[] _measurementForQuickSortByPivotRandom;
    private long[] _measurementForQuickSortWithInsertionSort;

    public long[] measurementForQuickSortByPivotLeft() {
        return _measurementForQuickSortByPivotLeft;
    }
    public void setMeasurementForQuickSortByPivotLeft(long[] _measurementForQuickSortByPivotLeft) {
        this._measurementForQuickSortByPivotLeft = _measurementForQuickSortByPivotLeft;
    }
    public long[] measurementForQuickSortByPivotMid() {
        return _measurementForQuickSortByPivotMid;
    }
    public void setMeasurementForQuickSortByPivotMid(long[] _measurementForQuickSortByPivotMid) {
        this._measurementForQuickSortByPivotMid = _measurementForQuickSortByPivotMid;
    }
    public long[] measurementForQuickSortByPivotMedian() {
        return _measurementForQuickSortByPivotMedian;
    }
    public void setMeasurementForQuickSortByPivotMedian(long[] _measurementForQuickSortByPivotMedian) {
        this._measurementForQuickSortByPivotMedian = _measurementForQuickSortByPivotMedian;
    }
    public long[] measurementForQuickSortByPivotRandom() {
        return _measurementForQuickSortByPivotRandom;
    }
    public void setMeasurementForQuickSortByPivotRandom(long[] _measurementForQuickSortByPivotRandom) {
        this._measurementForQuickSortByPivotRandom = _measurementForQuickSortByPivotRandom;
    }
    public long[] measurementForQuickSortWithInsertionSort() {
        return _measurementForQuickSortWithInsertionSort;
    }
    public void setMeasurementForQuickSortWithInsertionSort(long[] _measurementForQuickSortWithInsertionSort) {
        this._measurementForQuickSortWithInsertionSort = _measurementForQuickSortWithInsertionSort;
    }

    @Override
    protected void performMeasuring(ListOrder anOrder) {
        Integer[] list = this.dataSet().listWithOrder(anOrder);

        this.setMeasurementForQuickSortByPivotLeft(this.experiment().durationOfSort(ExperimentManagerForQuickSorts.QuickSortByPivotLeft, list));
        ExperimentManagerForQuickSorts.showDebugMessage("[Debug] end of QuickSortByPivotLeft\n");
        this.setMeasurementForQuickSortByPivotMid(this.experiment().durationOfSort(ExperimentManagerForQuickSorts.QuickSortByPivotMid, list));
        ExperimentManagerForQuickSorts.showDebugMessage("[Debug] end of QuickSortByPivotMid\n");
        this.setMeasurementForQuickSortByPivotMedian(this.experiment().durationOfSort(ExperimentManagerForQuickSorts.QuickSortByPivotMedian, list));
        ExperimentManagerForQuickSorts.showDebugMessage("[Debug] end of QuickSortByPivotMedian\n");
        this.setMeasurementForQuickSortByPivotRandom(this.experiment().durationOfSort(ExperimentManagerForQuickSorts.QuickSortByPivotRandom, list));
        ExperimentManagerForQuickSorts.showDebugMessage("[Debug] end of QuickSortByPivotRandom\n");
        this.setMeasurementForQuickSortWithInsertionSort(this.experiment().durationOfSort(ExperimentManagerForQuickSorts.QuickSortWithInsertionSort, list));
        ExperimentManagerForQuickSorts.showDebugMessage("[Debug] end of QuickSortWithInsertionSort\n");
    }

    public long measurementForQuickSortByPivotLeftAt(int anIndex){
        return this.measurementForQuickSortByPivotLeft()[anIndex];
    }
    public long measurementForQuickSortByPivotMidAt(int anIndex){
        return this.measurementForQuickSortByPivotMid()[anIndex];
    }
    public long measurementForQuickSortByPivotMedianAt(int anIndex){
        return this.measurementForQuickSortByPivotMedian()[anIndex];
    }
    public long measurementForQuickSortByPivotRandomAt(int anIndex){
        return this.measurementForQuickSortByPivotRandom()[anIndex];
    }
    public long measurementForQuickSortWithInsertionSortAt(int anIndex){
        return this.measurementForQuickSortWithInsertionSort()[anIndex];
    }
    public void performExperiment(ListOrder anOrder){
        this.performMeasuring(anOrder);
    }
}
