package EquvalenceClasses;
import app.AppView;
import graph.AdjacencyGraph;
import graph.Edge;
import list.List;
import list.Stack;
import list.LinkedList;
import list.Iterator;
import list.ArrayStack;

public class EquivalenceClasses<E extends Edge> {
    private static final boolean DEBUG_MODE = true;

    private static void showDebugMessage(String aMessage) {
        if (EquivalenceClasses.DEBUG_MODE) {
            AppView.outputDebugMessage(aMessage);
        }
    }

    private AdjacencyGraph<E> _graph;
    private boolean[] _found;
    private Stack<Integer> _sameClassMembers;
    private List<List<Integer>> _equivalenceClassList;

    private AdjacencyGraph<E> graph() {
        return this._graph;
    }
    private void setGraph(AdjacencyGraph<E> newGraph) {
        this._graph = newGraph;
    }
    private boolean[] found() {
        return this._found;
    }
    private void setFound(boolean[] newFound) {
        this._found = newFound;
    }
    private Stack<Integer> sameClassMembers() {
        return this._sameClassMembers;
    }
    private void setSameClassMembers(Stack<Integer> newSameClassMembers) { this._sameClassMembers = newSameClassMembers; }
    public List<List<Integer>> equivalenceClassList() {
        return this._equivalenceClassList;
    }
    private void setEquivalenceClassList(List<List<Integer>> newEquivalenceClassList) {
        this._equivalenceClassList = newEquivalenceClassList;
    }

    public EquivalenceClasses() {
        this.setEquivalenceClassList(null);
        this.setFound(null);
        this.setGraph(null);
        this.setSameClassMembers(null);
    }

    public boolean solve(AdjacencyGraph<E> aGraph) {
        this.setGraph(aGraph);
        if (this.graph().numberOfVertices() < 1) return false;
        this.setFound(new boolean[this.graph().numberOfVertices()]);
        this.setEquivalenceClassList(new LinkedList<List<Integer>>());
        this.setSameClassMembers(new ArrayStack<Integer>());
        EquivalenceClasses.showDebugMessage("\n");
        for (int vertex = 0; vertex < this.graph().numberOfVertices(); vertex++) {
            if (!this.found()[vertex]) {
                EquivalenceClasses.showDebugMessage("[Debug] 새로운 동등 클래스 {");
                List<Integer> newEquivalenceClass = new LinkedList<Integer>();
                this.equivalenceClassList().add(newEquivalenceClass);

                this.found()[vertex] = true;
                newEquivalenceClass.add(vertex);
                EquivalenceClasses.showDebugMessage(" " + vertex);
                this.sameClassMembers().push(vertex);
                while (!this.sameClassMembers().isEmpty()) {
                    int tailVertex = this.sameClassMembers().pop();
                    Iterator<E> iterator = this.graph().neighborIteratorOf(tailVertex);
                    while (iterator.hasNext()) {
                        E edge = iterator.next();
                        int headVertex = edge.headVertex();
                        if (!this.found()[headVertex]) {
                            this.found()[headVertex] = true;
                            newEquivalenceClass.add(headVertex);
                            EquivalenceClasses.showDebugMessage(", " + headVertex);
                            this.sameClassMembers().push(headVertex);
                        }
                    }
                }
                EquivalenceClasses.showDebugMessage(" } \n");
            }
        }
        return true;
    }
}