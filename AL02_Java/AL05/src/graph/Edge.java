package graph;

public class Edge {

    private int tailVertex;
    private int headVertex;

    public Edge(int givenTailVertex, int givenHeadVertex) {
        setTailVertex(givenTailVertex);
        setHeadVertex(givenHeadVertex);
    }

    public void setTailVertex(int givenTailVertex) { this.tailVertex = givenTailVertex; }
    public int tailVertex() { return tailVertex; }
    public void setHeadVertex(int givenHeadVertex) { this.headVertex = givenHeadVertex; }
    public int headVertex() { return headVertex; }

}
