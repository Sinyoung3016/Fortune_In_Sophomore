package DataStructure.List;

public class ArrayStack<T> extends ArrayList<T> implements Stack<T>{

    @Override
    public boolean push(T anElement) {
        //anElement를 스택의 맨 위에 추가
        //return this.addToLast(anElement);
        if(this.isFull())
            return false;
        else{
            this.list()[this.size()] = anElement;
            this.setSize(this.size() + 1);
            return true;
        }
    }

    @Override
    public T pop() {
        //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환하고 제거
        //return this.removeLast();
        T ReturnElement = null;
        if(!this.isEmpty()){
            ReturnElement = this.list()[this.size()-1];
            this.list()[this.size()-1] = null;
            this.setSize(this.size()-1);
        }
        return ReturnElement;
    }

    @Override
    public T peek() {
        //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환
        //return elementAt(this.size()-1)
        T ReturnElement = null;
        if(!this.isEmpty()){
            ReturnElement = this.list()[this.size()-1];
        }
        return ReturnElement;
    }

}
