package experiment;

import app.AppView;
import sort.HeapSort;
import sort.InsertionSort;
import sort.QuickSortByPivotLeft;

public class ExperimentManagerForThreeSorts extends ExperimentManager {

    private static final boolean DEBUG_MODE = false;
    private static void showDebugMessage(String aMessage){
        if (DEBUG_MODE)
            AppView.outputDebugMessage(aMessage);
    }

    private static final InsertionSort<Integer> InsertionSort = new InsertionSort<Integer>(true);
    private static final QuickSortByPivotLeft<Integer> QuickSort = new QuickSortByPivotLeft<Integer>(true);
    private static final HeapSort<Integer> HeapSort = new HeapSort<Integer>(true);

    private long[] _measurementForInsertionSort;
    private long[] _measurementForQuickSort;
    private long[] _measurementForHeapSort;

    private long[] _estimationForInsertionSort;
    private long[] _estimationForQuickSort;
    private long[] _estimationForHeapSort;

    public void setMeasurementForInsertionSort(long[] _measurementForInsertionSort) {
        this._measurementForInsertionSort = _measurementForInsertionSort;
    }
    public long[] measurementForQuickSort() {
        return _measurementForQuickSort;
    }
    public void setMeasurementForQuickSort(long[] _measurementForQuickSort) {
        this._measurementForQuickSort = _measurementForQuickSort;
    }
    public long[] measurementForHeapSort() {
        return _measurementForHeapSort;
    }
    public void setMeasurementForHeapSort(long[] _measurementForHeapSort) {
        this._measurementForHeapSort = _measurementForHeapSort;
    }
    public long[] estimationForInsertionSort() {
        return _estimationForInsertionSort;
    }
    public void setEstimationForInsertionSort(long[] _estimationForInsertionSort) {
        this._estimationForInsertionSort = _estimationForInsertionSort;
    }
    public long[] estimationForQuickSort() {
        return _estimationForQuickSort;
    }
    public void setEstimationForQuickSort(long[] _estimationForQuickSort) {
        this._estimationForQuickSort = _estimationForQuickSort;
    }
    public long[] estimationForHeapSort() {
        return _estimationForHeapSort;
    }
    public void setEstimationForHeapSort(long[] _estimationForHeapSort) {
        this._estimationForHeapSort = _estimationForHeapSort;
    }
    private long[] measurementForInsertionSort(){
        return this._measurementForInsertionSort;
    }

    @Override
    protected void performMeasuring(ListOrder anOrder) {
        Integer[] experimentList = this.dataSet().listWithOrder(anOrder);

        this.setMeasurementForInsertionSort(this.experiment().durationOfSort(ExperimentManagerForThreeSorts.InsertionSort, experimentList));
        ExperimentManagerForThreeSorts.showDebugMessage("[Debug] end of Insertion Sort\n");
        this.setMeasurementForQuickSort(this.experiment().durationOfSort(ExperimentManagerForThreeSorts.QuickSort, experimentList));
        ExperimentManagerForThreeSorts.showDebugMessage("[Debug] end of Quick Sort\n");
        this.setMeasurementForHeapSort(this.experiment().durationOfSort(ExperimentManagerForThreeSorts.HeapSort, experimentList));
        ExperimentManagerForThreeSorts.showDebugMessage("[Debug] end of Heap Sort\n");
    }

    private void estimateForRandomList(){
        this.setEstimationForInsertionSort(Estimation.estimateByQuadratic(this.measurementForInsertionSort(), this.parameterSetForMeasurement()));
        this.setEstimationForQuickSort(Estimation.estimateByNLogN(this.measurementForQuickSort(), this.parameterSetForMeasurement()));
        this.setEstimationForHeapSort(Estimation.estimateByNLogN(this.measurementForHeapSort(), this.parameterSetForMeasurement()));
    }
    private void estimatedForAscendingList(){
        this.setEstimationForInsertionSort(Estimation.estimateByQuadratic(this.measurementForInsertionSort(), this.parameterSetForMeasurement()));
        this.setEstimationForQuickSort(Estimation.estimateByQuadratic(this.measurementForQuickSort(), this.parameterSetForMeasurement()));
        this.setEstimationForHeapSort(Estimation.estimateByNLogN(this.measurementForHeapSort(), this.parameterSetForMeasurement()));
    }
    private void estimateForDescendingList(){
        this.setEstimationForInsertionSort(Estimation.estimateByQuadratic(this.measurementForInsertionSort(), this.parameterSetForMeasurement()));
        this.setEstimationForQuickSort(Estimation.estimateByQuadratic(this.measurementForQuickSort(), this.parameterSetForMeasurement()));
        this.setEstimationForHeapSort(Estimation.estimateByNLogN(this.measurementForHeapSort(), this.parameterSetForMeasurement()));
    }

    @Override
    public void performExperiment(ListOrder anOrder) {
        this.performMeasuring(anOrder);
        if (anOrder.equals(ListOrder.Random))
            this.estimateForRandomList();
        else if(anOrder.equals(ListOrder.Ascending))
            this.estimatedForAscendingList();
        else
            this.estimateForDescendingList();
    }

    public long measurementForInsertionSorAt(int anIndex){
        return this.measurementForInsertionSort()[anIndex];
    }
    public long measurementForQuickSortAt(int anIndex){
        return this.measurementForQuickSort()[anIndex];
    }
    public long measurementForHeapSortAt(int anIndex){
        return this.measurementForHeapSort()[anIndex];
    }
    public long estimatedForInsertionSortAt(int anIndex){
        return this.estimationForInsertionSort()[anIndex];
    }
    public long estimatedForQuickSortAt(int anIndex){
        return this.estimationForQuickSort()[anIndex];
    }
    public long estimatedForHeapSortAt(int anIndex){
        return this.estimationForHeapSort()[anIndex];
    }
}
