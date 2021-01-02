package experiment;

import model.FindClosestPair;
import model.PairOfPoints;
import model.Point;
import model.PointSet;

import java.util.Random;

public class ExperimentManager {
    // Constants
    private static final int MAX_COORDINATE_VALUE = 10000000;
    private static final int NUMBER_OF_KINDS_OF_EXPERIMENTS = 3;
    private static final int SIZE_FOR_CORRECTNESS_TEST = 10000;

    // Instance Variables
    private ParameterSet _parameterSet ;
    private FindClosestPair _findClosestPair ;
    private Experiment _experimentForComparingAllPairs ;
    private Experiment _experimentForDivideAndConquer ;
    private Experiment _experimentForHybrid ;


    private ParameterSet parameterSet() {
        return this._parameterSet;
    }

    private void setParameterSet(ParameterSet newParameterSet) {
        this._parameterSet = newParameterSet;
    }

    private FindClosestPair findClosestPair() {
        return this._findClosestPair;
    }

    private void setFindClosestPair(FindClosestPair newFindClosestPair) {
        this._findClosestPair = newFindClosestPair;
    }

    private Experiment experimentForComparingAllPairs() {
        return this._experimentForComparingAllPairs;
    }

    private void setExperimentForComparingAllPairs(Experiment newExperimentForComparingAllPairs) {
        this._experimentForComparingAllPairs = newExperimentForComparingAllPairs;
    }

    private Experiment experimentForDivideAndConquer() {
        return this._experimentForDivideAndConquer;
    }

    private void setExperimentForDivideAndConquer(Experiment newExperimentForDivideAndConquer) {
        this._experimentForDivideAndConquer = newExperimentForDivideAndConquer;
    }

    private Experiment experimentForHybrid() {
        return this._experimentForHybrid;
    }

    private void setExperimentForHybrid(Experiment newExperimentForHybrid) {
        this._experimentForHybrid = newExperimentForHybrid;
    }

    // Constructor
    public ExperimentManager (ParameterSet givenParameterSet)
    {
        this.setParameterSet ( givenParameterSet ) ;
        this.setFindClosestPair ( new FindClosestPair() ) ;
        this.findClosestPair().setMinRecursionSize (this.parameterSet().minRecursionSize() ) ;
        this.setExperimentForComparingAllPairs (
                new ExperimentForComparingAllPairs (this.findClosestPair(), givenParameterSet) ) ;
        this.setExperimentForDivideAndConquer (
                new ExperimentForDivideAndConquer (this.findClosestPair(), givenParameterSet) ) ;
        this.setExperimentForHybrid (
                new ExperimentForHybrid (this.findClosestPair(), givenParameterSet) ) ;
    }

    // Private Method
    private PointSet generatePointSet (int size) {
        PointSet pointSet = new PointSet(size) ;
        Random random = new Random() ;
        for ( int count = 0 ; count < size ; count++ ) {
            int x = random.nextInt (MAX_COORDINATE_VALUE) ;
            int y = random.nextInt (MAX_COORDINATE_VALUE) ;
            Point point = new Point (x, y) ;
            pointSet.add (point) ;
        }
        return pointSet ;
    }

    public long[][] measureDurationOfSingleSolve ()
    {
        long[][] measurement = new long
                [NUMBER_OF_KINDS_OF_EXPERIMENTS]
                [this.parameterSet().numberOfSteps()] ;
        int sizeForStep = this.parameterSet().startingSize() ;
        for ( int step = 0 ; step < this.parameterSet().numberOfSteps() ; step++ )
        {
            PointSet pointSet = this.generatePointSet (sizeForStep) ;
            measurement[0][step] =
                    this.experimentForComparingAllPairs().durationOfSingleSolve(pointSet) ;
            measurement[1][step] =
                    this.experimentForDivideAndConquer().durationOfSingleSolve(pointSet) ;
            measurement[2][step] =
                    this.experimentForHybrid().durationOfSingleSolve (pointSet) ;
            sizeForStep += this.parameterSet().incrementSize() ;
        }
        return measurement ;
    }
    public long[][] measureAverageDurationOfSingleSolves ()
    {
        long[][] measurement = new long
                [NUMBER_OF_KINDS_OF_EXPERIMENTS]
                [this.parameterSet().numberOfSteps()] ;
        int sizeForStep = this.parameterSet().startingSize() ;
        for ( int step = 0 ; step < this.parameterSet().numberOfSteps() ; step++ )
        {
            PointSet pointSet = this.generatePointSet(sizeForStep) ;
            measurement[0][step] =
                    this.experimentForComparingAllPairs().averageDurationOfSingleSolves (pointSet) ;
            measurement[1][step] =
                    this.experimentForDivideAndConquer().averageDurationOfSingleSolves (pointSet) ;
            measurement[2][step] =
                    this.experimentForHybrid().averageDurationOfSingleSolves(pointSet) ;
            sizeForStep += this.parameterSet().incrementSize() ;
        }
        return measurement ;
    }
    public long[][] measureMinDurationAmongSingleSolves ()
    {
        long[][] measurement = new long
                [NUMBER_OF_KINDS_OF_EXPERIMENTS]
                [this.parameterSet().numberOfSteps()] ;
        int sizeForStep = this.parameterSet().startingSize() ;
        for ( int step = 0 ; step < this.parameterSet().numberOfSteps() ; step++ )
        {
            PointSet pointSet = this.generatePointSet(sizeForStep) ;
            measurement[0][step] =
                    this.experimentForComparingAllPairs().minDurationAmongSingleSolves (pointSet) ;
            measurement[1][step] =
                    this.experimentForDivideAndConquer().minDurationAmongSingleSolves (pointSet) ;
            measurement[2][step] =
                    this.experimentForHybrid().minDurationAmongSingleSolves(pointSet) ;
            sizeForStep += this.parameterSet().incrementSize() ;
        }
        return measurement ;
    }
    public boolean closestPairAlgorithmsAreCorrect() {
        PointSet pointSet = this.generatePointSet (ExperimentManager.SIZE_FOR_CORRECTNESS_TEST) ;
        PairOfPoints closestPairByComparingAllPairs = this.findClosestPair().solveByComparingAllPairs (pointSet) ;
        PairOfPoints closestPairByDivideAndConquer = this.findClosestPair().solveByDivideAndConquer (pointSet) ;
        PairOfPoints closestPairByHybrid = this.findClosestPair().solveByHybrid(pointSet) ;
        return (( closestPairByComparingAllPairs.distance() == closestPairByDivideAndConquer.distance()) && ( closestPairByComparingAllPairs.distance() == closestPairByHybrid.distance() ) ) ;
    }
}