package graph;

public class WeightedUndirectedAdjacencyMatrixGraph <WE extends WeightedEdge> extends UndirectedAdjacencyMatrixGraph<WE> implements SupplementForWeightedGraph<WE>{

    private static final int WEIGHT_EDGE_NONE = -1;

    public WeightedUndirectedAdjacencyMatrixGraph(int givenNumberOfVertices) {
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
        for(int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++)
            for(int headVertex = 0; headVertex < this.numberOfVertices(); headVertex++)
                this.setWeightOfEdgeAsNone(tailVertex, headVertex);
    }

    private void setWeightOfEdge(int aTailVertex, int aHeadVertex, int newWeight){
        this.adjacency()[aTailVertex][aHeadVertex] = newWeight;
    }
    private void setWeightOfEdgeAsNone(int aTailVertex, int aHeadVertex){
        this.setWeightOfEdge(aTailVertex, aHeadVertex, WeightedUndirectedAdjacencyMatrixGraph.WEIGHT_EDGE_NONE);
    }

    @Override
    public int weightOfEdge(WE anEdge) {
        if(anEdge != null) return this.weightOfEdge(anEdge.tailVertex(), anEdge.headVertex());
        return WeightedUndirectedAdjacencyMatrixGraph.WEIGHT_EDGE_NONE;
    }

    @Override
    public int weightOfEdge(int aTailVertex, int aHeadVertex) {
        if(this.edgeDoesExist(aTailVertex, aHeadVertex)) return this.adjacencyOfEdge(aTailVertex, aHeadVertex);
        return WeightedUndirectedAdjacencyMatrixGraph.WEIGHT_EDGE_NONE;
    }

    @Override
    protected boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVertex){
        return (this.adjacency()[tailVertex][headVertex] != WeightedUndirectedAdjacencyMatrixGraph.WEIGHT_EDGE_NONE);
    }

    public boolean addEdge(WE anEdge){
        if(anEdge != null){
            if(this.edgeIsValid(anEdge) && !this.edgeDoesExist(anEdge)){
                int tailVertex = anEdge.tailVertex();
                int headVertex = anEdge.headVertex();
                this.setWeightOfEdge(tailVertex, headVertex, anEdge.weight());
                this.setWeightOfEdge(headVertex, tailVertex, anEdge.weight());
                this.setNumberOfEdges(this.numberOfEdges() + 1);
                return true;
            }
        }
        return false;
    }
}
