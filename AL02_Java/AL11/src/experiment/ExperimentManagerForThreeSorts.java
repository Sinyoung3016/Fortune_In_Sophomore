package experiment;

import app.AppView;
import sort.QuickSort;
import sort.InsertionSort;
import sort.HeapSort;
public class ExperimentManagerForThreeSorts extends ExperimentManager {
    private static final boolean DEBUG_MODE = false;
    private static void showDebugMessage(String aMessage){
        if(DEBUG_MODE){
            AppView.outputDebugMessage(aMessage);
        }
    }
    private static final InsertionSort<Integer> InsertionSort = new InsertionSort<Integer>(true);
    private static final sort.QuickSort<Integer> QuickSort = new QuickSort<Integer>(true);
    private static final HeapSort<Integer> HeapSort = new HeapSort<Integer>(true);

    private long[] _measurementForInsertionSort;
    private long[] _measurementForQuickSort;
    private long[] _measurementForHeapSort;

    private long[] _estimationForInsertionSort;
    private long[] _estimationForQuickSort;
    private long[] _estimationForHeapSort;

    private long[] measurementForInsertionSort() {
        return this._measurementForInsertionSort;
    }
    private void setMeasurementForInsertionSort(long[] newMeasurementForInsertionSort) {
        this._measurementForInsertionSort = newMeasurementForInsertionSort;
    }
    private long[] measurementForQuickSort() {
        return this._measurementForQuickSort;
    }
    private void setMeasurementForQuickSort(long[] newMeasurementForQuickSort) {
        this._measurementForQuickSort = newMeasurementForQuickSort;
    }
    private long[] measurementForHeapSort() {
        return this._measurementForHeapSort;
    }
    private void setMeasurementForHeapSort(long[] newMeasurementForHeapSort) {
        this._measurementForHeapSort = newMeasurementForHeapSort;
    }
    private long[] estimationForInsertionSort() {
        return this._estimationForInsertionSort;
    }
    private void setEstimationForInsertionSort(long[] newEstimationForInsertionSort) {
        this._estimationForInsertionSort = newEstimationForInsertionSort;
    }
    private long[] estimationForQuickSort() {
        return this._estimationForQuickSort;
    }
    private void setEstimationForQuickSort(long[] newEstimationForQuickSort) {
        this._estimationForQuickSort = newEstimationForQuickSort;
    }
    private long[] estimationForHeapSort() {
        return this._estimationForHeapSort;
    }
    private void setEstimationForHeapSort(long[] newEstimationForHeapSort) {
        this._estimationForHeapSort = newEstimationForHeapSort;
    }

    public long measurementForInsertionSortAt(int anIndex){
        return this.measurementForInsertionSort()[anIndex];
    }
    public long measurementForQuickSortAt(int anIndex){
        return this.measurementForQuickSort()[anIndex];
    }
    public long measurementForHeapSortAt(int anIndex){
        return this.measurementForHeapSort()[anIndex];
    }
    public long estimationForInsertionSortAt(int anIndex){
        return this.estimationForInsertionSort()[anIndex];
    }
    public long estimationForQuickSortAt(int anIndex){
        return this.estimationForQuickSort()[anIndex];
    }
    public long estimationForHeapSortAt(int anIndex){
        return this.estimationForHeapSort()[anIndex];
    }

    @Override
    protected void performMeasuring(ListOrder anOrder){
        Integer[] experimentList = this.dataSet().listWithOrder(anOrder);

        this.setMeasurementForInsertionSort(this.experiment().durationOfSort(ExperimentManagerForThreeSorts.InsertionSort,experimentList));
        ExperimentManagerForThreeSorts.showDebugMessage("[Debug] end of Insertion Sort\n");
        this.setMeasurementForQuickSort(this.experiment().durationOfSort(ExperimentManagerForThreeSorts.QuickSort,experimentList));
        ExperimentManagerForThreeSorts.showDebugMessage("[Debug] end of Quick Sort\n");
        this.setMeasurementForHeapSort(this.experiment().durationOfSort(ExperimentManagerForThreeSorts.HeapSort,experimentList));
        ExperimentManagerForThreeSorts.showDebugMessage("[Debug] end of Heap Sort\n");
    }
    private void estimateForRandomList(){
        this.setEstimationForInsertionSort(Estimation.estimateByQuadratic(this.measurementForInsertionSort(),this.parameterSetForMeasurement()));
        this.setEstimationForQuickSort(Estimation.estimateByNLogN(this.measurementForQuickSort(),this.parameterSetForMeasurement()));
        this.setEstimationForHeapSort(Estimation.estimateByNLogN(this.measurementForHeapSort(),this.parameterSetForMeasurement()));
    }
    private void estimateForAscendingList(){
        this.setEstimationForInsertionSort(Estimation.estimateByLinear(this.measurementForInsertionSort(),this.parameterSetForMeasurement()));
        this.setEstimationForQuickSort(Estimation.estimateByQuadratic(this.measurementForQuickSort(),this.parameterSetForMeasurement()));
        this.setEstimationForHeapSort(Estimation.estimateByNLogN(this.measurementForHeapSort(),this.parameterSetForMeasurement()));
    }
    private void estimateForDescendingList(){
        this.setEstimationForInsertionSort(Estimation.estimateByQuadratic(this.measurementForInsertionSort(),this.parameterSetForMeasurement()));
        this.setEstimationForQuickSort(Estimation.estimateByQuadratic(this.measurementForQuickSort(),this.parameterSetForMeasurement()));
        this.setEstimationForHeapSort(Estimation.estimateByNLogN(this.measurementForHeapSort(),this.parameterSetForMeasurement()));
    }
    @Override
    public void performExperiment(ListOrder anOrder){
        this.performMeasuring(anOrder);
        if(anOrder.equals(ListOrder.Random))
            this.estimateForRandomList();
        else if(anOrder.equals(ListOrder.Ascending))
            this.estimateForAscendingList();
        else this.estimateForDescendingList();
    }
}
