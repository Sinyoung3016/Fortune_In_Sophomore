package DS_06;

public class AppController {

    private Experiment _experiment;

    private Experiment experiment(){return this._experiment; }
    private void setExperiment( Experiment newExperiment){ this._experiment = newExperiment; }

    public AppController(){
        this.setExperiment(new Experiment());
        this.experiment().generateData(); //실험 객체에게 성능 측정에 사용할 데이터를 생성하게 함
    }

    public void run(){
        AppView.outputLine("<<<  리스트 성능 측정 프로그램을 시작합니다. >>>");
        AppView.outputLine("! 리스트의 구현에 따른 시간의 차이를 알아봅시다.(단위 : Micro Second)");

        AppView.outputLine("");
        AppView.outputLine("<Sorted ArrayList>");
        this.experiment().measureForSortedArrayList();//실험 객체에게 SortedArrayList에 대한 성능측정을 실행
        this.showExperimentResults();//실험 결과를 출력

        AppView.outputLine("");
        AppView.outputLine("<UnSorted ArrayList>");
        this.experiment().measureForUnSortedArrayList();//실험 객체에게 UnSortedArrayList에 대한 성능측정을 실행
        this.showExperimentResults();//실험 결과를 출력

        AppView.outputLine("");
        AppView.outputLine("<Sorted LinkedList>");
        this.experiment().measureForSortedLinkedList();//실험 객체에게 SortedLinkedList에 대한 성능측정을 실행
        this.showExperimentResults();//실험 결과를 출력

        AppView.outputLine("");
        AppView.outputLine("<UnSorted LinkedList>");
        this.experiment().measureForUnSortedLinkedList();//실험 객체에게 UnSortedLinkedList에 대한 성능측정을 실행
        this.showExperimentResults();//실험 결과를 출력

        AppView.outputLine("<<< 리스트 성능 측정 프로그램을 종료합니다. >>>");
    }

    private void showExperimentResults(){
        //결과를 출력하는 메소드
        MeasuredResult[] results = this.experiment().measuredResults();
        for(int i = 0; i < this.experiment().numberOfIteration(); i++){ //5
            AppView.outputResult(
                    results[i].size(),
                    results[i].durationForAdd()/1000, //Nano를 Micro로
                    results[i].durationForMax()/1000 //Nano를 Micro로
            );
        }
    }

}
