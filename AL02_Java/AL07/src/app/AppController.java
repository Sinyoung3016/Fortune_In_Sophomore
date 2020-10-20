package app;

import graph.*;
import shortestPaths.*;
import list.*;

public class AppController {

    private AdjacencyGraph<WeightedEdge> graph;
    private ShortestPaths<WeightedEdge> shortestPaths;

    private AdjacencyGraph<WeightedEdge> graph(){
        return this.graph;
    }
    private void setGraph(AdjacencyGraph<WeightedEdge> newGraph){
        this.graph = newGraph;
    }
    public ShortestPaths<WeightedEdge> shortestPaths() { return shortestPaths; }
    public void setShortestPaths(ShortestPaths<WeightedEdge> shortestPaths) { this.shortestPaths = shortestPaths; }

    public AppController(){
        this.setGraph(null);
        this.setShortestPaths(new ShortestPaths<WeightedEdge>());
    }

    private int inputSourceVertex(){
        int sourceVertex = AppView.inputSourceVertex();
        while(!this.graph().vertexDoesExist(sourceVertex)){
            AppView.outputLine("[오류] 입력된 출발 vertex는 존재하지 않습니다 : " + sourceVertex);
            sourceVertex = AppView.inputSourceVertex();
        }
        return sourceVertex;
    }

    private void inputAndMakeGraph(){
        AppView.outputLine("> 입력할 그래프의 vertex 수와 edge 수를 먼저 입력해야 합니다. : ");
        int numberOfVertices = this.inputNumberOfVertices();
        this.setGraph(new WeightedDirectedAdjacencyListGraph(numberOfVertices));

        int numberOfEdges = this.inputNumberOfEdges();
        AppView.outputLine("");
        AppView.outputLine("> 이제부터 edge 를 주어진 수만큼 입력합니다.");

        int edgeCount = 0;
        while(edgeCount < numberOfEdges){
            WeightedEdge edge = this.inputEdge();
            if(this.graph().edgeDoesExist(edge))
                AppView.outputLine("(오류) 입력된 edge (" + edge.tailVertex() + " ," + edge.headVertex() + " ,(" + edge.weight() + ")) 는 이미 그래프에 존재합니다.");
            else{
                edgeCount++;
                this.graph().addEdge(edge);
                AppView.outputLine("! 새로운 edge (" + edge.tailVertex() + " ," + edge.headVertex() + " ,(" + edge.weight() + ")) 가 삽입되었습니다.");
            }
        }
    }

    private int inputNumberOfVertices(){
        while(true){
            AppView.output(">> Vertex 수를 입력하시오 : ");
            try{
                int numberOfVertices = AppView.inputInt();
                if(numberOfVertices < 2)
                    AppView.outputLine("[오류] Vertex 수는 1보다 커야 합니다.");
                else return numberOfVertices;
            }
            catch(NumberFormatException e){
                AppView.outputLine("[오류] 올바른 숫자가 입력되지 않았습니다.");
            }
        }
    }

    private int inputNumberOfEdges(){
        while(true){
            AppView.output(">> Edge 수를 입력하시오 : ");
            try{
                int numberOfEdges = AppView.inputInt();
                if(numberOfEdges < 1)
                    AppView.outputLine("[오류] Edge 수는 0보다 커야 합니다.");
                else return numberOfEdges;
            }
            catch(NumberFormatException e){
                AppView.outputLine("[오류] 올바른 숫자가 입력되지 않았습니다.");
            }
        }
    }

    private WeightedEdge inputEdge(){
        do{
            AppView.outputLine("> 입력할 edge의 두 vertex와 cost를 차례로 입력해야 합니다. : ");
            int tailVertex = AppView.inputTailVertex();
            int headVertex = AppView.inputHeadVertex();
            int cost = AppView.inputCost();
            if(this.graph().vertexDoesExist(tailVertex) && this.graph().vertexDoesExist(headVertex)){
                if(tailVertex == headVertex)
                    AppView.outputLine("[오류] 두 vertex 번호가 동일합니다.");
                else
                    return new WeightedEdge(tailVertex,headVertex, cost);
            }else{
                if(! this.graph().vertexDoesExist(tailVertex))
                    AppView.outputLine("[오류] 존재하지 않는 tail vertex 입니다. : " +  tailVertex);
                if(! this.graph().vertexDoesExist(headVertex))
                    AppView.outputLine("[오류] 존재하지 않는 head vertex 입니다. : " +  headVertex);
                if(cost < 0)
                    AppView.outputLine("[오류] edge의 비용은 양수여야 합니다. : " + cost);
            }
        }while(true);
    }

    private void showGraph(){
        AppView.outputLine("");
        AppView.outputLine("> 입력된 그래프는 다음과 같습니다. : ");
        for(int tailVertex = 0; tailVertex <  this.graph().numberOfVertices(); tailVertex++){
            AppView.output("[" + tailVertex + "] ->");
            Iterator<WeightedEdge> neighborIterator = this.graph().neighborIteratorOf(tailVertex);
            while(neighborIterator.hasNext()){
                WeightedEdge nextEdge = neighborIterator.next();
                AppView.output(" " +  nextEdge.headVertex());
                AppView.output("(" + nextEdge.weight() + ")");
            }
            AppView.outputLine("");
        }
    }

    private void solveAndShowShortestPaths(){
        AppView.outputLine("");
        AppView.outputLine("> 주어진 그래프에서 최단 경로를 찾습니다 : ");
        if(this.graph().numberOfVertices() <= 1)
            AppView.outputLine("[오류] vertex 수 (" + this.graph().numberOfVertices() + ")가 너무 적어서, 최단 경로 찾기를 하지 않습니다. 2개 이상이어야 합니다.");
        else {
            AppView.outputLine("> 출발점을 입력해야 합니다.");
            int sourceVertex = this.inputSourceVertex();
            if(this.shortestPaths().solve(this.graph(), sourceVertex)){
                AppView.outputLine("");
                AppView.outputLine("> 최단 경로별 비용과 경로는 다음과 같습니다.");
                AppView.outputLine("출발점 = " + sourceVertex + " : ");
                for(int destination = 0; destination < this.graph().numberOfVertices(); destination++){
                    if(destination != sourceVertex) {
                        AppView.output("    [목적점 = " + destination + "] ");
                        AppView.output("최소비용 = " + this.shortestPaths().minCostPfPathDestination(destination) + ", ");
                        AppView.output("경로 : ");
                        LinkedStack<Integer> pathToDestination = this.shortestPaths().pathToDestination(destination);
                        LinkedStack<Integer>.IteratorForLinkedStack iterator = pathToDestination.iterator();
                        while (iterator.hasNext())
                            AppView.output(" -> " + iterator.next());
                        AppView.outputLine("");
                    }
                }
            }else{
                AppView.outputLine("[오류] 최단거리 찾기를 실패하였습니다.");
            }
        }
    }

    public void run(){
        AppView.outputLine("<<< 최단 경로 찾기 프로그램을 시작합니다 >>>");
        this.inputAndMakeGraph();
        this.showGraph();

        this.solveAndShowShortestPaths();
        AppView.outputLine("");
        AppView.outputLine("<<< 최단 경로 찾기 프로그램을 종료합니다 >>>");
    }

}
