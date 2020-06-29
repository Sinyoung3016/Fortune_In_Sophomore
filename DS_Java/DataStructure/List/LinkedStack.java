package DataStructure.List;

public class LinkedStack<T> extends LinkedList<T> implements Stack<T>{
    //이때, headElement를 Order 0으로 두었을 때

    @Override
    public boolean push(T anElement){
        //anElement를 스택의 맨 위에 추가
        //return this.addToLast(anElement);
        Node<T> newNode = new Node<>(anElement, null);
        newNode.setNext(this.head());
        this.setHead(newNode);
        this.setSize(this.size()+1);
        return true;
    }
    @Override
    public T pop(){
        //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환하고 제거
        //return this.removeLast();
        Node<T> result = null;
        if(!isEmpty()){
            result = head();
            this.setHead(head().next());
            this.setSize(this.size()-1);
        }
        return result.element();
    }
    @Override
    public T peek(){
        //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환
        //return this.last();
        Node<T> result = null;
        if(!isEmpty()){
            result = head();
            this.setSize(this.size()-1);
        }
        return result.element();
    }
    //<STACK END>
}
