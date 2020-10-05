package graph;

public class UndirectedAdjacencyMatrixGraph<E extends Edge> implements Graph<E>{

    private static final int EDGE_EXIST = 1;
    private static final int EDGE_NONE = 0;

    private int numberOfVertices;
    private int numberOfEdges;
    private int [][] adjacency;

    protected UndirectedAdjacencyMatrixGraph(){}

    protected UndirectedAdjacencyMatrixGraph(int givenNumberOfVertices){
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int [givenNumberOfVertices][givenNumberOfVertices]);

        for(int tailVertex = 0; tailVertex < numberOfVertices(); tailVertex++)
            for(int headVertex = 0; headVertex < numberOfVertices(); headVertex++)
                this.setAdjacencyOdEdgeAsNone(tailVertex, headVertex);
    }

    //getter setter start
    public int numberOfVertices(){
        return numberOfVertices;
    }
    public int numberOfEdges(){
        return numberOfEdges;
    }
    protected void setNumberOfVertices(int newNumberOfVertices){
        this.numberOfVertices = newNumberOfVertices;
    }
    protected void setNumberOfEdges(int newNumberOfEdges){
        this.numberOfEdges = newNumberOfEdges;
    }

    protected int [][] adjacency(){
        return adjacency;
    }
    protected void setAdjacency(int [][] newAdjacency){
        adjacency = newAdjacency;
    }
    protected int adjacencyOfEdge(int tailVertex, int headVertex){ return this.adjacency()[tailVertex][headVertex]; }
    protected void setAdjacencyOfEdgeAs(int tailVertex, int headVertex, int anAdjacencyOfEdge){ this.adjacency()[tailVertex][headVertex] = anAdjacencyOfEdge; }
    private void setAdjacencyOdEdgeAsExist(int tailVertex, int headVertex){ this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_EXIST); }
    protected void setAdjacencyOdEdgeAsNone(int tailVertex, int headVertex){ this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_NONE); }
    //getter setter end

    public boolean edgeIsValid(int aTailVertex, int aHeadVertex) {
        return (this.vertexDoesExist(aTailVertex) && this.vertexDoesExist(aHeadVertex));
    }
    public boolean edgeIsValid(E anEdge) {
        if(anEdge != null) return (this.edgeIsValid(anEdge.tailVertex(), anEdge.headVertex()));
        return false;
    }
    public E Edge(int aTailVertex, int aHeadVertex) {
        if(this.edgeDoesExist(aTailVertex, aHeadVertex)) return (E) new Edge(aTailVertex, aHeadVertex);
        return null;
    }
    public boolean edgeDoesExist(int aTailVertex, int aHeadVertex) {
        if(this.edgeIsValid(aTailVertex, aHeadVertex)) return this.adjacencyOfEdgeDoesExist(aTailVertex, aHeadVertex);
        return false;
    }
    public boolean edgeDoesExist(Edge anEdge){
        if(anEdge != null) return this.edgeDoesExist(anEdge.tailVertex(), anEdge.headVertex());
        return false;
    }
    public boolean vertexDoesExist(int aVertex){
        return (0 <= aVertex && aVertex < this.numberOfVertices());
    }
    protected boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVertex){
        return (this.adjacency()[tailVertex][headVertex] != UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }

    public boolean addEdge(E anEdge){
        if(anEdge != null){
            if(this.edgeIsValid(anEdge) && !this.edgeDoesExist(anEdge)){
                int tailVertex = anEdge.tailVertex();
                int headVertex = anEdge.headVertex();
                this.setAdjacencyOdEdgeAsExist(tailVertex, headVertex);
                this.setAdjacencyOdEdgeAsExist(headVertex, tailVertex);
                this.setNumberOfEdges(this.numberOfEdges() + 1);
                return true;
            }
        }
        return false;
    }
}
