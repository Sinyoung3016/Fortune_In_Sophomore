public class Coloring {

    private AdjacencyMatrixGraph graph;
    private VertexColor[] vertexColors;
    private int startingVertex;
    private LinkedList<Edge> sameColorEdges;

    private int startingVertex() { return startingVertex; }
    private void setStartingVertex(int startingVertex) { this.startingVertex = startingVertex; }
    private AdjacencyMatrixGraph graph() { return graph; }
    private void setGraph(AdjacencyMatrixGraph graph) { this.graph = graph; }
    private VertexColor[] vertexColors() { return vertexColors; }
    private void setVertexColors(VertexColor[] vertexColors) { this.vertexColors = vertexColors; }

    public LinkedList<Edge> sameColorEdges() { return sameColorEdges; }
    private void setSameColorEdges(LinkedList<Edge> sameColorEdges) { this.sameColorEdges = sameColorEdges; }

    public VertexColor vertexColor(int aVertex) { return this.vertexColors()[aVertex]; }
    private void setVertexColor(int aVertex, VertexColor newColor) { this.vertexColors()[aVertex] = newColor; }

    public Coloring(AdjacencyMatrixGraph givenGraph) {
        this.setGraph(givenGraph);
        this.setVertexColors(new VertexColor[this.graph().numberOfVertices()]);
        for (int vertex = 0; vertex < this.graph().numberOfVertices(); vertex++) {
            this.setVertexColor(vertex, VertexColor.NONE);
        }
        this.setSameColorEdges(new LinkedList<Edge>());
        this.setStartingVertex(0);
    }

    public void runColoring() {
        this.pointColoringOfVertices();
        this.findSameColorEdges();
    }

    public void pointColoringOfVertices() {
        this.setVertexColor(this.startingVertex(), VertexColor.RED);

        CircularQueue<Integer> BFSQueue = new CircularQueue<>(this.graph().numberOfVertices());
        BFSQueue.add(this.startingVertex());

        while (!BFSQueue.isEmpty()) {
            int tailVertex = BFSQueue.remove();
            VertexColor headVertexColor = (this.vertexColor(tailVertex) == VertexColor.RED) ? VertexColor.BLUE : VertexColor.RED;

            for (int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++) {
                Edge visitingEdge = new Edge(tailVertex, headVertex);
                if (this.graph().edgeDoesExist(visitingEdge)) {
                    if (this.vertexColor(headVertex) == VertexColor.NONE) {
                        this.setVertexColor(headVertex, headVertexColor);
                        BFSQueue.add(headVertex);
                    }
                }
            }
        }
    }

    private void findSameColorEdges() {
        for (int tailVertex = 0; tailVertex < this.graph().numberOfVertices(); tailVertex++) {
            for (int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++) {
                Edge visitingEdge = new Edge(tailVertex, headVertex);
                if (this.graph().edgeDoesExist(visitingEdge)) {
                    if (this.vertexColor(tailVertex) == this.vertexColor(headVertex))
                        this.sameColorEdges().add(visitingEdge);
                }
            }
        }
    }

}
