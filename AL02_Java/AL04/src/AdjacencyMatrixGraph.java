public class AdjacencyMatrixGraph {

    private static final int EDGE_EXIST = 1;
    private static final int EDGE_NONE = 0;

    private int numberOfVertices;
    private int numberOfEdges;
    private int [][] adjacency;

    public AdjacencyMatrixGraph(int givenNumberOfVertices){
        setNumberOfVertices(givenNumberOfVertices);
        setNumberOfEdges(0);
        setAdjacency(new int [givenNumberOfVertices][givenNumberOfVertices]);

        for(int tailVertex = 0; tailVertex < numberOfVertices(); tailVertex++)
            for(int headVertex = 0; headVertex < numberOfVertices(); headVertex++)
                adjacency()[tailVertex][headVertex] = AdjacencyMatrixGraph.EDGE_NONE;
    }

    //getter setter start
    public int numberOfVertices(){
        return numberOfVertices;
    }
    public int numberOfEdges(){
        return numberOfEdges;
    }

    private void setNumberOfVertices(int newNumberOfVertices){
        this.numberOfVertices = newNumberOfVertices;
    }
    private void setNumberOfEdges(int newNumberOfEdges){
        this.numberOfEdges = newNumberOfEdges;
    }
    private int [][] adjacency(){
        return adjacency;
    }
    private void setAdjacency(int [][] newAdjacency){
        adjacency = newAdjacency;
    }
    //getter setter end

    public boolean vertexDoesExist(int aVertex){
        return (0 <= aVertex && aVertex < this.numberOfVertices());
    }

    public boolean edgeDoesExist(Edge anEdge){
        if(anEdge != null){
            int tailVertex = anEdge.tailVertex();
            int headVertex = anEdge.headVertex();
            if(this.vertexDoesExist(tailVertex) && this.vertexDoesExist(tailVertex))
                return (this.adjacencyOfEdgeDoesExist(tailVertex,headVertex));
        }
        return false;
    }

    private boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVertex){
        return (this.adjacency()[tailVertex][headVertex] != AdjacencyMatrixGraph.EDGE_NONE);
    }

    public boolean addEdge(Edge anEdge){
        if(anEdge != null){
            int tailVertex = anEdge.tailVertex();
            int headVertex = anEdge.headVertex();
            if(this.vertexDoesExist(tailVertex) && this.vertexDoesExist(headVertex)){
                if(!this.adjacencyOfEdgeDoesExist(tailVertex, headVertex)){
                    this.adjacency()[tailVertex][headVertex] = AdjacencyMatrixGraph.EDGE_EXIST;
                    this.adjacency()[headVertex][tailVertex] = AdjacencyMatrixGraph.EDGE_EXIST;
                    this.setNumberOfEdges(this.numberOfEdges()+1);
                    return true;
                }
            }
        }
        return false;
    }
}
