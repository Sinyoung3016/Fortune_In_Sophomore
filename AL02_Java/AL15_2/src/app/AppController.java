package app;

import experiment.ExperimentManager;
import experiment.ParameterSet;
import model.FindClosestPair;
import model.PairOfPoints;
import model.Point;
import model.PointSet;
import view.AppView;

public class AppController {

    private static final int STARTING_SIZE = 1000 ;
    private static final int NUMBER_OF_STEPS = 10 ;
    private static final int INCREMENT_SIZE = 1000 ;
    private static final int NUMBER_OF_REPETITIONS_OF_SAME_EXECUTION = 50 ;
    private static final int MIN_RECURSION_SIZE = 1000 ;

    private PointSet _pointSet;
    private FindClosestPair _findClosestPair;
    private ExperimentManager _experimentManager ;
    private ParameterSet _parameterSet ;

    private void showMeasurement (long[][] measurement, String measurementTitle) {
        AppView.outputLine ("") ;
        AppView.outputLine ("<" + measurementTitle + " 측정> (단위: 마이크로 초)") ;
        AppView.outputLine (
                String.format ("%8s %20s %20s %20s %12s ",
                        "Size ",
                        "Compare-All-Pairs",
                        "Divide-And-Conquer",
                        "Hybrid (MinRS: " + MIN_RECURSION_SIZE + ")",
                        "Saving (%)")) ;
        int size = this.parameterSet().startingSize() ;
        for ( int step = 0 ; step < this.parameterSet().numberOfSteps() ; step++ ) {
            long durationByComparingAllPairs = measurement[0][step] ;
            long durationByDivideAndConquer = measurement[1][step] ;
            long durationByHybrid = measurement[2][step] ;
            double savingRatioByHybrid =
                    (double) (durationByDivideAndConquer - durationByHybrid) * 100.0
                            / (double) durationByDivideAndConquer ;
            AppView.outputLine(
                    String.format ("[%6d]%20d %20d %20d %12.0f " ,
                            size ,
                            durationByComparingAllPairs ,
                            durationByDivideAndConquer ,
                            durationByHybrid ,
                            savingRatioByHybrid
                    )
            ) ;
            size += this.parameterSet().incrementSize() ;
        }
    }

    private ExperimentManager experimentManager() {
        return this._experimentManager;
    }

    private void setExperimentManager(ExperimentManager newExperimentManager) {
        this._experimentManager = newExperimentManager;
    }

    private ParameterSet parameterSet() {
        return this._parameterSet;
    }

    public void setParameterSet(ParameterSet newParameterSet) {
        this._parameterSet = newParameterSet;
    }

    private PointSet pointSet() {
        return this._pointSet;
    }

    private void setPointSet(PointSet newPointSet) {
        this._pointSet = newPointSet;
    }

    private FindClosestPair findClosestPair() {
        return this._findClosestPair;
    }

    private void setFindClosestPair(FindClosestPair newFindClosetPair) {
        this._findClosestPair = newFindClosetPair;
    }
    private boolean doesContinueToSolve () {
        AppView.outputLine ("") ;
        AppView.output ("?? 문제를 풀려면 'Y' 또는 'y', 아니면 다른 아무거나 치시오: ") ;
        char answer = AppView.inputChar() ;
        return ( (answer == 'Y') || (answer == 'y') ) ;
    }
    private boolean inputPointSet () {
        int numberOfPoints = this.inputNumberOfPoints () ;
        this.setPointSet (new PointSet(numberOfPoints) ) ;
        for ( int count = 0 ; count < numberOfPoints ; count++ ) {
            Point point = this.inputPoint() ;
            if ( ! this.pointSet().add (point) ) {
                AppView.output ("[오류] 입력 받은 점을 점의 집합에 추가하기를 실패하였습니다.") ;
                return false ;
            }
        }
        return true ;
    }
    private int inputNumberOfPoints () {
        do {
            AppView.output ("? 점의 개수를 입력하시오: ") ;
            try {
                int numberOfPoints = AppView.inputInt() ;
                if ( numberOfPoints < 2 ) {
                    AppView.outputLine ("[오류] 점의 개수는 2 이상이어야 합니다.") ;
                }
                else {
                    return numberOfPoints ;
                }
            }
            catch (NumberFormatException e) {
                AppView.outputLine ("[오류] 올바른 숫자가 입력되지 않았습니다.") ;
            }
        } while (true) ;
    }
    private int inputCoordinateValue (String coordinateName) {
        do {
            AppView.output ("? " + coordinateName + " 좌표 값을 입력하시오: ") ;
            try {
                return AppView.inputInt() ;
            }
            catch (NumberFormatException e) {
                AppView.outputLine ("[오류] 올바른 숫자가 입력되지 않았습니다.") ;
            }
        } while (true) ;
    }

