package graph;

public class UndirectedAdjacencyMatrixGraph<E extends Edge> extends DirectedAdjacencyMatrixGraph<E> {
    public UndirectedAdjacencyMatrixGraph(int givenNumberOfVertices){
        super(givenNumberOfVertices);
    }

    @Override
    public boolean addEdge(E anEdge){
        if(this.edgeIsValid(anEdge)&& (!this.edgeDoesExist(anEdge))){
            this.setAdjacencyOfEdgeAsExist(anEdge.tailVertex(),anEdge.headVertex());
            this.setAdjacencyOfEdgeAsExist(anEdge.headVertex(),anEdge.tailVertex());
            this.setNumberOfEdges(this.numberOfEdges()+1);
            return true;
        }
        return false;
    }
}
