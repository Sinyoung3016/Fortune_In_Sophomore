package graph;

public abstract class AdjacencyGraph <E extends Edge> implements Graph<E>{

    protected static final int EDGE_EXIST = 1;
    protected static final int EDGE_NONE = 0;

    private int _numberOfVertices;
    private int _numberOfEdges;

    public int numberOfVertices() { return _numberOfVertices; }
    protected void setNumberOfVertices(int _numberOfVertices) { this._numberOfVertices = _numberOfVertices; }
    public int numberOfEdges() { return _numberOfEdges; }
    protected void setNumberOfEdges(int _numberOfEdges) { this._numberOfEdges = _numberOfEdges; }

    public boolean edgeIsValid(int aTailVertex, int aHeadVertex) {
        return (this.vertexDoesExist(aTailVertex) && this.vertexDoesExist(aHeadVertex));
    }

    public boolean edgeIsValid(E anEdge) {
        if(anEdge != null) return (this.edgeIsValid(anEdge.tailVertex(), anEdge.headVertex()));
        return false;
    }

    public boolean vertexDoesExist(int aVertex){
        return (0 <= aVertex && aVertex < this.numberOfVertices());
    }


}