    private Point inputPoint () {
        Point point = new Point() ;
        AppView.outputLine ("") ;
        AppView.outputLine ("! 점의 (X, Y) 좌표를 차례로 입력해야 합니다: ") ;
        point.x = this.inputCoordinateValue ("X") ;
        point.y = this.inputCoordinateValue ("Y") ;
        return point ;
    }
    private void showPoint (Point point) {
        AppView.output ( "(" + point.x +", "+ point.y + ")" ) ;
    }

    private void showPointSet () {
        AppView.outputLine ("") ;
        AppView.outputLine ("! 점들의 집합입니다:") ;
        for ( int count = 0 ; count < this.pointSet().size() ; count++ ) {
            this.showPoint ( this.pointSet().elementAt(count) ) ;
            AppView.outputLine ("") ;
        }
    }

    private void showPairOfPoints (PairOfPoints pair) {
        AppView.output ("<") ;
        this.showPoint ( pair.firstPoint() ) ;
        AppView.output(", ") ;
        this.showPoint ( pair.secondPoint() ) ;
        AppView.output (">") ;
    }

    private void showClosestPair (PairOfPoints closestPair, String explanation ) {
        AppView.output ( "! " + explanation + ": " ) ;
        this.showPairOfPoints (closestPair) ;
        AppView.outputLine (
                String.format ( " Distance= %d", closestPair.distance() )
        ) ;
    }

    public void run () {
        AppView.outputLine ("") ;
        AppView.outputLine("<<< 최단거리 쌍 찾기 성능 측정을 시작합니다 >>>") ;
        if ( this.experimentManager().closestPairAlgorithmsAreCorrect() ) {
            long[][] measurementOfSingleSolve =
                    this.experimentManager().measureDurationOfSingleSolve() ;
            this.showMeasurement (measurementOfSingleSolve, "한번 실행") ;
            long[][] measurementOfAverageOfSingleSolves =
                    this.experimentManager().measureAverageDurationOfSingleSolves() ;
            this.showMeasurement (measurementOfAverageOfSingleSolves, "반복 실행의 평균") ;
            long[][] measurementOfMinOfSingleSolves =
                    this.experimentManager().measureMinDurationAmongSingleSolves() ;
            this.showMeasurement (measurementOfMinOfSingleSolves, "반복 실행 중 최소 시간") ;
        }
        else {
            AppView.outputLine ("! 현재 구현되어 있는 알고리즘이 올바로 작동하지 않습니다.") ;
        }
        AppView.outputLine ("") ;
        AppView.outputLine ("<<< 최단거리 쌍 찾기 성능 측정을 종료합니다 >>>") ;
    }

    public AppController(){
        this.setPointSet(null);
        this.setParameterSet (
                new ParameterSet(
                        AppController.NUMBER_OF_STEPS,
                        AppController.STARTING_SIZE,
                        AppController.INCREMENT_SIZE,
                        AppController.NUMBER_OF_REPETITIONS_OF_SAME_EXECUTION,
                        AppController.MIN_RECURSION_SIZE )
        ) ;
        this.setExperimentManager (new ExperimentManager( this.parameterSet() ) ) ;
        this.setFindClosestPair(new FindClosestPair());
    }
}