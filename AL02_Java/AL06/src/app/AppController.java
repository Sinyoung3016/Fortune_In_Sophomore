package app;

import graph.*;
import kruskal.*;
import list.*;

public class AppController {

    private WeightedUndirectedAdjacencyMatrixGraph graph;
    private MinCostSpanningTree minCostSpanningTree;
    private List<WeightedEdge> spanningTreeEdgeList;

    private MinCostSpanningTree minCostSpanningTree() { return minCostSpanningTree; }
    private void setMinCostSpanningTree(MinCostSpanningTree minCostSpanningTree) { this.minCostSpanningTree = minCostSpanningTree; }
    private List<WeightedEdge> spanningTreeEdgeList() { return spanningTreeEdgeList; }
    private void setSpanningTreeEdgeList(List<WeightedEdge> spanningTreeEdgeList) { this.spanningTreeEdgeList = spanningTreeEdgeList; }

    private WeightedUndirectedAdjacencyMatrixGraph graph(){
        return this.graph;
    }
    private void  setGraph(WeightedUndirectedAdjacencyMatrixGraph newGraph){
        this.graph = newGraph;
    }

    public AppController(){
        this.setGraph(null);
        this.setMinCostSpanningTree(null);
        this.setSpanningTreeEdgeList(null);
    }

    private void inputAndMakeGraph(){
        AppView.outputLine("> 입력할 그래프의 vertex 수와 edge 수를 먼저 입력해야 합니다. : ");
        int numberOfVertices = this.inputNumberOfVertices();
        this.setGraph(new WeightedUndirectedAdjacencyMatrixGraph(numberOfVertices));

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
            for(int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++){
                if(this.graph().edgeDoesExist(tailVertex, headVertex)) {
                    AppView.output(" " + headVertex);
                    AppView.output("(" + this.graph().weightOfEdge(tailVertex, headVertex) + ")");
                }
            }
            AppView.outputLine("");
        }
        AppView.outputLine("");
        AppView.outputLine("> 입력학 그래프의 Adjacency Matrix는 다음과 같다. : ");
        AppView.output("       ");
        for(int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++)
            AppView.output(String.format("  [%1s]", headVertex));

        AppView.outputLine("");
        for(int tailVertex = 0; tailVertex < this.graph().numberOfVertices(); tailVertex++){
            AppView.output("["+tailVertex+"] ->");
            for(int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++){
                int weight = this.graph().weightOfEdge(tailVertex, headVertex);
                AppView.output(String.format(" %4d", weight));
            }
            AppView.outputLine("");
        }
    }

    private void showMinCostSpanningTree(){
        AppView.outputLine("");
        AppView.outputLine("> 주어진 그래프의 최소비용 확장트리의 edge들을 다음과 같습니다 : ");
        Iterator<WeightedEdge> listIterator = this.spanningTreeEdgeList().listIterator();
        while(listIterator.hasNext()){
            WeightedEdge edge = listIterator.next();
            AppView.outputLine("Tree Edge (" + edge.tailVertex() + ", " + edge.headVertex() + ")(" + edge.weight() + ")");
        }
    }

    public void run(){
        AppView.outputLine("<<< 최소비용 확장 트리 찾기를 시작합니다 >>>");
        this.inputAndMakeGraph();
        this.showGraph();

        AppView.outputLine("");
        AppView.outputLine("> 주어진 그래프의 최소비용 확장트리 찾기를 시작합니다 :");
        AppView.outputLine("");
        this.setMinCostSpanningTree(new MinCostSpanningTree());
        this.setSpanningTreeEdgeList(this.minCostSpanningTree().solve(this.graph));
        if(this.spanningTreeEdgeList() == null)
            AppView.outputLine("> 주어진 그래프의 컴포넌트가 2개 이상이여서, 최소비용 확장트리 찾기를 실패했습니다.");
        else
            this.showMinCostSpanningTree();

        AppView.outputLine("");
        AppView.outputLine("<<< 최소비용 확장 트리 찾기를 종료합니다 >>>");
    }

}
