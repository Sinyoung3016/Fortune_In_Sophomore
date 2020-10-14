package kruskal;

import app.AppView;
import graph.*;
import list.*;

public class MinCostSpanningTree {

    private WeightedUndirectedAdjacencyMatrixGraph<WeightedEdge> _graph;
    private MinPriorityQ<WeightedEdge> _minPriorityQ;
    private List<WeightedEdge> _spanningTreeEdgeList;

    public MinCostSpanningTree(){
        this.setGraph(null);
        this.setMinPriorityQ(null);
        this.setSpanningTreeEdgeList(null);
    }

    private WeightedUndirectedAdjacencyMatrixGraph<WeightedEdge> graph() { return _graph; }
    private void setGraph(WeightedUndirectedAdjacencyMatrixGraph<WeightedEdge> _graph) { this._graph = _graph; }
    private MinPriorityQ<WeightedEdge> minPriorityQ() { return _minPriorityQ; }
    private void setMinPriorityQ(MinPriorityQ<WeightedEdge> _minPriorityQ) { this._minPriorityQ = _minPriorityQ; }
    private List<WeightedEdge> spanningTreeEdgeList() { return _spanningTreeEdgeList; }
    private void setSpanningTreeEdgeList(List<WeightedEdge> _spanningTreeEdgeList) { this._spanningTreeEdgeList = _spanningTreeEdgeList; }

    private void initMinPriority(){
        this.setMinPriorityQ(new MinPriorityQ<WeightedEdge>(this.graph().numberOfEdges()));
        int numberOfVertices = this.graph().numberOfVertices();
        for(int tailVertex = 0; tailVertex < numberOfVertices; tailVertex++)
            for(int headVertex = tailVertex + 1; headVertex < numberOfVertices; headVertex++)
                if(this.graph().edgeDoesExist(tailVertex,headVertex)){
                    int weight = this.graph().weightOfEdge(tailVertex, headVertex);
                    WeightedEdge edge = new WeightedEdge(tailVertex, headVertex, weight);
                    this.minPriorityQ().add(edge);
                }
    }

    public List<WeightedEdge> solve(WeightedUndirectedAdjacencyMatrixGraph<WeightedEdge> aGraph){
        this.setGraph(aGraph);
        this.initMinPriority();
        this.setSpanningTreeEdgeList(new LinkedList<WeightedEdge>());

        PairwiseDisjointSets pairwiseDisjointSets = new PairwiseDisjointSets(this.graph().numberOfVertices());
        int maxNumberOfTreeEdges = this.graph().numberOfVertices() - 1;
        while((this.spanningTreeEdgeList().size() < maxNumberOfTreeEdges) && (!this.minPriorityQ().isEmpty())){
            WeightedEdge edge = this.minPriorityQ().removeMin();
            int setOfTailVertex = pairwiseDisjointSets.find(edge.tailVertex());
            int setOfHeadVertex = pairwiseDisjointSets.find(edge.headVertex());
            if(setOfTailVertex == setOfHeadVertex)
                AppView.outputLine("[Debug] Edge (" + edge.tailVertex() + ", " + edge.headVertex() + ")(" + edge.weight() + ")는 스패닝 트리에 사이클을 생성시키므로, 버립니다.");
            else{
                this.spanningTreeEdgeList().add(edge);
                pairwiseDisjointSets.union(setOfTailVertex, setOfHeadVertex);
                AppView.outputLine("[Debug] Edge (" + edge.tailVertex() + ", " + edge.headVertex() + ")(" + edge.weight() + ")는 스패닝 트리에 edge로 추가됩니다.");
            }
        }
        return (this.spanningTreeEdgeList().size() == maxNumberOfTreeEdges) ? this.spanningTreeEdgeList() :null;
    }

}
